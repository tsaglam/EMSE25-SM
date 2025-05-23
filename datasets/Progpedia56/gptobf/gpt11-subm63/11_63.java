import java.util.*;
import java.io.*;
class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        double x, y;
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
        }
        g.populate();
        System.out.printf("%.2f\n", g.prim());
    }
}
class Graph {
    public LinkedList<Node> nodes;
    public double ink;
    Graph() {
        ink = 0.0;
        nodes = new LinkedList<>();
    }
    public void addNode(Node a) {
        nodes.add(a);
    }
    public void populate() {
        for (Node parent : new LinkedList<>(nodes)) {
            for (Node a : nodes) {
                if (a != parent) {
                    parent.addEdge(new Edge(parent, a));
                    a.addEdge(new Edge(a, parent));
                }
            }
        }
    }
    public double prim() {
        if (nodes.isEmpty()) return ink;
        double aux = Double.POSITIVE_INFINITY;
        LinkedList<Node> q = new LinkedList<>();
        q.addAll(nodes);
        LinkedList<Edge> edges = new LinkedList<>();
        Node node = q.poll();
        node.visited = true;
        while (!q.isEmpty()) {
            edges.clear();
            edges.addAll(node.adj);
            Edge auxedge = null;
            for (Edge a : edges) {
                if (!a.target.visited && aux > a.weight) {
                    aux = a.weight;
                    auxedge = a;
                }
            }
            if (auxedge != null) {
                ink += aux;
                auxedge.target.visited = true;
                node = auxedge.target;
                q.remove(node);
            }
            aux = Double.POSITIVE_INFINITY;
        }
        return ink;
    }
}
class Node {
    public boolean visited;
    public double x;
    public double y;
    public LinkedList<Edge> adj;
    Node(double x, double y) {
        this.x = x;
        this.y = y;
        adj = new LinkedList<>();
    }
    public void addEdge(Edge e) {
        adj.add(e);
    }
}
class Edge {
    public Node from;
    public Node target;
    public double weight;
    Edge(Node from, Node target) {
        this.from = from;
        this.target = target;
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
    }
}