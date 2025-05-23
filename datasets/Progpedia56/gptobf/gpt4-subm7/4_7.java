import java.util.*;

class Freckles {
    static double[][] adjMatrix;
    static double[] closestDist;
    static int[] closestVertex;
    static int vertexCount;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int n = vertexCount = scanner.nextInt();
        adjMatrix = new double[n][n];
        closestDist = new double[n];
        closestVertex = new int[n];
        double[][] points = new double[n][2];
        
        // Reading points coordinates
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextDouble(); // x-coordinate
            points[i][1] = scanner.nextDouble(); // y-coordinate
        }
        
        // Calculating distances
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(points[i], points[j]);
                adjMatrix[i][j] = adjMatrix[j][i] = distance;
            }
        }
        
        // Executing Prim's Algorithm
        prim(0);
        
        // Calculating total minimum spanning tree weight
        double totalWeight = 0;
        for (double dist : closestDist) {
            totalWeight += dist;
        }
        System.out.printf(Locale.US, "%.2f\n", totalWeight);
    }
    
    private static double calculateDistance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
    }
    
    private static void prim(int startVertex) {
        boolean[] included = new boolean[vertexCount];
        Arrays.fill(closestDist, Double.MAX_VALUE);
        closestDist[startVertex] = 0;
        
        for (int count = 0; count < vertexCount - 1; count++) {
            int u = findMinimumDistance(included);
            included[u] = true;
            
            for (int v = 0; v < vertexCount; v++) {
                if (!included[v] && adjMatrix[u][v] < closestDist[v] && adjMatrix[u][v] != 0) {
                    closestVertex[v] = u;
                    closestDist[v] = adjMatrix[u][v];
                }
            }
        }
    }
    
    private static int findMinimumDistance(boolean[] included) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;
        
        for (int i = 0; i < vertexCount; i++) {
            if (!included[i] && closestDist[i] < min) {
                min = closestDist[i];
                minIndex = i;
            }
        }
        
        return minIndex;
    }
}