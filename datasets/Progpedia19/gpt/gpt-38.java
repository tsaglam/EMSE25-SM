import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = scanner.nextInt();

            // Initialize a list to store each student's relations
            List<Set<Integer>> relations = new ArrayList<>();
            for (int i = 0; i <= studentsCount; i++) {
                relations.add(new HashSet<>());
            }

            for (int i = 1; i <= studentsCount; i++) {
                int student = scanner.nextInt();
                int count = scanner.nextInt();
                for (int j = 0; j < count; j++) {
                    int friend = scanner.nextInt();
                    relations.get(student).add(friend);
                    relations.get(friend).add(student);
                }
            }

            // DFS to find all groups
            boolean[] visited = new boolean[studentsCount + 1];
            List<Set<Integer>> groups = new ArrayList<>();
            for (int i = 1; i <= studentsCount; i++) {
                if (!visited[i]) {
                    Set<Integer> group = new HashSet<>();
                    dfs(i, relations, visited, group);
                    groups.add(group);
                }
            }

            // Count groups with four or more members and number of people outside these groups
            int groupsWithFourOrMore = 0;
            int peopleOutside = studentsCount;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupsWithFourOrMore++;
                    peopleOutside -= group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsWithFourOrMore + " " + peopleOutside);
        }
        scanner.close();
    }

    private static void dfs(int current, List<Set<Integer>> relations, boolean[] visited, Set<Integer> group) {
        visited[current] = true;
        group.add(current);

        for (int friend : relations.get(current)) {
            if (!visited[friend]) {
                dfs(friend, relations, visited, group);
            }
        }
    }
}