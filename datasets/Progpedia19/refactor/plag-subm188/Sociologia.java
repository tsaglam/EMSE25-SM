import java.util.LinkedList;
import java.util.Optional;
import java.util.Stack;
class Vertice {
    int aluno;

    int[] amigos;

    LinkedList<Integer> tamigos = new LinkedList<Integer>();

    int namigos;

    public double Vertice_callMe_not(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int cor;

    int tempo;

    Vertice(int aluno, int namigos) {
        this.aluno = aluno;
        Optional<int[]> EXTRACTED_1_OPT = Optional.of(new int[namigos]);
        this.amigos = EXTRACTED_1_OPT.get();
    }

    void adicionaAmigo(int amigo) {
        amigos[namigos] = amigo;
        namigos++;
    }

    void adicionarAmigoTransposto(int amigo) {
        tamigos.add(amigo);
    }

    /**
     */
    public Vertice() {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public Sociologia() {
    }

    private static int tempo;

    private static Stack<Integer> pilha = new Stack<Integer>();

    private static LinkedList<Integer> arvore;

    public static void main(String[] args) {
        int ncasos = SociologiaConstants.in.nextInt();
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(ncasos + 1);
        for (int i = 1; i < EXTRACTED_2_OPT.get(); i++) {
            int nalunos = SociologiaConstants.in.nextInt();
            Optional<Vertice[]> vertices_OPT = Optional.of(new Vertice[nalunos]);
            vertices_OPT = Optional.of(recolherDados(nalunos, vertices_OPT.get()));
            vertices_OPT = Optional.of(ordenar(vertices_OPT.get()));
            vertices_OPT = Optional.of(DFS(vertices_OPT.get()));
            vertices_OPT = Optional.of(calcularTransposta(vertices_OPT.get()));
            DFS_invertido(vertices_OPT.get());
            Optional<String> EXTRACTED_7_OPT = Optional.of(SociologiaConstants.CONSTANT_1 + i);
            Optional<String> EXTRACTED_6_OPT = Optional.of(EXTRACTED_7_OPT.get() + SociologiaConstants.CONSTANT_2);
            Optional<String> EXTRACTED_4_OPT = Optional.of(EXTRACTED_6_OPT.get() + SociologiaConstants.grupos);
            String EXTRACTED_5 = EXTRACTED_4_OPT.get() + SociologiaConstants.CONSTANT_3;
            Optional<String> EXTRACTED_3_OPT = Optional.of(EXTRACTED_5 + SociologiaConstants.sozinhos);
            System.out.println(EXTRACTED_3_OPT.get());
        }
    }

    private static void DFS_invertido(Vertice[] vertices) {
        grupos = 0;
        sozinhos = 0;
        Vertice u;
        for (Vertice v : vertices) {
            v.cor = 0;
        }
        while (!pilha.isEmpty()) {
            int EXTRACTED_13 = 1;
            Optional<Integer> EXTRACTED_8_OPT = Optional.of(pilha.pop() - EXTRACTED_13);
            u = vertices[EXTRACTED_8_OPT.get()];
            arvore = new LinkedList<Integer>();
            Optional<Integer> EXTRACTED_10_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_9_OPT = Optional.of(u.cor == EXTRACTED_10_OPT.get());
            if (EXTRACTED_9_OPT.get()) {
                arvore.add(u.aluno);
                vertices = DFS_visit_invertido(u, vertices);
            }
            boolean EXTRACTED_11 = arvore.size() >= SociologiaConstants.CONSTANT_4;
            if (!EXTRACTED_11) {
                Optional<Integer> EXTRACTED_12_OPT = Optional.of(SociologiaConstants.sozinhos + arvore.size());
                sozinhos = EXTRACTED_12_OPT.get();
            } else
                grupos++;

        } 
    }

    private static Vertice[] DFS_visit_invertido(Vertice v, Vertice[] vertices) {
        v.cor = 1;
        for (int amigo : v.tamigos) {
            Optional<Integer> EXTRACTED_14_OPT = Optional.of(amigo - 1);
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            Optional<Boolean> EXTRACTED_15_OPT = Optional.of(vertices[EXTRACTED_14_OPT.get()].cor == EXTRACTED_16_OPT.get());
            if (EXTRACTED_15_OPT.get()) {
                arvore.add(amigo);
                Optional<Integer> EXTRACTED_17_OPT = Optional.of(amigo - 1);
                Optional<Vertice> EXTRACTED_18_OPT = Optional.of(vertices[EXTRACTED_17_OPT.get()]);
                vertices = DFS_visit_invertido(EXTRACTED_18_OPT.get(), vertices);
            }
        }
        return vertices;
    }

    private static Vertice[] calcularTransposta(Vertice[] vertices) {
        for (Vertice v : vertices) {
            for (int aluno : v.amigos) {
                int EXTRACTED_20 = 1;
                Optional<Integer> EXTRACTED_19_OPT = Optional.of(aluno - EXTRACTED_20);
                vertices[EXTRACTED_19_OPT.get()].adicionarAmigoTransposto(v.aluno);
            }
        }
        return vertices;
    }

    private static Vertice[] ordenar(Vertice[] vertices) {
        Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
        Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
        for (int i = EXTRACTED_21_OPT.get(); i < (vertices.length - EXTRACTED_22_OPT.get()); i++) {
            int EXTRACTED_25 = 1;
            int EXTRACTED_24 = i + EXTRACTED_25;
            Vertice EXTRACTED_23 = vertices[EXTRACTED_24];
            Vertice EXTRACTED_26 = vertices[i];
            boolean EXTRACTED_28 = EXTRACTED_23.aluno < EXTRACTED_26.aluno;
            if (EXTRACTED_28) {
                Optional<Vertice> temp_OPT = Optional.of(vertices[i]);
                Optional<Integer> EXTRACTED_31_OPT = Optional.of(i + 1);
                Optional<Vertice> EXTRACTED_27_OPT = Optional.of(vertices[EXTRACTED_31_OPT.get()]);
                vertices[i] = EXTRACTED_27_OPT.get();
                Optional<Integer> EXTRACTED_30_OPT = Optional.of(1);
                int EXTRACTED_29 = i + EXTRACTED_30_OPT.get();
                vertices[EXTRACTED_29] = temp_OPT.get();
            }
        }
        return vertices;
    }

    private static Vertice[] DFS(Vertice[] vertices) {
        for (Vertice v : vertices) {
            v.cor = 0;
            v.tempo = 0;
        }
        tempo = 0;
        for (Vertice v : vertices) {
            if (v.cor == 0) {
                vertices = DFS_visit(v, vertices);
            }
        }
        return vertices;
    }

    private static Vertice[] DFS_visit(Vertice v, Vertice[] vertices) {
        v.cor = 1;
        tempo++;
        v.tempo = tempo;
        for (int amigo : v.amigos) {
            int EXTRACTED_34 = 1;
            Optional<Integer> EXTRACTED_33_OPT = Optional.of(amigo - EXTRACTED_34);
            Optional<Vertice> EXTRACTED_32_OPT = Optional.of(vertices[EXTRACTED_33_OPT.get()]);
            Optional<Integer> EXTRACTED_35_OPT = Optional.of(0);
            if (EXTRACTED_32_OPT.get().cor == EXTRACTED_35_OPT.get()) {
                Optional<Integer> EXTRACTED_37_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_36_OPT = Optional.of(amigo - EXTRACTED_37_OPT.get());
                vertices = DFS_visit(vertices[EXTRACTED_36_OPT.get()], vertices);
            }
        }
        tempo++;
        v.tempo = tempo;
        pilha.push(v.aluno);
        return vertices;
    }

    public Object Sociologia_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    private static Vertice[] recolherDados(int nalunos, Vertice[] vertices) {
        for (int j = 0; j < nalunos; j++) {
            Optional<Integer> id_OPT = Optional.of(SociologiaConstants.in.nextInt());
            int namigos = SociologiaConstants.in.nextInt();
            Optional<Vertice> EXTRACTED_38_OPT = Optional.of(new Vertice(id_OPT.get(), namigos));
            vertices[j] = EXTRACTED_38_OPT.get();
            int EXTRACTED_39 = 0;
            for (int h = EXTRACTED_39; h < namigos; h++) {
                Optional<Vertice> EXTRACTED_40_OPT = Optional.of(vertices[j]);
                EXTRACTED_40_OPT.get().adicionaAmigo(SociologiaConstants.in.nextInt());
            }
        }
        return vertices;
    }

    /**
     */
    public Sociologia(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}