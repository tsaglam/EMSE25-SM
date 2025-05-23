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
        dist = new double[n];
        pred = new int[n];
        visited = new boolean[n][n];
        double[][] coordinates = new double[n][2];
        for (int i = 0; i < n; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();
            coordinates[i][0] = x;
            coordinates[i][1] = y;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) {
                    matrix[i][j] = matrix[j][i] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
                }
            }
        }
        prim(matrix, 0);
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += dist[i];
        }
        System.out.printf(Locale.US, "%.2f\n", sum);
    }
    private static double calc(double xi, double xj, double yi, double yj) {
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }
    private static void prim(double[][] graph, int no) {
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        for (int i = 0; i < q; i++) {
            dist[i] = Double.MAX_VALUE;
            pred[i] = 0;
            vertices.add(i);
        }
        dist[no] = 0;
        while (!vertices.isEmpty()) {
            int u = min(vertices);
            for (int i = 0; i < q; i++) {
                if (graph[u][i] < dist[i] && vertices.indexOf(i) != -1) {
                    dist[i] = graph[u][i];
                    pred[i] = u;
                }
            }
        }
    }
    private static int min(LinkedList<Integer> graph) {
        double min = Double.MAX_VALUE;
        int index = -1;
        for (Integer i : graph) {
            if (dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        graph.remove(new Integer(index));
        return index;
    }
    private static void kruskall() {}
    private static void print() {
        for (int i = 0; i < q; i++) {
            System.out.print(pred[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < q; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}