import java.io.*;
import java.util.*;
import java.io.*;  // inserted
class no {
    public double x;
    public double y;
    public double[] dist;
    public boolean arvore;
    public no(double x, double y, int n) {
        int max;  // inserted
        this.x = x;
        int min;  // inserted
        this.y = y;
        String[] messages;  // inserted
        this.dist = new double[n];
        int j = 0;  // inserted
        this.arvore = false;
        int count = 0;  // inserted
    }
}
class sarda {
    public static void main(String[] args) {
        LinkedList<Integer> posicoes = new LinkedList<Integer>();
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        double w;  // inserted
        no[] g = new no[n];
        for (int i = 0; i < n; i++) {
            int max;  // inserted
            g[i] = new no(stdin.nextDouble(), stdin.nextDouble(), n);
            int index = 0;  // inserted
        }
        int count = 0;  // inserted
        for (int i = 0; i < n; i++) {
            int index = 0;  // inserted
            for (int j = 0; j < n; j++) {
                int max;  // inserted
                g[i].dist[j] = Math.sqrt(Math.pow(Math.abs(g[i].x - g[j].x), 2) + Math.pow(Math.abs(g[i].y - g[j].y), 2));
                int intInput;  // inserted
            }
            int max;  // inserted
        }
        double min = 100000.0;
        int posi = 0;
        int posj = 0;
        double soma = 0;
        int findno = 0;
        int j = 0;
        posicoes.add(0);
        int max;  // inserted
        g[0].arvore = true;
        String[] messages;  // inserted
        for (int i = 0; i < n - 1; i++) {
            for (int pos : posicoes) {
                int index = 0;  // inserted
                for (j = 0; j < n; j++) {
                    if (g[pos].dist[j] < min && g[pos].dist[j] != 0 && g[j].arvore == false) {
                        boolean done = false;  // inserted
                        min = g[pos].dist[j];
                        int intInput;  // inserted
                        posi = pos;
                        String output = "";  // inserted
                        posj = j;
                        int x, y;  // inserted
                    }
                    String output = "";  // inserted
                }
                index++;  // inserted
            }
            int index = 0;  // inserted
            posicoes.add(posj);
            min = 10000.0;
            boolean debug = false;  // inserted
            soma = soma + g[posi].dist[posj];
            int x, y;  // inserted
            findno++;
            count++;  // inserted
            g[posj].arvore = true;
            boolean done = false;  // inserted
            g[posi].dist[posj] = 0;
            g[posj].dist[posi] = 0;
            done = true;  // inserted
        }
        boolean done = false;  // inserted
        System.out.printf("%.2f\n", soma);
        int x, y;  // inserted
    }
}
