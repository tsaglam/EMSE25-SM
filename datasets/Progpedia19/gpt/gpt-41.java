import java.util.*;

class SociologyExperiment {

    static class DisjointSet {
        int[] rank, parent;
        int[] memberCount; // Additional array to count members in each set.

        public DisjointSet(int size) {
            rank = new int[size];
            parent = new int[size];
            memberCount = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                memberCount[i] = 1; // Initially, each set has only one member.
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot == yRoot) return;

            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
                memberCount[yRoot] += memberCount[xRoot];
            } else if (rank[yRoot] < rank[xRoot]) {
                parent[yRoot] = xRoot;
                memberCount[xRoot] += memberCount[yRoot];
            } else {
                parent[yRoot] = xRoot;
                rank[xRoot] += 1;
                memberCount[xRoot] += memberCount[yRoot];
            }
        }

        // Utility function to get count of unique groups with more than 3 members.
        public int[] getLargeGroupsInfo() {
            int groupCount = 0;
            int outsideCount = 0;
            boolean[] visited = new boolean[rank.length];
            for (int i = 0; i < rank.length; i++) {
                int root = find(i);
                if (!visited[root]) {
                    visited[root] = true;
                    if (memberCount[root] >= 4) {
                        groupCount++;
                    } else {
                        outsideCount += memberCount[root];
                    }
                }
            }
            return new int[]{groupCount, outsideCount};
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim());
        for (int t = 1; t <= scenarios; t++) {
            int numStudents = Integer.parseInt(scanner.nextLine().trim());
            DisjointSet ds = new DisjointSet(numStudents);
            for (int i = 0; i < numStudents; i++) {
                String[] input = scanner.nextLine().trim().split(" ");
                int student = Integer.parseInt(input[0]) - 1; // Adjusting indexing to 0-based.
                for (int j = 2; j < input.length; j++) {
                    int friend = Integer.parseInt(input[j]) - 1; // Adjusting indexing to 0-based.
                    ds.union(student, friend);
                }
            }

            int[] result = ds.getLargeGroupsInfo();
            System.out.println("Caso #" + t);
            System.out.println(result[0] + " " + result[1]);
        }
        scanner.close();
    }
}