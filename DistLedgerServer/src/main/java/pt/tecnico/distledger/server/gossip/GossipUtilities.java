package pt.tecnico.distledger.server.gossip;

import java.util.List;

public class GossipUtilities {

    public static final int REPLICAS_COUNT = 2;
    
    public static int TS_INDEX;
    private static boolean initialized_TS_INDEX = false;
    public static void set_TS_INDEX(String qualifier) {
        if (!initialized_TS_INDEX) {
            if (qualifier.equals("A")) {
                TS_INDEX = 0;
            } else if (qualifier.equals("B")) {
                TS_INDEX = 1;
            } else {
                TS_INDEX = -1;
            }
            initialized_TS_INDEX = true;
        }
    }

    // TS merging

    public static void mergeTS(List<Integer> targetTS, List<Integer> sourceTS) {
        for (int i = 0; i < 2; i++) {
            targetTS.set(i, Integer.max(targetTS.get(i), sourceTS.get(i)));
        }
    }

    // TS comparison

    public static boolean TSLess(List<Integer> ts1, List<Integer> ts2) {
        boolean atLeastOneLesserElement = false;
        if (!TSEqual(ts1, ts2)) {
        for (int i = 0; i < REPLICAS_COUNT; i++) {
            if (ts1.get(i) < ts2.get(i)) {
                atLeastOneLesserElement = true;
                }
            }
        }
        return atLeastOneLesserElement;
    }

    public static boolean TSEqual(List<Integer> ts1, List<Integer> ts2) {
        for (int i = 0; i < REPLICAS_COUNT; i++) {
            if (ts1.get(i) != ts2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean TSLessOrEqual(List<Integer> ts1, List<Integer> ts2) {
        return TSLess(ts1, ts2) || TSEqual(ts1, ts2);
    }
}
