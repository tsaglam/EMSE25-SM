import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfScenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= numberOfScenarios; scenario++) {
            int numberOfStudents = scanner.nextInt();
            List<Set<Integer>> relationships = new ArrayList<>();
            for (int i = 0; i < numberOfStudents; i++) {
                int student = scanner.nextInt() - 1;
                int numberOfRelationships = scanner.nextInt();
                Set<Integer> currentSet = new HashSet<>();
                currentSet.add(student);
                for (int j = 0; j < numberOfRelationships; j++) {
                    currentSet.add(scanner.nextInt() - 1);
                }
                relationships.add(currentSet);
            }
            List<Set<Integer>> groups = findGroups(relationships);
            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutsideGroups += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }
        scanner.close();
    }

    private static List<Set<Integer>> findGroups(List<Set<Integer>> relationships) {
        List<Set<Integer>> groups = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < relationships.size(); i++) {
            if (!visited.contains(i)) {
                Set<Integer> group = dfs(i, relationships, new HashSet<>());
                visited.addAll(group);
                groups.add(group);
            }
        }
        return groups;
    }

    private static Set<Integer> dfs(int current, List<Set<Integer>> relationships, Set<Integer> group) {
        group.add(current);
        for (int neighbor : relationships.get(current)) {
            if (!group.contains(neighbor)) {
                dfs(neighbor, relationships, group);
            }
        }
        return group;
    }
}