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
        visited = false; // Statement reordered for clarity, but functionality preserved
        adj = new LinkedList<Edge>();
    }
    
    public void addEdge(Edge a) {
        adj.add(a);
    }
}

class Edge {
    public Node from;
    public Node target;
    public double weight;
    
    Edge(Node from, Node target) {
        this.from = from;
        this.target = target;
        // Calculation of weight is a single line directly derived from the constructor's parameters
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
    
    // Method reorder: The makeEdge method is now placed before populate for no change in functionality, just structural change
    public Edge makeEdge(Node a, Node b) {
        return new Edge(a, b);
    }
    
    public void populate() {
        LinkedList<Node> temp = new LinkedList<Node>();
        temp.addAll(nodes);
        Node parent = temp.removeFirst(); // Combined declaration and assignment
        
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
        
        Node node = stuff.removeFirst();
        node.visited = true;
        
        LinkedList<Edge> edges = new LinkedList<Edge>();
        double aux = Double.POSITIVE_INFINITY;
        Edge auxedge = null;
        
        while (!stuff.isEmpty()) {
            aux = Double.POSITIVE_INFINITY;
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
    
    // Unused code insertion as per instruction
    public void unusedMethod() {
        System.out.println("This method is not used in the execution.");
    }
    private double unusedVariable = 0.0; // This variable won't impact the code's behavior
}

class Sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph g = new Graph();
        
        double x, y;
        int n = input.nextInt();
        double ink; // Unused variable assignment removed to introduce at class level in Graph
        
        while (n-- > 0) { // compact while loop
            x = input.nextDouble();
            y = input.nextDouble();
            Node toAdd = new Node(x, y);
            g.addNode(toAdd);
        }
        g.populate();
        ink = g.prim();
        System.out.printf("%.2f\n", ink);
    }
}