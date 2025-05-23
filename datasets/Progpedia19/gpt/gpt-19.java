import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenarioIndex = 1; scenarioIndex <= scenarios; scenarioIndex++) {
            int numStudents = scanner.nextInt();
            List<Set<Integer>> relations = new ArrayList<>();

            for (int i = 0; i < numStudents; i++) {
                relations.add(new HashSet<>());
            }

            for (int i = 0; i < numStudents; i++) {
                int student = scanner.nextInt() - 1;
                int numFriends = scanner.nextInt();
                for (int j = 0; j < numFriends; j++) {
                    int friend = scanner.nextInt() - 1;
                    relations.get(student).add(friend);
                    relations.get(friend).add(student); // Mutual relationship
                }
            }

            List<Set<Integer>> groups = new ArrayList<>();
            boolean[] visited = new boolean[numStudents];

            for (int i = 0; i < numStudents; i++) {
                if (!visited[i]) {
                    Set<Integer> group = new HashSet<>();
                    dfs(i, relations, visited, group);
                    groups.add(group);
                }
            }

            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutsideGroups += group.size();
                }
            }

            System.out.println("Caso #" + scenarioIndex);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }
    }

    private static void dfs(int student, List<Set<Integer>> relations, boolean[] visited, Set<Integer> group) {
        visited[student] = true;
        group.add(student);
        for (int friend : relations.get(student)) {
            if (!visited[friend]) {
                dfs(friend, relations, visited, group);
            }
        }
    }
}