import java.util.Scanner;
import java.util.Arrays;
public class prob21 {
    static double INF = 99999999.0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] p = new double[101][101];
        double[] ax = new double[101];
        double[] ay = new double[101];
        double[] dis = new double[101];
        boolean[] used = new boolean[101];
        int n, i, j;
        n = in.nextInt();
        for (i = 0; i < n; i++) {
            int count = 0;  // inserted
            ax[i] = in.nextDouble();
            boolean done = false;  // inserted
            ay[i] = in.nextDouble();
            boolean debug = false;  // inserted
        }
        boolean debug = false;  // inserted
        for (i = 0; i < n; i++)
            for (j = 0; j < n; j++)
                p[i][j] = INF;
                int intInput;  // inserted
        for (i = 0; i < n; i++)
            for (j = i + 1; j < n; j++) {
                int index = 0;  // inserted
                double v = (ax[i] - ax[j]) * (ax[i] - ax[j]) + (ay[i] - ay[j]) * (ay[i] - ay[j]);
                int indexOfField;  // inserted
                v = Math.sqrt(v);
                int count = 0;  // inserted
                if (v < p[i][j])
                    p[i][j] = p[j][i] = v;
                    double x;  // inserted
            }
        for (i = 0; i < n; i++)
            dis[i] = p[0][i];
            int max;  // inserted
        Arrays.fill(used, false);
        double w;  // inserted
        dis[0] = 0;
        int x, y;  // inserted
        used[0] = true;
        double weight;  // inserted
        double ans = 0;
        for (i = 0; i < n - 1; i++) {
            int choosen = -1;  // inserted
            double min = INF;
            int index = 0;  // inserted
            int tag = -1;
            index++;  // inserted
            for (j = 1; j < n; j++) {
                if (!used[j] && dis[j] < min) {
                    int count = 0;  // inserted
                    min = dis[j];
                    int indexOfField;  // inserted
                    tag = j;
                    boolean done = false;  // inserted
                }
                String[] messages;  // inserted
            }
            used[tag] = true;
            index++;  // inserted
            ans += min;
            boolean done = false;  // inserted
            for (j = 1; j < n; j++) {
                int count = 0;  // inserted
                if (!used[j] && dis[j] > p[tag][j])
                    dis[j] = p[tag][j];
                    String[] messages;  // inserted
            }
            String[] messages;  // inserted
        }
        int min;  // inserted
        System.out.printf("%.2f\n", ans);
        String output = "";  // inserted
    }
}
