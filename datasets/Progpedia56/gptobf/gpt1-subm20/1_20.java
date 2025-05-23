import java.util.*;
import java.lang.Math;

class Point {
    double x, y;
    int parentIndex;
    Point(double x, double y, int parentIndex) {
        this.x = x;
        this.y = y;
        this.parentIndex = parentIndex;
    }
}

class UnionFind {
    private int[] parent;

    UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }
}

class Edge implements Comparable<Edge> {
    Point startPoint, endPoint;
    double distance;

    Edge(Point a, Point b) {
        this.startPoint = a;
        this.endPoint = b;
        this.distance = Math.hypot(b.x - a.x, b.y - a.y);
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}

class KruskalAlgorithm {
    public static double kruskalMinimumSpanningTree(List<Point> points) {
        List<Edge> edges = new ArrayList<>();
        UnionFind unionFind = new UnionFind(points.size());

        // Create all possible edges
        for (int i = 0; i < points.size(); i++) {
            for (int j = i + 1; j < points.size(); j++) {
                edges.add(new Edge(points.get(i), points.get(j)));
            }
        }
        Collections.sort(edges);

        double totalDistance = 0.0;
        for (Edge edge : edges) {
            int root1 = unionFind.find(edge.startPoint.parentIndex);
            int root2 = unionFind.find(edge.endPoint.parentIndex);

            if (root1 != root2) {
                totalDistance += edge.distance;
                unionFind.union(root1, root2);
            }
        }

        return totalDistance;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfPoints = input.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numberOfPoints; i++) {
            points.add(new Point(input.nextDouble(), input.nextDouble(), i));
        }

        double result = kruskalMinimumSpanningTree(points);
        System.out.printf("%.2f\n", result);
    }
}