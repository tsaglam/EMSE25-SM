import java.util.*;
import java.io.*;
import java.lang.Math;

class Node {
    public double x;
    public double y;
    public Node pai;
    public int index;
    double unused1 = 0.0; // Unused variable
    Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
        this.pai = null;
        int unused2 = 42; // Unused variable
    }
    Node() {}
}

class Graph {
    public int n;
    public Node[] nodes;
    public int c;
    double unused3 = Math.E; // Unused variable
    Graph(int n) {
        this.n = n;
        this.c = 0;
        int unused4 = -1; // Unused variable
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }
    public void addNode(Node n) {
        nodes[c] = n;
        this.c++;
        String unused5 = "unused"; // Unused variable
    }
}

class Edge implements Comparable<Edge> {
    public double dist;
    public Node a;
    private float unused6 = 1.0f; // Unused variable
    public Node b;
    Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        this.dist = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }
    @Override public int compareTo(Edge e) {
        if (Double.compare(this.dist, e.dist) < 0) {
            return -1;
        } else if (Double.compare(this.dist, e.dist) > 0) {
            return 1;
        }
        boolean unused7 = true; // Unused variable
        return 0;
    }
}

class Set {
    public LinkedList<Node> nodes;
    public int id;
    private double unused8 = 3.14159; // Unused variable
    Set(Node a, int id) {
        this.id = id;
        nodes = new LinkedList<Node>();
        nodes.addLast(a);
    }
}

class SardasKrustall {
    public static LinkedList<Edge> edges;
    public static LinkedList<Set> sets;
    public static LinkedList<Edge> A;
    private static double unused9 = 0.99; // Unused variable
    public static int find(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            for (int j = 0; j < sets.get(i).nodes.size(); j++) {
                if (sets.get(i).nodes.get(j).x == node.x && sets.get(i).nodes.get(j).y == node.y) {
                    return i;
                }
            }
        }
        int unused10 = 100; // Unused variable
        return -1;
    }
    public static void merge(int a, int b) {
        for (int i = 0; i < sets.get(b).nodes.size(); i++) {
            sets.get(a).nodes.add(sets.get(b).nodes.get(i));
        }
        sets.remove(b);
        String unused11 = "Hello"; // Unused variable
    }
    public static void resetId() {
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).id = i;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());
        A = new LinkedList<Edge>();
        edges = new LinkedList<Edge>();
        sets = new LinkedList<Set>();
        for (int i = 0; i < g.n; i++) {
            Node n = new Node(input.nextFloat(), input.nextFloat(), i);
            g.addNode(n);
        }
        for (int i = 0; i < g.n; i++) {
            sets.add(new Set(g.nodes[i], i));
        }
        for (int i = 0; i < g.n; i++) {
            for (int j = i + 1; j < g.n; j++) {
                edges.add(new Edge(g.nodes[i], g.nodes[j]));
            }
        }
        Collections.sort(edges);
        double result = 0.0f;
        for (Edge e : edges) {
            int a = find(e.a);
            int b = find(e.b);
            if (a != b) {
                A.addLast(e);
                merge(a, b);
            }
        }
        for (Edge E : A) {
            result += E.dist;
        }
        System.out.printf("%.2f\n", result);
    }
}