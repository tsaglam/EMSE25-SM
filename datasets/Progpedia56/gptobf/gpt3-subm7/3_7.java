import java.util.*;

class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        int n = q = in.nextInt();
        matrix = new double[n][n];
        visited = new boolean[n][n];
        dist = new double[n];
        pred = new int[n];
        double[][] coordinates = new double[n][2];

        for (int i = 0; i < n; i++) {
            coordinates[i][0] = in.nextDouble();
            coordinates[i][1] = in.nextDouble();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    double distance = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
                    matrix[j][i] = matrix[i][j] = distance;
                }
            }
        }

        prim(matrix, 0);

        double sum = 0;
        for (double v : dist) {
            sum += v;
        }

        System.out.printf(Locale.US, "%.2f\n", sum);
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        double xDiff = xi - xj;
        double yDiff = yi - yj;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private static void prim(double[][] graph, int no) {
        Arrays.fill(pred, 0);
        Arrays.fill(dist, Double.MAX_VALUE);
        LinkedList<Integer> vertices = new LinkedList<>();

        for (int i = 0; i < q; i++) {
            vertices.add(i);
        }

        dist[no] = 0;

        while (!vertices.isEmpty()) {
            int u = min(vertices);
            vertices.forEach(i -> {
                if (graph[u][i] < dist[i]) {
                    pred[i] = u;
                    dist[i] = graph[u][i];
                }
            });
        }
    }

    private static int min(LinkedList<Integer> graph) {
        double min = Double.MAX_VALUE;
        int index = -1; // Initialize with a placeholder indicating no index found yet

        for (Integer i : graph) {
            if (dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }

        graph.remove(Integer.valueOf(index)); // Unbox index to Integer, ensuring correct removal method is called
        return index;
    }

    // Method kruskall not used, so it can be omitted or implemented if necessary.
}