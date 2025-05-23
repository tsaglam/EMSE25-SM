import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SociologyExperiment {
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int s = 1; s <= scenarios; s++) {
            int students = scanner.nextInt();
            graph = new ArrayList<>();
            visited = new boolean[students + 1];

            for (int i = 0; i <= students; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt();
                int numFriends = scanner.nextInt();
                for (int j = 0; j < numFriends; j++) {
                    int friend = scanner.nextInt();
                    graph.get(student).add(friend);
                    graph.get(friend).add(student); 
                }
            }

            int groupsOfFourOrMore = 0;
            int peopleOutside = students;
            for (int i = 1; i <= students; i++) {
                if (!visited[i]) {
                    count = 0;
                    dfs(i);
                    if (count >= 4) {
                        groupsOfFourOrMore++;
                        peopleOutside -= count;
                    }
                }
            }

            System.out.println("Caso #" + s);
            System.out.println(groupsOfFourOrMore + " " + peopleOutside);
        }
        scanner.close();
    }

    private static void dfs(int v) {
        visited[v] = true;
        count++;
        for (int neighbor : graph.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}