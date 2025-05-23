import java.util.*;
import java.io.*;

class Node {
    private final double x, y;
    private boolean visited;
    private final List<Edge> adjacencyList;

    Node(double x, double y) {
        this.x = x;
        this.y = y;
        this.visited = false;
        this.adjacencyList = new ArrayList<>();
    }

    void addEdge(Edge edge) {
        adjacencyList.add(edge);
    }

    boolean isVisited() {
        return visited;
    }

    void visit() {
        this.visited = true;
    }

    List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    double getX() {
        return x;
    }

    double getY() {
        return y;
    }
}

class Graph {
    private final List<Node> nodes;
    private double ink;

    Graph() {
        nodes = new ArrayList<>();
        ink = 0.0;
    }

    void addNode(Node node) {
        nodes.add(node);
    }

    void populateGraph() {
        for (Node parent : nodes) {
            for (Node child : nodes) {
                if (parent != child) { // Avoid self-loops
                    Edge edge = new Edge(parent, child);
                    parent.addEdge(edge);
                    child.addEdge(edge); // For undirected graph, consider if needed.
                }
            }
        }
    }
    
    Edge makeEdge(Node a, Node b) {
        return new Edge(a, b);
    }

    double executePrimAlgorithm() {
        if (nodes.isEmpty()) return 0.0;

        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.weight));
        Set<Node> visitedNodes = new HashSet<>();
        Node startNode = nodes.get(0);
        visitedNodes.add(startNode);
        edgeQueue.addAll(startNode.getAdjacencyList());

        while (!edgeQueue.isEmpty() && visitedNodes.size() < nodes.size()) {
            Edge edge = edgeQueue.remove();
            Node targetNode = edge.target;
            if (!visitedNodes.contains(targetNode)) {
                ink += edge.weight;
                targetNode.visit();
                visitedNodes.add(targetNode);
                edgeQueue.addAll(targetNode.getAdjacencyList());
            }
        }

        return ink;
    }
}

class Edge {
    final double weight;
    final Node target;
    final Node from;

    Edge(Node from, Node target) {
        this.from = from;
        this.target = target;
        this.weight = Math.hypot(from.getX() - target.getX(), from.getY() - target.getY());
    }
}

class SardasSimulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = input.nextInt();
        Graph graph = new Graph();

        for (int i = 0; i < n; i++) {
            double x = input.nextDouble();
            double y = input.nextDouble();
            graph.addNode(new Node(x, y));
        }

        graph.populateGraph();
        double totalInk = graph.executePrimAlgorithm();
        System.out.printf("Total minimum ink required: %.2f%n", totalInk);
    }
}