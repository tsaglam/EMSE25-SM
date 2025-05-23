import java.util.*;
public class prob21 {
    public prob21() {
    }

    static int[] pset;

    static class ramo implements Comparable<ramo> {
        int u;

        int v;

        double w;

        public ramo(int st, int end, double we) {
            u = st;
            v = end;
            w = we;
        }

        @Override
        public int compareTo(ramo o) {
            if (!(w > o.w)) {
                Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
                return EXTRACTED_1_OPT.get();
            } else
                return prob21Constants.CONSTANT_1;

        }
    }

    public Object prob21_callMe_not(float float0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static int findSet(int i) {
        Optional<Boolean> EXTRACTED_2_OPT = Optional.of(pset[i] == i);
        if (!EXTRACTED_2_OPT.get()) {
            return pset[i] = findSet(pset[i]);
        } else {
            return i;
        }
    }

    static void unionSet(int i, int j) {
        pset[findSet(i)] = pset[findSet(j)];
    }

    static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public static void initSet(int tamanho) {
        pset = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            pset[i] = i;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner ler = new Scanner(System.in);
        Optional<PriorityQueue<ramo>> ramoList_OPT = Optional.of(new PriorityQueue<ramo>());
        Optional<Integer> n_OPT = Optional.of(ler.nextInt());
        double[][] cord = new double[n_OPT.get()][2];
        Optional<Double> currLen_OPT;
        Optional<Double> yDiff_OPT;
        double xDiff;
        Optional<Double> min_OPT = Optional.of(0.0);
        for (int i = 0; i < n_OPT.get(); i++) {
            int EXTRACTED_14 = 0;
            min_OPT = Optional.of(EXTRACTED_14);
            initSet(n_OPT.get());
            double[] EXTRACTED_15 = cord[i];
            EXTRACTED_15[0] = ler.nextDouble();
            int EXTRACTED_3 = 1;
            cord[i][EXTRACTED_3] = ler.nextDouble();
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(0);
            for (int j = EXTRACTED_4_OPT.get(); j < n_OPT.get(); j++) {
                int EXTRACTED_17 = 1;
                Optional<Integer> EXTRACTED_16_OPT = Optional.of(j + EXTRACTED_17);
                for (int k = EXTRACTED_16_OPT.get(); k < n_OPT.get(); k++) {
                    Optional<double[]> EXTRACTED_6_OPT = Optional.of(cord[j]);
                    Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
                    Optional<Double> EXTRACTED_5_OPT = Optional.of(EXTRACTED_6_OPT.get()[EXTRACTED_25_OPT.get()]);
                    Optional<double[]> EXTRACTED_7_OPT = Optional.of(cord[k]);
                    int EXTRACTED_19 = 0;
                    Optional<Double> EXTRACTED_26_OPT = Optional.of(EXTRACTED_7_OPT.get()[EXTRACTED_19]);
                    Optional<Double> EXTRACTED_18_OPT = Optional.of(EXTRACTED_5_OPT.get() - EXTRACTED_26_OPT.get());
                    xDiff = EXTRACTED_18_OPT.get();
                    Optional<Integer> EXTRACTED_9_OPT = Optional.of(1);
                    Optional<double[]> EXTRACTED_22_OPT = Optional.of(cord[k]);
                    double EXTRACTED_8 = EXTRACTED_22_OPT.get()[EXTRACTED_9_OPT.get()];
                    Optional<Integer> EXTRACTED_21_OPT = Optional.of(1);
                    Optional<double[]> EXTRACTED_28_OPT = Optional.of(cord[j]);
                    double EXTRACTED_20 = EXTRACTED_28_OPT.get()[EXTRACTED_21_OPT.get()];
                    yDiff_OPT = Optional.of(EXTRACTED_20 - EXTRACTED_8);
                    double EXTRACTED_10 = yDiff_OPT.get() * yDiff_OPT.get();
                    Optional<Double> EXTRACTED_27_OPT = Optional.of(xDiff * xDiff);
                    Optional<Double> EXTRACTED_23_OPT = Optional.of(EXTRACTED_10 + EXTRACTED_27_OPT.get());
                    currLen_OPT = Optional.of(Math.sqrt(EXTRACTED_23_OPT.get()));
                    double EXTRACTED_11 = -currLen_OPT.get();
                    ramo e = new ramo(j, k, EXTRACTED_11);
                    ramoList_OPT.get().add(e);
                }
            }
            while (!ramoList_OPT.get().isEmpty()) {
                ramo e = ramoList_OPT.get().poll();
                Optional<Boolean> EXTRACTED_24_OPT = Optional.of(!isSameSet(e.u, e.v));
                if (EXTRACTED_24_OPT.get()) {
                    double EXTRACTED_12 = -e.w;
                    min_OPT = Optional.of(EXTRACTED_12);
                    unionSet(e.u, e.v);
                }
            } 
        }
        Optional<String> EXTRACTED_13_OPT = Optional.of("%.2f\n");
        System.out.printf(EXTRACTED_13_OPT.get(), min_OPT.get());
    }

    /**
     */
    public prob21() {
        throw new RuntimeException("You'd better not have called me!");
    }
}