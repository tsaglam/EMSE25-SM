import java.util.Scanner;
import java.util.Arrays;

class Freckles {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        double distance(Point p) {
            return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        System.out.printf("%.2f\n", prim(points, N));
    }

    static double prim(Point[] points, int N) {
        boolean[] added = new boolean[N]; // Tracks if a point is already added to MST
        double[] distance = new double[N]; // Distance of points from the MST
        Arrays.fill(distance, Double.MAX_VALUE); // Initialize distances with infinity
        distance[0] = 0; // Starting point for Prim's algorithm

        double minCost = 0;

        for (int i = 0; i < N; i++) {
            int nearest = -1;
            double nearestDistance = Double.MAX_VALUE;

            // Find the nearest unadded point
            for (int j = 0; j < N; j++) {
                if (!added[j] && distance[j] < nearestDistance) {
                    nearest = j;
                    nearestDistance = distance[j];
                }
            }

            // Add the nearest point to the MST
            added[nearest] = true;
            minCost += nearestDistance;

            // Update distances to the MST for the rest of the points
            for (int j = 0; j < N; j++) {
                double dist = points[nearest].distance(points[j]);
                if (!added[j] && dist < distance[j]) {
                    distance[j] = dist;
                }
            }
        }

        return minCost;
    }
}