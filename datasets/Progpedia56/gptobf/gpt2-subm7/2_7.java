import java.util.*;

class Freckles {

    private static double[][] graph;
    private static double[] minEdgeWeight;
    private static int[] pred;
    private static boolean[] inMST;
    private static int n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        n = in.nextInt();
        graph = new double[n][n];
        minEdgeWeight = new double[n];
        pred = new int[n];
        inMST = new boolean[n];

        double[][] points = new double[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = in.nextDouble();
            points[i][1] = in.nextDouble();
        }

        buildGraph(points);
        prim();

        System.out.printf(Locale.US, "%.2f\n", sumOfEdges());
    }

    private static void buildGraph(double[][] points) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = calculateDistance(points[i], points[j]);
                graph[i][j] = distance;
                graph[j][i] = distance;
            }
        }
    }

    private static double calculateDistance(double[] p1, double[] p2) {
        return Math.sqrt(Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
    }

    private static void prim() {
        Arrays.fill(minEdgeWeight, Double.MAX_VALUE);
        minEdgeWeight[0] = 0;
        pred[0] = -1;

        for (int count = 0; count < n - 1; count++) {
            int u = -1;
            double minDistance = Double.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!inMST[i] && minEdgeWeight[i] < minDistance) {
                    u = i;
                    minDistance = minEdgeWeight[i];
                }
            }

            inMST[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < minEdgeWeight[v]) {
                    pred[v] = u;
                    minEdgeWeight[v] = graph[u][v];
                }
            }
        }
    }

    private static double sumOfEdges() {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += minEdgeWeight[i];
        }
        return sum;
    }
}