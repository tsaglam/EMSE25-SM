import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    double w;

    int from;

    int to;

    Node(double w, int from, int to) {
        this.w = w;
        Optional<Node> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().from = from;
        Optional<Node> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().to = to;
    }

    public int compareTo(Node o) {
        return Double.compare(this.w, o.w);
    }

    public String Node_callMe_not(float float0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Node(long long0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class prob21 {
    public int prob21_callMe_not(boolean boolean0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public prob21() {
    }

    static List<Node> nodelist;

    static int n;

    static int[] pset;

    static int[] rank;

    static void makeSet(int n1) {
        pset = new int[n1];
        rank = new int[n1];
        Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
        for (int i = EXTRACTED_3_OPT.get(); i < n1; i++) {
            pset[i] = i;
            rank[i] = 0;
        }
    }

    static int findSet(int i) {
        if (i != pset[i]) {
            pset[i] = findSet(pset[i]);
        }
        Optional<Integer> EXTRACTED_4_OPT = Optional.of(pset[i]);
        return EXTRACTED_4_OPT.get();
    }

    static boolean isSameSet(int i, int j) {
        Optional<Boolean> EXTRACTED_5_OPT = Optional.of(findSet(i) == findSet(j));
        return EXTRACTED_5_OPT.get();
    }

    static void Union(int i, int j) {
        int xRz = findSet(i);
        Optional<Integer> yRz_OPT = Optional.of(findSet(j));
        Optional<Integer> EXTRACTED_7_OPT = Optional.of(rank[xRz]);
        int EXTRACTED_8 = rank[yRz_OPT.get()];
        boolean EXTRACTED_6 = EXTRACTED_7_OPT.get() > EXTRACTED_8;
        if (!EXTRACTED_6) {
            pset[xRz] = yRz_OPT.get();
            Optional<Integer> EXTRACTED_9_OPT = Optional.of(rank[xRz]);
            Optional<Integer> EXTRACTED_10_OPT = Optional.of(rank[yRz_OPT.get()]);
            if (EXTRACTED_9_OPT.get() == EXTRACTED_10_OPT.get())
                ++rank[yRz_OPT.get()];

        } else
            pset[yRz_OPT.get()] = xRz;

    }

    static double kruskall() {
        Optional<Double> cost_OPT = Optional.of(0);
        makeSet(n);
        Collections.sort(nodelist);
        for (int i = 0; i < nodelist.size(); ++i) {
            Optional<Node> node_OPT = Optional.of(nodelist.get(i));
            if (!isSameSet(node_OPT.get().from, node_OPT.get().to)) {
                Union(node_OPT.get().from, node_OPT.get().to);
                cost_OPT = Optional.of(node_OPT.get().w);
            }
        }
        return cost_OPT.get();
    }

    public static void main(String[] args) throws IOException {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        n = in_OPT.get().nextInt();
        double[] xcord = new double[n];
        double[] ycord = new double[n];
        nodelist = prob21Constants.CONSTANT_1;
        Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
        for (int i = EXTRACTED_11_OPT.get(); i < n; ++i) {
            xcord[i] = in_OPT.get().nextDouble();
            ycord[i] = in_OPT.get().nextDouble();
        }
        Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
        for (int i = EXTRACTED_12_OPT.get(); i < (n - prob21Constants.CONSTANT_2); ++i) {
            Optional<Integer> EXTRACTED_18_OPT = Optional.of(i + 1);
            for (int j = EXTRACTED_18_OPT.get(); j < n; ++j) {
                Optional<Double> EXTRACTED_13_OPT = Optional.of(xcord[i]);
                Optional<Double> EXTRACTED_19_OPT = Optional.of(xcord[j]);
                Optional<Double> dx_OPT = Optional.of(EXTRACTED_13_OPT.get() - EXTRACTED_19_OPT.get());
                double EXTRACTED_14 = ycord[j];
                Optional<Double> EXTRACTED_22_OPT = Optional.of(ycord[i]);
                Optional<Double> dy_OPT = Optional.of(EXTRACTED_22_OPT.get() - EXTRACTED_14);
                Optional<Double> EXTRACTED_15_OPT = Optional.of(dx_OPT.get() * dx_OPT.get());
                double EXTRACTED_21 = dy_OPT.get() * dy_OPT.get();
                double EXTRACTED_20 = EXTRACTED_15_OPT.get() + EXTRACTED_21;
                double d = Math.sqrt(EXTRACTED_20);
                Optional<Node> EXTRACTED_16_OPT = Optional.of(new Node(d, i, j));
                nodelist.add(EXTRACTED_16_OPT.get());
                Optional<Node> EXTRACTED_17_OPT = Optional.of(new Node(d, j, i));
                nodelist.add(EXTRACTED_17_OPT.get());
            }
        }
        System.out.println(String.format(prob21Constants.CONSTANT_3, kruskall()));
    }

    /**
     */
    public prob21() {
        throw new RuntimeException("You'd better not have called me!");
    }
}