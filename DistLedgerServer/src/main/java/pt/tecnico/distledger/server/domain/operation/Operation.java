package pt.tecnico.distledger.server.domain.operation;

import pt.tecnico.distledger.server.gossip.GossipUtilities;

import java.util.List;
import java.util.ArrayList;

public class Operation implements Comparable<Operation> {
    
    private String account;
    private List<Integer> TS;
    private List<Integer> prevTS;

    public Operation(String account, List<Integer> prevTS, List<Integer> TS) {
        this.account = account;
        this.prevTS = new ArrayList<>(prevTS);
        this.TS = new ArrayList<>(TS);
        
    }

    public boolean isStable(List<Integer> valueTS) { 
        return GossipUtilities.TSLessOrEqual(prevTS, valueTS);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Integer> getPrevTS() {
        return prevTS;
    }

    public void setPrevTS(List<Integer> prevTS) {
        this.prevTS = prevTS;
    }

    public List<Integer> getTS() {
        return TS;
    }

    public void setTS(List<Integer> tS) {
        this.TS = tS;
    }

    @Override
    public String toString() {
        return "Operation [account=" + account + ", TS=" + TS + ", prevTS=" + prevTS + "]";
    }


    public int compareTo(Operation other) {
        if (GossipUtilities.TSEqual(this.getPrevTS(), other.getPrevTS())) {
            return 0;
        } else if (GossipUtilities.TSLess(other.getPrevTS(), this.getPrevTS())) {
            return 1;
        } else {
            return -1;
        }
    }
}

