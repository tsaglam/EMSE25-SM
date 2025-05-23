import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = scanner.nextInt();
            Map<Integer, Set<Integer>> relationships = new HashMap<>();

            for (int i = 0; i < studentsCount; i++) {
                int student = scanner.nextInt();
                int friendsCount = scanner.nextInt();
                relationships.putIfAbsent(student, new HashSet<>());

                for (int j = 0; j < friendsCount; j++) {
                    int friend = scanner.nextInt();
                    relationships.get(student).add(friend);
                    relationships.putIfAbsent(friend, new HashSet<>());
                    relationships.get(friend).add(student);
                }
            }

            List<Set<Integer>> groups = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (int student : relationships.keySet()) {
                if (!visited.contains(student)) {
                    Set<Integer> group = new HashSet<>();
                    dfs(relationships, student, group, visited);
                    groups.add(group);
                }
            }

            int largeGroups = 0;
            int outsideGroups = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups += 1;
                } else {
                    outsideGroups += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + outsideGroups);
        }

        scanner.close();
    }

    public static void dfs(Map<Integer, Set<Integer>> relationships, int current, Set<Integer> group, Set<Integer> visited) {
        visited.add(current);
        group.add(current);

        for (int neighbor : relationships.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(relationships, neighbor, group, visited);
            }
        }
    }
}