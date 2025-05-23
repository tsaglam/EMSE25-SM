import java.util.*;

class SociologyExperiment {

    private static class UnionFind {
        int[] parent;
        int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]); // Path compression
            }
            return parent[i];
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                if (size[rootI] < size[rootJ]) {
                    parent[rootI] = rootJ;
                    size[rootJ] += size[rootI];
                } else {
                    parent[rootJ] = rootI;
                    size[rootI] += size[rootJ];
                }
            }
        }

        public HashSet<Integer> getGroups() {
            HashSet<Integer> groups = new HashSet<>();
            for (int i = 0; i < parent.length; i++) {
                groups.add(find(i));
            }
            return groups;
        }

        public int getSize(int i) {
            return size[find(i)];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();
            UnionFind uf = new UnionFind(students + 1); // +1 since we start from 1

            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt();
                int count = scanner.nextInt();
                while (count-- > 0) {
                    int friend = scanner.nextInt();
                    uf.union(student, friend);
                }
            }

            HashSet<Integer> groups = uf.getGroups();
            int largeGroups = 0;
            int outside = 0;

            for (int group : groups) {
                if (uf.getSize(group) >= 4) {
                    largeGroups++;
                } else {
                    outside += uf.getSize(group);
                }
            }

            // Adjusting for the case where everyone is outside (group of 1 not counted)
            if (groups.size() == students && students < 4) {
                largeGroups = 0;
                outside = students;
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + (students - outside));
        }
    }
}