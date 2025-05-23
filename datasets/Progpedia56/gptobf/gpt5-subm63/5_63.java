import java.util.*;
import java.io.*;

class Vertex {
    boolean marked;
    double posX, posY;
    ArrayList<Link> connections;

    public Vertex(double posX, double posY) {
        this.marked = false;
        this.posX = posX;
        this.posY = posY;
        connections = new ArrayList<>();
    }

    void connect(Link link) {
        connections.add(link);
    }
}

class Network {
    ArrayList<Vertex> vertices;
    double totalInk;

    public Network() {
        vertices = new ArrayList<>();
        totalInk = 0;
    }

    void insertVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    void structure() {
        ArrayList<Vertex> tempVertices = new ArrayList<>(vertices);
        Vertex current;

        while (!tempVertices.isEmpty()) {
            current = tempVertices.remove(0);
            for (Vertex vertex : tempVertices) {
                Link forward = new Link(current, vertex);
                Link reverse = new Link(vertex, current);
                current.connect(forward);
                vertex.connect(reverse);
            }
        }
    }

    Link createLink(Vertex start, Vertex end) {
        return new Link(start, end);
    }

    double executePrim() {
        PriorityQueue<Link> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(l -> l.distance));
        Vertex current = vertices.get(0);
        current.marked = true;

        while (vertices.stream().anyMatch(vertex -> !vertex.marked)) {
            for (Link link : current.connections) {
                if (!link.destination.marked) {
                    priorityQueue.add(link);
                }
            }

            while (!priorityQueue.isEmpty() && priorityQueue.peek().destination.marked) {
                priorityQueue.poll();
            }

            if (!priorityQueue.isEmpty()) {
                Link nextLink = priorityQueue.poll();
                totalInk += nextLink.distance;
                nextLink.destination.marked = true;
                current = nextLink.destination;
            }
        }
        return totalInk;
    }
}

class Link {
    double distance;
    Vertex destination;
    Vertex source;

    public Link(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        distance = Math.hypot(source.posX - destination.posX, source.posY - destination.posY);
    }
}

class NetworkPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Network network = new Network();
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Vertex newVertex = new Vertex(x, y);
            network.insertVertex(newVertex);
        }

        network.structure();
        double requiredInk = network.executePrim();
        System.out.printf(Locale.US, "%.2f\n", requiredInk);
    }
}