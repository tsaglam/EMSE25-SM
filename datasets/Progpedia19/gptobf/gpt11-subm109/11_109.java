import java.io.*;
import java.util.*;

class Grupos {
    public static PrintWriter pw = new PrintWriter(System.out, true);
    private static Scanner sca = new Scanner(System.in);

    public static void main(String[] args) {
        Resultados resus = new Resultados();
        int n_cenarios = sca.nextInt();
        for (int cenario = 1; cenario <= n_cenarios; cenario++) {
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
            resus.adicionarResultado(TestGrupos.contagem_de_grupos(cenario, n_alunos, alunos));
        }
        TestGrupos.output(resus);
    }
}

class TestGrupos {
    static void verAlunos(int cenario, int n_alunos, Vertice[] alunos) {
        Grupos.pw.print("\n\n\nCenario " + cenario);
        for (int aluno = 0; aluno < n_alunos; aluno++) {
            int n_amigos = alunos[aluno].getNAmigos();
            if (n_amigos > 0) {
                Grupos.pw.print("\n\n aluno: " + (aluno + 1) + " tem " + n_amigos + " amigo(s) que sao: ");
                for (int amigo = 0; amigo < n_amigos; amigo++)
                    Grupos.pw.print("\n\t" + (alunos[aluno].Amigo(amigo) + 1));
            } else
                Grupos.pw.print("\n\n aluno: " + (aluno + 1) + " nao tem amigos.");
        }
        Grupos.pw.print("\n\n");
    }

    static Resultado contagem_de_grupos(int cenario, int n_alunos, Vertice[] alunos) {
        boolean[] analisados = new boolean[n_alunos];
        Lista_CFC lista_comp = new Lista_CFC();
        int index = 0, n_grupos4 = 0, outros = 0;
        for (int i = 0; i < n_alunos; i++) {
            if (!analisados[i]) {
                lista_comp = tarjan(n_alunos, alunos, i, index, new Stack(), lista_comp);
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
        }
        return new Resultado(cenario, n_grupos4, outros);
    }

    static Lista_CFC tarjan(int n_alunos, Vertice[] alunos, int v, int index, Stack pilha, Lista_CFC lista_comp) {
        Vertice atual = alunos[v];
        atual.setIndex(index);
        atual.setLowlink(index++);
        pilha.push(v);
        int n_amigos = atual.getNAmigos();
        for (int i = 0; i < n_amigos; i++) {
            int amigo = atual.Amigo(i);
            if (alunos[amigo].getIndex() == -1) {
                tarjan(n_alunos, alunos, amigo, index, pilha, lista_comp);
                atual.setLowlink(Math.min(atual.getLowlink(), alunos[amigo].getLowlink()));
            } else if (pilha.elemInStack(amigo))
                atual.setLowlink(Math.min(atual.getLowlink(), alunos[amigo].getIndex()));
        }
        if (atual.getLowlink() == atual.getIndex()) {
            lista_comp.add2Lista(pilha.getTill(v));
        }
        return (lista_comp);
    }

    static void output(Resultados resus) {
        for (Resultado i = resus.getPrimeiro(); i != null; i = i.proximo()) {
            Grupos.pw.println("Caso #" + i.getCaso() + "\n" + i.getGruposDe4() + " " + i.getOutrosElementos());
        }
    }
}

class Resultados {
    private Resultado primeiro, ultimo;

    void adicionarResultado(Resultado res) {
        if (primeiro == null) {
            primeiro = ultimo = res;
        } else {
            ultimo.setProximo(res);
            ultimo = res;
        }
    }

    Resultado getPrimeiro() {
        return primeiro;
    }
}

class Vertice {
    private int n_amigos;
    private int[] amigos;
    private int index = -1;
    private int lowlink = -1;

    Vertice(int n, int[] ami) {
        n_amigos = n;
        amigos = ami;
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
}

class Lista_CFC {
    private CFC primeiro, ultimo;

    void add2Lista(Stack pilha) {
        CFC compfc = new CFC(pilha);
        if (primeiro == null) {
            primeiro = ultimo = compfc;
        } else {
            ultimo.setNext(compfc);
            ultimo = compfc;
        }
    }

    CFC getPrimeiro() {
        return primeiro;
    }
}

class CFC {
    private Stack componente;
    private CFC next;

    CFC(Stack comp) {
        componente = comp;
    }

    void setNext(CFC no) {
        next = no;
    }

    CFC getNext() {
        return next;
    }

    Stack getComponente() {
        return componente;
    }
}

class Stack {
    private int elems = 0;
    private Node first = null;

    boolean isEmpty() {
        return first == null;
    }

    void push(int x) {
        Node no = new Node(x, first);
        first = no;
        elems++;
    }

    int pop() {
        if (isEmpty()) return -1; // Error handling for empty stack
        int x = first.getValor();
        first = first.getNext();
        elems--;
        return x;
    }

    boolean elemInStack(int x) {
        for (Node i = first; i != null; i = i.getNext()) if (i.getValor() == x) return true;
        return false;
    }

    int elemsStack() {
        return elems;
    }

    Stack getTill(int v) {
        Stack s = new Stack();
        int i;
        do {
            i = pop();
            s.push(i);
        } while (i != v && !isEmpty()); // Ensure pop until find v or stack is empty
        return s;
    }

    int[] getElements() {
        int[] elements = new int[elems];
        int j = 0;
        for (Node i = first; i != null; i = i.getNext()) elements[j++] = i.getValor();
        return elements;
    }
}

class Node {
    private int valor;
    private Node next;

    Node(int x, Node nextNode) {
        valor = x;
        next = nextNode;
    }

    int getValor() {
        return valor;
    }

    Node getNext() {
        return next;
    }
}

class Resultado {
    private int caso;
    private int gruposDe4;
    private int outrosElementos;
    private Resultado next;

    Resultado(int cas, int grupos, int outros) {
        caso = cas;
        gruposDe4 = grupos;
        outrosElementos = outros;
    }

    void setProximo(Resultado res) {
        next = res;
    }

    Resultado proximo() {
        return next;
    }

    int getCaso() {
        return caso;
    }

    int getGruposDe4() {
        return gruposDe4;
    }

    int getOutrosElementos() {
        return outrosElementos;
    }
}