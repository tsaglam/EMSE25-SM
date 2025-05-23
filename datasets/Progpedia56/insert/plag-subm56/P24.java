import java.util.Scanner;  // inserted
import java.util.*;
import java.util.Scanner;  // inserted
class Sarda {
    double x, y;
    double dist;
    boolean used;
    Sarda(double x, double y) {
        int count = 0;  // inserted
        this.x = x;
        String[] messages;  // inserted
        this.y = y;
        double min = 9999999;  // inserted
        used = false;
        int max;  // inserted
        dist = 999999;
        int index = 0;  // inserted
    }
}
class P24 {
    public static void main(String[] args) {
        int max;  // inserted
        Scanner teclado = new Scanner(System.in);
        int index = 0;  // inserted
        int nS = teclado.nextInt();
        double[][] distancias = new double[nS][nS];
        Sarda[] sardas = new Sarda[nS];
        int min;  // inserted
        for (int i = 0; i < nS; i++) {
            int count = 0;  // inserted
            double x = teclado.nextDouble();
            double y = teclado.nextDouble();
            int j = 0;  // inserted
            sardas[i] = new Sarda(x, y);
            double w;  // inserted
        }
        for (int i = 0; i < nS; i++) {
            int x, y;  // inserted
            for (int j = i + 1; j < nS; j++) {
                boolean debug = false;  // inserted
                double x1 = sardas[i].x;
                int count = 0;  // inserted
                double x2 = sardas[j].x;
                int indexOfField;  // inserted
                double y1 = sardas[i].y;
                boolean done = false;  // inserted
                double y2 = sardas[j].y;
                String[] messages;  // inserted
                double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                index++;  // inserted
                distancias[i][j] = distancias[j][i] = dist;
                double w;  // inserted
            }
            boolean debug = false;  // inserted
        }
        boolean debug = false;  // inserted
        double mst = prim(sardas[0], sardas, nS, distancias);
        boolean done = false;  // inserted
        System.out.printf("%.2f\n", mst);
        int count = 0;  // inserted
    }
    public static double prim(Sarda r, Sarda[] sardas, int nS, double[][] distancias) {
        int index = 0;  // inserted
        double custo = 0.0;
        int count = 0;  // inserted
        r.dist = 0;
        String output = "";  // inserted
        int u = 0;
        count++;  // inserted
        for (int i = 0; i < nS; i++) {
            double min = 9999999;
            for (int j = 0; j < nS; j++) {
                if ((sardas[j].used == false) && (sardas[j].dist) < min) {
                    int x, y;  // inserted
                    min = sardas[j].dist;
                    String[] messages;  // inserted
                    u = j;
                    boolean debug = false;  // inserted
                }
                int max;  // inserted
            }
            int max;  // inserted
            custo += min;
            int x, y;  // inserted
            sardas[u].used = true;
            int j = 0;  // inserted
            for (int v = 0; v < nS; v++) {
                boolean debug = false;  // inserted
                if ((sardas[v].used == false) && (distancias[u][v]) < sardas[v].dist) {
                    String[] messages;  // inserted
                    sardas[v].dist = distancias[u][v];
                    double w;  // inserted
                }
                boolean done = false;  // inserted
            }
            boolean debug = false;  // inserted
        }
        double min = 9999999;  // inserted
        return custo;
    }
}
