import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
class Adjs {
    public Adjs() {
    }

    LinkedList<Integer> adjs = new LinkedList<Integer>();

    public Object Adjs_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Adjs(int int0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    public int Grafo_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Adjs[] verts;

    Grafo(int nv) {
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(nv + GrafoConstants.CONSTANT_1);
        Optional<Adjs[]> EXTRACTED_1_OPT = Optional.of(new Adjs[EXTRACTED_2_OPT.get()]);
        verts = EXTRACTED_1_OPT.get();
        for (int i = 0; i <= nv; i++) {
            verts[i] = GrafoConstants.CONSTANT_2;
        }
    }

    /**
     */
    public Grafo(int int0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class sociologo {
    public sociologo() {
    }

    static int res1 = 0;

    static int res2 = 0;

    public int sociologo_callMe_not(Object object0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static int DFSVISIT(Grafo a, int val, int instante, int[] cor, int[] posnum) {
        cor[val] = sociologoConstants.CONSTANT_3;
        Optional<Adjs> EXTRACTED_3_OPT = Optional.of(a.verts[val]);
        while (!EXTRACTED_3_OPT.get().adjs.isEmpty()) {
            Optional<Adjs> EXTRACTED_4_OPT = Optional.of(a.verts[val]);
            Optional<Integer> analisa_OPT = Optional.of(EXTRACTED_4_OPT.get().adjs.removeFirst());
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(cor[analisa_OPT.get()]);
            if (EXTRACTED_5_OPT.get() == 0)
                instante = DFSVISIT(a, analisa_OPT.get(), instante, cor, posnum);

        } 
        instante++;
        posnum[val] = instante;
        return instante;
    }

    public static void DFS(Grafo a, int n, Stack<Integer> v, int[] posnum) {
        Optional<Integer> instante_OPT = Optional.of(0);
        Optional<int[]> prev_OPT = Optional.of(new int[n]);
        for (int i = 1; i < n; i++)
            prev_OPT.get()[i] = Integer.MAX_VALUE;

        int[] cor = new int[n];
        while (!v.empty()) {
            Optional<Integer> val_OPT = Optional.of(v.pop());
            Optional<Integer> EXTRACTED_7_OPT = Optional.of(cor[val_OPT.get()]);
            Optional<Boolean> EXTRACTED_6_OPT = Optional.of(EXTRACTED_7_OPT.get() == 0);
            if (EXTRACTED_6_OPT.get()) {
                instante_OPT = Optional.of(DFSVISIT(a, val_OPT.get(), instante_OPT.get(), cor, posnum));
            }
        } 
    }

    public static int DFSnVISIT(Grafo a, int val, int instante, int[] cor) {
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(1);
        cor[val] = EXTRACTED_8_OPT.get();
        Optional<Adjs> EXTRACTED_10_OPT = Optional.of(a.verts[val]);
        Optional<Boolean> EXTRACTED_9_OPT = Optional.of(!EXTRACTED_10_OPT.get().adjs.isEmpty());
        while (EXTRACTED_9_OPT.get()) {
            Optional<Integer> analisa_OPT = Optional.of(a.verts[val].adjs.removeFirst());
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
            if (cor[analisa_OPT.get()] == EXTRACTED_11_OPT.get())
                instante = DFSnVISIT(a, analisa_OPT.get(), instante, cor);

        } 
        instante++;
        return instante;
    }

    public static void DFSN(Grafo a, int n, Stack<Integer> v) {
        Optional<Integer> instante_OPT = Optional.of(0);
        Optional<int[]> prev_OPT = Optional.of(new int[n]);
        Optional<Integer> EXTRACTED_12_OPT = Optional.of(1);
        for (int i = EXTRACTED_12_OPT.get(); i < n; i++)
            prev_OPT.get()[i] = Integer.MAX_VALUE;

        int[] cor = new int[n];
        while (!v.empty()) {
            int EXTRACTED_14 = 0;
            instante_OPT = Optional.of(EXTRACTED_14);
            int val = v.pop();
            int EXTRACTED_13 = cor[val];
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_15_OPT = Optional.of(EXTRACTED_13 == EXTRACTED_16_OPT.get());
            if (EXTRACTED_15_OPT.get()) {
                instante_OPT = Optional.of(DFSnVISIT(a, val, instante_OPT.get(), cor));
                Optional<Boolean> EXTRACTED_17_OPT = Optional.of(instante_OPT.get() >= sociologoConstants.CONSTANT_4);
                if (!EXTRACTED_17_OPT.get()) {
                    res2 += instante_OPT.get();
                } else
                    res1++;

            }
        } 
    }

    public static void main(String[] args) {
        Optional<Scanner> io_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> testes_OPT = Optional.of(io_OPT.get().nextInt());
        Stack<Integer> pilha = new Stack<Integer>();
        for (int i = 1; i <= testes_OPT.get(); i++) {
            Optional<Integer> n_OPT = Optional.of(io_OPT.get().nextInt() + 1);
            Optional<Grafo> a_OPT = Optional.of(new Grafo(n_OPT.get()));
            Optional<Grafo> b_OPT = Optional.of(new Grafo(n_OPT.get()));
            Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
            for (int j = EXTRACTED_20_OPT.get(); j < n_OPT.get(); j++) {
                Optional<Integer> liga_OPT = Optional.of(io_OPT.get().nextInt());
                pilha.add(liga_OPT.get());
                Optional<Integer> nfilhos_OPT = Optional.of(io_OPT.get().nextInt());
                Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
                for (int t = EXTRACTED_18_OPT.get(); t < nfilhos_OPT.get(); t++) {
                    Optional<Integer> filho_OPT = Optional.of(io_OPT.get().nextInt());
                    Optional<Adjs> EXTRACTED_21_OPT = Optional.of(a_OPT.get().verts[liga_OPT.get()]);
                    EXTRACTED_21_OPT.get().adjs.addFirst(filho_OPT.get());
                    Adjs EXTRACTED_22 = b_OPT.get().verts[filho_OPT.get()];
                    EXTRACTED_22.adjs.addFirst(liga_OPT.get());
                }
            }
            Optional<int[]> posnum_OPT = Optional.of(new int[n_OPT.get()]);
            DFS(a_OPT.get(), n_OPT.get(), pilha, posnum_OPT.get());
            for (int j = 1; j < n_OPT.get(); j++) {
                Optional<Integer> EXTRACTED_28_OPT = Optional.of(1);
                for (int t = EXTRACTED_28_OPT.get(); t < n_OPT.get(); t++) {
                    int EXTRACTED_24 = posnum_OPT.get()[t];
                    Optional<Boolean> EXTRACTED_23_OPT = Optional.of(EXTRACTED_24 == j);
                    if (EXTRACTED_23_OPT.get())
                        pilha.push(t);

                }
            }
            DFSN(b_OPT.get(), n_OPT.get(), pilha);
            Optional<String> EXTRACTED_25_OPT = Optional.of(sociologoConstants.CONSTANT_5 + i);
            System.out.println(EXTRACTED_25_OPT.get());
            Optional<String> EXTRACTED_26_OPT = Optional.of(sociologoConstants.CONSTANT_6 + res1);
            Optional<String> EXTRACTED_19_OPT = Optional.of(EXTRACTED_26_OPT.get() + sociologoConstants.CONSTANT_7);
            System.out.println(EXTRACTED_19_OPT.get() + res2);
            res1 = 0;
            int EXTRACTED_27 = 0;
            res2 = EXTRACTED_27;
        }
    }

    /**
     */
    public sociologo() {
        throw new RuntimeException("You'd better not have called me!");
    }
}