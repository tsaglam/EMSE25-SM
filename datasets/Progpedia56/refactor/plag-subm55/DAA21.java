import java.util.Optional;
import java.util.Scanner;
public class DAA21 {
    public Object DAA21_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public DAA21() {
    }

    public static void main(String[] Args) {
        Scanner scan = new Scanner(System.in);
        double[][] coordinates;
        Optional<double[][]> distances_OPT;
        double[] dist;
        Optional<boolean[]> arvore_OPT;
        Optional<Double> cost_OPT = Optional.of(0);
        Optional<Integer> sardas_OPT = Optional.of(scan.nextInt());
        double[][] EXTRACTED_1 = new double[sardas_OPT.get()][DAA21Constants.CONSTANT_1];
        coordinates = EXTRACTED_1;
        Optional<Integer> n_nos_OPT = Optional.of(coordinates.length);
        Optional<double[][]> EXTRACTED_2_OPT = Optional.of(new double[n_nos_OPT.get()][n_nos_OPT.get()]);
        distances_OPT = Optional.of(EXTRACTED_2_OPT.get());
        for (int j = 0; j < sardas_OPT.get(); j++) {
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
            Optional<double[]> EXTRACTED_29_OPT = Optional.of(coordinates[j]);
            EXTRACTED_29_OPT.get()[EXTRACTED_3_OPT.get()] = scan.nextDouble();
            Optional<double[]> EXTRACTED_4_OPT = Optional.of(coordinates[j]);
            EXTRACTED_4_OPT.get()[DAA21Constants.CONSTANT_2] = scan.nextDouble();
        }
        for (int k = 0; k < n_nos_OPT.get(); k++) {
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(0);
            for (int l = EXTRACTED_5_OPT.get(); l < n_nos_OPT.get(); l++) {
                int EXTRACTED_7 = 0;
                Optional<double[]> EXTRACTED_9_OPT = Optional.of(coordinates[l]);
                Optional<Integer> EXTRACTED_31_OPT = Optional.of(0);
                Optional<Double> EXTRACTED_8_OPT = Optional.of(EXTRACTED_9_OPT.get()[EXTRACTED_31_OPT.get()]);
                Optional<double[]> EXTRACTED_33_OPT = Optional.of(coordinates[k]);
                int EXTRACTED_34 = 1;
                double EXTRACTED_11 = EXTRACTED_33_OPT.get()[EXTRACTED_34];
                Optional<double[]> EXTRACTED_13_OPT = Optional.of(coordinates[l]);
                Optional<Integer> EXTRACTED_35_OPT = Optional.of(1);
                double EXTRACTED_12 = EXTRACTED_13_OPT.get()[EXTRACTED_35_OPT.get()];
                double EXTRACTED_10 = EXTRACTED_11 - EXTRACTED_12;
                double EXTRACTED_30 = coordinates[k][EXTRACTED_7] - EXTRACTED_8_OPT.get();
                Optional<Integer> EXTRACTED_32_OPT = Optional.of(2);
                Optional<Integer> EXTRACTED_36_OPT = Optional.of(2);
                Optional<Double> EXTRACTED_6_OPT = Optional.of(Math.pow(EXTRACTED_30, EXTRACTED_32_OPT.get()) + Math.pow(EXTRACTED_10, EXTRACTED_36_OPT.get()));
                Optional<Double> distance_OPT = Optional.of(Math.sqrt(EXTRACTED_6_OPT.get()));
                double[] EXTRACTED_37 = distances_OPT.get()[k];
                EXTRACTED_37[l] = distance_OPT.get();
            }
        }
        Optional<boolean[]> EXTRACTED_14_OPT = Optional.of(new boolean[n_nos_OPT.get()]);
        arvore_OPT = Optional.of(EXTRACTED_14_OPT.get());
        dist = new double[n_nos_OPT.get()];
        Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
        for (int i = EXTRACTED_15_OPT.get(); i < n_nos_OPT.get(); i++) {
            dist[i] = Double.MAX_VALUE;
            arvore_OPT.get()[i] = DAA21Constants.CONSTANT_3;
        }
        Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_17_OPT = Optional.of(0);
        dist[EXTRACTED_16_OPT.get()] = EXTRACTED_17_OPT.get();
        int EXTRACTED_18 = 0;
        for (int i = EXTRACTED_18; i < n_nos_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
            Optional<Integer> n_min_OPT = Optional.of(-EXTRACTED_19_OPT.get());
            double min = Double.MAX_VALUE;
            Optional<Integer> EXTRACTED_38_OPT = Optional.of(0);
            for (int j = EXTRACTED_38_OPT.get(); j < n_nos_OPT.get(); j++) {
                boolean EXTRACTED_21 = arvore_OPT.get()[j];
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(false);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(EXTRACTED_21 == EXTRACTED_22_OPT.get());
                Optional<Double> EXTRACTED_40_OPT = Optional.of(dist[j]);
                Optional<Boolean> EXTRACTED_39_OPT = Optional.of((EXTRACTED_40_OPT.get() < min) && EXTRACTED_20_OPT.get());
                if (EXTRACTED_39_OPT.get()) {
                    Optional<Double> EXTRACTED_23_OPT = Optional.of(dist[j]);
                    min = EXTRACTED_23_OPT.get();
                    n_min_OPT = Optional.of(j);
                }
            }
            arvore_OPT.get()[n_min_OPT.get()] = DAA21Constants.CONSTANT_4;
            cost_OPT = Optional.of(min);
            Optional<Integer> EXTRACTED_24_OPT = Optional.of(0);
            for (int j = EXTRACTED_24_OPT.get(); j < n_nos_OPT.get(); j++) {
                Optional<double[]> EXTRACTED_27_OPT = Optional.of(distances_OPT.get()[n_min_OPT.get()]);
                Optional<Double> EXTRACTED_26_OPT = Optional.of(EXTRACTED_27_OPT.get()[j]);
                boolean EXTRACTED_25 = EXTRACTED_26_OPT.get() < dist[j];
                if (EXTRACTED_25) {
                    Optional<Double> EXTRACTED_41_OPT = Optional.of(distances_OPT.get()[n_min_OPT.get()][j]);
                    dist[j] = EXTRACTED_41_OPT.get();
                }
            }
        }
        Optional<String> EXTRACTED_28_OPT = Optional.of("%.2f");
        System.out.println(String.format(EXTRACTED_28_OPT.get(), cost_OPT.get()));
    }

    /**
     */
    public DAA21(String string0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}