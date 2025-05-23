import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfScenarios = Integer.parseInt(scanner.nextLine());
        for (int scenario = 1; scenario <= numberOfScenarios; scenario++) {
            int n = Integer.parseInt(scanner.nextLine());
            ArrayList<HashSet<Integer>> relations = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                relations.add(new HashSet<>());
            }
            for (int i = 0; i < n; i++) {
                String[] input = scanner.nextLine().split(" ");
                int student = Integer.parseInt(input[0]) - 1;
                for (int j = 2; j < input.length; j++) {
                    int friend = Integer.parseInt(input[j]) - 1;
                    relations.get(student).add(friend);
                    relations.get(friend).add(student);
                }
            }

            ArrayList<HashSet<Integer>> groups = new ArrayList<>();
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    HashSet<Integer> group = new HashSet<>();
                    dfs(i, group, relations, visited);
                    groups.add(group);
                }
            }

            int largeGroups = 0;
            int individualsOutside = 0;
            for (HashSet<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    individualsOutside += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + individualsOutside);
        }
        scanner.close();
    }

    private static void dfs(int current, HashSet<Integer> group, ArrayList<HashSet<Integer>> relations, boolean[] visited) {
        visited[current] = true;
        group.add(current);
        for (int neighbor : relations.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, group, relations, visited);
            }
        }
    }
}