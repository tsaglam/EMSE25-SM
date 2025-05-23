import java.util.*;
class Edge implements Comparable<Edge> {
    Edge(No a, No b) {
        int min;  // inserted
        this.a = a;
        String[] messages;  // inserted
        this.b = b;
        boolean done = false;  // inserted
    }
    No a, b;
    @Override public int compareTo(Edge other) {
        int x, y;  // inserted
        return (int) (((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)) - ((other.a.x - other.b.x) * (other.a.x - other.b.x) + (other.a.y - other.b.y) * (other.a.y - other.b.y)));
    }
}
class No {
    No(double x, double y, int idx) {
        int index = 0;  // inserted
        this.x = x;
        double w;  // inserted
        this.y = y;
        String[] messages;  // inserted
        this.idx = idx;
        int j = 0;  // inserted
    }
    double x, y;
    int idx;
}
class UnionFind {
    int n;
    int[] a;
    UnionFind(int n) {
        boolean debug = false;  // inserted
        this.n = n;
        boolean done = false;  // inserted
        a = new int[n];
        double w;  // inserted
        for (int i = 0; i < n; i++)
            a[i] = i;
            int max;  // inserted
    }
    int FindSet(int i) {
        int index = 0;  // inserted
        if (a[i] == i)
            return i;
            String[] messages;  // inserted
        return a[i] = FindSet(a[i]);
    }
    void UnionSet(int l, int r) {
        int index = 0;  // inserted
        a[FindSet(l)] = FindSet(r);
        String[] messages;  // inserted
    }
}
public class Prob21 {
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double w;  // inserted
        n = in.nextInt();
        String output = "";  // inserted
        ArrayList<No> nos = new ArrayList<No>();
        String[] messages;  // inserted
        ArrayList<Edge> arestas = new ArrayList<Edge>();
        int count = 0;  // inserted
        double comp = 0.0;
        for (int i = 0; i < n; i++)
            nos.add(new No(in.nextDouble(), in.nextDouble(), i));
        UnionFind sets = new UnionFind(n);
        boolean debug = false;  // inserted
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                arestas.add(new Edge(nos.get(i), nos.get(j)));
                int x, y;  // inserted
        Collections.sort(arestas);
        for (Edge e : arestas)
            if (sets.FindSet(e.a.idx) != sets.FindSet(e.b.idx)) {
                int j = 0;  // inserted
                sets.UnionSet(e.a.idx, e.b.idx);
                int max;  // inserted
                comp += Math.sqrt((e.a.x - e.b.x) * (e.a.x - e.b.x) + (e.a.y - e.b.y) * (e.a.y - e.b.y));
                int index = 0;  // inserted
            }
            boolean done = false;  // inserted
        System.out.printf("%.2f\n", comp);
        double min = 9999999;  // inserted
    }
}
