import java.util.*;
import java.lang.*;
class Graph {
    public final Integer DIM = 1000;
    int[] startTime, finishTime;
    int[] color, parent;
    LinkedList<Integer>[] adj = null;
    int time;
    @SuppressWarnings("unchecked") Graph() {
        color = new int[DIM];
        adj = new LinkedList[DIM];
        parent = new int[DIM];
        finishTime = new int[DIM];
        startTime = new int[DIM];
    }
    @SuppressWarnings("unchecked") Graph transpose() {
        Graph transposed = new Graph();
        for (int i = 0; this.adj[i] != null; i++)
            transposed.adj[i] = new LinkedList<Integer>();
        for (int i = 0; this.adj[i] != null; i++) {
            Iterator<Integer> it = adj[i].iterator();
            while (it.hasNext()) {
                int node = it.next();
                transposed.adj[node].addLast(i);
            }
        }
        return transposed;
    }
    @SuppressWarnings("unchecked") void depthFirstSearch(LinkedList<Integer> fst, LinkedList<Integer> snd) {
        Arrays.fill(finishTime, -1);
        time = 0;
        Arrays.fill(startTime, -1);
        Arrays.fill(color, 0);
        Arrays.fill(parent, -1);       
        Iterator<Integer> it = fst.iterator();
        while (it.hasNext()) {
            int source = it.next();
            if (color[source] == 0)
                depthFirstVisit(source, snd);
        }
    }
    @SuppressWarnings("unchecked") void depthFirstVisit(int source, LinkedList<Integer> snd) {
        startTime[source] = time;
        time += 1;
        color[source] = 1;
        Iterator<Integer> it = adj[source].iterator();
        while (it.hasNext()) {
            int node = it.next();
            if (color[node] == 0) {
                parent[node] = source;
                depthFirstVisit(node, snd);
            }
        }        
        color[source] = 2;
        time += 1;
        finishTime[source] = time;
        snd.addFirst(source);
    }
    @SuppressWarnings("unchecked") void makeTree(LinkedList<Integer> tree, int value) {
        if (value != -1)
            tree.add(value);
        PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
        fila = findValues(value, parent);
        while (!fila.isEmpty()) {
            int newValue = fila.remove();
            makeTree(tree, newValue);
        }
    }
    @SuppressWarnings("unchecked") PriorityQueue<Integer> findValues(int value, int[] vtr) {
        PriorityQueue<Integer> fila = new PriorityQueue<Integer>();
        for (int i = 0; adj[i] != null; i++)
            if (vtr[i] == value)
                fila.add(i);
        return fila;
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
            int nAlunos = inp.nextInt();
            LinkedList<Integer> fst = new LinkedList<Integer>();
            LinkedList<Integer> snd = new LinkedList<Integer>();
            Graph sociologia = new Graph();
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
            }
            System.out.printf("%d %d\n", nGroups, nElemOut);
        }
    }
}