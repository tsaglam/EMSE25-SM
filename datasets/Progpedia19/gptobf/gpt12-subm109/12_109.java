import java.io.*;
import java.util.*;

class Grupos {
    public static PrintWriter pw = new PrintWriter(System.out, true);
    private static Scanner sca = new Scanner(System.in);

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        // Unused variable for demonstration purposes
        int unusedVariable = 100; 
        int n_cenarios = sca.nextInt();
        Resultados resus = new Resultados();
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
    
    // Inserted a totally unused method for the purpose of fulfilling task requirements
    private static void unusedMethod() {
        System.out.println("This is an unused method.");
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
        if (Grupos.pw.checkError())
            Grupos.pw.println("An output error occurred!");
    }

    static void listaLCFC(int cenario, Lista_CFC lista) {
        Grupos.pw.print("\n\n\nCenario: " + cenario);
        for (CFC i = lista.getPrimeiro(); i != null; i = i.getNext())
            showStack(i.getComponente());
    }

    static void showStack(Stack pilha) {
        int n_elems = pilha.elemsStack();
        int[] stack = pilha.getElements();
        Grupos.pw.print("\n\n\t Pilha:");
        if (n_elems > 0) {
            for (int i = 0; i < n_elems; i++)
                Grupos.pw.print("\n\t\t" + (stack[i] + 1));
        } else {
            Grupos.pw.println("\n\tSem elementos");
        }
        Grupos.pw.print("\n\n");
    }

    static void output(Resultados resus) {
        for (Resultado i = resus.getPrimeiro(); i != null; i = i.proximo()) {
            Grupos.pw.println("Caso #" + i.getCaso() + "\n" + i.getGruposDe4() + " " + i.getOutrosElementos());
        }
    }

    static Resultado contagem_de_grupos(int cenario, int n_alunos, Vertice[] alunos) {
        boolean[] analisados = new boolean[n_alunos];
        Lista_CFC lista_comp = new Lista_CFC();
        Stack pilha = new Stack();
        int n_grupos4 = 0, outros = 0, index = 0;
        for (int i = 0; i < n_alunos; i++){
            analisados[i] = false;
            while ((i = primeiro_Nao_Analisado(analisados, n_alunos)) != -1) {
                lista_comp = tarjan(n_alunos, alunos, i, index, pilha, lista_comp);
                for (CFC j = lista_comp.getPrimeiro(); j != null; j = j.getNext()) {
                    Stack p2 = j.getComponente();
                    int elementos_na_pilha = p2.elemsStack();
                    if (elementos_na_pilha >= 4) n_grupos4++;
                    else outros += elementos_na_pilha;
                    while (!p2.isEmpty()) {
                        analisados[p2.pop()] = true;
                    }
                }
            }
        }
        return new Resultado(cenario, n_grupos4, outros);
    }

    static int primeiro_Nao_Analisado(boolean[] estadoPosicoes, int n) {
        for (int i = 0; i < n; i++) {
            if (!estadoPosicoes[i]) return i;
        }
        return -1;
    }

    private static Lista_CFC tarjan(int n_alunos, Vertice[] alunos, int v, int index, Stack pilha, Lista_CFC lista_comp) {
        alunos[v].setIndex(index);
        alunos[v].setLowlink(index++);
        pilha.push(v);
        int n_amigos = alunos[v].getNAmigos();
        for (int i = 0; i < n_amigos; i++) {
            int amigo = alunos[v].Amigo(i);
            if (alunos[amigo].getIndex() == -1) {
                tarjan(n_alunos, alunos, amigo, index, pilha, lista_comp);
                alunos[v].setLowlink(Math.min(alunos[v].getLowlink(), alunos[amigo].getLowlink()));
            } else if (pilha.elemInStack(amigo)) {
                alunos[v].setLowlink(Math.min(alunos[v].getLowlink(), alunos[amigo].getIndex()));
            }
        }
        if (alunos[v].getLowlink() == alunos[v].getIndex()) {
            lista_comp.add2Lista(pilha.getTill(v));
        }
        return lista_comp;
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
        return (n_amigos);
    }
    int Amigo(int x) {
        return (amigos[x]);
    }
    void setIndex(int ind) {
        index = ind;
    }
    int getIndex() {
        return (index);
    }
    void setLowlink(int ll) {
        lowlink = ll;
    }
    int getLowlink() {
        return (lowlink);
    }
    boolean isAmigo(int a) {
        int i;
        for (i = 0; i < n_amigos; i++)
            if (amigos[i] == a)
                return (true);
        return (false);
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
        return (primeiro);
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
        caso = cas;
        gruposDe4 = 0;
        outrosElementos = 0;
        next = null;
    }
    int getCaso() {
        return (caso);
    }
    void addGrupoDe4() {
        gruposDe4++;
    }
    int getGruposDe4() {
        return (gruposDe4);
    }
    void addOutrosElementos() {
        outrosElementos++;
    }
    int getOutrosElementos() {
        return (outrosElementos);
    }
    void setProximo(Resultado res) {
        next = res;
    }
    Resultado proximo() {
        return (next);
    }
}
class Lista_CFC {
    CFC primeiro, ultimo;
    Lista_CFC() {
        primeiro = null;
        ultimo = null;
    }
    CFC getPrimeiro() {
        return (primeiro);
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
        return (componente);
    }
    void setNext(CFC no) {
        next = no;
    }
    CFC getNext() {
        return (next);
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
        return (elems);
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
        return (x);
    }
    boolean isEmpty() {
        return (first == null);
    }
    boolean elemInStack(int x) {
        Node i;
        for (i = first; i != null; i = i.getNext())
            if (i.getValor() == x)
                return (true);
        return (false);
    }
    int[] getElements() {
        int[] elements = new int[elems];
        int j;
        Node i;
        for (i = first, j = elems - 1; i != null; i = i.getNext(), j--) {
            elements[j] = i.getValor();
        }
        return (elements);
    }
    Stack getTill(int v) {
        Node nova;
        int i;
        Stack s = new Stack();
        do {
            i = this.pop();
            s.push(i);
        } while (i != v);
        return (s);
    }
    int verPosicao(int ind) {
        Node j;
        int i;
        for (i = 0, j = first; i < ind && j != null; i++, j = j.getNext());
        if (j != null)
            return (j.getValor());
        else
            return (-1);
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
        return (valor);
    }
    void setNext(Node no) {
        next = no;
    }
    Node getNext() {
        return (next);
    }
}