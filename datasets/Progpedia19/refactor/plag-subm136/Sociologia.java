import java.util.*;
class Graph {
    public final Integer DIM = 1000;

    LinkedList<Integer>[] adj = null;

    int[] color;

    int[] parent;

    int[] startTime;

    int[] finishTime;

    int time;

    @SuppressWarnings(GraphConstants.CONSTANT_1)
    Graph() {
        adj = new LinkedList[DIM];
        color = new int[DIM];
        parent = new int[DIM];
        Optional<int[]> EXTRACTED_1_OPT = Optional.of(new int[DIM]);
        startTime = EXTRACTED_1_OPT.get();
        finishTime = new int[DIM];
    }

    @SuppressWarnings("unchecked")
    Graph transpose() {
        Optional<Graph> transposed_OPT = Optional.of(new Graph());
        Graph EXTRACTED_3 = this;
        Optional<LinkedList<Integer>> EXTRACTED_2_OPT = Optional.of(EXTRACTED_3.adj[i]);
        for (int i = 0; EXTRACTED_2_OPT.get() != null; i++)
            transposed_OPT.get().adj[i] = GraphConstants.CONSTANT_2;

        Optional<Graph> EXTRACTED_4_OPT = Optional.of(this);
        for (int i = 0; EXTRACTED_4_OPT.get().adj[i] != null; i++) {
            LinkedList<Integer> EXTRACTED_6 = adj[i];
            Optional<Iterator<Integer>> it_OPT = Optional.of(EXTRACTED_6.iterator());
            while (it_OPT.get().hasNext()) {
                Optional<Integer> node_OPT = Optional.of(it_OPT.get().next());
                Optional<LinkedList<Integer>> EXTRACTED_5_OPT = Optional.of(transposed_OPT.get().adj[node_OPT.get()]);
                EXTRACTED_5_OPT.get().addLast(i);
            } 
        }
        return transposed_OPT.get();
    }

    @SuppressWarnings("unchecked")
    void depthFirstSearch(LinkedList<Integer> fst, LinkedList<Integer> snd) {
        Arrays.fill(color, 0);
        Arrays.fill(parent, GraphConstants.CONSTANT_3);
        Arrays.fill(startTime, -1);
        int EXTRACTED_7 = -1;
        Arrays.fill(finishTime, EXTRACTED_7);
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
        time = EXTRACTED_8_OPT.get();
        Iterator<Integer> it = fst.iterator();
        while (it.hasNext()) {
            Optional<Integer> source_OPT = Optional.of(it.next());
            int EXTRACTED_9 = color[source_OPT.get()];
            Optional<Integer> EXTRACTED_10_OPT = Optional.of(0);
            boolean EXTRACTED_11 = EXTRACTED_9 == EXTRACTED_10_OPT.get();
            if (EXTRACTED_11)
                depthFirstVisit(source_OPT.get(), snd);

        } 
    }

    @SuppressWarnings("unchecked")
    void depthFirstVisit(int source, LinkedList<Integer> snd) {
        int EXTRACTED_12 = 1;
        color[source] = EXTRACTED_12;
        time += 1;
        startTime[source] = time;
        Optional<LinkedList<Integer>> EXTRACTED_13_OPT = Optional.of(adj[source]);
        Iterator<Integer> it = EXTRACTED_13_OPT.get().iterator();
        while (it.hasNext()) {
            Optional<Integer> node_OPT = Optional.of(it.next());
            Optional<Integer> EXTRACTED_15_OPT = Optional.of(color[node_OPT.get()]);
            Optional<Integer> EXTRACTED_16_OPT = Optional.of(0);
            boolean EXTRACTED_14 = EXTRACTED_15_OPT.get() == EXTRACTED_16_OPT.get();
            if (EXTRACTED_14) {
                parent[node_OPT.get()] = source;
                depthFirstVisit(node_OPT.get(), snd);
            }
        } 
        color[source] = GraphConstants.CONSTANT_4;
        time += 1;
        finishTime[source] = time;
        snd.addFirst(source);
    }

    public int Graph_callMe_not(Object object0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    @SuppressWarnings("unchecked")
    PriorityQueue<Integer> findValues(int value, int[] vtr) {
        PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
        for (int i = 0; adj[i] != null; i++) {
            boolean EXTRACTED_17 = vtr[i] == value;
            if (EXTRACTED_17)
                fila.add(i);

        }
        return fila;
    }

    @SuppressWarnings("unchecked")
    void makeTree(LinkedList<Integer> tree, int value) {
        boolean EXTRACTED_18 = value != (-1);
        if (EXTRACTED_18)
            tree.add(value);

        Optional<PriorityQueue<Integer>> fila_OPT = Optional.of(new PriorityQueue<Integer>());
        fila_OPT = Optional.of(findValues(value, parent));
        while (!fila_OPT.get().isEmpty()) {
            Optional<Integer> newValue_OPT = Optional.of(fila_OPT.get().remove());
            makeTree(tree, newValue_OPT.get());
        } 
    }

    @SuppressWarnings("unchecked")
    LinkedList<Integer>[] buildTreeForest() {
        Optional<LinkedList<Integer>[]> tree_OPT = Optional.of(((LinkedList<Integer>[]) (new LinkedList[DIM])));
        Optional<Integer> EXTRACTED_19_OPT = Optional.of(0);
        Optional<LinkedList<Integer>> EXTRACTED_20_OPT = Optional.of(adj[i]);
        for (int i = EXTRACTED_19_OPT.get(); EXTRACTED_20_OPT.get() != null; i++) {
            Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
            Optional<Integer> EXTRACTED_21_OPT = Optional.of(-EXTRACTED_22_OPT.get());
            if (parent[i] == EXTRACTED_21_OPT.get()) {
                int aux = 0;
                Optional<Integer> EXTRACTED_23_OPT = Optional.of(0);
                Optional<LinkedList<Integer>> EXTRACTED_24_OPT = Optional.of(tree_OPT.get()[j]);
                for (int j = EXTRACTED_23_OPT.get(); EXTRACTED_24_OPT.get() != null; j++)
                    aux++;

                LinkedList<Integer> EXTRACTED_25 = new LinkedList<Integer>();
                tree_OPT.get()[aux] = EXTRACTED_25;
                Optional<LinkedList<Integer>> EXTRACTED_26_OPT = Optional.of(tree_OPT.get()[aux]);
                makeTree(EXTRACTED_26_OPT.get(), i);
            }
        }
        return tree_OPT.get();
    }

    /**
     */
    public Graph() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Sociologia {
    public Sociologia() {
    }

    @SuppressWarnings(SociologiaConstants.CONSTANT_6)
    public static void main(String[] args) {
        Optional<Scanner> inp_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> nCenarios_OPT = Optional.of(inp_OPT.get().nextInt());
        Optional<Integer> EXTRACTED_27_OPT = Optional.of(0);
        for (int i = EXTRACTED_27_OPT.get(); i < nCenarios_OPT.get(); i++) {
            Optional<LinkedList<Integer>> fst_OPT = Optional.of(new LinkedList<Integer>());
            Optional<LinkedList<Integer>> snd_OPT = Optional.of(new LinkedList<Integer>());
            Optional<Graph> sociologia_OPT = Optional.of(new Graph());
            Optional<Integer> nAlunos_OPT = Optional.of(inp_OPT.get().nextInt());
            for (int j = 0; j < nAlunos_OPT.get(); j++) {
                Optional<LinkedList<Integer>> EXTRACTED_39_OPT = Optional.of(new LinkedList<Integer>());
                sociologia_OPT.get().adj[j] = EXTRACTED_39_OPT.get();
                fst_OPT.get().addLast(j);
            }
            Optional<Integer> EXTRACTED_28_OPT = Optional.of(0);
            for (int j = EXTRACTED_28_OPT.get(); j < nAlunos_OPT.get(); j++) {
                Optional<Integer> aluno_OPT = Optional.of(inp_OPT.get().nextInt());
                int nAmigos = inp_OPT.get().nextInt();
                int EXTRACTED_29 = 0;
                for (int k = EXTRACTED_29; k < nAmigos; k++) {
                    LinkedList<Integer> EXTRACTED_30 = sociologia_OPT.get().adj[aluno_OPT.get() - SociologiaConstants.CONSTANT_7];
                    Optional<Integer> EXTRACTED_40_OPT = Optional.of(1);
                    int EXTRACTED_31 = inp_OPT.get().nextInt() - EXTRACTED_40_OPT.get();
                    EXTRACTED_30.addLast(EXTRACTED_31);
                }
            }
            sociologia_OPT.get().depthFirstSearch(fst_OPT.get(), snd_OPT.get());
            Graph sociologiaT = sociologia_OPT.get().transpose();
            Optional<LinkedList<Integer>> EXTRACTED_32_OPT = Optional.of(new LinkedList<Integer>());
            fst_OPT = Optional.of(EXTRACTED_32_OPT.get());
            sociologiaT.depthFirstSearch(snd_OPT.get(), fst_OPT.get());
            Optional<LinkedList<Integer>[]> groups_OPT = Optional.of(sociologiaT.buildTreeForest());
            int count = 0;
            Optional<Integer> nGroups_OPT = Optional.of(0);
            int nElemOut = 0;
            int EXTRACTED_34 = 1;
            int EXTRACTED_33 = i + EXTRACTED_34;
            System.out.printf(SociologiaConstants.CONSTANT_8, EXTRACTED_33);
            Optional<Integer> EXTRACTED_35_OPT = Optional.of(0);
            Optional<LinkedList<Integer>> EXTRACTED_36_OPT = Optional.of(groups_OPT.get()[j]);
            for (int j = EXTRACTED_35_OPT.get(); EXTRACTED_36_OPT.get() != null; j++) {
                LinkedList<Integer> EXTRACTED_37 = groups_OPT.get()[j];
                Iterator<Integer> it = EXTRACTED_37.iterator();
                while (it.hasNext()) {
                    count++;
                    it.next();
                } 
                if (!(count >= SociologiaConstants.CONSTANT_9)) {
                    nElemOut += count;
                } else {
                    Optional<Integer> EXTRACTED_38_OPT = Optional.of(1);
                    nGroups_OPT = Optional.of(EXTRACTED_38_OPT.get());
                }
                Optional<Integer> EXTRACTED_41_OPT = Optional.of(0);
                count = EXTRACTED_41_OPT.get();
            }
            System.out.printf(SociologiaConstants.CONSTANT_10, nGroups_OPT.get(), nElemOut);
        }
    }

    public boolean Sociologia_callMe_not() {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public Sociologia(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}