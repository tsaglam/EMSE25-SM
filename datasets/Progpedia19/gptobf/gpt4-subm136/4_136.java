import java.util.*;

class Graph {
    public static final int DIM = 1000; // Make DIM static final as it's a constant
    LinkedList<Integer>[] adj = new LinkedList[DIM];
    int[] color = new int[DIM], parent = new int[DIM], startTime = new int[DIM], finishTime = new int[DIM];
    int time = 0;

    Graph() {
        for (int i = 0; i < adj.length; i++) { // Initialize as null to start so checking for null is valid
            adj[i] = null; 
        }
    }

    Graph transpose() {
        Graph transposed = new Graph();
        for (int i = 0; i < adj.length && adj[i] != null; i++) // Check within bounds and non-null
            transposed.adj[i] = new LinkedList<>();

        for (int i = 0; i < adj.length && adj[i] != null; i++) {
            for (int node : adj[i]) { // Enhanced for loop for readability
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

        for (int source : fst) { // Enhanced for loop
            if (color[source] == 0)
                depthFirstVisit(source, snd);
        }
    }

    void depthFirstVisit(int source, LinkedList<Integer> snd) {
        color[source] = 1;
        startTime[source] = ++time;
        for (int node : adj[source]) { // Enhanced for loop
            if (color[node] == 0) {
                parent[node] = source;
                depthFirstVisit(node, snd);
            }
        }
        finishTime[source] = ++time;
        snd.addFirst(source); // Reversed post-order for processing
    }

    PriorityQueue<Integer> findValues(int value, int[] vtr) {
        PriorityQueue<Integer> fila = new PriorityQueue<>();
        for (int i = 0; i < adj.length && adj[i] != null; i++)
            if (vtr[i] == value) fila.add(i);
        return fila;
    }

    void makeTree(LinkedList<Integer> tree, int value) {
        if (value != -1) tree.add(value);
        for (int newValue : findValues(value, parent)) {
            makeTree(tree, newValue);
        }
    }

    LinkedList<Integer>[] buildTreeForest() {
        LinkedList<Integer>[] tree = new LinkedList[DIM];
        for (int i = 0; i < adj.length && adj[i] != null; i++) {
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
            LinkedList<Integer> fst = new LinkedList<>();
            LinkedList<Integer> snd = new LinkedList<>();
            Graph sociologia = new Graph();
            int nAlunos = inp.nextInt();
            for (int j = 0; j < nAlunos; j++) {
                sociologia.adj[j] = new LinkedList<>();
                fst.add(j);
            }
            for (int j = 0; j < nAlunos; j++) {
                int aluno = inp.nextInt();
                int nAmigos = inp.nextInt();
                for (int k = 0; k < nAmigos; k++)
                    sociologia.adj[aluno - 1].add(inp.nextInt() - 1);
            }
            sociologia.depthFirstSearch(fst, snd);
            Graph sociologiaT = sociologia.transpose();
            sociologiaT.depthFirstSearch(snd, fst = new LinkedList<>()); // Reset fst directly

            LinkedList<Integer>[] groups = sociologiaT.buildTreeForest();
            int count = 0, nGroups = 0, nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (LinkedList<Integer> group : groups) {
                if (group == null) break; // Exit loop if null encountered
                for (Integer elem : group) { // Use enhanced for loop
                    count++;
                }
                if (count >= 4)
                    nGroups++;
                else
                    nElemOut += count;
                count = 0;
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
        inp.close(); // Close scanner
    }
}