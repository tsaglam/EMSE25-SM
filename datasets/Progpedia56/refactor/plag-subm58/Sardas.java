import java.util.*;
class Node implements Comparable<Node> {
    int number;

    boolean visited;

    float distance;

    Node parent;

    int chosen;

    public Object Node_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    float chosenValue;

    float posx;

    float posy;

    Node(boolean visited, int number, float distance, Node parent, int chosen, float chosenValue, float posx, float posy) {
        this.number = number;
        this.visited = visited;
        this.distance = distance;
        this.parent = parent;
        this.chosen = chosen;
        Optional<Node> EXTRACTED_1_OPT = Optional.of(this);
        EXTRACTED_1_OPT.get().chosenValue = chosenValue;
        this.posx = posx;
        Optional<Node> EXTRACTED_2_OPT = Optional.of(this);
        EXTRACTED_2_OPT.get().posy = posy;
    }

    @Override
    public int compareTo(Node x) {
        Optional<Node> EXTRACTED_4_OPT = Optional.of(this);
        Optional<Boolean> EXTRACTED_3_OPT = Optional.of(EXTRACTED_4_OPT.get().distance < x.distance);
        if (!EXTRACTED_3_OPT.get()) {
            Optional<Boolean> EXTRACTED_6_OPT = Optional.of(this.distance > x.distance);
            if (!EXTRACTED_6_OPT.get()) {
                Optional<Node> EXTRACTED_9_OPT = Optional.of(this);
                Optional<Boolean> EXTRACTED_8_OPT = Optional.of(EXTRACTED_9_OPT.get().number < x.number);
                if (!EXTRACTED_8_OPT.get()) {
                    Node EXTRACTED_10 = this;
                    boolean EXTRACTED_13 = EXTRACTED_10.number > x.number;
                    if (!EXTRACTED_13) {
                        return NodeConstants.CONSTANT_1;
                    } else {
                        Optional<Integer> EXTRACTED_11_OPT = Optional.of(1);
                        return EXTRACTED_11_OPT.get();
                    }
                } else {
                    Optional<Integer> EXTRACTED_12_OPT = Optional.of(-1);
                    return EXTRACTED_12_OPT.get();
                }
            } else {
                Optional<Integer> EXTRACTED_7_OPT = Optional.of(1);
                return EXTRACTED_7_OPT.get();
            }
        } else {
            Optional<Integer> EXTRACTED_5_OPT = Optional.of(1);
            return -EXTRACTED_5_OPT.get();
        }
    }

    /**
     */
    public Node() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Sardas {
    public Sardas() {
    }

    static Node[] array;

    static float[][] connected;

    public double Sardas_callMe_not(int int0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static LinkedList<Node> list;

    static int Nnodes;

    static double total;

    public static void prim(Node nod) {
        total = SardasConstants.CONSTANT_2;
        Optional<Integer> flag_OPT = Optional.of(0);
        for (int i = 0; i < Nnodes; i++) {
            Optional<Node> EXTRACTED_31_OPT = Optional.of(array[i]);
            EXTRACTED_31_OPT.get().distance = SardasConstants.CONSTANT_3;
            Optional<Node> EXTRACTED_14_OPT = Optional.of(array[i]);
            EXTRACTED_14_OPT.get().parent = null;
        }
        Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
        nod.distance = EXTRACTED_15_OPT.get();
        Optional<PriorityQueue<Node>> heap_OPT = Optional.of(new PriorityQueue<Node>());
        for (int i = 0; i < Nnodes; i++) {
            Optional<Node> EXTRACTED_16_OPT = Optional.of(array[i]);
            heap_OPT.get().add(EXTRACTED_16_OPT.get());
        }
        while (!heap_OPT.get().isEmpty()) {
            Optional<Node> u_OPT = Optional.of(heap_OPT.get().remove());
            Optional<Boolean> EXTRACTED_17_OPT = Optional.of(flag_OPT.get() == SardasConstants.CONSTANT_4);
            if (EXTRACTED_17_OPT.get()) {
                total = total + u_OPT.get().chosenValue;
            }
            flag_OPT = Optional.of(1);
            int EXTRACTED_32 = 0;
            for (int j = EXTRACTED_32; j < Nnodes; j++) {
                Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_19_OPT = Optional.of(u_OPT.get().number - EXTRACTED_20_OPT.get());
                Optional<float[]> EXTRACTED_33_OPT = Optional.of(connected[EXTRACTED_19_OPT.get()]);
                Optional<Float> EXTRACTED_18_OPT = Optional.of(EXTRACTED_33_OPT.get()[j]);
                Optional<Integer> EXTRACTED_21_OPT = Optional.of(0);
                if (EXTRACTED_18_OPT.get() != EXTRACTED_21_OPT.get()) {
                    Node EXTRACTED_43 = array[j];
                    Optional<Boolean> EXTRACTED_22_OPT = Optional.of(heap_OPT.get().contains(EXTRACTED_43) == SardasConstants.CONSTANT_5);
                    Node EXTRACTED_23 = array[j];
                    int EXTRACTED_36 = 1;
                    int EXTRACTED_35 = u_OPT.get().number - EXTRACTED_36;
                    Optional<float[]> EXTRACTED_45_OPT = Optional.of(connected[EXTRACTED_35]);
                    Optional<Float> EXTRACTED_44_OPT = Optional.of(EXTRACTED_45_OPT.get()[j]);
                    Optional<Boolean> EXTRACTED_34_OPT = Optional.of(EXTRACTED_22_OPT.get() && (EXTRACTED_44_OPT.get() < EXTRACTED_23.distance));
                    if (EXTRACTED_34_OPT.get()) {
                        Optional<Integer> EXTRACTED_39_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_38_OPT = Optional.of(u_OPT.get().number - EXTRACTED_39_OPT.get());
                        Node EXTRACTED_24 = array[EXTRACTED_38_OPT.get()];
                        Optional<Node> EXTRACTED_37_OPT = Optional.of(array[j]);
                        EXTRACTED_37_OPT.get().parent = EXTRACTED_24;
                        Node EXTRACTED_25 = array[j];
                        Optional<Integer> EXTRACTED_40_OPT = Optional.of(1);
                        int EXTRACTED_27 = u_OPT.get().number - EXTRACTED_40_OPT.get();
                        Optional<float[]> EXTRACTED_26_OPT = Optional.of(connected[EXTRACTED_27]);
                        EXTRACTED_25.distance = EXTRACTED_26_OPT.get()[j];
                        Optional<Node> EXTRACTED_28_OPT = Optional.of(array[j]);
                        heap_OPT.get().remove(EXTRACTED_28_OPT.get());
                        Optional<Node> EXTRACTED_29_OPT = Optional.of(array[j]);
                        heap_OPT.get().add(EXTRACTED_29_OPT.get());
                        Optional<Node> EXTRACTED_46_OPT = Optional.of(array[j]);
                        EXTRACTED_46_OPT.get().chosen = u_OPT.get().number;
                        Optional<Integer> EXTRACTED_47_OPT = Optional.of(1);
                        int EXTRACTED_42 = u_OPT.get().number - EXTRACTED_47_OPT.get();
                        Optional<float[]> EXTRACTED_30_OPT = Optional.of(connected[EXTRACTED_42]);
                        Optional<Float> EXTRACTED_41_OPT = Optional.of(EXTRACTED_30_OPT.get()[j]);
                        array[j].chosenValue = EXTRACTED_41_OPT.get();
                    }
                }
            }
        } 
    }

    public static void main(String[] args) {
        Optional<Scanner> hello_OPT = Optional.of(new Scanner(System.in));
        Nnodes = hello_OPT.get().nextInt();
        connected = new float[Nnodes][Nnodes];
        Optional<Node[]> EXTRACTED_48_OPT = Optional.of(new Node[Nnodes]);
        array = EXTRACTED_48_OPT.get();
        for (int i = 0; i < Nnodes; i++) {
            Optional<Integer> EXTRACTED_49_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_50_OPT = Optional.of(0);
            Optional<Integer> EXTRACTED_57_OPT = Optional.of(i + EXTRACTED_49_OPT.get());
            int EXTRACTED_58 = 0;
            array[i] = new Node(false, EXTRACTED_57_OPT.get(), SardasConstants.CONSTANT_6, null, 0, 0, EXTRACTED_50_OPT.get(), EXTRACTED_58);
        }
        for (int i = 0; i < Nnodes; i++) {
            Optional<Float> x_OPT = Optional.of(hello_OPT.get().nextFloat());
            Optional<Float> y_OPT = Optional.of(hello_OPT.get().nextFloat());
            Optional<Node> EXTRACTED_51_OPT = Optional.of(array[i]);
            EXTRACTED_51_OPT.get().posx = x_OPT.get();
            Optional<Node> EXTRACTED_52_OPT = Optional.of(array[i]);
            EXTRACTED_52_OPT.get().posy = y_OPT.get();
        }
        int EXTRACTED_53 = 0;
        for (int i = EXTRACTED_53; i < Nnodes; i++) {
            float x1 = array[i].posx;
            Optional<Node> EXTRACTED_59_OPT = Optional.of(array[i]);
            Optional<Float> y1_OPT = Optional.of(EXTRACTED_59_OPT.get().posy);
            for (int j = 0; j < Nnodes; j++) {
                Node EXTRACTED_60 = array[j];
                Optional<Float> x2_OPT = Optional.of(EXTRACTED_60.posx);
                Node EXTRACTED_54 = array[j];
                Optional<Float> y2_OPT = Optional.of(EXTRACTED_54.posy);
                Optional<Integer> EXTRACTED_56_OPT = Optional.of(2);
                float EXTRACTED_61 = y1_OPT.get() - y2_OPT.get();
                Optional<Double> EXTRACTED_55_OPT = Optional.of(Math.pow(Math.abs(x1 - x2_OPT.get()), SardasConstants.CONSTANT_7) + Math.pow(Math.abs(EXTRACTED_61), EXTRACTED_56_OPT.get()));
                connected[i][j] = ((float) (Math.sqrt(EXTRACTED_55_OPT.get())));
            }
        }
        prim(array[0]);
        System.out.printf(SardasConstants.CONSTANT_8, total);
    }

    /**
     */
    public Sardas(float float0, int int1) {
        throw new RuntimeException("You'd better not have called me!");
    }
}