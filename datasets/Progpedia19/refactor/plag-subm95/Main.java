import java.io.*;
import java.util.Optional;
import java.util.Scanner;
public class Main {
    public Main() {
    }

    public static void resetCheckedMatrix(boolean[] checkedMatrix, int matrixDim) {
        Optional<Integer> EXTRACTED_1_OPT = Optional.of(0);
        for (int c = EXTRACTED_1_OPT.get(); c < matrixDim; c++)
            checkedMatrix[c] = false;

    }

    public static void resetRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        Optional<Integer> EXTRACTED_2_OPT = Optional.of(0);
        for (int c = EXTRACTED_2_OPT.get(); c < matrixDim; c++) {
            Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
            rcMatrix[c] = EXTRACTED_3_OPT.get();
        }
    }

    public static void fillRelationCountMatrix(boolean[][] matrix, int[] rcMatrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            Optional<Integer> EXTRACTED_4_OPT = Optional.of(0);
            for (int l = EXTRACTED_4_OPT.get(); l < matrixDim; l++) {
                Optional<boolean[]> EXTRACTED_5_OPT = Optional.of(matrix[c]);
                boolean EXTRACTED_7 = EXTRACTED_5_OPT.get()[l];
                if (EXTRACTED_7) {
                    int EXTRACTED_6 = rcMatrix[c];
                    EXTRACTED_6++;
                }
            }
        }
    }

    public static void showRelationCountMatrix(int[] rcMatrix, int matrixDim) {
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
        for (int c = EXTRACTED_8_OPT.get(); c < matrixDim; c++) {
            Optional<String> EXTRACTED_10_OPT = Optional.of(MainConstants.CONSTANT_1 + rcMatrix[c]);
            Optional<String> EXTRACTED_9_OPT = Optional.of(EXTRACTED_10_OPT.get() + "]");
            System.out.print(EXTRACTED_9_OPT.get());
        }
        System.out.println();
    }

    public static void linkMatrix(boolean[][] matrix, int matrixDim) {
        for (int c = 0; c < matrixDim; c++) {
            Optional<Integer> EXTRACTED_11_OPT = Optional.of(0);
            for (int l = EXTRACTED_11_OPT.get(); l < matrixDim; l++) {
                Optional<Boolean> EXTRACTED_14_OPT = Optional.of(matrix[c][l]);
                if (EXTRACTED_14_OPT.get()) {
                    Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
                    for (int colSearch = EXTRACTED_15_OPT.get(); colSearch < matrixDim; colSearch++) {
                        Optional<boolean[]> EXTRACTED_16_OPT = Optional.of(matrix[l]);
                        if (EXTRACTED_16_OPT.get()[colSearch]) {
                            Optional<boolean[]> EXTRACTED_12_OPT = Optional.of(matrix[c]);
                            EXTRACTED_12_OPT.get()[colSearch] = MainConstants.CONSTANT_2;
                        }
                        Optional<boolean[]> EXTRACTED_13_OPT = Optional.of(matrix[colSearch]);
                        boolean EXTRACTED_18 = EXTRACTED_13_OPT.get()[c];
                        if (EXTRACTED_18) {
                            boolean[] EXTRACTED_17 = matrix[colSearch];
                            boolean EXTRACTED_19 = true;
                            EXTRACTED_17[l] = EXTRACTED_19;
                        }
                    }
                }
            }
        }
    }

    public String Main_callMe_not(double double0) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public static void resetMatrix(boolean[][] matrix, int matrixDim) {
        int c;
        int l;
        int EXTRACTED_20 = 0;
        for (c = EXTRACTED_20; c < matrixDim; c++) {
            for (l = 0; l < c; l++) {
                Optional<boolean[]> EXTRACTED_21_OPT = Optional.of(matrix[c]);
                boolean EXTRACTED_22 = false;
                EXTRACTED_21_OPT.get()[l] = EXTRACTED_22;
            }
            Optional<boolean[]> EXTRACTED_23_OPT = Optional.of(matrix[c]);
            boolean EXTRACTED_25 = true;
            EXTRACTED_23_OPT.get()[l] = EXTRACTED_25;
            for (++l; l < matrixDim; l++) {
                Optional<boolean[]> EXTRACTED_24_OPT = Optional.of(matrix[c]);
                boolean EXTRACTED_26 = false;
                EXTRACTED_24_OPT.get()[l] = EXTRACTED_26;
            }
        }
    }

    public static void showMatrix(boolean[][] matrix, int matrixDim) {
        int c;
        int l;
        System.out.print(MainConstants.CONSTANT_3);
        for (c = 0; c < matrixDim; c++) {
            int EXTRACTED_28 = c + MainConstants.CONSTANT_5;
            Optional<String> EXTRACTED_29_OPT = Optional.of("|");
            String EXTRACTED_37 = MainConstants.CONSTANT_4 + EXTRACTED_28;
            Optional<String> EXTRACTED_27_OPT = Optional.of(EXTRACTED_37 + EXTRACTED_29_OPT.get());
            System.out.print(EXTRACTED_27_OPT.get());
        }
        System.out.print(MainConstants.CONSTANT_6);
        int EXTRACTED_30 = 0;
        for (c = EXTRACTED_30; c < matrixDim; c++) {
            Optional<Integer> EXTRACTED_39_OPT = Optional.of(c + 1);
            Optional<String> EXTRACTED_38_OPT = Optional.of("|" + EXTRACTED_39_OPT.get());
            Optional<String> EXTRACTED_40_OPT = Optional.of("|");
            Optional<String> EXTRACTED_31_OPT = Optional.of(EXTRACTED_38_OPT.get() + EXTRACTED_40_OPT.get());
            System.out.print(EXTRACTED_31_OPT.get());
            for (l = 0; l < matrixDim; l++) {
                Optional<Integer> EXTRACTED_35_OPT = Optional.of(0);
                boolean EXTRACTED_41 = matrix[c][l];
                Optional<Integer> EXTRACTED_43_OPT = Optional.of(1);
                int EXTRACTED_34 = (EXTRACTED_41) ? EXTRACTED_43_OPT.get() : EXTRACTED_35_OPT.get();
                Optional<String> EXTRACTED_42_OPT = Optional.of("[");
                String EXTRACTED_33 = EXTRACTED_42_OPT.get() + EXTRACTED_34;
                String EXTRACTED_44 = "]";
                String EXTRACTED_32 = EXTRACTED_33 + EXTRACTED_44;
                System.out.print(EXTRACTED_32);
            }
            Optional<String> EXTRACTED_36_OPT = Optional.of("\n");
            System.out.print(EXTRACTED_36_OPT.get());
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws IOException {
        Optional<InputStreamReader> converter_OPT = Optional.of(new InputStreamReader(System.in));
        Optional<Scanner> scanner_OPT = Optional.of(new Scanner(converter_OPT.get()));
        Optional<Integer> nSituations_OPT = Optional.of(scanner_OPT.get().nextInt());
        for (int s = 1; s <= nSituations_OPT.get(); s++) {
            Optional<Integer> matrixDim_OPT = Optional.of(scanner_OPT.get().nextInt());
            boolean[][] matrix = new boolean[matrixDim_OPT.get()][matrixDim_OPT.get()];
            resetMatrix(matrix, matrixDim_OPT.get());
            Optional<Integer> EXTRACTED_45_OPT = Optional.of(0);
            for (int i = EXTRACTED_45_OPT.get(); i < matrixDim_OPT.get(); i++) {
                Optional<Integer> index_OPT = Optional.of(scanner_OPT.get().nextInt());
                Optional<Integer> relations_OPT = Optional.of(scanner_OPT.get().nextInt());
                Optional<Integer> EXTRACTED_67_OPT = Optional.of(1);
                for (int j = EXTRACTED_67_OPT.get(); j <= relations_OPT.get(); j++) {
                    Optional<Integer> c_OPT = Optional.of(scanner_OPT.get().nextInt());
                    int EXTRACTED_48 = 1;
                    int EXTRACTED_47 = index_OPT.get() - EXTRACTED_48;
                    Optional<boolean[]> EXTRACTED_46_OPT = Optional.of(matrix[EXTRACTED_47]);
                    int EXTRACTED_68 = 1;
                    Optional<Integer> EXTRACTED_49_OPT = Optional.of(c_OPT.get() - EXTRACTED_68);
                    Optional<Boolean> EXTRACTED_61_OPT = Optional.of(true);
                    EXTRACTED_46_OPT.get()[EXTRACTED_49_OPT.get()] = EXTRACTED_61_OPT.get();
                }
            }
            linkMatrix(matrix, matrixDim_OPT.get());
            Optional<int[]> rcMatrix_OPT = Optional.of(new int[matrixDim_OPT.get()]);
            Optional<boolean[]> checkedMatrix_OPT = Optional.of(new boolean[matrixDim_OPT.get()]);
            resetRelationCountMatrix(rcMatrix_OPT.get(), matrixDim_OPT.get());
            resetCheckedMatrix(checkedMatrix_OPT.get(), matrixDim_OPT.get());
            fillRelationCountMatrix(matrix, rcMatrix_OPT.get(), matrixDim_OPT.get());
            int nGroups = 0;
            Optional<Integer> nOut_OPT = Optional.of(0);
            Optional<Integer> EXTRACTED_50_OPT = Optional.of(0);
            for (int c = EXTRACTED_50_OPT.get(); c < matrixDim_OPT.get(); c++) {
                Optional<Boolean> EXTRACTED_51_OPT = Optional.of(checkedMatrix_OPT.get()[c]);
                if (EXTRACTED_51_OPT.get())
                    continue;

                Optional<Integer> nRelationsC_OPT = Optional.of(rcMatrix_OPT.get()[c]);
                int c1;
                int nElements = 1;
                for (c1 = 0; c1 < matrixDim_OPT.get(); c1++) {
                    Optional<Boolean> EXTRACTED_54_OPT = Optional.of(checkedMatrix_OPT.get()[c1]);
                    boolean EXTRACTED_53 = !EXTRACTED_54_OPT.get();
                    Optional<Boolean> EXTRACTED_55_OPT = Optional.of(c != c1);
                    Optional<Boolean> EXTRACTED_52_OPT = Optional.of(EXTRACTED_53 && EXTRACTED_55_OPT.get());
                    if (EXTRACTED_52_OPT.get()) {
                        Optional<Integer> nRelationsC1_OPT = Optional.of(rcMatrix_OPT.get()[c1]);
                        boolean EXTRACTED_62 = nRelationsC_OPT.get() == nRelationsC1_OPT.get();
                        if (EXTRACTED_62) {
                            boolean equal = true;
                            Optional<Integer> EXTRACTED_56_OPT = Optional.of(0);
                            for (int l = EXTRACTED_56_OPT.get(); l < matrixDim_OPT.get(); l++) {
                                boolean[] EXTRACTED_59 = matrix[c1];
                                Optional<Boolean> EXTRACTED_58_OPT = Optional.of(EXTRACTED_59[l]);
                                Optional<boolean[]> EXTRACTED_64_OPT = Optional.of(matrix[c]);
                                Optional<Boolean> EXTRACTED_63_OPT = Optional.of(EXTRACTED_64_OPT.get()[l]);
                                boolean EXTRACTED_57 = EXTRACTED_63_OPT.get() == EXTRACTED_58_OPT.get();
                                equal &= EXTRACTED_57;
                                Optional<Boolean> EXTRACTED_65_OPT = Optional.of(!equal);
                                if (EXTRACTED_65_OPT.get())
                                    break;

                            }
                            if (equal) {
                                Optional<Boolean> EXTRACTED_69_OPT = Optional.of(true);
                                checkedMatrix_OPT.get()[c] = EXTRACTED_69_OPT.get();
                                Optional<Boolean> EXTRACTED_70_OPT = Optional.of(true);
                                checkedMatrix_OPT.get()[c1] = EXTRACTED_70_OPT.get();
                                nElements++;
                            }
                        }
                    }
                }
                boolean EXTRACTED_60 = nElements < MainConstants.CONSTANT_7;
                if (!EXTRACTED_60) {
                    nGroups++;
                } else {
                    nOut_OPT = Optional.of(nElements);
                }
            }
            String EXTRACTED_66 = ((((MainConstants.CONSTANT_8 + s) + "\n") + nGroups) + MainConstants.CONSTANT_9) + nOut_OPT.get();
            System.out.println(EXTRACTED_66);
        }
    }

    /**
     */
    public Main() {
        throw new RuntimeException("You'd better not have called me!");
    }
}