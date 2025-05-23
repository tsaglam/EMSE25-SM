import java.util.*;

class SociologyExperiment {

    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int[] size;
        private int disjointSets;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            disjointSets = n;
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
                disjointSets--;
            }
        }
        
        public int getDisjointSets() {
            return disjointSets;
        }

        public int[] getSize() {
            return size;
        }

        // Custom method to get detailed group sizes
        public Map<Integer, Integer> getGroupSizes() {
            Map<Integer, Integer> groupSizes = new HashMap<>();
            for (int i = 0; i < parent.length; i++) {
                int root = find(i);
                groupSizes.put(root, groupSizes.getOrDefault(root, 0) + 1);
            }
            return groupSizes;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim());

        for (int s = 1; s <= scenarios; s++) {
            int students = Integer.parseInt(scanner.nextLine().trim());
            UnionFind uf = new UnionFind(students);

            for (int i = 0; i < students; i++) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                int student = Integer.parseInt(line[0]) - 1; // Adjusting for 0 based indexing
                for (int j = 2; j < line.length; j++) {
                    int friend = Integer.parseInt(line[j]) - 1; // Adjusting for 0 based indexing
                    uf.union(student, friend);
                }
            }

            Map<Integer, Integer> groupSizes = uf.getGroupSizes();
            int groupsWithFourOrMore = 0;
            int peopleOutsideGroups = 0;
            for (Integer size : groupSizes.values()) {
                if (size >= 4) {
                    groupsWithFourOrMore++;
                } else {
                    peopleOutsideGroups += size;
                }
            }

            System.out.println("Caso #" + s);
            System.out.println(groupsWithFourOrMore + " " + peopleOutsideGroups);
        }

        scanner.close();
    }
}