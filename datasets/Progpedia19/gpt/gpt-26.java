import java.util.*;

class SociologyExperiment {

    private static List<Set<Integer>> findGroups(List<List<Integer>> relations, int n) {
        List<Set<Integer>> groups = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                Set<Integer> group = new HashSet<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    if (!visited[current]) {
                        visited[current] = true;
                        group.add(current);
                        for (int friend : relations.get(current - 1)) {
                            if (!visited[friend]) {
                                queue.add(friend);
                            }
                        }
                    }
                }
                groups.add(group);
            }
        }

        return groups;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine());

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int students = Integer.parseInt(scanner.nextLine());
            List<List<Integer>> relations = new ArrayList<>();

            for (int i = 0; i < students; i++) {
                String[] parts = scanner.nextLine().split(" ");
                List<Integer> relation = new ArrayList<>();
                for (int j = 2; j < parts.length; j++) {
                    relation.add(Integer.parseInt(parts[j]));
                }
                relations.add(relation);
            }

            List<Set<Integer>> groups = findGroups(relations, students);
            int largeGroups = 0;
            int outsiders = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    largeGroups++;
                } else {
                    outsiders += group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(largeGroups + " " + outsiders);
        }

        scanner.close();
    }
}