package pt.tecnico.distledger.userclient.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import pt.tecnico.distledger.namingserver.grpc.NamingServerService;
import pt.tecnico.distledger.namingserver.other.NamingServerUtilities;
import pt.tecnico.distledger.server.gossip.GossipUtilities;
import pt.ulisboa.tecnico.distledger.contract.user.UserServiceGrpc;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.BalanceRequest;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.BalanceResponse;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.CreateAccountRequest;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.CreateAccountResponse;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.TransferToRequest;
import pt.ulisboa.tecnico.distledger.contract.user.UserDistLedger.TransferToResponse;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class UserService implements AutoCloseable {

	private static final boolean DEBUG_FLAG = (System.getProperty("debug") != null);
	private static void debug(String debugMessage) { if (DEBUG_FLAG) System.err.println("UserService: " + debugMessage); }

    private final NamingServerService namingServerService;

    private ManagedChannel primaryServerChannel;
    private UserServiceGrpc.UserServiceBlockingStub primaryServerStub;

    private ManagedChannel secondaryServerChannel;
    private UserServiceGrpc.UserServiceBlockingStub secondaryServerStub;

    private List<Integer> prevTS = new ArrayList<>(Arrays.asList(0,0));

    public UserService(NamingServerService namingServerService) {
        this.namingServerService = namingServerService;
        swapServerOfType("A");
        swapServerOfType("B");
    }

    // services

    public void balance(String qualifier, String username) {
        debug("Request user balance");
        try {
            BalanceResponse response = selectStub(qualifier).balance(BalanceRequest.newBuilder()
                                                                                   .setUserId(username)
                                                                                   .addAllPrevTS(prevTS)                                            
                                                                                   .build());
            GossipUtilities.mergeTS(prevTS, response.getValueTSList());
            System.out.println("OK\n" + response.getValue() + "\n");
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }

    public void createAccount(String qualifier, String username) {
        debug("request for '" + username + "'s account creation on server '" + qualifier + "'");
        try {
            CreateAccountResponse response = selectStub(qualifier).createAccount(CreateAccountRequest.newBuilder()
                                                                                                     .setUserId(username)
                                                                                                     .addAllPrevTS(prevTS)
                                                                                                     .build());
            GossipUtilities.mergeTS(prevTS, response.getTSList());
            System.out.println("OK");
            debug("prevTS is now " + prevTS);
            System.out.println();
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }  
    }

    public void transferTo(String qualifier, String usernameFrom, String usernameDest, int amount) {
        debug("Transfer Request");
        try {
            TransferToResponse response = selectStub(qualifier).transferTo(TransferToRequest.newBuilder()
                                                                                            .setAccountFrom(usernameFrom)
                                                                                            .setAccountTo(usernameDest)
                                                                                            .setAmount(amount)
                                                                                            .addAllPrevTS(prevTS)
                                                                                            .build());
            GossipUtilities.mergeTS(prevTS, response.getTSList());
            System.out.println("OK");
            debug("prevTS is now " + prevTS);
            System.out.println();
        } catch (StatusRuntimeException e) {
            System.out.println(e.getStatus().getDescription());
        }
    }
    
    // auxiliary

    private void swapServerOfType(String qualifier) {
        String address = namingServerService.lookup(NamingServerUtilities.DISTLEDGER_SERVICE, qualifier).get(0);
        String host = NamingServerUtilities.parseServerHost(address);
        int port = NamingServerUtilities.parseServerPort(address);
        if (qualifier.equals("A")) {
            this.primaryServerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            this.primaryServerStub = UserServiceGrpc.newBlockingStub(primaryServerChannel);
            debug("user swapped it's primary server with address: " + address);
        } else {
            this.secondaryServerChannel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
            this.secondaryServerStub = UserServiceGrpc.newBlockingStub(secondaryServerChannel);
            debug("user swapped it's secondary server with address: " + address);
        }
    }
    
    private UserServiceGrpc.UserServiceBlockingStub selectStub(String qualifier) {
        if (qualifier.equals("A")) { 
            return primaryServerStub;
        } else {
            return secondaryServerStub;
        }
    }

    // other

    @Override
    public final void close() {
        primaryServerChannel.shutdown();
        secondaryServerChannel.shutdown();
    }
}
