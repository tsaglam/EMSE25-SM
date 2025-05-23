import java.util.*;
class Ponto {
    double x;

    double y;

    Ponto(double a, double b) {
        x = a;
        y = b;
    }

    public boolean Ponto_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    double distancia(Ponto p2) {
        Optional<Double> dist_OPT;
        int EXTRACTED_1 = 2;
        dist_OPT = Optional.of(Math.sqrt(Math.pow(x - p2.x, PontoConstants.CONSTANT_1) + Math.pow(y - p2.y, EXTRACTED_1)));
        return dist_OPT.get();
    }

    /**
     */
    public Ponto(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class prob24 {
    public double prob24_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public prob24() {
    }

    static Ponto[] array;

    static double[][] matrix;

    static double[][] dist;

    static int n;

    static boolean[] visited;

    static void prim(int r) {
        for (int i = 1; i <= n; i++) {
            int EXTRACTED_18 = 1;
            dist[r][i] = Double.MAX_VALUE - EXTRACTED_18;
        }
        dist[r][r] = prob24Constants.CONSTANT_2;
        int vis = 1;
        boolean EXTRACTED_2 = vis != n;
        while (EXTRACTED_2) {
            Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
            Optional<Integer> u_OPT = Optional.of(-EXTRACTED_19_OPT.get());
            double distmax = Double.MAX_VALUE;
            int EXTRACTED_3 = 1;
            int EXTRACTED_5 = 1;
            int EXTRACTED_4 = n + EXTRACTED_5;
            for (int i = EXTRACTED_3; i < EXTRACTED_4; i++) {
                Optional<Boolean> EXTRACTED_8_OPT = Optional.of(visited[i]);
                Optional<Boolean> EXTRACTED_7_OPT = Optional.of(!EXTRACTED_8_OPT.get());
                Optional<Double> EXTRACTED_9_OPT = Optional.of(dist[r][i]);
                boolean EXTRACTED_20 = EXTRACTED_9_OPT.get() < distmax;
                Optional<Boolean> EXTRACTED_6_OPT = Optional.of(EXTRACTED_7_OPT.get() && EXTRACTED_20);
                if (EXTRACTED_6_OPT.get()) {
                    distmax = dist[r][i];
                    u_OPT = Optional.of(i);
                }
            }
            boolean EXTRACTED_10 = u_OPT.get() == (-1);
            if (EXTRACTED_10)
                break;

            visited[u_OPT.get()] = prob24Constants.CONSTANT_3;
            vis++;
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_21_OPT = Optional.of(n + EXTRACTED_11_OPT.get());
            for (int i = 1; i < EXTRACTED_21_OPT.get(); i++) {
                Optional<Boolean> EXTRACTED_13_OPT = Optional.of(visited[i]);
                Optional<double[]> EXTRACTED_16_OPT = Optional.of(dist[r]);
                Optional<Double> EXTRACTED_15_OPT = Optional.of(EXTRACTED_16_OPT.get()[i]);
                double EXTRACTED_23 = matrix[u_OPT.get()][i];
                Optional<Boolean> EXTRACTED_14_OPT = Optional.of(EXTRACTED_23 < EXTRACTED_15_OPT.get());
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(!EXTRACTED_13_OPT.get());
                Optional<Boolean> EXTRACTED_12_OPT = Optional.of(EXTRACTED_22_OPT.get() && EXTRACTED_14_OPT.get());
                if (EXTRACTED_12_OPT.get()) {
                    Optional<double[]> EXTRACTED_25_OPT = Optional.of(matrix[u_OPT.get()]);
                    Optional<Double> EXTRACTED_17_OPT = Optional.of(EXTRACTED_25_OPT.get()[i]);
                    double[] EXTRACTED_24 = dist[r];
                    EXTRACTED_24[i] = EXTRACTED_17_OPT.get();
                }
            }
        } 
    }

    public static void main(String[] args) {
        double aux1 = 0.0;
        Optional<Double> aux2_OPT = Optional.of(0.0);
        Optional<Double> sum_OPT = Optional.of(0.0);
        Scanner EXTRACTED_26 = new Scanner(System.in);
        Optional<Scanner> s_OPT = Optional.of(EXTRACTED_26.useLocale(Locale.US));
        n = s_OPT.get().nextInt();
        Optional<Integer> EXTRACTED_28_OPT = Optional.of(2);
        Optional<Integer> EXTRACTED_27_OPT = Optional.of(EXTRACTED_28_OPT.get() * n);
        array = new Ponto[EXTRACTED_27_OPT.get()];
        int EXTRACTED_30 = n + 1;
        Optional<double[][]> EXTRACTED_29_OPT = Optional.of(new double[EXTRACTED_30][n + 1]);
        matrix = EXTRACTED_29_OPT.get();
        Optional<Integer> EXTRACTED_32_OPT = Optional.of(1);
        Optional<Integer> EXTRACTED_33_OPT = Optional.of(n + 1);
        Optional<double[][]> EXTRACTED_31_OPT = Optional.of(new double[n + EXTRACTED_32_OPT.get()][EXTRACTED_33_OPT.get()]);
        dist = EXTRACTED_31_OPT.get();
        visited = new boolean[n + 1];
        s_OPT.get().nextLine();
        int EXTRACTED_34 = 1;
        for (int i = EXTRACTED_34; i < (n + 1); i++) {
            aux1 = s_OPT.get().nextDouble();
            aux2_OPT = Optional.of(s_OPT.get().nextDouble());
            Optional<Ponto> EXTRACTED_35_OPT = Optional.of(new Ponto(aux1, aux2_OPT.get()));
            array[i] = EXTRACTED_35_OPT.get();
        }
        int EXTRACTED_36 = 1;
        Optional<Integer> EXTRACTED_38_OPT = Optional.of(1);
        int EXTRACTED_37 = n + EXTRACTED_38_OPT.get();
        for (int i = EXTRACTED_36; i < EXTRACTED_37; i++) {
            Optional<Integer> EXTRACTED_39_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_47_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_48_OPT = Optional.of(n + EXTRACTED_39_OPT.get());
            for (int j = EXTRACTED_47_OPT.get(); j < EXTRACTED_48_OPT.get(); j++) {
                Optional<double[]> EXTRACTED_40_OPT = Optional.of(matrix[i]);
                Optional<Ponto> EXTRACTED_41_OPT = Optional.of(array[j]);
                EXTRACTED_40_OPT.get()[j] = array[i].distancia(EXTRACTED_41_OPT.get());
            }
        }
        int EXTRACTED_42 = 1;
        prim(EXTRACTED_42);
        Optional<Integer> EXTRACTED_43_OPT = Optional.of(n + 1);
        for (int i = 1; i < EXTRACTED_43_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_46_OPT = Optional.of(1);
            double[] EXTRACTED_45 = dist[EXTRACTED_46_OPT.get()];
            double EXTRACTED_44 = EXTRACTED_45[i];
            sum_OPT = Optional.of(EXTRACTED_44);
        }
        System.out.printf(prob24Constants.CONSTANT_4, sum_OPT.get());
    }

    /**
     */
    public prob24(Object object0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}