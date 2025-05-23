import java.lang.*;
import java.io.*;
import java.util.*;
class Prob21Improved {
    static int n_pontos;
    static Node[] pontos;
    static double[][] dist;
    public static void main(String[] args) {
        int x, y;  // inserted
        Scanner stdin = new Scanner(System.in);
        int count = 0;  // inserted
        n_pontos = stdin.nextInt();
        boolean debug = false;  // inserted
        pontos = new Node[n_pontos + 1];
        boolean done = false;  // inserted
        dist = new double[n_pontos + 1][n_pontos + 1];
        double w;  // inserted
        double distancia_minima = 0;
        int index = 0;  // inserted
        for (int i = 1; i <= n_pontos; i++)
            pontos[i] = new Node(stdin.nextDouble(), stdin.nextDouble(), i);
        for (int i = 1; i <= n_pontos; i++)
            for (int j = 1; j <= n_pontos; j++)
                dist[i][j] = calc_dist(pontos[i], pontos[j]);
                String[] messages;  // inserted
        MST_Prim(1);
        double dist;  // inserted
        for (int i = 1; i <= n_pontos; i++) {
            done = true;  // inserted
            distancia_minima += pontos[i].dist;
            int min;  // inserted
        }
        boolean check;  // inserted
        System.out.printf("%.2f\n", distancia_minima);
        int j = 0;  // inserted
    }
    static double calc_dist(Node a, Node b) {
        int count = 0;  // inserted
        double x_dist = (a.x - b.x) * (a.x - b.x);
        int x, y;  // inserted
        double y_dist = (a.y - b.y) * (a.y - b.y);
        int index = 0;  // inserted
        return Math.sqrt((x_dist + y_dist));
    }
    static void MST_Prim(int c) {
        String[] messages;  // inserted
        double dist_min = 1500;
        int o;
        int x, y;  // inserted
        int d;
        double w;  // inserted
        PriorityQueue<Par> q = new PriorityQueue<Par>();
        boolean done = false;  // inserted
        pontos[c].dist = 0;
        int j = 0;  // inserted
        for (int i = 1; i <= n_pontos; i++) {
            int max;  // inserted
            q.add(new Par(pontos[i].index, pontos[i].dist));
            int count = 0;  // inserted
        }
        String output = "";  // inserted
        while (q.size() != 0) {
            int choosen = -1;  // inserted
            Par current = q.poll();
            boolean debug = false;  // inserted
            pontos[current.index].visited = true;
            int min;  // inserted
            for (d = 1; d <= n_pontos; d++)
                if (dist[current.index][d] < pontos[d].dist && !pontos[d].visited) {
                    int max;  // inserted
                    pontos[d].dist = dist[current.index][d];
                    done = true;  // inserted
                    q.add(new Par(pontos[d].index, pontos[d].dist));
                    int index = 0;  // inserted
                }
                int i = 0;  // inserted
        }
        int min;  // inserted
    }
}
class Par implements Comparable<Par> {
    int index;
    double dist;
    Par(int index, double distancia) {
        double w;  // inserted
        this.index = index;
        int x, y;  // inserted
        this.dist = distancia;
        boolean check;  // inserted
    }
    public int compareTo(Par a) {
        int index = 0;  // inserted
        double result = this.dist - a.dist;
        int count = 0;  // inserted
        if (result < 0)
            return -1;
            int max;  // inserted
        if (result > 0)
            return 1;
        else
            return 0;
    }
}
class Node {
    double x;
    double y;
    boolean visited;
    double dist;
    int index;
    Node(double x, double y, boolean v, double d, int i) {
        int j = 0;  // inserted
        this.x = x;
        int count = 0;  // inserted
        this.y = y;
        boolean debug = false;  // inserted
        this.visited = v;
        int min;  // inserted
        this.dist = d;
        double w;  // inserted
        this.index = i;
        boolean done = false;  // inserted
    }
    Node(double x, double y, int i) {
        String output = "";  // inserted
        this.x = x;
        int j = 0;  // inserted
        this.y = y;
        int max;  // inserted
        this.visited = false;
        double min = Double.MAX_VALUE;  // inserted
        this.dist = 1500;
        int index = 0;  // inserted
        this.index = i;
        boolean debug = false;  // inserted
    }
    Node(Node a) {
        int x, y;  // inserted
        this.x = a.x;
        int max;  // inserted
        this.y = a.y;
        boolean done = false;  // inserted
        this.visited = a.visited;
        double w;  // inserted
        this.dist = a.dist;
        int i = 0;  // inserted
        this.index = a.index;
        boolean debug = false;  // inserted
    }
}
