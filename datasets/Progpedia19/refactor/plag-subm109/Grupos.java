import java.io.*;
import java.util.*;
class TestGrupos {
    public long TestGrupos_callMe_not(int int0) {
        throw TestGruposConstants.CONSTANT_1;
    }

    public float TestGrupos_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public TestGrupos() {
    }

    static void verAlunos(int cenario, int n_alunos, Vertice[] alunos) {
        int aluno;
        int n_amigos;
        int amigo;
        Optional<String> EXTRACTED_1_OPT = Optional.of(TestGruposConstants.CONSTANT_1 + cenario);
        Grupos.pw.print(EXTRACTED_1_OPT.get());
        for (aluno = TestGruposConstants.CONSTANT_2; aluno < n_alunos; aluno++) {
            Optional<Vertice> EXTRACTED_2_OPT = Optional.of(alunos[aluno]);
            Optional<Optional<Vertice>> EXTRACTED_8_OPT_OPT = Optional.of(Optional.of(EXTRACTED_2_OPT.get()));
            n_amigos = EXTRACTED_8_OPT_OPT.get().get().getNAmigos();
            Optional<Optional<Integer>> EXTRACTED_1_OPT_OPT = Optional.of(Optional.of(TestGruposConstants.CONSTANT_2));
            boolean EXTRACTED_9 = n_amigos > EXTRACTED_1_OPT_OPT.get().get();
            boolean EXTRACTED_3 = !EXTRACTED_9;
            if (!EXTRACTED_3) {
                Optional<Integer> EXTRACTED_13_OPT = Optional.of(aluno + TestGruposConstants.CONSTANT_4);
                Optional<String> EXTRACTED_3_OPT = Optional.of(TestGruposConstants.CONSTANT_3 + EXTRACTED_13_OPT.get());
                Optional<String> EXTRACTED_4_OPT = Optional.of(EXTRACTED_3_OPT.get() + TestGruposConstants.CONSTANT_5);
                Optional<String> EXTRACTED_2_OPT = Optional.of(EXTRACTED_4_OPT.get());
                Optional<String> EXTRACTED_11_OPT = Optional.of(EXTRACTED_2_OPT.get() + n_amigos);
                Optional<String> EXTRACTED_5_OPT = Optional.of(EXTRACTED_11_OPT.get() + TestGruposConstants.CONSTANT_6);
                Grupos.pw.print(EXTRACTED_5_OPT.get());
                Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
                Optional<Integer> EXTRACTED_4_OPT = Optional.of(EXTRACTED_6_OPT.get());
                for (amigo = EXTRACTED_4_OPT.get(); amigo < n_amigos; amigo++) {
                    Optional<Optional<Vertice>> EXTRACTED_10_OPT_OPT = Optional.of(Optional.of(alunos[aluno]));
                    int EXTRACTED_8 = 1;
                    Optional<Integer> EXTRACTED_7_OPT = Optional.of(EXTRACTED_10_OPT_OPT.get().get().Amigo(amigo) + EXTRACTED_8);
                    Optional<Optional<Integer>> EXTRACTED_6_OPT_OPT = Optional.of(Optional.of(EXTRACTED_7_OPT.get()));
                    Optional<String> EXTRACTED_13_OPT = Optional.of(TestGruposConstants.CONSTANT_7 + EXTRACTED_6_OPT_OPT.get().get());
                    Optional<Optional<String>> EXTRACTED_5_OPT_OPT = Optional.of(Optional.of(EXTRACTED_13_OPT.get()));
                    Grupos.pw.print(EXTRACTED_5_OPT_OPT.get().get());
                }
            } else {
                Optional<Optional<Integer>> EXTRACTED_15_OPT_OPT = Optional.of(Optional.of(TestGruposConstants.CONSTANT_3));
                Optional<Integer> EXTRACTED_12_OPT = Optional.of(aluno + EXTRACTED_15_OPT_OPT.get().get());
                Optional<Optional<Integer>> EXTRACTED_7_OPT_OPT = Optional.of(Optional.of(EXTRACTED_12_OPT.get()));
                Optional<Optional<String>> EXTRACTED_12_OPT_OPT = Optional.of(Optional.of(TestGruposConstants.CONSTANT_4));
                String EXTRACTED_9 = EXTRACTED_12_OPT_OPT.get().get() + EXTRACTED_7_OPT_OPT.get().get();
                Optional<Optional<String>> EXTRACTED_11_OPT_OPT = Optional.of(Optional.of(EXTRACTED_9));
                Optional<String> EXTRACTED_10_OPT = Optional.of(EXTRACTED_11_OPT_OPT.get().get() + TestGruposConstants.CONSTANT_5);
                Optional<Optional<String>> EXTRACTED_14_OPT_OPT = Optional.of(Optional.of(EXTRACTED_10_OPT.get()));
                Grupos.pw.print(EXTRACTED_14_OPT_OPT.get().get());
            }
        }
        Grupos.pw.print(TestGruposConstants.CONSTANT_8);
        if (Grupos.pw.checkError())
            Grupos.pw.println(TestGruposConstants.CONSTANT_9);

    }

    static void listaLCFC(int cenario, Lista_CFC lista) {
        Optional<CFC> i_OPT;
        Optional<Optional<String>> EXTRACTED_16_OPT_OPT = Optional.of(Optional.of(TestGruposConstants.CONSTANT_10 + cenario));
        Grupos.pw.print(EXTRACTED_16_OPT_OPT.get().get());
        for (i_OPT = Optional.of(lista.getPrimeiro()); i_OPT.get() != null; i_OPT = Optional.of(i_OPT.get().getNext()))
            showStack(i_OPT.get().getComponente());

    }

    static void showStack(Stack pilha) {
        Optional<Optional<int[]>> stack_OPT_OPT;
        Optional<Optional<Integer>> n_elems_OPT_OPT = Optional.of(Optional.of(pilha.elemsStack()));
        int i;
        stack_OPT_OPT = Optional.of(Optional.of(pilha.getElements()));
        Grupos.pw.print(TestGruposConstants.CONSTANT_11);
        Optional<Boolean> EXTRACTED_14_OPT = Optional.of(n_elems_OPT_OPT.get().get() > 0);
        Optional<Optional<Boolean>> EXTRACTED_17_OPT_OPT = Optional.of(Optional.of(EXTRACTED_14_OPT.get()));
        if (!EXTRACTED_17_OPT_OPT.get().get()) {
            Grupos.pw.println(TestGruposConstants.CONSTANT_12);
        } else {
            Optional<Optional<Integer>> EXTRACTED_21_OPT_OPT = Optional.of(Optional.of(0));
            for (i = EXTRACTED_21_OPT_OPT.get().get(); i < n_elems_OPT_OPT.get().get(); i++) {
                Optional<Integer> EXTRACTED_15_OPT = Optional.of(stack_OPT_OPT.get().get()[i]);
                Optional<Optional<Integer>> EXTRACTED_19_OPT_OPT = Optional.of(Optional.of(EXTRACTED_15_OPT.get()));
                int EXTRACTED_16 = 1;
                Optional<Integer> EXTRACTED_20_OPT = Optional.of(EXTRACTED_16);
                String EXTRACTED_22 = "\n\t\t";
                Optional<Integer> EXTRACTED_18_OPT = Optional.of(EXTRACTED_19_OPT_OPT.get().get() + EXTRACTED_20_OPT.get());
                Optional<Optional<Integer>> EXTRACTED_23_OPT_OPT = Optional.of(Optional.of(EXTRACTED_18_OPT.get()));
                Optional<String> EXTRACTED_17_OPT = Optional.of(EXTRACTED_22 + EXTRACTED_23_OPT_OPT.get().get());
                Optional<String> EXTRACTED_18_OPT = Optional.of(EXTRACTED_17_OPT.get());
                Grupos.pw.print(EXTRACTED_18_OPT.get());
            }
        }
        Grupos.pw.print(TestGruposConstants.CONSTANT_6);
    }

    /**
     */
    public TestGrupos() {
        Optional<String> EXTRACTED_19_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_19_OPT.get());
    }

    /**
     */
    public TestGrupos() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Vertice {
    private int n_amigos;

    int[] amigos;

    int index;

    int lowlink;

    Vertice(int n, int[] ami) {
        n_amigos = n;
        amigos = ami;
        Optional<Integer> EXTRACTED_24_OPT = Optional.of(-VerticeConstants.CONSTANT_13);
        index = EXTRACTED_24_OPT.get();
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(VerticeConstants.CONSTANT_7);
        lowlink = EXTRACTED_25_OPT.get();
    }

    int getNAmigos() {
        return n_amigos;
    }

    int Amigo(int x) {
        int EXTRACTED_26 = amigos[x];
        return EXTRACTED_26;
    }

    void setIndex(int ind) {
        index = ind;
    }

    int getIndex() {
        return index;
    }

    void setLowlink(int ll) {
        lowlink = ll;
    }

    public String Vertice_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int getLowlink() {
        return lowlink;
    }

    boolean isAmigo(int a) {
        int i;
        for (i = VerticeConstants.CONSTANT_14; i < n_amigos; i++) {
            Optional<Optional<Integer>> EXTRACTED_28_OPT_OPT = Optional.of(Optional.of(amigos[i]));
            Optional<Optional<Boolean>> EXTRACTED_27_OPT_OPT = Optional.of(Optional.of(EXTRACTED_28_OPT_OPT.get().get() == a));
            if (EXTRACTED_27_OPT_OPT.get().get())
                return VerticeConstants.CONSTANT_15;

        }
        return VerticeConstants.CONSTANT_16;
    }

    public long Vertice_callMe_not(boolean boolean0) {
        throw new RuntimeException(VerticeConstants.CONSTANT_8);
    }

    /**
     */
    public Vertice(boolean boolean0) {
        RuntimeException EXTRACTED_20 = new RuntimeException("You'd better not have called me!");
        throw EXTRACTED_20;
    }

    /**
     */
    public Vertice(float float0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Resultados {
    public int Resultados_callMe_not(int int0, long long1) {
        throw ResultadosConstants.CONSTANT_10;
    }

    Resultado primeiro;

    Resultado ultimo;

    Resultados() {
        primeiro = null;
        ultimo = null;
    }

    Resultado getPrimeiro() {
        return primeiro;
    }

    void adicionarResultado(Resultado res) {
        Optional<Boolean> EXTRACTED_21_OPT = Optional.of(primeiro == null);
        Optional<Optional<Boolean>> EXTRACTED_29_OPT_OPT = Optional.of(Optional.of(EXTRACTED_21_OPT.get()));
        if (!EXTRACTED_29_OPT_OPT.get().get()) {
            ultimo.setProximo(res);
            ultimo = res;
        } else {
            primeiro = res;
            ultimo = res;
        }
    }

    public int Resultados_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Resultados(Object object0, double double1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Resultados() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Resultado {
    int caso;

    int gruposDe4;

    int outrosElementos;

    Resultado next;

    public boolean Resultado_callMe_not(Object object0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Resultado(int cas, int grupos, int outros) {
        caso = cas;
        gruposDe4 = grupos;
        outrosElementos = outros;
        next = null;
    }

    public int Resultado_callMe_not(double double0, float float1) {
        throw ResultadoConstants.CONSTANT_11;
    }

    Resultado(int cas) {
        caso = cas;
        gruposDe4 = ResultadoConstants.CONSTANT_17;
        outrosElementos = ResultadoConstants.CONSTANT_12;
        next = null;
    }

    int getCaso() {
        return caso;
    }

    void addGrupoDe4() {
        gruposDe4++;
    }

    int getGruposDe4() {
        return gruposDe4;
    }

    void addOutrosElementos() {
        outrosElementos++;
    }

    int getOutrosElementos() {
        return outrosElementos;
    }

    void setProximo(Resultado res) {
        next = res;
    }

    Resultado proximo() {
        return next;
    }

    /**
     */
    public Resultado(float float0) {
        Optional<String> EXTRACTED_23_OPT = Optional.of("You'd better not have called me!");
        Optional<RuntimeException> EXTRACTED_22_OPT = Optional.of(new RuntimeException(EXTRACTED_23_OPT.get()));
        throw EXTRACTED_22_OPT.get();
    }

    /**
     */
    public Resultado(double double0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Lista_CFC {
    CFC primeiro;

    CFC ultimo;

    public String Lista_CFC_callMe_not(boolean boolean0, boolean boolean1) {
        throw Lista_CFCConstants.CONSTANT_14;
    }

    Lista_CFC() {
        primeiro = null;
        ultimo = null;
    }

    public Object Lista_CFC_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    CFC getPrimeiro() {
        return primeiro;
    }

    void add2Lista(Stack pilha) {
        Optional<Optional<CFC>> compfc_OPT_OPT = Optional.of(Optional.of(new CFC(pilha)));
        Optional<Boolean> EXTRACTED_24_OPT = Optional.of(primeiro != null);
        if (!EXTRACTED_24_OPT.get()) {
            primeiro = compfc_OPT_OPT.get().get();
        } else {
            ultimo.setNext(compfc_OPT_OPT.get().get());
        }
        ultimo = compfc_OPT_OPT.get().get();
    }

    /**
     */
    public Lista_CFC(boolean boolean0) {
        Optional<RuntimeException> EXTRACTED_25_OPT = Optional.of(new RuntimeException("You'd better not have called me!"));
        throw EXTRACTED_25_OPT.get();
    }

    /**
     */
    public Lista_CFC(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class CFC {
    Stack componente;

    CFC next;

    public String CFC_callMe_not(String string0, long long1) {
        throw CFCConstants.CONSTANT_15;
    }

    CFC(Stack comp) {
        componente = comp;
        next = null;
    }

    Stack getComponente() {
        return componente;
    }

    void setNext(CFC no) {
        next = no;
    }

    CFC getNext() {
        return next;
    }

    /**
     */
    public CFC(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public boolean CFC_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public CFC(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Stack {
    int elems;

    Node first;

    Stack() {
        elems = StackConstants.CONSTANT_18;
        first = null;
    }

    int elemsStack() {
        return elems;
    }

    public float Stack_callMe_not(int int0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public double Stack_callMe_not(long long0) {
        throw StackConstants.CONSTANT_16;
    }

    void push(int x) {
        Optional<Optional<Node>> no_OPT_OPT = Optional.of(Optional.of(new Node(x)));
        no_OPT_OPT.get().get().setNext(first);
        first = no_OPT_OPT.get().get();
        elems++;
    }

    int pop() {
        int x = first.getValor();
        first = first.getNext();
        elems--;
        return x;
    }

    boolean isEmpty() {
        return first == null;
    }

    boolean elemInStack(int x) {
        Optional<Node> i_OPT;
        for (i_OPT = Optional.of(first); i_OPT.get() != null; i_OPT = Optional.of(i_OPT.get().getNext())) {
            Optional<Boolean> EXTRACTED_26_OPT = Optional.of(i_OPT.get().getValor() == x);
            Optional<Optional<Boolean>> EXTRACTED_30_OPT_OPT = Optional.of(Optional.of(EXTRACTED_26_OPT.get()));
            if (EXTRACTED_30_OPT_OPT.get().get())
                return StackConstants.CONSTANT_17;

        }
        return StackConstants.CONSTANT_19;
    }

    int[] getElements() {
        int[] EXTRACTED_27 = new int[elems];
        Optional<Optional<int[]>> elements_OPT_OPT = Optional.of(Optional.of(EXTRACTED_27));
        int j;
        Optional<Node> i_OPT;
        Optional<Optional<Integer>> EXTRACTED_31_OPT_OPT = Optional.of(Optional.of(elems - StackConstants.CONSTANT_20));
        for (i_OPT = Optional.of(first), j = EXTRACTED_31_OPT_OPT.get().get(); i_OPT.get() != null; i_OPT = Optional.of(i_OPT.get().getNext()) , j--) {
            elements_OPT_OPT.get().get()[j] = i_OPT.get().getValor();
        }
        return elements_OPT_OPT.get().get();
    }

    Stack getTill(int v) {
        Optional<Optional<Node>> nova_OPT_OPT;
        Optional<Optional<Integer>> i_OPT_OPT;
        Stack s = new Stack();
        do {
            Stack EXTRACTED_32 = this;
            i_OPT_OPT = Optional.of(Optional.of(EXTRACTED_32.pop()));
            s.push(i_OPT_OPT.get().get());
        } while (i_OPT_OPT.get().get() != v );
        return s;
    }

    int verPosicao(int ind) {
        Optional<Optional<Node>> j_OPT_OPT;
        int i;
        Optional<Boolean> EXTRACTED_33_OPT = Optional.of(j_OPT_OPT.get().get() != null);
        Optional<Boolean> EXTRACTED_28_OPT = Optional.of(i < ind);
        for (i = StackConstants.CONSTANT_18, j_OPT_OPT = Optional.of(Optional.of(first)); EXTRACTED_28_OPT.get() && EXTRACTED_33_OPT.get(); i++ , j_OPT_OPT = Optional.of(Optional.of(j_OPT_OPT.get().get().getNext())));
        Optional<Boolean> EXTRACTED_29_OPT = Optional.of(j_OPT_OPT.get().get() != null);
        if (!EXTRACTED_29_OPT.get()) {
            return StackConstants.CONSTANT_21;
        } else
            return j_OPT_OPT.get().get().getValor();

    }

    /**
     */
    public Stack(Object object0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Stack() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Node {
    public boolean Node_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    int valor;

    Node next;

    Node(int x) {
        valor = x;
        next = null;
    }

    int getValor() {
        return valor;
    }

    public Object Node_callMe_not(float float0, float float1) {
        throw NodeConstants.CONSTANT_20;
    }

    void setNext(Node no) {
        next = no;
    }

    Node getNext() {
        return next;
    }

    /**
     */
    public Node(Object object0, String string1) {
        Optional<String> EXTRACTED_30_OPT = Optional.of("You'd better not have called me!");
        throw new RuntimeException(EXTRACTED_30_OPT.get());
    }

    /**
     */
    public Node() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Grupos {
    public Grupos() {
    }

    public static PrintWriter pw = new PrintWriter(System.out, GruposConstants.CONSTANT_23);

    public long Grupos_callMe_not() {
        throw GruposConstants.CONSTANT_22;
    }

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Optional<Integer> n_cenarios_OPT;
        int cenario;
        Optional<Optional<Integer>> n_alunos_OPT_OPT;
        int aluno;
        Optional<Vertice[]> alunos_OPT;
        Optional<Optional<Integer>> id_OPT_OPT;
        Optional<Optional<Integer>> n_amigos_OPT_OPT;
        Optional<int[]> amigos_OPT;
        int i;
        Optional<Resultados> resus_OPT = Optional.of(new Resultados());
        n_cenarios_OPT = Optional.of(GruposConstants.sca.nextInt());
        for (cenario = GruposConstants.CONSTANT_24; cenario <= n_cenarios_OPT.get(); cenario++) {
            n_alunos_OPT_OPT = Optional.of(Optional.of(GruposConstants.sca.nextInt()));
            Vertice[] EXTRACTED_31 = new Vertice[n_alunos_OPT_OPT.get().get()];
            alunos_OPT = Optional.of(EXTRACTED_31);
            for (aluno = GruposConstants.CONSTANT_25; aluno < n_alunos_OPT_OPT.get().get(); aluno++) {
                id_OPT_OPT = Optional.of(Optional.of(GruposConstants.sca.nextInt()));
                n_amigos_OPT_OPT = Optional.of(Optional.of(GruposConstants.sca.nextInt()));
                Optional<int[]> EXTRACTED_33_OPT = Optional.of(new int[n_amigos_OPT_OPT.get().get()]);
                Optional<int[]> EXTRACTED_37_OPT = Optional.of(EXTRACTED_33_OPT.get());
                amigos_OPT = Optional.of(EXTRACTED_37_OPT.get());
                Optional<Optional<Integer>> EXTRACTED_38_OPT_OPT = Optional.of(Optional.of(GruposConstants.CONSTANT_23));
                for (i = EXTRACTED_38_OPT_OPT.get().get(); i < n_amigos_OPT_OPT.get().get(); i++) {
                    Optional<Integer> EXTRACTED_35_OPT = Optional.of(1);
                    int EXTRACTED_34 = GruposConstants.sca.nextInt() - EXTRACTED_35_OPT.get();
                    amigos_OPT.get()[i] = EXTRACTED_34_OPT.get();
                }
                Optional<Integer> EXTRACTED_34_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_32_OPT = Optional.of(id_OPT_OPT.get().get() - EXTRACTED_34_OPT.get());
                Optional<Optional<Integer>> EXTRACTED_36_OPT_OPT = Optional.of(Optional.of(EXTRACTED_32_OPT.get()));
                Optional<Vertice> EXTRACTED_39_OPT = Optional.of(new Vertice(n_amigos_OPT_OPT.get().get(), amigos_OPT.get()));
                alunos_OPT.get()[EXTRACTED_36_OPT_OPT.get().get()] = EXTRACTED_39_OPT.get();
            }
            TestGrupos.verAlunos(cenario, n_alunos_OPT_OPT.get().get(), alunos_OPT.get());
            resus_OPT.get().adicionarResultado(contagem_de_grupos(cenario, n_alunos_OPT_OPT.get().get(), alunos_OPT.get()));
        }
        output(resus_OPT.get());
    }

    private static Resultado contagem_de_grupos(int cenario, int n_alunos, Vertice[] alunos) {
        Optional<Optional<Integer>> index_OPT_OPT;
        int i;
        int n_grupos4;
        Optional<Integer> outros_OPT;
        int elementos_na_pilha;
        boolean[] EXTRACTED_35 = new boolean[n_alunos];
        Optional<Optional<boolean[]>> analisados_OPT_OPT = Optional.of(Optional.of(EXTRACTED_35));
        Optional<Stack> pilha_OPT = Optional.of(new Stack());
        Optional<Stack> p2_OPT;
        Optional<Lista_CFC> lista_comp_OPT = Optional.of(GruposConstants.CONSTANT_24);
        Optional<Optional<CFC>> j_OPT_OPT;
        Optional<Optional<Resultado>> resu_OPT_OPT;
        Optional<Integer> EXTRACTED_36_OPT = Optional.of(0);
        for (i = EXTRACTED_36_OPT.get(); i < n_alunos; i++) {
            Optional<Optional<Boolean>> EXTRACTED_45_OPT_OPT = Optional.of(Optional.of(GruposConstants.CONSTANT_25));
            analisados_OPT_OPT.get().get()[i] = EXTRACTED_45_OPT_OPT.get().get();
        }
        int EXTRACTED_37 = 0;
        n_grupos4 = EXTRACTED_37;
        outros_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_38_OPT = Optional.of(0);
        index_OPT_OPT = Optional.of(Optional.of(EXTRACTED_38_OPT.get()));
        int EXTRACTED_41 = 1;
        Optional<Optional<Integer>> EXTRACTED_40_OPT_OPT = Optional.of(Optional.of(-EXTRACTED_41));
        while ((i = primeiro_Nao_Analisado(analisados_OPT_OPT.get().get(), n_alunos)) != EXTRACTED_40_OPT_OPT.get().get()) {
            lista_comp_OPT = Optional.of(tarjan(n_alunos, alunos, i, index_OPT_OPT.get().get(), pilha_OPT.get(), lista_comp_OPT.get()));
            for (j_OPT_OPT = Optional.of(Optional.of(lista_comp_OPT.get().getPrimeiro())); j_OPT_OPT.get().get() != null; j_OPT_OPT = Optional.of(Optional.of(j_OPT_OPT.get().get().getNext()))) {
                p2_OPT = Optional.of(j_OPT_OPT.get().get().getComponente());
                elementos_na_pilha = p2_OPT.get().elemsStack();
                int EXTRACTED_42 = 4;
                boolean EXTRACTED_39 = elementos_na_pilha >= EXTRACTED_42;
                Optional<Boolean> EXTRACTED_43_OPT = Optional.of(!EXTRACTED_39);
                if (!EXTRACTED_43_OPT.get()) {
                    n_grupos4++;
                } else {
                    outros_OPT = Optional.of(elementos_na_pilha);
                }
                Optional<Boolean> EXTRACTED_41_OPT = Optional.of(false);
                boolean EXTRACTED_40 = p2_OPT.get().isEmpty() == EXTRACTED_41_OPT.get();
                Optional<Boolean> EXTRACTED_43_OPT = Optional.of(EXTRACTED_40);
                while (EXTRACTED_43_OPT.get()) {
                    Optional<Boolean> EXTRACTED_44_OPT = Optional.of(GruposConstants.CONSTANT_26);
                    analisados_OPT_OPT.get().get()[p2_OPT.get().pop()] = EXTRACTED_44_OPT.get();
                } 
            }
        } 
        Resultado EXTRACTED_42 = new Resultado(cenario, n_grupos4, outros_OPT.get());
        resu_OPT_OPT = Optional.of(Optional.of(EXTRACTED_42));
        return resu_OPT_OPT.get().get();
    }

    static int primeiro_Nao_Analisado(boolean[] estadoPosicoes, int n) {
        int i;
        Optional<Integer> EXTRACTED_46_OPT = Optional.of(0);
        for (i = EXTRACTED_46_OPT.get(); i < n; i++) {
            Optional<Boolean> EXTRACTED_45_OPT = Optional.of(estadoPosicoes[i]);
            Optional<Boolean> EXTRACTED_44_OPT = Optional.of(EXTRACTED_45_OPT.get() == false);
            Optional<Optional<Boolean>> EXTRACTED_47_OPT_OPT = Optional.of(Optional.of(EXTRACTED_44_OPT.get()));
            if (EXTRACTED_47_OPT_OPT.get().get())
                return i;

        }
        return GruposConstants.CONSTANT_27;
    }

    private static Lista_CFC tarjan(int n_alunos, Vertice[] alunos, int v, int index, Stack pilha, Lista_CFC lista_comp) {
        int i;
        Optional<Optional<Integer>> n_amigos_OPT_OPT;
        Optional<Optional<Integer>> amigo_OPT_OPT;
        Optional<Vertice> EXTRACTED_48_OPT = Optional.of(alunos[v]);
        EXTRACTED_48_OPT.get().setIndex(index);
        Optional<Optional<Vertice>> EXTRACTED_49_OPT_OPT = Optional.of(Optional.of(alunos[v]));
        EXTRACTED_49_OPT_OPT.get().get().setLowlink(index);
        index++;
        pilha.push(v);
        n_amigos_OPT_OPT = Optional.of(Optional.of(alunos[v].getNAmigos()));
        for (i = 0; i < n_amigos_OPT_OPT.get().get(); i++) {
            Optional<Vertice> EXTRACTED_49_OPT = Optional.of(alunos[v]);
            Optional<Optional<Vertice>> EXTRACTED_50_OPT_OPT = Optional.of(Optional.of(EXTRACTED_49_OPT.get()));
            amigo_OPT_OPT = Optional.of(Optional.of(EXTRACTED_50_OPT_OPT.get().get().Amigo(i)));
            Optional<Integer> EXTRACTED_50_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_51_OPT = Optional.of(-EXTRACTED_50_OPT.get());
            Optional<Vertice> EXTRACTED_52_OPT = Optional.of(alunos[amigo_OPT_OPT.get().get()]);
            boolean EXTRACTED_51 = EXTRACTED_52_OPT.get().getIndex() == EXTRACTED_51_OPT.get();
            Optional<Optional<Boolean>> EXTRACTED_54_OPT_OPT = Optional.of(Optional.of(EXTRACTED_51_OPT.get()));
            Optional<Boolean> EXTRACTED_53_OPT = Optional.of(!EXTRACTED_54_OPT_OPT.get().get());
            if (!EXTRACTED_53_OPT.get()) {
                tarjan(n_alunos, alunos, amigo_OPT_OPT.get().get(), index, pilha, lista_comp);
                Vertice EXTRACTED_46 = alunos[v];
                Optional<Vertice> EXTRACTED_52_OPT = Optional.of(EXTRACTED_46);
                Vertice EXTRACTED_55 = alunos[v];
                Optional<Vertice> EXTRACTED_56_OPT = Optional.of(alunos[amigo_OPT_OPT.get().get()]);
                EXTRACTED_55.setLowlink(min(EXTRACTED_52_OPT.get().getLowlink(), EXTRACTED_56_OPT.get().getLowlink()));
            } else if (pilha.elemInStack(amigo_OPT_OPT.get().get())) {
                Optional<Vertice> EXTRACTED_54_OPT = Optional.of(alunos[v]);
                Optional<Optional<Vertice>> EXTRACTED_53_OPT_OPT = Optional.of(Optional.of(EXTRACTED_54_OPT.get()));
                Vertice EXTRACTED_57 = alunos[v];
                Optional<Optional<Vertice>> EXTRACTED_56_OPT_OPT = Optional.of(Optional.of(EXTRACTED_57));
                Vertice EXTRACTED_55 = alunos[amigo_OPT_OPT.get().get()];
                EXTRACTED_56_OPT_OPT.get().get().setLowlink(min(EXTRACTED_53_OPT_OPT.get().get().getLowlink(), EXTRACTED_55.getIndex()));
            }
        }
        Vertice EXTRACTED_48 = alunos[v];
        Optional<Boolean> EXTRACTED_47_OPT = Optional.of(alunos[v].getLowlink() == EXTRACTED_48_OPT.get().getIndex());
        if (EXTRACTED_47_OPT.get()) {
            lista_comp.add2Lista(pilha.getTill(v));
        }
        return lista_comp;
    }

    private static int min(int x, int y) {
        Optional<Boolean> EXTRACTED_58_OPT = Optional.of(x <= y);
        Optional<Boolean> EXTRACTED_57_OPT = Optional.of(EXTRACTED_58_OPT.get());
        if (EXTRACTED_57_OPT.get())
            return x;

        return y;
    }

    public boolean Grupos_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static void output(Resultados resus) {
        Optional<Resultado> i_OPT;
        for (i_OPT = Optional.of(resus.getPrimeiro()); i_OPT.get() != null; i_OPT = Optional.of(i_OPT.get().proximo())) {
            String EXTRACTED_61 = GruposConstants.CONSTANT_26 + i_OPT.get().getCaso();
            Optional<Optional<String>> EXTRACTED_60_OPT_OPT = Optional.of(Optional.of(EXTRACTED_61));
            Optional<String> EXTRACTED_59_OPT = Optional.of(EXTRACTED_60_OPT_OPT.get().get() + GruposConstants.CONSTANT_27);
            Optional<String> EXTRACTED_62_OPT = Optional.of(EXTRACTED_59_OPT.get() + i_OPT.get().getGruposDe4());
            Optional<Optional<String>> EXTRACTED_59_OPT_OPT = Optional.of(Optional.of(EXTRACTED_62_OPT.get()));
            String EXTRACTED_60 = EXTRACTED_59_OPT_OPT.get().get() + GruposConstants.CONSTANT_28;
            Optional<String> EXTRACTED_58_OPT = Optional.of(EXTRACTED_60 + i_OPT.get().getOutrosElementos());
            pw.println(EXTRACTED_58_OPT.get());
        }
    }

    /**
     */
    public Grupos() {
        String EXTRACTED_64 = "You'd better not have called me!";
        Optional<RuntimeException> EXTRACTED_63_OPT = Optional.of(new RuntimeException(EXTRACTED_64));
        throw EXTRACTED_63_OPT.get();
    }

    /**
     */
    public Grupos(float float0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}