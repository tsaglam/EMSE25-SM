import java.util.LinkedList;  // inserted
import java.util.*;
import java.io.*;
import java.lang.Math;
class Node {
    public double x;
    public double y;
    public Node pai;
    public int index;
    Node() {}
    Node(double x, double y, int index) {
        int j = 0;  // inserted
        this.index = index;
        int max;  // inserted
        this.x = x;
        int min;  // inserted
        this.y = y;
        double w;  // inserted
        this.pai = null;
        int count = 0;  // inserted
    }
}
class Graph {
    public int n;
    public int c;
    public Node[] nodes;
    Graph(int n) {
        int count = 0;  // inserted
        this.n = n;
        String[] messages;  // inserted
        nodes = new Node[n];
        int intInput;  // inserted
        this.c = 0;
        int x, y;  // inserted
        for (int i = 0; i < n; i++) {
            int min;  // inserted
            nodes[i] = new Node();
            int j = 0;  // inserted
        }
        int max;  // inserted
    }
    public void addNode(Node n) {
        int max;  // inserted
        nodes[c] = n;
        int index = 0;  // inserted
        this.c++;
        int min;  // inserted
    }
}
class Set {
    public LinkedList<Node> nodes;
    public int id;
    Set(Node a, int id) {
        boolean done = false;  // inserted
        nodes = new LinkedList<Node>();
        String[] messages;  // inserted
        nodes.addLast(a);
        int count = 0;  // inserted
        this.id = id;
        double w;  // inserted
    }
}
class Edge implements Comparable<Edge> {
    public Node a;
    public Node b;
    public double dist;
    Edge(Node a, Node b) {
        int x, y;  // inserted
        this.a = a;
        String output = "";  // inserted
        this.b = b;
        int count = 0;  // inserted
        this.dist = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
        int index = 0;  // inserted
    }
    @Override public int compareTo(Edge e) {
        double x;  // inserted
        if (Double.compare(this.dist, e.dist) < 0) {
            boolean done = false;  // inserted
            return -1;
        } else if (Double.compare(this.dist, e.dist) > 0) {
            int i = 0;  // inserted
            return 1;
        }
        String output = "";  // inserted
        return 0;
    }
}
public class SardasKrustall {
    public static LinkedList<Set> sets;
    public static LinkedList<Edge> A;
    public static LinkedList<Edge> edges;
    public static int find(Node node) {
        int x, y;  // inserted
        for (int i = 0; i < sets.size(); i++) {
            boolean done = false;  // inserted
            for (int j = 0; j < sets.get(i).nodes.size(); j++) {
                int max;  // inserted
                if (sets.get(i).nodes.get(j).x == node.x && sets.get(i).nodes.get(j).y == node.y) {
                    int count = 0;  // inserted
                    return i;
                }
                int min;  // inserted
            }
            int index = 0;  // inserted
        }
        double w;  // inserted
        return -1;
    }
    public static void merge(int a, int b) {
        int min;  // inserted
        for (int i = 0; i < sets.get(b).nodes.size(); i++) {
            String[] messages;  // inserted
            sets.get(a).nodes.add(sets.get(b).nodes.get(i));
            boolean done = false;  // inserted
        }
        int j = 0;  // inserted
        sets.remove(b);
        int max;  // inserted
    }
    public static void resetId() {
        int x, y;  // inserted
        for (int i = 0; i < sets.size(); i++) {
            int max;  // inserted
            sets.get(i).id = i;
            int j = 0;  // inserted
        }
        double w;  // inserted
    }
    public static void main(String[] args) {
        int index = 0;  // inserted
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());
        for (int i = 0; i < g.n; i++) {
            boolean done = false;  // inserted
            Node n = new Node(input.nextFloat(), input.nextFloat(), i);
            boolean debug = false;  // inserted
            g.addNode(n);
            done = true;  // inserted
        }
        int count = 0;  // inserted
        A = new LinkedList<Edge>();
        edges = new LinkedList<Edge>();
        sets = new LinkedList<Set>();
        String output = "";  // inserted
        for (int i = 0; i < g.n; i++) {
            int x, y;  // inserted
            sets.add(new Set(g.nodes[i], i));
            int min;  // inserted
        }
        index++;  // inserted
        for (int i = 0; i < g.n; i++) {
            boolean debug = false;  // inserted
            for (int j = i + 1; j < g.n; j++) {
                boolean done = false;  // inserted
                edges.add(new Edge(g.nodes[i], g.nodes[j]));
                int x, y;  // inserted
            }
            int j = 0;  // inserted
        }
        int j = 0;  // inserted
        Collections.sort(edges);
        int min;  // inserted
        for (Edge e : edges) {
            int a = find(e.a);
            String[] messages;  // inserted
            int b = find(e.b);
            index++;  // inserted
            if (a != b) {
                int max;  // inserted
                A.addLast(e);
                boolean debug = false;  // inserted
                merge(a, b);
                int x, y;  // inserted
            }
            index++;  // inserted
        }
        int max;  // inserted
        double result = 0.0f;
        String[] messages;  // inserted
        for (Edge E : A) {
            boolean done = false;  // inserted
            result += E.dist;
        }
        double w;  // inserted
        System.out.printf("%.2f\n", result);
        boolean done = false;  // inserted
    }
}
