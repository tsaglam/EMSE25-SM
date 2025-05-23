import java.util.*;

class SociologyExperiment {
    private static class UnionFind {
        private int[] root;
        private int[] rank;

        public UnionFind(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == root[x]) {
                return x;
            }
            return root[x] = find(root[x]); // Path compression
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    root[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    root[rootX] = rootY;
                } else {
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int i = 1; i <= scenarios; i++) {
            int n = scanner.nextInt();
            UnionFind uf = new UnionFind(n);

            for (int student = 0; student < n; student++) {
                int studentId = scanner.nextInt() - 1; // Adjust for 0-based indexing
                int friends = scanner.nextInt();
                for (int j = 0; j < friends; j++) {
                    int friendId = scanner.nextInt() - 1; // Adjust for 0-based indexing
                    uf.union(studentId, friendId);
                }
            }

            // Count the number of nodes in each disjoint set (group)
            int[] groupSize = new int[n];
            for (int k = 0; k < n; k++) {
                int root = uf.find(k);
                groupSize[root]++;
            }

            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = 0;
            Set<Integer> countedGroups = new HashSet<>();
            for (int k = 0; k < n; k++) {
                int root = uf.find(k);
                if (groupSize[root] >= 4 && countedGroups.add(root)) {
                    groupsOfFourOrMore++;
                }
            }
            for (int size : groupSize) {
                if (size < 4) peopleOutsideGroups += size;
            }

            System.out.println("Caso #" + i);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }
        scanner.close();
    }
}