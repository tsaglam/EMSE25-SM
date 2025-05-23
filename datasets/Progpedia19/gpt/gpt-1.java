import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt(); // Number of scenarios

        for (int caseNumber = 1; caseNumber <= scenarios; caseNumber++) {
            int numStudents = scanner.nextInt(); // Number of students in the scenario
            List<Set<Integer>> friendGroups = new ArrayList<>();

            // Initialize lists to keep track of relations
            for (int i = 0; i <= numStudents; i++) {
                friendGroups.add(new HashSet<>());
            }

            // Read relations
            for (int i = 0; i < numStudents; i++) {
                int student = scanner.nextInt();
                int numFriends = scanner.nextInt();
                for (int j = 0; j < numFriends; j++) {
                    int friend = scanner.nextInt();
                    friendGroups.get(student).add(friend);
                    friendGroups.get(friend).add(student); // Assuming mutual relationship
                }
            }

            // Generate groups
            boolean[] visited = new boolean[numStudents + 1]; // Keeping track of visited students
            List<Set<Integer>> groups = new ArrayList<>();

            for (int i = 1; i <= numStudents; i++) {
                if (!visited[i]) {
                    Set<Integer> group = new HashSet<>();
                    dfs(i, group, friendGroups, visited);
                    groups.add(group);
                }
            }

            // Compute required output
            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = numStudents;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupsOfFourOrMore++;
                    peopleOutsideGroups -= group.size();
                }
            }

            // Output results
            System.out.println("Caso #" + caseNumber);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }

        scanner.close();
    }

    private static void dfs(int student, Set<Integer> group, List<Set<Integer>> friendGroups, boolean[] visited) {
        visited[student] = true;
        group.add(student);
        for (int friend : friendGroups.get(student)) {
            if (!visited[friend]) {
                dfs(friend, group, friendGroups, visited);
            }
        }
    }
}