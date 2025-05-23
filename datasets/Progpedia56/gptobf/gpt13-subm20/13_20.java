import java.util.*;
import java.io.*;
import java.lang.Math;

class Node {
    public double x;
    public double y;
    public Node pai;
    public int index;

    // Constructors reordered for no actual reason as they are independent of each other.
    Node(double x, double y, int index) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.pai = null;
    }

    Node() {}

    // Unused methods added as requested
    public void printX() {
        System.out.println(x);
    }

    public void unusedMethodOne() {
        System.out.println("Unused 1");
    }

    public void unusedMethodTwo() {
        System.out.println("Unused 2");
    }
}

class Graph {
    // Properties
    public int c;
    public int n;
    public Node[] nodes;

    // Constructor
    Graph(int n) {
        this.n = n;
        this.c = 0;
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    // Add node method
    public void addNode(Node n) {
        this.c++;
        nodes[c - 1] = n;
    }

    // An unused method demonstrating no effect on functionality
    public void unusedGraphMethod() {
        System.out.println("Unused graph method");
    }
}

class Set {
    public int id;
    public LinkedList<Node> nodes;

    // Constructor
    Set(Node a, int id) {
        this.id = id;
        nodes = new LinkedList<Node>();
        nodes.addLast(a);
    }

    // An unused method for illustration
    public void printId() {
        System.out.println(id);
    }
}

class Edge implements Comparable<Edge> {
    public Node a;
    public Node b;
    public double dist;

    // Constructor
    Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        this.dist = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    // Compare method for sorting
    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.dist, e.dist);
    }

    // Unnecessary method as per the requirement
    public void printDist() {
        System.out.println("Distance: " + dist);
    }
}

class SardasKrustall {
    public static LinkedList<Edge> A;
    public static LinkedList<Set> sets;
    public static LinkedList<Edge> edges;

    // Main functionality
    public static void main(String[] args) {
        // Input and graph initialization altered for reordering demonstration
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());

        // Unused variable declarations
        int unusedInt = 0; // example of an unused variable
        String unusedString = "hello";
        double unusedDouble = 3.14;

        // Building the graph
        for (int i = 0; i < g.n; i++) {
            Node n = new Node(input.nextFloat(), input.nextFloat(), i);
            g.addNode(n);
        }

        sets = new LinkedList<Set>();
        A = new LinkedList<Edge>();
        edges = new LinkedList<Edge>();

        // Init sets and edges
        for (int i = 0; i < g.n; i++) {
            sets.add(new Set(g.nodes[i], i));
        }
        for (int i = 0; i < g.n; i++) {
            for (int j = i + 1; j < g.n; j++) {
                edges.add(new Edge(g.nodes[i], g.nodes[j]));
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

        double result = 0.0f;
        for (Edge E : A) {
            result += E.dist;
        }
        System.out.printf("%.2f\n", result);
    }

    // Reordered utility methods
    public static int find(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            for (int j = 0; j < sets.get(i).nodes.size(); j++) {
                if (sets.get(i).nodes.get(j).x == node.x && sets.get(i).nodes.get(j).y == node.y) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void merge(int a, int b) {
        sets.get(a).nodes.addAll(sets.get(b).nodes);
        sets.remove(b);
    }

    public static void resetId() {
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).id = i;
        }
    }

    // Adding unused methods
    public static void unusedStaticMethodOne() {
        System.out.println("Unused static 1");
    }

    public static void unusedStaticMethodTwo() {
        System.out.println("Unused static 2");
    }

    public static void unusedStaticMethodThree() {
        System.out.println("Unused static 3");
    }
}