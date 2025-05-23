import java.util.*;

class SociologyExperiment {
    private static List<Set<Integer>> groups;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim()); // Reads the number of scenarios

        for(int t = 1; t <= scenarios; t++) {
            int students = Integer.parseInt(scanner.nextLine().trim()); // Reads the number of students
            Map<Integer, Set<Integer>> relations = new HashMap<>();
            groups = new ArrayList<>();
            visited = new boolean[students + 1];
            
            // Reads the relationships
            for(int i = 0; i < students; i++) {
                String[] parts = scanner.nextLine().trim().split(" ");
                int student = Integer.parseInt(parts[0]);
                relations.putIfAbsent(student, new HashSet<>());
                for(int j = 2; j < parts.length + 1; j++) {
                    int friend = Integer.parseInt(parts[j-1]);
                    relations.get(student).add(friend);
                    relations.putIfAbsent(friend, new HashSet<>());
                    relations.get(friend).add(student);
                }
            }

            // Process groups
            for(int student: relations.keySet()) {
                if(!visited[student]) {
                    Set<Integer> group = new HashSet<>();
                    dfs(student, relations, group);
                    groups.add(group);
                }
            }

            // Count the number of groups with 4 or more members and people outside
            int countLargeGroups = 0;
            int peopleOutside = 0;
            for(Set<Integer> group: groups) {
                if(group.size() >= 4) countLargeGroups++;
                else peopleOutside += group.size();
            }

            // Output
            System.out.println("Caso #" + t);
            System.out.println(countLargeGroups + " " + peopleOutside);
        }
        scanner.close();
    }

    private static void dfs(int student, Map<Integer, Set<Integer>> relations, Set<Integer> group) {
        visited[student] = true;
        group.add(student);
        for(int friend: relations.get(student)) {
            if(!visited[friend]) {
                dfs(friend, relations, group);
            }
        }
    }
}