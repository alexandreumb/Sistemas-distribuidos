package pt.tecnico.distledger.server.domain;

import pt.tecnico.distledger.server.domain.operation.CreateAccountOp;
import pt.tecnico.distledger.server.domain.operation.Operation;
import pt.tecnico.distledger.server.domain.operation.TransferOp;
import pt.tecnico.distledger.server.exception.AccountAlreadyExistsException;
import pt.tecnico.distledger.server.exception.CannotModifyBrokerException;
import pt.tecnico.distledger.server.exception.CannotTransferToSelfException;
import pt.tecnico.distledger.server.exception.InvalidArgumentsException;
import pt.tecnico.distledger.server.exception.NoSuchAccountException;
import pt.tecnico.distledger.server.exception.NoSuchDestinationAccountException;
import pt.tecnico.distledger.server.exception.NotEnoughCoinsException;
import pt.tecnico.distledger.server.exception.ServerNotActiveException;
import pt.tecnico.distledger.server.exception.ServerAlreadyActiveException;
import pt.tecnico.distledger.server.exception.ServerAlreadyDeactiveException;
import pt.tecnico.distledger.server.exception.BalanceNotUpdatedException;
import pt.tecnico.distledger.server.gossip.GossipUtilities;
import pt.tecnico.distledger.server.grpc.CrossServerService;
import pt.ulisboa.tecnico.distledger.contract.DistLedgerCommonDefinitions.OperationType;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class ServerState {
    
    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);
    private static void debug(String debugMessage) { if (DEBUG_FLAG) System.err.println("ServerState: " + debugMessage); }
    
    // attributes
    
    private boolean active;

    private final String qualifier;

    private List<Operation> ledger;

    private List<Operation> executedOperations;

    private final String broker;
    
    private Map<String, Integer> accountsBalance;

    private final CrossServerService crossServerService;

    private List<Integer> valueTS;
    
    private List<Integer> replicaTS;
    
    // constructors

    public ServerState(String qualifier, CrossServerService crossServerService) {
        this.active = true;
        this.qualifier = qualifier;
        this.ledger = new ArrayList<>();
        this.executedOperations = new ArrayList<>();
        this.broker = "broker";
        this.accountsBalance = new HashMap<>();
        this.accountsBalance.put(broker, 1000);
        this.crossServerService = crossServerService;
        this.valueTS = new ArrayList<>(Arrays.asList(0,0));
        this.replicaTS = new ArrayList<>(Arrays.asList(0,0));
        
    }

    // accessors
    
    public boolean isActive() { return active; }

    public String getQualifer() { return qualifier; }

    public void addOperation(Operation operation) { ledger.add(operation); }


    // user interface

    public synchronized List<Integer> balance(String account, List<Integer> prevTS) throws ServerNotActiveException, NoSuchAccountException, BalanceNotUpdatedException {
        List<Integer> result = new ArrayList<>();
        Integer balance = accountsBalance.get(account);
        if (!active) {
            throw new ServerNotActiveException();
        } else if (balance == null) {
            throw new NoSuchAccountException();
        }
        System.out.println(prevTS);
        System.out.println(valueTS);
        if (GossipUtilities.TSLessOrEqual(prevTS, valueTS)) {
            result.add(valueTS.get(0));
            result.add(valueTS.get(1));
        } else {
            throw new BalanceNotUpdatedException();
        }
        /*Quando tiveremos o gossip feito basta fazer notify all na função e faz release à thread */ 
        result.add(balance);
        debug("checked balance of account with username '" + account + "'");
        return result;
    }

    public synchronized List<Integer> createAccount(String account, List<Integer> prevTS) throws ServerNotActiveException,
                                                                                                 CannotModifyBrokerException,
                                                                                                 AccountAlreadyExistsException {
        if (!active) {
            throw new ServerNotActiveException();
        } else if (account.equals(broker)) {
            throw new CannotModifyBrokerException();
        } else if (accountsBalance.containsKey(account)) {
            throw new AccountAlreadyExistsException();
        }
        Operation operation = new CreateAccountOp(account, prevTS, valueTS);
        
        if (!cantCreateAccount((CreateAccountOp) operation, prevTS)) {
            executeAccountCreation((CreateAccountOp) operation, false);
        }

        return operation.getTS();
        
    }

    private synchronized void executeAccountCreation(CreateAccountOp operation,boolean recreate) {
        incrementReplicaTS();
        List<Integer> newTS = operationTS(operation.getPrevTS());
        operation.setTS(newTS);
        ledger.add(operation);
        if (operation.isStable(valueTS) && !executedOperations.contains(operation) && !recreate) {
            accountsBalance.put(operation.getAccount(), 0);
            GossipUtilities.mergeTS(valueTS, operation.getTS());
            executedOperations.add(operation);
            debug("created account with username '" + operation.getAccount() + "' | valueTS is now " + valueTS + " | replicaTS is now " + replicaTS);
           
        }
        else if (operation.isStable(valueTS) && !executedOperations.contains(operation) && recreate) {
            accountsBalance.put(operation.getAccount(), 0);
            GossipUtilities.mergeTS(valueTS, operation.getTS());
            executedOperations.add(operation);
            debug("created account with username '" + operation.getAccount() + "' | valueTS is now " + valueTS + " | replicaTS is now " + replicaTS);
           
        }
    }

    public synchronized List<Integer> transferTo (String fromAccount, String destAccount, int amount, List<Integer> prevTS) throws ServerNotActiveException, 
                                                                                                                                   NoSuchAccountException,
                                                                                                                                   NoSuchDestinationAccountException, 
                                                                                                                                   CannotTransferToSelfException, 
                                                                                                                                   InvalidArgumentsException, 
                                                                                                                                   NotEnoughCoinsException {
        Integer fromAccountBalance = accountsBalance.get(fromAccount);
        Integer destAccountBalance = accountsBalance.get(destAccount);
        if (!active) {
            throw new ServerNotActiveException();
        } else if (fromAccountBalance == null) {
            throw new NoSuchAccountException();
        } else if (destAccountBalance == null) {
            throw new NoSuchDestinationAccountException();
        } else if (fromAccount.equals(destAccount)) {
            throw new CannotTransferToSelfException();
        } else if (amount <= 0) {
            throw new InvalidArgumentsException();
        } else if (fromAccountBalance < amount) {
            throw new NotEnoughCoinsException();
        }
        Operation operation = new TransferOp(fromAccount, destAccount, amount, prevTS, valueTS);
        if (!cantTransferTo(prevTS)) {
            executeTransfer( (TransferOp) operation, false);
        }
        
        return operation.getTS();
    }

    private synchronized void executeTransfer(TransferOp operation, boolean recreate) {
        incrementReplicaTS();
        List<Integer> newTS = operationTS(operation.getPrevTS());
        operation.setTS(newTS);
        ledger.add(operation);
        if (operation.isStable(valueTS) && !executedOperations.contains(operation) && !recreate) {
            accountsBalance.put(operation.getAccount(), accountsBalance.get(operation.getAccount()) - operation.getAmount());
            accountsBalance.put(operation.getDestAccount(), accountsBalance.get(operation.getDestAccount()) + operation.getAmount());
            GossipUtilities.mergeTS(valueTS, operation.getTS());
            executedOperations.add(operation);
            debug("created account with username '" + operation.getAccount() + "' | valueTS is now " + valueTS + " | replicaTS is now " + replicaTS);
        }
        else if (operation.isStable(valueTS) && !executedOperations.contains(operation) && recreate) {
            accountsBalance.put(operation.getAccount(), accountsBalance.get(operation.getAccount()) - operation.getAmount());
            accountsBalance.put(operation.getDestAccount(), accountsBalance.get(operation.getDestAccount()) + operation.getAmount());
            GossipUtilities.mergeTS(operation.getTS(), replicaTS);
            GossipUtilities.mergeTS(valueTS, operation.getTS());
            executedOperations.add(operation);
            debug("created account with username '" + operation.getAccount() + "' | valueTS is now " + valueTS + " | replicaTS is now " + replicaTS);
        }
    }

    // admin interface

    public synchronized void activate() throws ServerAlreadyActiveException {
        if (active) { throw new ServerAlreadyActiveException(); }
        active = true; 
    }

    public synchronized void deactivate() throws ServerAlreadyDeactiveException {
        if (!active) { throw new ServerAlreadyDeactiveException(); }
        active = false; 
    }

    public synchronized List<Operation> getLedgerState() { return ledger; }

    public void gossip() { propagateState(); }

    // cross server interface

    public synchronized void propagateState() { crossServerService.propagateState(ledger, replicaTS); }

    // gossip

    public void update(List<Operation> newLedger, List<Integer> newReplicaTS) throws ServerNotActiveException {
        if(!active) { throw new ServerNotActiveException(); }
        mergeLedgerWith(newLedger);
        GossipUtilities.mergeTS(replicaTS, newReplicaTS);
        List<Operation> operationsToExecute = new ArrayList<>();
        do {
            operationsToExecute.clear();
            for (Operation operation : ledger) {
                if (!executedOperations.contains(operation) && operation.isStable(valueTS)) {
                    operationsToExecute.add(operation);
                }
            }
            Collections.sort(operationsToExecute);
            for (Operation operation : operationsToExecute) {
                if (operation instanceof CreateAccountOp) {
                    executeAccountCreation((CreateAccountOp) operation, true);
                } else if (operation instanceof TransferOp) {
                    executeTransfer((TransferOp) operation, true);
                }
            }
        } while (!operationsToExecute.isEmpty());
    }

    private void mergeLedgerWith(List<Operation> newLedger) {
        for (Operation operation : newLedger) {
            if (!GossipUtilities.TSLessOrEqual(operation.getTS(), replicaTS)) {
                ledger.add(operation);
            }
        }
    }

    private void incrementReplicaTS() { 
        replicaTS.set(GossipUtilities.TS_INDEX, replicaTS.get(GossipUtilities.TS_INDEX)+1);
    }

    private void deriveTS(Operation op) {
        List<Integer> newTS;
    }

    private int qualifierToIndex(String qualifier) {
        if (qualifier.equals("A")) {
            return 1;
        }
        else if (qualifier.equals("B")) {
            return 2;
        }
        return 0;
    }

    private boolean cantCreateAccount (CreateAccountOp createAccountOp, List<Integer> prevTS) {
        boolean exists = false;
        for (Operation operation : ledger ) {
            if (createAccountOp.getAccount().equals(operation.getAccount()) || operation.getPrevTS().equals(prevTS)) {
                exists = true;
            }
        }
        for (Operation operation : executedOperations) {
            if (createAccountOp.getAccount().equals(operation.getAccount()) || operation.getPrevTS().equals(prevTS)) {
                exists = true;
            }
        }
        return exists;
    }

    private boolean cantTransferTo (List<Integer> prevTs) {
        boolean exists = false;
        for (Operation operation : ledger ) {
            if (operation.getPrevTS().equals(prevTs)) {
                exists = true;
            }
        }
        for (Operation operation : executedOperations) {
            if (operation.getPrevTS().equals(prevTs)) {
                exists = true;
            }
        }
        return exists;
    }

    private List<Integer> operationTS (List<Integer> prevTS) {
        List<Integer> newTS = new ArrayList<>(Arrays.asList(prevTS.get(0),prevTS.get(1)));
        if (qualifier.equals("A") ) {
            newTS.set(0, replicaTS.get(0));
        }
        else if (qualifier.equals("B") ) {
            newTS.set(1,replicaTS.get(1));
        }
        return newTS;
    }
}