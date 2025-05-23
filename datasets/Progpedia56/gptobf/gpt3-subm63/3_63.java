import java.util.*;
import java.io.*;

class Node {
    boolean visited = false; // Made package-private for brevity
    double x, y; // Combined declaration
    List<Edge> adj = new LinkedList<>(); // Used the interface for the type declaration

    Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void addEdge(Edge a) { // Made package-private for brevity
        adj.add(a);
    }
}

class Graph {
    List<Node> nodes = new LinkedList<>(); // Simplified initialization
    double ink = 0.0;

    void addNode(Node a) { // Made package-private for brevity
        nodes.add(a);
    }

    void populate() {
        List<Node> temp = new LinkedList<>(nodes); // Simplified copy initialization
        while (!temp.isEmpty()) {
            Node parent = temp.remove(0); // Simplified removal call
            temp.forEach(a -> {
                parent.addEdge(new Edge(parent, a)); // inlined makeEdge
                a.addEdge(new Edge(a, parent)); // inlined makeEdge
            });
        }
    }

    double prim() {
        if (nodes.isEmpty()) return ink; 

        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        Node node = nodes.get(0); 
        node.visited = true;

        while (node != null) {
            node.adj.stream().filter(edge -> !edge.target.visited).forEach(edgeQueue::add);
            Edge auxedge;
            do {
               auxedge = edgeQueue.poll();
            } while (auxedge != null && auxedge.target.visited);

            if (auxedge == null) break;

            ink += auxedge.weight;
            auxedge.target.visited = true;
            node = auxedge.target;
        }

        return ink;
    }
}

class Edge {
    double weight; // Made package-private for brevity
    Node target, from; // Combined declaration

    Edge(Node from, Node target) {
        this.target = target;
        this.from = from;
        weight = Math.hypot(from.x - target.x, from.y - target.y); // Used Math.hypot for readability
    }
}

class Sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        int n = input.nextInt();
        while (n-- > 0) { // Simplified loop
            double x = input.nextDouble();
            double y = input.nextDouble();
            g.addNode(new Node(x, y)); // Simplified instantiation and addition
        }
        g.populate();
        double ink = g.prim();
        System.out.printf("%.2f%n", ink); // Used %n for platform-independent new line
    }
}