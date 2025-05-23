import java.util.*;
class Parte3_2 {
    public int Parte3_2_callMe_not(Object object0, float float1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public Parte3_2() {
    }

    static PriorityQueue<Node> list = new PriorityQueue<Node>();

    static LinkedList<Node> aux = new LinkedList<Node>();

    static float dist = 0;

    public static void main(String[] args) {
        Optional<Scanner> input_OPT = Optional.of(new Scanner(System.in));
        input_OPT.get().useLocale(Locale.US);
        Optional<Integer> n_OPT = Optional.of(input_OPT.get().nextInt());
        int EXTRACTED_1 = 0;
        for (int i = EXTRACTED_1; i < n_OPT.get(); i++) {
            Optional<Node> node_OPT = Optional.of(new Node(input_OPT.get().nextFloat(), input_OPT.get().nextFloat()));
            list.add(node_OPT.get());
            aux.add(node_OPT.get());
        }
        prim();
        System.out.format(Locale.ENGLISH, Parte3_2Constants.CONSTANT_1, dist);
        System.out.println();
    }

    public static void prim() {
        Optional<Boolean> first_OPT = Optional.of(true);
        Node node = null;
        Optional<Boolean> EXTRACTED_2_OPT = Optional.of(list.size() > 0);
        while (EXTRACTED_2_OPT.get()) {
            node = list.remove();
            aux.remove(node);
            Optional<Boolean> EXTRACTED_3_OPT = Optional.of(!first_OPT.get());
            if (!EXTRACTED_3_OPT.get()) {
                first_OPT = Optional.of(Parte3_2Constants.CONSTANT_2);
            } else
                dist += node.dist;

            for (Node adjNode : aux) {
                Optional<Float> weight_OPT = Optional.of(returnWeight(node, adjNode));
                Optional<Boolean> EXTRACTED_4_OPT = Optional.of(weight_OPT.get() < adjNode.dist);
                if (EXTRACTED_4_OPT.get()) {
                    list.remove(adjNode);
                    adjNode.parent = node;
                    adjNode.dist = weight_OPT.get();
                    list.add(adjNode);
                }
            }
        } 
    }

    public static float returnWeight(Node node1, Node node2) {
        float EXTRACTED_6 = (node1.x - node2.x) * (node1.x - node2.x);
        Optional<Float> EXTRACTED_7_OPT = Optional.of((node1.y - node2.y) * (node1.y - node2.y));
        Optional<Float> EXTRACTED_5_OPT = Optional.of(EXTRACTED_6 + EXTRACTED_7_OPT.get());
        return ((float) (Math.sqrt(EXTRACTED_5_OPT.get())));
    }

    /**
     */
    public Parte3_2() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Node implements Comparable<Node> {
    float dist = Float.MAX_VALUE;

    Node parent = null;

    public float x;

    public float y;

    Node(float x, float y) {
        Optional<Node> EXTRACTED_8_OPT = Optional.of(this);
        EXTRACTED_8_OPT.get().x = x;
        Node EXTRACTED_9 = this;
        EXTRACTED_9.y = y;
    }

    public float Node_callMe_not(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public int compareTo(Node n) {
        Optional<Boolean> EXTRACTED_10_OPT = Optional.of(dist < n.dist);
        if (!EXTRACTED_10_OPT.get()) {
            boolean EXTRACTED_11 = dist > n.dist;
            if (!EXTRACTED_11) {
                return NodeConstants.CONSTANT_4;
            } else {
                Optional<Integer> EXTRACTED_12_OPT = Optional.of(1);
                return EXTRACTED_12_OPT.get();
            }
        } else
            return NodeConstants.CONSTANT_3;

    }

    /**
     */
    public Node(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}