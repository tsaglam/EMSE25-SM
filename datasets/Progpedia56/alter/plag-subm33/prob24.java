import java.util.*;
import java.io.*;
import java.math.*;
class Ponto {
    double x;
    double y;
    Ponto(double a, double b) {
        x = a;
        y = b;
    }
    double distancia(Ponto p2) {
        double dist;
        dist = Math.sqrt(Math.pow((x - p2.x), 2) + Math.pow((y - p2.y), 2));
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
        for (int i = 1; i <= n; i++) {
            dist[r][i] = Double.MAX_VALUE - 1;
        }
        dist[r][r] = 0;
        int vis = 1;
        while (vis != n) {
            int u = -1;
            double distmax = Double.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && dist[r][i] < distmax) {
                    distmax = dist[r][i];
                    u = i;
                }
            }
            if (u == -1)
                break;
            visited[u] = true;
            vis++;
            for (int i = 1; i < n + 1; i++) {
                if (!visited[i] && matrix[u][i] < dist[r][i]) {
                    dist[r][i] = matrix[u][i];
                }
            }
        }
    }
    public static void main(String[] args) {
        double aux1 = 0.0;
        double aux2 = 0.0;
        double sum = 0.0;
        Scanner s = new Scanner(System.in).useLocale(Locale.US);
        n = s.nextInt();
        array = new Ponto[2 * n];
        matrix = new double[n + 1][n + 1];
        dist = new double[n + 1][n + 1];
        visited = new boolean[n + 1];
        s.nextLine();
        for (int i = 1; i < n + 1; i++) {
            aux1 = s.nextDouble();
            aux2 = s.nextDouble();
            array[i] = new Ponto(aux1, aux2);
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                matrix[i][j] = array[i].distancia(array[j]);
            }
        }
        prim(1);
        for (int i = 1; i < n + 1; i++) {
            sum += dist[1][i];
        }
        System.out.printf("%.2f\n", sum);
    }
}
