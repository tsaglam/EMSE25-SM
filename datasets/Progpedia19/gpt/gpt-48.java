import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

class SociologyExperiment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cases = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= cases; i++) {
            int studentsCount = Integer.parseInt(scanner.nextLine());

            List<Set<Integer>> relations = new ArrayList<>();
            for (int j = 0; j < studentsCount; j++) {
                relations.add(new HashSet<>());
            }

            for (int j = 0; j < studentsCount; j++) {
                String[] input = scanner.nextLine().split(" ");
                int student = Integer.parseInt(input[0]) - 1;
                for (int k = 2; k < input.length; k++) {
                    int friend = Integer.parseInt(input[k]) - 1;
                    relations.get(student).add(friend);
                    relations.get(friend).add(student); // Because the relationship is mutual
                }
            }

            List<Integer> groupSizes = new ArrayList<>();
            boolean[] visited = new boolean[studentsCount];
            for (int j = 0; j < studentsCount; j++) {
                if (!visited[j]) {
                    int size = dfs(j, relations, visited);
                    groupSizes.add(size);
                }
            }

            int groupsOfFourOrMore = 0;
            int peopleOutsideGroups = 0;
            for (int size : groupSizes) {
                if (size >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutsideGroups += size;
                }
            }

            System.out.println("Caso #" + i);
            System.out.println(groupsOfFourOrMore + " " + peopleOutsideGroups);
        }
        scanner.close();
    }

    private static int dfs(int current, List<Set<Integer>> relations, boolean[] visited) {
        visited[current] = true;
        int size = 1;
        for (int friend : relations.get(current)) {
            if (!visited[friend]) {
                size += dfs(friend, relations, visited);
            }
        }
        return size;
    }
}