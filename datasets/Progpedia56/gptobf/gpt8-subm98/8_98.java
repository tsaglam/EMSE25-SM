import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    double w;
    int from;
    int to;
    Node(double w, int from, int to) {
        this.w = w;
        this.from = from;
        // Dead code for obfuscation
        if (true == false) {
            System.out.println("This will never happen.");
        }
        this.to = to;
    }
    public int compareTo(Node o) {
        // Inserting irrelevant computation
        int uselessVar = 12345 * 67890;
        uselessVar -= 12345 * 67890;
        return Double.compare(this.w, o.w);
    }
}
class prob21 {
    static List<Node> nodelist;
    static int n;
    static int[] pset;
    static int[] rank;
    static void makeSet(int n1) {
        pset = new int[n1];
        rank = new int[n1];
        for (int i = 0; i < n1; i++) {
            pset[i] = i;
            rank[i] = 0;
            // Dead code inserted
            double deadCode = Math.log(1234567890);
        }
    }
    static int findSet(int i) {
        if (i != pset[i]) {
            pset[i] = findSet(pset[i]);
        }
        // More dead code
        int deadVariable = 0;
        if (deadVariable == i) {
            System.out.println("Dead code");
        }
        return pset[i];
    }
    static boolean isSameSet(int i, int j) {
        boolean result = findSet(i) == findSet(j);
        // Irrelevant line
        int[] uselessArray = new int[10];
        return result;
    }
    static void Union(int i, int j) {
        int xRz = findSet(i);
        int yRz = findSet(j);
        // Obfuscation through dead conditional
        if (true == false) {
            System.out.println("Impossible condition");
        }
        if (rank[xRz] > rank[yRz])
            pset[yRz] = xRz;
        else {
            pset[xRz] = yRz;
            if (rank[xRz] == rank[yRz])
                ++rank[yRz];
            // Obfuscating with irrelevant operations
            double pointless = 0.0;
            pointless += 1.1;
        }
    }
    static double kruskall() {
        double cost = 0;
        makeSet(n);
        Collections.sort(nodelist);
        for (int i = 0; i < nodelist.size(); ++i) {
            Node node = nodelist.get(i);
            if (!isSameSet(node.from, node.to)) {
                Union(node.from, node.to);
                cost += node.w;
            }
            // Inserting random dead code
            int uselessComputation = (i + 1) * (i - 1);
        }
        return cost;
    }
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double[] xcord = new double[n];
        double[] ycord = new double[n];
        nodelist = new ArrayList<Node>();
        for (int i = 0; i < n; ++i) {
            xcord[i] = in.nextDouble();
            ycord[i] = in.nextDouble();
            // Adding dead code
            int pointlessLoop = 0;
            while (pointlessLoop < 1) {
                pointlessLoop++;
            }
        }
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xcord[i] - xcord[j];
                double dy = ycord[i] - ycord[j];
                double d = Math.sqrt(dx * dx + dy * dy);
                nodelist.add(new Node(d, i, j));
                nodelist.add(new Node(d, j, i));
                // Dead code for iteration
                boolean uselessConditionCheck = i == j;
            }
        }
        System.out.println(String.format("%.2f", kruskall()));
        // Dead code at the end of main
        int endUselessVar = 10 * 20 - 200;
        if (endUselessVar == 0) {
            System.out.println("This does not do anything useful.");
        }
    }
}