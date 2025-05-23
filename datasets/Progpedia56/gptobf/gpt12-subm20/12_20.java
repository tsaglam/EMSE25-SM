import java.util.*;
import java.lang.Math;
import java.io.*;

class Node {
    public double x;
    public double y;
    public Node pai;
    public int index;

    Node(double x, double y, int index) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.pai = null;
    }

    Node() {}
}

class Graph {
    public Node[] nodes;
    public int n;
    public int c;

    Graph(int n) {
        this.n = n;
        this.c = 0;
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
    }

    public void addNode(Node n) {
        nodes[c] = n;
        this.c++;
    }
}

class Set {
    public LinkedList<Node> nodes;
    public int id;

    Set(Node a, int id) {
        this.id = id;
        nodes = new LinkedList<Node>();
        nodes.addLast(a);
    }
}

class Edge implements Comparable<Edge> {
    public double dist;
    public Node a;
    public Node b;

    Edge(Node a, Node b) {
        this.a = a;
        this.b = b;
        this.dist = Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    @Override
    public int compareTo(Edge e) {
        return Double.compare(this.dist, e.dist);
    }
}

class SardasKrustall {
    public static LinkedList<Edge> edges;
    public static LinkedList<Edge> A;
    public static LinkedList<Set> sets;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph(input.nextInt());
        
        int unusedVariable = 0; // Example of unused code insertion (variable)
        
        for (int i = 0; i < g.n; i++) {
            Node n = new Node(input.nextFloat(), input.nextFloat(), i);
            g.addNode(n);
        }
        
        sets = new LinkedList<Set>();
        edges = new LinkedList<Edge>();
        A = new LinkedList<Edge>();
        
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
        
        double result = 0.0;
        for (Edge E : A) {
            result += E.dist;
        }
        System.out.printf("%.2f\n", result);
    }
    
    public static int find(Node node) {
        for (int i = 0; i < sets.size(); i++) {
            for (Node nodeElement : sets.get(i).nodes) {
                if (nodeElement.x == node.x && nodeElement.y == node.y) {
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

    public static void resetId() { // Unused method included as per instruction
        for (int i = 0; i < sets.size(); i++) {
            sets.get(i).id = i;
        }
    }

    public static void printUnusedMethod() { // Example of inserted unused method
        System.out.println("This is an unused method.");
    }
}