import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfScenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= numberOfScenarios; scenario++) {
            int numberOfStudents = scanner.nextInt();
            Map<Integer, Set<Integer>> relationships = new HashMap<>();

            // Read the relationships
            for (int i = 0; i < numberOfStudents; i++) {
                int student = scanner.nextInt();
                int numberOfFriends = scanner.nextInt();
                relationships.putIfAbsent(student, new HashSet<>());
                for (int j = 0; j < numberOfFriends; j++) {
                    int friend = scanner.nextInt();
                    relationships.get(student).add(friend);
                    relationships.putIfAbsent(friend, new HashSet<>());
                    relationships.get(friend).add(student);
                }
            }

            // Find groups
            List<Set<Integer>> groups = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (Integer student : relationships.keySet()) {
                if (!visited.contains(student)) {
                    Set<Integer> group = new HashSet<>();
                    dfs(student, relationships, group, visited);
                    groups.add(group);
                }
            }

            // Count groups with four or more students
            int largeGroups = 0;
            int peopleOutside = 0;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    peopleOutside += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + peopleOutside);
        }
        scanner.close();
    }

    private static void dfs(Integer student, Map<Integer, Set<Integer>> relationships, Set<Integer> group, Set<Integer> visited) {
        visited.add(student);
        group.add(student);

        for (Integer friend : relationships.get(student)) {
            if (!visited.contains(friend)) {
                dfs(friend, relationships, group, visited);
            }
        }
    }
}