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
        
        for (int scenarioIndex = 1; scenarioIndex <= numberOfScenarios; scenarioIndex++) {
            int numberOfStudents = scanner.nextInt();
            Map<Integer, Set<Integer>> studentRelations = new HashMap<>();
            for (int i = 0; i < numberOfStudents; i++) {
                int studentId = scanner.nextInt();
                int numberOfFriends = scanner.nextInt();
                studentRelations.putIfAbsent(studentId, new HashSet<>());
                
                for (int j = 0; j < numberOfFriends; j++) {
                    int friendId = scanner.nextInt();
                    studentRelations.get(studentId).add(friendId);
                    
                    studentRelations.putIfAbsent(friendId, new HashSet<>());
                    studentRelations.get(friendId).add(studentId);
                }
            }
            
            List<Set<Integer>> groups = findGroups(studentRelations);
            int largeGroups = 0;
            int peopleOutside = 0;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    peopleOutside += group.size();
                }
            }
            System.out.println("Caso #" + scenarioIndex);
            System.out.println(largeGroups + " " + peopleOutside);
        }
        
        scanner.close();
    }

    private static List<Set<Integer>> findGroups(Map<Integer, Set<Integer>> studentRelations) {
        List<Set<Integer>> groups = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        
        for (Integer student : studentRelations.keySet()) {
            if (!visited.contains(student)) {
                Set<Integer> group = new HashSet<>();
                dfs(student, studentRelations, visited, group);
                groups.add(group);
            }
        }
        return groups;
    }

    private static void dfs(Integer student, Map<Integer, Set<Integer>> studentRelations, Set<Integer> visited, Set<Integer> group) {
        visited.add(student);
        group.add(student);
        
        for (Integer friend : studentRelations.get(student)) {
            if (!visited.contains(friend)) {
                dfs(friend, studentRelations, visited, group);
            }
        }
    }
}