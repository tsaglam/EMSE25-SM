import java.util.*;

class Enigma {
    Scanner scanner;
    Enigma(Scanner scanner) {
        this.scanner = scanner;
    }

    int VertexCount;
    int islands;
    boolean[] mark;
    LinkedList<Integer> sequence = new LinkedList<>();
    LinkedList<Integer> VertexList = new LinkedList<>();
    HashMap<Integer, Integer> vertexMap = new HashMap<>();
    List<LinkedList<Integer>> graph = new ArrayList<>();
    List<LinkedList<Integer>> reverseGraph = new ArrayList<>();

    int mapVertex(int vertex) {
        if (!vertexMap.containsKey(vertex)) {
            graph.add(new LinkedList<>());
            reverseGraph.add(new LinkedList<>());
            int index = vertexMap.size();
            vertexMap.put(vertex, index);
        }
        return vertexMap.get(vertex);
    }

    void loadData() {
        VertexCount = scanner.nextInt();
        vertexMap.clear();
        graph.clear();
        reverseGraph.clear();
        for (int i = 0; i < VertexCount; i++) {
            int from = mapVertex(scanner.nextInt());
            int connections = scanner.nextInt();
            for (int j = 0; j < connections; j++) {
                int to = mapVertex(scanner.nextInt());
                graph.get(from).add(to);
                reverseGraph.get(to).add(from);
            }
        }
        VertexCount = vertexMap.size();
    }

    void explore(int vertex) {
        if (mark[vertex]) return;
        mark[vertex] = true;
        for (int adjVertex : graph.get(vertex)) {
            if (!mark[adjVertex]) explore(adjVertex);
        }
        sequence.addFirst(vertex);
    }

    void countComponent(int vertex) {
        islands++;
        mark[vertex] = true;
        for (int adjVertex : reverseGraph.get(vertex)) {
            if (!mark[adjVertex]) countComponent(adjVertex);
        }
    }

    void process() {
        sequence.clear();
        mark = new boolean[VertexCount];
        Arrays.fill(mark, false);
        for (int i = 0; i < VertexCount; i++) explore(i);
        Arrays.fill(mark, false);
        int largeIslands = 0, smallIslands = 0;
        for (int vertex : sequence) {
            if (!mark[vertex]) {
                islands = 0;
                countComponent(vertex);
                if (islands >= 4) largeIslands++;
                else smallIslands += islands;
            }
        }
        System.out.printf("%d %d\n", largeIslands, smallIslands);
    }
}

class ProblemAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Enigma enigma = new Enigma(scanner);
        int cases = scanner.nextInt();
        for (int i = 1; i <= cases; i++) {
            System.out.printf("Case#%d\n", i);
            enigma.loadData();
            enigma.process();
        }
    }
}