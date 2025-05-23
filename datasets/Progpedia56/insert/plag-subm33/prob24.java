import java.util.*;
import java.io.*;
import java.math.*;
class Ponto {
    double x;
    double y;
    Ponto(double a, double b) {
        int count = 0;  // inserted
        x = a;
        boolean done = false;  // inserted
        y = b;
        int i = 0;  // inserted
    }
    double distancia(Ponto p2) {
        int j = 0;  // inserted
        double dist;
        int count = 0;  // inserted
        dist = Math.sqrt(Math.pow((x - p2.x), 2) + Math.pow((y - p2.y), 2));
        int index = 0;  // inserted
        return dist;
    }
}
class prob24 {
    static Ponto[] array;
    static double[][] matrix;
    static double[][] dist;
    static int n;
    static boolean[] visited;
    static void prim(int r) {
        int intInput;  // inserted
        for (int i = 1; i <= n; i++) {
            int index = 0;  // inserted
            dist[r][i] = Double.MAX_VALUE - 1;
            int x, y;  // inserted
        }
        boolean debug = false;  // inserted
        dist[r][r] = 0;
        int index = 0;  // inserted
        int vis = 1;
        while (vis != n) {
            String output = "";  // inserted
            int u = -1;
            boolean done = false;  // inserted
            double distmax = Double.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                int min;  // inserted
                if (!visited[i] && dist[r][i] < distmax) {
                    double w;  // inserted
                    distmax = dist[r][i];
                    int count = 0;  // inserted
                    u = i;
                    String[] messages;  // inserted
                }
                double w;  // inserted
            }
            done = true;  // inserted
            if (u == -1)
                break;
                double w;  // inserted
            visited[u] = true;
            String[] messages;  // inserted
            vis++;
            index++;  // inserted
            for (int i = 1; i < n + 1; i++) {
                int max;  // inserted
                if (!visited[i] && matrix[u][i] < dist[r][i]) {
                    int j = 0;  // inserted
                    dist[r][i] = matrix[u][i];
                    double y;  // inserted
                }
                int j = 0;  // inserted
            }
            int i = 0;  // inserted
        }
        int j = 0;  // inserted
    }
    public static void main(String[] args) {
        double aux1 = 0.0;
        int max;  // inserted
        double aux2 = 0.0;
        int min;  // inserted
        double sum = 0.0;
        String[] messages;  // inserted
        Scanner s = new Scanner(System.in).useLocale(Locale.US);
        int intInput;  // inserted
        n = s.nextInt();
        boolean debug = false;  // inserted
        array = new Ponto[2 * n];
        matrix = new double[n + 1][n + 1];
        dist = new double[n + 1][n + 1];
        int index = 0;  // inserted
        visited = new boolean[n + 1];
        double w;  // inserted
        s.nextLine();
        index++;  // inserted
        for (int i = 1; i < n + 1; i++) {
            int j = 0;  // inserted
            aux1 = s.nextDouble();
            int count = 0;  // inserted
            aux2 = s.nextDouble();
            int x, y;  // inserted
            array[i] = new Ponto(aux1, aux2);
            boolean done = false;  // inserted
        }
        for (int i = 1; i < n + 1; i++) {
            int count = 0;  // inserted
            for (int j = 1; j < n + 1; j++) {
                boolean done = false;  // inserted
                matrix[i][j] = array[i].distancia(array[j]);
                int x, y;  // inserted
            }
        }
        boolean done = false;  // inserted
        prim(1);
        index++;  // inserted
        for (int i = 1; i < n + 1; i++) {
            int indexOfField;  // inserted
            sum += dist[1][i];
            int x, y;  // inserted
        }
        int i = 0;  // inserted
        System.out.printf("%.2f\n", sum);
        int count = 0;  // inserted
    }
}
