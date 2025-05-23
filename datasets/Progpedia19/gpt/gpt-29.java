import java.util.*;

class SociologyExperiment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = scanner.nextInt();

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int studentsCount = scanner.nextInt();
            ArrayList<HashSet<Integer>> connectionsList = new ArrayList<>();

            for (int i = 0; i < studentsCount; i++) {
                int studentId = scanner.nextInt() - 1; // Adjusting ID to be index-based
                int numberOfConnections = scanner.nextInt();
                HashSet<Integer> connections = new HashSet<>();
                connections.add(studentId); // Adding self

                for (int j = 0; j < numberOfConnections; j++) {
                    int friendId = scanner.nextInt() - 1; // Adjusting ID to index-based
                    connections.add(friendId);
                }

                connectionsList.add(connections);
            }

            // Merging groups based on shared connections
            for (int i = 0; i < connectionsList.size(); i++) {
                for (int j = i + 1; j < connectionsList.size(); j++) {
                    HashSet<Integer> group1 = connectionsList.get(i);
                    HashSet<Integer> group2 = connectionsList.get(j);

                    for (Integer member : group1) {
                        if (group2.contains(member)) {
                            group1.addAll(group2);
                            group2.addAll(group1);
                            break;
                        }
                    }
                }
            }

            // Counting unique groups and their sizes
            HashSet<HashSet<Integer>> uniqueGroups = new HashSet<>(connectionsList);
            int[] counters = new int[studentsCount + 1]; // Counters for group sizes

            for (HashSet<Integer> group : uniqueGroups) {
                counters[group.size()]++;
            }

            int groupsOfFourOrMore = 0;
            int individualsOutsideGroups = counters[1]; // Count of individuals outside groups (size 1 groups)

            for (int k = 4; k < counters.length; k++) { // Four or more
                groupsOfFourOrMore += counters[k];
            }

            System.out.println("Caso #" + scenario);
            System.out.println(groupsOfFourOrMore + " " + individualsOutsideGroups);
        }

        scanner.close();
    }
}