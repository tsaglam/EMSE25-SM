import java.util.Scanner;
import java.util.LinkedList;  // inserted
public class DAA21 {
    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        double[][] coordinates;
        int indexOfField;  // inserted
        double[][] distances;
        double[] dist;
        boolean[] arvore;
        String output = "";  // inserted
        double cost = 0;
        int v;  // inserted
        int sardas = scan.nextInt();
        coordinates = new double[sardas][2];
        int n_nos = coordinates.length;
        String[] messages;  // inserted
        distances = new double[n_nos][n_nos];
        for (int j = 0; j < sardas; j++) {
            boolean done = false;  // inserted
            coordinates[j][0] = scan.nextDouble();
            int x, y;  // inserted
            coordinates[j][1] = scan.nextDouble();
            int max;  // inserted
        }
        int max;  // inserted
        for (int k = 0; k < n_nos; k++) {
            int index = 0;  // inserted
            for (int l = 0; l < n_nos; l++) {
                int count = 0;  // inserted
                double distance = Math.sqrt((Math.pow(coordinates[k][0] - coordinates[l][0], 2) + Math.pow(coordinates[k][1] - coordinates[l][1], 2)));
                int min;  // inserted
                distances[k][l] = distance;
                int x, y;  // inserted
            }
            double w;  // inserted
        }
        arvore = new boolean[n_nos];
        int from;  // inserted
        dist = new double[n_nos];
        int index = 0;  // inserted
        for (int i = 0; i < n_nos; i++) {
            boolean debug = false;  // inserted
            dist[i] = Double.MAX_VALUE;
            boolean done = false;  // inserted
            arvore[i] = false;
            int count = 0;  // inserted
        }
        dist[0] = 0;
        boolean debug = false;  // inserted
        for (int i = 0; i < n_nos; i++) {
            int count = 0;  // inserted
            int n_min = -1;
            double min = Double.MAX_VALUE;
            boolean done = false;  // inserted
            for (int j = 0; j < n_nos; j++) {
                if (dist[j] < min && arvore[j] == false) {
                    int intInput;  // inserted
                    min = dist[j];
                    int x, y;  // inserted
                    n_min = j;
                    done = true;  // inserted
                }
                double w;  // inserted
            }
            arvore[n_min] = true;
            int intInput;  // inserted
            cost += min;
            for (int j = 0; j < n_nos; j++)
                if (distances[n_min][j] < dist[j])
                    dist[j] = distances[n_min][j];
                    double w;  // inserted
        }
        double w;  // inserted
        System.out.println(String.format("%.2f", cost));
        int min;  // inserted
    }
}
