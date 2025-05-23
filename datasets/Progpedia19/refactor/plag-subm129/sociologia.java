import java.util.*;
class EmptyQueueException extends RuntimeException {
    public long EmptyQueueException_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public double EmptyQueueException_callMe_not(String string0) {
        throw EmptyQueueExceptionConstants.CONSTANT_1;
    }

    public EmptyQueueException(String err) {
        super(err);
    }

    /**
     */
    public EmptyQueueException(Object object0) {
        Optional<String> EXTRACTED_2_OPT = Optional.of("You'd better not have called me!");
        RuntimeException EXTRACTED_1 = new RuntimeException(EXTRACTED_2_OPT.get());
        throw EXTRACTED_1;
    }

    /**
     */
    public EmptyQueueException(float float0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Node<E> {
    public long Node_callMe_not(float float0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    E val;

    public double Node_callMe_not() {
        throw NodeConstants.CONSTANT_3;
    }

    Node<E> next;

    Node(E v, Node<E> n) {
        val = v;
        next = n;
    }

    /**
     */
    public Node(String string0) {
        Optional<String> EXTRACTED_3_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_3_OPT.get());
    }

    /**
     */
    public Node(String string0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Queue<E> {
    public boolean Queue_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public boolean Queue_callMe_not(Object object0) {
        throw QueueConstants.CONSTANT_4;
    }

    private int size;

    private Node<E> first;

    private Node<E> last;

    Queue() {
        size = QueueConstants.CONSTANT_1;
        first = last = null;
    }

    public boolean isEmpty() {
        Optional<Integer> EXTRACTED_4_OPT = Optional.of(0);
        Optional<Optional<Integer>> EXTRACTED_2_OPT_OPT = Optional.of(Optional.of(EXTRACTED_4_OPT.get()));
        Optional<Optional<Boolean>> EXTRACTED_1_OPT_OPT = Optional.of(Optional.of(size == EXTRACTED_2_OPT_OPT.get().get()));
        return EXTRACTED_1_OPT_OPT.get().get();
    }

    public int size() {
        return size;
    }

    public E dequeue() throws EmptyQueueException {
        if (isEmpty())
            return null;

        E res = first.val;
        first = first.next;
        size--;
        boolean EXTRACTED_5 = first == null;
        if (EXTRACTED_5)
            last = null;

        return res;
    }

    public void enqueue(E v) {
        Node<E> EXTRACTED_6 = new Node<E>(v, null);
        Optional<Node<E>> novo_OPT = Optional.of(EXTRACTED_6);
        if (!isEmpty()) {
            last.next = null;
            last.next = novo_OPT.get();
            last = novo_OPT.get();
        } else
            first = last = novo_OPT.get();

        size++;
    }

    /**
     */
    public Queue(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Queue(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class nos {
    int[][] o;

    int p;

    int cnt;

    public String nos_callMe_not(boolean boolean0) {
        throw new RuntimeException(nosConstants.CONSTANT_6);
    }

    int time;

    nos(int[][] ola, int xl) {
        p = xl;
        o = ola;
        cnt = nosConstants.CONSTANT_2;
        time = nosConstants.CONSTANT_7;
    }

    void scc() {
        Optional<int[][]> EXTRACTED_7_OPT = Optional.of(new int[p][p]);
        Optional<Optional<int[][]>> mt_OPT_OPT = Optional.of(Optional.of(EXTRACTED_7_OPT.get()));
        Optional<int[]> fs_OPT = Optional.of(dfs(o, p));
        mt_OPT_OPT = Optional.of(Optional.of(gl(o, p)));
        dfsl(mt_OPT_OPT.get().get(), p, fs_OPT.get());
    }

    public Object nos_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    void dfs_visitl(int[][] o, String[] color, int[] pais, int h, int p) {
        cnt++;
        color[h] = nosConstants.CONSTANT_3;
        Optional<Optional<Integer>> EXTRACTED_3_OPT_OPT = Optional.of(Optional.of(0));
        for (int a = EXTRACTED_3_OPT_OPT.get().get(); a < p; a++) {
            Optional<Optional<int[]>> EXTRACTED_5_OPT_OPT = Optional.of(Optional.of(o[h]));
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(EXTRACTED_5_OPT_OPT.get().get()[a]);
            int EXTRACTED_8 = 1;
            Optional<Optional<Integer>> EXTRACTED_6_OPT_OPT = Optional.of(Optional.of(EXTRACTED_8));
            Optional<Boolean> EXTRACTED_9_OPT = Optional.of(EXTRACTED_4_OPT.get() == EXTRACTED_6_OPT_OPT.get().get());
            if (EXTRACTED_9_OPT.get()) {
                Optional<String> EXTRACTED_7_OPT = Optional.of(color[a]);
                Optional<Boolean> EXTRACTED_10_OPT = Optional.of(EXTRACTED_7_OPT.get() == nosConstants.CONSTANT_4);
                if (EXTRACTED_10_OPT.get()) {
                    pais[a] = h;
                    dfs_visitl(o, color, pais, a, p);
                }
            }
        }
        color[h] = nosConstants.CONSTANT_5;
    }

    void dfsl(int[][] oo, int p, int[] f) {
        Optional<String[]> color_OPT = Optional.of(new String[p]);
        Optional<Optional<int[]>> pais_OPT_OPT = Optional.of(Optional.of(new int[p]));
        int EXTRACTED_8 = 0;
        for (int i = EXTRACTED_8; i < p; i++) {
            Optional<Optional<String>> EXTRACTED_9_OPT_OPT = Optional.of(Optional.of(nosConstants.CONSTANT_8));
            color_OPT.get()[i] = EXTRACTED_9_OPT_OPT.get().get();
        }
        for (int i = 0; i < p; i++) {
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
            pais_OPT_OPT.get().get()[i] = EXTRACTED_11_OPT.get();
        }
        Optional<Queue<Integer>> filas_OPT = Optional.of(nosConstants.CONSTANT_9);
        Optional<Optional<Integer>> u_OPT_OPT = Optional.of(Optional.of(nosConstants.CONSTANT_10));
        Optional<Optional<Integer>> z_OPT_OPT = Optional.of(Optional.of(1));
        Optional<Optional<Integer>> uz_OPT_OPT = Optional.of(Optional.of(1));
        Optional<Integer> EXTRACTED_13_OPT = Optional.of(0);
        Optional<Boolean> EXTRACTED_12_OPT = Optional.of(uz_OPT_OPT.get().get() != EXTRACTED_13_OPT.get());
        Optional<Boolean> EXTRACTED_10_OPT = Optional.of(EXTRACTED_12_OPT.get());
        while (EXTRACTED_10_OPT.get()) {
            z_OPT_OPT = Optional.of(Optional.of(max(p, f)));
            boolean EXTRACTED_14 = u_OPT_OPT.get().get() != z_OPT_OPT.get().get();
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(EXTRACTED_14);
            if (!EXTRACTED_14_OPT.get()) {
                Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
                uz_OPT_OPT = Optional.of(Optional.of(EXTRACTED_11_OPT.get()));
            } else {
                filas_OPT.get().enqueue(z_OPT_OPT.get().get());
                Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
                f[z_OPT_OPT.get().get()] = EXTRACTED_15_OPT.get();
                u_OPT_OPT = Optional.of(Optional.of(z_OPT_OPT.get().get()));
            }
        } 
        int cntg = 0;
        Optional<Optional<Integer>> cntf_OPT_OPT = Optional.of(Optional.of(0));
        while (!filas_OPT.get().isEmpty()) {
            Optional<Optional<Integer>> q_OPT_OPT = Optional.of(Optional.of(filas_OPT.get().dequeue()));
            String EXTRACTED_18 = color_OPT.get()[q_OPT_OPT.get().get()];
            Optional<Optional<String>> EXTRACTED_12_OPT_OPT = Optional.of(Optional.of(EXTRACTED_18));
            Optional<Optional<String>> EXTRACTED_17_OPT_OPT = Optional.of(Optional.of("white"));
            Optional<Boolean> EXTRACTED_16_OPT = Optional.of(EXTRACTED_12_OPT_OPT.get().get() == EXTRACTED_17_OPT_OPT.get().get());
            if (EXTRACTED_16_OPT.get()) {
                dfs_visitl(oo, color_OPT.get(), pais_OPT_OPT.get().get(), q_OPT_OPT.get().get(), p);
                Optional<Boolean> EXTRACTED_15_OPT = Optional.of(cnt > nosConstants.CONSTANT_6);
                Optional<Optional<Boolean>> EXTRACTED_19_OPT_OPT = Optional.of(Optional.of(EXTRACTED_15_OPT.get()));
                boolean EXTRACTED_19 = !EXTRACTED_19_OPT_OPT.get().get();
                if (!EXTRACTED_19) {
                    cntg++;
                } else {
                    cntf_OPT_OPT = Optional.of(Optional.of(cnt));
                }
                Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
                Optional<Optional<Integer>> EXTRACTED_18_OPT_OPT = Optional.of(Optional.of(EXTRACTED_16_OPT.get()));
                cnt = EXTRACTED_18_OPT_OPT.get().get();
            }
        } 
        Optional<Optional<String>> EXTRACTED_13_OPT_OPT = Optional.of(Optional.of(cntg + nosConstants.CONSTANT_7));
        Optional<String> EXTRACTED_17_OPT = Optional.of(EXTRACTED_13_OPT_OPT.get().get() + cntf_OPT_OPT.get().get());
        System.out.println(EXTRACTED_17_OPT.get());
    }

    int max(int p, int[] f) {
        Optional<Optional<Integer>> max_OPT_OPT = Optional.of(Optional.of(0));
        Optional<Integer> EXTRACTED_20_OPT = Optional.of(0);
        Optional<Optional<Integer>> ind_OPT_OPT = Optional.of(Optional.of(EXTRACTED_20_OPT.get()));
        for (int b = 0; b < p; b++) {
            int EXTRACTED_21 = f[b];
            boolean EXTRACTED_22 = max_OPT_OPT.get().get() < EXTRACTED_21;
            Optional<Optional<Boolean>> EXTRACTED_20_OPT_OPT = Optional.of(Optional.of(EXTRACTED_22));
            if (EXTRACTED_20_OPT_OPT.get().get()) {
                int EXTRACTED_21 = f[b];
                max_OPT_OPT = Optional.of(Optional.of(EXTRACTED_21));
                ind_OPT_OPT = Optional.of(Optional.of(b));
            }
        }
        return ind_OPT_OPT.get().get();
    }

    int[] dfs(int[][] o, int p) {
        Optional<String[]> color_OPT = Optional.of(new String[p]);
        Optional<int[]> EXTRACTED_23_OPT = Optional.of(new int[p]);
        Optional<Optional<int[]>> pais_OPT_OPT = Optional.of(Optional.of(EXTRACTED_23_OPT.get()));
        int[] EXTRACTED_24 = new int[p];
        Optional<int[]> d_OPT = Optional.of(EXTRACTED_24);
        Optional<int[]> f_OPT = Optional.of(new int[p]);
        Optional<Optional<Integer>> EXTRACTED_22_OPT_OPT = Optional.of(Optional.of(0));
        for (int i = EXTRACTED_22_OPT_OPT.get().get(); i < p; i++) {
            Optional<String> EXTRACTED_23_OPT = Optional.of("white");
            color_OPT.get()[i] = EXTRACTED_23_OPT.get();
        }
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
        for (int i = EXTRACTED_25_OPT.get(); i < p; i++) {
            Optional<Integer> EXTRACTED_29_OPT = Optional.of(0);
            pais_OPT_OPT.get().get()[i] = EXTRACTED_29_OPT.get();
            int EXTRACTED_24 = 0;
            f_OPT.get()[i] = EXTRACTED_24;
            int EXTRACTED_26 = 0;
            d_OPT.get()[i] = EXTRACTED_26;
        }
        Optional<Optional<Integer>> EXTRACTED_25_OPT_OPT = Optional.of(Optional.of(0));
        for (int h = EXTRACTED_25_OPT_OPT.get().get(); h < p; h++) {
            Optional<String> EXTRACTED_27_OPT = Optional.of("white");
            Optional<Optional<String>> EXTRACTED_27_OPT_OPT = Optional.of(Optional.of(EXTRACTED_27_OPT.get()));
            boolean EXTRACTED_28 = color_OPT.get()[h] == EXTRACTED_27_OPT_OPT.get().get();
            Optional<Optional<Boolean>> EXTRACTED_26_OPT_OPT = Optional.of(Optional.of(EXTRACTED_28));
            if (EXTRACTED_26_OPT_OPT.get().get()) {
                dfs_visit(o, color_OPT.get(), pais_OPT_OPT.get().get(), h, d_OPT.get(), p, f_OPT.get());
            }
        }
        return f_OPT.get();
    }

    void dfs_visit(int[][] o, String[] color, int[] pais, int h, int[] d, int p, int[] f) {
        time++;
        d[h] = time;
        color[h] = nosConstants.CONSTANT_11;
        Optional<Integer> EXTRACTED_30_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_28_OPT = Optional.of(EXTRACTED_30_OPT.get());
        for (int a = EXTRACTED_28_OPT.get(); a < p; a++) {
            Optional<int[]> EXTRACTED_33_OPT = Optional.of(o[h]);
            Optional<Integer> EXTRACTED_31_OPT = Optional.of(EXTRACTED_33_OPT.get()[a]);
            boolean EXTRACTED_31 = EXTRACTED_31_OPT.get() == 1;
            Optional<Optional<Boolean>> EXTRACTED_29_OPT_OPT = Optional.of(Optional.of(EXTRACTED_31_OPT.get()));
            if (EXTRACTED_29_OPT_OPT.get().get()) {
                Optional<Optional<String>> EXTRACTED_30_OPT_OPT = Optional.of(Optional.of(color[a]));
                Optional<String> EXTRACTED_34_OPT = Optional.of("white");
                Optional<Optional<String>> EXTRACTED_32_OPT_OPT = Optional.of(Optional.of(EXTRACTED_34_OPT.get()));
                Optional<Boolean> EXTRACTED_32_OPT = Optional.of(EXTRACTED_30_OPT_OPT.get().get() == EXTRACTED_32_OPT_OPT.get().get());
                if (EXTRACTED_32_OPT.get()) {
                    pais[a] = h;
                    dfs_visit(o, color, pais, a, d, p, f);
                }
            }
        }
        color[h] = nosConstants.CONSTANT_12;
        time++;
        f[h] = time;
    }

    int[][] gl(int[][] matriz, int r) {
        Optional<Optional<int[][]>> matrizl_OPT_OPT = Optional.of(Optional.of(new int[r][r]));
        Optional<Integer> EXTRACTED_33_OPT = Optional.of(0);
        for (int ii = EXTRACTED_33_OPT.get(); ii < r; ii++) {
            Optional<Integer> EXTRACTED_38_OPT = Optional.of(0);
            for (int jj = EXTRACTED_38_OPT.get(); jj < r; jj++) {
                Optional<int[]> EXTRACTED_38_OPT = Optional.of(matriz[ii]);
                Optional<Optional<int[]>> EXTRACTED_35_OPT_OPT = Optional.of(Optional.of(EXTRACTED_38_OPT.get()));
                Optional<Integer> EXTRACTED_37_OPT = Optional.of(EXTRACTED_35_OPT_OPT.get().get()[jj]);
                Optional<Optional<Integer>> EXTRACTED_39_OPT_OPT = Optional.of(Optional.of(EXTRACTED_37_OPT.get()));
                Optional<Integer> EXTRACTED_40_OPT = Optional.of(1);
                Optional<Boolean> EXTRACTED_34_OPT = Optional.of(EXTRACTED_39_OPT_OPT.get().get() == EXTRACTED_40_OPT.get());
                if (EXTRACTED_34_OPT.get()) {
                    int[] EXTRACTED_35 = matrizl_OPT_OPT.get().get()[jj];
                    Optional<int[]> EXTRACTED_36_OPT = Optional.of(EXTRACTED_35);
                    int EXTRACTED_36 = 1;
                    Optional<Integer> EXTRACTED_37_OPT = Optional.of(EXTRACTED_36);
                    EXTRACTED_36_OPT.get()[ii] = EXTRACTED_37_OPT.get();
                }
            }
        }
        return matrizl_OPT_OPT.get().get();
    }

    /**
     */
    public nos(float float0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public nos(int int0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sociologia {
    public int sociologia_callMe_not(int int0) {
        throw sociologiaConstants.CONSTANT_14;
    }

    public sociologia() {
    }

    public Object sociologia_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Scanner> EXTRACTED_39_OPT = Optional.of(new Scanner(in_OPT_OPT.get().get()));
        Optional<Optional<Scanner>> in_OPT_OPT = Optional.of(Optional.of(EXTRACTED_39_OPT.get()));
        Optional<Optional<Integer>> x_OPT_OPT = Optional.of(Optional.of(in_OPT_OPT.get().get().nextInt()));
        int y = 0;
        Optional<Optional<Queue<Integer>>> fila_OPT_OPT = Optional.of(Optional.of(sociologiaConstants.CONSTANT_15));
        Optional<Integer> EXTRACTED_40_OPT = Optional.of(0);
        for (int i = EXTRACTED_40_OPT.get(); i < x_OPT_OPT.get().get(); i++) {
            y = in_OPT_OPT.get().get().nextInt();
            int[][] EXTRACTED_41 = new int[y][y];
            Optional<Optional<int[][]>> matriz_OPT_OPT = Optional.of(Optional.of(EXTRACTED_41));
            int EXTRACTED_42 = 0;
            for (int j = EXTRACTED_42; j < y; j++) {
                Optional<Optional<Integer>> r_OPT_OPT = Optional.of(Optional.of(in_OPT_OPT.get().get().nextInt()));
                Optional<Integer> m_OPT = Optional.of(in_OPT_OPT.get().get().nextInt());
                Optional<Integer> EXTRACTED_43_OPT = Optional.of(0);
                Optional<Optional<Integer>> EXTRACTED_44_OPT_OPT = Optional.of(Optional.of(EXTRACTED_43_OPT.get()));
                for (int k = EXTRACTED_44_OPT_OPT.get().get(); k < m_OPT.get(); k++) {
                    Optional<Integer> n_OPT = Optional.of(in_OPT_OPT.get().get().nextInt());
                    Optional<Integer> EXTRACTED_44_OPT = Optional.of(r_OPT_OPT.get().get() - sociologiaConstants.CONSTANT_8);
                    Optional<Optional<Integer>> EXTRACTED_41_OPT_OPT = Optional.of(Optional.of(EXTRACTED_44_OPT.get()));
                    int EXTRACTED_42 = 1;
                    int EXTRACTED_45 = n_OPT.get() - EXTRACTED_42;
                    Optional<Integer> EXTRACTED_46_OPT = Optional.of(1);
                    int[] EXTRACTED_45 = matriz_OPT_OPT.get().get()[EXTRACTED_41_OPT_OPT.get().get()];
                    EXTRACTED_45[EXTRACTED_45] = EXTRACTED_46_OPT.get();
                }
            }
            Optional<Integer> EXTRACTED_46_OPT = Optional.of(1);
            Optional<Optional<Integer>> num_OPT_OPT = Optional.of(Optional.of(i + EXTRACTED_46_OPT.get()));
            Optional<String> EXTRACTED_43_OPT = Optional.of("Caso #");
            String EXTRACTED_47 = EXTRACTED_43_OPT.get() + num_OPT_OPT.get().get();
            System.out.println(EXTRACTED_47);
            Optional<Optional<nos>> falar_OPT_OPT = Optional.of(Optional.of(new nos(matriz_OPT_OPT.get().get(), y)));
            falar_OPT_OPT.get().get().scc();
        }
    }

    /**
     */
    public sociologia() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public sociologia(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}