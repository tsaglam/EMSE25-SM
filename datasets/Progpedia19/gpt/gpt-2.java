import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine());

        for (int s = 0; s < scenarios; s++) {
            int n = Integer.parseInt(scanner.nextLine());
            Map<Integer, Set<Integer>> relationships = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] line = scanner.nextLine().split(" ");
                int student = Integer.parseInt(line[0]);
                Set<Integer> friends = new HashSet<>();

                for (int j = 2; j < line.length; j++) {
                    int friend = Integer.parseInt(line[j]);
                    friends.add(friend);
                    relationships.putIfAbsent(friend, new HashSet<>());
                    relationships.get(friend).add(student);
                }

                relationships.put(student, friends);
            }

            List<Set<Integer>> groups = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            for (int student : relationships.keySet()) {
                if (!visited.contains(student)) {
                    Set<Integer> group = new HashSet<>();
                    exploreGroup(relationships, student, group, visited);
                    groups.add(group);
                }
            }

            int groupsOfFourOrMore = 0;
            int peopleOutside = 0;

            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupsOfFourOrMore++;
                } else {
                    peopleOutside += group.size();
                }
            }

            System.out.println("Caso #" + (s + 1));
            System.out.println(groupsOfFourOrMore + " " + peopleOutside);
        }

        scanner.close();
    }

    private static void exploreGroup(Map<Integer, Set<Integer>> relationships, int student, Set<Integer> group, Set<Integer> visited) {
        group.add(student);
        visited.add(student);

        for (int friend : relationships.get(student)) {
            if (!visited.contains(friend)) {
                exploreGroup(relationships, friend, group, visited);
            }
        }
    }
}