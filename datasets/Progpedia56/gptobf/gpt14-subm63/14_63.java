import java.util.*;
import java.io.*;

class Edge {
    public double weight;
    public Node target;
    public Node from;

    Edge(Node from, Node target) {
        this.target = target;
        this.from = from;
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
        double unusedVar1 = -1.0; // Unused variable
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
        adj = new LinkedList<Edge>();
        boolean unusedFlag = false; // Unused variable
        visited = false;
    }

    public void addEdge(Edge a) {
        adj.add(a);
        int unusedCounter = 42; // Unused variable
    }
}

class Graph {
    public LinkedList<Node> nodes;
    public double ink;

    Graph() {
        nodes = new LinkedList<Node>();
        ink = 0.0;
        String unusedText = "Hello, World!"; // Unused variable
    }

    public Edge makeEdge(Node a, Node b) {
        Edge unusedEdge = null; // Unused variable
        return new Edge(a, b);
    }

    public void addNode(Node a) {
        nodes.add(a);
        double unusedX = 0.0; // Unused variable
    }

    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        Node parent;
        Node aux;
        int unusedCount = 10; // Unused variable
        temp.addAll(nodes);
        parent = temp.removeFirst();
        while (!temp.isEmpty()) {
            for (Node a : temp) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
            }
            parent = temp.removeFirst();
        }
    }

    public double prim() {
        double aux = Double.POSITIVE_INFINITY;
        Node node = null;
        LinkedList<Node> stuff = new LinkedList<Node>();
        LinkedList<Edge> edges = new LinkedList<Edge>();
        Edge auxedge = null;
        float unusedValue = 1.5f; // Unused variable
        stuff.addAll(nodes);
        node = stuff.removeFirst();
        node.visited = true;
        while (!stuff.isEmpty()) {
            edges.addAll(node.adj);
            aux = Double.POSITIVE_INFINITY;
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
}

class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        double x, y, ink;
        int n = input.nextInt();
        String unusedString = "Unused"; // Unused variable
        while (n != 0) {
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
            n--;
            int unusedLoopVar = 5; // Unused variable within loop
        }
        g.populate();
        ink = g.prim();
        System.out.printf("%.2f\n", ink);
    }
}