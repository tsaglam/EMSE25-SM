import java.util.*;
import java.lang.Math;

class Node {
    public double x, y; // Combined declaration for brevity
    public Node parent; // Renamed for clarity
    public int index;

    // Simplified constructors
    public Node() {}
    public Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.parent = null;
    }
}

class Graph {
    public Node[] nodes;
    private int counter; // Encapsulation of fields

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node();
        }
    }

    public void addNode(Node node) {
        nodes[counter++] = node; // Simplified increment
    }

    public int size() {
        return nodes.length; // Provides direct access to the size of the graph
    }
}

class Set {
    public LinkedList<Node> nodes = new LinkedList<>(); // Initialization at declaration
    public int id;

    public Set(Node node, int id) {
        nodes.add(node);
        this.id = id;
    }
}

class Edge implements Comparable<Edge> {
    public Node a, b; // Combined declaration
    public double dist;

    public Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        this.dist = Math.hypot(b.x - a.x, b.y - a.y); // Direct method for distance calculation
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.dist, other.dist);
    }
}

class SardasKrustall {
    private static LinkedList<Set> sets = new LinkedList<>(); // Direct initialization
    private static LinkedList<Edge> selectedEdges = new LinkedList<>();

    public static int findSetIndexForNode(Node node) {
        // Enhanced readability with `for-each` loop
        for (Set set : sets) {
            if (set.nodes.contains(node)) return sets.indexOf(set);
        }
        return -1;
    }

    public static void mergeSets(int a, int b) {
        sets.get(a).nodes.addAll(sets.get(b).nodes);
        sets.remove(b);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph graph = new Graph(input.nextInt());
        for (int i = 0; i < graph.size(); i++) {
            Node node = new Node(input.nextDouble(), input.nextDouble(), i); // Changed to nextDouble for consistency
            graph.addNode(node);
        }

        LinkedList<Edge> edges = new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            for (int j = i + 1; j < graph.size(); j++) {
                edges.add(new Edge(graph.nodes[i], graph.nodes[j]));
            }
        }

        Collections.sort(edges); // Sorting edges based on distance

        for (Node n : graph.nodes) {
            sets.add(new Set(n, sets.size())); // Simplified set addition
        }

        for (Edge e : edges) {
            int a = findSetIndexForNode(e.a);
            int b = findSetIndexForNode(e.b);
            if (a != b) {
                selectedEdges.add(e);
                mergeSets(a, b);
            }
        }

        double totalDistance = selectedEdges.stream().mapToDouble(e -> e.dist).sum(); // Streamlined distance calculation
        System.out.printf("%.2f\n", totalDistance);
    }
}