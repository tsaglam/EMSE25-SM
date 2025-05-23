import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class SociologyExperiment {
    private static final Map<Integer, Set<Integer>> studentRelations = new HashMap<>();
    private static final List<Set<Integer>> groups = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int scenarios = scanner.nextInt();
        
        for (int i = 1; i <= scenarios; i++) {
            int numberOfStudents = scanner.nextInt();
            studentRelations.clear();
            groups.clear();
            
            for (int j = 0; j < numberOfStudents; j++) {
                int studentId = scanner.nextInt();
                int count = scanner.nextInt();
                Set<Integer> related = studentRelations.computeIfAbsent(studentId, k -> new HashSet<>());
                
                for (int k = 0; k < count; k++) {
                    int relatedStudent = scanner.nextInt();
                    related.add(relatedStudent);
                    studentRelations.computeIfAbsent(relatedStudent, x -> new HashSet<>()).add(studentId);
                }
            }
            
            for (Integer student : studentRelations.keySet()) {
                findOrCreateGroup(student);
            }
            
            int largeGroups = 0;
            int isolatedStudents = 0;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    isolatedStudents += group.size();
                }
            }
            
            System.out.println("Caso #" + i);
            System.out.println(largeGroups + " " + isolatedStudents);
        }
        
        scanner.close();
    }
    
    private static void findOrCreateGroup(Integer studentId) {
        Set<Integer> group = getGroupOf(studentId);
        
        if (group == null) {
            group = new HashSet<>();
            groups.add(group);
        }
        
        group.add(studentId);
        for (Integer relatedStudent : new HashSet<>(studentRelations.get(studentId))) {
            if (!group.contains(relatedStudent)) {
                studentRelations.get(studentId).remove(relatedStudent); // Avoid infinite recursion
                studentRelations.get(relatedStudent).remove(studentId); // Mutually remove to stop recursion
                findOrCreateGroup(relatedStudent);
                group.add(relatedStudent);
            }
        }
    }
    
    private static Set<Integer> getGroupOf(Integer studentId) {
        for (Set<Integer> group : groups) {
            if (group.contains(studentId)) {
                return group;
            }
        }
        return null;
    }
}