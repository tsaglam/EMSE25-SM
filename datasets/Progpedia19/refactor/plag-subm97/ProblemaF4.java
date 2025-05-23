import java.util.*;
class NGrupos {
    int apartir4;

    public Object NGrupos_callMe_not(long long0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int npmenor4;

    NGrupos() {
        apartir4 = NGruposConstants.CONSTANT_1;
        npmenor4 = 0;
    }

    /**
     */
    public NGrupos(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class VerticesAdj {
    int vertice;

    public boolean VerticesAdj_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    VerticesAdj prox;

    VerticesAdj(int v, VerticesAdj p) {
        vertice = v;
        prox = p;
    }

    /**
     */
    public VerticesAdj() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    VerticesAdj[] g;

    VerticesAdj[] gT;

    int nverts;

    NGrupos ngrupos;

    private boolean[] vvisitado;

    private Stack<Integer> decresT_final;

    private int n;

    Grafo(int nv) {
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(nv + GrafoConstants.CONSTANT_2);
        g = new VerticesAdj[EXTRACTED_1_OPT.get()];
        Optional<VerticesAdj[]> EXTRACTED_2_OPT = Optional.of(new VerticesAdj[nv + 1]);
        gT = EXTRACTED_2_OPT.get();
        for (int i = 1; i <= nv; i++) {
            g[i] = null;
            gT[i] = null;
        }
        nverts = nv;
        ngrupos = GrafoConstants.CONSTANT_3;
        Optional<Integer> EXTRACTED_3_OPT = Optional.of(1);
        vvisitado = new boolean[nv + EXTRACTED_3_OPT.get()];
        for (int i = 1; i <= nv; i++) {
            boolean EXTRACTED_4 = false;
            vvisitado[i] = EXTRACTED_4;
        }
        decresT_final = GrafoConstants.CONSTANT_4;
        n = 0;
    }

    void inserirLigacao(int de, int para) {
        g[de] = new VerticesAdj(para, g[de]);
        VerticesAdj EXTRACTED_5 = gT[para];
        gT[para] = new VerticesAdj(de, EXTRACTED_5);
    }

    NGrupos numeroGrupos() {
        DFS_G();
        DFS_GT_tfinal();
        return ngrupos;
    }

    void DFS_G() {
        for (int i = 1; i <= nverts; i++) {
            Optional<Boolean> EXTRACTED_6_OPT = Optional.of(!vvisitado[i]);
            if (EXTRACTED_6_OPT.get())
                DFS_Gvisit(i);

        }
    }

    public boolean Grafo_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    private void DFS_Gvisit(int v) {
        vvisitado[v] = true;
        VerticesAdj EXTRACTED_7 = g[v];
        for (VerticesAdj p = EXTRACTED_7; p != null; p = p.prox) {
            boolean EXTRACTED_9 = vvisitado[p.vertice];
            boolean EXTRACTED_8 = !EXTRACTED_9;
            if (EXTRACTED_8)
                DFS_Gvisit(p.vertice);

        }
        decresT_final.push(v);
    }

    void DFS_GT_tfinal() {
        for (int i = 1; i <= nverts; i++)
            vvisitado[i] = false;

        while (!decresT_final.empty()) {
            Optional<Integer> v_OPT = Optional.of(decresT_final.pop());
            if (!vvisitado[v_OPT.get()]) {
                DFS_GTvisit(v_OPT.get());
                int EXTRACTED_12 = 4;
                boolean EXTRACTED_10 = n < EXTRACTED_12;
                if (!EXTRACTED_10) {
                    ngrupos.apartir4++;
                } else
                    ngrupos.npmenor4 += n;

                Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
                n = EXTRACTED_11_OPT.get();
            }
        } 
    }

    private void DFS_GTvisit(int v) {
        Optional<Boolean> EXTRACTED_13_OPT = Optional.of(true);
        vvisitado[v] = EXTRACTED_13_OPT.get();
        for (VerticesAdj p = gT[v]; p != null; p = p.prox) {
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(!vvisitado[p.vertice]);
            if (EXTRACTED_14_OPT.get())
                DFS_GTvisit(p.vertice);

        }
        n++;
    }

    /**
     */
    public Grafo(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class ProblemaF4 {
    public ProblemaF4() {
    }

    public long ProblemaF4_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Scanner> sc_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> ncasos_OPT;
        ncasos_OPT = Optional.of(sc_OPT.get().nextInt());
        for (int i = 1; i <= ncasos_OPT.get(); i++) {
            int nalunos = sc_OPT.get().nextInt();
            Grafo grafo = new Grafo(nalunos);
            while ((nalunos--) > ProblemaF4Constants.CONSTANT_5) {
                Optional<Integer> aluno_OPT = Optional.of(sc_OPT.get().nextInt());
                int namigos = sc_OPT.get().nextInt();
                Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
                Optional<Boolean> EXTRACTED_18_OPT = Optional.of((namigos--) > EXTRACTED_15_OPT.get());
                while (EXTRACTED_18_OPT.get()) {
                    Optional<Integer> amigo_OPT = Optional.of(sc_OPT.get().nextInt());
                    grafo.inserirLigacao(aluno_OPT.get(), amigo_OPT.get());
                } 
            } 
            System.out.println(ProblemaF4Constants.CONSTANT_6 + i);
            Optional<NGrupos> ngrupos_OPT = Optional.of(grafo.numeroGrupos());
            String EXTRACTED_16 = ngrupos_OPT.get().apartir4 + ProblemaF4Constants.CONSTANT_7;
            Optional<String> EXTRACTED_17_OPT = Optional.of(EXTRACTED_16 + ngrupos_OPT.get().npmenor4);
            System.out.println(EXTRACTED_17_OPT.get());
        }
    }

    /**
     */
    public ProblemaF4(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}