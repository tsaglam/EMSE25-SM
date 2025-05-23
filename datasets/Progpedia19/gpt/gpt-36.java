import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class SociologyExperiment {

    private static class Graph {
        private final Map<Integer, List<Integer>> adjList = new HashMap<>();

        public void addEdge(int src, int dest) {
            adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
            adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src);
        }

        public Map<Integer, List<Integer>> getAdjList() {
            return adjList;
        }
    }

    private static void processInputAndPrintOutput(Scanner scanner) {
        int s = scanner.nextInt(); // Scenarios

        for (int i = 1; i <= s; i++) {
            int n = scanner.nextInt(); // Number of students
            Graph graph = new Graph();

            for (int j = 0; j < n; j++) {
                int studentNumber = scanner.nextInt();
                int friendsCount = scanner.nextInt();

                for (int k = 0; k < friendsCount; k++) {
                    int friend = scanner.nextInt();
                    graph.addEdge(studentNumber, friend);
                }
            }

            printGroups(i, graph, n);
        }
    }

    private static void printGroups(int caseNumber, Graph graph, int totalStudents) {
        HashSet<Integer> visited = new HashSet<>();
        int groupCount = 0;
        int outsiders = 0;

        Map<Integer, List<Integer>> adjList = graph.getAdjList();

        for (int student = 1; student <= totalStudents; student++) {
            if (!visited.contains(student)) {
                int groupSize = bfs(adjList, student, visited);
                if (groupSize >= 4) {
                    groupCount++;
                } else {
                    outsiders += groupSize;
                }
            }
        }

        System.out.printf("Caso #%d\n", caseNumber);
        System.out.println(groupCount + " " + outsiders);
    }

    private static int bfs(Map<Integer, List<Integer>> adjList, int start, HashSet<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        int size = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            size++;

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        processInputAndPrintOutput(scanner);
    }
}