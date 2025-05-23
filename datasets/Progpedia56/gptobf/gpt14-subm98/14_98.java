import java.io.*;
import java.util.*;

class prob21 {
    static int n;
    static List<Node> nodelist;
    static int[] rank;
    static int[] pset;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        nodelist = new ArrayList<Node>(); // Moved initialization up for reordering
        n = in.nextInt();

        // Insert unused variables #1
        double unusedVariable1 = 99.99;
        unusedVariable1 = 1.0; // This change has no impact

        double[] xcord = new double[n];
        double[] ycord = new double[n];
        for (int i = 0; i < n; ++i) {
            xcord[i] = in.nextDouble();
            ycord[i] = in.nextDouble();
        }

        // Unused variable insertion #2
        String unusedString2 = "unused";
        unusedString2 = "still unused";

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xcord[i] - xcord[j];
                double dy = ycord[i] - ycord[j];
                double d = Math.sqrt(dx * dx + dy * dy);
                nodelist.add(new Node(d, i, j));
                nodelist.add(new Node(d, j, i));
            }
        }
        System.out.println(String.format("%.2f", kruskall()));
    }

    static void makeSet(int n1) {
        rank = new int[n1];
        pset = new int[n1];

        // Unused variable insertion #3
        int unusedInt3 = 25;
        unusedInt3 = -5;

        for (int i = 0; i < n1; i++) {
            pset[i] = i;
            rank[i] = 0;
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
        }

        // Unused variable insertion #4
        boolean unusedBool4 = false;
        unusedBool4 = true; // This is a no-op in terms of behavior

        return cost;
    }

    static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    static int findSet(int i) {
        if (i != pset[i]) {
            pset[i] = findSet(pset[i]);
        }

        // Unused variable insertion #5
        double unusedDouble5 = Math.E;
        unusedDouble5 = Math.PI;

        return pset[i];
    }

    static void Union(int i, int j) {
        int xRz = findSet(i);
        int yRz = findSet(j);
        if (rank[xRz] > rank[yRz])
            pset[yRz] = xRz;
        else {
            pset[xRz] = yRz;
            if (rank[xRz] == rank[yRz])
                ++rank[yRz];
        }

        // Unused variable insertion #6
        long unusedLong6 = 123456789L;
        unusedLong6 = 987654321L;
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