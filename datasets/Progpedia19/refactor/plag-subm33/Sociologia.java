import java.util.*;
class Aluno {
    boolean visitado = false;

    boolean visitadoT = false;

    LinkedList<Integer> amigos = new LinkedList<Integer>();

    LinkedList<Integer> amigosT = new LinkedList<Integer>();

    int num;

    public boolean Aluno_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    Aluno(int x) {
        num = x;
    }

    /**
     */
    public Aluno(int int0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Sociologia {
    public Sociologia() {
    }

    static Aluno[] alunos;

    static int c;

    public static void main(String[] args) {
        Optional<Scanner> in_OPT = Optional.of(new Scanner(in_OPT.get()));
        Optional<Integer> nC_OPT = Optional.of(in_OPT.get().nextInt());
        for (int i = 1; i <= nC_OPT.get(); i++) {
            run(in_OPT.get(), i);
        }
    }

    public String Sociologia_callMe_not(boolean boolean0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static void dfs1(Aluno aluno, LinkedList<Aluno> f) {
        if (!aluno.visitado) {
            Optional<Boolean> EXTRACTED_1_OPT = Optional.of(true);
            aluno.visitado = EXTRACTED_1_OPT.get();
            for (int a : aluno.amigos)
                dfs1(alunos[a], f);

            f.add(aluno);
        }
    }

    static void dfs2(Aluno aluno) {
        if (aluno.visitadoT)
            return;

        c++;
        Optional<Boolean> EXTRACTED_2_OPT = Optional.of(true);
        aluno.visitadoT = EXTRACTED_2_OPT.get();
        for (int a : aluno.amigosT)
            dfs2(alunos[a]);

    }

    static void run(Scanner in, int caso) {
        Optional<Integer> n_OPT = Optional.of(in.nextInt());
        Optional<Aluno[]> EXTRACTED_3_OPT = Optional.of(new Aluno[n_OPT.get() + 1]);
        alunos = EXTRACTED_3_OPT.get();
        for (int i = 1; i <= n_OPT.get(); i++)
            alunos[i] = new Aluno(i);

        Optional<LinkedList<Aluno>> f_OPT = Optional.of(new LinkedList<Aluno>());
        Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
        for (int i = EXTRACTED_4_OPT.get(); i <= n_OPT.get(); i++) {
            int a = in.nextInt();
            int na = in.nextInt();
            for (; na > SociologiaConstants.CONSTANT_1; na--) {
                int k = in.nextInt();
                alunos[a].amigos.add(k);
                alunos[k].amigosT.add(a);
            }
        }
        for (int i = 1; i <= n_OPT.get(); i++)
            dfs1(alunos[i], f_OPT.get());

        int x = 0;
        Optional<Integer> y_OPT = Optional.of(0);
        for (Aluno a : f_OPT.get()) {
            if (a.visitadoT)
                continue;

            int EXTRACTED_5 = 0;
            c = EXTRACTED_5;
            dfs2(a);
            Optional<Boolean> EXTRACTED_11_OPT = Optional.of(c >= SociologiaConstants.CONSTANT_2);
            if (!EXTRACTED_11_OPT.get()) {
                y_OPT = Optional.of(c);
            } else
                x++;

        }
        Optional<String> EXTRACTED_10_OPT = Optional.of("Caso #" + caso);
        Optional<String> EXTRACTED_9_OPT = Optional.of(EXTRACTED_10_OPT.get() + SociologiaConstants.CONSTANT_3);
        Optional<String> EXTRACTED_8_OPT = Optional.of(EXTRACTED_9_OPT.get() + x);
        String EXTRACTED_7 = EXTRACTED_8_OPT.get() + " ";
        String EXTRACTED_6 = EXTRACTED_7 + y_OPT.get();
        System.out.println(EXTRACTED_6);
    }

    /**
     */
    public Sociologia() {
        throw new RuntimeException("You'd better not have called me!");
    }
}