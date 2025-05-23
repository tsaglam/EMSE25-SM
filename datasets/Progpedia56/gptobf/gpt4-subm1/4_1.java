import java.util.*;

class FrecklesArt {

    static int unionRank = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPoints = scanner.nextInt();
        Point[] map = new Point[numPoints];
        for (int i = 0; i < numPoints; i++) {
            map[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }
        createArt(map);
    }

    public static void createArt(Point[] points) {
        int partitions = points.length;
        PriorityQueue<Link> edges = new PriorityQueue<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++)
                edges.add(new Link(i, j, points[i].calculateDistance(points[j])));
        }
        
        double totalDistance = 0;
        while (!edges.isEmpty() && partitions > 1) {
            Link closestLink = edges.poll();
            Point root1 = findRoot(points[closestLink.pointA]);
            Point root2 = findRoot(points[closestLink.pointB]);
            
            if (root1 != root2) {
                root1.union(root2);
                partitions--;
                totalDistance += closestLink.distance;
            }
        }
        
        System.out.printf("%.2f%n", totalDistance);
    }
    
    public static Point findRoot(Point point) {
        if (point.parent != point) {
            unionRank++;
            point.parent = findRoot(point.parent);
        }
        return point.parent;
    }

    static class Point {
        Point parent;
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
            this.parent = this;
        }

        double calculateDistance(Point other) {
            double dx = Math.abs(this.x - other.x);
            double dy = Math.abs(this.y - other.y);
            return Math.sqrt(dx * dx + dy * dy);
        }

        void union(Point root) {
            root.parent = this;
        }
    }

    static class Link implements Comparable<Link> {
        int pointA, pointB;
        double distance;

        Link(int pointA, int pointB, double distance) {
            this.pointA = pointA;
            this.pointB = pointB;
            this.distance = distance;
        }

        @Override
        public int compareTo(Link other) {
            return Double.compare(this.distance, other.distance);
        }
    }
}