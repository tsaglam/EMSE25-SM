import java.util.*;
class Sociologia {
    public Sociologia() {
    }

    public static void main(String[] args) {
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> ncenarios_OPT = Optional.of(stdin_OPT.get().nextInt());
        for (int i = 0; i < ncenarios_OPT.get(); i++) {
            analisaCenario(stdin_OPT.get(), i);
        }
    }

    static void analisaCenario(Scanner stdin, int indcenario) {
        Optional<Integer> nalunos_OPT = Optional.of(stdin.nextInt());
        Grafo cenario = new Grafo(nalunos_OPT.get());
        for (int i = 0; i < nalunos_OPT.get(); i++) {
            Optional<Integer> id_OPT = Optional.of(stdin.nextInt() - SociologiaConstants.CONSTANT_1);
            analisaAluno(cenario, id_OPT.get(), stdin);
        }
        int EXTRACTED_1 = 1;
        System.out.printf(SociologiaConstants.CONSTANT_2, indcenario + EXTRACTED_1);
        contaGrupos(cenario);
    }

    public double Sociologia_callMe_not(Object object0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    static void analisaAluno(Grafo cenario, int id, Scanner stdin) {
        int namigos = stdin.nextInt();
        for (int i = 0; i < namigos; i++) {
            Optional<Integer> idamigo_OPT = Optional.of(stdin.nextInt() - 1);
            Vertex amigo = cenario.vertices[idamigo_OPT.get()];
            cenario.vertices[id].arcosadj.add(new Arco(amigo));
        }
    }

    static void contaGrupos(Grafo cenario) {
        int ngrupos4oumais = 0;
        int npessoasoutros = 0;
        Stack<Vertex> s = new Stack<Vertex>();
        boolean EXTRACTED_2 = s.size() < cenario.vertices.length;
        while (EXTRACTED_2) {
            Optional<Vertex> u_OPT = Optional.of(findNonStacked(cenario));
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(1);
            cenario.dfsVisit(u_OPT.get(), s, EXTRACTED_3_OPT.get(), SociologiaConstants.CONSTANT_3);
        } 
        cenario.reverteArcos();
        while (!s.isEmpty()) {
            Vertex u = s.pop();
            if (u.stacked == true) {
                Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
                int npessoasgrupo = cenario.dfsVisit(u, s, EXTRACTED_4_OPT.get(), SociologiaConstants.CONSTANT_4);
                boolean EXTRACTED_5 = npessoasgrupo >= SociologiaConstants.CONSTANT_5;
                if (!EXTRACTED_5) {
                    Optional<Integer> EXTRACTED_6_OPT = Optional.of(npessoasoutros + npessoasgrupo);
                    npessoasoutros = EXTRACTED_6_OPT.get();
                } else
                    ngrupos4oumais++;

            }
        } 
        System.out.printf(SociologiaConstants.CONSTANT_6, ngrupos4oumais, npessoasoutros);
    }

    static Vertex findNonStacked(Grafo cenario) {
        for (int i = 0; i < cenario.vertices.length; i++) {
            Optional<Boolean> EXTRACTED_8_OPT = Optional.of(false);
            Optional<Sociologia.Vertex> EXTRACTED_10_OPT = Optional.of(cenario.vertices[i]);
            Optional<Boolean> EXTRACTED_7_OPT = Optional.of(EXTRACTED_10_OPT.get().stacked == EXTRACTED_8_OPT.get());
            if (EXTRACTED_7_OPT.get()) {
                Optional<Sociologia.Vertex> EXTRACTED_9_OPT = Optional.of(cenario.vertices[i]);
                return EXTRACTED_9_OPT.get();
            }
        }
        return null;
    }

    static class Grafo {
        Vertex[] vertices;

        Grafo(int n) {
            Optional<Vertex[]> EXTRACTED_11_OPT = Optional.of(new Vertex[n]);
            vertices = EXTRACTED_11_OPT.get();
            for (int i = 0; i < n; i++) {
                vertices[i] = new Vertex(i);
            }
        }

        public int dfsVisit(Vertex u, Stack<Vertex> s, int npessoasgrupo, boolean primvolta) {
            u.color = Vertex.Color.gray;
            for (int i = 0; i < u.arcosadj.size(); i++) {
                Optional<Boolean> EXTRACTED_12_OPT = Optional.of(u.arcosadj.get(i).nofinal.color == Vertex.Color.white);
                if (EXTRACTED_12_OPT.get()) {
                    Vertex v = u.arcosadj.get(i).nofinal;
                    npessoasgrupo++;
                    npessoasgrupo = dfsVisit(v, s, npessoasgrupo, primvolta);
                }
            }
            u.color = Vertex.Color.black;
            Optional<Boolean> EXTRACTED_14_OPT = Optional.of(true);
            boolean EXTRACTED_13 = primvolta == EXTRACTED_14_OPT.get();
            if (EXTRACTED_13) {
                s.push(u);
                u.stacked = true;
            }
            Optional<Boolean> EXTRACTED_15_OPT = Optional.of(false);
            if (primvolta == EXTRACTED_15_OPT.get()) {
                Optional<Boolean> EXTRACTED_16_OPT = Optional.of(false);
                u.stacked = EXTRACTED_16_OPT.get();
            }
            return npessoasgrupo;
        }

        public void reverteArcos() {
            Optional<Integer> EXTRACTED_17_OPT = Optional.of(0);
            for (int i = EXTRACTED_17_OPT.get(); i < this.vertices.length; i++) {
                List<Arco> toRemove = new LinkedList<Sociologia.Arco>();
                Optional<Sociologia.Grafo> EXTRACTED_22_OPT = Optional.of(this);
                for (int j = 0; j < EXTRACTED_22_OPT.get().vertices[i].arcosadj.size(); j++) {
                    Sociologia.Vertex EXTRACTED_18 = this.vertices[i];
                    Arco actual = EXTRACTED_18.arcosadj.get(j);
                    boolean EXTRACTED_20 = false;
                    Optional<Boolean> EXTRACTED_19_OPT = Optional.of(actual.processed == EXTRACTED_20);
                    if (EXTRACTED_19_OPT.get()) {
                        Sociologia.Vertex EXTRACTED_23 = this.vertices[i];
                        Optional<Arco> novo_OPT = Optional.of(new Arco(EXTRACTED_23));
                        boolean EXTRACTED_24 = true;
                        novo_OPT.get().processed = EXTRACTED_24;
                        Optional<Sociologia.Grafo> EXTRACTED_26_OPT = Optional.of(this);
                        Optional<Sociologia.Vertex> EXTRACTED_25_OPT = Optional.of(EXTRACTED_26_OPT.get().vertices[actual.nofinal.id]);
                        EXTRACTED_25_OPT.get().arcosadj.add(novo_OPT.get());
                        toRemove.add(actual);
                    }
                }
                for (Arco arco : toRemove) {
                    Sociologia.Grafo EXTRACTED_21 = this;
                    EXTRACTED_21.vertices[i].arcosadj.remove(arco);
                }
            }
            for (int i = 0; i < this.vertices.length; i++) {
                Optional<Sociologia.Grafo> EXTRACTED_28_OPT = Optional.of(this);
                Optional<Sociologia.Vertex> EXTRACTED_27_OPT = Optional.of(EXTRACTED_28_OPT.get().vertices[i]);
                EXTRACTED_27_OPT.get().color = Vertex.Color.white;
            }
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            for (Vertex v : this.vertices) {
                String EXTRACTED_30 = "v = ";
                Optional<String> EXTRACTED_29_OPT = Optional.of((EXTRACTED_30 + v.id) + SociologiaConstants.CONSTANT_7);
                sb.append(EXTRACTED_29_OPT.get());
                for (Arco a : v.arcosadj) {
                    String EXTRACTED_31 = SociologiaConstants.CONSTANT_8 + a.nofinal.id;
                    sb.append(EXTRACTED_31 + "\n");
                }
            }
            return sb.toString();
        }
    }

    static class Vertex {
        enum Color {

            white,
            gray,
            black;
        }

        int id;

        Color color;

        boolean stacked;

        LinkedList<Arco> arcosadj;

        Vertex(int i) {
            id = i;
            color = Color.white;
            Optional<Boolean> EXTRACTED_32_OPT = Optional.of(false);
            stacked = EXTRACTED_32_OPT.get();
            Optional<LinkedList<Arco>> EXTRACTED_33_OPT = Optional.of(new LinkedList<Arco>());
            arcosadj = EXTRACTED_33_OPT.get();
        }
    }

    static class Arco {
        boolean processed;

        Vertex nofinal;

        Arco(Vertex n) {
            processed = false;
            nofinal = n;
        }
    }

    /**
     */
    public Sociologia(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}