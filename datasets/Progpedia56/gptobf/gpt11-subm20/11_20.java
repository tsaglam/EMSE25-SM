import java.util.*;
import java.io.*;
import java.lang.Math;

class Graph {
    public Node[] nodes;
    public int n, c;
    Graph(int n) {
        this.n = n;
        nodes = new Node[n];
        c = 0;
    }
    public void addNode(Node n) {
        nodes[c++] = n;
    }
}

class Node {
    public double x, y;
    public Node pai;
    public int index;
    Node() {}
    Node(double x, double y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class Set {
    public LinkedList<Node> nodes;
    public int id;
    Set(Node a, int id) {
        nodes = new LinkedList<>();
        this.id = id;
        nodes.add(a);
    }
}

class Edge implements Comparable<Edge> {
    public Node a, b;
    public double dist;
    Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        dist = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.dist, e.dist);
    }
}

class SardasKrustall {
    public static LinkedList<Set> sets;
    public static LinkedList<Edge> edges, A;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());
        for (int i = 0; i < g.n; i++) {
            g.addNode(new Node(input.nextDouble(), input.nextDouble(), i));
        }

        sets = new LinkedList<>();
        for (Node node : g.nodes) {
            sets.add(new Set(node, node.index));
        }

        edges = new LinkedList<>();
        A = new LinkedList<>();
        for (int i = 0; i < g.n; i++) {
            for (int j = 0; j < g.n; j++) {
                if (i < j) {
                    Edge edge = new Edge(g.nodes[i], g.nodes[j]);
                    edges.add(edge);
                }
            }
        }

        Collections.sort(edges);
        for (Edge e : edges) {
            int a = find(e.a);
            int b = find(e.b);
            if (a != b) {
                A.add(e);
                merge(a, b);
            }
        }

        double result = 0;
        for (Edge e : A) {
            result += e.dist;
        }
        System.out.printf("%.2f\n", result);
    }

    public static int find(Node node) {
        for (Set set : sets) {
            if (set.nodes.contains(node)) {
                return set.id;
            }
        }
        return -1;
    }

    public static void merge(int a, int b) {
        Set setA = sets.get(a);
        Set setB = sets.get(b);
        setA.nodes.addAll(setB.nodes);
        sets.remove(b);
    }
}