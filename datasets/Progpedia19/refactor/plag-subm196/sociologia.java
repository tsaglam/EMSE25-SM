import java.util.*;
class Grafo {
    int nverts;

    int narcos;

    Vertice[] verts;

    Grafo(int n) {
        nverts = GrafoConstants.CONSTANT_1;
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        narcos = EXTRACTED_1_OPT.get();
        Optional<Vertice[]> EXTRACTED_2_OPT = Optional.of(new Vertice[n]);
        verts = EXTRACTED_2_OPT.get();
    }

    void novoVert(int n) {
        verts[n] = new Vertice(n);
        nverts++;
    }

    public double Grafo_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    void novoAdj(int v, int a, int c) {
        Optional<Boolean> EXTRACTED_3_OPT = Optional.of(procuraArco(v, a) == 0);
        if (EXTRACTED_3_OPT.get()) {
            Optional<Vertice> EXTRACTED_4_OPT = Optional.of(verts[v]);
            EXTRACTED_4_OPT.get().adicionarAdj(a, c);
            narcos++;
        }
    }

    int procuraArco(int v, int d) {
        Optional<Arco> aux_OPT;
        aux_OPT = Optional.of(verts[v].adjs);
        Optional<Boolean> EXTRACTED_5_OPT = Optional.of(aux_OPT.get() != null);
        while (EXTRACTED_5_OPT.get()) {
            if (aux_OPT.get().proxVert != d) {
                aux_OPT = Optional.of(aux_OPT.get().prox);
            } else
                return GrafoConstants.CONSTANT_2;

        } 
        return 0;
    }

    /**
     */
    public Grafo() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Arco {
    int proxVert;

    int c;

    Arco prox;

    public boolean Arco_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Arco(int v, int ca) {
        proxVert = v;
        c = ca;
        prox = null;
    }

    Arco(int v, int ca, Arco a) {
        proxVert = v;
        c = ca;
        prox = a;
    }

    /**
     */
    public Arco(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Vertice {
    int label;

    public float Vertice_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Arco adjs;

    Vertice(int v) {
        label = v;
        adjs = null;
    }

    void adicionarAdj(int n, int c) {
        Optional<Arco> EXTRACTED_6_OPT = Optional.of(new Arco(n, c, adjs));
        adjs = EXTRACTED_6_OPT.get();
    }

    /**
     */
    public Vertice(float float0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Fila {
    public int Fila_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Node first;

    int length;

    Fila() {
        first = null;
        length = FilaConstants.CONSTANT_3;
    }

    void imprimeFila() {
        Optional<Node> aux_OPT;
        aux_OPT = Optional.of(first);
        Optional<Boolean> EXTRACTED_7_OPT = Optional.of(aux_OPT.get() != null);
        while (EXTRACTED_7_OPT.get()) {
            System.out.println(aux_OPT.get().val);
            aux_OPT = Optional.of(aux_OPT.get().prox);
        } 
    }

    boolean isEmpty() {
        if (length == 0)
            return FilaConstants.CONSTANT_4;

        return FilaConstants.CONSTANT_5;
    }

    void pushNode(int v) {
        Optional<Node> aux_OPT;
        int EXTRACTED_8 = 0;
        if (length != EXTRACTED_8) {
            Node EXTRACTED_10 = new Node(v, first);
            aux_OPT = Optional.of(EXTRACTED_10);
            first = aux_OPT.get();
            length++;
        } else {
            Optional<Node> EXTRACTED_9_OPT = Optional.of(new Node(v, null));
            first = EXTRACTED_9_OPT.get();
            length++;
        }
    }

    int popNode() {
        Optional<Integer> aux_OPT;
        aux_OPT = Optional.of(first.val);
        first = first.prox;
        length--;
        return aux_OPT.get();
    }

    class Node {
        public Object Node_callMe_not(String string0) {
            throw new RuntimeException("You'd better not have called me!");
        }

        int val;

        Node prox;

        Node(int v, Node p) {
            val = v;
            prox = p;
        }

        /**
         */
        public Node() {
            throw new RuntimeException("You'd better not have called me!");
        }
    }

    /**
     */
    public Fila(long long0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Set {
    int[] s;

    int size;

    int length;

    Set(int x) {
        int i;
        size = x + SetConstants.CONSTANT_6;
        int EXTRACTED_11 = 0;
        length = EXTRACTED_11;
        s = new int[x + 1];
        Optional<Integer> EXTRACTED_12_OPT = Optional.of(x + 1);
        for (i = 0; i < EXTRACTED_12_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_13_OPT = Optional.of(0);
            s[i] = EXTRACTED_13_OPT.get();
        }
    }

    void insert(int n) {
        s[n] = 1;
        length++;
    }

    void remove(int n) {
        s[n] = 0;
        length--;
    }

    int size() {
        return length;
    }

    void imprime() {
        int i;
        for (i = 1; i < size; i++) {
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(s[i]);
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(1);
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(EXTRACTED_15_OPT.get() == EXTRACTED_16_OPT.get());
            if (EXTRACTED_14_OPT.get())
                System.out.println(i);

        }
    }

    boolean isEqual(Set x) {
        int i;
        if (length != x.length)
            return false;

        for (i = 0; i < size; i++) {
            Optional<Integer> EXTRACTED_18_OPT = Optional.of(s[i]);
            Optional<Integer> EXTRACTED_19_OPT = Optional.of(x.s[i]);
            Optional<Boolean> EXTRACTED_17_OPT = Optional.of(EXTRACTED_18_OPT.get() != EXTRACTED_19_OPT.get());
            if (EXTRACTED_17_OPT.get()) {
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(false);
                return EXTRACTED_20_OPT.get();
            }
        }
        return SetConstants.CONSTANT_7;
    }

    public String Set_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Set intersect(Set x) {
        Optional<Set> aux_OPT = Optional.of(new Set(size));
        int i;
        for (i = 0; i < size; i++) {
            Optional<Integer> EXTRACTED_25_OPT = Optional.of(s[i]);
            boolean EXTRACTED_21 = EXTRACTED_25_OPT.get() == 1;
            int EXTRACTED_23 = 1;
            boolean EXTRACTED_22 = x.s[i] == EXTRACTED_23;
            Optional<Boolean> EXTRACTED_24_OPT = Optional.of(EXTRACTED_21 && EXTRACTED_22);
            if (EXTRACTED_24_OPT.get())
                aux_OPT.get().insert(i);

        }
        return aux_OPT.get();
    }

    /**
     */
    public Set(Object object0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Lista {
    public String Lista_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Lista.Node first;

    int length;

    Lista() {
        first = null;
        length = ListaConstants.CONSTANT_8;
    }

    void addNode(Set n) {
        Optional<Lista.Node> aux_OPT;
        int flag = 0;
        boolean EXTRACTED_26 = length == 0;
        if (!EXTRACTED_26) {
            aux_OPT = Optional.of(first);
            Optional<Integer> EXTRACTED_32_OPT = Optional.of(0);
            flag = EXTRACTED_32_OPT.get();
            Optional<Boolean> EXTRACTED_28_OPT = Optional.of(aux_OPT.get() != null);
            while (EXTRACTED_28_OPT.get()) {
                Optional<Boolean> EXTRACTED_29_OPT = Optional.of(aux_OPT.get().s.isEqual(n) == ListaConstants.CONSTANT_9);
                if (EXTRACTED_29_OPT.get()) {
                    flag = ListaConstants.CONSTANT_10;
                    break;
                }
                aux_OPT = Optional.of(aux_OPT.get().prox);
            } 
            int EXTRACTED_33 = 0;
            Optional<Boolean> EXTRACTED_30_OPT = Optional.of(flag == EXTRACTED_33);
            if (EXTRACTED_30_OPT.get()) {
                Optional<Lista.Node> EXTRACTED_31_OPT = Optional.of(new Lista.Node(n, first));
                aux_OPT = Optional.of(EXTRACTED_31_OPT.get());
                first = aux_OPT.get();
                length++;
            }
        } else {
            Optional<Lista.Node> EXTRACTED_27_OPT = Optional.of(new Lista.Node(n, null));
            first = EXTRACTED_27_OPT.get();
            length++;
        }
    }

    class Node {
        public int Node_callMe_not() {
            throw new RuntimeException("You'd better not have called me!");
        }

        Set s;

        Lista.Node prox;

        Node(Set n, Lista.Node p) {
            s = n;
            prox = p;
        }

        /**
         */
        public Node(Object object0) {
            throw new RuntimeException("You'd better not have called me!");
        }
    }

    /**
     */
    public Lista(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sociologia {
    public sociologia() {
    }

    static Set depthFirstSearch(Grafo g, int v, int n) {
        Optional<Integer> EXTRACTED_35_OPT = Optional.of(1);
        int EXTRACTED_34 = n + EXTRACTED_35_OPT.get();
        Optional<int[]> lidos_OPT = Optional.of(new int[EXTRACTED_34]);
        int cont;
        int i;
        Optional<Arco> aux_OPT;
        Optional<Fila> stack_OPT = Optional.of(new Fila());
        Optional<Set> s_OPT = Optional.of(new Set(n + 1));
        Optional<Integer> EXTRACTED_36_OPT = Optional.of(n + 1);
        for (i = sociologiaConstants.CONSTANT_11; i < EXTRACTED_36_OPT.get(); i++) {
            Optional<Integer> EXTRACTED_37_OPT = Optional.of(0);
            lidos_OPT.get()[i] = EXTRACTED_37_OPT.get();
        }
        stack_OPT.get().pushNode(v);
        s_OPT.get().insert(v);
        while (stack_OPT.get().isEmpty() == sociologiaConstants.CONSTANT_12) {
            i = stack_OPT.get().popNode();
            int EXTRACTED_38 = 1;
            lidos_OPT.get()[i] = EXTRACTED_38;
            if (g.verts[i] != null) {
                aux_OPT = Optional.of(g.verts[i].adjs);
                while (aux_OPT.get() != null) {
                    Optional<Integer> EXTRACTED_39_OPT = Optional.of(0);
                    int EXTRACTED_40 = lidos_OPT.get()[aux_OPT.get().proxVert];
                    boolean EXTRACTED_42 = EXTRACTED_40 == EXTRACTED_39_OPT.get();
                    if (EXTRACTED_42) {
                        stack_OPT.get().pushNode(aux_OPT.get().proxVert);
                        Optional<Integer> EXTRACTED_41_OPT = Optional.of(1);
                        lidos_OPT.get()[aux_OPT.get().proxVert] = EXTRACTED_41_OPT.get();
                        s_OPT.get().insert(aux_OPT.get().proxVert);
                    }
                    aux_OPT = Optional.of(aux_OPT.get().prox);
                } 
            }
        } 
        return s_OPT.get();
    }

    public float sociologia_callMe_not(long long0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Integer> ncasos_OPT;
        int npessoas;
        int i;
        int j;
        Optional<Integer> n_OPT;
        int aux;
        int c;
        Optional<int[]> grupo_OPT;
        Grafo g;
        Optional<Grafo> trans_OPT;
        Set s1;
        Optional<Set> s2_OPT;
        Set s;
        Optional<Scanner> kb_OPT = Optional.of(new Scanner(System.in));
        Optional<Fila> listaSets_OPT;
        Optional<Lista> sets_OPT;
        ncasos_OPT = Optional.of(kb_OPT.get().nextInt());
        Optional<Integer> EXTRACTED_43_OPT = Optional.of(0);
        for (c = EXTRACTED_43_OPT.get(); c < ncasos_OPT.get(); c++) {
            Optional<Lista> EXTRACTED_64_OPT = Optional.of(new Lista());
            sets_OPT = Optional.of(EXTRACTED_64_OPT.get());
            listaSets_OPT = Optional.of(new Fila());
            npessoas = kb_OPT.get().nextInt();
            aux = npessoas;
            Optional<Integer> EXTRACTED_45_OPT = Optional.of(1);
            Grafo EXTRACTED_44 = new Grafo(npessoas + EXTRACTED_45_OPT.get());
            g = EXTRACTED_44;
            Optional<Integer> EXTRACTED_46_OPT = Optional.of(1);
            int EXTRACTED_65 = npessoas + EXTRACTED_46_OPT.get();
            trans_OPT = Optional.of(new Grafo(EXTRACTED_65));
            int EXTRACTED_47 = 0;
            while (aux > EXTRACTED_47) {
                i = kb_OPT.get().nextInt();
                g.novoVert(i);
                j = kb_OPT.get().nextInt();
                Optional<Integer> EXTRACTED_48_OPT = Optional.of(0);
                while (j > EXTRACTED_48_OPT.get()) {
                    n_OPT = Optional.of(kb_OPT.get().nextInt());
                    Optional<Integer> EXTRACTED_49_OPT = Optional.of(0);
                    g.novoAdj(i, n_OPT.get(), EXTRACTED_49_OPT.get());
                    Optional<Vertice> EXTRACTED_69_OPT = Optional.of(trans_OPT.get().verts[n_OPT.get()]);
                    Optional<Boolean> EXTRACTED_50_OPT = Optional.of(EXTRACTED_69_OPT.get() == null);
                    if (EXTRACTED_50_OPT.get())
                        trans_OPT.get().novoVert(n_OPT.get());

                    int EXTRACTED_51 = 0;
                    trans_OPT.get().novoAdj(n_OPT.get(), i, EXTRACTED_51);
                    j--;
                } 
                aux--;
            } 
            int EXTRACTED_53 = 1;
            Optional<Integer> EXTRACTED_52_OPT = Optional.of(npessoas + EXTRACTED_53);
            grupo_OPT = Optional.of(new int[EXTRACTED_52_OPT.get()]);
            Optional<Integer> EXTRACTED_54_OPT = Optional.of(0);
            for (i = EXTRACTED_54_OPT.get(); i <= npessoas; i++) {
                int EXTRACTED_70 = 0;
                grupo_OPT.get()[i] = EXTRACTED_70;
            }
            Optional<Integer> EXTRACTED_55_OPT = Optional.of(1);
            for (i = EXTRACTED_55_OPT.get(); i <= npessoas; i++) {
                s1 = depthFirstSearch(g, i, npessoas);
                s2_OPT = Optional.of(depthFirstSearch(trans_OPT.get(), i, npessoas));
                s = s1.intersect(s2_OPT.get());
                boolean EXTRACTED_56 = s.length >= sociologiaConstants.CONSTANT_13;
                if (EXTRACTED_56) {
                    sets_OPT.get().addNode(s);
                    Optional<Integer> EXTRACTED_57_OPT = Optional.of(1);
                    for (j = EXTRACTED_57_OPT.get(); j < s.size; j++) {
                        Optional<Integer> EXTRACTED_71_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_72_OPT = Optional.of(s.s[j]);
                        Optional<Boolean> EXTRACTED_58_OPT = Optional.of(EXTRACTED_72_OPT.get() == EXTRACTED_71_OPT.get());
                        if (EXTRACTED_58_OPT.get()) {
                            int EXTRACTED_59 = 1;
                            grupo_OPT.get()[j] = EXTRACTED_59;
                        }
                    }
                }
            }
            j = 0;
            Optional<Integer> EXTRACTED_60_OPT = Optional.of(1);
            for (i = EXTRACTED_60_OPT.get(); i <= npessoas; i++) {
                Optional<Integer> EXTRACTED_66_OPT = Optional.of(0);
                Optional<Boolean> EXTRACTED_61_OPT = Optional.of(grupo_OPT.get()[i] == EXTRACTED_66_OPT.get());
                if (EXTRACTED_61_OPT.get())
                    j++;

            }
            int EXTRACTED_67 = c + 1;
            String EXTRACTED_62 = sociologiaConstants.CONSTANT_14 + EXTRACTED_67;
            System.out.println(EXTRACTED_62);
            Optional<String> EXTRACTED_68_OPT = Optional.of(sets_OPT.get().length + sociologiaConstants.CONSTANT_15);
            String EXTRACTED_63 = EXTRACTED_68_OPT.get() + j;
            System.out.println(EXTRACTED_63);
        }
    }

    /**
     */
    public sociologia(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}