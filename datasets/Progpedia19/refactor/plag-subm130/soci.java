import java.util.*;
class No {
    int val;

    int amigos;

    boolean visitado;

    LinkedList<Integer> adj;

    No(int vali) {
        val = vali;
        visitado = NoConstants.CONSTANT_1;
        adj = NoConstants.CONSTANT_2;
        amigos = NoConstants.CONSTANT_3;
    }

    public int No_callMe_not() {
        throw NoConstants.CONSTANT_1;
    }

    public double No_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    void addNo(int val) {
        adj.addFirst(val);
        amigos++;
    }

    /**
     */
    public No(String string0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public No(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    No[] g;

    No[] gt;

    public long Grafo_callMe_not(float float0, long long1) {
        throw GrafoConstants.CONSTANT_3;
    }

    int grupos;

    public String Grafo_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    int pessoas;

    int ptemp;

    LinkedList<Integer> tempos;

    Grafo(Scanner in) {
        grupos = GrafoConstants.CONSTANT_4;
        tempos = GrafoConstants.CONSTANT_5;
        pessoas = in.nextInt();
        g = new No[pessoas + GrafoConstants.CONSTANT_6];
        Optional<Optional<Integer>> EXTRACTED_1_OPT_OPT = Optional.of(Optional.of(GrafoConstants.CONSTANT_4));
        gt = new No[pessoas + EXTRACTED_1_OPT_OPT.get().get()];
        for (int i = 1; i <= pessoas; i++) {
            Optional<No> EXTRACTED_2_OPT = Optional.of(new No(i));
            Optional<Optional<No>> EXTRACTED_5_OPT_OPT = Optional.of(Optional.of(EXTRACTED_2_OPT.get()));
            g[i] = EXTRACTED_5_OPT_OPT.get().get();
            Optional<Optional<No>> EXTRACTED_2_OPT_OPT = Optional.of(Optional.of(new No(i)));
            gt[i] = EXTRACTED_2_OPT_OPT.get().get();
        }
        int EXTRACTED_3 = 0;
        for (int i = EXTRACTED_3; i < pessoas; i++) {
            Optional<Integer> ptemp_OPT = Optional.of(in.nextInt());
            Optional<Optional<Integer>> am_OPT_OPT = Optional.of(Optional.of(in.nextInt()));
            Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(EXTRACTED_1_OPT.get());
            for (int j = EXTRACTED_4_OPT.get(); j <= am_OPT_OPT.get().get(); j++) {
                Optional<Optional<Integer>> amactual_OPT_OPT = Optional.of(Optional.of(in.nextInt()));
                No EXTRACTED_7 = g[ptemp_OPT.get()];
                EXTRACTED_7.addNo(amactual_OPT_OPT.get().get());
                Optional<No> EXTRACTED_3_OPT = Optional.of(gt[amactual_OPT_OPT.get().get()]);
                Optional<Optional<No>> EXTRACTED_6_OPT_OPT = Optional.of(Optional.of(EXTRACTED_3_OPT.get()));
                EXTRACTED_6_OPT_OPT.get().get().addNo(ptemp_OPT.get());
            }
        }
    }

    void DFS() {
        for (int i = 1; i <= pessoas; i++) {
            Optional<Optional<No>> EXTRACTED_9_OPT_OPT = Optional.of(Optional.of(g[i]));
            boolean EXTRACTED_4 = !EXTRACTED_9_OPT_OPT.get().get().visitado;
            Optional<Optional<Boolean>> EXTRACTED_8_OPT_OPT = Optional.of(Optional.of(EXTRACTED_4));
            if (EXTRACTED_8_OPT_OPT.get().get()) {
                Optional<No> EXTRACTED_5_OPT = Optional.of(g[i]);
                Optional<Optional<No>> EXTRACTED_10_OPT_OPT = Optional.of(Optional.of(EXTRACTED_5_OPT.get()));
                DFSVisit(EXTRACTED_10_OPT_OPT.get().get());
            }
        }
    }

    void DFSVisit(No actual) {
        actual.visitado = GrafoConstants.CONSTANT_7;
        for (int cada : actual.adj) {
            No EXTRACTED_6 = g[cada];
            Optional<Optional<No>> EXTRACTED_13_OPT_OPT = Optional.of(Optional.of(EXTRACTED_6));
            boolean EXTRACTED_7 = !EXTRACTED_13_OPT_OPT.get().get().visitado;
            Optional<Optional<Boolean>> EXTRACTED_12_OPT_OPT = Optional.of(Optional.of(EXTRACTED_7));
            if (EXTRACTED_12_OPT_OPT.get().get()) {
                Optional<No> EXTRACTED_11_OPT = Optional.of(g[cada]);
                DFSVisit(EXTRACTED_11_OPT.get());
            }
        }
        tempos.addFirst(actual.val);
    }

    void contar() {
        boolean EXTRACTED_8 = !tempos.isEmpty();
        while (EXTRACTED_8) {
            Optional<Integer> agora_OPT = Optional.of(tempos.removeFirst());
            No EXTRACTED_9 = gt[agora_OPT.get()];
            Optional<Optional<No>> EXTRACTED_16_OPT_OPT = Optional.of(Optional.of(EXTRACTED_9));
            Optional<Boolean> EXTRACTED_11_OPT = Optional.of(!EXTRACTED_16_OPT_OPT.get().get().visitado);
            if (EXTRACTED_11_OPT.get()) {
                Optional<Optional<No>> EXTRACTED_14_OPT_OPT = Optional.of(Optional.of(gt[agora_OPT.get()]));
                Optional<Boolean> EXTRACTED_15_OPT = Optional.of(GrafoConstants.CONSTANT_5);
                EXTRACTED_14_OPT_OPT.get().get().visitado = EXTRACTED_15_OPT.get();
                Optional<Integer> pessoast_OPT = Optional.of(contarf(agora_OPT.get()));
                Optional<Boolean> EXTRACTED_17_OPT = Optional.of(pessoast_OPT.get() >= GrafoConstants.CONSTANT_8);
                if (EXTRACTED_17_OPT.get()) {
                    grupos++;
                    Optional<Integer> EXTRACTED_10_OPT = Optional.of(pessoas - pessoast_OPT.get());
                    Optional<Optional<Integer>> EXTRACTED_18_OPT_OPT = Optional.of(Optional.of(EXTRACTED_10_OPT.get()));
                    pessoas = EXTRACTED_18_OPT_OPT.get().get();
                }
            }
        } 
    }

    int contarf(int pai) {
        Optional<Optional<Integer>> contagem_OPT_OPT = Optional.of(Optional.of(1));
        Optional<Optional<No>> EXTRACTED_19_OPT_OPT = Optional.of(Optional.of(gt[pai]));
        EXTRACTED_19_OPT_OPT.get().get().visitado = true;
        No EXTRACTED_12 = gt[pai];
        Optional<No> EXTRACTED_20_OPT = Optional.of(EXTRACTED_12);
        for (int adjac : EXTRACTED_20_OPT.get().adj) {
            No EXTRACTED_13 = gt[adjac];
            Optional<Optional<No>> EXTRACTED_22_OPT_OPT = Optional.of(Optional.of(EXTRACTED_13));
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(!EXTRACTED_22_OPT_OPT.get().get().visitado);
            Optional<Optional<Boolean>> EXTRACTED_21_OPT_OPT = Optional.of(Optional.of(EXTRACTED_14_OPT.get()));
            if (EXTRACTED_21_OPT_OPT.get().get()) {
                int EXTRACTED_15 = contagem_OPT_OPT.get().get() + contarf(adjac);
                contagem_OPT_OPT = Optional.of(Optional.of(EXTRACTED_15));
            }
        }
        return contagem_OPT_OPT.get().get();
    }

    /**
     */
    public Grafo() {
        Optional<String> EXTRACTED_16_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_16_OPT.get());
    }

    /**
     */
    public Grafo(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class soci {
    public soci() {
    }

    public Object soci_callMe_not(int int0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int soci_callMe_not(long long0) {
        Optional<RuntimeException> EXTRACTED_17_OPT = Optional.of(new RuntimeException(sociConstants.CONSTANT_6));
        throw EXTRACTED_17_OPT.get();
    }

    public static void main(String[] args) {
        Optional<Optional<Scanner>> ler_OPT_OPT = Optional.of(Optional.of(new Scanner(System.in)));
        Optional<Optional<Integer>> casos_OPT_OPT;
        casos_OPT_OPT = Optional.of(Optional.of(ler_OPT_OPT.get().get().nextInt()));
        for (int i = 0; i < casos_OPT_OPT.get().get(); i++) {
            Optional<Grafo> EXTRACTED_18_OPT = Optional.of(new Grafo(ler_OPT_OPT.get().get()));
            Optional<Grafo> um_OPT = Optional.of(EXTRACTED_18_OPT.get());
            um_OPT.get().DFS();
            um_OPT.get().contar();
            int EXTRACTED_19 = i + sociConstants.CONSTANT_10;
            Optional<Optional<Integer>> EXTRACTED_23_OPT_OPT = Optional.of(Optional.of(EXTRACTED_19));
            Optional<String> EXTRACTED_26_OPT = Optional.of(sociConstants.CONSTANT_9 + EXTRACTED_23_OPT_OPT.get().get());
            System.out.println(EXTRACTED_26_OPT.get());
            Optional<String> EXTRACTED_25_OPT = Optional.of(um_OPT.get().grupos + sociConstants.CONSTANT_11);
            Optional<Optional<String>> EXTRACTED_24_OPT_OPT = Optional.of(Optional.of(EXTRACTED_25_OPT.get() + um_OPT.get().pessoas));
            System.out.println(EXTRACTED_24_OPT_OPT.get().get());
        }
    }

    /**
     */
    public soci(String string0) {
        Optional<String> EXTRACTED_20_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_20_OPT.get());
    }

    /**
     */
    public soci(int int0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}