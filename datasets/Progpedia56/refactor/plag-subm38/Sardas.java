import java.util.*;
class Node {
    public LinkedList<Integer> adj;

    public double distance;

    public double y;

    public double x;

    public double Node_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int pai;

    Node(double x, double y) {
        adj = NodeConstants.CONSTANT_1;
        distance = NodeConstants.CONSTANT_2;
        Node EXTRACTED_1 = this;
        EXTRACTED_1.x = x;
        Optional<Node> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().y = y;
        pai = NodeConstants.CONSTANT_3;
    }

    /**
     */
    public Node() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Graph {
    int n;

    Node[] nodes;

    public float Graph_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Graph(int n) {
        Optional<Graph> EXTRACTED_3_OPT = Optional.of(this);
        EXTRACTED_3_OPT.get().n = n;
        nodes = new Node[n + GraphConstants.CONSTANT_4];
    }

    public double peso(int x, int y) {
        Optional<Double> EXTRACTED_5_OPT = Optional.of(nodes[x].x - nodes[y].x);
        Optional<Node> EXTRACTED_6_OPT = Optional.of(nodes[y]);
        Node EXTRACTED_8 = nodes[x];
        Node EXTRACTED_9 = nodes[y];
        double EXTRACTED_7 = EXTRACTED_8.y - EXTRACTED_9.y;
        Optional<Node> EXTRACTED_10_OPT = Optional.of(nodes[x]);
        Optional<Double> EXTRACTED_4_OPT = Optional.of((EXTRACTED_5_OPT.get() * (nodes[x].x - EXTRACTED_6_OPT.get().x)) + (EXTRACTED_7 * (EXTRACTED_10_OPT.get().y - nodes[y].y)));
        Optional<Double> p_OPT = Optional.of(Math.sqrt(EXTRACTED_4_OPT.get()));
        return p_OPT.get();
    }

    public void Prim(int v) {
        Optional<LinkedList<Integer>> q_OPT = Optional.of(new LinkedList<Integer>());
        for (int i = 1; i <= n; i++) {
            Node EXTRACTED_11 = nodes[i];
            EXTRACTED_11.distance = Double.MAX_VALUE;
            q_OPT.get().add(i);
        }
        Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
        nodes[v].distance = EXTRACTED_12_OPT.get();
        double min = Double.MAX_VALUE;
        int u = 0;
        Optional<Integer> menor_OPT = Optional.of(0);
        while (q_OPT.get().size() > 0) {
            min = Double.MAX_VALUE;
            Optional<Integer> EXTRACTED_13_OPT = Optional.of(1);
            for (int i = EXTRACTED_13_OPT.get(); i <= n; i++) {
                Optional<Node> EXTRACTED_15_OPT = Optional.of(nodes[i]);
                boolean EXTRACTED_21 = EXTRACTED_15_OPT.get().distance < min;
                Optional<Boolean> EXTRACTED_14_OPT = Optional.of(q_OPT.get().contains(i) && EXTRACTED_21);
                if (EXTRACTED_14_OPT.get()) {
                    Node EXTRACTED_16 = nodes[i];
                    min = EXTRACTED_16.distance;
                    menor_OPT = Optional.of(i);
                }
            }
            q_OPT.get().removeFirstOccurrence(menor_OPT.get());
            u = menor_OPT.get();
            Optional<Node> EXTRACTED_22_OPT = Optional.of(nodes[u]);
            for (int w : EXTRACTED_22_OPT.get().adj) {
                double p = peso(u, w);
                Optional<Node> EXTRACTED_19_OPT = Optional.of(nodes[w]);
                Optional<Boolean> EXTRACTED_18_OPT = Optional.of(p < EXTRACTED_19_OPT.get().distance);
                Optional<Boolean> EXTRACTED_17_OPT = Optional.of(q_OPT.get().contains(w) && EXTRACTED_18_OPT.get());
                if (EXTRACTED_17_OPT.get()) {
                    Optional<Node> EXTRACTED_23_OPT = Optional.of(nodes[w]);
                    EXTRACTED_23_OPT.get().pai = u;
                    Optional<Node> EXTRACTED_20_OPT = Optional.of(nodes[w]);
                    EXTRACTED_20_OPT.get().distance = p;
                }
            }
        } 
    }

    /**
     */
    public Graph(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sardas {
    public Sardas() {
    }

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        Optional<Integer> n_OPT = Optional.of(in_OPT.get().nextInt());
        Optional<Graph> g_OPT = Optional.of(new Graph(n_OPT.get()));
        Optional<Integer> EXTRACTED_24_OPT = Optional.of(1);
        for (int i = EXTRACTED_24_OPT.get(); i <= n_OPT.get(); i++) {
            Optional<Node> EXTRACTED_25_OPT = Optional.of(new Node(in_OPT.get().nextDouble(), in_OPT.get().nextDouble()));
            g_OPT.get().nodes[i] = EXTRACTED_25_OPT.get();
        }
        int EXTRACTED_26 = 1;
        for (int i = EXTRACTED_26; i <= n_OPT.get(); i++)
            for (int j = 1; j <= n_OPT.get(); j++) {
                Optional<Node> EXTRACTED_27_OPT = Optional.of(g_OPT.get().nodes[i]);
                EXTRACTED_27_OPT.get().adj.add(j);
            }

        Optional<Integer> EXTRACTED_28_OPT = Optional.of(1);
        g_OPT.get().Prim(EXTRACTED_28_OPT.get());
        Optional<Double> t_OPT = Optional.of(0.0);
        for (int i = 1; i <= n_OPT.get(); i++) {
            Node EXTRACTED_29 = g_OPT.get().nodes[i];
            t_OPT = Optional.of(EXTRACTED_29.distance);
        }
        System.out.printf(SardasConstants.CONSTANT_5, t_OPT.get());
    }

    public double Sardas_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Sardas() {
        throw new RuntimeException("You'd better not have called me!");
    }
}