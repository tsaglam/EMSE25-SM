import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
class no {
    double x;

    double y;

    double dist;

    List<no> adj;

    no pai;

    boolean uspai;

    no(double x1, double y1) {
        x = x1;
        y = y1;
        dist = noConstants.CONSTANT_1;
        uspai = noConstants.CONSTANT_2;
        pai = null;
        adj = noConstants.CONSTANT_3;
    }

    public String no_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public no() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class graf {
    List<no> v;

    public String graf_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    graf() {
        v = grafConstants.CONSTANT_4;
    }

    /**
     */
    public graf(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class twentyfour {
    public twentyfour() {
    }

    public static void prim(graf g, no r) {
        r.dist = twentyfourConstants.CONSTANT_5;
        Optional<LinkedList<no>> q_OPT = Optional.of(new LinkedList<no>());
        LinkedList<no> caminho = new LinkedList<no>();
        for (no n : g.v)
            q_OPT.get().add(n);

        caminho.add(r);
        Optional<Boolean> EXTRACTED_1_OPT = Optional.of(!q_OPT.get().isEmpty());
        while (EXTRACTED_1_OPT.get()) {
            int index = extrair(q_OPT.get(), caminho);
            Optional<no> u_OPT = Optional.of(q_OPT.get().remove(index - twentyfourConstants.CONSTANT_6));
            double dist = 9999999.0;
            for (no adj : caminho) {
                Optional<Boolean> EXTRACTED_4_OPT = Optional.of(adj != u_OPT.get());
                if (EXTRACTED_4_OPT.get()) {
                    double EXTRACTED_2 = adj.y - u_OPT.get().y;
                    Optional<Double> EXTRACTED_5_OPT = Optional.of(adj.x - u_OPT.get().x);
                    Optional<Double> EXTRACTED_7_OPT = Optional.of(adj.y - u_OPT.get().y);
                    Optional<Double> EXTRACTED_6_OPT = Optional.of(EXTRACTED_2 * EXTRACTED_7_OPT.get());
                    Optional<Double> EXTRACTED_8_OPT = Optional.of(EXTRACTED_5_OPT.get() * (adj.x - u_OPT.get().x));
                    Optional<Double> EXTRACTED_9_OPT = Optional.of(EXTRACTED_8_OPT.get() + EXTRACTED_6_OPT.get());
                    dist = Math.sqrt(EXTRACTED_9_OPT.get());
                    Optional<Boolean> EXTRACTED_3_OPT = Optional.of(dist < u_OPT.get().dist);
                    if (EXTRACTED_3_OPT.get()) {
                        u_OPT.get().dist = dist;
                        u_OPT.get().pai = u_OPT.get();
                    }
                }
            }
            caminho.add(u_OPT.get());
        } 
    }

    public long twentyfour_callMe_not(double double0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    private static int extrair(List<no> q, List<no> cam) {
        double dist = 9.9999999E7;
        int i = 0;
        Optional<Integer> index_OPT = Optional.of(i);
        for (no q2 : q) {
            i++;
            for (no cami : cam) {
                Optional<Double> EXTRACTED_10_OPT = Optional.of(cami.x - q2.x);
                Optional<Double> EXTRACTED_12_OPT = Optional.of(cami.y - q2.y);
                double EXTRACTED_16 = cami.y - q2.y;
                Optional<Double> EXTRACTED_11_OPT = Optional.of(EXTRACTED_12_OPT.get() * EXTRACTED_16);
                Optional<Double> EXTRACTED_14_OPT = Optional.of(cami.x - q2.x);
                double EXTRACTED_13 = EXTRACTED_10_OPT.get() * EXTRACTED_14_OPT.get();
                double EXTRACTED_15 = EXTRACTED_13 + EXTRACTED_11_OPT.get();
                double dist2 = Math.sqrt(EXTRACTED_15);
                boolean EXTRACTED_17 = dist2 < dist;
                if (EXTRACTED_17) {
                    dist = dist2;
                    index_OPT = Optional.of(i);
                }
            }
        }
        return index_OPT.get();
    }

    public static void main(String[] args) {
        @SuppressWarnings(twentyfourConstants.CONSTANT_7)
        Scanner in = new Scanner(System.in);
        Optional<Integer> n_OPT = Optional.of(in.nextInt());
        Optional<Double> count_OPT = Optional.of(0);
        Optional<graf> g_OPT = Optional.of(new graf());
        for (int i = 0; i < n_OPT.get(); i++) {
            g_OPT.get().v.add(new no(in.nextDouble(), in.nextDouble()));
        }
        prim(g_OPT.get(), g_OPT.get().v.get(0));
        Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
        for (int i = EXTRACTED_18_OPT.get(); i < n_OPT.get(); i++)
            if (!g_OPT.get().v.get(i).uspai) {
                count_OPT = Optional.of(g_OPT.get().v.get(i).dist);
                g_OPT.get().v.get(i).uspai = twentyfourConstants.CONSTANT_8;
            }

        System.out.println(String.format(twentyfourConstants.CONSTANT_9, count_OPT.get()));
    }

    /**
     */
    public twentyfour(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}