import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RefactoredProblemA {

    public static void main(String[] args) {
        System.out.println("Input: ");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfScenarios = Integer.parseInt(reader.readLine().trim());
            for (int scenario = 1; scenario <= numberOfScenarios; scenario++) {
                int numberOfStudents = Integer.parseInt(reader.readLine().trim());
                int[][] connections = new int[numberOfStudents + 1][numberOfStudents + 1];
                for (int student = 0; student < numberOfStudents; student++) {
                    String[] parts = reader.readLine().split(" ");
                    int studentId = Integer.parseInt(parts[0]);
                    connections[studentId][studentId] = 1; // Mark self-connections
                    for (int j = 2; j < parts.length; j++) {
                        int friendId = Integer.parseInt(parts[j]);
                        connections[studentId][friendId] = 1;
                    }
                }
                analyzeScenario(scenario, connections);
            }
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }

    private static void analyzeScenario(int scenarioNumber, int[][] connections) {
        FloydWarshall(connections);
        List<Set<Integer>> groups = formGroups(connections);
        printResult(scenarioNumber, groups);
    }

    private static void FloydWarshall(int[][] dist) {
        int n = dist.length;
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = 1; // Assume there's a way if both have a connection
                    }
                }
            }
        }
    }

    private static List<Set<Integer>> formGroups(int[][] connections) {
        List<Set<Integer>> groups = new ArrayList<>();
        int n = connections.length;
        boolean[] visited = new boolean[n];

        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                Set<Integer> group = new HashSet<>();
                group.add(i);
                visited[i] = true;
                for (int j = 1; j < n; j++) {
                    if (connections[i][j] == 1 && connections[j][i] == 1 && !visited[j]) {
                        group.add(j);
                        visited[j] = true;
                    }
                }
                groups.add(group);
            }
        }
        return groups;
    }

    private static void printResult(int scenario, List<Set<Integer>> groups) {
        System.out.println("Caso #" + scenario);
        for (Set<Integer> group : groups) {
            System.out.println("Group with " + group.size() + " students.");
        }
    }
}