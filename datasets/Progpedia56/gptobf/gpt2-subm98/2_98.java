import java.util.*;

class Node implements Comparable<Node> {
    private final double weight;
    private final int from;
    private final int to;

    Node(double weight, int from, int to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    public int compareTo(Node o) {
        return Double.compare(this.weight, o.weight);
    }

    public double getWeight() {
        return weight;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}

class Prob21 {
    private static List<Node> nodeList;
    private static int[] parentSet;
    private static int[] rank;

    private static void makeSet(int size) {
        parentSet = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parentSet[i] = i;
            rank[i] = 0;
        }
    }

    private static int findSet(int i) {
        if (i != parentSet[i]) {
            parentSet[i] = findSet(parentSet[i]);
        }
        return parentSet[i];
    }

    private static void union(int i, int j) {
        int rootI = findSet(i);
        int rootJ = findSet(j);
        if (rank[rootI] > rank[rootJ])
            parentSet[rootJ] = rootI;
        else {
            parentSet[rootI] = rootJ;
            if (rank[rootI] == rank[rootJ])
                rank[rootJ]++;
        }
    }

    private static double kruskal() {
        double cost = 0;
        Collections.sort(nodeList);
        for (Node node : nodeList) {
            if (findSet(node.getFrom()) != findSet(node.getTo())) {
                union(node.getFrom(), node.getTo());
                cost += node.getWeight();
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double[] xCord = new double[n];
        double[] yCord = new double[n];
        nodeList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            xCord[i] = in.nextDouble();
            yCord[i] = in.nextDouble();
        }

        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                double dx = xCord[i] - xCord[j];
                double dy = yCord[i] - yCord[j];
                nodeList.add(new Node(Math.sqrt(dx * dx + dy * dy), i, j));
            }
        }

        makeSet(n);

        System.out.printf("%.2f\n", kruskal());
    }
}