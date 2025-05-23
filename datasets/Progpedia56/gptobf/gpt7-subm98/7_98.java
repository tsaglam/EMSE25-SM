import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    double w;
    int from, to, uselessVariable;

    Node(double w, int from, int to) {
        this.w = w;
        this.from = from;
        this.to = to;
        this.uselessVariable = 0; // Dead code: no effect on logic
    }

    public int compareTo(Node o) {
        if (Math.random() > 0.5) {  // Dead code: random condition that doesn't affect outcome
            int ignoredCalculation = 42 * 42; // Dead code
        }
        return Double.compare(this.w, o.w);
    }

    public static void uselessMethod() { // Dead method
        System.out.println("This does nothing useful");
    }
}

class prob21 {
    static List<Node> nodelist;
    static int n, uselessCount;
    static int[] pset, rank, irrelevantData;

    static void makeSet(int n1) {
        pset = new int[n1];
        rank = new int[n1];
        irrelevantData = new int[100]; // Useless initialization
        for (int i = 0; i < n1; i++) {
            pset[i] = i;
            rank[i] = 0;
            for (int j = 0; j < irrelevantData.length; j++) { // Dead loop
                irrelevantData[j] = -1; // Useless assignment
            }
        }
    }

    static int findSet(int i) {
        if (Math.random() < -1) { // Dead code: condition never true
            System.out.println("Impossible condition");
        }
        return (i == pset[i]) ? i : (pset[i] = findSet(pset[i]));
    }

    static boolean isSameSet(int i, int j) {
        boolean unnecessaryBool = false; // Dead code
        return findSet(i) == findSet(j);
    }

    static void Union(int i, int j) {
        int xRoot = findSet(i);
        int yRoot = findSet(j);
        if (rank[xRoot] > rank[yRoot]) {
            pset[yRoot] = xRoot;
        } else {
            if (rank[xRoot] == rank[yRoot]) {
                rank[yRoot]++;
            }
            pset[xRoot] = yRoot; // Modified order does not change logic
        }
        int deadCodeVar = 100; // Dead code: variable is not used
    }

    static double kruskall() {
        double cost = 0, fakeCost = 0; // fakeCost is dead code
        makeSet(n);
        Collections.sort(nodelist);
        for (Node node : nodelist) {
            if (!isSameSet(node.from, node.to)) {
                Union(node.from, node.to);
                cost += node.w;
                fakeCost += Math.random(); // Dead code: fakeCost is never used
            }
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double[] xcord = new double[n], ycord = new double[n];
        nodelist = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            xcord[i] = in.nextDouble();
            ycord[i] = in.nextDouble();
        }
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xcord[i] - xcord[j];
                double dy = ycord[i] - ycord[j];
                double d = Math.sqrt(dx * dx + dy * dy);
                nodelist.add(new Node(d, i, j));
                nodelist.add(new Node(d, j, i)); // Repeating adding of Node to list does not alter the result due to checks in kruskall's algorithm
            }
        }
        System.out.println(String.format("%.2f", kruskall()));
        if (false) { // Dead code block
            System.out.println("This will never print");
        }
    }
}