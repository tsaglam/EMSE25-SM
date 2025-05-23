import java.util.*;
import java.lang.*;

class NetGraph {
    public static final int MaxDimension = 1000;
    List<Integer>[] adjacencyList;
    int[] paint, origin, beginTime, endTime;
    int clock;

    @SuppressWarnings("unchecked")
    NetGraph() {
        adjacencyList = new LinkedList[MaxDimension];
        paint = new int[MaxDimension];
        origin = new int[MaxDimension];
        beginTime = new int[MaxDimension];
        endTime = new int[MaxDimension];
    }

    @SuppressWarnings("unchecked")
    NetGraph reverseGraph() {
        NetGraph reversed = new NetGraph();
        for (int v = 0; adjacencyList[v] != null; v++) reversed.adjacencyList[v] = new LinkedList<>();
        for (int v = 0; adjacencyList[v] != null; v++) {
            for (Integer i : adjacencyList[v]) {
                reversed.adjacencyList[i].add(v);
            }
        }
        return reversed;
    }

    @SuppressWarnings("unchecked")
    void exploreDepthFirst(List<Integer> srcQueue, List<Integer> dstQueue) {
        Arrays.fill(paint, 0);
        Arrays.fill(origin, -1);
        Arrays.fill(beginTime, -1);
        Arrays.fill(endTime, -1);
        clock = 0;
        for (Integer src : srcQueue) {
            if (paint[src] == 0) diveDeeper(src, dstQueue);
        }
    }

    @SuppressWarnings("unchecked")
    void diveDeeper(int node, List<Integer> dstQueue) {
        paint[node] = 1;
        clock++;
        beginTime[node] = clock;
        for (Integer adjNode : adjacencyList[node]) {
            if (paint[adjNode] == 0) {
                origin[adjNode] = node;
                diveDeeper(adjNode, dstQueue);
            }
        }
        paint[node] = 2;
        clock++;
        endTime[node] = clock;
        dstQueue.add(0, node);
    }

    @SuppressWarnings("unchecked")
    PriorityQueue<Integer> searchValues(int val, int[] vector) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; adjacencyList[i] != null; i++) {
            if (vector[i] == val) queue.add(i);
        }
        return queue;
    }

    @SuppressWarnings("unchecked")
    void constructForest(List<Integer> tree, int nodeValue) {
        if (nodeValue != -1) tree.add(nodeValue);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue = searchValues(nodeValue, origin);
        while (!queue.isEmpty()) {
            constructForest(tree, queue.poll());
        }
    }

    @SuppressWarnings("unchecked")
    List<Integer>[] generateForest() {
        List<Integer>[] forest = (List<Integer>[]) new LinkedList[MaxDimension];
        for (int i = 0; adjacencyList[i] != null; i++) {
            if (origin[i] == -1) {
                int pointer = 0;
                while (forest[pointer] != null) pointer++;
                forest[pointer] = new LinkedList<>();
                constructForest(forest[pointer], i);
            }
        }
        return forest;
    }
}

class SocialNetworkAnalysis {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int scenarios = input.nextInt();
        for (int s = 0; s < scenarios; s++) {
            List<Integer> startPoints = new LinkedList<>();
            List<Integer> endPoints = new LinkedList<>();
            NetGraph graph = new NetGraph();
            int numOfStudents = input.nextInt();
            for (int n = 0; n < numOfStudents; n++) {
                graph.adjacencyList[n] = new LinkedList<>();
                startPoints.add(n);
            }
            for (int n = 0; n < numOfStudents; n++) {
                int student = input.nextInt();
                int friendsCount = input.nextInt();
                for (int f = 0; f < friendsCount; f++) graph.adjacencyList[student - 1].add(input.nextInt() - 1);
            }
            graph.exploreDepthFirst(startPoints, endPoints);
            NetGraph transposedGraph = graph.reverseGraph();
            startPoints.clear();
            transposedGraph.exploreDepthFirst(endPoints, startPoints);

            List<Integer>[] clusters = transposedGraph.generateForest();
            int clusterCount = 0, outsiders = 0, membersCount = 0;
            System.out.printf("Scenario #%d\n", s + 1);
            for (int c = 0; clusters[c] != null; c++) {
                for (Integer ignored : clusters[c]) membersCount++;
                if (membersCount >= 4) clusterCount++;
                else outsiders += membersCount;
                membersCount = 0;
            }
            System.out.printf("%d %d\n", clusterCount, outsiders);
        }
    }
}