import java.util.*;
class No {
    int aluno;

    Boolean visitado;

    public Object No_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    LinkedList<Integer> amigos;

    LinkedList<Integer> DFSresultado;

    No(int alu) {
        aluno = alu;
        amigos = NoConstants.CONSTANT_1;
        Optional<LinkedList<Integer>> EXTRACTED_1_OPT = Optional.of(new LinkedList<Integer>());
        DFSresultado = EXTRACTED_1_OPT.get();
        visitado = NoConstants.CONSTANT_2;
    }

    /**
     */
    public No(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Grafo {
    LinkedList<No> total;

    public double Grafo_callMe_not(Object object0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    Grafo() {
        total = GrafoConstants.CONSTANT_3;
    }

    void ColocaGrafo(int alu) {
        total.add(new No(alu));
    }

    void AdicionaLigacao(int amigo, int aluno) {
        for (No n : total) {
            if (n.aluno == aluno)
                n.amigos.add(amigo);

        }
    }

    void DFS(Grafo grafo) {
        for (No n : total) {
            if (n.visitado == GrafoConstants.CONSTANT_4)
                DFSVisit(n, grafo, n);

            for (No k : total)
                k.visitado = false;

        }
    }

    void DFSVisit(No z, Grafo grafo, No n) {
        n.visitado = GrafoConstants.CONSTANT_5;
        for (int a : n.amigos)
            for (No f : total) {
                boolean EXTRACTED_2 = a == f.aluno;
                if (EXTRACTED_2) {
                    Optional<Boolean> EXTRACTED_4_OPT = Optional.of(false);
                    Optional<Boolean> EXTRACTED_3_OPT = Optional.of(f.visitado == EXTRACTED_4_OPT.get());
                    if (EXTRACTED_3_OPT.get())
                        DFSVisit(z, grafo, f);

                }
            }

        z.DFSresultado.add(n.aluno);
    }

    /**
     */
    public Grafo(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public float Sociologia_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public Sociologia() {
    }

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        int count = 1;
        Optional<Integer> ncenarios_OPT = Optional.of(in_OPT.get().nextInt());
        Optional<LinkedList<Integer>> fim_OPT = Optional.of(new LinkedList<Integer>());
        while (count <= ncenarios_OPT.get()) {
            int ngrupos = 0;
            int nsgrupo = 0;
            Optional<Integer> nalunos_OPT = Optional.of(in_OPT.get().nextInt());
            Optional<Grafo> grafo_OPT = Optional.of(new Grafo());
            Optional<Grafo> grafoT_OPT = Optional.of(new Grafo());
            for (int i = 1; i <= nalunos_OPT.get(); i++) {
                grafo_OPT.get().ColocaGrafo(i);
                grafoT_OPT.get().ColocaGrafo(i);
            }
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(0);
            for (int i = EXTRACTED_5_OPT.get(); i < nalunos_OPT.get(); i++) {
                Optional<Integer> aluno_OPT = Optional.of(in_OPT.get().nextInt());
                Optional<Integer> namigos_OPT = Optional.of(in_OPT.get().nextInt());
                Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
                for (int j = EXTRACTED_6_OPT.get(); j < namigos_OPT.get(); j++) {
                    Optional<Integer> amigo_OPT = Optional.of(in_OPT.get().nextInt());
                    grafo_OPT.get().AdicionaLigacao(amigo_OPT.get(), aluno_OPT.get());
                    grafoT_OPT.get().AdicionaLigacao(aluno_OPT.get(), amigo_OPT.get());
                }
            }
            grafo_OPT.get().DFS(grafo_OPT.get());
            grafoT_OPT.get().DFS(grafoT_OPT.get());
            for (No n : grafo_OPT.get().total) {
                boolean EXTRACTED_7 = n.visitado == SociologiaConstants.CONSTANT_6;
                if (EXTRACTED_7) {
                    fim_OPT = Optional.of(n.DFSresultado);
                    for (No t : grafoT_OPT.get().total) {
                        boolean EXTRACTED_8 = t.aluno == n.aluno;
                        if (EXTRACTED_8)
                            fim_OPT.get().retainAll(t.DFSresultado);

                    }
                    for (int h : fim_OPT.get()) {
                        for (No f : grafo_OPT.get().total) {
                            Optional<Integer> EXTRACTED_10_OPT = Optional.of(1);
                            Optional<Boolean> EXTRACTED_9_OPT = Optional.of(f.DFSresultado.size() != EXTRACTED_10_OPT.get());
                            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(h == f.aluno);
                            if (EXTRACTED_14_OPT.get() && EXTRACTED_9_OPT.get())
                                f.visitado = SociologiaConstants.CONSTANT_7;

                        }
                    }
                    boolean EXTRACTED_11 = fim_OPT.get().size() >= SociologiaConstants.CONSTANT_8;
                    if (EXTRACTED_11)
                        ngrupos++;

                }
            }
            for (No n : grafo_OPT.get().total) {
                Optional<Boolean> EXTRACTED_15_OPT = Optional.of(false);
                if (n.visitado == EXTRACTED_15_OPT.get())
                    nsgrupo++;

            }
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(0);
            if (ngrupos == EXTRACTED_12_OPT.get())
                nsgrupo = nalunos_OPT.get();

            String EXTRACTED_16 = SociologiaConstants.CONSTANT_9 + count;
            System.out.println(EXTRACTED_16);
            Optional<String> EXTRACTED_13_OPT = Optional.of(" ");
            Optional<String> EXTRACTED_18_OPT = Optional.of(ngrupos + EXTRACTED_13_OPT.get());
            String EXTRACTED_17 = EXTRACTED_18_OPT.get() + nsgrupo;
            System.out.println(EXTRACTED_17);
            count++;
        } 
    }

    /**
     */
    public Sociologia(float float0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}