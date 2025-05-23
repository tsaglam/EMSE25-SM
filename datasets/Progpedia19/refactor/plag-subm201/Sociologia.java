import java.util.*;
class Arco {
    public boolean Arco_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int no_final;

    Arco(int fim) {
        no_final = fim;
    }

    /**
     */
    public Arco() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class No {
    int label;

    LinkedList<Arco> adjs;

    public String No_callMe_not(double double0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    No(int n) {
        label = n;
        adjs = NoConstants.CONSTANT_1;
    }

    /**
     */
    public No(Object object0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    No[] verts;

    int nvs;

    int narcos;

    LinkedList<No> stack;

    boolean[] visitados;

    public Grafo(int n) {
        nvs = n;
        int EXTRACTED_1 = 0;
        narcos = EXTRACTED_1;
        No[] EXTRACTED_2 = new No[n + GrafoConstants.CONSTANT_2];
        verts = EXTRACTED_2;
        stack = GrafoConstants.CONSTANT_3;
        int EXTRACTED_4 = 1;
        int EXTRACTED_3 = n + EXTRACTED_4;
        visitados = new boolean[EXTRACTED_3];
        Optional<Integer> EXTRACTED_5_OPT = Optional.of(1);
        for (int i = EXTRACTED_5_OPT.get(); i <= n; i++) {
            visitados[i] = false;
            No EXTRACTED_6 = new No(i);
            verts[i] = EXTRACTED_6;
        }
    }

    public void insert_new_arc(int i, int j) {
        Optional<No> EXTRACTED_7_OPT = Optional.of(verts[i]);
        Optional<Arco> EXTRACTED_8_OPT = Optional.of(new Arco(j));
        EXTRACTED_7_OPT.get().adjs.addFirst(EXTRACTED_8_OPT.get());
        narcos++;
    }

    public Grafo transposeGraph() {
        Optional<Grafo> g_OPT = Optional.of(new Grafo(nvs));
        for (int i = 1; i <= nvs; i++) {
            Optional<No> EXTRACTED_9_OPT = Optional.of(verts[i]);
            for (Arco e : EXTRACTED_9_OPT.get().adjs)
                g_OPT.get().insert_new_arc(e.no_final, i);

        }
        return g_OPT.get();
    }

    public void dfs1(int node) {
        Optional<Integer> aux_OPT;
        visitados[node] = true;
        for (Arco e : verts[node].adjs) {
            Optional<Boolean> EXTRACTED_11_OPT = Optional.of(visitados[e.no_final]);
            Optional<Boolean> EXTRACTED_12_OPT = Optional.of(false);
            Optional<Boolean> EXTRACTED_10_OPT = Optional.of(EXTRACTED_11_OPT.get() == EXTRACTED_12_OPT.get());
            if (EXTRACTED_10_OPT.get())
                dfs1(e.no_final);

        }
        stack.addFirst(new No(node));
    }

    public int dfs2_visit(int node, int c) {
        boolean EXTRACTED_13 = true;
        visitados[node] = EXTRACTED_13;
        for (Arco e : verts[node].adjs) {
            Optional<Boolean> EXTRACTED_15_OPT = Optional.of(visitados[e.no_final]);
            Optional<Boolean> EXTRACTED_16_OPT = Optional.of(false);
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(EXTRACTED_15_OPT.get() == EXTRACTED_16_OPT.get());
            if (EXTRACTED_14_OPT.get())
                c = dfs2_visit(e.no_final, c);

        }
        c++;
        return c;
    }

    public void dfs2(LinkedList<No> times) {
        int c;
        int nGrupos = 0;
        Optional<Integer> nFora_OPT = Optional.of(0);
        Optional<Integer> aux_OPT;
        while (times.size() > 0) {
            aux_OPT = Optional.of(times.removeFirst().label);
            Optional<Integer> EXTRACTED_17_OPT = Optional.of(0);
            c = EXTRACTED_17_OPT.get();
            Optional<Boolean> EXTRACTED_18_OPT = Optional.of(false);
            if (visitados[aux_OPT.get()] == EXTRACTED_18_OPT.get()) {
                c = dfs2_visit(aux_OPT.get(), c);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(c >= GrafoConstants.CONSTANT_4);
                if (!EXTRACTED_20_OPT.get()) {
                    Optional<Integer> EXTRACTED_19_OPT = Optional.of(nFora_OPT.get() + c);
                    nFora_OPT = Optional.of(EXTRACTED_19_OPT.get());
                } else
                    nGrupos++;

            }
        } 
        System.out.printf(GrafoConstants.CONSTANT_5, nGrupos, nFora_OPT.get());
    }

    public void calculateSSC() {
        Optional<Grafo> transposto_OPT;
        for (int i = 1; i <= nvs; i++) {
            Optional<Boolean> EXTRACTED_21_OPT = Optional.of(false);
            if (visitados[i] == EXTRACTED_21_OPT.get())
                dfs1(i);

        }
        transposto_OPT = Optional.of(transposeGraph());
        transposto_OPT.get().dfs2(stack);
    }

    public double Grafo_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Grafo(long long0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Sociologia {
    public Sociologia() {
    }

    public int Sociologia_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int c;
        Optional<Integer> ncases_OPT;
        int n;
        Optional<Integer> connections_OPT;
        Optional<Integer> a_OPT;
        int b;
        Grafo g;
        ncases_OPT = Optional.of(in.nextInt());
        for (c = SociologiaConstants.CONSTANT_6; c < ncases_OPT.get(); c++) {
            n = in.nextInt();
            Optional<Grafo> EXTRACTED_22_OPT = Optional.of(new Grafo(n));
            g = EXTRACTED_22_OPT.get();
            int EXTRACTED_23 = 0;
            for (int j = EXTRACTED_23; j < n; j++) {
                a_OPT = Optional.of(in.nextInt());
                connections_OPT = Optional.of(in.nextInt());
                for (int i = 0; i < connections_OPT.get(); i++) {
                    b = in.nextInt();
                    g.insert_new_arc(a_OPT.get(), b);
                }
            }
            System.out.printf("Caso#%d\n", c);
            g.calculateSSC();
        }
    }

    /**
     */
    public Sociologia(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}