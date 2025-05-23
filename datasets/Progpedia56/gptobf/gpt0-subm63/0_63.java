import java.util.LinkedList;
import java.util.Scanner;

class LocationNode {
    double x, y;
    boolean visited = false;
    LinkedList<ConnectionEdge> connections = new LinkedList<>();

    LocationNode(double x, double y) {
        this.x = x;
        this.y = y;
    }

    void connect(LocationNode other) {
        ConnectionEdge edge = new ConnectionEdge(this, other);
        this.connections.add(edge);
        other.connections.add(new ConnectionEdge(other, this));
    }
}

class ConnectionEdge {
    LocationNode source, target;
    double distance;

    ConnectionEdge(LocationNode from, LocationNode to) {
        this.source = from;
        this.target = to;
        this.distance = Math.hypot(from.x - to.x, from.y - to.y); // More direct way to calculate Euclidean distance.
    }
}

class MapGraph {
    LinkedList<LocationNode> locations = new LinkedList<>();
    double totalDistance = 0.0;

    void addLocation(double x, double y) {
        LocationNode newNode = new LocationNode(x, y);
        locations.add(newNode);
    }

    void createConnections() {
        LinkedList<LocationNode> queue = new LinkedList<>(locations);
        while (!queue.isEmpty()) {
            LocationNode current = queue.poll();
            queue.forEach(other -> current.connect(other));
        }
    }

    double executePrim() {
        LinkedList<LocationNode> unvisited = new LinkedList<>(locations);
        LocationNode startNode = unvisited.poll();
        assert startNode != null;
        startNode.visited = true;

        while (!unvisited.isEmpty()) {
            ConnectionEdge shortestEdge = null;
            double shortestDistance = Double.POSITIVE_INFINITY;

            for (LocationNode from : locations) {
                if (from.visited) {
                    for (ConnectionEdge e : from.connections) {
                        if (!e.target.visited && e.distance < shortestDistance) {
                            shortestDistance = e.distance;
                            shortestEdge = e;
                        }
                    }
                }
            }

            if (shortestEdge != null) {
                shortestEdge.target.visited = true;
                unvisited.remove(shortestEdge.target);
                totalDistance += shortestDistance;
            }
        }
        return totalDistance;
    }
}

class SimplifiedSardas {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) { // Try-with-resources for Scanner to ensure it is closed properly.
            MapGraph graph = new MapGraph();
            int nodesCount = input.nextInt();

            for (int i = 0; i < nodesCount; i++) {
                double x = input.nextDouble();
                double y = input.nextDouble();
                graph.addLocation(x, y);
            }

            graph.createConnections();
            double inkRequired = graph.executePrim();
            System.out.printf("%.2f\n", inkRequired);
        }
    }
}