import java.util.*;
import java.io.*;

class Node {
    public boolean visited;
    public double x;
    public double y;
    public LinkedList<Edge> adj;
    // Random dead variable for obfuscation
    private int unused;

    Node(double x, double y) {
        visited = false;
        this.x = x;
        this.y = y;
        adj = new LinkedList<Edge>();
        unused = 0; // Dead code
    }

    public void addEdge(Edge a) {
        adj.add(a);
        unused++; // Dead code
    }

    // Unused method for obfuscation
    private void deadMethod() {
        unused = (int) (Math.random() * 100);
    }
}

class Graph {
    public LinkedList<Node> nodes;
    public double ink;
    // Dead variable for obfuscation
    private int pointlessVariable;
    
    Graph() {
        nodes = new LinkedList<Node>();
        ink = 0.0;
        pointlessVariable = -1; // Dead code
    }

    public void addNode(Node a) {
        nodes.add(a);
        pointlessVariable++; // Dead code
    }

    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        temp.addAll(nodes);
        Node parent;
        // Inserting dead code
        Node unusedNode = null;
        parent = temp.removeFirst();
        while (!temp.isEmpty()) {
            for (Node a : temp) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
                // Dead code
                if (unusedNode == a) {
                    unusedNode = null;
                }
            }
            parent = temp.removeFirst();
        }
    }

    public Edge makeEdge(Node a, Node b) {
        // Dead code: misleading information
        double deadCalculation = Math.random();
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
        // Unnecessary increment operation
        int count = 0;
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
                count++; // Dead code: meaningless increment
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

class Edge {
    public double weight;
    public Node target;
    public Node from;
    
    Edge(Node from, Node target) {
        this.target = target;
        this.from = from;
        // Complicated expression
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2)) * 1.00000001 / 1.00000001;
        // Dead code for obfuscation
        double deadWeight = weight - Math.random();
    }
}

class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        double x, y, ink;
        int n = input.nextInt();
        while (n != 0) {
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
            n--;
            // Dead code block
            if (x == y && n == 1000) {
                System.out.println("This won't happen.");
            }
        }
        g.populate();
        ink = g.prim();
        System.out.printf("%.2f\n", ink);
        // Final dead code for confusion
        if (ink > 10000) {
            System.out.println("This is misleading and will likely never be printed.");
        }
    }
}