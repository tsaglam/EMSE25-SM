import java.util.*;

class Graph {
    public static final int DIM = 1000; // Made static because it's a constant
    LinkedList<Integer>[] adj;
    int[] color, parent, startTime, finishTime;
    int time;

    Graph() {
        adj = new LinkedList[DIM];
        color = new int[DIM];
        parent = new int[DIM];
        startTime = new int[DIM];
        finishTime = new int[DIM];
    }

    Graph transpose() {
        var transposed = new Graph();
        for (int i = 0; adj[i] != null; i++)
            transposed.adj[i] = new LinkedList<>();

        for (int i = 0; adj[i] != null; i++) {
            for (int node : adj[i]) {
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
        for (int source : fst) {
            if (color[source] == 0)
                depthFirstVisit(source, snd);
        }
    }

    void depthFirstVisit(int source, LinkedList<Integer> snd) {
        color[source] = 1;
        time++;
        startTime[source] = time;
        for (int node : adj[source]) {
            if (color[node] == 0) {
                parent[node] = source;
                depthFirstVisit(node, snd);
            }
        }
        color[source] = 2;
        time++;
        finishTime[source] = time;
        snd.addFirst(source);
    }

    PriorityQueue<Integer> findValues(int value, int[] vtr) {
        var queue = new PriorityQueue<Integer>();
        for (int i = 0; adj[i] != null; i++)
            if (vtr[i] == value)
                queue.add(i);
        return queue;
    }

    void makeTree(LinkedList<Integer> tree, int value) {
        if (value != -1)
            tree.add(value);
        
        var queue = findValues(value, parent);
        while (!queue.isEmpty()) {
            int newValue = queue.remove();
            makeTree(tree, newValue);
        }
    }

    LinkedList<Integer>[] buildTreeForest() {
        var tree = (LinkedList<Integer>[]) new LinkedList[DIM];
        for (int i = 0; adj[i] != null; i++) {
            if (parent[i] == -1) {
                int aux = 0;
                while (tree[aux] != null) aux++;
                tree[aux] = new LinkedList<>();
                makeTree(tree[aux], i);
            }
        }
        return tree;
    }
}

class Sociologia {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int nCenarios = scanner.nextInt();
        for (int i = 0; i < nCenarios; i++) {
            var fst = new LinkedList<Integer>();
            var snd = new LinkedList<Integer>();
            var sociologia = new Graph();
            int nAlunos = scanner.nextInt();
            for (int j = 0; j < nAlunos; j++) {
                sociologia.adj[j] = new LinkedList<>();
                fst.add(j);
            }
            for (int j = 0; j < nAlunos; j++) {
                int aluno = scanner.nextInt();
                int nAmigos = scanner.nextInt();
                for (int k = 0; k < nAmigos; k++)
                    sociologia.adj[aluno - 1].add(scanner.nextInt() - 1);
            }
            sociologia.depthFirstSearch(fst, snd);
            var sociologiaT = sociologia.transpose();
            sociologiaT.depthFirstSearch(snd, new LinkedList<Integer>());
            var groups = sociologiaT.buildTreeForest();
            int count = 0, nGroups = 0, nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (var group : groups) {
                if (group == null) break;

                count = group.size();
                if (count >= 4)
                    nGroups++;
                else
                    nElemOut += count;
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}