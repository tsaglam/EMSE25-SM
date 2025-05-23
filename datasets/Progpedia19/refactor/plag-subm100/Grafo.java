import java.util.*;
public class Sociologia {
    public Sociologia() {
    }

    public Object Sociologia_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void main(String[] args) {
        Optional<Integer> n_cenarios_OPT;
        int n_alunos;
        int control;
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        n_cenarios_OPT = Optional.of(stdin_OPT.get().nextInt());
        stdin_OPT.get().nextLine();
        control = SociologiaConstants.CONSTANT_1;
        Optional<Boolean> EXTRACTED_1_OPT = Optional.of(n_cenarios_OPT.get() >= control);
        while (EXTRACTED_1_OPT.get()) {
            n_alunos = stdin_OPT.get().nextInt();
            stdin_OPT.get().nextLine();
            Optional<Grafo> g_OPT = Optional.of(new Grafo(n_alunos));
            Optional<Boolean> EXTRACTED_2_OPT = Optional.of(n_alunos > SociologiaConstants.CONSTANT_2);
            while (EXTRACTED_2_OPT.get()) {
                ArrayList<Integer> temp_Adj = new ArrayList<Integer>();
                Optional<ArrayList<Integer>> temp_Pre_OPT = Optional.of(new ArrayList<Integer>());
                int aluno = stdin_OPT.get().nextInt();
                int amigos = stdin_OPT.get().nextInt();
                int EXTRACTED_3 = 0;
                while (amigos > EXTRACTED_3) {
                    Optional<Integer> amigo_OPT = Optional.of(stdin_OPT.get().nextInt());
                    temp_Adj.add(amigo_OPT.get());
                    Optional<Boolean> EXTRACTED_6_OPT = Optional.of(!g_OPT.get().listaPre.containsKey(amigo_OPT.get()));
                    if (!EXTRACTED_6_OPT.get()) {
                        g_OPT.get().listaPre.get(amigo_OPT.get()).add(aluno);
                    } else {
                        temp_Pre_OPT.get().add(aluno);
                        g_OPT.get().listaPre.put(amigo_OPT.get(), temp_Pre_OPT.get());
                    }
                    amigos--;
                } 
                g_OPT.get().listaAdj.put(aluno, temp_Adj);
                Optional<String> EXTRACTED_7_OPT = Optional.of(SociologiaConstants.CONSTANT_3 + aluno);
                Optional<String> EXTRACTED_9_OPT = Optional.of((EXTRACTED_7_OPT.get() + " tem ") + temp_Adj.size());
                Optional<String> EXTRACTED_4_OPT = Optional.of(EXTRACTED_9_OPT.get() + SociologiaConstants.CONSTANT_4);
                System.out.println(EXTRACTED_4_OPT.get());
                n_alunos--;
            } 
            String EXTRACTED_8 = "Caso: ";
            String EXTRACTED_5 = EXTRACTED_8 + control;
            System.out.println(EXTRACTED_5);
            control++;
        } 
    }

    /**
     */
    public Sociologia() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    int vertices;

    HashMap<Integer, ArrayList<Integer>> listaAdj;

    HashMap<Integer, ArrayList<Integer>> listaPre;

    int[] color;

    Grafo(int v) {
        vertices = v;
        listaAdj = new HashMap<Integer, ArrayList<Integer>>();
        listaPre = new HashMap<Integer, ArrayList<Integer>>();
        color = new int[v];
    }

    void DFS() {
        for (int u : listaAdj.keySet()) {
            int EXTRACTED_10 = u - GrafoConstants.CONSTANT_5;
            if (color[EXTRACTED_10] == 0)
                DFS(u);

        }
    }

    void DFS(int u) {
        int EXTRACTED_12 = 1;
        Optional<Integer> EXTRACTED_11_OPT = Optional.of(u - EXTRACTED_12);
        color[EXTRACTED_11_OPT.get()] = 1;
        for (int v : listaAdj.get(u)) {
        }
    }

    public Object Grafo_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Grafo() {
        throw new RuntimeException("You'd better not have called me!");
    }
}