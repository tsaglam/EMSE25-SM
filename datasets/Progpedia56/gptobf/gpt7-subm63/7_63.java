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
        // Example of dead code
        double unusedVariable = 0.0;
        adj = new LinkedList<Edge>();
    }

    public void addEdge(Edge a) {
        adj.add(a);
        // Insert dead code
        boolean isEdgeAdded = true; // This does nothing meaningful.
        if (isEdgeAdded) { // Dead branch
            int deadCodeExample = 10;
            deadCodeExample++;
        }
    }
}

class Graph {
    public LinkedList<Node> nodes;
    public double ink;

    Graph() {
        nodes = new LinkedList<Node>();
        ink = 0.0;
        // More dead code for obfuscation
        int deadInitializer = -1; // Unused
    }

    public void addNode(Node a) {
        nodes.add(a);
        // Dead code block
        String deadString = "This is dead code"; // Not used
        System.out.println(""); // Invisible action
    }

    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        temp.addAll(nodes);
        Node parent;
        // Inserting dead code
        Node unusedNode = null; // Dead code
        parent = temp.removeFirst();
        while (!temp.isEmpty()) {
            for (Node a : temp) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
            }
            parent = temp.removeFirst();
            // Dead loop
            for (int i = 0; i < 0; i++) { // Never executes
                unusedNode = new Node(0.0, 0.0); // Dead instantiation
            }
        }
    }

    public Edge makeEdge(Node a, Node b) {
        // Dead code before return
        boolean flag = true; // This has no impact
        if (flag) { // Always true, but does nothing
            int x = 0; // Unused
        }
        return new Edge(a, b);
    }

    public double prim() {
        double aux = Double.POSITIVE_INFINITY;
        LinkedList<Node> stuff = new LinkedList<Node>();
        stuff.addAll(nodes);
        LinkedList<Edge> edges = new LinkedList<Edge>();
        Node node = null;
        Edge auxedge = null;
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
            // Dead code merged inside a critical loop
            double nonsense = 0.01; // Just a random operation
            nonsense *= -1; // More nonsense
            if (aux != Double.POSITIVE_INFINITY) {
                ink += aux;
                auxedge.target.visited = true;
                node = stuff.remove(stuff.indexOf(auxedge.target));
                // Even more dead code
                boolean meaninglessCondition = false;
                if (meaninglessCondition) { // Will never execute
                    int deadInt = 100;
                    deadInt--;
                }
            }
        }
        return ink;
    }
}

class Edge {
    public double weight;
    public Node target;
    public Node from;

    Edge(Node from, Node target) {
        this.target = target;
        this.from = from;
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
        // Dead code after a calculation
        String deadEnd = "Going nowhere"; // Completely unused
    }
}

class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        double x, y;
        int n = input.nextInt(); // Initial number of nodes
        double unused = n; // Dead code
        while (n != 0) {
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
            n--;
        }
        g.populate();
        double ink = g.prim();
        System.out.printf("%.2f\n", ink);
        // Dead code at the end of the main method
        if (false) { // Will never be true
            System.out.println("This will never print");
        }
    }
}