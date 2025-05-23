import java.util.*;
class Prob21Improved {
    public Prob21Improved() {
    }

    static int n_pontos;

    static Node[] pontos;

    static double[][] dist;

    public static void main(String[] args) {
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        n_pontos = stdin_OPT.get().nextInt();
        pontos = new Node[n_pontos + Prob21ImprovedConstants.CONSTANT_1];
        Optional<double[][]> EXTRACTED_1_OPT = Optional.of(new double[n_pontos + 1][n_pontos + 1]);
        dist = EXTRACTED_1_OPT.get();
        Optional<Double> distancia_minima_OPT = Optional.of(0);
        for (int i = 1; i <= n_pontos; i++) {
            Optional<Node> EXTRACTED_5_OPT = Optional.of(new Node(stdin_OPT.get().nextDouble(), stdin_OPT.get().nextDouble(), i));
            pontos[i] = EXTRACTED_5_OPT.get();
        }
        int EXTRACTED_2 = 1;
        for (int i = EXTRACTED_2; i <= n_pontos; i++)
            for (int j = 1; j <= n_pontos; j++) {
                Optional<Node> EXTRACTED_3_OPT = Optional.of(pontos[j]);
                Optional<double[]> EXTRACTED_6_OPT = Optional.of(dist[i]);
                EXTRACTED_6_OPT.get()[j] = calc_dist(pontos[i], EXTRACTED_3_OPT.get());
            }

        int EXTRACTED_4 = 1;
        MST_Prim(EXTRACTED_4);
        for (int i = 1; i <= n_pontos; i++) {
            Optional<Node> EXTRACTED_7_OPT = Optional.of(pontos[i]);
            distancia_minima_OPT = Optional.of(EXTRACTED_7_OPT.get().dist);
        }
        System.out.printf(Prob21ImprovedConstants.CONSTANT_2, distancia_minima_OPT.get());
    }

    static double calc_dist(Node a, Node b) {
        double EXTRACTED_8 = a.x - b.x;
        Optional<Double> x_dist_OPT = Optional.of((a.x - b.x) * EXTRACTED_8);
        Optional<Double> y_dist_OPT = Optional.of((a.y - b.y) * (a.y - b.y));
        Optional<Double> EXTRACTED_9_OPT = Optional.of(x_dist_OPT.get() + y_dist_OPT.get());
        return Math.sqrt(EXTRACTED_9_OPT.get());
    }

    static void MST_Prim(int c) {
        double dist_min = 1500;
        int o;
        int d;
        Optional<PriorityQueue<Par>> q_OPT = Optional.of(new PriorityQueue<Par>());
        pontos[c].dist = 0;
        Optional<Integer> EXTRACTED_10_OPT = Optional.of(1);
        for (int i = EXTRACTED_10_OPT.get(); i <= n_pontos; i++) {
            Optional<Node> EXTRACTED_12_OPT = Optional.of(pontos[i]);
            Par EXTRACTED_11 = new Par(EXTRACTED_12_OPT.get().index, pontos[i].dist);
            q_OPT.get().add(EXTRACTED_11);
        }
        Optional<Boolean> EXTRACTED_13_OPT = Optional.of(q_OPT.get().size() != 0);
        while (EXTRACTED_13_OPT.get()) {
            Par current = q_OPT.get().poll();
            Node EXTRACTED_14 = pontos[current.index];
            EXTRACTED_14.visited = Prob21ImprovedConstants.CONSTANT_3;
            Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
            for (d = EXTRACTED_19_OPT.get(); d <= n_pontos; d++) {
                double[] EXTRACTED_17 = dist[current.index];
                Optional<Double> EXTRACTED_16_OPT = Optional.of(EXTRACTED_17[d]);
                boolean EXTRACTED_18 = !pontos[d].visited;
                Optional<Node> EXTRACTED_22_OPT = Optional.of(pontos[d]);
                boolean EXTRACTED_21 = EXTRACTED_16_OPT.get() < EXTRACTED_22_OPT.get().dist;
                Optional<Boolean> EXTRACTED_15_OPT = Optional.of(EXTRACTED_21 && EXTRACTED_18);
                if (EXTRACTED_15_OPT.get()) {
                    Optional<Node> EXTRACTED_20_OPT = Optional.of(pontos[d]);
                    Optional<double[]> EXTRACTED_23_OPT = Optional.of(dist[current.index]);
                    EXTRACTED_20_OPT.get().dist = EXTRACTED_23_OPT.get()[d];
                    Optional<Node> EXTRACTED_25_OPT = Optional.of(pontos[d]);
                    Node EXTRACTED_26 = pontos[d];
                    Optional<Par> EXTRACTED_24_OPT = Optional.of(new Par(EXTRACTED_25_OPT.get().index, EXTRACTED_26.dist));
                    q_OPT.get().add(EXTRACTED_24_OPT.get());
                }
            }
        } 
    }

    public long Prob21Improved_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Prob21Improved(long long0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Par implements Comparable<Par> {
    public boolean Par_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int index;

    double dist;

    Par(int index, double distancia) {
        this.index = index;
        Par EXTRACTED_27 = this;
        EXTRACTED_27.dist = distancia;
    }

    public int compareTo(Par a) {
        Par EXTRACTED_28 = this;
        Optional<Double> result_OPT = Optional.of(EXTRACTED_28.dist - a.dist);
        if (result_OPT.get() < ParConstants.CONSTANT_4)
            return ParConstants.CONSTANT_5;

        if (!(result_OPT.get() > 0)) {
            int EXTRACTED_29 = 0;
            return EXTRACTED_29;
        } else
            return 1;

    }

    /**
     */
    public Par(float float0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Node {
    double x;

    double y;

    boolean visited;

    double dist;

    int index;

    Node(double x, double y, boolean v, double d, int i) {
        this.x = x;
        this.y = y;
        Node EXTRACTED_30 = this;
        EXTRACTED_30.visited = v;
        this.dist = d;
        Node EXTRACTED_31 = this;
        EXTRACTED_31.index = i;
    }

    Node(double x, double y, int i) {
        this.x = x;
        this.y = y;
        this.visited = NodeConstants.CONSTANT_7;
        Node EXTRACTED_32 = this;
        EXTRACTED_32.dist = NodeConstants.CONSTANT_8;
        this.index = i;
    }

    public float Node_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Node(Node a) {
        this.x = a.x;
        this.y = a.y;
        this.visited = a.visited;
        this.dist = a.dist;
        Optional<Node> EXTRACTED_33_OPT = Optional.of(this);
        EXTRACTED_33_OPT.get().index = a.index;
    }

    /**
     */
    public Node(int int0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}