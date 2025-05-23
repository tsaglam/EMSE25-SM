import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
public class prob21 {
    public prob21() {
    }

    public double prob21_callMe_not(boolean boolean0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static double INF = 9.9999999E7;

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(101);
        double[][] p = new double[prob21Constants.CONSTANT_1][EXTRACTED_1_OPT.get()];
        double[] ax = new double[101];
        double[] ay = new double[101];
        Optional<double[]> dis_OPT = Optional.of(new double[101]);
        int EXTRACTED_2 = 101;
        Optional<boolean[]> used_OPT = Optional.of(new boolean[EXTRACTED_2]);
        Optional<Integer> n_OPT;
        int i;
        int j;
        n_OPT = Optional.of(in_OPT.get().nextInt());
        for (i = prob21Constants.CONSTANT_2; i < n_OPT.get(); i++) {
            ax[i] = in_OPT.get().nextDouble();
            ay[i] = in_OPT.get().nextDouble();
        }
        for (i = 0; i < n_OPT.get(); i++) {
            int EXTRACTED_3 = 0;
            for (j = EXTRACTED_3; j < n_OPT.get(); j++)
                p[i][j] = INF;

        }
        for (i = 0; i < n_OPT.get(); i++) {
            int EXTRACTED_4 = i + prob21Constants.CONSTANT_3;
            for (j = EXTRACTED_4; j < n_OPT.get(); j++) {
                Optional<Double> EXTRACTED_6_OPT = Optional.of(ax[i]);
                Optional<Double> EXTRACTED_7_OPT = Optional.of(ax[j]);
                Optional<Double> EXTRACTED_8_OPT = Optional.of(ax[j]);
                Optional<Double> EXTRACTED_16_OPT = Optional.of(ax[i]);
                double EXTRACTED_5 = (EXTRACTED_6_OPT.get() - EXTRACTED_7_OPT.get()) * (EXTRACTED_16_OPT.get() - EXTRACTED_8_OPT.get());
                Optional<Double> EXTRACTED_18_OPT = Optional.of(ay[j]);
                Optional<Double> EXTRACTED_17_OPT = Optional.of(ay[i] - EXTRACTED_18_OPT.get());
                Optional<Double> EXTRACTED_21_OPT = Optional.of(ay[j]);
                Optional<Double> v_OPT = Optional.of(EXTRACTED_5 + (EXTRACTED_17_OPT.get() * (ay[i] - EXTRACTED_21_OPT.get())));
                v_OPT = Optional.of(Math.sqrt(v_OPT.get()));
                Optional<double[]> EXTRACTED_20_OPT = Optional.of(p[i]);
                Optional<Double> EXTRACTED_19_OPT = Optional.of(EXTRACTED_20_OPT.get()[j]);
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(v_OPT.get() < EXTRACTED_19_OPT.get());
                if (EXTRACTED_22_OPT.get())
                    p[i][j] = p[j][i] = v_OPT.get();

            }
        }
        for (i = 0; i < n_OPT.get(); i++) {
            Optional<double[]> EXTRACTED_24_OPT = Optional.of(p[0]);
            Optional<Double> EXTRACTED_23_OPT = Optional.of(EXTRACTED_24_OPT.get()[i]);
            dis_OPT.get()[i] = EXTRACTED_23_OPT.get();
        }
        Arrays.fill(used_OPT.get(), prob21Constants.CONSTANT_4);
        Optional<Integer> EXTRACTED_9_OPT = Optional.of(0);
        dis_OPT.get()[0] = EXTRACTED_9_OPT.get();
        used_OPT.get()[0] = prob21Constants.CONSTANT_5;
        double ans = 0;
        for (i = 0; i < (n_OPT.get() - 1); i++) {
            double min = INF;
            Optional<Integer> tag_OPT = Optional.of(-1);
            for (j = 1; j < n_OPT.get(); j++) {
                Optional<Boolean> EXTRACTED_10_OPT = Optional.of(used_OPT.get()[j]);
                double EXTRACTED_11 = dis_OPT.get()[j];
                boolean EXTRACTED_30 = (!EXTRACTED_10_OPT.get()) && (EXTRACTED_11 < min);
                if (EXTRACTED_30) {
                    double EXTRACTED_25 = dis_OPT.get()[j];
                    min = EXTRACTED_25;
                    tag_OPT = Optional.of(j);
                }
            }
            used_OPT.get()[tag_OPT.get()] = true;
            ans += min;
            int EXTRACTED_26 = 1;
            for (j = EXTRACTED_26; j < n_OPT.get(); j++) {
                Optional<Boolean> EXTRACTED_28_OPT = Optional.of(used_OPT.get()[j]);
                Optional<Boolean> EXTRACTED_12_OPT = Optional.of(!EXTRACTED_28_OPT.get());
                double[] EXTRACTED_14 = p[tag_OPT.get()];
                Optional<Double> EXTRACTED_29_OPT = Optional.of(EXTRACTED_14[j]);
                Optional<Boolean> EXTRACTED_13_OPT = Optional.of(dis_OPT.get()[j] > EXTRACTED_29_OPT.get());
                Optional<Boolean> EXTRACTED_27_OPT = Optional.of(EXTRACTED_12_OPT.get() && EXTRACTED_13_OPT.get());
                if (EXTRACTED_27_OPT.get()) {
                    Optional<double[]> EXTRACTED_31_OPT = Optional.of(p[tag_OPT.get()]);
                    Optional<Double> EXTRACTED_15_OPT = Optional.of(EXTRACTED_31_OPT.get()[j]);
                    dis_OPT.get()[j] = EXTRACTED_15_OPT.get();
                }
            }
        }
        System.out.printf(prob21Constants.CONSTANT_6, ans);
    }

    /**
     */
    public prob21(Object object0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}