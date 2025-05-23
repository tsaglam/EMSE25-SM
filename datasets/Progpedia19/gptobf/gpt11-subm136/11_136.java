import java.util.*;

class Graph {
    public final Integer DIM = 1000;
    LinkedList<Integer>[] adj = new LinkedList[DIM];
    int[] color = new int[DIM], parent = new int[DIM], startTime = new int[DIM], finishTime = new int[DIM];
    int time;

    Graph() {
        for (int i = 0; i < DIM; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    Graph transpose() {
        Graph transposed = new Graph();
        for (int i = 0; i < DIM && this.adj[i] != null; i++) {
            for (Integer node : adj[i]) {
                transposed.adj[node].add(i);
            }
        }
        return transposed;
    }

    void depthFirstSearch(LinkedList<Integer> fst, LinkedList<Integer> snd) {
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(startTime, -1);
        Arrays.fill(finishTime, -1);
        time = 0;
        for (Integer source : fst) {
            if (color[source] == 0) depthFirstVisit(source, snd);
        }
    }

    void depthFirstVisit(int source, LinkedList<Integer> snd) {
        color[source] = 1;
        startTime[source] = ++time;
        for (Integer node : adj[source]) {
            if (color[node] == 0) {
                parent[node] = source;
                depthFirstVisit(node, snd);
            }
        }
        color[source] = 2;
        finishTime[source] = ++time;
        snd.addFirst(source);
    }

    PriorityQueue<Integer> findValues(int value, int[] vtr) {
        PriorityQueue<Integer> fila = new PriorityQueue<>();
        for (int i = 0; i < DIM && adj[i] != null; i++) {
            if (vtr[i] == value) fila.add(i);
        }
        return fila;
    }

    void makeTree(LinkedList<Integer> tree, int value) {
        if (value != -1) tree.add(value);
        PriorityQueue<Integer> fila = findValues(value, parent);
        while (!fila.isEmpty()) {
            makeTree(tree, fila.remove());
        }
    }

    LinkedList<Integer>[] buildTreeForest() {
        LinkedList<Integer>[] tree = new LinkedList[DIM];
        for (int i = 0; i < DIM && adj[i] != null; i++) {
            if (parent[i] == -1) {
                tree[i] = new LinkedList<>();
                makeTree(tree[i], i);
            }
        }
        return tree;
    }
}

class Sociologia {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int nCenarios = inp.nextInt();
        for (int i = 0; i < nCenarios; i++) {
            Graph sociologia = new Graph();
            int nAlunos = inp.nextInt();
            LinkedList<Integer> fst = new LinkedList<>();
            for (int j = 0; j < nAlunos; j++) {
                fst.add(j);
            }
            for (int j = 0; j < nAlunos; j++) {
                int aluno = inp.nextInt(), nAmigos = inp.nextInt();
                for (int k = 0; k < nAmigos; k++) {
                    sociologia.adj[aluno - 1].add(inp.nextInt() - 1);
                }
            }
            LinkedList<Integer> snd = new LinkedList<>();
            sociologia.depthFirstSearch(fst, snd);
            Graph sociologiaT = sociologia.transpose();
            LinkedList<Integer> emptyList = new LinkedList<>();
            sociologiaT.depthFirstSearch(snd, emptyList);
            LinkedList<Integer>[] groups = sociologiaT.buildTreeForest();
            int count = 0, nGroups = 0, nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (LinkedList<Integer> group : groups) {
                if (group == null) break;
                for (Integer member : group) {
                    count++;
                }
                if (count >= 4) nGroups++;
                else nElemOut += count;
                count = 0;
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}