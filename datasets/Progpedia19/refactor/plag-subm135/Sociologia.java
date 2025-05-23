import java.util.*;
class Pessoa {
    int id;

    int namigos;

    int[] amigos;

    int t;

    boolean visitado;

    Pessoa(int i) {
        id = i;
        Optional<Boolean> EXTRACTED_1_OPT = Optional.of(false);
        visitado = EXTRACTED_1_OPT.get();
    }

    public long Pessoa_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Pessoa(int i, int n) {
        id = i;
        namigos = n;
        amigos = new int[namigos];
        t = PessoaConstants.CONSTANT_1;
        visitado = false;
    }

    int pos() {
        int p = 0;
        int EXTRACTED_2 = 0;
        for (int i = EXTRACTED_2; i < amigos.length; i++) {
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(amigos[i] != EXTRACTED_4_OPT.get());
            if (EXTRACTED_3_OPT.get())
                p++;

        }
        return p;
    }

    /**
     */
    public Pessoa() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    int nos;

    int tempo;

    Pessoa[] ppl;

    public String Grafo_callMe_not(long long0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Pessoa[] tppl;

    int ngrupos;

    int nelementos;

    int res;

    int visitados;

    Grafo(int n) {
        nos = n;
        tempo = 0;
        ppl = new Pessoa[n + GrafoConstants.CONSTANT_2];
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(1);
        int EXTRACTED_5 = n + EXTRACTED_6_OPT.get();
        tppl = new Pessoa[EXTRACTED_5];
        ngrupos = 0;
        int EXTRACTED_7 = 0;
        nelementos = EXTRACTED_7;
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
        res = EXTRACTED_8_OPT.get();
        int EXTRACTED_9 = 0;
        visitados = EXTRACTED_9;
    }

    void criar(Scanner kb) {
        for (int i = 1; i <= nos; i++) {
            Optional<Pessoa> EXTRACTED_10_OPT = Optional.of(new Pessoa(i));
            ppl[i] = EXTRACTED_10_OPT.get();
            Optional<Pessoa> EXTRACTED_11_OPT = Optional.of(new Pessoa(i, nos));
            tppl[i] = EXTRACTED_11_OPT.get();
        }
        for (int i = 0; i < nos; i++) {
            Optional<Integer> id_OPT = Optional.of(kb.nextInt());
            Optional<Integer> nf_OPT = Optional.of(kb.nextInt());
            Optional<Pessoa> nova_OPT = Optional.of(new Pessoa(id_OPT.get(), nf_OPT.get()));
            ppl[id_OPT.get()] = nova_OPT.get();
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
            for (int j = EXTRACTED_12_OPT.get(); j < nf_OPT.get(); j++) {
                Optional<Integer> f_OPT = Optional.of(kb.nextInt());
                Optional<Pessoa> EXTRACTED_13_OPT = Optional.of(ppl[id_OPT.get()]);
                EXTRACTED_13_OPT.get().amigos[j] = f_OPT.get();
            }
        }
    }

    void transpor() {
        Optional<Integer> EXTRACTED_14_OPT = Optional.of(1);
        for (int i = EXTRACTED_14_OPT.get(); i <= nos; i++) {
            Optional<Integer> aux_OPT;
            Optional<Integer> in_OPT;
            Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
            Pessoa EXTRACTED_19 = ppl[i];
            for (int j = EXTRACTED_18_OPT.get(); j < EXTRACTED_19.amigos.length; j++) {
                Optional<Pessoa> EXTRACTED_15_OPT = Optional.of(ppl[i]);
                Optional<Integer> EXTRACTED_20_OPT = Optional.of(EXTRACTED_15_OPT.get().amigos[j]);
                aux_OPT = Optional.of(EXTRACTED_20_OPT.get());
                Optional<Pessoa> EXTRACTED_16_OPT = Optional.of(tppl[aux_OPT.get()]);
                in_OPT = Optional.of(EXTRACTED_16_OPT.get().pos());
                Pessoa EXTRACTED_17 = tppl[aux_OPT.get()];
                EXTRACTED_17.amigos[in_OPT.get()] = i;
            }
        }
    }

    void dfs() {
        Optional<Integer> EXTRACTED_21_OPT = Optional.of(1);
        for (int i = EXTRACTED_21_OPT.get(); i < ppl.length; i++) {
            Optional<Boolean> EXTRACTED_22_OPT = Optional.of(ppl[i].visitado == GrafoConstants.CONSTANT_3);
            if (EXTRACTED_22_OPT.get())
                dfs_visit(i);

        }
    }

    void dfs_visit(int x) {
        Optional<Boolean> EXTRACTED_23_OPT = Optional.of(false);
        if (ppl[x].visitado == EXTRACTED_23_OPT.get()) {
            Pessoa EXTRACTED_26 = ppl[x];
            EXTRACTED_26.visitado = GrafoConstants.CONSTANT_4;
            int EXTRACTED_27 = 0;
            for (int j = EXTRACTED_27; j < ppl[x].amigos.length; j++) {
                Optional<Pessoa> EXTRACTED_24_OPT = Optional.of(ppl[x]);
                Optional<Integer> EXTRACTED_28_OPT = Optional.of(EXTRACTED_24_OPT.get().amigos[j]);
                dfs_visit(EXTRACTED_28_OPT.get());
            }
            tempo++;
            Pessoa EXTRACTED_25 = ppl[x];
            EXTRACTED_25.t = tempo;
        }
    }

    int findMax() {
        Optional<Integer> max_OPT = Optional.of(-1);
        Optional<Integer> indice_OPT = Optional.of(-1);
        for (int i = 1; i <= nos; i++) {
            Pessoa EXTRACTED_30 = tppl[i];
            Optional<Boolean> EXTRACTED_31_OPT = Optional.of(false);
            Optional<Boolean> EXTRACTED_29_OPT = Optional.of(EXTRACTED_30.visitado == EXTRACTED_31_OPT.get());
            Optional<Pessoa> EXTRACTED_33_OPT = Optional.of(ppl[i]);
            boolean EXTRACTED_32 = max_OPT.get() < EXTRACTED_33_OPT.get().t;
            if (EXTRACTED_32 && EXTRACTED_29_OPT.get()) {
                Optional<Pessoa> EXTRACTED_34_OPT = Optional.of(ppl[i]);
                max_OPT = Optional.of(EXTRACTED_34_OPT.get().t);
                indice_OPT = Optional.of(i);
            }
        }
        return indice_OPT.get();
    }

    void dfs_t_visit(int x) {
        Optional<Pessoa> EXTRACTED_36_OPT = Optional.of(tppl[x]);
        Optional<Boolean> EXTRACTED_35_OPT = Optional.of(EXTRACTED_36_OPT.get().visitado == false);
        if (EXTRACTED_35_OPT.get()) {
            Optional<Pessoa> EXTRACTED_39_OPT = Optional.of(tppl[x]);
            boolean EXTRACTED_40 = true;
            EXTRACTED_39_OPT.get().visitado = EXTRACTED_40;
            visitados++;
            Optional<Integer> EXTRACTED_37_OPT = Optional.of(0);
            for (int j = EXTRACTED_37_OPT.get(); j < tppl[x].pos(); j++) {
                Optional<Integer> EXTRACTED_38_OPT = Optional.of(tppl[x].amigos[j]);
                dfs_t_visit(EXTRACTED_38_OPT.get());
            }
            nelementos++;
        }
    }

    void dfs_t() {
        while (visitados < nos) {
            Optional<Integer> id_OPT = Optional.of(findMax());
            Pessoa EXTRACTED_43 = tppl[id_OPT.get()];
            Optional<Boolean> EXTRACTED_44_OPT = Optional.of(false);
            Optional<Boolean> EXTRACTED_42_OPT = Optional.of(EXTRACTED_43.visitado == EXTRACTED_44_OPT.get());
            int EXTRACTED_46 = 1;
            Optional<Integer> EXTRACTED_45_OPT = Optional.of(-EXTRACTED_46);
            Optional<Boolean> EXTRACTED_41_OPT = Optional.of(EXTRACTED_42_OPT.get() && (id_OPT.get() != EXTRACTED_45_OPT.get()));
            if (EXTRACTED_41_OPT.get()) {
                int EXTRACTED_47 = 0;
                nelementos = EXTRACTED_47;
                dfs_t_visit(id_OPT.get());
                Optional<Boolean> EXTRACTED_48_OPT = Optional.of(nelementos >= GrafoConstants.CONSTANT_5);
                if (!EXTRACTED_48_OPT.get()) {
                    res = res + nelementos;
                } else
                    ngrupos++;

            }
        } 
    }

    void print() {
        Optional<String> EXTRACTED_49_OPT = Optional.of((ngrupos + GrafoConstants.CONSTANT_6) + res);
        System.out.println(EXTRACTED_49_OPT.get());
    }

    /**
     */
    public Grafo() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public Sociologia() {
    }

    public double Sociologia_callMe_not(long long0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Scanner> kb_OPT = Optional.of(new Scanner(System.in));
        int ncasos = kb_OPT.get().nextInt();
        for (int i = 1; i <= ncasos; i++) {
            Optional<Integer> n_OPT = Optional.of(kb_OPT.get().nextInt());
            Optional<Grafo> g_OPT = Optional.of(new Grafo(n_OPT.get()));
            g_OPT.get().criar(kb_OPT.get());
            g_OPT.get().dfs();
            g_OPT.get().transpor();
            g_OPT.get().dfs_t();
            Optional<String> EXTRACTED_50_OPT = Optional.of(SociologiaConstants.CONSTANT_7 + i);
            System.out.println(EXTRACTED_50_OPT.get());
            g_OPT.get().print();
        }
    }

    /**
     */
    public Sociologia() {
        throw new RuntimeException("You'd better not have called me!");
    }
}