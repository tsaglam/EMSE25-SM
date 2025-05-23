import java.util.*;

class SociologyExperiment {
    
    static Map<Integer, Set<Integer>> studentFriendsMap;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim()); // Number of scenarios
        
        for (int i = 1; i <= scenarios; i++) {
            int numStudents = Integer.parseInt(scanner.nextLine().trim()); // Number of students
            
            studentFriendsMap = new HashMap<>();
            for (int j = 0; j < numStudents; j++) {
                String[] studentInfo = scanner.nextLine().trim().split(" ");
                int student = Integer.parseInt(studentInfo[0]);
                studentFriendsMap.putIfAbsent(student, new HashSet<>());
                
                for (int k = 2; k < studentInfo.length; k++) {
                    int friend = Integer.parseInt(studentInfo[k]);
                    studentFriendsMap.get(student).add(friend);
                    studentFriendsMap.putIfAbsent(friend, new HashSet<>());
                    studentFriendsMap.get(friend).add(student); // Mutual relationship
                }
            }

            visited = new boolean[numStudents + 1];
            List<Integer> groupSizes = new ArrayList<>();
            
            for (int student : studentFriendsMap.keySet()) {
                int size = dfs(student);
                if (size > 0) {
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
    
    // Depth-First Search to find connected components (i.e., friends groups)
    private static int dfs(int student) {
        if (visited[student]) 
            return 0;
        
        visited[student] = true;
        int size = 1; // count self
        
        for (int friend : studentFriendsMap.get(student)) {
            if (!visited[friend]) {
                size += dfs(friend);
            }
        }
        
        return size;
    }
}