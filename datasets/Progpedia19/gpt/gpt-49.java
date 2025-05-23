import java.util.*;

class SociologyExperiment {
    private static List<List<Integer>> generateAdjacencyList(int n, Scanner scanner) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int student = scanner.nextInt() - 1; // Adjusting to 0-based index
            int count = scanner.nextInt();
            for (int j = 0; j < count; j++) {
                int friend = scanner.nextInt() - 1; // Adjusting to 0-based index
                adjacencyList.get(student).add(friend);
                adjacencyList.get(friend).add(student); // Mutual relationship
            }
        }
        return adjacencyList;
    }

    private static void dfs(int student, List<List<Integer>> adjacencyList, boolean[] visited, List<Integer> group) {
        visited[student] = true;
        group.add(student);
        for (int friend : adjacencyList.get(student)) {
            if (!visited[friend]) {
                dfs(friend, adjacencyList, visited, group);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int n = scanner.nextInt();
            List<List<Integer>> adjacencyList = generateAdjacencyList(n, scanner);
            boolean[] visited = new boolean[n];
            List<List<Integer>> groups = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    List<Integer> group = new ArrayList<>();
                    dfs(i, adjacencyList, visited, group);
                    groups.add(group);
                }
            }

            int countLargeGroups = 0;
            int outsides = n;
            for (List<Integer> group : groups) {
                if (group.size() >= 4) {
                    countLargeGroups++;
                    outsides -= group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(countLargeGroups + " " + outsides);
        }
        scanner.close();
    }
}