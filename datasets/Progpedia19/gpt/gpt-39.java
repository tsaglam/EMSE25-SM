import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = scanner.nextInt();
            HashMap<Integer, HashSet<Integer>> relations = new HashMap<>();

            // Reading relationships
            for (int s = 0; s < studentsCount; s++) {
                int student = scanner.nextInt();
                int numOfFriends = scanner.nextInt();
                relations.putIfAbsent(student, new HashSet<>());
                for (int f = 0; f < numOfFriends; f++) {
                    int friend = scanner.nextInt();
                    relations.get(student).add(friend);
                    relations.putIfAbsent(friend, new HashSet<>());
                    relations.get(friend).add(student); // Make the relationship bidirectional
                }
            }

            List<HashSet<Integer>> groups = new ArrayList<>();
            HashSet<Integer> visited = new HashSet<>();

            // Forming groups
            for (int student : relations.keySet()) {
                if (!visited.contains(student)) {
                    HashSet<Integer> group = new HashSet<>();
                    dfs(relations, student, group, visited);
                    groups.add(group);
                }
            }

            // Counting the groups with 4 or more members and students outside those groups
            int largeGroups = 0, outsideGroupStudents = 0;
            for (HashSet<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    outsideGroupStudents += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + outsideGroupStudents);
        }
        scanner.close();
    }

    private static void dfs(HashMap<Integer, HashSet<Integer>> relations, int student, HashSet<Integer> group, HashSet<Integer> visited) {
        visited.add(student);
        group.add(student);
        for (int friend : relations.get(student)) {
            if (!visited.contains(friend)) {
                dfs(relations, friend, group, visited);
            }
        }
    }
}