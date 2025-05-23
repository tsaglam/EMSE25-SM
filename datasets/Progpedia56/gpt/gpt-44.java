import java.util.Scanner;
import java.util.Arrays;

class Freckles {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of freckles
        
        Point[] points = new Point[n]; // Stores the coordinates of freckles

        // Reading coordinates
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            points[i] = new Point(x, y);
        }

        System.out.printf("%.2f\n", calculateMinimumInk(points));
    }

    private static double calculateMinimumInk(Point[] points) {
        int n = points.length;
        double[] minWeight = new double[n];
        boolean[] added = new boolean[n];
        Arrays.fill(minWeight, Double.MAX_VALUE);
        minWeight[0] = 0; // Start with the first freckle
        
        double minInk = 0;
        
        for (int i = 0; i < n; i++) {
            int closest = -1;
            double closestDist = Double.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (!added[j] && minWeight[j] < closestDist) {
                    closestDist = minWeight[j];
                    closest = j;
                }
            }
            
            if (closest == -1) break; // Shouldn't happen if the input graph is connected
            
            added[closest] = true;
            minInk += closestDist;
            
            for (int j = 0; j < n; j++) {
                if (!added[j]) {
                    double dist = distance(points[closest], points[j]);
                    if (dist < minWeight[j]) {
                        minWeight[j] = dist;
                    }
                }
            }
        }
        
        return minInk;
    }

    private static double distance(Point p1, Point p2) {
        double dx = p1.x - p2.x;
        double dy = p1.y - p2.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}