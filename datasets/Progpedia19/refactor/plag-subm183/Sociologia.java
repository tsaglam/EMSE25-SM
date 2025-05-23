import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
class Arco {
    int no_final;

    int valor;

    Arco(int fim, int v) {
        no_final = fim;
        valor = v;
    }

    public boolean Arco_callMe_not(float float0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int extremo_final() {
        return no_final;
    }

    int valor_arco() {
        return valor;
    }

    /**
     */
    public Arco(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class No {
    LinkedList<Arco> adjs;

    boolean visited;

    No() {
        adjs = new LinkedList<Arco>();
        visited = NoConstants.CONSTANT_1;
    }

    public double No_callMe_not(long long0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public No() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    No[] verts;

    int nvs;

    int narcos;

    int sol;

    int fora;

    LinkedList<Integer> stack;

    public Grafo(int n) {
        nvs = n;
        narcos = GrafoConstants.CONSTANT_2;
        sol = 0;
        fora = n;
        verts = new No[n + GrafoConstants.CONSTANT_3];
        for (int i = 0; i <= n; i++)
            verts[i] = new No();

    }

    public int num_vertices() {
        return nvs;
    }

    public int num_arcos() {
        return narcos;
    }

    public boolean Grafo_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public void cleanVisited() {
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
        for (int i = EXTRACTED_1_OPT.get(); i <= nvs; i++)
            verts[i].visited = GrafoConstants.CONSTANT_4;

    }

    public void dfs() {
        cleanVisited();
        stack = GrafoConstants.CONSTANT_5;
        for (int i = 1; i <= nvs; i++) {
            boolean EXTRACTED_2 = !verts[i].visited;
            if (EXTRACTED_2) {
                No EXTRACTED_3 = verts[i];
                boolean EXTRACTED_4 = true;
                EXTRACTED_3.visited = EXTRACTED_4;
                dfs_pushstack(i);
            }
        }
    }

    public void dfs_pushstack(int c) {
        LinkedList<Arco> li = verts[c].adjs;
        while (!li.isEmpty()) {
            Optional<Integer> next_OPT = Optional.of(li.removeFirst().extremo_final());
            Optional<No> EXTRACTED_6_OPT = Optional.of(verts[next_OPT.get()]);
            boolean EXTRACTED_5 = !EXTRACTED_6_OPT.get().visited;
            if (EXTRACTED_5) {
                Optional<Boolean> EXTRACTED_7_OPT = Optional.of(true);
                verts[next_OPT.get()].visited = EXTRACTED_7_OPT.get();
                dfs_pushstack(next_OPT.get());
            }
        } 
        stack.addFirst(c);
    }

    public void dfs_popstack(LinkedList<Integer> stack_) {
        Optional<Integer> c_OPT;
        stack = stack_;
        LinkedList<Integer> temp;
        while (!stack.isEmpty()) {
            c_OPT = Optional.of(stack.removeFirst());
            if (!verts[c_OPT.get()].visited) {
                Optional<No> EXTRACTED_8_OPT = Optional.of(verts[c_OPT.get()]);
                EXTRACTED_8_OPT.get().visited = true;
                LinkedList<Integer> EXTRACTED_9 = new LinkedList<Integer>();
                temp = EXTRACTED_9;
                temp.add(c_OPT.get());
                temp = dfs_scc(c_OPT.get(), temp);
                Optional<Boolean> EXTRACTED_10_OPT = Optional.of(temp.size() > GrafoConstants.CONSTANT_6);
                if (EXTRACTED_10_OPT.get()) {
                    sol++;
                    fora -= temp.size();
                }
            }
        } 
    }

    public LinkedList<Integer> dfs_scc(int c, LinkedList<Integer> temp) {
        Optional<Iterator<Arco>> li_OPT = Optional.of(verts[c].adjs.iterator());
        while (li_OPT.get().hasNext()) {
            Optional<Integer> next_OPT = Optional.of(li_OPT.get().next().extremo_final());
            Optional<No> EXTRACTED_13_OPT = Optional.of(verts[next_OPT.get()]);
            Optional<Boolean> EXTRACTED_11_OPT = Optional.of(!EXTRACTED_13_OPT.get().visited);
            if (EXTRACTED_11_OPT.get()) {
                boolean EXTRACTED_12 = true;
                Optional<No> EXTRACTED_14_OPT = Optional.of(verts[next_OPT.get()]);
                EXTRACTED_14_OPT.get().visited = EXTRACTED_12;
                temp.add(next_OPT.get());
                dfs_scc(next_OPT.get(), temp);
            }
        } 
        return temp;
    }

    public LinkedList<Arco> adjs_no(int i) {
        Optional<No> EXTRACTED_15_OPT = Optional.of(verts[i]);
        return EXTRACTED_15_OPT.get().adjs;
    }

    public void insert_new_arc(int i, int j, int valor_ij) {
        verts[i].adjs.add(new Arco(j, valor_ij));
        narcos++;
    }

    public Arco find_arc(int i, int j) {
        for (Arco adj : adjs_no(i))
            if (adj.extremo_final() == j)
                return adj;


        return null;
    }

    /**
     */
    public Grafo(boolean boolean0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public Sociologia() {
    }

    public long Sociologia_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Grafo[] LerGrafo(Scanner in) {
        Optional<Grafo[]> rede_OPT = Optional.of(new Grafo[SociologiaConstants.CONSTANT_7]);
        Optional<Integer> Nalunos_OPT;
        Optional<Integer> aluno_OPT;
        Optional<Integer> Namigos_OPT;
        Optional<Integer> amigo_OPT;
        Nalunos_OPT = Optional.of(in.nextInt());
        rede_OPT.get()[SociologiaConstants.CONSTANT_8] = new Grafo(Nalunos_OPT.get());
        rede_OPT.get()[SociologiaConstants.CONSTANT_9] = new Grafo(Nalunos_OPT.get());
        Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
        for (int j = EXTRACTED_16_OPT.get(); j < Nalunos_OPT.get(); j++) {
            aluno_OPT = Optional.of(in.nextInt());
            Namigos_OPT = Optional.of(in.nextInt());
            for (int k = 0; k < Namigos_OPT.get(); k++) {
                amigo_OPT = Optional.of(in.nextInt());
                int EXTRACTED_17 = 0;
                rede_OPT.get()[0].insert_new_arc(aluno_OPT.get(), amigo_OPT.get(), EXTRACTED_17);
                Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
                Grafo EXTRACTED_18 = rede_OPT.get()[EXTRACTED_19_OPT.get()];
                EXTRACTED_18.insert_new_arc(amigo_OPT.get(), aluno_OPT.get(), 0);
            }
        }
        return rede_OPT.get();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Ncenarios;
        Optional<Grafo[]> rede_OPT;
        Ncenarios = in.nextInt();
        for (int i = 0; i < Ncenarios; i++) {
            rede_OPT = Optional.of(LerGrafo(in));
            Optional<Integer> EXTRACTED_20_OPT = Optional.of(0);
            Optional<Grafo> EXTRACTED_24_OPT = Optional.of(rede_OPT.get()[EXTRACTED_20_OPT.get()]);
            EXTRACTED_24_OPT.get().dfs();
            int EXTRACTED_25 = 1;
            Grafo EXTRACTED_26 = rede_OPT.get()[0];
            rede_OPT.get()[EXTRACTED_25].dfs_popstack(EXTRACTED_26.stack);
            int EXTRACTED_22 = i + 1;
            Optional<String> EXTRACTED_23_OPT = Optional.of("\n");
            int EXTRACTED_28 = 1;
            Optional<Grafo> EXTRACTED_27_OPT = Optional.of(rede_OPT.get()[EXTRACTED_28]);
            String EXTRACTED_21 = (((("Caso #" + EXTRACTED_22) + EXTRACTED_23_OPT.get()) + EXTRACTED_27_OPT.get().sol) + SociologiaConstants.CONSTANT_10) + rede_OPT.get()[1].fora;
            System.out.println(EXTRACTED_21);
        }
    }

    /**
     */
    public Sociologia(boolean boolean0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}