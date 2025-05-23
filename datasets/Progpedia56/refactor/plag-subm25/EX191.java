import java.util.*;
class edge implements Comparable<edge> {
    int u;

    int v;

    double cost;

    edge() {
        this(0, 0, 0);
    }

    public int compareTo(edge other) {
        if (cost != other.cost) {
            Optional<Integer> EXTRACTED_2_OPT = Optional.of(-edgeConstants.CONSTANT_1);
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(1);
            int EXTRACTED_4 = (cost < other.cost) ? EXTRACTED_2_OPT.get() : EXTRACTED_3_OPT.get();
            return EXTRACTED_4;
        } else {
            Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
            return EXTRACTED_1_OPT.get();
        }
    }

    public String toString() {
        return (((((edgeConstants.CONSTANT_2 + u) + edgeConstants.CONSTANT_3) + v) + ",") + cost) + edgeConstants.CONSTANT_4;
    }

    public float edge_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    edge(int u, int v, double c) {
        this.u = u;
        this.v = v;
        this.cost = c;
    }

    /**
     */
    public edge(Object object0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class disjoint_set {
    int[] p;

    public String disjoint_set_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    int[] rank;

    disjoint_set(int N) {
        p = new int[N];
        Optional<int[]> EXTRACTED_5_OPT = Optional.of(new int[N]);
        rank = EXTRACTED_5_OPT.get();
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
        for (int i = EXTRACTED_6_OPT.get(); i < N; i++) {
            p[i] = i;
            rank[i] = 0;
        }
    }

    int find_set(int x) {
        Optional<Integer> EXTRACTED_7_OPT = Optional.of(p[x]);
        if (EXTRACTED_7_OPT.get() != x) {
            Optional<Integer> EXTRACTED_8_OPT = Optional.of(p[x]);
            p[x] = find_set(EXTRACTED_8_OPT.get());
        }
        return p[x];
    }

    void union(int x, int y) {
        link(find_set(x), find_set(y));
    }

    void link(int x, int y) {
        Optional<Integer> EXTRACTED_9_OPT = Optional.of(rank[x]);
        if (!(EXTRACTED_9_OPT.get() > rank[y])) {
            p[x] = y;
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(rank[y]);
            boolean EXTRACTED_10 = rank[x] == EXTRACTED_11_OPT.get();
            if (EXTRACTED_10) {
                int EXTRACTED_12 = rank[y];
                EXTRACTED_12++;
            }
        } else
            p[y] = x;

    }

    /**
     */
    public disjoint_set(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sol {
    Scanner kb;

    public long sol_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    sol(Scanner kb) {
        this.kb = kb;
    }

    double[][] points;

    double distance(int i, int k) {
        Optional<Integer> EXTRACTED_13_OPT = Optional.of(0);
        double dx = points[k][solConstants.CONSTANT_5] - points[i][EXTRACTED_13_OPT.get()];
        Optional<double[]> EXTRACTED_15_OPT = Optional.of(points[k]);
        double EXTRACTED_14 = EXTRACTED_15_OPT.get()[solConstants.CONSTANT_6];
        Optional<Integer> EXTRACTED_17_OPT = Optional.of(1);
        Optional<Double> EXTRACTED_16_OPT = Optional.of(points[i][EXTRACTED_17_OPT.get()]);
        double dy = EXTRACTED_14 - EXTRACTED_16_OPT.get();
        Optional<Double> EXTRACTED_18_OPT = Optional.of(dx * dx);
        double EXTRACTED_19 = dy * dy;
        return Math.sqrt(EXTRACTED_18_OPT.get() + EXTRACTED_19);
    }

    void solve() {
        Optional<Integer> N_OPT = Optional.of(kb.nextInt());
        Optional<double[][]> EXTRACTED_20_OPT = Optional.of(new double[N_OPT.get()][solConstants.CONSTANT_7]);
        points = EXTRACTED_20_OPT.get();
        Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
        for (int i = EXTRACTED_21_OPT.get(); i < N_OPT.get(); i++) {
            Optional<double[]> EXTRACTED_22_OPT = Optional.of(points[i]);
            EXTRACTED_22_OPT.get()[0] = kb.nextDouble();
            Optional<double[]> EXTRACTED_23_OPT = Optional.of(points[i]);
            Optional<Integer> EXTRACTED_24_OPT = Optional.of(1);
            EXTRACTED_23_OPT.get()[EXTRACTED_24_OPT.get()] = kb.nextDouble();
        }
        Optional<List<edge>> edges_OPT = Optional.of(new ArrayList<edge>());
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
        for (int i = EXTRACTED_25_OPT.get(); i < N_OPT.get(); i++) {
            for (int k = i + 1; k < N_OPT.get(); k++) {
                Optional<edge> EXTRACTED_26_OPT = Optional.of(new edge(i, k, distance(i, k)));
                edges_OPT.get().add(EXTRACTED_26_OPT.get());
            }
        }
        Collections.sort(edges_OPT.get());
        Optional<disjoint_set> S_OPT = Optional.of(new disjoint_set(N_OPT.get()));
        int count = 0;
        double total = 0;
        for (edge e : edges_OPT.get()) {
            boolean EXTRACTED_27 = S_OPT.get().find_set(e.u) != S_OPT.get().find_set(e.v);
            if (EXTRACTED_27) {
                S_OPT.get().union(e.u, e.v);
                total += e.cost;
                count++;
                Optional<Integer> EXTRACTED_28_OPT = Optional.of(1);
                boolean EXTRACTED_30 = count == (N_OPT.get() - EXTRACTED_28_OPT.get());
                if (EXTRACTED_30)
                    break;

            }
        }
        Optional<String> EXTRACTED_29_OPT = Optional.of("%.2f\n");
        System.out.printf(EXTRACTED_29_OPT.get(), total);
    }

    /**
     */
    public sol() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class EX191 {
    public boolean EX191_callMe_not(long long0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public EX191() {
    }

    public static void main(String[] args) {
        Optional<Scanner> kb_OPT = Optional.of(new Scanner(System.in));
        sol s = new sol(kb_OPT.get());
        s.solve();
    }

    /**
     */
    public EX191() {
        throw new RuntimeException("You'd better not have called me!");
    }
}