import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class SociologyExperiment {

    static class UnionFind {
        private int[] parent;

        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x);
            int yRoot = find(y);
            if (xRoot != yRoot) {
                parent[xRoot] = yRoot;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= scenarios; i++) {
            int students = Integer.parseInt(scanner.nextLine());
            UnionFind uf = new UnionFind(students);

            for (int j = 0; j < students; j++) {
                String[] input = scanner.nextLine().split(" ");
                int student = Integer.parseInt(input[0]) - 1;
                int count = Integer.parseInt(input[1]);

                for (int k = 0; k < count; k++) {
                    int friend = Integer.parseInt(input[k + 2]) - 1;
                    uf.union(student, friend);
                }
            }

            int[] groupSizes = new int[students];
            for (int j = 0; j < students; j++) {
                groupSizes[uf.find(j)]++;
            }

            int groupsOfFourOrMore = 0;
            int individualsOutsideGroups = 0;
            Set<Integer> counted = new HashSet<>();

            for (int j = 0; j < students; j++) {
                int root = uf.find(j);
                if (!counted.contains(root)) {
                    if (groupSizes[root] >= 4) {
                        groupsOfFourOrMore++;
                    } else {
                        individualsOutsideGroups += groupSizes[root];
                    }
                    counted.add(root);
                }
            }

            System.out.printf("Caso #%d\n", i);
            System.out.println(groupsOfFourOrMore + " " + individualsOutsideGroups);
        }

        scanner.close();
    }
}