import java.util.*;

class SociologyExperiment {
    private static List<Set<Integer>> findGroups(int n, Map<Integer, Set<Integer>> relations) {
        List<Set<Integer>> groups = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                Set<Integer> group = new HashSet<>();
                dfs(i, group, relations, visited);
                groups.add(group);
            }
        }

        return groups;
    }

    private static void dfs(int student, Set<Integer> group, Map<Integer, Set<Integer>> relations, boolean[] visited) {
        visited[student] = true;
        group.add(student);
        for (int neighbour : relations.get(student)) {
            if (!visited[neighbour]) {
                dfs(neighbour, group, relations, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine());

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> relations = new HashMap<>();

            for (int i = 1; i <= studentsCount; i++) {
                String[] relationInput = scanner.nextLine().split(" ");
                int student = Integer.parseInt(relationInput[0]);
                relations.putIfAbsent(student, new HashSet<>());
                for (int j = 2; j < relationInput.length; j++) {
                    int relatedStudent = Integer.parseInt(relationInput[j]);
                    relations.putIfAbsent(relatedStudent, new HashSet<>());
                    relations.get(student).add(relatedStudent);
                    relations.get(relatedStudent).add(student); // Mutual relationship
                }
            }

            List<Set<Integer>> groups = findGroups(studentsCount, relations);

            int largeGroupsCount = 0;
            int outsidePeopleCount = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroupsCount++;
                } else {
                    outsidePeopleCount += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroupsCount + " " + outsidePeopleCount);
        }

        scanner.close();
    }
}