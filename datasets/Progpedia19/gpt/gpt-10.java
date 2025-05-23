import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class SociologyExperiment {
    private static final Map<Integer, List<Integer>> relations = new HashMap<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scen = 1; scen <= scenarios; scen++) {
            int students = scanner.nextInt();
            visited = new boolean[students + 1];
            relations.clear();

            for (int i = 0; i < students; i++) {
                int student = scanner.nextInt();
                int count = scanner.nextInt();
                List<Integer> friends = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt();
                    friends.add(friend);
                }
                relations.put(student, friends);
            }

            List<Integer> groupSizes = new ArrayList<>();
            for (int i = 1; i <= students; i++) {
                if (!visited[i]) {
                    int size = dfs(i);
                    groupSizes.add(size);
                }
            }

            int largeGroupsCount = 0;
            int individualsOutside = 0;
            for (Integer size : groupSizes) {
                if (size >= 4) {
                    largeGroupsCount++;
                } else {
                    individualsOutside += size;
                }
            }

            System.out.println("Caso #" + scen);
            System.out.println(largeGroupsCount + " " + individualsOutside);
        }
        scanner.close();
    }

    private static int dfs(int student) {
        if (visited[student]) return 0;
        visited[student] = true;
        int size = 1; // Count current student
        for (int friend : relations.getOrDefault(student, new ArrayList<>())) {
            size += dfs(friend); // Count this student's friends
        }
        return size;
    }
}