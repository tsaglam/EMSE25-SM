import java.util.*;

class SociologyExperiment {

    private static List<Set<Integer>> groups = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int n = scanner.nextInt();
            
            // Clear groups from previous scenarios
            groups.clear();

            // Initialize all students and their relationships
            List<Integer>[] students = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                students[i] = new ArrayList<>();
                int student = scanner.nextInt(); // Student ID, not used as index matches student
                int numFriends = scanner.nextInt();
                for (int j = 0; j < numFriends; j++) {
                    students[i].add(scanner.nextInt());
                }
            }

            // Find groups
            boolean[] visited = new boolean[n + 1];
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    Set<Integer> group = new HashSet<>();
                    dfs(i, students, visited, group);
                    if(!group.isEmpty()) {
                        groups.add(group);
                    }
                }
            }

            // Count groups with 4 or more people and people outside groups
            int countLargeGroups = 0;
            int peopleOutSideGroups = 0;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    countLargeGroups++;
                } else {
                    peopleOutSideGroups += group.size();
                }
            }
            System.out.println("Caso #" + scenario);
            System.out.println(countLargeGroups + " " + peopleOutSideGroups);
        }
    }

    private static void dfs(int student, List<Integer>[] students, boolean[] visited, Set<Integer> group) {
        visited[student] = true;
        group.add(student);
        
        for (int friend : students[student]) {
            if (!visited[friend]) {
                dfs(friend, students, visited, group);
            }
        }
    }
}