import java.io.*;
import java.util.*;

class prob21 {
    static int n;
    static int[] pset;
    static int[] rank;
    static List<Node> nodelist;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double[] xcord = new double[n];
        double[] ycord = new double[n];
        for (int i = 0; i < n; ++i) {
            xcord[i] = in.nextDouble();
            ycord[i] = in.nextDouble();
        }

        nodelist = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xcord[i] - xcord[j];
                double dy = ycord[i] - ycord[j];
                double dist = Math.sqrt(dx * dx + dy * dy);
                nodelist.add(new Node(dist, i, j));
            }
        }

        System.out.printf("%.2f\n", kruskall());
    }

    static double kruskall() {
        double cost = 0.0;
        makeSet(n);
        Collections.sort(nodelist);
        for (Node edge : nodelist) {
            if (!isSameSet(edge.from, edge.to)) {
                Union(edge.from, edge.to);
                cost += edge.w;
            }
        }
        return cost;
    }

    static void makeSet(int n) {
        pset = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            pset[i] = i;
            rank[i] = 0;
        }
    }

    static int findSet(int i) {
        if (pset[i] != i) {
            pset[i] = findSet(pset[i]);
        }
        return pset[i];
    }

    static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    static void Union(int i, int j) {
        int xRoot = findSet(i);
        int yRoot = findSet(j);
        if (rank[xRoot] > rank[yRoot]) {
            pset[yRoot] = xRoot;
        } else {
            pset[xRoot] = yRoot;
            if (rank[xRoot] == rank[yRoot]) {
                rank[yRoot]++;
            }
        }
    }
}

class Node implements Comparable<Node> {
    double w;
    int from;
    int to;

    Node(double w, int from, int to) {
        this.w = w;
        this.from = from;
        this.to = to;
    }

    public int compareTo(Node o) {
        return Double.compare(this.w, o.w);
    }
}