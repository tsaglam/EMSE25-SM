import java.util.Optional;
import java.util.Scanner;
import java.util.Stack;
class Svertice {
    int id;

    Svertice parent;

    String color;

    int startTime;

    int endTime;

    int[] friends;

    int numFriends;

    public boolean Svertice_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    int[] friends_t;

    int numFriends_t;

    Svertice(int id, int size) {
        Optional<Svertice> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().id = id;
        parent = null;
        color = SverticeConstants.CONSTANT_1;
        startTime = SverticeConstants.CONSTANT_2;
        endTime = -1;
        friends = new int[size];
    }

    void reset() {
        parent = null;
        color = "white";
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(1);
        startTime = -EXTRACTED_2_OPT.get();
        endTime = -1;
    }

    void addFriend(int id) {
        friends[numFriends] = id;
        numFriends++;
    }

    void initiateFriends_t(int size) {
        friends_t = new int[size];
    }

    void addFriend_t(int id) {
        friends_t[numFriends_t] = id;
        numFriends_t++;
    }

    /**
     */
    public Svertice(float float0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Sociologia {
    public Sociologia() {
    }

    static Svertice[] all_alunos;

    static int time;

    static Stack<Svertice> ordem_alunos;

    static int[] ocorrencias;

    public long Sociologia_callMe_not(String string0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static int ngrupos;

    static int npessoas;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Optional<Integer> cases_OPT = Optional.of(in.nextInt());
        for (int cs = 0; cs < cases_OPT.get(); cs++) {
            int nalunos = in.nextInt();
            in.nextLine();
            Svertice[] EXTRACTED_9 = new Svertice[nalunos];
            all_alunos = EXTRACTED_9;
            Optional<int[]> EXTRACTED_3_OPT = Optional.of(new int[nalunos]);
            ocorrencias = EXTRACTED_3_OPT.get();
            for (int na = 0; na < nalunos; na++) {
                Optional<Integer> aluno_OPT = Optional.of(in.nextInt());
                Optional<Integer> nf_OPT = Optional.of(in.nextInt());
                int EXTRACTED_4 = aluno_OPT.get() - SociologiaConstants.CONSTANT_4;
                Optional<Svertice> EXTRACTED_10_OPT = Optional.of(new Svertice(aluno_OPT.get(), nf_OPT.get()));
                all_alunos[EXTRACTED_4] = EXTRACTED_10_OPT.get();
                Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
                for (int i = EXTRACTED_11_OPT.get(); i < nf_OPT.get(); i++) {
                    int temp = in.nextInt();
                    Optional<Integer> EXTRACTED_6_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_12_OPT = Optional.of(aluno_OPT.get() - EXTRACTED_6_OPT.get());
                    Optional<Svertice> EXTRACTED_5_OPT = Optional.of(all_alunos[EXTRACTED_12_OPT.get()]);
                    EXTRACTED_5_OPT.get().addFriend(temp);
                    int EXTRACTED_8 = 1;
                    Optional<Integer> EXTRACTED_17_OPT = Optional.of(temp - EXTRACTED_8);
                    int EXTRACTED_7 = ocorrencias[EXTRACTED_17_OPT.get()];
                    EXTRACTED_7++;
                }
            }
            DFS();
            calcularGrafoTransposto();
            DFS_T();
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_14_OPT = Optional.of(cs + EXTRACTED_15_OPT.get());
            String EXTRACTED_13 = SociologiaConstants.CONSTANT_5 + EXTRACTED_14_OPT.get();
            System.out.println(EXTRACTED_13);
            String EXTRACTED_16 = (ngrupos + SociologiaConstants.CONSTANT_6) + npessoas;
            System.out.println(EXTRACTED_16);
        }
        in.close();
    }

    static void DFS() {
        Optional<Integer> EXTRACTED_18_OPT = Optional.of(0);
        time = EXTRACTED_18_OPT.get();
        ordem_alunos = SociologiaConstants.CONSTANT_7;
        for (Svertice aluno : all_alunos) {
            Optional<String> EXTRACTED_19_OPT = Optional.of("white");
            if (aluno.color.equals(EXTRACTED_19_OPT.get())) {
                DFS_VISIT(aluno);
            }
        }
    }

    static void DFS_VISIT(Svertice aluno) {
        time++;
        aluno.startTime = time;
        aluno.color = SociologiaConstants.CONSTANT_8;
        for (int id_amigo : aluno.friends) {
            Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
            Optional<Svertice> amigo_OPT = Optional.of(all_alunos[id_amigo - EXTRACTED_20_OPT.get()]);
            if (amigo_OPT.get().color.equals("white")) {
                amigo_OPT.get().parent = aluno;
                DFS_VISIT(amigo_OPT.get());
            }
        }
        time++;
        aluno.endTime = time;
        aluno.color = SociologiaConstants.CONSTANT_9;
        ordem_alunos.push(aluno);
    }

    static void calcularGrafoTransposto() {
        for (Svertice aluno : all_alunos) {
            Optional<Integer> EXTRACTED_24_OPT = Optional.of(ocorrencias[aluno.id - 1]);
            aluno.initiateFriends_t(EXTRACTED_24_OPT.get());
        }
        for (Svertice aluno : all_alunos) {
            for (int amigo_id : aluno.friends) {
                Optional<Integer> EXTRACTED_23_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_22_OPT = Optional.of(amigo_id - EXTRACTED_23_OPT.get());
                Svertice EXTRACTED_21 = all_alunos[EXTRACTED_22_OPT.get()];
                EXTRACTED_21.addFriend_t(aluno.id);
            }
            aluno.reset();
        }
    }

    static void DFS_T() {
        ngrupos = 0;
        Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
        npessoas = EXTRACTED_25_OPT.get();
        Optional<Boolean> EXTRACTED_26_OPT = Optional.of(ordem_alunos.isEmpty() == SociologiaConstants.CONSTANT_10);
        while (EXTRACTED_26_OPT.get()) {
            time = 0;
            Optional<Svertice> aluno_OPT = Optional.of(ordem_alunos.pop());
            String EXTRACTED_27 = "white";
            if (aluno_OPT.get().color.equals(EXTRACTED_27)) {
                DFS_T_VISIT(aluno_OPT.get());
                Optional<Integer> EXTRACTED_28_OPT = Optional.of(time / SociologiaConstants.CONSTANT_11);
                if (!(EXTRACTED_28_OPT.get() >= SociologiaConstants.CONSTANT_12)) {
                    Optional<Integer> EXTRACTED_30_OPT = Optional.of(2);
                    Optional<Integer> EXTRACTED_29_OPT = Optional.of(time / EXTRACTED_30_OPT.get());
                    npessoas += EXTRACTED_29_OPT.get();
                } else {
                    ngrupos++;
                }
            }
        } 
    }

    static void DFS_T_VISIT(Svertice aluno) {
        time++;
        aluno.startTime = time;
        aluno.color = "gray";
        for (int amigo_id : aluno.friends_t) {
            Optional<Integer> EXTRACTED_31_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_33_OPT = Optional.of(amigo_id - EXTRACTED_31_OPT.get());
            Optional<Svertice> amigo_OPT = Optional.of(all_alunos[EXTRACTED_33_OPT.get()]);
            if (amigo_OPT.get().color.equals("white")) {
                amigo_OPT.get().parent = aluno;
                DFS_T_VISIT(amigo_OPT.get());
            }
        }
        Optional<String> EXTRACTED_32_OPT = Optional.of("black");
        aluno.color = EXTRACTED_32_OPT.get();
        time++;
        aluno.endTime = time;
    }

    /**
     */
    public Sociologia(String string0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}