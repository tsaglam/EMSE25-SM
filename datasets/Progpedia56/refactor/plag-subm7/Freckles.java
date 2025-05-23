import java.util.*;
class Freckles {
    public Freckles() {
    }

    public float Freckles_callMe_not(float float0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static double[][] matrix;

    static boolean[][] visited;

    static double[] dist;

    static int[] pred;

    static int q;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in).useLocale(Locale.US);
        Optional<Integer> n_OPT = Optional.of(q = in.nextInt());
        matrix = new double[n_OPT.get()][n_OPT.get()];
        visited = new boolean[n_OPT.get()][n_OPT.get()];
        dist = new double[n_OPT.get()];
        pred = new int[n_OPT.get()];
        double[][] coordinates = new double[n_OPT.get()][FrecklesConstants.CONSTANT_1];
        for (int i = 0; i < n_OPT.get(); i++) {
            double x = in.nextDouble();
            Optional<Double> y_OPT = Optional.of(in.nextDouble());
            Optional<double[]> EXTRACTED_1_OPT = Optional.of(coordinates[i]);
            EXTRACTED_1_OPT.get()[0] = x;
            coordinates[i][FrecklesConstants.CONSTANT_2] = y_OPT.get();
        }
        for (int i = 0; i < n_OPT.get(); i++) {
            for (int j = i; j < n_OPT.get(); j++) {
                Optional<Boolean> EXTRACTED_14_OPT = Optional.of(i != j);
                if (EXTRACTED_14_OPT.get()) {
                    Optional<double[]> EXTRACTED_2_OPT = Optional.of(matrix[j]);
                    Optional<double[]> EXTRACTED_3_OPT = Optional.of(coordinates[i]);
                    Optional<double[]> EXTRACTED_12_OPT = Optional.of(coordinates[i]);
                    int EXTRACTED_13 = 1;
                    Optional<Double> EXTRACTED_4_OPT = Optional.of(EXTRACTED_12_OPT.get()[EXTRACTED_13]);
                    Optional<double[]> EXTRACTED_5_OPT = Optional.of(coordinates[j]);
                    Optional<Integer> EXTRACTED_9_OPT = Optional.of(0);
                    Optional<Double> EXTRACTED_8_OPT = Optional.of(EXTRACTED_3_OPT.get()[EXTRACTED_9_OPT.get()]);
                    Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
                    double EXTRACTED_10 = coordinates[j][EXTRACTED_11_OPT.get()];
                    Optional<double[]> EXTRACTED_15_OPT = Optional.of(matrix[i]);
                    double EXTRACTED_16 = EXTRACTED_5_OPT.get()[1];
                    EXTRACTED_2_OPT.get()[i] = EXTRACTED_15_OPT.get()[j] = calc(EXTRACTED_8_OPT.get(), EXTRACTED_10, EXTRACTED_4_OPT.get(), EXTRACTED_16);
                }
            }
        }
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
        prim(matrix, EXTRACTED_6_OPT.get());
        Optional<Double> sum_OPT = Optional.of(0);
        int EXTRACTED_7 = 0;
        for (int i = EXTRACTED_7; i < n_OPT.get(); i++) {
            sum_OPT = Optional.of(dist[i]);
        }
        System.out.printf(Locale.US, FrecklesConstants.CONSTANT_3, sum_OPT.get());
    }

    private static double calc(double xi, double xj, double yi, double yj) {
        Optional<Double> EXTRACTED_18_OPT = Optional.of(yi - yj);
        double EXTRACTED_17 = ((xi - xj) * (xi - xj)) + (EXTRACTED_18_OPT.get() * (yi - yj));
        return Math.sqrt(EXTRACTED_17);
    }

    private static void kruskall() {
    }

    private static void prim(double[][] graph, int no) {
        int aux = q;
        LinkedList<Integer> vertices = new LinkedList<Integer>();
        for (int i = 0; i < q; i++) {
            Optional<Integer> EXTRACTED_27_OPT = Optional.of(0);
            pred[i] = EXTRACTED_27_OPT.get();
            dist[i] = Double.MAX_VALUE;
            vertices.add(i);
        }
        dist[no] = 0;
        boolean EXTRACTED_19 = vertices.peekFirst() != null;
        while (EXTRACTED_19) {
            Optional<Integer> u_OPT = Optional.of(min(vertices));
            for (int i = 0; i < q; i++) {
                Integer EXTRACTED_21 = new Integer(i);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(vertices.indexOf(EXTRACTED_21) != FrecklesConstants.CONSTANT_4);
                Optional<double[]> EXTRACTED_24_OPT = Optional.of(graph[u_OPT.get()]);
                Optional<Double> EXTRACTED_23_OPT = Optional.of(EXTRACTED_24_OPT.get()[i]);
                Optional<Double> EXTRACTED_25_OPT = Optional.of(dist[i]);
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(EXTRACTED_23_OPT.get() < EXTRACTED_25_OPT.get());
                boolean EXTRACTED_29 = EXTRACTED_20_OPT.get() && EXTRACTED_22_OPT.get();
                if (EXTRACTED_29) {
                    pred[i] = u_OPT.get();
                    Optional<double[]> EXTRACTED_28_OPT = Optional.of(graph[u_OPT.get()]);
                    Optional<Double> EXTRACTED_26_OPT = Optional.of(EXTRACTED_28_OPT.get()[i]);
                    dist[i] = EXTRACTED_26_OPT.get();
                }
            }
        } 
    }

    private static int min(LinkedList<Integer> graph) {
        Optional<Double> min_OPT = Optional.of(Double.MAX_VALUE);
        Optional<Integer> index_OPT = Optional.of(0);
        for (Integer i : graph) {
            Optional<Double> EXTRACTED_30_OPT = Optional.of(dist[i]);
            boolean EXTRACTED_32 = EXTRACTED_30_OPT.get() < min_OPT.get();
            if (EXTRACTED_32) {
                index_OPT = Optional.of(i);
                Optional<Double> EXTRACTED_31_OPT = Optional.of(dist[i]);
                min_OPT = Optional.of(EXTRACTED_31_OPT.get());
            }
        }
        graph.remove(new Integer(index_OPT.get()));
        return index_OPT.get();
    }

    private static void print() {
        Optional<Integer> EXTRACTED_33_OPT = Optional.of(0);
        for (int i = EXTRACTED_33_OPT.get(); i < q; i++) {
            String EXTRACTED_35 = " ";
            Optional<String> EXTRACTED_34_OPT = Optional.of(dist[i] + EXTRACTED_35);
            System.out.print(EXTRACTED_34_OPT.get());
        }
        System.out.println();
        Optional<Integer> EXTRACTED_36_OPT = Optional.of(0);
        for (int i = EXTRACTED_36_OPT.get(); i < q; i++) {
            int EXTRACTED_37 = pred[i];
            String EXTRACTED_38 = " ";
            Optional<String> EXTRACTED_39_OPT = Optional.of(EXTRACTED_37 + EXTRACTED_38);
            System.out.print(EXTRACTED_39_OPT.get());
        }
    }

    /**
     */
    public Freckles(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}