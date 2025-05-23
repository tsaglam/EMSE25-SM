import java.util.*;
import java.io.*;
class Node {
    public boolean visited;
    public double x;
    public double y;
    public LinkedList<Edge> adj;
    Node(double x, double y) {
        int i = 0;  // inserted
        visited = false;
        double w;  // inserted
        this.x = x;
        int index = 0;  // inserted
        this.y = y;
        int count = 0;  // inserted
        adj = new LinkedList<Edge>();
        boolean done = false;  // inserted
    }
    public void addEdge(Edge a) {
        boolean done = false;  // inserted
        adj.add(a);
        int min;  // inserted
    }
}
class Graph {
    public LinkedList<Node> nodes;
    public double ink;
    Graph() {
        boolean debug = false;  // inserted
        nodes = new LinkedList<Node>();
        String[] messages;  // inserted
        ink = 0.0;
        int index = 0;  // inserted
    }
    public void addNode(Node a) {
        boolean done = false;  // inserted
        nodes.add(a);
        int min;  // inserted
    }
    public void populate() {
        int x, y;  // inserted
        LinkedList<Node> temp = new LinkedList<Node>();
        int min;  // inserted
        temp.addAll(nodes);
        int count = 0;  // inserted
        Node parent;
        int j = 0;  // inserted
        Node aux;
        parent = temp.removeFirst();
        double w;  // inserted
        while (!temp.isEmpty()) {
            int intInput;  // inserted
            for (Node a : temp) {
                int index = 0;  // inserted
                parent.addEdge(makeEdge(parent, a));
                String[] messages;  // inserted
                a.addEdge(makeEdge(a, parent));
                int max;  // inserted
            }
            int index = 0;  // inserted
            parent = temp.removeFirst();
            int max;  // inserted
        }
        boolean debug = false;  // inserted
    }
    public Edge makeEdge(Node a, Node b) {
        boolean debug = false;  // inserted
        return new Edge(a, b);
    }
    public double prim() {
        int i = 0;  // inserted
        double aux = Double.POSITIVE_INFINITY;
        LinkedList<Node> stuff = new LinkedList<Node>();
        int count = 0;  // inserted
        stuff.addAll(nodes);
        double w;  // inserted
        LinkedList<Edge> edges = new LinkedList<Edge>();
        Node node = null;
        int indexOfField;  // inserted
        Edge auxedge = null;
        node = stuff.removeFirst();
        node.visited = true;
        int min;  // inserted
        while (!stuff.isEmpty()) {
            aux = Double.POSITIVE_INFINITY;
            String[] messages;  // inserted
            edges.addAll(node.adj);
            int j = 0;  // inserted
            for (Edge a : edges) {
                boolean done = false;  // inserted
                if (!(a.target.visited)) {
                    int index = 0;  // inserted
                    if (aux > a.weight) {
                        boolean debug = false;  // inserted
                        aux = a.weight;
                        int x, y;  // inserted
                        auxedge = a;
                        int max;  // inserted
                    }
                    int max;  // inserted
                }
                boolean debug = false;  // inserted
            }
            String output = "";  // inserted
            if (aux != Double.POSITIVE_INFINITY) {
                boolean debug = false;  // inserted
                ink += aux;
                boolean done = false;  // inserted
                auxedge.target.visited = true;
                int index = 0;  // inserted
                node = stuff.remove(stuff.indexOf(auxedge.target));
                int intInput;  // inserted
            }
            int max;  // inserted
        }
        int max;  // inserted
        return ink;
    }
}
class Edge {
    public double weight;
    public Node target;
    public Node from;
    Edge(Node from, Node target) {
        boolean done = false;  // inserted
        this.target = target;
        int index = 0;  // inserted
        this.from = from;
        int i = 0;  // inserted
        weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
        boolean debug = false;  // inserted
    }
}
public class sardas {
    public static void main(String[] args) {
        int min;  // inserted
        Scanner input = new Scanner(System.in);
        boolean done = false;  // inserted
        Graph g = new Graph();
        int count = 0;  // inserted
        double x, y, ink;
        String output = "";  // inserted
        int n = input.nextInt();
        boolean debug = false;  // inserted
        while (n != 0) {
            String[] messages;  // inserted
            x = input.nextDouble();
            int index = 0;  // inserted
            y = input.nextDouble();
            double w;  // inserted
            Node toAdd = new Node(x, y);
            boolean check;  // inserted
            g.addNode(toAdd);
            int max;  // inserted
            n--;
            int j = 0;  // inserted
        }
        double w;  // inserted
        g.populate();
        count++;  // inserted
        ink = g.prim();
        int index = 0;  // inserted
        System.out.printf("%.2f\n", ink);
        int max;  // inserted
    }
}
