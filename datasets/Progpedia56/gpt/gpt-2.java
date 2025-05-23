import java.util.Scanner;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;

class Freckles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Number of freckles

        Point2D.Double[] freckles = new Point2D.Double[N];
        
        // Reading freckle positions
        for (int i = 0; i < N; i++) {
            freckles[i] = new Point2D.Double(scanner.nextDouble(), scanner.nextDouble());
        }

        double result = calculateMinInk(freckles);
        System.out.println(new DecimalFormat("#.00").format(result));
    }

    private static double calculateMinInk(Point2D.Double[] freckles) {
        boolean[] visited = new boolean[freckles.length]; // Tracks visited freckles
        double[] minWeight = new double[freckles.length];

        for (int i = 0; i < freckles.length; i++) {
            minWeight[i] = Double.MAX_VALUE;
        }

        minWeight[0] = 0; // Starting from the first freckle
        double minInkUsed = 0;

        for (int i = 0; i < freckles.length; i++) {
            int closestFreckle = -1;
            double closestDistance = Double.MAX_VALUE;

            // Find the closest, unvisited freckle
            for (int j = 0; j < freckles.length; j++) {
                if (!visited[j] && minWeight[j] < closestDistance) {
                    closestDistance = minWeight[j];
                    closestFreckle = j;
                }
            }

            // Mark the closest freckle as visited
            visited[closestFreckle] = true;
            minInkUsed += closestDistance;

            // Update the distances to other freckles
            for (int j = 0; j < freckles.length; j++) {
                if (!visited[j]) {
                    double distance = freckles[closestFreckle].distance(freckles[j]);
                    if (distance < minWeight[j]) {
                        minWeight[j] = distance;
                    }
                }
            }
        }

        return minInkUsed;
    }
}