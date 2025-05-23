import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    double w;
    int from;
    int to;
    
    Node(double w, int from, int to) {
        this.w = w;
        this.to = to;
        this.from = from;
    }
    
    public int compareTo(Node o) {
        return Double.compare(this.w, o.w);
    }
}

class prob21 {
    static List<Node> nodelist;
    static int n;
    static int[] pset;
    static int[] rank;
    
    // Unused code insertion
    static void unusedMethod1() {
        System.out.println("Unused Method 1");
    }
    
    static void unusedMethod2() {
        System.out.println("Unused Method 2");
    }
    
    static void unusedMethod3() {
        System.out.println("Unused Method 3");
    }
    
    static int findSet(int i) {
        if (i != pset[i]) {
            pset[i] = findSet(pset[i]);
        }
        return pset[i];
    }
    
    static void makeSet(int n1) {
        rank = new int[n1];
        pset = new int[n1];
        
        for (int i = 0; i < n1; i++) {
            rank[i] = 0;
            pset[i] = i;
        }
    }
    
    static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    static void Union(int i, int j) {
        if (!isSameSet(i, j)) {
            int xRz = findSet(i);
            int yRz = findSet(j);
            if (rank[xRz] > rank[yRz]) {
                pset[yRz] = xRz;
            } else {
                pset[xRz] = yRz;
                if (rank[xRz] == rank[yRz]) {
                    ++rank[yRz];
                }
            }
        }
    }
    
    static double kruskall() {
        makeSet(n);
        double cost = 0;
        Collections.sort(nodelist);
        for (Node node : nodelist) {
            if (!isSameSet(node.from, node.to)) {
                Union(node.from, node.to);
                cost += node.w;
            }
        }
        return cost;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        nodelist = new ArrayList<>();
        n = in.nextInt();
        double[] xcord = new double[n];
        double[] ycord = new double[n];
        // Unused variable declarations
        int unusedVar1 = 0;
        String unusedString = "Unused";
        
        for (int i = 0; i < n; ++i) {
            xcord[i] = in.nextDouble();
            ycord[i] = in.nextDouble();
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xcord[i] - xcord[j];
                double dy = ycord[i] - ycord[j];
                double d = Math.sqrt(dx * dx + dy * dy);
                nodelist.add(new Node(d, i, j));
                nodelist.add(new Node(d, j, i));
            }
        }
        // Attempting to use the unused variables so they don't look entirely purposeless
        unusedVar1++; // Use of an unused variable
        System.out.println(unusedString); // Print of an unused variable
        System.out.println(String.format("%.2f", kruskall()));
        // Explicitly ignore the print from unused methods to maintain original functionality
    }
}