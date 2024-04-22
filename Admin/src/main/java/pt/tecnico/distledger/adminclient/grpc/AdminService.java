package pt.tecnico.distledger.adminclient.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;

import pt.tecnico.distledger.namingserver.grpc.NamingServerService;
import pt.tecnico.distledger.namingserver.other.NamingServerUtilities;
import pt.ulisboa.tecnico.distledger.contract.DistLedgerCommonDefinitions.LedgerState;
import pt.ulisboa.tecnico.distledger.contract.DistLedgerCommonDefinitions.Operation;
import pt.ulisboa.tecnico.distledger.contract.DistLedgerCommonDefinitions.OperationType;

import pt.ulisboa.tecnico.distledger.contract.admin.AdminServiceGrpc;
import pt.ulisboa.tecnico.distledger.contract.admin.AdminDistLedger.*;

public class AdminService implements AutoCloseable {
    
    private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);
	private static void debug(String debugMessage) { if (DEBUG_FLAG) System.err.println("AdminService: " + debugMessage); }
    
    private final NamingServerService namingServerService;
    
    private ManagedChannel primaryServerChannel;
    private AdminServiceGrpc.AdminServiceBlockingStub primaryServerStub;

    private ManagedChannel secondaryServerChannel;
    private AdminServiceGrpc.AdminServiceBlockingStub secondaryServerStub;

    Scanner scanner = new Scanner(System.in);

    public AdminService(NamingServerService namingServerService) {
		this.namingServerService = namingServerService;
        swapServerOfType("A");
        swapServerOfType("B");
	}

    private void swapServerOfType(String qualifier) {
        String address = namingServerService.lookup(NamingServerUtilities.DISTLEDGER_SERVICE, qualifier).get(0);
        String host = NamingServerUtilities.parseServerHost(address);
        int port = NamingServerUtilities.parseServerPort(address);
        if (qualifier.equals("A")) {
            this.primaryServerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            this.primaryServerStub = AdminServiceGrpc.newBlockingStub(primaryServerChannel);
            debug("admin swapped it's primary server with address: " + address);
        } else {
            this.secondaryServerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            this.secondaryServerStub = AdminServiceGrpc.newBlockingStub(secondaryServerChannel);
            debug("admin swapped it's secondary server with address: " + address);
        }
    }

    private AdminServiceGrpc.AdminServiceBlockingStub selectStub(String qualifier) {
        if (qualifier.equals("A")) { 
            return primaryServerStub;
        } else {
            return secondaryServerStub;
        }
    }

    public void activate(String qualifier) {
        debug("activate server");
        try {
            selectStub(qualifier).activate(ActivateRequest.getDefaultInstance());
            System.out.println("OK\n");
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }

    public void deactivate(String qualifier) {
        debug("Deactivate server");
        try {
            selectStub(qualifier).deactivate(DeactivateRequest.getDefaultInstance());
            System.out.println("OK\n");
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }

    public void getLedgerState(String qualifier) {
        debug("Get LedgerState");
        try {
            getLedgerStateResponse response = selectStub(qualifier).getLedgerState(getLedgerStateRequest.getDefaultInstance());
            LedgerState ledgers = response.getLedgerState();
            System.out.print("OK\nledgerState {\n");
            for (int size = 0; size < ledgers.getLedgerCount(); size++) {
                Operation ledger = ledgers.getLedger(size);

                if (ledger.getType() == OperationType.OP_CREATE_ACCOUNT) {
                    System.out.print("  ledger {\n    type: OP_CREATE_ACCOUNT\n    userId: " + ledger.getUserId() + "\n  }\n");
                } else if (ledger.getType() == OperationType.OP_DELETE_ACCOUNT) {
                    System.out.print("  ledger {\n    type: OP_DELETE_ACCOUNT\n    userId: " + ledger.getUserId() + "\n  }\n");
                } else if (ledger.getType() == OperationType.OP_TRANSFER_TO) {
                    System.out.print("  ledger {\n    type: OP_TRANSFER_TO\n    userId: " + ledger.getUserId() + "\n    destUserId: " + ledger.getDestUserId() + "\n    amount: " + ledger.getAmount() + "\n  }\n");
                }
            }
            System.out.println("}\n");   
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }

    public void gossip(String qualifier) {
        debug("Gossip");
        try {
            selectStub(qualifier).gossip(GossipRequest.getDefaultInstance());
            System.out.println("OK\n");
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }

    @Override
	public final void close() {
		primaryServerChannel.shutdown();
        secondaryServerChannel.shutdown();
	}
}