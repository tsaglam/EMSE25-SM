import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.StringTokenizer;
public class Main {
    public Main() {
    }

    static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer st = new StringTokenizer(MainConstants.CONSTANT_1);

    static String readString() throws Exception {
        Optional<Boolean> EXTRACTED_1_OPT = Optional.of(!st.hasMoreTokens());
        while (EXTRACTED_1_OPT.get()) {
            st = new StringTokenizer(stdin.readLine());
        } 
        return st.nextToken();
    }

    static int readInt() throws Exception {
        return Integer.parseInt(readString());
    }

    static double readDouble() throws Exception {
        return Double.parseDouble(readString());
    }

    public static void main(String[] args) throws Exception {
        int EXTRACTED_2 = 0;
        Optional<Double> total_OPT = Optional.of(Double.valueOf(EXTRACTED_2));
        int numberOfFreckles = readInt();
        Optional<Double[][]> freckles_OPT = Optional.of(new Double[numberOfFreckles][2]);
        Optional<int[]> sets_OPT = Optional.of(new int[numberOfFreckles]);
        for (int i = 0; i < numberOfFreckles; i++) {
            Optional<Double[]> EXTRACTED_7_OPT = Optional.of(freckles_OPT.get()[i]);
            EXTRACTED_7_OPT.get()[0] = readDouble();
            Optional<Double[]> EXTRACTED_8_OPT = Optional.of(freckles_OPT.get()[i]);
            Optional<Integer> EXTRACTED_9_OPT = Optional.of(1);
            EXTRACTED_8_OPT.get()[EXTRACTED_9_OPT.get()] = readDouble();
            sets_OPT.get()[i] = i;
        }
        for (int i = 1; i < numberOfFreckles; i++) {
            Double shortest = Double.MAX_VALUE;
            int EXTRACTED_10 = 1;
            Optional<Integer> s_OPT = Optional.of(-EXTRACTED_10);
            for (int j = 0; j < numberOfFreckles; j++) {
                Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
                int EXTRACTED_3 = -EXTRACTED_4_OPT.get();
                s_OPT = Optional.of(EXTRACTED_3);
                int EXTRACTED_5 = sets_OPT.get()[j];
                Optional<Boolean> EXTRACTED_11_OPT = Optional.of(sets_OPT.get()[i] != EXTRACTED_5);
                if (EXTRACTED_11_OPT.get()) {
                    Optional<Double[]> EXTRACTED_6_OPT = Optional.of(freckles_OPT.get()[i]);
                    Optional<Double[]> EXTRACTED_12_OPT = Optional.of(freckles_OPT.get()[j]);
                    Optional<Double> n_OPT = Optional.of(findDistance(EXTRACTED_6_OPT.get(), EXTRACTED_12_OPT.get()));
                    Optional<Boolean> EXTRACTED_13_OPT = Optional.of(n_OPT.get() < shortest);
                    if (EXTRACTED_13_OPT.get()) {
                        shortest = n_OPT.get();
                        Optional<Integer> EXTRACTED_14_OPT = Optional.of(sets_OPT.get()[j]);
                        s_OPT = Optional.of(EXTRACTED_14_OPT.get());
                    }
                }
            }
            total_OPT = Optional.of(shortest);
            sets_OPT.get()[i] = s_OPT.get();
        }
        System.out.printf(MainConstants.CONSTANT_2, total_OPT.get());
    }

    private static double findDistance(Double[] f1, Double[] f2) {
        Optional<Double> EXTRACTED_17_OPT = Optional.of(f1[0]);
        double EXTRACTED_16 = EXTRACTED_17_OPT.get() - f2[0];
        Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
        Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
        int EXTRACTED_21 = 1;
        Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
        Optional<Double> EXTRACTED_15_OPT = Optional.of((EXTRACTED_16 * (f1[0] - f2[EXTRACTED_18_OPT.get()])) + ((f1[EXTRACTED_19_OPT.get()] - f2[EXTRACTED_20_OPT.get()]) * (f1[EXTRACTED_21] - f2[EXTRACTED_22_OPT.get()])));
        return Math.sqrt(EXTRACTED_15_OPT.get());
    }

    public Object Main_callMe_not(double double0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Main(long long0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}