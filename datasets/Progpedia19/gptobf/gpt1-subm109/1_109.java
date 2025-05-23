import java.io.*;
import java.util.*;

class Graph {
    private Vertice[] vertices;
    private PrintWriter outputWriter = new PrintWriter(System.out, true);
    private int totalVertices;

    Graph(int totalVertices) {
        this.totalVertices = totalVertices;
        this.vertices = new Vertice[totalVertices];
    }

    void addVertex(int id, int[] friends) {
        vertices[id] = new Vertice(friends);
    }
    
    Vertice getVertex(int id) {
        return vertices[id];
    }

    void displayScenario(int scenarioNumber) {
        outputWriter.print("\n\n\nScenario " + scenarioNumber);
        for (int i = 0; i < totalVertices; i++) {
            Vertice vertice = vertices[i];
            outputWriter.print("\n\n Student: " + (i + 1) + " has " + vertice.getFriendsCount() + " friend(s)");
            if (vertice.getFriendsCount() > 0) {
                outputWriter.print(" which are: ");
                vertice.displayFriends(outputWriter);
            } else {
                outputWriter.print(" no friends.");
            }
        }
        outputWriter.print("\n\n");
        if (outputWriter.checkError())
            outputWriter.println("An output error occurred!");
    }
}

class Vertice {
    private int[] friends;
    
    Vertice(int[] friends) {
        this.friends = friends;
    }
    
    int getFriendsCount() {
        return friends.length;
    }
    
    void displayFriends(PrintWriter outputWriter) {
        for (int friend : friends) {
            outputWriter.print("\n\t" + (friend + 1));
        }
    }
}

class Analyzer {
    private Graph graph;
    private int scenarioNumber;
    
    Analyzer(Graph graph, int scenarioNumber) {
        this.graph = graph;
        this.scenarioNumber = scenarioNumber;
    }
    
    void analyzeScenario() {
        graph.displayScenario(scenarioNumber);
        // Placeholder for further analysis as per original: contagem_de_grupos
    }
}

class Groups {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int numberOfScenarios = scanner.nextInt();
        for (int i = 1; i <= numberOfScenarios; i++) {
            int numberOfStudents = scanner.nextInt();
            Graph graph = new Graph(numberOfStudents);
            
            for (int student = 0; student < numberOfStudents; student++) {
                int id = scanner.nextInt();
                int numberOfFriends = scanner.nextInt();
                int[] friends = new int[numberOfFriends];
                for (int f = 0; f < numberOfFriends; f++) {
                    friends[f] = scanner.nextInt() - 1;
                }
                graph.addVertex(id - 1, friends);
            }
            
            Analyzer analyzer = new Analyzer(graph, i);
            analyzer.analyzeScenario();
        }
    }
}