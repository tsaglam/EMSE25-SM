import java.util.*;

class SociologyExperiment {

    private static class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();
            UnionFind uf = new UnionFind(students);
            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt() - 1; // Adjust for 0-indexed
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int related = scanner.nextInt() - 1; // Adjust for 0-indexed
                    uf.union(student, related);
                }
            }

            // Count groups and their sizes
            Map<Integer, Integer> groupSizes = new HashMap<>();
            for (int i = 0; i < students; i++) {
                int root = uf.find(i);
                groupSizes.put(root, groupSizes.getOrDefault(root, 0) + 1);
            }

            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = 0;
            for (int size : groupSizes.values()) {
                if (size >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutsideGroups += size;
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }
    }
}