import java.util.*;
import java.io.*;

class Vertex {
    public boolean isVisited;
    public double coordX;
    public double coordY;
    public LinkedList<Connector> connections;
    Vertex(double x, double y) {
        isVisited = false;
        this.coordX = x;
        this.coordY = y;
        connections = new LinkedList<Connector>();
    }
    public void connect(Connector edge) {
        connections.add(edge);
    }
}

class Network {
    public LinkedList<Vertex> vertices;
    public double totalDistance;
    Network() {
        vertices = new LinkedList<Vertex>();
        totalDistance = 0.0;
    }
    public void includeVertex(Vertex vertex) {
        vertices.add(vertex);
    }
    public void initialize() {
        LinkedList<Vertex> queue = new LinkedList<Vertex>();
        queue.addAll(vertices);
        Vertex startingPoint;
        startingPoint = queue.poll();
        while (!queue.isEmpty()) {
            for (Vertex current : queue) {
                startingPoint.connect(establishConnector(startingPoint, current));
                current.connect(establishConnector(current, startingPoint));
            }
            startingPoint = queue.poll();
        }
    }
    public Connector establishConnector(Vertex start, Vertex end) {
        return new Connector(start, end);
    }

    public double computeMST() {
        double minDistance = Double.POSITIVE_INFINITY;
        LinkedList<Vertex> unvisited = new LinkedList<>();
        LinkedList<Connector> potentialEdges = new LinkedList<>();
        
        unvisited.addAll(vertices);
        Vertex currentVertex;
        Connector lightestEdge;
        currentVertex = unvisited.poll();
        currentVertex.isVisited = true;
        
        while (!unvisited.isEmpty()) {
            minDistance = Double.POSITIVE_INFINITY;
            potentialEdges.addAll(currentVertex.connections);
            
            lightestEdge = null;
            for (Connector edge : potentialEdges) {
                if (!edge.destination.isVisited && minDistance > edge.length) {
                    minDistance = edge.length;
                    lightestEdge = edge;
                }
            }
            if (minDistance != Double.POSITIVE_INFINITY) {
                totalDistance += minDistance;
                lightestEdge.destination.isVisited = true;
                currentVertex = unvisited.remove(unvisited.indexOf(lightestEdge.destination));
            }
        }
        return totalDistance;
    }
}

class Connector {
    public double length;
    public Vertex destination;
    public Vertex source;
    Connector(Vertex source, Vertex dest) {
        this.destination = dest;
        this.source = source;
        length = Math.sqrt(Math.pow(source.coordX - dest.coordX, 2) + Math.pow(source.coordY - dest.coordY, 2));
    }
}

class NetworkBuilder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Network network = new Network();
        double xCoord, yCoord;
        double totalInk;
        int vertexCount = scanner.nextInt();
        while (vertexCount > 0) {
            xCoord = scanner.nextDouble();
            yCoord = scanner.nextDouble();
            Vertex newVertex = new Vertex(xCoord, yCoord);
            network.includeVertex(newVertex);
            vertexCount--;
        }
        network.initialize();
        totalInk = network.computeMST();
        System.out.printf("%.2f\n", totalInk);
    }
}