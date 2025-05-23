import java.util.*;
class Aresta {
    int node;

    double weight;

    Aresta(int n, double w) {
        Aresta EXTRACTED_1 = this;
        EXTRACTED_1.node = n;
        this.weight = w;
    }

    public int Aresta_callMe_not(double double0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Aresta(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Node {
    public LinkedList<Aresta> adj;

    public boolean visited;

    public double x;

    public double y;

    public double dist;

    public boolean Node_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Node() {
        adj = NodeConstants.CONSTANT_1;
        visited = false;
        dist = NodeConstants.CONSTANT_2;
    }

    /**
     */
    public Node(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Graph {
    int n;

    Node[] nodes;

    Graph(int n) {
        Optional<Graph> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().n = n;
        Optional<Graph> EXTRACTED_3_OPT = Optional.of(this);
        Optional<Integer> EXTRACTED_5_OPT = Optional.of(n + GraphConstants.CONSTANT_3);
        Node[] EXTRACTED_4 = new Node[EXTRACTED_5_OPT.get()];
        EXTRACTED_3_OPT.get().nodes = EXTRACTED_4;
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(1);
        for (int i = EXTRACTED_6_OPT.get(); i <= n; i++) {
            Node EXTRACTED_7 = new Node();
            nodes[i] = EXTRACTED_7;
        }
    }

    public double distance(Node a, Node b) {
        Optional<Double> EXTRACTED_8_OPT = Optional.of(a.x - b.x);
        return Math.sqrt(Math.pow(EXTRACTED_8_OPT.get(), GraphConstants.CONSTANT_4) + Math.pow(a.y - b.y, 2));
    }

    public void addNode(int i, double a, double b) {
        Node EXTRACTED_9 = this.nodes[i];
        EXTRACTED_9.x = a;
        this.nodes[i].y = b;
        this.nodes[i].visited = false;
    }

    public double Graph_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public void Prim(int no) {
        Optional<Node> EXTRACTED_10_OPT = Optional.of(nodes[no]);
        EXTRACTED_10_OPT.get().dist = GraphConstants.CONSTANT_5;
        Optional<Double> cost_OPT = Optional.of(0);
        for (int i = 1; i <= n; i++) {
            double min = 1500;
            Optional<Integer> min_node_OPT = Optional.of(1500);
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(1);
            for (int j = EXTRACTED_16_OPT.get(); j <= n; j++) {
                Optional<Node> EXTRACTED_11_OPT = Optional.of(nodes[j]);
                boolean EXTRACTED_12 = false;
                Node EXTRACTED_23 = nodes[j];
                Optional<Boolean> EXTRACTED_18_OPT = Optional.of(EXTRACTED_23.dist < min);
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(EXTRACTED_11_OPT.get().visited == EXTRACTED_12);
                boolean EXTRACTED_17 = EXTRACTED_22_OPT.get() && EXTRACTED_18_OPT.get();
                if (EXTRACTED_17) {
                    Node EXTRACTED_13 = nodes[j];
                    min = EXTRACTED_13.dist;
                    min_node_OPT = Optional.of(j);
                }
            }
            cost_OPT = Optional.of(min);
            Optional<Node> EXTRACTED_14_OPT = Optional.of(nodes[min_node_OPT.get()]);
            Optional<Boolean> EXTRACTED_19_OPT = Optional.of(true);
            EXTRACTED_14_OPT.get().visited = EXTRACTED_19_OPT.get();
            for (Aresta a : nodes[min_node_OPT.get()].adj) {
                Optional<Boolean> EXTRACTED_15_OPT = Optional.of(!nodes[a.node].visited);
                Optional<Node> EXTRACTED_21_OPT = Optional.of(nodes[a.node]);
                Optional<Boolean> EXTRACTED_24_OPT = Optional.of(a.weight < EXTRACTED_21_OPT.get().dist);
                boolean EXTRACTED_20 = EXTRACTED_15_OPT.get() && EXTRACTED_24_OPT.get();
                if (EXTRACTED_20) {
                    Node EXTRACTED_25 = nodes[a.node];
                    EXTRACTED_25.dist = a.weight;
                }
            }
        }
        System.out.printf(GraphConstants.CONSTANT_6, cost_OPT.get());
    }

    /**
     */
    public Graph(double double0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Prim {
    public Prim() {
    }

    public Object Prim_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Graph g;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Optional<Integer> nos_OPT = Optional.of(in.nextInt());
        Graph EXTRACTED_26 = new Graph(nos_OPT.get());
        g = EXTRACTED_26;
        for (int i = 1; i <= nos_OPT.get(); i++) {
            g.addNode(i, in.nextDouble(), in.nextDouble());
        }
        for (int i = 1; i <= nos_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_27_OPT = Optional.of(1);
            for (int j = EXTRACTED_27_OPT.get(); j <= nos_OPT.get(); j++) {
                Optional<Boolean> EXTRACTED_32_OPT = Optional.of(i != j);
                if (EXTRACTED_32_OPT.get()) {
                    Optional<Node> EXTRACTED_28_OPT = Optional.of(g.nodes[i]);
                    Node EXTRACTED_30 = g.nodes[i];
                    Optional<Aresta> EXTRACTED_31_OPT = Optional.of(new Aresta(j, g.distance(EXTRACTED_28_OPT.get(), g.nodes[j])));
                    EXTRACTED_30.adj.add(EXTRACTED_31_OPT.get());
                }
            }
        }
        Optional<Integer> EXTRACTED_29_OPT = Optional.of(1);
        g.Prim(EXTRACTED_29_OPT.get());
    }

    /**
     */
    public Prim(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}