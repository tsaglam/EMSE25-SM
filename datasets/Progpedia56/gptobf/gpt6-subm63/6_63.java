import java.util.*;

class PointNode {
    double x, y;
    List<DistanceEdge> connections;
    boolean visited;

    PointNode(double x, double y) {
        this.x = x;
        this.y = y;
        this.visited = false;
        this.connections = new ArrayList<>();
    }
    
    void connect(PointNode other) {
        DistanceEdge edge = new DistanceEdge(this, other);
        this.connections.add(edge);
        other.connections.add(edge);
    }
}

class DistanceEdge {
    PointNode from, to;
    double distance;

    DistanceEdge(PointNode from, PointNode to) {
        this.from = from;
        this.to = to;
        this.distance = Math.hypot(from.x - to.x, from.y - to.y);
    }
}

class PointGraph {
    List<PointNode> points;
    double totalDistance;

    PointGraph() {
        this.points = new ArrayList<>();
        this.totalDistance = 0.0;
    }

    void addPoint(double x, double y) {
        PointNode newNode = new PointNode(x, y);
        for (PointNode existingNode : points) {
            newNode.connect(existingNode);
        }
        this.points.add(newNode);
    }

    double calculateMinimumSpanningTree() {
        if (points.isEmpty()) return totalDistance;

        PriorityQueue<DistanceEdge> edgeQueue = new PriorityQueue<>(Comparator.comparingDouble(e -> e.distance));
        PointNode start = points.get(0);
        start.visited = true;
        
        edgeQueue.addAll(start.connections);

        while (!edgeQueue.isEmpty()) {
            DistanceEdge edge = edgeQueue.poll();
            PointNode nextPoint = !edge.to.visited ? edge.to : (!edge.from.visited ? edge.from : null);

            if (nextPoint != null && !nextPoint.visited) {
                totalDistance += edge.distance;
                nextPoint.visited = true;
                for (DistanceEdge nextEdge : nextPoint.connections) {
                    if (!nextEdge.to.visited || !nextEdge.from.visited) {
                        edgeQueue.add(nextEdge);
                    }
                }
            }
        }
        return totalDistance;
    }
}

class GraphApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PointGraph graph = new PointGraph();
        int numberOfPoints = scanner.nextInt();

        while (numberOfPoints-- > 0) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            graph.addPoint(x, y);
        }

        double minimalInkRequired = graph.calculateMinimumSpanningTree();
        System.out.printf("%.2f%n", minimalInkRequired);
    }
}