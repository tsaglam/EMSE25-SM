import java.util.*;
import java.io.*;

class Node {
    public boolean visited;
    public double x;
    public double y;
    public LinkedList<Edge> adj;

    Node(double x, double y) {
        this.x = x;
        this.y = y;
        visited = false; // Reordered statement
        adj = new LinkedList<Edge>();
    }

    public void addEdge(Edge a) {
        adj.add(a);
    }
    
    // Unused methods
    public void unusedMethod1() {
        System.out.println("Unused 1");
    }

    public void unusedMethod2() {
        System.out.println("Unused 2");
    }

    public void unusedMethod3() {
        System.out.println("Unused 3");
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

class Graph {
    public LinkedList<Node> nodes;
    public double ink;

    Graph() {
        ink = 0.0;
        nodes = new LinkedList<Node>(); // Reordered statement
    }

    public void addNode(Node a) {
        nodes.add(a);
    }

    public Edge makeEdge(Node a, Node b) {
        return new Edge(a, b);
    }

    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        temp.addAll(nodes);
        Node parent;
        parent = temp.removeFirst(); // Reordered Statement

        while (!temp.isEmpty()) {
            for (Node a : temp) {
                parent.addEdge(makeEdge(parent, a));
                a.addEdge(makeEdge(a, parent));
            }
            parent = temp.removeFirst();
        }
    }

    public double prim() {
        LinkedList<Node> stuff = new LinkedList<Node>();
        stuff.addAll(nodes);
        double aux = Double.POSITIVE_INFINITY; // Reordered
        LinkedList<Edge> edges = new LinkedList<Edge>();
        Node node;
        Edge auxedge = null;
        node = stuff.removeFirst();
        node.visited = true;
        
        while (!stuff.isEmpty()) {
            aux = Double.POSITIVE_INFINITY; // Reordered
            edges.addAll(node.adj);
            for (Edge a : edges) {
                if (!a.target.visited && aux > a.weight) {
                    aux = a.weight;
                    auxedge = a;
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

    // Unused variable insertions
    public void unusedVars() {
        int unusedInt = 42;
        double unusedDouble = 3.14;
        String unusedString = "hello";
        unusedInt++;
        unusedDouble += 1.0;
        System.out.println(unusedString); // This is to avoid compiled as unused error/warning
    }
}

class sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        double x, y;
        double ink; // Reordered
        int n = input.nextInt();
        while (n-- > 0) { // Simplified loop
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
        }
        g.populate();
        ink = g.prim();
        System.out.printf("%.2f\n", ink);
    }

    // Unused methods in the main class
    public static void unusedMainMethod1() {
        System.out.println("Main Unused 1");
    }

    public static void unusedMainMethod2() {
        System.out.println("Main Unused 2");
    }

    public static void unusedMainMethod3() {
        System.out.println("Main Unused 3");
    }
}