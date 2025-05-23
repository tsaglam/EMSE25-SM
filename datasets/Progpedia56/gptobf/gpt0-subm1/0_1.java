import java.util.*;

class FreckleArt {
    static int unionRank = 0;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int numPoints = inputScanner.nextInt();
        Point[] constellation = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            constellation[i] = new Point(inputScanner.nextDouble(), inputScanner.nextDouble());
        }
        inkConstellation(constellation, numPoints);
    }

    private static void inkConstellation(Point[] points, int count) {
        int clusters = count;
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>();
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {
                edgeQueue.add(new Edge(i, j, calculateDistance(points[i], points[j])));
            }
        }
        double inkUsed = 0.0;
        while (!edgeQueue.isEmpty() && clusters > 1) {
            Edge shortest = edgeQueue.poll();
            Point rootA = findRoot(points[shortest.pointA]);
            Point rootB = findRoot(points[shortest.pointB]);
            if (rootA != rootB) {
                if (unionRank > unionRank)
                    rootA.mergeRoots(rootB);
                else
                    rootB.mergeRoots(rootA);
                clusters--;
                inkUsed += shortest.distance;
            }
        }
        System.out.printf("%.2f%n", inkUsed);
    }

    private static Point findRoot(Point point) {
        unionRank = 0;
        return point.getRoot();
    }

    private static double calculateDistance(Point a, Point b) {
        double deltaX = a.x - b.x;
        double deltaY = a.y - b.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    static class Point {
        private Point parent;
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.parent = this;
        }

        Point getRoot() {
            if (parent != this) {
                unionRank++;
                parent = parent.getRoot();
            }
            return parent;
        }

        void mergeRoots(Point root) {
            root.parent = this;
        }
    }

    static class Edge implements Comparable<Edge> {
        int pointA, pointB;
        double distance;

        Edge(int pointA, int pointB, double distance) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge other) {
            return Double.compare(this.distance, other.distance);
        }

        @Override
        public String toString() {
            return String.format("(%d,%d,%.2f)", pointA, pointB, distance);
        }
    }
}