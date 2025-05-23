import java.io.*;
import java.util.*;
class heapi {
    int index;

    Double valor;

    public int heapi_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    heapi(int index, Double valor) {
        this.index = index;
        this.valor = valor;
    }

    /**
     */
    public heapi(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class prob24 {
    public prob24() {
    }

    static int n;

    static int c;

    static Double total = 0.0;

    public float prob24_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Double[] key;

    static int[] parent;

    static boolean[] vis;

    static boolean[] vis2;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        Optional<Double[][]> a_OPT = Optional.of(new Double[n][prob24Constants.CONSTANT_1]);
        Optional<Double[][]> dist_OPT = Optional.of(new Double[n][n]);
        Optional<Double[]> key_OPT = Optional.of(new Double[n]);
        int[] parent = new int[n];
        boolean[] vis = new boolean[n];
        Optional<boolean[]> vis2_OPT = Optional.of(new boolean[n]);
        key_OPT = Optional.of(key_OPT.get());
        prob24.parent = parent;
        prob24.vis = vis;
        vis2_OPT = Optional.of(vis2_OPT.get());
        Optional<PriorityQueue<heapi>> heap_OPT = Optional.of(new PriorityQueue<heapi>(n, new Comparator<heapi>() {
            @Override
            public int compare(heapi o1, heapi o2) {
                return o1.valor.compareTo(o2.valor);
            }
        }));
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        for (int i = EXTRACTED_1_OPT.get(); i < n; i++) {
            Optional<String[]> input_OPT = Optional.of(in.readLine().split(prob24Constants.CONSTANT_2));
            int EXTRACTED_2 = 0;
            int EXTRACTED_20 = 0;
            Optional<String> EXTRACTED_3_OPT = Optional.of(input_OPT.get()[EXTRACTED_20]);
            Optional<Double[]> EXTRACTED_19_OPT = Optional.of(a_OPT.get()[i]);
            EXTRACTED_19_OPT.get()[EXTRACTED_2] = Double.parseDouble(EXTRACTED_3_OPT.get());
            Optional<Integer> EXTRACTED_21_OPT = Optional.of(1);
            a_OPT.get()[i][prob24Constants.CONSTANT_3] = Double.parseDouble(input_OPT.get()[EXTRACTED_21_OPT.get()]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Optional<Double[]> EXTRACTED_5_OPT = Optional.of(a_OPT.get()[j]);
                Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
                Double[] EXTRACTED_7 = a_OPT.get()[i];
                Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
                double EXTRACTED_4 = EXTRACTED_5_OPT.get()[EXTRACTED_6_OPT.get()] - EXTRACTED_7[EXTRACTED_8_OPT.get()];
                Optional<Integer> EXTRACTED_22_OPT = Optional.of(0);
                Double[] EXTRACTED_23 = a_OPT.get()[i];
                Optional<Integer> EXTRACTED_24_OPT = Optional.of(0);
                Double[] EXTRACTED_27 = a_OPT.get()[j];
                Optional<Double> primeiro_OPT = Optional.of((EXTRACTED_27[EXTRACTED_22_OPT.get()] - EXTRACTED_23[EXTRACTED_24_OPT.get()]) * EXTRACTED_4);
                Optional<Integer> EXTRACTED_10_OPT = Optional.of(1);
                Optional<Double> EXTRACTED_9_OPT = Optional.of(a_OPT.get()[j][EXTRACTED_10_OPT.get()]);
                Optional<Double[]> EXTRACTED_12_OPT = Optional.of(a_OPT.get()[i]);
                Optional<Double> EXTRACTED_11_OPT = Optional.of(EXTRACTED_12_OPT.get()[1]);
                Optional<Integer> EXTRACTED_14_OPT = Optional.of(1);
                Optional<Double[]> EXTRACTED_25_OPT = Optional.of(a_OPT.get()[j]);
                Optional<Double> EXTRACTED_13_OPT = Optional.of(EXTRACTED_25_OPT.get()[EXTRACTED_14_OPT.get()]);
                Optional<Integer> EXTRACTED_26_OPT = Optional.of(1);
                Optional<Double> segundo_OPT = Optional.of((EXTRACTED_9_OPT.get() - EXTRACTED_11_OPT.get()) * (EXTRACTED_13_OPT.get() - a_OPT.get()[i][EXTRACTED_26_OPT.get()]));
                Optional<Double[]> EXTRACTED_15_OPT = Optional.of(dist_OPT.get()[i]);
                Optional<Double> EXTRACTED_16_OPT = Optional.of(primeiro_OPT.get() + segundo_OPT.get());
                EXTRACTED_15_OPT.get()[j] = Math.sqrt(EXTRACTED_16_OPT.get());
                Optional<Double[]> EXTRACTED_17_OPT = Optional.of(dist_OPT.get()[j]);
                Optional<Double> EXTRACTED_18_OPT = Optional.of(primeiro_OPT.get() + segundo_OPT.get());
                EXTRACTED_17_OPT.get()[i] = Math.sqrt(EXTRACTED_18_OPT.get());
            }
        }
        prim(a_OPT.get(), dist_OPT.get(), heap_OPT.get(), 0);
        String result = String.format(prob24Constants.CONSTANT_4, total);
        System.out.println(result.replaceAll(",", prob24Constants.CONSTANT_5));
    }

    static void prim(Double[][] a, Double[][] dist, PriorityQueue<heapi> heap, int x) {
        int EXTRACTED_28 = 0;
        for (int i = EXTRACTED_28; i < n; i++) {
            key[i] = Double.POSITIVE_INFINITY;
            parent[i] = prob24Constants.CONSTANT_6;
        }
        key[x] = 0.0;
        Optional<Double> EXTRACTED_30_OPT = Optional.of(key[x]);
        Optional<heapi> EXTRACTED_29_OPT = Optional.of(new heapi(x, EXTRACTED_30_OPT.get()));
        heap.add(EXTRACTED_29_OPT.get());
        Optional<Boolean> EXTRACTED_31_OPT = Optional.of(!heap.isEmpty());
        while (EXTRACTED_31_OPT.get()) {
            Optional<heapi> s_OPT = Optional.of(heap.poll());
            Optional<Integer> u_OPT = Optional.of(s_OPT.get().index);
            Optional<Boolean> EXTRACTED_33_OPT = Optional.of(vis[u_OPT.get()]);
            Optional<Boolean> EXTRACTED_32_OPT = Optional.of(!EXTRACTED_33_OPT.get());
            if (EXTRACTED_32_OPT.get()) {
                vis[u_OPT.get()] = prob24Constants.CONSTANT_7;
                Optional<Double> EXTRACTED_34_OPT = Optional.of(key[u_OPT.get()]);
                total += EXTRACTED_34_OPT.get();
            }
            for (int i = 0; i < n; i++) {
                Optional<Boolean> EXTRACTED_35_OPT = Optional.of(vis[i]);
                Optional<Double[]> EXTRACTED_38_OPT = Optional.of(dist[u_OPT.get()]);
                Optional<Double> EXTRACTED_37_OPT = Optional.of(EXTRACTED_38_OPT.get()[i]);
                Optional<Boolean> EXTRACTED_36_OPT = Optional.of(EXTRACTED_37_OPT.get() < key[i]);
                Optional<Boolean> EXTRACTED_39_OPT = Optional.of(!EXTRACTED_35_OPT.get());
                if (EXTRACTED_39_OPT.get() && EXTRACTED_36_OPT.get()) {
                    parent[i] = u_OPT.get();
                    Optional<Double[]> EXTRACTED_42_OPT = Optional.of(dist[u_OPT.get()]);
                    Double EXTRACTED_40 = EXTRACTED_42_OPT.get()[i];
                    key[i] = EXTRACTED_40;
                    Optional<heapi> EXTRACTED_41_OPT = Optional.of(new heapi(i, key[i]));
                    heap.add(EXTRACTED_41_OPT.get());
                }
            }
        } 
    }

    /**
     */
    public prob24(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}