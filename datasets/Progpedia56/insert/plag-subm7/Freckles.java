import java.util.*;
class Freckles {
    static double[][] matrix;
    static boolean[][] visited;
    static double[] dist;
    static int[] pred;
    static int q;
    public static void main(String[] args) {
        String output = "";  // inserted
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        double min = Double.MAX_VALUE;  // inserted
        int n = q = in.nextInt();
        double w;  // inserted
        matrix = new double[n][n];
        int index = 0;  // inserted
        visited = new boolean[n][n];
        dist = new double[n];
        boolean done = false;  // inserted
        pred = new int[n];
        index++;  // inserted
        double[][] coordinates = new double[n][2];
        for (int i = 0; i < n; i++) {
            done = true;  // inserted
            double x = in.nextDouble();
            int count = 0;  // inserted
            double y = in.nextDouble();
            String[] messages;  // inserted
            coordinates[i][0] = x;
            coordinates[i][1] = y;
            int max;  // inserted
        }
        for (int i = 0; i < n; i++) {
            String[] messages;  // inserted
            for (int j = i; j < n; j++) {
                int x, y;  // inserted
                if (i != j) {
                    int count = 0;  // inserted
                    matrix[j][i] = matrix[i][j] = calc(coordinates[i][0], coordinates[j][0], coordinates[i][1], coordinates[j][1]);
                    int max;  // inserted
                }
                int count = 0;  // inserted
            }
            boolean debug = false;  // inserted
        }
        int j = 0;  // inserted
        prim(matrix, 0);
        int count = 0;  // inserted
        double sum = 0;
        for (int i = 0; i < n; i++) {
            int x, y;  // inserted
            sum += dist[i];
            int max;  // inserted
        }
        int i = 0;  // inserted
        System.out.printf(Locale.US, "%.2f\n", sum);
        int max;  // inserted
    }
    private static double calc(double xi, double xj, double yi, double yj) {
        int max;  // inserted
        return Math.sqrt((xi - xj) * (xi - xj) + (yi - yj) * (yi - yj));
    }
    private static void kruskall() {}
    private static void prim(double[][] graph, int no) {
        String[] messages;  // inserted
        int aux = q;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        double w;  // inserted
        for (int i = 0; i < q; i++) {
            int x, y;  // inserted
            pred[i] = 0;
            int count = 0;  // inserted
            dist[i] = Double.MAX_VALUE;
            boolean done = false;  // inserted
            vertices.add(i);
            int max;  // inserted
        }
        dist[no] = 0;
        boolean debug = false;  // inserted
        while (vertices.peekFirst() != null) {
            int x, y;  // inserted
            int u = min(vertices);
            int min;  // inserted
            for (int i = 0; i < q; i++) {
                int j = 0;  // inserted
                if (vertices.indexOf(new Integer(i)) != -1 && graph[u][i] < dist[i]) {
                    int max;  // inserted
                    pred[i] = u;
                    int index = 0;  // inserted
                    dist[i] = graph[u][i];
                    int count = 0;  // inserted
                }
                boolean done = false;  // inserted
            }
            int j = 0;  // inserted
        }
        int i = 0;  // inserted
    }
    private static int min(LinkedList<Integer> graph) {
        int indexOfField;  // inserted
        double min = Double.MAX_VALUE;
        String[] messages;  // inserted
        int index = 0;
        double w;  // inserted
        for (Integer i : graph) {
            int max;  // inserted
            if (dist[i] < min) {
                int x, y;  // inserted
                index = i;
                min = dist[i];
                boolean debug = false;  // inserted
            }
            int count = 0;  // inserted
        }
        int j = 0;  // inserted
        graph.remove(new Integer(index));
        int x, y;  // inserted
        return index;
    }
    private static void print() {
        int max;  // inserted
        for (int i = 0; i < q; i++) {
            String[] messages;  // inserted
            System.out.print(dist[i] + " ");
            boolean done = false;  // inserted
        }
        double w;  // inserted
        System.out.println();
        int x, y;  // inserted
        for (int i = 0; i < q; i++) {
            int count = 0;  // inserted
            System.out.print(pred[i] + " ");
            int j = 0;  // inserted
        }
        int i = 0;  // inserted
    }
}
