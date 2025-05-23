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
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
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
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();
            UnionFind unionFind = new UnionFind(students);

            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt() - 1;
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt() - 1;
                    unionFind.union(student, friend);
                }
            }

            Set<Integer> largeGroups = new HashSet<>();
            int[] peopleInGroups = new int[students];

            for (int i = 0; i < students; i++) {
                int size = unionFind.getSize(i);
                peopleInGroups[i] = size;
                if (size >= 4) {
                    largeGroups.add(unionFind.find(i));
                }
            }

            int largeGroupCount = 0, peopleOutside = 0;
            for (int size : peopleInGroups) {
                if (size < 4) {
                    peopleOutside++;
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups.size() + " " + peopleOutside);
        }
    }
}