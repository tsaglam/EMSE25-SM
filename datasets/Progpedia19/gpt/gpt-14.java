import java.util.*;

class SociologyExperiment {
    private static List<Set<Integer>> groups;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim());
        for (int i = 1; i <= scenarios; i++) {
            int students = Integer.parseInt(scanner.nextLine().trim());
            groups = new ArrayList<>();
            Map<Integer, List<Integer>> relations = new HashMap<>();

            for (int j = 0; j < students; j++) {
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ");
                int student = Integer.parseInt(parts[0]);
                List<Integer> friends = new ArrayList<>();
                for (int k = 1; k < parts.length; k++) {
                    friends.add(Integer.parseInt(parts[k]));
                }
                relations.put(student, friends);
            }

            for (int student : relations.keySet()) {
                boolean isInGroup = false;
                for (Set<Integer> group : groups) {
                    if (group.contains(student)) {
                        isInGroup = true;
                        break;
                    }
                }
                if (!isInGroup) {
                    Set<Integer> newGroup = new HashSet<>();
                    buildGroup(student, newGroup, relations);
                    groups.add(newGroup);
                }
            }

            int groupOfFourOrMore = 0;
            int peopleOutside = 0;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    groupOfFourOrMore++;
                } else {
                    peopleOutside += group.size();
                }
            }

            System.out.printf("Caso #%d\n", i);
            System.out.println(groupOfFourOrMore + " " + peopleOutside);
        }
    }

    private static void buildGroup(int student, Set<Integer> group, Map<Integer, List<Integer>> relations) {
        if (!group.contains(student)) {
            group.add(student);
            for (int friend : relations.get(student)) {
                buildGroup(friend, group, relations);
            }
        }
    }
}