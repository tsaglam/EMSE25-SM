import java.util.*;

class SociologyExperiment {
    static int[] parent; // Parent array to track the root of each node in the set
    static int[] rank; // Rank array to keep the tree short
    static int[] size; // Size array to keep track of the size of each group

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt(); // Read the number of scenarios

        for (int caseNum = 1; caseNum <= scenarios; caseNum++) {
            int students = scanner.nextInt(); // Read the number of students

            // Initialize parent, rank, and size arrays for the current scenario
            parent = new int[students + 1];
            rank = new int[students + 1];
            size = new int[students + 1];

            for (int i = 1; i <= students; i++) {
                parent[i] = i; // Each student is initially their own parent
                size[i] = 1; // Initial size of each group is 1
            }

            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt(); // Read the student number
                int count = scanner.nextInt(); // Number of students they relate to

                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt();
                    union(student, friend); // Union the current student and their friend
                }
            }

            // Counting the number of groups with 4 or more students
            int groupsOfFourOrMore = 0;
            Set<Integer> uniqueGroups = new HashSet<>();
            for (int i = 1; i <= students; i++) {
                int root = find(i);
                if (size[root] >= 4) {
                    uniqueGroups.add(root);
                }
            }
            groupsOfFourOrMore = uniqueGroups.size();

            // Counting the number of people outside groups of four or more
            int countOutside = 0;
            for (int root : uniqueGroups) {
                countOutside += size[root];
            }
            countOutside = students - countOutside;

            System.out.println("Caso #" + caseNum);
            System.out.println(groupsOfFourOrMore + " " + countOutside);
        }
        scanner.close();
    }

    public static int find(int i) { // Find with Path Compression
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public static void union(int x, int y) { // Union by Rank
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) return;

        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            size[rootY] += size[rootX]; // Update the size of the new root
        } else if (rank[rootY] < rank[rootX]) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY]; // Update the size of the new root
        } else {
            parent[rootY] = rootX;
            rank[rootX] = rank[rootX] + 1;
            size[rootX] += size[rootY]; // Update the size of the new root
        }
    }
}