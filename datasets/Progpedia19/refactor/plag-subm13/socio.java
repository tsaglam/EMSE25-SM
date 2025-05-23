import java.util.*;
class Aluno {
    int cod;

    public long Aluno_callMe_not(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    int place;

    public double Aluno_callMe_not(double double0) {
        throw AlunoConstants.CONSTANT_1;
    }

    int place2;

    boolean estado;

    Aluno(int c) {
        cod = c;
        place = AlunoConstants.CONSTANT_1;
        int EXTRACTED_1 = 0;
        place2 = EXTRACTED_1;
        estado = AlunoConstants.CONSTANT_2;
    }

    /**
     */
    public Aluno(String string0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Aluno(int int0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class socio {
    public socio() {
    }

    static int lugar(Aluno[] gr, int val, int t) {
        for (int i = 1; i <= t; i++) {
            Optional<Aluno> EXTRACTED_1_OPT = Optional.of(gr[i]);
            Optional<Optional<Aluno>> EXTRACTED_3_OPT_OPT = Optional.of(Optional.of(EXTRACTED_1_OPT.get()));
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(EXTRACTED_3_OPT_OPT.get().get().place == val);
            if (EXTRACTED_3_OPT.get())
                return i;

        }
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(1);
        int EXTRACTED_2 = -EXTRACTED_2_OPT.get();
        return EXTRACTED_2;
    }

    static int dfs(Aluno[] gr, int k, int pl, boolean[][] m, int t) {
        gr[k].estado = socioConstants.CONSTANT_3;
        int EXTRACTED_4 = 1;
        for (int i = EXTRACTED_4; i <= t; i++) {
            Optional<Aluno> EXTRACTED_4_OPT = Optional.of(gr[i]);
            Optional<Optional<Aluno>> EXTRACTED_6_OPT_OPT = Optional.of(Optional.of(EXTRACTED_4_OPT.get()));
            Optional<Boolean> EXTRACTED_7_OPT = Optional.of(m[k][i]);
            boolean EXTRACTED_5 = !EXTRACTED_6_OPT_OPT.get().get().estado;
            Optional<Boolean> EXTRACTED_5_OPT = Optional.of(EXTRACTED_5_OPT.get() && EXTRACTED_7_OPT.get());
            if (EXTRACTED_5_OPT.get())
                pl = dfs(gr, i, pl, m, t);

        }
        gr[k].place = pl;
        pl++;
        return pl;
    }

    public boolean socio_callMe_not(float float0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public String socio_callMe_not() {
        throw new RuntimeException(socioConstants.CONSTANT_4);
    }

    static int dfsv(Aluno[] gr, int k, int pl, boolean[][] m, int t) {
        Optional<Aluno> EXTRACTED_8_OPT = Optional.of(gr[k]);
        EXTRACTED_8_OPT.get().estado = socioConstants.CONSTANT_3;
        for (int i = 1; i <= t; i++) {
            Optional<Aluno> EXTRACTED_6_OPT = Optional.of(gr[i]);
            Optional<Optional<Aluno>> EXTRACTED_11_OPT_OPT = Optional.of(Optional.of(EXTRACTED_6_OPT.get()));
            boolean[] EXTRACTED_8 = m[i];
            Optional<Boolean> EXTRACTED_7_OPT = Optional.of(EXTRACTED_8[k]);
            boolean EXTRACTED_9 = EXTRACTED_11_OPT_OPT.get().get().estado && EXTRACTED_7_OPT.get();
            if (EXTRACTED_9)
                pl = dfsv(gr, i, pl, m, t);

        }
        Optional<Aluno> EXTRACTED_10_OPT = Optional.of(gr[k]);
        EXTRACTED_10_OPT.get().place2 = pl;
        pl++;
        return pl;
    }

    public static void main(String[] args) {
        Optional<Optional<Scanner>> kb_OPT_OPT = Optional.of(Optional.of(new Scanner(System.in)));
        Optional<Integer> cenar_OPT = Optional.of(kb_OPT_OPT.get().get().nextInt());
        for (int i = 1; i <= cenar_OPT.get(); i++) {
            int grupos = 0;
            Optional<Optional<Integer>> solos_OPT_OPT = Optional.of(Optional.of(0));
            Optional<Optional<Integer>> alunos_OPT_OPT = Optional.of(Optional.of(kb_OPT_OPT.get().get().nextInt()));
            Optional<Optional<Integer>> EXTRACTED_13_OPT_OPT = Optional.of(Optional.of(1));
            Optional<Integer> EXTRACTED_9_OPT = Optional.of(alunos_OPT_OPT.get().get() + EXTRACTED_13_OPT_OPT.get().get());
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(EXTRACTED_9_OPT.get());
            Optional<Optional<Aluno[]>> lista_OPT_OPT = Optional.of(Optional.of(new Aluno[EXTRACTED_12_OPT.get()]));
            Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(alunos_OPT_OPT.get().get() + EXTRACTED_22_OPT.get());
            Optional<Integer> EXTRACTED_23_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_12_OPT = Optional.of(alunos_OPT_OPT.get().get() + EXTRACTED_23_OPT.get());
            Optional<boolean[][]> EXTRACTED_10_OPT = Optional.of(new boolean[EXTRACTED_11_OPT.get()][EXTRACTED_12_OPT.get()]);
            Optional<Optional<boolean[][]>> matr_OPT_OPT = Optional.of(Optional.of(EXTRACTED_10_OPT.get()));
            Optional<Optional<Integer>> EXTRACTED_14_OPT_OPT = Optional.of(Optional.of(1));
            for (int j = EXTRACTED_14_OPT_OPT.get().get(); j <= alunos_OPT_OPT.get().get(); j++) {
                Optional<Optional<Integer>> cod_OPT_OPT = Optional.of(Optional.of(kb_OPT_OPT.get().get().nextInt()));
                Optional<Aluno> EXTRACTED_13_OPT = Optional.of(new Aluno(j));
                lista_OPT_OPT.get().get()[j] = EXTRACTED_13_OPT.get();
                Optional<Integer> amigos_OPT = Optional.of(kb_OPT_OPT.get().get().nextInt());
                Optional<Integer> EXTRACTED_24_OPT = Optional.of(0);
                Optional<Optional<Integer>> EXTRACTED_15_OPT_OPT = Optional.of(Optional.of(EXTRACTED_24_OPT.get()));
                for (int z = EXTRACTED_15_OPT_OPT.get().get(); z < amigos_OPT.get(); z++) {
                    Optional<Optional<Integer>> am_OPT_OPT = Optional.of(Optional.of(kb_OPT_OPT.get().get().nextInt()));
                    Optional<boolean[]> EXTRACTED_14_OPT = Optional.of(matr_OPT_OPT.get().get()[cod_OPT_OPT.get().get()]);
                    Optional<Optional<boolean[]>> EXTRACTED_23_OPT_OPT = Optional.of(Optional.of(EXTRACTED_14_OPT.get()));
                    Optional<Boolean> EXTRACTED_15_OPT = Optional.of(true);
                    EXTRACTED_23_OPT_OPT.get().get()[am_OPT_OPT.get().get()] = EXTRACTED_15_OPT.get();
                }
            }
            Optional<Optional<Integer>> lug_OPT_OPT = Optional.of(Optional.of(1));
            Optional<Optional<Integer>> EXTRACTED_16_OPT_OPT = Optional.of(Optional.of(1));
            for (int j = EXTRACTED_16_OPT_OPT.get().get(); j <= alunos_OPT_OPT.get().get(); j++) {
                Aluno EXTRACTED_16 = lista_OPT_OPT.get().get()[j];
                Optional<Optional<Aluno>> EXTRACTED_30_OPT_OPT = Optional.of(Optional.of(EXTRACTED_16));
                Optional<Boolean> EXTRACTED_17_OPT = Optional.of(!EXTRACTED_30_OPT_OPT.get().get().estado);
                Optional<Optional<Boolean>> EXTRACTED_17_OPT_OPT = Optional.of(Optional.of(EXTRACTED_17_OPT.get()));
                if (EXTRACTED_17_OPT_OPT.get().get()) {
                    lug_OPT_OPT = Optional.of(Optional.of(dfs(lista_OPT_OPT.get().get(), j, lug_OPT_OPT.get().get(), matr_OPT_OPT.get().get(), alunos_OPT_OPT.get().get())));
                }
            }
            int EXTRACTED_18 = 1;
            lug_OPT_OPT = Optional.of(Optional.of(EXTRACTED_18));
            Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
            Optional<Optional<Integer>> p_OPT_OPT = Optional.of(Optional.of(EXTRACTED_19_OPT.get()));
            int EXTRACTED_20 = 0;
            Optional<Integer> EXTRACTED_24_OPT = Optional.of(EXTRACTED_20);
            for (int j = alunos_OPT_OPT.get().get(); j > EXTRACTED_24_OPT.get(); j--) {
                Optional<Optional<Integer>> k_OPT_OPT = Optional.of(Optional.of(lugar(lista_OPT_OPT.get().get(), j, alunos_OPT_OPT.get().get())));
                Optional<Aluno> EXTRACTED_21_OPT = Optional.of(lista_OPT_OPT.get().get()[k_OPT_OPT.get().get()]);
                Optional<Optional<Aluno>> EXTRACTED_25_OPT_OPT = Optional.of(Optional.of(EXTRACTED_21_OPT.get()));
                if (EXTRACTED_25_OPT_OPT.get().get().estado) {
                    lug_OPT_OPT = Optional.of(Optional.of(dfsv(lista_OPT_OPT.get().get(), k_OPT_OPT.get().get(), lug_OPT_OPT.get().get(), matr_OPT_OPT.get().get(), alunos_OPT_OPT.get().get())));
                    int EXTRACTED_18 = lug_OPT_OPT.get().get() - p_OPT_OPT.get().get();
                    Optional<Boolean> EXTRACTED_22_OPT = Optional.of(EXTRACTED_18 > socioConstants.CONSTANT_4);
                    Optional<Optional<Boolean>> EXTRACTED_26_OPT_OPT = Optional.of(Optional.of(EXTRACTED_22_OPT.get()));
                    if (!EXTRACTED_26_OPT_OPT.get().get()) {
                        int EXTRACTED_25 = solos_OPT_OPT.get().get() + lug_OPT_OPT.get().get();
                        Optional<Optional<Integer>> EXTRACTED_20_OPT_OPT = Optional.of(Optional.of(EXTRACTED_25));
                        Optional<Integer> EXTRACTED_19_OPT = Optional.of(EXTRACTED_20_OPT_OPT.get().get() - p_OPT_OPT.get().get());
                        solos_OPT_OPT = Optional.of(Optional.of(EXTRACTED_19_OPT.get()));
                    } else
                        grupos++;

                    p_OPT_OPT = Optional.of(Optional.of(lug_OPT_OPT.get().get()));
                }
            }
            Optional<Optional<String>> EXTRACTED_21_OPT_OPT = Optional.of(Optional.of(socioConstants.CONSTANT_5 + i));
            System.out.println(EXTRACTED_21_OPT_OPT.get().get());
            Optional<String> EXTRACTED_29_OPT = Optional.of(socioConstants.CONSTANT_5);
            Optional<Optional<String>> EXTRACTED_28_OPT_OPT = Optional.of(Optional.of(grupos + EXTRACTED_29_OPT.get()));
            String EXTRACTED_27 = EXTRACTED_28_OPT_OPT.get().get() + solos_OPT_OPT.get().get();
            System.out.println(EXTRACTED_27);
        }
    }

    /**
     */
    public socio(boolean boolean0, boolean boolean1) {
        RuntimeException EXTRACTED_26 = new RuntimeException("You'd better not have called me!");
        throw EXTRACTED_26;
    }

    /**
     */
    public socio(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}