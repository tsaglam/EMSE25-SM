import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int numberOfStudents = scanner.nextInt();
            ArrayList<ArrayList<Integer>> relations = new ArrayList<>();
            // Initialize relations list
            for (int i = 0; i <= numberOfStudents; i++) {
                relations.add(new ArrayList<>());
            }
            // Read relations
            for (int i = 0; i < numberOfStudents; i++) {
                int student = scanner.nextInt();
                int number = scanner.nextInt();
                for (int j = 0; j < number; j++) {
                    int friend = scanner.nextInt();
                    relations.get(student).add(friend);
                    relations.get(friend).add(student); // Since the relationship is mutual
                }
            }

            // Array to keep track of visited nodes
            boolean[] visited = new boolean[numberOfStudents + 1];
            List<Integer> groupSizes = new ArrayList<>();
            for (int i = 1; i <= numberOfStudents; i++) {
                if (!visited[i]) {
                    int size = dfs(i, relations, visited);
                    groupSizes.add(size);
                }
            }

            // Determine the number of groups with 4 or more people and people outside these groups
            int groupsOfFourOrMore = 0;
            int peopleOutside = 0;
            for (Integer size : groupSizes) {
                if (size >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutside += size;
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfFourOrMore + " " + peopleOutside);
        }
    }

    // Depth-First Search to calculate the size of a group
    public static int dfs(int student, ArrayList<ArrayList<Integer>> relations, boolean[] visited) {
        visited[student] = true;
        int size = 1; // Start with the student itself
        for (int friend : relations.get(student)) {
            if (!visited[friend]) {
                size += dfs(friend, relations, visited); // Add the sizes of connected components
            }
        }
        return size;
    }
}