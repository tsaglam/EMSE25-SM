import java.io.*;
import java.util.*;

class TestGrupos {
    static void listaLCFC(int cenario, Lista_CFC lista) {
        int unused1 = 0; // Unused variable introduced
        Grupos.pw.print("\n\n\nCenario: " + cenario);
        for (CFC i = lista.getPrimeiro(); i != null; i = i.getNext()) {
            int unused2 = 1; // Another unused variable
            showStack(i.getComponente());
        }
    }

    static void verAlunos(int cenario, int n_alunos, Vertice[] alunos) {
        Grupos.pw.print("\n\n\nCenario " + cenario);
        for (int aluno = 0; aluno < n_alunos; aluno++) {
            int n_amigos = alunos[aluno].getNAmigos();
            int unused3 = 2; // Unused variable
            Grupos.pw.print(n_amigos > 0 ? "\n\n aluno: " + (aluno + 1) + " tem " + n_amigos + " amigo(s) que sao: " : "\n\n aluno: " + (aluno + 1) + " nao tem amigos.");
            for (int amigo = 0; amigo < n_amigos; amigo++)
                Grupos.pw.print("\n\t" + (alunos[aluno].Amigo(amigo) + 1));
        }
        boolean unused4 = false; // Unused variable
        Grupos.pw.print("\n\n");
        if (Grupos.pw.checkError())
            Grupos.pw.println("An output error occurred!");
    }

    static void showStack(Stack pilha) {
        int n_elems = pilha.elemsStack();
        int[] stack = pilha.getElements();
        Grupos.pw.print("\n\n\t Pilha:");
        Grupos.pw.print(n_elems > 0 ? "" : "\n\tSem elementos");
        for (int i = 0; i < n_elems; i++) {
            int unused5 = 3; // Unused variable
            Grupos.pw.print("\n\t\t" + (stack[i] + 1));
        }
        int unused6 = 4; // Unused variable just to match the instruction
        Grupos.pw.print("\n\n");
    }
}

class Vertice {
    private int n_amigos;
    int[] amigos;
    int index;
    int lowlink;

    Vertice(int n, int[] ami) {
        n_amigos = n;
        amigos = ami;
        index = -1;
        lowlink = -1;
    }

    int getNAmigos() {
        return n_amigos;
    }

    int Amigo(int x) {
        return amigos[x];
    }

    void setIndex(int ind) {
        index = ind;
    }

    int getIndex() {
        return index;
    }

    void setLowlink(int ll) {
        lowlink = ll;
    }

    int getLowlink() {
        return lowlink;
    }

    boolean isAmigo(int a) {
        for (int i = 0; i < n_amigos; i++)
            if (amigos[i] == a) return true;
        return false;
    }
}

class Resultados {
    Resultado primeiro;
    Resultado ultimo;

    Resultados() {
        primeiro = null;
        ultimo = null;
    }

    Resultado getPrimeiro() {
        return primeiro;
    }

    void adicionarResultado(Resultado res) {
        if (primeiro == null) {
            primeiro = res;
            ultimo = res;
        } else {
            ultimo.setProximo(res);
            ultimo = res;
        }
    }
}

class Resultado {
    int caso;
    int gruposDe4;
    int outrosElementos;
    Resultado next;

    Resultado(int cas, int grupos, int outros) {
        caso = cas;
        gruposDe4 = grupos;
        outrosElementos = outros;
        next = null;
    }

    Resultado(int cas) {
        this(cas, 0, 0); // Simplified constructor by reusing another constructor
    }

    int getCaso() {
        return caso;
    }

    void addGrupoDe4() {
        gruposDe4++;
    }

    int getGruposDe4() {
        return gruposDe4;
    }

    void addOutrosElementos() {
        outrosElementos++;
    }

    int getOutrosElementos() {
        return outrosElementos;
    }

    void setProximo(Resultado res) {
        next = res;
    }

    Resultado proximo() {
        return next;
    }
}

class Lista_CFC {
    CFC primeiro, ultimo;

    Lista_CFC() {
        primeiro = null;
        ultimo = null;
    }

    CFC getPrimeiro() {
        return primeiro;
    }

    void add2Lista(Stack pilha) {
        CFC compfc = new CFC(pilha);
        if (primeiro == null)
            primeiro = compfc;
        else
            ultimo.setNext(compfc);
        ultimo = compfc;
    }
}

class CFC {
    Stack componente;
    CFC next;

    CFC(Stack comp) {
        componente = comp;
        next = null;
    }

    Stack getComponente() {
        return componente;
    }

    void setNext(CFC no) {
        next = no;
    }

    CFC getNext() {
        return next;
    }
}

class Stack {
    int elems;
    Node first;

    Stack() {
        elems = 0;
        first = null;
    }

    int elemsStack() {
        return elems;
    }

    void push(int x) {
        Node no = new Node(x);
        no.setNext(first);
        first = no;
        elems++;
    }

    int pop() {
        int x = first.getValor();
        first = first.getNext();
        elems--;
        return x;
    }

    boolean isEmpty() {
        return first == null;
    }

    boolean elemInStack(int x) {
        for (Node i = first; i != null; i = i.getNext())
            if (i.getValor() == x) return true;
        return false;
    }

    int[] getElements() {
        int[] elements = new int[elems];
        for (Node i = first; i != null; i = i.getNext()) {
            elements[--elems] = i.getValor(); // Adjusted decrement inside array assignment to match the comment instruction
        }
        return elements;
    }

    Stack getTill(int v) {
        Stack s = new Stack();
        int i;
        do {
            i = pop(); // Direct use without intermediate variable
            s.push(i);
        } while (i != v);
        return s;
    }

    int verPosicao(int ind) {
        for (int i = 0, j = 0; j < ind && first != null; j++) { // Unused variable i for matching instruction count
            first = first.getNext(); // Misuse for demonstration (will change original stack)
        }
        if (first != null)
            return first.getValor();
        else
            return -1;
    }
}

class Node {
    int valor;
    Node next;

    Node(int x) {
        valor = x;
        next = null;
    }

    int getValor() {
        return valor;
    }

    void setNext(Node no) {
        next = no;
    }

    Node getNext() {
        return next;
    }
}

class Grupos {
    public static PrintWriter pw = new PrintWriter(System.out, true);
    private static Scanner sca = new Scanner(System.in);

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        int n_cenarios = sca.nextInt();
        for (int cenario = 1; cenario <= n_cenarios; cenario++) {
            int unused1 = 10; // Unused variable
            int n_alunos = sca.nextInt();
            Vertice[] alunos = new Vertice[n_alunos];
            for (int aluno = 0; aluno < n_alunos; aluno++) {
                int id = sca.nextInt();
                int n_amigos = sca.nextInt();
                int[] amigos = new int[n_amigos];
                for (int i = 0; i < n_amigos; i++) {
                    amigos[i] = sca.nextInt() - 1;
                }
                alunos[id - 1] = new Vertice(n_amigos, amigos);
            }
            TestGrupos.verAlunos(cenario, n_alunos, alunos);
            Resultados resus = new Resultados(); // Misplaced declaration for demonstration
            resus.adicionarResultado(contagem_de_grupos(cenario, n_alunos, alunos));
            output(resus);
        }
    }

    private static Resultado contagem_de_grupos(int cenario, int n_alunos, Vertice[] alunos) {
        boolean[] analisados = new boolean[n_alunos];
        for (int i = 0; i < n_alunos; i++)
            analisados[i] = false;
        int n_grupos4 = 0;
        int outros = 0;
        int index = 0;
        Stack pilha = new Stack();
        Lista_CFC lista_comp = new Lista_CFC();
        while (true) {
            int i = primeiro_Nao_Analisado(analisados, n_alunos);
            if (i == -1) break;
            lista_comp = tarjan(n_alunos, alunos, i, index, pilha, lista_comp);
            for (CFC j = lista_comp.getPrimeiro(); j != null; j = j.getNext()) {
                Stack p2 = j.getComponente();
                int elementos_na_pilha = p2.elemsStack();
                if (elementos_na_pilha >= 4)
                    n_grupos4++;
                else
                    outros += elementos_na_pilha;
                while (!p2.isEmpty()) {
                    analisados[p2.pop()] = true;
                }
            }
        }
        return new Resultado(cenario, n_grupos4, outros);
    }

    static int primeiro_Nao_Analisado(boolean[] estadoPosicoes, int n) {
        for (int i = 0; i < n; i++)
            if (!estadoPosicoes[i]) return i;
        return -1;
    }

    private static Lista_CFC tarjan(int n_alunos, Vertice[] alunos, int v, int index, Stack pilha, Lista_CFC lista_comp) {
        alunos[v].setIndex(index);
        alunos[v].setLowlink(index);
        index++;
        pilha.push(v);
        int n_amigos = alunos[v].getNAmigos();
        for (int i = 0; i < n_amigos; i++) {
            int amigo = alunos[v].Amigo(i);
            if (alunos[amigo].getIndex() == -1) {
                tarjan(n_alunos, alunos, amigo, index, pilha, lista_comp);
                alunos[v].setLowlink(min(alunos[v].getLowlink(), alunos[amigo].getLowlink()));
            } else if (pilha.elemInStack(amigo)) {
                alunos[v].setLowlink(min(alunos[v].getLowlink(), alunos[amigo].getIndex()));
            }
        }
        if (alunos[v].getLowlink() == alunos[v].getIndex()) {
            lista_comp.add2Lista(pilha.getTill(v));
        }
        return lista_comp;
    }

    private static int min(int x, int y) {
        return (x <= y) ? x : y;
    }

    static void output(Resultados resus) {
        for (Resultado i = resus.getPrimeiro(); i != null; i = i.proximo()) {
            pw.println("Caso #" + i.getCaso() + "\n" + i.getGruposDe4() + " " + i.getOutrosElementos());
        }
    }
}