import java.util.*;
class Edge implements Comparable<Edge> {
    Edge(No a, No b) {
        this.a = a;
        this.b = b;
    }

    No a;

    No b;

    @Override
    public int compareTo(Edge other) {
        Optional<Double> EXTRACTED_2_OPT = Optional.of(a.x - b.x);
        Optional<Double> EXTRACTED_3_OPT = Optional.of(a.x - b.x);
        Optional<Double> EXTRACTED_4_OPT = Optional.of((a.y - b.y) * (a.y - b.y));
        Optional<Double> EXTRACTED_5_OPT = Optional.of(other.a.x - other.b.x);
        double EXTRACTED_6 = (other.a.y - other.b.y) * (other.a.y - other.b.y);
        Optional<Double> EXTRACTED_1_OPT = Optional.of(((int) (((EXTRACTED_2_OPT.get() * EXTRACTED_3_OPT.get()) + EXTRACTED_4_OPT.get()) - (((other.a.x - other.b.x) * EXTRACTED_5_OPT.get()) + EXTRACTED_6))));
        return EXTRACTED_1_OPT.get();
    }

    public String Edge_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Edge(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class No {
    No(double x, double y, int idx) {
        this.x = x;
        Optional<No> EXTRACTED_7_OPT = Optional.of(this);
        EXTRACTED_7_OPT.get().y = y;
        Optional<No> EXTRACTED_8_OPT = Optional.of(this);
        EXTRACTED_8_OPT.get().idx = idx;
    }

    double x;

    double y;

    int idx;

    public Object No_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public No(Object object0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class UnionFind {
    int n;

    int[] a;

    public int UnionFind_callMe_not(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    UnionFind(int n) {
        Optional<UnionFind> EXTRACTED_9_OPT = Optional.of(this);
        EXTRACTED_9_OPT.get().n = n;
        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = i;

    }

    int FindSet(int i) {
        Optional<Boolean> EXTRACTED_10_OPT = Optional.of(a[i] == i);
        if (EXTRACTED_10_OPT.get())
            return i;

        return a[i] = FindSet(a[i]);
    }

    void UnionSet(int l, int r) {
        a[FindSet(l)] = FindSet(r);
    }

    /**
     */
    public UnionFind() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Prob21 {
    public Prob21() {
    }

    public boolean Prob21_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    static int n;

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        n = in_OPT.get().nextInt();
        ArrayList<No> nos = new ArrayList<No>();
        ArrayList<Edge> arestas = new ArrayList<Edge>();
        double comp = 0.0;
        for (int i = 0; i < n; i++) {
            Optional<No> EXTRACTED_11_OPT = Optional.of(new No(in_OPT.get().nextDouble(), in_OPT.get().nextDouble(), i));
            nos.add(EXTRACTED_11_OPT.get());
        }
        Optional<UnionFind> sets_OPT = Optional.of(new UnionFind(n));
        for (int i = 0; i < n; i++) {
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(i + Prob21Constants.CONSTANT_1);
            for (int j = EXTRACTED_15_OPT.get(); j < n; j++) {
                Optional<Edge> EXTRACTED_16_OPT = Optional.of(new Edge(nos.get(i), nos.get(j)));
                arestas.add(EXTRACTED_16_OPT.get());
            }
        }
        Collections.sort(arestas);
        for (Edge e : arestas) {
            Optional<Boolean> EXTRACTED_17_OPT = Optional.of(sets_OPT.get().FindSet(e.a.idx) != sets_OPT.get().FindSet(e.b.idx));
            if (EXTRACTED_17_OPT.get()) {
                sets_OPT.get().UnionSet(e.a.idx, e.b.idx);
                Optional<Double> EXTRACTED_13_OPT = Optional.of(e.a.x - e.b.x);
                Optional<Double> EXTRACTED_14_OPT = Optional.of(e.a.y - e.b.y);
                Optional<Double> EXTRACTED_18_OPT = Optional.of(e.a.x - e.b.x);
                Optional<Double> EXTRACTED_19_OPT = Optional.of((e.a.y - e.b.y) * EXTRACTED_14_OPT.get());
                Optional<Double> EXTRACTED_20_OPT = Optional.of(EXTRACTED_18_OPT.get() * EXTRACTED_13_OPT.get());
                Optional<Double> EXTRACTED_12_OPT = Optional.of(EXTRACTED_20_OPT.get() + EXTRACTED_19_OPT.get());
                comp += Math.sqrt(EXTRACTED_12_OPT.get());
            }
        }
        System.out.printf(Prob21Constants.CONSTANT_2, comp);
    }

    /**
     */
    public Prob21() {
        throw new RuntimeException("You'd better not have called me!");
    }
}