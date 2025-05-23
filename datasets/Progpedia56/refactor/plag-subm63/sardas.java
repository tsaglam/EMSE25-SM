import java.util.*;
class Node {
    public boolean visited;

    public double x;

    public double y;

    public LinkedList<Edge> adj;

    Node(double x, double y) {
        visited = NodeConstants.CONSTANT_1;
        this.x = x;
        this.y = y;
        adj = NodeConstants.CONSTANT_2;
    }

    public void addEdge(Edge a) {
        adj.add(a);
    }

    public int Node_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Node() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Graph {
    public LinkedList<Node> nodes;

    public double ink;

    Graph() {
        nodes = GraphConstants.CONSTANT_3;
        ink = GraphConstants.CONSTANT_4;
    }

    public Object Graph_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public void addNode(Node a) {
        nodes.add(a);
    }

    public void populate() {
        Optional<LinkedList<Node>> temp_OPT = Optional.of(new LinkedList<Node>());
        temp_OPT.get().addAll(nodes);
        Node parent;
        Optional<Node> aux_OPT;
        parent = temp_OPT.get().removeFirst();
        while (!temp_OPT.get().isEmpty()) {
            for (Node a : temp_OPT.get()) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
            }
            parent = temp_OPT.get().removeFirst();
        } 
    }

    public Edge makeEdge(Node a, Node b) {
        return new Edge(a, b);
    }

    public double prim() {
        double aux = Double.POSITIVE_INFINITY;
        Optional<LinkedList<Node>> stuff_OPT = Optional.of(new LinkedList<Node>());
        stuff_OPT.get().addAll(nodes);
        LinkedList<Edge> edges = new LinkedList<Edge>();
        Node node = null;
        Optional<Edge> auxedge_OPT = Optional.of(null);
        node = stuff_OPT.get().removeFirst();
        node.visited = GraphConstants.CONSTANT_5;
        Optional<Boolean> EXTRACTED_1_OPT = Optional.of(!stuff_OPT.get().isEmpty());
        while (EXTRACTED_1_OPT.get()) {
            aux = Double.POSITIVE_INFINITY;
            edges.addAll(node.adj);
            for (Edge a : edges) {
                Optional<Boolean> EXTRACTED_2_OPT = Optional.of(!a.target.visited);
                if (EXTRACTED_2_OPT.get()) {
                    Optional<Boolean> EXTRACTED_3_OPT = Optional.of(aux > a.weight);
                    if (EXTRACTED_3_OPT.get()) {
                        aux = a.weight;
                        auxedge_OPT = Optional.of(a);
                    }
                }
            }
            Optional<Boolean> EXTRACTED_4_OPT = Optional.of(aux != Double.POSITIVE_INFINITY);
            if (EXTRACTED_4_OPT.get()) {
                ink += aux;
                Optional<Boolean> EXTRACTED_5_OPT = Optional.of(true);
                auxedge_OPT.get().target.visited = EXTRACTED_5_OPT.get();
                node = stuff_OPT.get().remove(stuff_OPT.get().indexOf(auxedge_OPT.get().target));
            }
        } 
        return ink;
    }

    /**
     */
    public Graph(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Edge {
    public double weight;

    public Node target;

    public Object Edge_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public Node from;

    Edge(Node from, Node target) {
        this.target = target;
        this.from = from;
        Optional<Integer> EXTRACTED_7_OPT = Optional.of(2);
        Optional<Double> EXTRACTED_6_OPT = Optional.of(Math.pow(from.x - target.x, EdgeConstants.CONSTANT_6) + Math.pow(from.y - target.y, EXTRACTED_7_OPT.get()));
        weight = Math.sqrt(EXTRACTED_6_OPT.get());
    }

    /**
     */
    public Edge(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class sardas {
    public sardas() {
    }

    public double sardas_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Optional<Graph> g_OPT = Optional.of(new Graph());
        double x;
        Optional<Double> y_OPT;
        Optional<Double> ink_OPT;
        int n = input.nextInt();
        while (n != sardasConstants.CONSTANT_7) {
            x = input.nextDouble();
            y_OPT = Optional.of(input.nextDouble());
            Optional<Node> toAdd_OPT = Optional.of(new Node(x, y_OPT.get()));
            g_OPT.get().addNode(toAdd_OPT.get());
            n--;
        } 
        g_OPT.get().populate();
        ink_OPT = Optional.of(g_OPT.get().prim());
        System.out.printf(sardasConstants.CONSTANT_8, ink_OPT.get());
    }

    /**
     */
    public sardas(Object object0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}