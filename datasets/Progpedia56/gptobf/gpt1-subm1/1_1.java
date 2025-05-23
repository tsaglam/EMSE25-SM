import java.util.PriorityQueue;
import java.util.Scanner;

class Freckles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }
        System.out.format("%.2f\n", calcMinimumInk(points));
    }

    public static double calcMinimumInk(Point[] points) {
        double totalInk = 0;
        int groups = points.length;
        PriorityQueue<Edge> edges = initEdges(points);
        
        while (!edges.isEmpty() && groups > 1) {
            Edge edge = edges.poll();
            Point rootA = points[edge.a].findRoot();
            Point rootB = points[edge.b].findRoot();

            if (rootA != rootB) {
                rootA.union(rootB);
                groups--;
                totalInk += edge.distance;
            }
        }
        return totalInk;
    }

    private static PriorityQueue<Edge> initEdges(Point[] points) {
        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, points[i].distanceTo(points[j])));
            }
        }
        return edges;
    }
}

class Point {
    Point parent = this;
    double x, y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point findRoot() {
        if (parent != this) {
            parent = parent.findRoot();
        }
        return parent;
    }

    void union(Point that) {
        that.findRoot().parent = this;
    }

    double distanceTo(Point that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Edge implements Comparable<Edge> {
    int a, b;
    double distance;

    Edge(int a, int b, double distance) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}