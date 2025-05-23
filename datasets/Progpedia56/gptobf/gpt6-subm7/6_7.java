import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Locale;

class FreckleConnector {
    static final int INF = Integer.MAX_VALUE;
    static class Edge implements Comparable<Edge> {
        int target;
        double weight;
        Edge(int target, double weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int n = scanner.nextInt(); // Number of freckles
        Point[] points = new Point[n];

        // Reading points (freckles) coordinates
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        System.out.printf(Locale.US, "%.2f\n", computeMSTCost(points));
    }

    static double computeMSTCost(Point[] points) {
        int n = points.length;
        boolean[] visited = new boolean[n]; // To track visited vertices
        double[] key = new double[n]; // Key values used to pick minimum weight edge in cut
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // Initialize all keys as infinite
        for (int i = 0; i < n; i++) {
            key[i] = Double.MAX_VALUE;
        }

        // Always start from first point
        key[0] = 0.0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.target;
            if (visited[u]) {
                continue;
            }
            visited[u] = true; // Include vertex in MST

            for (int v = 0; v < n; v++) {
                double weight = distance(points[u], points[v]);
                // If v is not in MST and weight of (u,v) is smaller than current key of v
                if (!visited[v] && weight < key[v] && v != u) {
                    key[v] = weight;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        double sum = 0;
        for (double value : key) {
            sum += value;
        }
        return sum;
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    static class Point {
        public double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}