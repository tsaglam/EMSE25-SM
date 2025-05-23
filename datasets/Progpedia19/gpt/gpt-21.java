import java.util.*;

class SociologyExperiment {

    private static int[] parent;
    private static int[] rank;
    private static int[] groupSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();
            initialize(students);

            // Reading relations and forming groups
            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt() - 1;
                int relations = scanner.nextInt();
                for (int j = 0; j < relations; j++) {
                    int friend = scanner.nextInt() - 1;
                    union(student, friend);
                }
            }

            // Counting unique groups with their sizes
            Map<Integer, Integer> groupCounts = new HashMap<>();
            for (int i = 0; i < students; i++) {
                int root = find(i);
                groupCounts.put(root, groupCounts.getOrDefault(root, 0) + 1);
            }

            // Determining number of groups with size >= 4 and number of people outside these groups
            int groupsOfSizeFourOrMore = 0;
            int peopleOutside = 0;
            for (int size : groupCounts.values()) {
                if (size >= 4) {
                    groupsOfSizeFourOrMore++;
                } else {
                    peopleOutside += size;
                }
            }

            // Output result for the current scenario
            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfSizeFourOrMore + " " + peopleOutside);
        }
        scanner.close();
    }

    private static void initialize(int n) {
        parent = new int[n];
        rank = new int[n];
        groupSize = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            groupSize[i] = 1;
        }
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot != yRoot) {
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
                groupSize[yRoot] += groupSize[xRoot];
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
                groupSize[xRoot] += groupSize[yRoot];
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot]++;
                groupSize[xRoot] += groupSize[yRoot];
            }
        }
    }
}