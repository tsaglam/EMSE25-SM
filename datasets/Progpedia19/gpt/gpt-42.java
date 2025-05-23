import java.util.*;

class SociologyExperiment {
    static List<List<Integer>> adjList;
    static boolean[] visited;
    static int groupSize;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();  // Number of scenarios to consider

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = scanner.nextInt();  // Number of students
            adjList = new ArrayList<>();
            visited = new boolean[students];

            // Initialize adjacency list
            for (int i = 0; i < students; i++) {
                adjList.add(new ArrayList<>());
            }

            // Read relationships
            for (int i = 0; i < students; i++) {
                int studentId = scanner.nextInt() - 1;  // Adjust for 0-based indexing
                int friendsCount = scanner.nextInt();

                for (int j = 0; j < friendsCount; j++) {
                    int friendId = scanner.nextInt() - 1;  // Adjust for 0-based indexing
                    adjList.get(studentId).add(friendId);
                    adjList.get(friendId).add(studentId);  // Since the relationship is mutual
                }
            }

            // DFS to find all groups
            int groupsWithFourOrMore = 0;
            int individualsOutsideGroups = students;
            for (int i = 0; i < students; i++) {
                if (!visited[i]) {
                    groupSize = 0;
                    dfs(i);
                    if (groupSize >= 4) {
                        groupsWithFourOrMore++;
                        individualsOutsideGroups -= groupSize;
                    }
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsWithFourOrMore + " " + individualsOutsideGroups);
        }

        scanner.close();
    }

    // DFS to traverse through friends and calculate group size
    public static void dfs(int student) {
        visited[student] = true;
        groupSize++;
        for (int friend : adjList.get(student)) {
            if (!visited[friend]) {
                dfs(friend);
            }
        }
    }
}