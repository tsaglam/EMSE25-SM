import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

class SpeckledMap {

    static double[][] edgeWeights;
    static boolean[][] markedEdges;
    static double[] minimumDistances;
    static int[] predecessors;
    static int vertexCount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        vertexCount = scanner.nextInt();
        edgeWeights = new double[vertexCount][vertexCount];
        markedEdges = new boolean[vertexCount][vertexCount];
        minimumDistances = new double[vertexCount];
        predecessors = new int[vertexCount];
        double[][] points = new double[vertexCount][2];

        // Input all points
        for (int i = 0; i < vertexCount; i++) {
            points[i][0] = scanner.nextDouble(); // x-coordinate
            points[i][1] = scanner.nextDouble(); // y-coordinate
        }

        // Calculate distances between all pairs of points
        for (int i = 0; i < vertexCount; i++) {
            for (int j = i; j < vertexCount; j++) {
                if (i != j) {
                    double distance = calculateDistance(points[i][0], points[j][0], points[i][1], points[j][1]);
                    edgeWeights[i][j] = edgeWeights[j][i] = distance;
                }
            }
        }

        // Applying Prim's algorithm
        applyPrimAlgorithm(edgeWeights, 0);

        // Calculating the sum of minimum distances
        double totalDistance = 0;
        for (double distance : minimumDistances) {
            totalDistance += distance;
        }

        System.out.printf(Locale.US, "%.2f\n", totalDistance);
        scanner.close();
    }

    private static double calculateDistance(double x1, double x2, double y1, double y2) {
        return Math.hypot(x1 - x2, y1 - y2);
    }

    private static void applyPrimAlgorithm(double[][] graph, int startVertex) {
        LinkedList<Integer> vertexQueue = new LinkedList<>();
        minimumDistances = new double[vertexCount];
        predecessors = new int[vertexCount];
        
        for (int i = 0; i < vertexCount; i++) {
            minimumDistances[i] = Double.MAX_VALUE;
            vertexQueue.add(i);
        }
        
        minimumDistances[startVertex] = 0;
        
        while (!vertexQueue.isEmpty()) {
            int currentVertex = extractMin(vertexQueue);
            for (int v = 0; v < vertexCount; v++) {
                if (vertexQueue.contains(v) && graph[currentVertex][v] < minimumDistances[v]) {
                    predecessors[v] = currentVertex;
                    minimumDistances[v] = graph[currentVertex][v];
                }
            }
        }
    }

    private static int extractMin(LinkedList<Integer> queue) {
        int vertexWithMinDistance = queue.getFirst();
        double minDistance = Double.MAX_VALUE;
        
        for (int vertex : queue) {
            if (minimumDistances[vertex] < minDistance) {
                minDistance = minimumDistances[vertex];
                vertexWithMinDistance = vertex;
            }
        }
        queue.remove(Integer.valueOf(vertexWithMinDistance));
        return vertexWithMinDistance;
    }
}