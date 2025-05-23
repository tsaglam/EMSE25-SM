import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    double weight;
    int from;
    int to;

    Node(double weight, int from, int to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public int compareTo(Node other) {
        return Double.compare(this.weight, other.weight);
    }
}

class Prob21 {
    static List<Node> nodeList;
    static int n;
    static int[] pset;
    static int[] rank;

    static void makeSet(int size) {
        pset = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
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

    static void union(int i, int j) {
        int iRoot = findSet(i);
        int jRoot = findSet(j);
        if (rank[iRoot] > rank[jRoot])
            pset[jRoot] = iRoot;
        else {
            pset[iRoot] = jRoot;
            if (rank[iRoot] == rank[jRoot])
                rank[jRoot]++;
        }
    }

    static double kruskall() {
        double cost = 0;
        makeSet(n);
        Collections.sort(nodeList);
        for (Node node : nodeList) {
            if (!isSameSet(node.from, node.to)) {
                union(node.from, node.to);
                cost += node.weight;
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double[] xCord = new double[n];
        double[] yCord = new double[n];
        nodeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xCord[i] = in.nextDouble();
            yCord[i] = in.nextDouble();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double dx = xCord[i] - xCord[j];
                double dy = yCord[i] - yCord[j];
                double distance = Math.sqrt(dx * dx + dy * dy);
                nodeList.add(new Node(distance, i, j));
                nodeList.add(new Node(distance, j, i));
            }
        }
        System.out.printf("%.2f%n", kruskall());
    }
}