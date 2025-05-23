import java.util.*;
import java.io.*;

class Node {
    boolean visited;
    double x, y;
    List<Edge> adjacencyList;

    Node(double x, double y) {
        this.visited = false;
        this.x = x;
        this.y = y;
        this.adjacencyList = new LinkedList<>();
    }

    void addEdge(Edge edge) {
        adjacencyList.add(edge);
    }
}

class Graph {
    List<Node> nodes;
    double totalInkUsed;

    Graph() {
        nodes = new LinkedList<>();
        totalInkUsed = 0.0;
    }

    void addNode(Node node) {
        nodes.add(node);
    }

    void buildGraph() {
        for (int i = 0; i < nodes.size(); i++) {
            Node parentNode = nodes.get(i);
            for (int j = 0; j < nodes.size(); j++) {
                if (i != j) {
                    Node childNode = nodes.get(j);
                    Edge edge = new Edge(parentNode, childNode);
                    parentNode.addEdge(edge);
                }
            }
        }
    }

    double calculateMinimumInk() {
        if (nodes.isEmpty()) return totalInkUsed;
        
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(edge -> edge.weight));
        Node startNode = nodes.get(0);
        startNode.visited = true;

        priorityQueue.addAll(startNode.adjacencyList);

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!edge.target.visited) {
                edge.target.visited = true;
                totalInkUsed += edge.weight;
                priorityQueue.addAll(edge.target.adjacencyList);
            }
        }
        
        return totalInkUsed;
    }
}

class Edge {
    double weight;
    Node target, from;

    Edge(Node from, Node target) {
        this.from = from;
        this.target = target;
        this.weight = Math.sqrt(Math.pow(from.x - target.x, 2) + Math.pow(from.y - target.y, 2));
    }
}

class Sardas {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph graph = new Graph();
        int numberOfNodes = input.nextInt();
        while (numberOfNodes > 0) {
            double x = input.nextDouble();
            double y = input.nextDouble();
            Node node = new Node(x, y);
            graph.addNode(node);
            numberOfNodes--;
        }
        graph.buildGraph();
        double totalInk = graph.calculateMinimumInk();
        System.out.printf("%.2f%n", totalInk);
    }
}