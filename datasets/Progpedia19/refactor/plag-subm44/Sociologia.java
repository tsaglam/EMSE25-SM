import java.util.*;
class Arco {
    int peso;

    int aponta;

    public int Arco_callMe_not(double double0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Arco(int p, int a) {
        peso = p;
        aponta = a;
    }

    /**
     */
    public Arco(Object object0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Vertex {
    LinkedList<Arco> arestas;

    public int Vertex_callMe_not(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Vertex() {
        LinkedList<Arco> EXTRACTED_1 = new LinkedList<Arco>();
        arestas = EXTRACTED_1;
    }

    /**
     */
    public Vertex(long long0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    int sizeV;

    int sizeA;

    Vertex[] vertex;

    int[] visitado;

    Grafo(int tamanho) {
        sizeV = tamanho;
        vertex = new Vertex[tamanho];
        visitado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vertex[i] = GrafoConstants.CONSTANT_1;
            Optional<Integer> EXTRACTED_2_OPT = Optional.of(0);
            visitado[i] = EXTRACTED_2_OPT.get();
        }
    }

    public void AddArco(int were, int p, int a) {
        Vertex EXTRACTED_3 = vertex[were];
        EXTRACTED_3.arestas.add(new Arco(p, a));
        sizeA++;
    }

    public double Grafo_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int Vertices() {
        return sizeV;
    }

    public int Arcos() {
        return sizeA;
    }

    /**
     */
    public Grafo(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Sociologia {
    public Sociologia() {
    }

    static void DFS(Grafo xpto, int v) {
        Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
        xpto.visitado[v] = EXTRACTED_4_OPT.get();
        Optional<ListIterator<Arco>> iterador_OPT = Optional.of(xpto.vertex[v].arestas.listIterator());
        while (iterador_OPT.get().hasNext()) {
            Optional<Integer> aux_OPT = Optional.of(iterador_OPT.get().next().aponta);
            int EXTRACTED_6 = xpto.visitado[aux_OPT.get()];
            Optional<Boolean> EXTRACTED_5_OPT = Optional.of(EXTRACTED_6 == SociologiaConstants.CONSTANT_2);
            if (EXTRACTED_5_OPT.get())
                DFS(xpto, aux_OPT.get());

        } 
        fexado.push(v);
    }

    static int DFS1(Grafo xpto, int v) {
        xpto.visitado[v] = 1;
        Optional<ListIterator<Arco>> iterador_OPT = Optional.of(xpto.vertex[v].arestas.listIterator());
        Optional<Integer> count_OPT = Optional.of(1);
        while (iterador_OPT.get().hasNext()) {
            Optional<Integer> aux_OPT = Optional.of(iterador_OPT.get().next().aponta);
            Optional<Integer> EXTRACTED_8_OPT = Optional.of(xpto.visitado[aux_OPT.get()]);
            boolean EXTRACTED_7 = EXTRACTED_8_OPT.get() == 0;
            if (EXTRACTED_7) {
                count_OPT = Optional.of(DFS1(xpto, aux_OPT.get()));
            }
        } 
        return count_OPT.get();
    }

    public int Sociologia_callMe_not(boolean boolean0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static Stack<Integer> fexado = new Stack<Integer>();

    public static void main(String[] Args) {
        Optional<Scanner> ler_OPT = Optional.of(new Scanner(System.in));
        Optional<StringBuilder> output_OPT = Optional.of(new StringBuilder());
        int casos = ler_OPT.get().nextInt();
        for (int lim = 0; lim < casos; lim++) {
            Optional<Integer> npessoas_OPT = Optional.of(ler_OPT.get().nextInt());
            Grafo amigos = new Grafo(npessoas_OPT.get());
            Grafo amigos1 = new Grafo(npessoas_OPT.get());
            int EXTRACTED_9 = 0;
            for (int i = EXTRACTED_9; i < npessoas_OPT.get(); i++) {
                Optional<Integer> amigo_OPT = Optional.of(ler_OPT.get().nextInt());
                int namigos = ler_OPT.get().nextInt();
                int EXTRACTED_10 = 0;
                for (int x = EXTRACTED_10; x < namigos; x++) {
                    Optional<Integer> amig_OPT = Optional.of(ler_OPT.get().nextInt());
                    int EXTRACTED_11 = 1;
                    Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
                    Optional<Integer> EXTRACTED_13_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_24_OPT = Optional.of(amigo_OPT.get() - EXTRACTED_11);
                    Optional<Integer> EXTRACTED_28_OPT = Optional.of(amig_OPT.get() - EXTRACTED_13_OPT.get());
                    amigos.AddArco(EXTRACTED_24_OPT.get(), EXTRACTED_12_OPT.get(), EXTRACTED_28_OPT.get());
                    Optional<Integer> EXTRACTED_25_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_14_OPT = Optional.of(amig_OPT.get() - EXTRACTED_25_OPT.get());
                    int EXTRACTED_27 = 1;
                    Optional<Integer> EXTRACTED_15_OPT = Optional.of(amigo_OPT.get() - EXTRACTED_27);
                    Optional<Integer> EXTRACTED_26_OPT = Optional.of(0);
                    amigos1.AddArco(EXTRACTED_14_OPT.get(), EXTRACTED_26_OPT.get(), EXTRACTED_15_OPT.get());
                }
            }
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            for (int i = EXTRACTED_16_OPT.get(); i < amigos.sizeV; i++) {
                Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
                Optional<Integer> EXTRACTED_21_OPT = Optional.of(amigos.visitado[i]);
                Optional<Boolean> EXTRACTED_17_OPT = Optional.of(EXTRACTED_21_OPT.get() == EXTRACTED_18_OPT.get());
                if (EXTRACTED_17_OPT.get())
                    DFS(amigos, i);

            }
            output_OPT.get().append(String.format("Caso #%d\n", lim + 1));
            int grupos = 0;
            Optional<Integer> solos_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_19_OPT = Optional.of(!fexado.isEmpty());
            while (EXTRACTED_19_OPT.get()) {
                Optional<Integer> aux_OPT = Optional.of(fexado.pop());
                Optional<Integer> EXTRACTED_29_OPT = Optional.of(amigos1.visitado[aux_OPT.get()]);
                Optional<Integer> EXTRACTED_30_OPT = Optional.of(0);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(EXTRACTED_29_OPT.get() == EXTRACTED_30_OPT.get());
                if (EXTRACTED_20_OPT.get()) {
                    int count = DFS1(amigos1, aux_OPT.get());
                    Optional<Integer> EXTRACTED_23_OPT = Optional.of(4);
                    boolean EXTRACTED_22 = count >= EXTRACTED_23_OPT.get();
                    if (!EXTRACTED_22) {
                        solos_OPT = Optional.of(count);
                    } else
                        grupos++;

                }
            } 
            output_OPT.get().append(String.format(SociologiaConstants.CONSTANT_3, grupos, solos_OPT.get()));
        }
        System.out.print(output_OPT.get());
        ler_OPT.get().close();
    }

    /**
     */
    public Sociologia(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}