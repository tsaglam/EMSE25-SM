import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int vertexCount;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = vertexCount = in.nextInt();
        matrix = new double[n][n];
        visited = new boolean[n][n];
        dist = new double[n];
        Arrays.fill(dist, Double.MAX_VALUE);
        pred = new int[n];
        double[][] coordinates = new double[n][2];
        
        for (int i = 0; i < n; i++) {
            coordinates[i] = new double[] {in.nextDouble(), in.nextDouble()};
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = matrix[j][i] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
            }
        }
        
        implementPrimAlgorithm(matrix, 0);
        
        double sum = Arrays.stream(dist).sum();
        System.out.printf(Locale.US, "%.2f\n", sum);
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        double deltaX = xi - xj;
        double deltaY = yi - yj;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    private static void implementPrimAlgorithm(double[][] graph, int sourceVertex) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingDouble(node -> dist[node]));
        dist[sourceVertex] = 0;
        queue.add(sourceVertex);
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v = 0; v < vertexCount; v++) {
                if (graph[u][v] != 0 && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = graph[u][v];
                    pred[v] = u;
                    queue.add(v);
                }
            }
        }
    }
}