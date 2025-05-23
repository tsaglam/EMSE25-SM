import java.util.*;
class GNode {
    public GNode() {
    }

    public ArrayList<Integer> filhos = new ArrayList<Integer>();

    public ArrayList<Integer> DFSresult = new ArrayList<Integer>();

    public int cor = 0;

    public String GNode_callMe_not(double double0, long long1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public GNode() {
        throw new RuntimeException("You'd better not have called me!");
    }
}class Search {
    public Search() {
    }

    public Object Search_callMe_not(boolean boolean0, String string1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public void DFS(GNode inicio, GNode[] listapontos, GNode origem) {
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(1);
        inicio.cor = EXTRACTED_1_OPT.get();
        for (int k = 0; k < inicio.filhos.size(); k++) {
            Optional<Integer> temp_OPT = Optional.of(inicio.filhos.get(k));
            if (origem.DFSresult.contains(temp_OPT.get()) == false) {
                origem.DFSresult.add(temp_OPT.get());
            }
            Optional<GNode> filho_OPT = Optional.of(new GNode());
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(1);
            GNode EXTRACTED_3 = listapontos[temp_OPT.get() - EXTRACTED_4_OPT.get()];
            int EXTRACTED_5 = 0;
            boolean EXTRACTED_2 = EXTRACTED_3.cor == EXTRACTED_5;
            if (EXTRACTED_2) {
                Optional<Integer> EXTRACTED_8_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_7_OPT = Optional.of(temp_OPT.get() - EXTRACTED_8_OPT.get());
                Optional<GNode> EXTRACTED_6_OPT = Optional.of(listapontos[EXTRACTED_7_OPT.get()]);
                filho_OPT = Optional.of(EXTRACTED_6_OPT.get());
            }
            DFS(filho_OPT.get(), listapontos, origem);
        }
    }

    /**
     */
    public Search(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}class sociologia {
    public sociologia() {
    }

    public static void main(String[] args) {
        Optional<Scanner> stdin_OPT = Optional.of(new Scanner(System.in));
        Optional<Integer> numerocasos_OPT = Optional.of(stdin_OPT.get().nextInt());
        for (int contadorcasos = 0; contadorcasos < numerocasos_OPT.get(); contadorcasos++) {
            int numeropessoas = stdin_OPT.get().nextInt();
            Optional<GNode[]> listadenos_OPT = Optional.of(new GNode[numeropessoas]);
            GNode[] listadenosinvertida = new GNode[numeropessoas];
            Optional<Integer> EXTRACTED_29_OPT = Optional.of(0);
            for (int i = EXTRACTED_29_OPT.get(); i < numeropessoas; i++) {
                GNode EXTRACTED_9 = new GNode();
                listadenosinvertida[i] = EXTRACTED_9;
                Optional<GNode> EXTRACTED_30_OPT = Optional.of(listadenosinvertida[i]);
                Optional<Integer> EXTRACTED_31_OPT = Optional.of(i + sociologiaConstants.CONSTANT_1);
                EXTRACTED_30_OPT.get().DFSresult.add(EXTRACTED_31_OPT.get());
            }
            Optional<Integer> EXTRACTED_32_OPT = Optional.of(0);
            for (int contadorpessoas = EXTRACTED_32_OPT.get(); contadorpessoas < numeropessoas; contadorpessoas++) {
                int posicaono = stdin_OPT.get().nextInt();
                Optional<Integer> posicaotemp_OPT = Optional.of(posicaono - 1);
                Optional<GNode> EXTRACTED_47_OPT = Optional.of(new GNode());
                listadenos_OPT.get()[posicaotemp_OPT.get()] = EXTRACTED_47_OPT.get();
                Optional<GNode> EXTRACTED_10_OPT = Optional.of(listadenos_OPT.get()[posicaotemp_OPT.get()]);
                EXTRACTED_10_OPT.get().DFSresult.add(posicaono);
                int numerofilhos = stdin_OPT.get().nextInt();
                int EXTRACTED_48 = 0;
                Optional<Boolean> EXTRACTED_11_OPT = Optional.of(numerofilhos != EXTRACTED_48);
                if (EXTRACTED_11_OPT.get()) {
                    Optional<Integer> EXTRACTED_33_OPT = Optional.of(0);
                    for (int contadorfilhos = EXTRACTED_33_OPT.get(); contadorfilhos < numerofilhos; contadorfilhos++) {
                        Optional<Integer> valortemp_OPT = Optional.of(stdin_OPT.get().nextInt());
                        Optional<Integer> EXTRACTED_49_OPT = Optional.of(1);
                        int valortemptemp = valortemp_OPT.get() - EXTRACTED_49_OPT.get();
                        GNode EXTRACTED_12 = listadenos_OPT.get()[posicaotemp_OPT.get()];
                        EXTRACTED_12.filhos.add(valortemp_OPT.get());
                        Optional<GNode> EXTRACTED_13_OPT = Optional.of(listadenosinvertida[valortemptemp]);
                        EXTRACTED_13_OPT.get().filhos.add(posicaono);
                    }
                }
            }
            Search DFSnormal = new Search();
            for (int contadorpessoas = 0; contadorpessoas < numeropessoas; contadorpessoas++) {
                Optional<GNode> EXTRACTED_14_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                Optional<GNode> EXTRACTED_15_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                DFSnormal.DFS(EXTRACTED_14_OPT.get(), listadenos_OPT.get(), EXTRACTED_15_OPT.get());
                Optional<Integer> EXTRACTED_34_OPT = Optional.of(0);
                for (int resetnos = EXTRACTED_34_OPT.get(); resetnos < numeropessoas; resetnos++) {
                    Optional<GNode> EXTRACTED_16_OPT = Optional.of(listadenos_OPT.get()[resetnos]);
                    Optional<Integer> EXTRACTED_17_OPT = Optional.of(0);
                    EXTRACTED_16_OPT.get().cor = EXTRACTED_17_OPT.get();
                }
            }
            Optional<Search> DFSinvertida_OPT = Optional.of(new Search());
            Optional<Integer> EXTRACTED_35_OPT = Optional.of(0);
            for (int contadorpessoas = EXTRACTED_35_OPT.get(); contadorpessoas < numeropessoas; contadorpessoas++) {
                Optional<GNode> EXTRACTED_18_OPT = Optional.of(listadenosinvertida[contadorpessoas]);
                GNode EXTRACTED_36 = listadenosinvertida[contadorpessoas];
                DFSinvertida_OPT.get().DFS(EXTRACTED_36, listadenosinvertida, EXTRACTED_18_OPT.get());
                for (int resetnos = 0; resetnos < numeropessoas; resetnos++) {
                    Optional<Integer> EXTRACTED_19_OPT = Optional.of(0);
                    GNode EXTRACTED_50 = listadenosinvertida[resetnos];
                    EXTRACTED_50.cor = EXTRACTED_19_OPT.get();
                }
            }
            int contadordegrupos = 0;
            int numerodenosdefora = 0;
            Optional<Integer> EXTRACTED_37_OPT = Optional.of(0);
            for (int contadorpessoas = EXTRACTED_37_OPT.get(); contadorpessoas < numeropessoas; contadorpessoas++) {
                Optional<GNode> EXTRACTED_21_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                Optional<Integer> EXTRACTED_51_OPT = Optional.of(0);
                Optional<Boolean> EXTRACTED_20_OPT = Optional.of(EXTRACTED_21_OPT.get().cor == EXTRACTED_51_OPT.get());
                if (EXTRACTED_20_OPT.get()) {
                    Optional<ArrayList<Integer>> conjuncao_OPT = Optional.of(new ArrayList<Integer>());
                    Optional<GNode> EXTRACTED_52_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                    conjuncao_OPT = Optional.of(EXTRACTED_52_OPT.get().DFSresult);
                    Optional<GNode> EXTRACTED_38_OPT = Optional.of(listadenosinvertida[contadorpessoas]);
                    conjuncao_OPT.get().retainAll(EXTRACTED_38_OPT.get().DFSresult);
                    Optional<Integer> EXTRACTED_39_OPT = Optional.of(0);
                    for (int l = EXTRACTED_39_OPT.get(); l < conjuncao_OPT.get().size(); l++) {
                        Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
                        Optional<GNode> EXTRACTED_41_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                        Optional<Boolean> EXTRACTED_40_OPT = Optional.of(EXTRACTED_41_OPT.get().DFSresult.size() != EXTRACTED_22_OPT.get());
                        if (EXTRACTED_40_OPT.get()) {
                            Optional<Integer> EXTRACTED_23_OPT = Optional.of(1);
                            Optional<Integer> EXTRACTED_53_OPT = Optional.of(1);
                            Optional<Integer> EXTRACTED_42_OPT = Optional.of(conjuncao_OPT.get().get(l) - EXTRACTED_53_OPT.get());
                            Optional<GNode> EXTRACTED_54_OPT = Optional.of(listadenos_OPT.get()[EXTRACTED_42_OPT.get()]);
                            EXTRACTED_54_OPT.get().cor = EXTRACTED_23_OPT.get();
                        }
                    }
                    Optional<Boolean> EXTRACTED_43_OPT = Optional.of(conjuncao_OPT.get().size() >= sociologiaConstants.CONSTANT_2);
                    if (EXTRACTED_43_OPT.get()) {
                        contadordegrupos++;
                    }
                }
            }
            Optional<Integer> EXTRACTED_44_OPT = Optional.of(0);
            for (int contadorpessoas = EXTRACTED_44_OPT.get(); contadorpessoas < numeropessoas; contadorpessoas++) {
                Optional<Integer> EXTRACTED_24_OPT = Optional.of(0);
                Optional<GNode> EXTRACTED_45_OPT = Optional.of(listadenos_OPT.get()[contadorpessoas]);
                boolean EXTRACTED_55 = EXTRACTED_45_OPT.get().cor == EXTRACTED_24_OPT.get();
                if (EXTRACTED_55) {
                    numerodenosdefora++;
                }
            }
            Optional<Integer> EXTRACTED_25_OPT = Optional.of(0);
            if (contadordegrupos == EXTRACTED_25_OPT.get()) {
                numerodenosdefora = numeropessoas;
            }
            Optional<Integer> EXTRACTED_26_OPT = Optional.of(contadorcasos + 1);
            Optional<String> EXTRACTED_46_OPT = Optional.of(sociologiaConstants.CONSTANT_3 + EXTRACTED_26_OPT.get());
            System.out.println(EXTRACTED_46_OPT.get());
            String EXTRACTED_28 = contadordegrupos + " ";
            Optional<String> EXTRACTED_27_OPT = Optional.of(EXTRACTED_28 + numerodenosdefora);
            System.out.println(EXTRACTED_27_OPT.get());
        }
    }

    public int sociologia_callMe_not(Object object0, boolean boolean1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    /**
     */
    public sociologia(Object object0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}