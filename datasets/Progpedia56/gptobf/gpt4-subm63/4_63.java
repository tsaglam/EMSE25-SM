import java.util.ArrayList;
import java.util.Scanner;

class Vertex {
    boolean marked;
    double xCoord;
    double yCoord;
    ArrayList<Connection> connections;

    Vertex(double x, double y) {
        marked = false;
        this.xCoord = x;
        this.yCoord = y;
        connections = new ArrayList<>();
    }

    void connect(Connection edge) {
        connections.add(edge);
    }
}

class Network {
    ArrayList<Vertex> vertices;
    double totalInk;

    Network() {
        vertices = new ArrayList<>();
        totalInk = 0.0;
    }

    void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    void build() {
        ArrayList<Vertex> queue = new ArrayList<>(vertices);
        while (!queue.isEmpty()) {
            Vertex current = queue.remove(0);
            for (Vertex v : queue) {
                current.connect(createConnection(current, v));
                v.connect(createConnection(v, current));
            }
        }
    }

    Connection createConnection(Vertex start, Vertex end) {
        return new Connection(start, end);
    }

    double executePrim() {
        if (vertices.isEmpty()) return totalInk;
        ArrayList<Vertex> unvisited = new ArrayList<>(vertices);
        ArrayList<Connection> availableEdges = new ArrayList<>();
        Vertex current = unvisited.remove(0);
        current.marked = true;

        while (!unvisited.isEmpty()) {
            double smallest = Double.POSITIVE_INFINITY;
            Connection selectedEdge = null;
            availableEdges.clear();
            availableEdges.addAll(current.connections);
            for (int i = 0; i < availableEdges.size(); i++) {
                Connection edge = availableEdges.get(i);
                if (!edge.destination.marked && edge.distance < smallest) {
                    smallest = edge.distance;
                    selectedEdge = edge;
                }
            }
            if (selectedEdge != null) {
                totalInk += smallest;
                selectedEdge.destination.marked = true;
                current = unvisited.remove(unvisited.indexOf(selectedEdge.destination));
            }
        }
        return totalInk;
    }
}

class Connection {
    double distance;
    Vertex destination;
    Vertex source;

    Connection(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
        distance = Math.sqrt(Math.pow(source.xCoord - destination.xCoord, 2) + Math.pow(source.yCoord - destination.yCoord, 2));
    }
}

class SimplifiedNetwork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Network network = new Network();
        int pointsCount = scanner.nextInt();
        while (pointsCount-- > 0) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            Vertex vertex = new Vertex(x, y);
            network.addVertex(vertex);
        }
        network.build();
        double requiredInk = network.executePrim();
        System.out.printf("%.2f\n", requiredInk);
    }
}