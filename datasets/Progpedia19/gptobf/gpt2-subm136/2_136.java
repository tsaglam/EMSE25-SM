import java.util.*;

class Graph {
    private final int DIM = 1000;
    private List<List<Integer>> adj;
    private int[] color, parent, startTime, finishTime;
    private int time;

    Graph() {
        adj = new ArrayList<>(Collections.nCopies(DIM, null));
        color = new int[DIM];
        parent = new int[DIM];
        startTime = new int[DIM];
        finishTime = new int[DIM];
        Arrays.fill(parent, -1);
    }

    Graph transpose() {
        Graph transposed = new Graph();
        for (int i = 0; i < DIM && this.adj.get(i) != null; i++) {
            transposed.adj.set(i, new LinkedList<>());
        }
        for (int i = 0; i < DIM && this.adj.get(i) != null; i++) {
            for (int node : adj.get(i)) {
                transposed.adj.get(node).add(i);
            }
        }
        return transposed;
    }

    void depthFirstSearch(List<Integer> fst, List<Integer> snd) {
        Arrays.fill(color, 0);
        time = 0;
        for (Integer source : fst) {
            if (color[source] == 0) depthFirstVisit(source, snd);
        }
    }

    private void depthFirstVisit(int source, List<Integer> snd) {
        color[source] = 1;
        startTime[source] = ++time;
        if (adj.get(source) != null) {
            for (int node : adj.get(source)) {
                if (color[node] == 0) {
                    parent[node] = source;
                    depthFirstVisit(node, snd);
                }
            }
        }
        color[source] = 2;
        finishTime[source] = ++time;
        snd.add(0, source);
    }

    PriorityQueue<Integer> findValues(int value) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < DIM && adj.get(i) != null; i++)
            if (parent[i] == value) queue.add(i);
        return queue;
    }

    void makeTree(List<Integer> tree, int value) {
        if (value != -1) tree.add(value);
        PriorityQueue<Integer> queue = findValues(value);
        while (!queue.isEmpty()) {
            makeTree(tree, queue.remove());
        }
    }

    List<List<Integer>> buildTreeForest() {
        List<List<Integer>> treeForest = new ArrayList<>(Collections.nCopies(DIM, null));
        for (int i = 0; i < DIM && adj.get(i) != null; i++) {
            if (parent[i] == -1) {
                List<Integer> tree = new LinkedList<>();
                makeTree(tree, i);
                treeForest.set(i, tree);
            }
        }
        treeForest.removeIf(Objects::isNull);
        return treeForest;
    }

    public void addEdge(int source, int destination) {
        if (adj.get(source) == null) adj.set(source, new LinkedList<>());
        adj.get(source).add(destination);
    }
}

class Sociologia {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int nCenarios = inp.nextInt();
        for (int i = 0; i < nCenarios; i++) {
            List<Integer> fst = new LinkedList<>();
            List<Integer> snd = new LinkedList<>();
            Graph sociologia = new Graph();
            int nAlunos = inp.nextInt();
            for (int j = 0; j < nAlunos; j++) {
                fst.add(j);
            }
            for (int j = 0; j < nAlunos; j++) {
                int aluno = inp.nextInt();
                int nAmigos = inp.nextInt();
                for (int k = 0; k < nAmigos; k++) {
                    sociologia.addEdge(aluno - 1, inp.nextInt() - 1);
                }
            }
            sociologia.depthFirstSearch(fst, snd);
            Graph sociologiaT = sociologia.transpose();
            sociologiaT.depthFirstSearch(snd, new LinkedList<>());
            List<List<Integer>> groups = sociologiaT.buildTreeForest();
            int count = 0, nGroups = 0, nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (List<Integer> group : groups) {
                count = group.size();
                if (count >= 4) nGroups++;
                else nElemOut += count;
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}