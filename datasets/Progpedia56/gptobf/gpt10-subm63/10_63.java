import java.util.*;
import java.io.*;
class Node {
    public boolean visited;
    public double x;
    public double y;
    public LinkedList<Edge> adj;
    Node(double x, double y) {
        visited = false;
        this.x = x;
        this.y = y;
        adj = new LinkedList<Edge>();

    }
    public void addEdge(Edge a) {
        adj.add(a);
    }

}
class Edge {
    public double weight;
    public Node target;
    public Node from;
    Edge(Node from, Node target) {
        this.from = from;
        this.target = target;
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
    }
}
class Graph {
    public LinkedList<Node> nodes;
    public double ink;
    Graph() {
        ink = 0.0;
        nodes = new LinkedList<Node>();
    }
    public void addNode(Node a) {
        nodes.add(a);
    }
    public double prim() {
        double aux = Double.POSITIVE_INFINITY;
        LinkedList<Edge> edges = new LinkedList<Edge>();
        LinkedList<Node> stuff = new LinkedList<Node>();
        stuff.addAll(nodes);
        Edge auxedge = null;
        Node node = null;
        node = stuff.removeFirst();
        node.visited = true;
        while (!stuff.isEmpty()) {
            aux = Double.POSITIVE_INFINITY;
            edges.addAll(node.adj);
            for (Edge a : edges) {
                if (!(a.target.visited)) {
                    if (aux > a.weight) {
                        aux = a.weight;
                        auxedge = a;
                    }
                }
            }
            if (aux != Double.POSITIVE_INFINITY) {
                ink += aux;
                auxedge.target.visited = true;
                node = stuff.remove(stuff.indexOf(auxedge.target));
            }
        }
        return ink;
    }
    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        temp.addAll(nodes);
        Node aux;
        Node parent;
        parent = temp.removeFirst();
        while (!temp.isEmpty()) {
            for (Node a : temp) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
            }
            parent = temp.removeFirst();
        }
    }
    public Edge makeEdge(Node a, Node b) {
        return new Edge(a, b);
    }

}
class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Graph g = new Graph();
        double x, y, ink;
        while (n != 0) {
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
            n--;
        }
        g.populate();
        ink = g.prim();
        System.out.printf("%.2f\n", ink);
    }

}