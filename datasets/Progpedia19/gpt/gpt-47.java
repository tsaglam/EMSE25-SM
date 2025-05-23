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
        int scenarios = Integer.parseInt(scanner.nextLine());
        
        for (int caseNumber = 1; caseNumber <= scenarios; caseNumber++) {
            int studentsCount = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> relations = new HashMap<>();
            
            for (int i = 0; i < studentsCount; i++) {
                String[] parts = scanner.nextLine().split(" ");
                int studentId = Integer.parseInt(parts[0]);
                relations.putIfAbsent(studentId, new HashSet<>());
                
                for (int j = 2; j < parts.length; j++) {
                    int friendId = Integer.parseInt(parts[j]);
                    relations.get(studentId).add(friendId);
                    relations.putIfAbsent(friendId, new HashSet<>());
                    relations.get(friendId).add(studentId);
                }
            }

            List<Set<Integer>> groups = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            
            for (int studentId : relations.keySet()) {
                if (!visited.contains(studentId)) {
                    Set<Integer> group = new HashSet<>();
                    dfs(relations, studentId, group, visited);
                    groups.add(group);
                }
            }
            
            int largeGroups = 0;
            int outsiders = 0;
            
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    outsiders += group.size();
                }
            }
            
            System.out.println("Caso #" + caseNumber);
            System.out.println(largeGroups + " " + outsiders);
        }

        scanner.close();
    }
    
    private static void dfs(Map<Integer, Set<Integer>> relations, int current, Set<Integer> group, Set<Integer> visited) {
        visited.add(current);
        group.add(current);
        for (int friend : relations.get(current)) {
            if (!visited.contains(friend)) {
                dfs(relations, friend, group, visited);
            }
        }
    }
}