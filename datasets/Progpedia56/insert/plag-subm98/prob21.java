import java.io.*;
import java.util.*;
class Node implements Comparable<Node> {
    double w;
    int from;
    int to;
    Node(double w, int from, int to) {
        int index = 0;  // inserted
        this.w = w;
        int x, y;  // inserted
        this.from = from;
        int max;  // inserted
        this.to = to;
        int count = 0;  // inserted
    }
    public int compareTo(Node o) {
        int count = 0;  // inserted
        return Double.compare(this.w, o.w);
    }
}
public class prob21 {
    static List<Node> nodelist;
    static int n;
    static int[] pset;
    static int[] rank;
    static void makeSet(int n1) {
        int count = 0;  // inserted
        pset = new int[n1];
        String[] messages;  // inserted
        rank = new int[n1];
        int j = 0;  // inserted
        for (int i = 0; i < n1; i++) {
            pset[i] = i;
            int min;  // inserted
            rank[i] = 0;
            int index = 0;  // inserted
        }
        int i = 0;  // inserted
    }
    static int findSet(int i) {
        int max;  // inserted
        if (i != pset[i]) {
            int x, y;  // inserted
            pset[i] = findSet(pset[i]);
            int index = 0;  // inserted
        }
        int count = 0;  // inserted
        return pset[i];
    }
    static boolean isSameSet(int i, int j) {
        boolean done = false;  // inserted
        return findSet(i) == findSet(j);
    }
    static void Union(int i, int j) {
        double w;  // inserted
        int xRz = findSet(i);
        int x, y;  // inserted
        int yRz = findSet(j);
        int count = 0;  // inserted
        if (rank[xRz] > rank[yRz])
            pset[yRz] = xRz;
        else {
            int index = 0;  // inserted
            pset[xRz] = yRz;
            boolean debug = false;  // inserted
            if (rank[xRz] == rank[yRz])
                ++rank[yRz];
                int max;  // inserted
        }
        String[] messages;  // inserted
    }
    static double kruskall() {
        int j = 0;  // inserted
        double cost = 0;
        int min;  // inserted
        makeSet(n);
        boolean done = false;  // inserted
        Collections.sort(nodelist);
        int count = 0;  // inserted
        for (int i = 0; i < nodelist.size(); ++i) {
            String[] messages;  // inserted
            Node node = nodelist.get(i);
            int index = 0;  // inserted
            if (!isSameSet(node.from, node.to)) {
                done = true;  // inserted
                Union(node.from, node.to);
                int x, y;  // inserted
                cost += node.w;
                double w;  // inserted
            }
            int max;  // inserted
        }
        double w;  // inserted
        return cost;
    }
    public static void main(String[] args) throws IOException {
        int from;  // inserted
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        double[] xcord = new double[n];
        int intInput;  // inserted
        double[] ycord = new double[n];
        nodelist = new ArrayList<Node>();
        String output = "";  // inserted
        for (int i = 0; i < n; ++i) {
            boolean done = false;  // inserted
            xcord[i] = in.nextDouble();
            boolean debug = false;  // inserted
            ycord[i] = in.nextDouble();
            int index = 0;  // inserted
        }
        String[] messages;  // inserted
        for (int i = 0; i < n - 1; ++i) {
            int min;  // inserted
            for (int j = i + 1; j < n; ++j) {
                boolean done = false;  // inserted
                double dx = xcord[i] - xcord[j];
                int x, y;  // inserted
                double dy = ycord[i] - ycord[j];
                int max;  // inserted
                double d = Math.sqrt(dx * dx + dy * dy);
                int index = 0;  // inserted
                nodelist.add(new Node(d, i, j));
                nodelist.add(new Node(d, j, i));
                double w;  // inserted
            }
            int index = 0;  // inserted
        }
        int min;  // inserted
        System.out.println(String.format("%.2f", kruskall()));
        int index = 0;  // inserted
    }
}
