import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;
public class SociologiaCC {
    public SociologiaCC() {
    }

    public static int BRANCO = 0;

    public static int CINZA = 1;

    public static int PRETO = 2;

    public static int n_alunos;

    public static int n_grupos_tot;

    public static int n_grupos;

    public double SociologiaCC_callMe_not(String string0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static int[] finalizacao;

    public static Alunos[] listaAlunosT;

    public static LinkedList<Integer> grupos;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Optional<Integer> conta_OPT = Optional.of(0);
        Optional<Alunos[]> listaAlunos_OPT;
        grupos = SociologiaCCConstants.CONSTANT_1;
        n_alunos = in.nextInt();
        in.nextLine();
        listaAlunos_OPT = Optional.of(new Alunos[n_alunos + 1]);
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
        listaAlunosT = new Alunos[n_alunos + EXTRACTED_1_OPT.get()];
        finalizacao = new int[n_alunos + 1];
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(1);
        Optional<Integer> EXTRACTED_3_OPT = Optional.of(n_alunos + 1);
        for (int i = EXTRACTED_2_OPT.get(); i < EXTRACTED_3_OPT.get(); i++) {
            Optional<Alunos> EXTRACTED_4_OPT = Optional.of(new Alunos(i));
            listaAlunos_OPT.get()[i] = EXTRACTED_4_OPT.get();
            Alunos EXTRACTED_13 = new Alunos(i);
            listaAlunosT[i] = EXTRACTED_13;
        }
        Optional<Integer> amigos_OPT;
        for (int i = 1; i < (n_alunos + 1); i++) {
            amigos_OPT = Optional.of(in.nextInt());
            int aluno_temp;
            Optional<Integer> EXTRACTED_14_OPT = Optional.of(0);
            for (int j = EXTRACTED_14_OPT.get(); j < amigos_OPT.get(); j++) {
                aluno_temp = in.nextInt();
                Alunos EXTRACTED_5 = listaAlunos_OPT.get()[i];
                amigos_OPT.get().add(listaAlunos_OPT.get()[aluno_temp]);
                Optional<Alunos> EXTRACTED_6_OPT = Optional.of(listaAlunosT[i]);
                Alunos EXTRACTED_15 = listaAlunosT[aluno_temp];
                amigos_OPT.get().add(EXTRACTED_6_OPT.get());
            }
            in.nextLine();
        }
        try {
            Optional<Integer> EXTRACTED_7_OPT = Optional.of(0);
            n_grupos = EXTRACTED_7_OPT.get();
            for (int i = 1; i < finalizacao.length; i++) {
                Optional<Alunos> EXTRACTED_8_OPT = Optional.of(listaAlunos_OPT.get()[i]);
                if (EXTRACTED_8_OPT.get().cor != PRETO) {
                    Optional<Alunos> EXTRACTED_16_OPT = Optional.of(listaAlunos_OPT.get()[i]);
                    dfs(listaAlunos_OPT.get(), EXTRACTED_16_OPT.get());
                }
            }
            Optional<Integer> EXTRACTED_9_OPT = Optional.of(1);
            int EXTRACTED_10 = 1;
            Optional<Integer> EXTRACTED_17_OPT = Optional.of(n_alunos + EXTRACTED_10);
            for (int i = EXTRACTED_9_OPT.get(); i < EXTRACTED_17_OPT.get(); i++) {
                Optional<Alunos> EXTRACTED_18_OPT = Optional.of(listaAlunosT[i]);
                EXTRACTED_18_OPT.get().cor = BRANCO;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int count = 0;
        Optional<Boolean> EXTRACTED_11_OPT = Optional.of(todos_visitados() == SociologiaCCConstants.CONSTANT_2);
        while (EXTRACTED_11_OPT.get()) {
            Optional<Integer> maximo_OPT = Optional.of(get_max().aluno);
            boolean EXTRACTED_12 = listaAlunosT[maximo_OPT.get()].cor != PRETO;
            if (EXTRACTED_12) {
                Optional<Integer> aux_OPT = Optional.of(dfsT(listaAlunosT, maximo_OPT.get()));
                n_grupos_tot += aux_OPT.get();
                grupos.addLast(n_grupos_tot);
                count++;
            }
        } 
        System.out.print(grupos.size());
    }

    public static boolean todos_visitados() {
        Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
        for (int i = EXTRACTED_19_OPT.get(); i < (n_alunos + 1); i++) {
            Alunos EXTRACTED_21 = listaAlunosT[i];
            boolean EXTRACTED_20 = EXTRACTED_21.cor != PRETO;
            if (EXTRACTED_20) {
                Optional<Boolean> EXTRACTED_22_OPT = Optional.of(false);
                return EXTRACTED_22_OPT.get();
            }
        }
        return SociologiaCCConstants.CONSTANT_3;
    }

    public static Alunos get_max() {
        Optional<Integer> conta_OPT = Optional.of(0);
        Optional<Integer> gajo_OPT = Optional.of(1);
        for (int i = 1; i < finalizacao.length; i++) {
            Optional<Boolean> EXTRACTED_23_OPT = Optional.of(finalizacao[i] > conta_OPT.get());
            if (EXTRACTED_23_OPT.get()) {
                int EXTRACTED_24 = finalizacao[i];
                conta_OPT = Optional.of(EXTRACTED_24);
                gajo_OPT = Optional.of(i);
            }
        }
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
        finalizacao[gajo_OPT.get()] = EXTRACTED_25_OPT.get();
        return listaAlunosT[gajo_OPT.get()];
    }

    public static void dfs(Alunos[] listaAlunos, Alunos aluno) throws InterruptedException {
        aluno.cor = PRETO;
        Optional<Alunos> EXTRACTED_26_OPT = Optional.of(listaAlunos[aluno.aluno]);
        for (Alunos aluno_temp : EXTRACTED_26_OPT.get().amigos) {
            boolean EXTRACTED_27 = aluno_temp.cor != PRETO;
            if (EXTRACTED_27) {
                dfs(listaAlunos, aluno_temp);
            }
        }
        n_grupos++;
        finalizacao[aluno.aluno] = n_grupos;
    }

    public static int dfsT(Alunos[] listaAlunosT, int temp_aluno) {
        Optional<Integer> count_OPT = Optional.of(1);
        listaAlunosT[temp_aluno].cor = PRETO;
        Optional<Alunos> EXTRACTED_28_OPT = Optional.of(listaAlunosT[temp_aluno]);
        for (Alunos aluno2 : EXTRACTED_28_OPT.get().amigos) {
            Optional<Boolean> EXTRACTED_29_OPT = Optional.of(aluno2.cor != PRETO);
            if (EXTRACTED_29_OPT.get()) {
                count_OPT = Optional.of(dfsT(listaAlunosT, aluno2.aluno));
            }
        }
        return count_OPT.get();
    }

    /**
     */
    public SociologiaCC(Object object0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Alunos {
    int aluno;

    public int Alunos_callMe_not(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int cor;

    ArrayList<Alunos> amigos;

    Alunos(int aluno) {
        this.aluno = aluno;
        this.cor = SociologiaCC.BRANCO;
        amigos = AlunosConstants.CONSTANT_4;
    }

    /**
     */
    public Alunos() {
        throw new RuntimeException("You'd better not have called me!");
    }
}