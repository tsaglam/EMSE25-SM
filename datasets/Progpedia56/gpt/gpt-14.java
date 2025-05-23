import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Freckles {

    // Class to represent a point (freckle) in 2D space
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    // Function to calculate Euclidean distance between two points
    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    // Function to find the minimum amount of ink required to connect all freckles
    private static double minInk(List<Point> freckles) {
        int n = freckles.size();
        boolean[] visited = new boolean[n]; // To mark visited nodes (freckles)
        double[] key = new double[n]; // Storing minimum weight(edge) to connect to MST
        
        // Initialize keys as infinite
        for (int i = 0; i < n; i++) {
            key[i] = Double.MAX_VALUE;
        }
        
        // Start from first freckle
        key[0] = 0;
        
        for (int count = 0; count < n - 1; count++) {
            // Find the unvisited node with the smallest key
            int u = -1;
            double min = Double.MAX_VALUE;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && key[v] < min) {
                    min = key[v];
                    u = v;
                }
            }
            
            // Mark the chosen vertex as visited
            visited[u] = true;
            
            // Update key value of the adjacent vertices of the chosen vertex
            for (int v = 0; v < n; v++) {
                double dist = distance(freckles.get(u), freckles.get(v));
                if (!visited[v] && dist < key[v]) {
                    key[v] = dist;
                }
            }
        }
        
        // Calculate total weight of MST
        double totalInk = 0;
        for (double d : key) {
            totalInk += d;
        }
        return totalInk;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of freckles
        List<Point> freckles = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            double x = scanner.nextDouble();
            double y = scanner.nextDouble();
            freckles.add(new Point(x, y));
        }
        
        double result = minInk(freckles);
        System.out.printf("%.2f\n", result);
        
        scanner.close();
    }
}