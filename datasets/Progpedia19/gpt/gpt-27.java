import java.util.*;

class SociologyExperiment {
    private static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
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
                    size[rootY] += size[rootX];
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                    size[rootX] += size[rootY];
                }
            }
        }

        public int getSize(int x) {
            return size[find(x)];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine());

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = Integer.parseInt(scanner.nextLine());
            UnionFind uf = new UnionFind(students);

            for (int i = 0; i < students; i++) {
                String[] input = scanner.nextLine().split(" ");
                int student = Integer.parseInt(input[0]) - 1; // Convert to zero-based index
                for (int j = 2; j < input.length; j++) {
                    uf.union(student, Integer.parseInt(input[j]) - 1); // Convert to zero-based index and join groups
                }
            }

            // Count the sizes
            HashSet<Integer> groups = new HashSet<>();
            int[] groupCount = new int[students + 1]; // Index 0 will be unused
            for (int i = 0; i < students; i++) {
                int size = uf.getSize(i);
                if (size >= 4) {
                    if (!groups.contains(uf.find(i))) {
                        groups.add(uf.find(i));
                        groupCount[size]++;
                    }
                }
            }

            int bigGroups = 0;
            int lonelyPeople = students;
            for (int groupSize : groupCount) {
                if (groupSize > 0) {
                    bigGroups++;
                    lonelyPeople -= groupSize * 4; // 4 or more in each group
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(bigGroups + " " + lonelyPeople);
        }
    }
}