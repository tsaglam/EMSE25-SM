import java.util.Scanner;

class Freckles {
    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of freckles
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }

        System.out.printf("%.2f\n", minimumInk(points));
    }

    private static double distance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }

    private static double minimumInk(Point[] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        double[] minDistance = new double[n];

        // Initialize distances as infinite (or very high value)
        for (int i = 0; i < n; i++) {
            minDistance[i] = Double.MAX_VALUE;
        }

        // Distance to the first point is 0 to make it the initial point
        minDistance[0] = 0;
        double totalInk = 0;

        for (int i = 0; i < n; i++) {
            // Find the unvisited point with the smallest distance
            int closest = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (closest == -1 || minDistance[j] < minDistance[closest])) {
                    closest = j;
                }
            }

            // Mark this point as visited
            visited[closest] = true;
            totalInk += minDistance[closest];

            // Update distances to this point
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    double distance = distance(points[closest], points[j]);
                    if (distance < minDistance[j]) {
                        minDistance[j] = distance;
                    }
                }
            }
        }

        return totalInk;
    }
}