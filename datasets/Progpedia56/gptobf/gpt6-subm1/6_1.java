import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

class FreckleArt {
    static class Point {
        double x, y;
        Point parent;
        int rank;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.parent = this; // Initially, each point is its own parent (root of its tree)
            this.rank = 0;
        }

        // Find the root parent of the point, also implements path compression
        Point find() {
            if (parent != this)
                parent = parent.find();
            return parent;
        }

        // Union by rank optimization
        void union(Point root) {
            if (root.rank < this.rank) {
                root.parent = this;
            } else if (root.rank > this.rank) {
                this.parent = root;
            } else {
                this.parent = root;
                root.rank++;
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        Point src, dest;
        double weight;

        Edge(Point src, Point dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }

        System.out.printf("%.2f\n", computeMST(points));
    }

    private static double computeMST(Point[] points) {
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = Math.hypot(points[i].x - points[j].x, points[i].y - points[j].y);
                edgeQueue.add(new Edge(points[i], points[j], distance));
            }
        }

        double totalWeight = 0;
        while (!edgeQueue.isEmpty()) {
            Edge edge = edgeQueue.poll();
            Point rootSrc = edge.src.find();
            Point rootDest = edge.dest.find();

            if (rootSrc != rootDest) {
                totalWeight += edge.weight;
                rootSrc.union(rootDest);
            }
        }
        return totalWeight;
    }
}