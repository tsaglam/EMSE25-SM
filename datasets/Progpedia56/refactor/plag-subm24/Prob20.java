import java.util.*;
class Node3 {
    public boolean visited;

    public int Node3_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int distance;

    Node3() {
        visited = Node3Constants.CONSTANT_1;
        distance = Node3Constants.CONSTANT_2;
    }

    /**
     */
    public Node3(Object object0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}public class Prob20 {
    public Prob20() {
    }

    static int c;

    static int l;

    public float Prob20_callMe_not(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static String linha;

    static char[][] matriz;

    static Node3[][] nodes;

    static int distMax = -1;

    static int distMin;

    static void bfs() {
        Optional<LinkedList<Integer>> x_OPT = Optional.of(new LinkedList<Integer>());
        Optional<LinkedList<Integer>> y_OPT = Optional.of(new LinkedList<Integer>());
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        for (int i = EXTRACTED_1_OPT.get(); i < l; i++) {
            int EXTRACTED_2 = 0;
            for (int j = EXTRACTED_2; j < c; j++) {
                char[] EXTRACTED_3 = matriz[i];
                Optional<Character> EXTRACTED_48_OPT = Optional.of(EXTRACTED_3[j]);
                boolean EXTRACTED_45 = EXTRACTED_48_OPT.get() != Prob20Constants.CONSTANT_3;
                if (EXTRACTED_45) {
                    x_OPT.get().add(i);
                    y_OPT.get().add(j);
                    Optional<Node3[]> EXTRACTED_4_OPT = Optional.of(nodes[i]);
                    Optional<Node3> EXTRACTED_46_OPT = Optional.of(EXTRACTED_4_OPT.get()[j]);
                    EXTRACTED_46_OPT.get().visited = Prob20Constants.CONSTANT_4;
                    Optional<Integer> EXTRACTED_47_OPT = Optional.of(0);
                    Node3[] EXTRACTED_49 = nodes[i];
                    Node3 EXTRACTED_50 = EXTRACTED_49[j];
                    EXTRACTED_50.distance = EXTRACTED_47_OPT.get();
                }
            }
        }
        Optional<Integer> EXTRACTED_6_OPT = Optional.of(0);
        boolean EXTRACTED_5 = x_OPT.get().size() > EXTRACTED_6_OPT.get();
        while (EXTRACTED_5) {
            Optional<Integer> u_OPT = Optional.of(x_OPT.get().removeFirst());
            Optional<Integer> v_OPT = Optional.of(y_OPT.get().removeFirst());
            Optional<Integer> EXTRACTED_7_OPT = Optional.of(c - 1);
            if (v_OPT.get() < EXTRACTED_7_OPT.get()) {
                Optional<Integer> EXTRACTED_11_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_10_OPT = Optional.of(v_OPT.get() + EXTRACTED_11_OPT.get());
                Node3 EXTRACTED_9 = nodes[u_OPT.get()][EXTRACTED_10_OPT.get()];
                Optional<Boolean> EXTRACTED_8_OPT = Optional.of(!EXTRACTED_9.visited);
                if (EXTRACTED_8_OPT.get()) {
                    x_OPT.get().add(u_OPT.get());
                    int EXTRACTED_51 = v_OPT.get() + 1;
                    y_OPT.get().add(EXTRACTED_51);
                    Optional<Node3[]> EXTRACTED_12_OPT = Optional.of(nodes[u_OPT.get()]);
                    Optional<Integer> EXTRACTED_13_OPT = Optional.of(1);
                    int EXTRACTED_52 = v_OPT.get() + EXTRACTED_13_OPT.get();
                    Optional<Node3> EXTRACTED_71_OPT = Optional.of(EXTRACTED_12_OPT.get()[EXTRACTED_52]);
                    EXTRACTED_71_OPT.get().visited = true;
                    Optional<Node3[]> EXTRACTED_16_OPT = Optional.of(nodes[u_OPT.get()]);
                    Node3 EXTRACTED_15 = EXTRACTED_16_OPT.get()[v_OPT.get()];
                    Optional<Integer> EXTRACTED_55_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_14_OPT = Optional.of(EXTRACTED_15.distance + EXTRACTED_55_OPT.get());
                    int EXTRACTED_54 = 1;
                    Optional<Integer> EXTRACTED_53_OPT = Optional.of(v_OPT.get() + EXTRACTED_54);
                    Optional<Node3[]> EXTRACTED_72_OPT = Optional.of(nodes[u_OPT.get()]);
                    EXTRACTED_72_OPT.get()[EXTRACTED_53_OPT.get()].distance = EXTRACTED_14_OPT.get();
                }
            }
            int EXTRACTED_56 = 0;
            if (v_OPT.get() > EXTRACTED_56) {
                Node3[] EXTRACTED_17 = nodes[u_OPT.get()];
                Optional<Integer> EXTRACTED_73_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_18_OPT = Optional.of(v_OPT.get() - EXTRACTED_73_OPT.get());
                Optional<Node3> EXTRACTED_57_OPT = Optional.of(EXTRACTED_17[EXTRACTED_18_OPT.get()]);
                if (!EXTRACTED_57_OPT.get().visited) {
                    x_OPT.get().add(u_OPT.get());
                    Optional<Integer> EXTRACTED_19_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_74_OPT = Optional.of(v_OPT.get() - EXTRACTED_19_OPT.get());
                    y_OPT.get().add(EXTRACTED_74_OPT.get());
                    Optional<Node3[]> EXTRACTED_20_OPT = Optional.of(nodes[u_OPT.get()]);
                    Optional<Integer> EXTRACTED_75_OPT = Optional.of(1);
                    int EXTRACTED_21 = v_OPT.get() - EXTRACTED_75_OPT.get();
                    Optional<Node3> EXTRACTED_58_OPT = Optional.of(EXTRACTED_20_OPT.get()[EXTRACTED_21]);
                    Optional<Boolean> EXTRACTED_59_OPT = Optional.of(true);
                    EXTRACTED_58_OPT.get().visited = EXTRACTED_59_OPT.get();
                    Optional<Integer> EXTRACTED_60_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_22_OPT = Optional.of(v_OPT.get() - EXTRACTED_60_OPT.get());
                    Optional<Node3[]> EXTRACTED_24_OPT = Optional.of(nodes[u_OPT.get()]);
                    Optional<Integer> EXTRACTED_78_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_23_OPT = Optional.of(EXTRACTED_24_OPT.get()[v_OPT.get()].distance + EXTRACTED_78_OPT.get());
                    Optional<Node3[]> EXTRACTED_77_OPT = Optional.of(nodes[u_OPT.get()]);
                    Optional<Node3> EXTRACTED_76_OPT = Optional.of(EXTRACTED_77_OPT.get()[EXTRACTED_22_OPT.get()]);
                    EXTRACTED_76_OPT.get().distance = EXTRACTED_23_OPT.get();
                }
            }
            int EXTRACTED_26 = 1;
            boolean EXTRACTED_25 = u_OPT.get() < (l - EXTRACTED_26);
            if (EXTRACTED_25) {
                Optional<Integer> EXTRACTED_28_OPT = Optional.of(1);
                int EXTRACTED_79 = u_OPT.get() + EXTRACTED_28_OPT.get();
                Node3[] EXTRACTED_27 = nodes[EXTRACTED_79];
                Optional<Node3> EXTRACTED_62_OPT = Optional.of(EXTRACTED_27[v_OPT.get()]);
                Optional<Boolean> EXTRACTED_61_OPT = Optional.of(!EXTRACTED_62_OPT.get().visited);
                if (EXTRACTED_61_OPT.get()) {
                    Optional<Integer> EXTRACTED_29_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_63_OPT = Optional.of(u_OPT.get() + EXTRACTED_29_OPT.get());
                    x_OPT.get().add(EXTRACTED_63_OPT.get());
                    y_OPT.get().add(v_OPT.get());
                    Optional<Integer> EXTRACTED_64_OPT = Optional.of(1);
                    int EXTRACTED_31 = u_OPT.get() + EXTRACTED_64_OPT.get();
                    Optional<Node3[]> EXTRACTED_30_OPT = Optional.of(nodes[EXTRACTED_31]);
                    Optional<Node3> EXTRACTED_80_OPT = Optional.of(EXTRACTED_30_OPT.get()[v_OPT.get()]);
                    Optional<Boolean> EXTRACTED_82_OPT = Optional.of(true);
                    EXTRACTED_80_OPT.get().visited = EXTRACTED_82_OPT.get();
                    Optional<Integer> EXTRACTED_81_OPT = Optional.of(1);
                    Node3[] EXTRACTED_32 = nodes[u_OPT.get() + EXTRACTED_81_OPT.get()];
                    int EXTRACTED_34 = 1;
                    Optional<Node3[]> EXTRACTED_65_OPT = Optional.of(nodes[u_OPT.get()]);
                    int EXTRACTED_33 = EXTRACTED_65_OPT.get()[v_OPT.get()].distance + EXTRACTED_34;
                    Optional<Node3> EXTRACTED_83_OPT = Optional.of(EXTRACTED_32[v_OPT.get()]);
                    EXTRACTED_83_OPT.get().distance = EXTRACTED_33;
                }
            }
            Optional<Integer> EXTRACTED_66_OPT = Optional.of(0);
            boolean EXTRACTED_35 = u_OPT.get() > EXTRACTED_66_OPT.get();
            if (EXTRACTED_35) {
                int EXTRACTED_67 = 1;
                Optional<Node3> EXTRACTED_37_OPT = Optional.of(nodes[u_OPT.get() - EXTRACTED_67][v_OPT.get()]);
                boolean EXTRACTED_36 = !EXTRACTED_37_OPT.get().visited;
                if (EXTRACTED_36) {
                    Optional<Integer> EXTRACTED_38_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_84_OPT = Optional.of(u_OPT.get() - EXTRACTED_38_OPT.get());
                    x_OPT.get().add(EXTRACTED_84_OPT.get());
                    y_OPT.get().add(v_OPT.get());
                    Optional<Integer> EXTRACTED_40_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_39_OPT = Optional.of(u_OPT.get() - EXTRACTED_40_OPT.get());
                    Optional<Boolean> EXTRACTED_41_OPT = Optional.of(true);
                    Optional<Node3> EXTRACTED_68_OPT = Optional.of(nodes[EXTRACTED_39_OPT.get()][v_OPT.get()]);
                    EXTRACTED_68_OPT.get().visited = EXTRACTED_41_OPT.get();
                    Optional<Integer> EXTRACTED_85_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_69_OPT = Optional.of(u_OPT.get() - EXTRACTED_85_OPT.get());
                    Optional<Node3[]> EXTRACTED_86_OPT = Optional.of(nodes[EXTRACTED_69_OPT.get()]);
                    Optional<Node3> EXTRACTED_42_OPT = Optional.of(EXTRACTED_86_OPT.get()[v_OPT.get()]);
                    Optional<Node3[]> EXTRACTED_44_OPT = Optional.of(nodes[u_OPT.get()]);
                    Optional<Node3> EXTRACTED_43_OPT = Optional.of(EXTRACTED_44_OPT.get()[v_OPT.get()]);
                    Optional<Integer> EXTRACTED_70_OPT = Optional.of(1);
                    Optional<Integer> EXTRACTED_87_OPT = Optional.of(EXTRACTED_43_OPT.get().distance + EXTRACTED_70_OPT.get());
                    EXTRACTED_42_OPT.get().distance = EXTRACTED_87_OPT.get();
                }
            }
        } 
    }

    public static void main(String[] args) {
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        l = stdin_OPT.get().nextInt();
        c = stdin_OPT.get().nextInt();
        linha = stdin_OPT.get().nextLine();
        matriz = new char[l][c];
        Optional<Integer> EXTRACTED_88_OPT = Optional.of(l + 1);
        nodes = new Node3[EXTRACTED_88_OPT.get()][c + 1];
        distMin = l * c;
        Optional<Integer> EXTRACTED_89_OPT = Optional.of(0);
        for (int i = EXTRACTED_89_OPT.get(); i < l; i++) {
            linha = stdin_OPT.get().nextLine();
            for (int j = 0; j < c; j++) {
                Optional<char[]> EXTRACTED_101_OPT = Optional.of(matriz[i]);
                EXTRACTED_101_OPT.get()[j] = linha.charAt(j);
            }
        }
        Optional<Integer> EXTRACTED_90_OPT = Optional.of(0);
        for (int i = EXTRACTED_90_OPT.get(); i < l; i++) {
            Optional<Integer> EXTRACTED_102_OPT = Optional.of(0);
            for (int j = EXTRACTED_102_OPT.get(); j < c; j++) {
                Optional<Node3[]> EXTRACTED_91_OPT = Optional.of(nodes[i]);
                EXTRACTED_91_OPT.get()[j] = Prob20Constants.CONSTANT_5;
            }
        }
        bfs();
        for (int i = 0; i < l; i++) {
            Optional<Integer> EXTRACTED_92_OPT = Optional.of(0);
            for (int j = EXTRACTED_92_OPT.get(); j < c; j++) {
                Optional<char[]> EXTRACTED_94_OPT = Optional.of(matriz[i]);
                Optional<Character> EXTRACTED_93_OPT = Optional.of(EXTRACTED_94_OPT.get()[j]);
                if (EXTRACTED_93_OPT.get() == Prob20Constants.CONSTANT_6) {
                    Optional<Node3[]> EXTRACTED_95_OPT = Optional.of(nodes[i]);
                    Optional<Node3> EXTRACTED_106_OPT = Optional.of(EXTRACTED_95_OPT.get()[j]);
                    if (EXTRACTED_106_OPT.get().distance > distMax) {
                        Optional<Node3[]> EXTRACTED_103_OPT = Optional.of(nodes[i]);
                        Optional<Node3> EXTRACTED_96_OPT = Optional.of(EXTRACTED_103_OPT.get()[j]);
                        distMax = EXTRACTED_96_OPT.get().distance;
                    }
                    Optional<Node3[]> EXTRACTED_98_OPT = Optional.of(nodes[i]);
                    Node3 EXTRACTED_104 = EXTRACTED_98_OPT.get()[j];
                    boolean EXTRACTED_97 = EXTRACTED_104.distance < distMin;
                    if (EXTRACTED_97) {
                        Optional<Node3[]> EXTRACTED_105_OPT = Optional.of(nodes[i]);
                        Optional<Node3> EXTRACTED_99_OPT = Optional.of(EXTRACTED_105_OPT.get()[j]);
                        distMin = EXTRACTED_99_OPT.get().distance;
                    }
                }
            }
        }
        Optional<String> EXTRACTED_100_OPT = Optional.of((distMin + Prob20Constants.CONSTANT_7) + distMax);
        System.out.println(EXTRACTED_100_OPT.get());
    }

    /**
     */
    public Prob20(long long0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}