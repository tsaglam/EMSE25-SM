import java.util.*;

class SociologyExperiment {

    private static List<Set<Integer>> findGroups(int n, List<List<Integer>> relations) {
        Map<Integer, Set<Integer>> groups = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            groups.put(i, new HashSet<>());
            groups.get(i).add(i); // Each person belongs to their own group initially.
        }

        for (List<Integer> relation : relations) {
            int student = relation.get(0);
            Set<Integer> group = groups.get(student);
            for (int i = 1; i < relation.size(); i++) {
                int friend = relation.get(i);
                group.add(friend);
                groups.get(friend).add(student); // Mutual inclusion in each other's group.
            }
        }

        // Merging groups based on shared members.
        boolean merged = true;
        while (merged) {
            merged = false;
            for (int i = 1; i <= n; i++) {
                Set<Integer> groupI = groups.get(i);
                for (int j = i + 1; j <= n; j++) {
                    Set<Integer> groupJ = groups.get(j);
                    if (i != j && !Collections.disjoint(groupI, groupJ)) {
                        groupI.addAll(groupJ);
                        for (Integer member : groupJ) {
                            groups.put(member, groupI); // Joining the groups together.
                        }
                        merged = true;
                    }
                }
            }
        }

        // Building the final list of unique groups.
        return new ArrayList<>(new HashSet<>(groups.values()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int scenarios = Integer.parseInt(scanner.nextLine().trim());

        for (int scenario = 1; scenario <= scenarios; scenario++) {
            int numStudents = Integer.parseInt(scanner.nextLine().trim());
            List<List<Integer>> relations = new ArrayList<>();

            for (int i = 0; i < numStudents; i++) {
                List<Integer> relation = new ArrayList<>();
                String[] parts = scanner.nextLine().trim().split(" ");
                for (String part : parts) {
                    relation.add(Integer.parseInt(part));
                }
                relations.add(relation);
            }

            List<Set<Integer>> groups = findGroups(numStudents, relations);

            // Counting the groups with 4 or more members and people outside these groups.
            int qualifiedGroups = 0, outsidersCount = numStudents;
            for (Set<Integer> group : groups) {
                if (group.size() >= 4) {
                    qualifiedGroups++;
                    outsidersCount -= group.size();
                }
            }

            System.out.println("Caso #" + scenario);
            System.out.println(qualifiedGroups + " " + outsidersCount);
        }
        scanner.close();
    }
}