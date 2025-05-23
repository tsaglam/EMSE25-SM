import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
class Arco {
    int no_final;

    public double Arco_callMe_not(double double0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Arco(int fim) {
        no_final = fim;
    }

    int extremo_final() {
        return no_final;
    }

    /**
     */
    public Arco(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class No {
    public double No_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    LinkedList<Arco> adjs;

    int cor;

    int id;

    No(int i) {
        cor = NoConstants.CONSTANT_1;
        adjs = NoConstants.CONSTANT_2;
        id = i;
    }

    /**
     */
    public No(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    No[] verts;

    int nvs;

    int narcos;

    public Grafo(int n) {
        nvs = n;
        narcos = GrafoConstants.CONSTANT_3;
        No[] EXTRACTED_1 = new No[n + GrafoConstants.CONSTANT_4];
        verts = EXTRACTED_1;
        for (int i = 0; i <= n; i++) {
            Optional<No> EXTRACTED_2_OPT = Optional.of(new No(i));
            verts[i] = EXTRACTED_2_OPT.get();
        }
    }

    public int num_vertices() {
        return nvs;
    }

    public int num_arcos() {
        return narcos;
    }

    public LinkedList<Arco> adjs_no(int i) {
        return verts[i].adjs;
    }

    public Arco find_arc(int i, int j) {
        for (Arco adj : adjs_no(i)) {
            boolean EXTRACTED_3 = adj.extremo_final() == j;
            if (EXTRACTED_3)
                return adj;

        }
        return null;
    }

    public float Grafo_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Grafo(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public Sociologia() {
    }

    static Scanner ler = new Scanner(System.in);

    static Grafo g;

    public float Sociologia_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Grafo gInv;

    static Stack<Integer> pilhaDFS = new Stack<Integer>();

    static Stack<Integer> inversa = new Stack<Integer>();

    static int nverts;

    public static void main(String[] args) {
        int ncasos = ler.nextInt();
        for (int i = 0; i < ncasos; i++) {
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(i + 1);
            Optional<String> EXTRACTED_4_OPT = Optional.of("Caso #" + EXTRACTED_5_OPT.get());
            System.out.println(EXTRACTED_4_OPT.get());
            g = lergrafo();
            resolveprob(g);
            escreveresp();
            System.out.println();
        }
    }

    public static Grafo lergrafo() {
        Optional<Integer> aluno_OPT;
        int amigos;
        int amigo;
        Optional<Integer> nalunos_OPT = Optional.of(ler.nextInt());
        Optional<Grafo> temp_OPT = Optional.of(new Grafo(nalunos_OPT.get()));
        for (int i = 0; i < nalunos_OPT.get(); i++) {
            aluno_OPT = Optional.of(ler.nextInt());
            amigos = ler.nextInt();
            Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
            for (int j = EXTRACTED_6_OPT.get(); j < amigos; j++) {
                amigo = ler.nextInt();
                No EXTRACTED_7 = temp_OPT.get().verts[aluno_OPT.get()];
                Arco EXTRACTED_8 = new Arco(amigo);
                EXTRACTED_7.adjs.add(EXTRACTED_8);
            }
        }
        return temp_OPT.get();
    }

    public static void resolveprob(Grafo g) {
        Optional<Grafo> EXTRACTED_9_OPT = Optional.of(new Grafo(g.verts.length));
        gInv = EXTRACTED_9_OPT.get();
        for (int i = 1; i <= g.nvs; i++) {
            boolean EXTRACTED_10 = !pilhaDFS.contains(g.verts[i].id);
            if (EXTRACTED_10)
                DFS(g, g.verts[i]);

        }
        gInv = inverso();
    }

    public static Grafo inverso() {
        Optional<Grafo> temp_OPT = Optional.of(new Grafo(Sociologia.g.verts.length));
        Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
        for (int i = EXTRACTED_11_OPT.get(); i < Sociologia.g.verts.length; i++) {
            Optional<No> EXTRACTED_12_OPT = Optional.of(g.verts[i]);
            for (int j = 0; j < EXTRACTED_12_OPT.get().adjs.size(); j++) {
                No EXTRACTED_14 = g.verts[i];
                int temp2 = EXTRACTED_14.adjs.get(j).no_final;
                No EXTRACTED_15 = temp_OPT.get().verts[temp2];
                EXTRACTED_15.adjs.add(new Arco(i));
            }
        }
        int EXTRACTED_13 = 0;
        while (pilhaDFS.size() > EXTRACTED_13)
            inversa.push(pilhaDFS.pop());

        return temp_OPT.get();
    }

    public static void escreveresp() {
        int ngrupos = 0;
        int npessoas;
        int sozinhas = 0;
        Optional<Integer> v_OPT;
        while (!inversa.isEmpty()) {
            v_OPT = Optional.of(inversa.pop());
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(1);
            nverts = EXTRACTED_16_OPT.get();
            DFS_INV(gInv, v_OPT.get());
            npessoas = nverts;
            if (!(npessoas >= SociologiaConstants.CONSTANT_5)) {
                Optional<Integer> EXTRACTED_17_OPT = Optional.of(sozinhas + npessoas);
                sozinhas = EXTRACTED_17_OPT.get();
            } else
                ngrupos++;

        } 
        String EXTRACTED_18 = ngrupos + SociologiaConstants.CONSTANT_6;
        System.out.print(EXTRACTED_18 + sozinhas);
    }

    public static void DFS(Grafo g, No v) {
        v.cor = 1;
        for (int i = 0; i < v.adjs.size(); i++) {
            Optional<No> EXTRACTED_20_OPT = Optional.of(g.verts[v.adjs.get(i).no_final]);
            Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
            if (EXTRACTED_20_OPT.get().cor == EXTRACTED_21_OPT.get()) {
                Optional<No> EXTRACTED_19_OPT = Optional.of(g.verts[v.adjs.get(i).no_final]);
                Optional<Integer> EXTRACTED_23_OPT = Optional.of(1);
                EXTRACTED_19_OPT.get().cor = EXTRACTED_23_OPT.get();
                Optional<No> EXTRACTED_22_OPT = Optional.of(g.verts[v.adjs.get(i).no_final]);
                DFS(g, EXTRACTED_22_OPT.get());
            }
        }
        v.cor = SociologiaConstants.CONSTANT_7;
        pilhaDFS.push(v.id);
    }

    public static void DFS_INV(Grafo g2, int v) {
        Optional<Integer> EXTRACTED_24_OPT = Optional.of(1);
        g2.verts[v].cor = EXTRACTED_24_OPT.get();
        if (procura(v) != SociologiaConstants.CONSTANT_8) {
            inversa.remove(procura(v));
        }
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
        for (int i = EXTRACTED_25_OPT.get(); i < g2.verts[v].adjs.size(); i++) {
            Optional<No> EXTRACTED_27_OPT = Optional.of(g2.verts[g2.verts[v].adjs.get(i).no_final]);
            int EXTRACTED_28 = 0;
            Optional<Boolean> EXTRACTED_26_OPT = Optional.of(EXTRACTED_27_OPT.get().cor == EXTRACTED_28);
            if (EXTRACTED_26_OPT.get()) {
                nverts++;
                No EXTRACTED_30 = g2.verts[v];
                No EXTRACTED_29 = g2.verts[EXTRACTED_30.adjs.get(i).no_final];
                DFS_INV(g2, EXTRACTED_29.id);
            }
        }
        g2.verts[v].cor = 2;
    }

    public static int procura(int n) {
        Optional<Integer> EXTRACTED_31_OPT = Optional.of(0);
        for (int i = EXTRACTED_31_OPT.get(); i < inversa.size(); i++) {
            Optional<Boolean> EXTRACTED_32_OPT = Optional.of(inversa.get(i) == n);
            if (EXTRACTED_32_OPT.get())
                return i;

        }
        Optional<Integer> EXTRACTED_34_OPT = Optional.of(1);
        Optional<Integer> EXTRACTED_33_OPT = Optional.of(-EXTRACTED_34_OPT.get());
        return EXTRACTED_33_OPT.get();
    }

    /**
     */
    public Sociologia(double double0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}