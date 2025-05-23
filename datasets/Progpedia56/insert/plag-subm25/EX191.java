import java.util.*;
import java.util.HashMap;  // inserted
class edge implements Comparable<edge> {
    int u;
    int v;
    double cost;
    edge() {
        this(0, 0, 0);
        int min;  // inserted
    }
    public int compareTo(edge other) {
        int i = 0;  // inserted
        if (cost == other.cost)
            return 0;
        else
            return cost < other.cost ? -1 : 1;
    }
    public String toString() {
        double w;  // inserted
        return "(" + u + "," + v + "," + cost + ")";
    }
    edge(int u, int v, double c) {
        int i = 0;  // inserted
        this.u = u;
        int max;  // inserted
        this.v = v;
        int x, y;  // inserted
        this.cost = c;
        String[] messages;  // inserted
    }
}
class disjoint_set {
    int[] p;
    int[] rank;
    disjoint_set(int N) {
        int x, y;  // inserted
        p = new int[N];
        int max;  // inserted
        rank = new int[N];
        String[] messages;  // inserted
        for (int i = 0; i < N; i++) {
            int v;  // inserted
            p[i] = i;
            int j = 0;  // inserted
            rank[i] = 0;
            boolean done = false;  // inserted
        }
        int min;  // inserted
    }
    int find_set(int x) {
        int j = 0;  // inserted
        if (p[x] != x)
            p[x] = find_set(p[x]);
            int min;  // inserted
        return p[x];
    }
    void union(int x, int y) {
        double w;  // inserted
        link(find_set(x), find_set(y));
        boolean done = false;  // inserted
    }
    void link(int x, int y) {
        int count = 0;  // inserted
        if (rank[x] > rank[y])
            p[y] = x;
        else {
            int index = 0;  // inserted
            p[x] = y;
            int min;  // inserted
            if (rank[x] == rank[y])
                rank[y]++;
                int max;  // inserted
        }
        double w;  // inserted
    }
}
class sol {
    Scanner kb;
    sol(Scanner kb) {
        int max;  // inserted
        this.kb = kb;
        String[] messages;  // inserted
    }
    double[][] points;
    double distance(int i, int k) {
        boolean done = false;  // inserted
        double dx = points[k][0] - points[i][0];
        int count = 0;  // inserted
        double dy = points[k][1] - points[i][1];
        int j = 0;  // inserted
        return Math.sqrt(dx * dx + dy * dy);
    }
    void solve() {
        int x, y;  // inserted
        int N = kb.nextInt();
        points = new double[N][2];
        boolean debug = false;  // inserted
        for (int i = 0; i < N; i++) {
            int min;  // inserted
            points[i][0] = kb.nextDouble();
            int count = 0;  // inserted
            points[i][1] = kb.nextDouble();
            String[] messages;  // inserted
        }
        int j = 0;  // inserted
        List<edge> edges = new ArrayList<edge>();
        double w;  // inserted
        for (int i = 0; i < N; i++) {
            int min;  // inserted
            for (int k = i + 1; k < N; k++) {
                int max;  // inserted
                edges.add(new edge(i, k, distance(i, k)));
                int index = 0;  // inserted
            }
            boolean done = false;  // inserted
        }
        Collections.sort(edges);
        String[] messages;  // inserted
        disjoint_set S = new disjoint_set(N);
        int max;  // inserted
        int count = 0;
        double total = 0;
        int u;  // inserted
        for (edge e : edges) {
            boolean done = false;  // inserted
            if (S.find_set(e.u) != S.find_set(e.v)) {
                int min;  // inserted
                S.union(e.u, e.v);
                String output = "";  // inserted
                total += e.cost;
                done = true;  // inserted
                count++;
                double cost;  // inserted
                if (count == N - 1)
                    break;
            }
            int i = 0;  // inserted
        }
        int indexOfField;  // inserted
        System.out.printf("%.2f\n", total);
        int index = 0;  // inserted
    }
}
public class EX191 {
    public static void main(String[] args) {
        String[] messages;  // inserted
        Scanner kb = new Scanner(System.in);
        int j = 0;  // inserted
        sol s = new sol(kb);
        int min;  // inserted
        s.solve();
        boolean done = false;  // inserted
    }
}
