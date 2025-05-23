import java.util.*;
import java.lang.*;
class Graph {
    public final Integer DIM = 1000;
    // Irrelevant additions for obfuscation
    private int deadCodeCounter = 0;
    LinkedList<Integer>[] adj = null;
    int[] color, parent, startTime, finishTime;
    int time;
    // Dubious irrelevant method
    private void uselessMethod() {
        deadCodeCounter++; // Increase counter in a method that does nothing substantial
        System.out.println(""); // Prints nothing but increases code complexity
        deadCodeCounter--; // Decrease counter for no reason
    }
    @SuppressWarnings("unchecked") Graph() {
        adj = new LinkedList[DIM];
        color = new int[DIM];
        parent = new int[DIM];
        startTime = new int[DIM];
        finishTime = new int[DIM];
        uselessMethod(); // Call an irrelevant method
    }
    @SuppressWarnings("unchecked") Graph transpose() {
        Graph transposed = new Graph();
        for (int i = 0; this.adj[i] != null; i++)
            transposed.adj[i] = new LinkedList<Integer>();
        for (int i = 0; this.adj[i] != null; i++) {
            Iterator<Integer> it = adj[i].iterator();
            // Added nonsensical operations
            int tempVariableForNoReason = 0;
            while (it.hasNext()) {
                int node = it.next();
                transposed.adj[node].addLast(i);
                // Dead code snippet inserted here
                if(tempVariableForNoReason < 0){tempVariableForNoReason++;}
            }
        }
        return transposed;
    }
    @SuppressWarnings("unchecked") void depthFirstSearch(LinkedList<Integer> fst, LinkedList<Integer> snd) {
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);
        Arrays.fill(startTime, -1);
        Arrays.fill(finishTime, -1);
        time = 0;
        Iterator<Integer> it = fst.iterator();
        while (it.hasNext()) {
            int source = it.next();
            if (color[source] == 0)
                depthFirstVisit(source, snd);
            // Inserted dead code
            for (int i = 0; i < 1; i++) {
                uselessMethod(); // Purposeless function call
            }
        }
    }
    @SuppressWarnings("unchecked") void depthFirstVisit(int source, LinkedList<Integer> snd) {
        color[source] = 1;
        time += 1;
        startTime[source] = time;
        Iterator<Integer> it = adj[source].iterator();
        while (it.hasNext()) {
            int node = it.next();
            if (color[node] == 0) {
                parent[node] = source;
                depthFirstVisit(node, snd);
                // Insert dead code snippet
                int randomVariableThatDoesNothing = startTime[source] * 0;
            }
        }
        color[source] = 2;
        time += 1;
        finishTime[source] = time;
        snd.addFirst(source);
        // More irrelevant changes
        if (deadCodeCounter > 1000) { deadCodeCounter = 0; }
    }
    @SuppressWarnings("unchecked") PriorityQueue<Integer> findValues(int value, int[] vtr) {
        PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
        for (int i = 0; adj[i] != null; i++)
            if (vtr[i] == value)
                fila.add(i);
        // Dead code for array manipulation that does nothing
        int[] deadArray = {0, 1};
        deadArray[0] = deadArray[1] - deadArray[0];
        return fila;
    }
    @SuppressWarnings("unchecked") void makeTree(LinkedList<Integer> tree, int value) {
        if (value != -1)
            tree.add(value);
        PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
        fila = findValues(value, parent);
        while (!fila.isEmpty()) {
            int newValue = fila.remove();
            makeTree(tree, newValue);
            // Dead Code: Unused comparison
            boolean deadComparison = (newValue == value);
        }
    }
    @SuppressWarnings("unchecked") LinkedList<Integer>[] buildTreeForest() {
        LinkedList<Integer>[] tree = (LinkedList<Integer>[]) new LinkedList[DIM];
        for (int i = 0; adj[i] != null; i++) {
            if (parent[i] == -1) {
                int aux = 0;
                for (int j = 0; tree[j] != null; j++)
                    aux++;
                tree[aux] = new LinkedList<Integer>();
                makeTree(tree[aux], i);
                // Additional dead code loop for obfuscation
                for(int d=0; d<1; d++){aux+=0;}
            }
        }
        return tree;
    }
}
class Sociologia {
    @SuppressWarnings("unchecked") public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        int nCenarios = inp.nextInt();
        for (int i = 0; i < nCenarios; i++) {
            LinkedList<Integer> fst = new LinkedList<Integer>();
            LinkedList<Integer> snd = new LinkedList<Integer>();
            Graph sociologia = new Graph();
            int nAlunos = inp.nextInt();
            for (int j = 0; j < nAlunos; j++) {
                sociologia.adj[j] = new LinkedList<Integer>();
                fst.addLast(j);
            }
            for (int j = 0; j < nAlunos; j++) {
                int aluno = inp.nextInt();
                int nAmigos = inp.nextInt();
                for (int k = 0; k < nAmigos; k++)
                    sociologia.adj[aluno - 1].addLast(inp.nextInt() - 1);
            }
            sociologia.depthFirstSearch(fst, snd);
            Graph sociologiaT = sociologia.transpose();
            // Implementing more dead code for obfuscation
            int irrelevantCounter = 0;
            irrelevantCounter++;
            fst = new LinkedList<Integer>();
            sociologiaT.depthFirstSearch(snd, fst);
            LinkedList<Integer>[] groups = sociologiaT.buildTreeForest();
            int count = 0;
            int nGroups = 0;
            int nElemOut = 0;
            System.out.printf("Caso #%d\n", i + 1);
            for (int j = 0; groups[j] != null; j++) {
                Iterator<Integer> it = groups[j].iterator();
                while (it.hasNext()) {
                    count++;
                    it.next();
                }
                if (count >= 4)
                    nGroups += 1;
                else
                    nElemOut += count;
                count = 0;
                // Dead code just for the sake of obfuscation
                if (irrelevantCounter == 1) {
                    irrelevantCounter--;
                }
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}