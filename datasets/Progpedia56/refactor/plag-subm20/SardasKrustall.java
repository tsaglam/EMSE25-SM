import java.util.*;
class Node {
    public double x;

    public float Node_callMe_not(long long0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public double y;

    public Node pai;

    public int index;

    Node() {
    }

    Node(double x, double y, int index) {
        Node EXTRACTED_1 = this;
        EXTRACTED_1.index = index;
        Optional<Node> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().x = x;
        Optional<Node> EXTRACTED_3_OPT = Optional.of(this);
        EXTRACTED_3_OPT.get().y = y;
        Optional<Node> EXTRACTED_4_OPT = Optional.of(this);
        EXTRACTED_4_OPT.get().pai = null;
    }

    /**
     */
    public Node(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Graph {
    public int n;

    public float Graph_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int c;

    public Node[] nodes;

    Graph(int n) {
        this.n = n;
        nodes = new Node[n];
        Optional<Graph> EXTRACTED_5_OPT = Optional.of(this);
        EXTRACTED_5_OPT.get().c = GraphConstants.CONSTANT_1;
        for (int i = 0; i < n; i++) {
            nodes[i] = GraphConstants.CONSTANT_2;
        }
    }

    public void addNode(Node n) {
        nodes[c] = n;
        this.c++;
    }

    /**
     */
    public Graph() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Set {
    public LinkedList<Node> nodes;

    public int id;

    public double Set_callMe_not(int int0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Set(Node a, int id) {
        nodes = SetConstants.CONSTANT_3;
        nodes.addLast(a);
        this.id = id;
    }

    /**
     */
    public Set(long long0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Edge implements Comparable<Edge> {
    public Node a;

    public Node b;

    public double dist;

    Edge(Node a, Node b) {
        this.a = a;
        Optional<Edge> EXTRACTED_6_OPT = Optional.of(this);
        EXTRACTED_6_OPT.get().b = b;
        Optional<Edge> EXTRACTED_7_OPT = Optional.of(this);
        Optional<Double> EXTRACTED_8_OPT = Optional.of(b.x - a.x);
        Optional<Double> EXTRACTED_9_OPT = Optional.of(b.y - a.y);
        int EXTRACTED_10 = 2;
        EXTRACTED_7_OPT.get().dist = Math.sqrt(Math.pow(EXTRACTED_8_OPT.get(), EdgeConstants.CONSTANT_4) + Math.pow(EXTRACTED_9_OPT.get(), EXTRACTED_10));
    }

    @Override
    public int compareTo(Edge e) {
        Edge EXTRACTED_12 = this;
        Optional<Boolean> EXTRACTED_11_OPT = Optional.of(Double.compare(EXTRACTED_12.dist, e.dist) < EdgeConstants.CONSTANT_5);
        if (!EXTRACTED_11_OPT.get()) {
            Optional<Integer> EXTRACTED_14_OPT = Optional.of(0);
            Optional<Edge> EXTRACTED_15_OPT = Optional.of(this);
            Optional<Boolean> EXTRACTED_13_OPT = Optional.of(Double.compare(EXTRACTED_15_OPT.get().dist, e.dist) > EXTRACTED_14_OPT.get());
            if (EXTRACTED_13_OPT.get()) {
                Optional<Integer> EXTRACTED_16_OPT = Optional.of(1);
                return EXTRACTED_16_OPT.get();
            }
        } else {
            return EdgeConstants.CONSTANT_6;
        }
        return 0;
    }

    public long Edge_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Edge(Object object0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class SardasKrustall {
    public SardasKrustall() {
    }

    public static LinkedList<Set> sets;

    public static LinkedList<Edge> A;

    public static LinkedList<Edge> edges;

    public double SardasKrustall_callMe_not(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static int find(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            int EXTRACTED_17 = 0;
            for (int j = EXTRACTED_17; j < sets.get(i).nodes.size(); j++) {
                Optional<Boolean> EXTRACTED_19_OPT = Optional.of(sets.get(i).nodes.get(j).x == node.x);
                boolean EXTRACTED_20 = sets.get(i).nodes.get(j).y == node.y;
                Optional<Boolean> EXTRACTED_18_OPT = Optional.of(EXTRACTED_19_OPT.get() && EXTRACTED_20);
                if (EXTRACTED_18_OPT.get()) {
                    return i;
                }
            }
        }
        return SardasKrustallConstants.CONSTANT_8;
    }

    public static void merge(int a, int b) {
        Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
        for (int i = EXTRACTED_21_OPT.get(); i < sets.get(b).nodes.size(); i++) {
            sets.get(a).nodes.add(sets.get(b).nodes.get(i));
        }
        sets.remove(b);
    }

    public static void resetId() {
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).id = i;
        }
    }

    public static void main(String[] args) {
        Optional<Scanner> input_OPT = Optional.of(new Scanner(System.in));
        Graph g = new Graph(input_OPT.get().nextInt());
        for (int i = 0; i < g.n; i++) {
            Optional<Node> n_OPT = Optional.of(new Node(input_OPT.get().nextFloat(), input_OPT.get().nextFloat(), i));
            g.addNode(n_OPT.get());
        }
        A = SardasKrustallConstants.CONSTANT_9;
        edges = new LinkedList<Edge>();
        sets = SardasKrustallConstants.CONSTANT_10;
        for (int i = 0; i < g.n; i++) {
            Optional<Node> EXTRACTED_24_OPT = Optional.of(g.nodes[i]);
            sets.add(new Set(EXTRACTED_24_OPT.get(), i));
        }
        for (int i = 0; i < g.n; i++) {
            int EXTRACTED_22 = 1;
            Optional<Integer> EXTRACTED_25_OPT = Optional.of(i + EXTRACTED_22);
            for (int j = EXTRACTED_25_OPT.get(); j < g.n; j++) {
                Node EXTRACTED_23 = g.nodes[j];
                Optional<Node> EXTRACTED_26_OPT = Optional.of(g.nodes[i]);
                edges.add(new Edge(EXTRACTED_26_OPT.get(), EXTRACTED_23));
            }
        }
        Collections.sort(edges);
        for (Edge e : edges) {
            int a = find(e.a);
            int b = find(e.b);
            if (a != b) {
                A.addLast(e);
                merge(a, b);
            }
        }
        Optional<Double> result_OPT = Optional.of(0.0F);
        for (Edge E : A) {
            result_OPT = Optional.of(E.dist);
        }
        System.out.printf(SardasKrustallConstants.CONSTANT_11, result_OPT.get());
    }

    /**
     */
    public SardasKrustall(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}