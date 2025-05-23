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
                } else {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                    if (rank[rootX] == rank[rootY]) {
                        rank[rootY]++;
                    }
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
            int n = scanner.nextInt();
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                int student = scanner.nextInt() - 1;
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt() - 1;
                    uf.union(student, friend);
                }
            }
            int groupsOfFourOrMore = 0;
            int individualsOutside = 0;
            boolean[] checked = new boolean[n];
            for (int i = 0; i < n; i++) {
                int root = uf.find(i);
                if (!checked[root]) {
                    checked[root] = true;
                    int size = uf.getSize(root);
                    if (size >= 4) {
                        groupsOfFourOrMore++;
                    } else {
                        individualsOutside += size;
                    }
                }
            }
            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfFourOrMore + " " + individualsOutside);
        }
        scanner.close();
    }
}