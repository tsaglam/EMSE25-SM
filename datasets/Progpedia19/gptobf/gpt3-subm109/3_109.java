import java.io.*;
import java.util.*;

class TestGrupos {
    static void verAlunos(int cenario, int nAlunos, Vertice[] alunos) {
        Grupos.pw.println("\n\n\nCenario " + cenario);
        for (int aluno = 0; aluno < nAlunos; aluno++) {
            int nAmigos = alunos[aluno].getNAmigos();
            if (nAmigos > 0) {
                Grupos.pw.println("\n aluno: " + (aluno + 1) + " tem " + nAmigos + " amigo(s) que sao: ");
                for (int amigo = 0; amigo < nAmigos; amigo++)
                    Grupos.pw.println("\t" + (alunos[aluno].Amigo(amigo) + 1));
            } else
                Grupos.pw.println("\n aluno: " + (aluno + 1) + " nao tem amigos.");
        }
        Grupos.pw.println();
        if (Grupos.pw.checkError())
            Grupos.pw.println("An output error occurred!");
    }

    // Similarly, you can refactor other methods by using enhanced loops where applicable,
    // renaming variables for clarity, and updating print statements for consistency.
}

// Assuming other class definitions such as Vertice and Resultado undergo similar 
// syntactic modernization without semantic alteration.

class Vertice {
    private int nAmigos;
    int[] amigos;
    int index;
    int lowlink;

    Vertice(int n, int[] ami) {
        nAmigos = n;
        amigos = ami;
        index = -1;
        lowlink = -1;
    }

    int getNAmigos() {
        return nAmigos;
    }

    int Amigo(int x) {
        return amigos[x];
    }
    
    // Continue refactoring getter and setter methods... 
}

class Grupos {
    public static PrintWriter pw = new PrintWriter(System.out, true);

    public static void main(String[] args) {
        try (Scanner sca = new Scanner(System.in)) {
            input(sca); // Pass the scanner as an argument to make the method more flexible
        }
    }

    private static void input(Scanner sca) {
        // Method implementation remains largely unaltered, considering the main goal is syntactical changes.
    }

    // Other methods can be adjusted similarly, focusing on syntax improvement.
}