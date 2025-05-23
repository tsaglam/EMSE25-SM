import java.util.*;

class SociologyExperiment {

    private static List<Set<Integer>> findGroups(int numStudents, int[][] relationships) {
        List<Set<Integer>> groups = new ArrayList<>();
        boolean[] visited = new boolean[numStudents + 1];

        for (int i = 1; i <= numStudents; i++) {
            if (!visited[i]) {
                Set<Integer> group = new HashSet<>();
                dfs(i, group, relationships, visited);
                groups.add(group);
            }
        }

        return groups;
    }

    private static void dfs(int student, Set<Integer> group, int[][] relationships, boolean[] visited) {
        visited[student] = true;
        group.add(student);

        for (int relatedStudent : relationships[student]) {
            if (!visited[relatedStudent]) {
                dfs(relatedStudent, group, relationships, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();
        for (int s = 1; s <= scenarios; s++) {
            int numStudents = scanner.nextInt();
            int[][] relationships = new int[numStudents + 1][];
            
            for (int i = 0; i < numStudents; i++) {
                int student = scanner.nextInt();
                int numRelations = scanner.nextInt();
                relationships[student] = new int[numRelations];
                for (int j = 0; j < numRelations; j++) {
                    int relatedStudent = scanner.nextInt();
                    relationships[student][j] = relatedStudent;
                }
            }

            // Linking mutual relationships for completeness
            for (int i=1; i <= numStudents; i++) {
                for (int related : relationships[i]) {
                    List<Integer> tempList = new ArrayList<>();
                    for (int backLink : relationships[related]) tempList.add(backLink);
                    // Check if relationship is already bidirectional
                    if (!tempList.contains(i)) {
                        tempList.add(i);
                        relationships[related] = tempList.stream().mapToInt(e -> e).toArray();
                    }
                }
            }

            List<Set<Integer>> groups = findGroups(numStudents, relationships);
            int largeGroups = 0;
            int outside = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    outside += group.size();
                }
            }

            System.out.println("Caso #" + s);
            System.out.println(largeGroups + " " + outside);
        }
        scanner.close();
    }
}