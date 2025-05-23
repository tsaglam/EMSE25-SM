import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class SociologyExperiment {
    private static class DisjointSet {
        private final int[] parent;
        private final int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
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
        int scenarios = Integer.parseInt(scanner.nextLine());
        for (int scenarioIndex = 1; scenarioIndex <= scenarios; scenarioIndex++) {
            int studentCount = Integer.parseInt(scanner.nextLine());
            DisjointSet ds = new DisjointSet(studentCount);

            for (int i = 0; i < studentCount; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int studentId = Integer.parseInt(parts[0]) - 1; // Adjusting to 0-based indexing
                for (int j = 2; j < parts.length; j++) {
                    int friendId = Integer.parseInt(parts[j]) - 1; // Adjusting to 0-based indexing
                    ds.union(studentId, friendId);
                }
            }

            int[] groupSize = new int[studentCount];
            for (int i = 0; i < studentCount; i++) {
                int root = ds.find(i);
                groupSize[root]++;
            }

            int largeGroups = 0;
            int outside = 0;
            HashSet<Integer> countedGroups = new HashSet<>();
            for (int i = 0; i < studentCount; i++) {
                int root = ds.find(i);
                if (!countedGroups.contains(root)) {
                    if (groupSize[root] >= 4) {
                        largeGroups++;
                    } else {
                        outside += groupSize[root];
                    }
                    countedGroups.add(root);
                }
            }

            System.out.println("Caso #" + scenarioIndex);
            System.out.println(largeGroups + " " + outside);
        }
        scanner.close();
    }
}