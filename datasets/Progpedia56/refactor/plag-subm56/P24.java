import java.util.*;
class Sarda {
    public String Sarda_callMe_not(String string0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    double x;

    double y;

    double dist;

    boolean used;

    Sarda(double x, double y) {
        Optional<Sarda> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().x = x;
        this.y = y;
        used = SardaConstants.CONSTANT_1;
        dist = 999999;
    }

    /**
     */
    public Sarda() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class P24 {
    public P24() {
    }

    public static void main(String[] args) {
        Optional<Scanner> teclado_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> nS_OPT = Optional.of(teclado_OPT.get().nextInt());
        double[][] distancias = new double[nS_OPT.get()][nS_OPT.get()];
        Optional<Sarda[]> sardas_OPT = Optional.of(new Sarda[nS_OPT.get()]);
        int EXTRACTED_2 = 0;
        for (int i = EXTRACTED_2; i < nS_OPT.get(); i++) {
            Optional<Double> x_OPT = Optional.of(teclado_OPT.get().nextDouble());
            double y = teclado_OPT.get().nextDouble();
            Optional<Sarda> EXTRACTED_3_OPT = Optional.of(new Sarda(x_OPT.get(), y));
            sardas_OPT.get()[i] = EXTRACTED_3_OPT.get();
        }
        int EXTRACTED_4 = 0;
        for (int i = EXTRACTED_4; i < nS_OPT.get(); i++) {
            for (int j = i + P24Constants.CONSTANT_2; j < nS_OPT.get(); j++) {
                Optional<Double> x1_OPT = Optional.of(sardas_OPT.get()[i].x);
                Optional<Sarda> EXTRACTED_5_OPT = Optional.of(sardas_OPT.get()[j]);
                Optional<Double> x2_OPT = Optional.of(EXTRACTED_5_OPT.get().x);
                Optional<Sarda> EXTRACTED_6_OPT = Optional.of(sardas_OPT.get()[i]);
                Optional<Double> y1_OPT = Optional.of(EXTRACTED_6_OPT.get().y);
                Optional<Sarda> EXTRACTED_7_OPT = Optional.of(sardas_OPT.get()[j]);
                Optional<Double> y2_OPT = Optional.of(EXTRACTED_7_OPT.get().y);
                double EXTRACTED_8 = x2_OPT.get() - x1_OPT.get();
                double EXTRACTED_9 = y2_OPT.get() - y1_OPT.get();
                Optional<Integer> EXTRACTED_13_OPT = Optional.of(2);
                Optional<Double> dist_OPT = Optional.of(Math.sqrt(Math.pow(EXTRACTED_8, P24Constants.CONSTANT_3) + Math.pow(EXTRACTED_9, EXTRACTED_13_OPT.get())));
                double[] EXTRACTED_10 = distancias[i];
                double[] EXTRACTED_14 = distancias[j];
                EXTRACTED_10[j] = EXTRACTED_14[i] = dist_OPT.get();
            }
        }
        Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
        Optional<Sarda> EXTRACTED_11_OPT = Optional.of(sardas_OPT.get()[EXTRACTED_12_OPT.get()]);
        double mst = prim(EXTRACTED_11_OPT.get(), sardas_OPT.get(), nS_OPT.get(), distancias);
        System.out.printf(P24Constants.CONSTANT_4, mst);
    }

    public static double prim(Sarda r, Sarda[] sardas, int nS, double[][] distancias) {
        Optional<Double> custo_OPT = Optional.of(0.0);
        int EXTRACTED_15 = 0;
        r.dist = EXTRACTED_15;
        Optional<Integer> u_OPT = Optional.of(0);
        for (int i = 0; i < nS; i++) {
            Optional<Double> min_OPT = Optional.of(9999999);
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            for (int j = EXTRACTED_16_OPT.get(); j < nS; j++) {
                Optional<Sarda> EXTRACTED_17_OPT = Optional.of(sardas[j]);
                Optional<Sarda> EXTRACTED_18_OPT = Optional.of(sardas[j]);
                boolean EXTRACTED_29 = EXTRACTED_17_OPT.get().used == P24Constants.CONSTANT_5;
                Optional<Boolean> EXTRACTED_30_OPT = Optional.of(EXTRACTED_18_OPT.get().dist < min_OPT.get());
                Optional<Boolean> EXTRACTED_23_OPT = Optional.of(EXTRACTED_29 && EXTRACTED_30_OPT.get());
                if (EXTRACTED_23_OPT.get()) {
                    Optional<Sarda> EXTRACTED_31_OPT = Optional.of(sardas[j]);
                    min_OPT = Optional.of(EXTRACTED_31_OPT.get().dist);
                    u_OPT = Optional.of(j);
                }
            }
            custo_OPT = Optional.of(min_OPT.get());
            Sarda EXTRACTED_24 = sardas[u_OPT.get()];
            EXTRACTED_24.used = P24Constants.CONSTANT_6;
            Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
            for (int v = EXTRACTED_25_OPT.get(); v < nS; v++) {
                Optional<Sarda> EXTRACTED_19_OPT = Optional.of(sardas[v]);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(false);
                boolean EXTRACTED_26 = EXTRACTED_19_OPT.get().used == EXTRACTED_20_OPT.get();
                double[] EXTRACTED_27 = distancias[u_OPT.get()];
                Sarda EXTRACTED_32 = sardas[v];
                if (EXTRACTED_26 && (EXTRACTED_27[v] < EXTRACTED_32.dist)) {
                    Optional<double[]> EXTRACTED_22_OPT = Optional.of(distancias[u_OPT.get()]);
                    Optional<Double> EXTRACTED_21_OPT = Optional.of(EXTRACTED_22_OPT.get()[v]);
                    Optional<Sarda> EXTRACTED_28_OPT = Optional.of(sardas[v]);
                    EXTRACTED_28_OPT.get().dist = EXTRACTED_21_OPT.get();
                }
            }
        }
        return custo_OPT.get();
    }

    public String P24_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public P24(float float0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}