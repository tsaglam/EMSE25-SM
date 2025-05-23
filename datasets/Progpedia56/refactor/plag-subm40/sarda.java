import java.util.*;
class no {
    public double x;

    public boolean no_callMe_not(double double0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public double y;

    public double[] dist;

    public boolean arvore;

    public no(double x, double y, int n) {
        this.x = x;
        this.y = y;
        no EXTRACTED_1 = this;
        EXTRACTED_1.dist = new double[n];
        this.arvore = noConstants.CONSTANT_1;
    }

    /**
     */
    public no() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sarda {
    public int sarda_callMe_not(boolean boolean0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public sarda() {
    }

    public static void main(String[] args) {
        Optional<LinkedList<Integer>> posicoes_OPT = Optional.of(new LinkedList<Integer>());
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> n_OPT = Optional.of(stdin_OPT.get().nextInt());
        Optional<no[]> g_OPT = Optional.of(new no[n_OPT.get()]);
        for (int i = 0; i < n_OPT.get(); i++) {
            Optional<no> EXTRACTED_17_OPT = Optional.of(new no(stdin_OPT.get().nextDouble(), stdin_OPT.get().nextDouble(), n_OPT.get()));
            g_OPT.get()[i] = EXTRACTED_17_OPT.get();
        }
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(0);
        for (int i = EXTRACTED_2_OPT.get(); i < n_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
            for (int j = EXTRACTED_3_OPT.get(); j < n_OPT.get(); j++) {
                no EXTRACTED_4 = g_OPT.get()[i];
                Optional<no> EXTRACTED_7_OPT = Optional.of(g_OPT.get()[i]);
                Optional<no> EXTRACTED_18_OPT = Optional.of(g_OPT.get()[j]);
                Optional<Double> EXTRACTED_6_OPT = Optional.of(EXTRACTED_7_OPT.get().x - EXTRACTED_18_OPT.get().x);
                no EXTRACTED_8 = g_OPT.get()[i];
                Optional<no> EXTRACTED_20_OPT = Optional.of(g_OPT.get()[j]);
                double EXTRACTED_19 = EXTRACTED_8.y - EXTRACTED_20_OPT.get().y;
                double EXTRACTED_5 = Math.pow(Math.abs(EXTRACTED_6_OPT.get()), sardaConstants.CONSTANT_2) + Math.pow(Math.abs(EXTRACTED_19), 2);
                EXTRACTED_4.dist[j] = Math.sqrt(EXTRACTED_5);
            }
        }
        Optional<Double> min_OPT = Optional.of(100000.0);
        int posi = 0;
        int posj = 0;
        Optional<Double> soma_OPT = Optional.of(0);
        int findno = 0;
        int j = 0;
        posicoes_OPT.get().add(0);
        Optional<no> EXTRACTED_9_OPT = Optional.of(g_OPT.get()[0]);
        EXTRACTED_9_OPT.get().arvore = sardaConstants.CONSTANT_3;
        for (int i = 0; i < (n_OPT.get() - 1); i++) {
            for (int pos : posicoes_OPT.get()) {
                for (j = 0; j < n_OPT.get(); j++) {
                    no EXTRACTED_10 = g_OPT.get()[pos];
                    Optional<Double> EXTRACTED_22_OPT = Optional.of(g_OPT.get()[pos].dist[j]);
                    int EXTRACTED_23 = 0;
                    boolean EXTRACTED_11 = EXTRACTED_22_OPT.get() != EXTRACTED_23;
                    no EXTRACTED_12 = g_OPT.get()[j];
                    Optional<Double> EXTRACTED_32_OPT = Optional.of(EXTRACTED_10.dist[j]);
                    Optional<Boolean> EXTRACTED_21_OPT = Optional.of(EXTRACTED_32_OPT.get() < min_OPT.get());
                    boolean EXTRACTED_24 = false;
                    boolean EXTRACTED_31 = EXTRACTED_12.arvore == EXTRACTED_24;
                    boolean EXTRACTED_30 = (EXTRACTED_21_OPT.get() && EXTRACTED_11) && EXTRACTED_31;
                    if (EXTRACTED_30) {
                        Optional<no> EXTRACTED_13_OPT = Optional.of(g_OPT.get()[pos]);
                        double EXTRACTED_25 = EXTRACTED_13_OPT.get().dist[j];
                        min_OPT = Optional.of(EXTRACTED_25);
                        posi = pos;
                        posj = j;
                    }
                }
            }
            posicoes_OPT.get().add(posj);
            min_OPT = Optional.of(sardaConstants.CONSTANT_4);
            Optional<Double> EXTRACTED_26_OPT = Optional.of(g_OPT.get()[posi].dist[posj]);
            soma_OPT = Optional.of(soma_OPT.get() + EXTRACTED_26_OPT.get());
            findno++;
            no EXTRACTED_14 = g_OPT.get()[posj];
            boolean EXTRACTED_27 = true;
            EXTRACTED_14.arvore = EXTRACTED_27;
            no EXTRACTED_15 = g_OPT.get()[posi];
            Optional<Integer> EXTRACTED_28_OPT = Optional.of(0);
            EXTRACTED_15.dist[posj] = EXTRACTED_28_OPT.get();
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            Optional<no> EXTRACTED_29_OPT = Optional.of(g_OPT.get()[posj]);
            EXTRACTED_29_OPT.get().dist[posi] = EXTRACTED_16_OPT.get();
        }
        System.out.printf("%.2f\n", soma_OPT.get());
    }

    /**
     */
    public sarda(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}