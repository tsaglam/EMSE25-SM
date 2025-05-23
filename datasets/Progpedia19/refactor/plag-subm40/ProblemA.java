import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
public class ProblemA {
    public boolean ProblemA_callMe_not(Object object0, Object object1) {
        throw new RuntimeException("You'd better not have called me!");
    }

    public ProblemA() {
    }

    private static int NumberOfStudents = 0;

    private static int pcase = 1;

    public static String inputd = "";

    public static String readString() {
        Optional<Integer> ch_OPT;
        String r = "";
        Optional<Boolean> done_OPT = Optional.of(false);
        while (!done_OPT.get()) {
            try {
                ch_OPT = Optional.of(System.in.read());
                Optional<Integer> EXTRACTED_3_OPT = Optional.of(0);
                boolean EXTRACTED_4 = ch_OPT.get() == ProblemAConstants.CONSTANT_1;
                Optional<Boolean> EXTRACTED_6_OPT = Optional.of(ch_OPT.get() < EXTRACTED_3_OPT.get());
                Optional<Boolean> EXTRACTED_5_OPT = Optional.of(EXTRACTED_6_OPT.get() || EXTRACTED_4);
                if (!EXTRACTED_5_OPT.get()) {
                    Optional<Boolean> EXTRACTED_1_OPT = Optional.of(ch_OPT.get() != ProblemAConstants.CONSTANT_3);
                    if (EXTRACTED_1_OPT.get()) {
                        String EXTRACTED_2 = r + ch_OPT.get();
                        r = EXTRACTED_2;
                    }
                } else {
                    done_OPT = Optional.of(ProblemAConstants.CONSTANT_2);
                }
            } catch (IOException e) {
                Optional<Boolean> EXTRACTED_7_OPT = Optional.of(true);
                done_OPT = Optional.of(EXTRACTED_7_OPT.get());
            }
        } 
        return r;
    }

    public static void main(String[] args) {
        System.out.println(ProblemAConstants.CONSTANT_4);
        inputd = readString();
        Optional<String[]> Data_OPT;
        Data_OPT = Optional.of(inputd.split(ProblemAConstants.CONSTANT_5));
        Optional<Integer> EXTRACTED_8_OPT = Optional.of(0);
        for (int linenumber = EXTRACTED_8_OPT.get(); linenumber < Data_OPT.get().length; linenumber++) {
            int EXTRACTED_10 = 0;
            Optional<Boolean> EXTRACTED_9_OPT = Optional.of(linenumber == EXTRACTED_10);
            if (!EXTRACTED_9_OPT.get()) {
                while (ProblemAConstants.NumberOfScenarios > 0) {
                    Optional<String> EXTRACTED_17_OPT = Optional.of(Data_OPT.get()[linenumber]);
                    NumberOfStudents = Integer.parseInt(EXTRACTED_17_OPT.get().trim());
                    int EXTRACTED_12 = 1;
                    Optional<Integer> EXTRACTED_11_OPT = Optional.of(NumberOfStudents + EXTRACTED_12);
                    Optional<Integer> EXTRACTED_13_OPT = Optional.of(1);
                    int[][] nData = new int[EXTRACTED_11_OPT.get()][NumberOfStudents + EXTRACTED_13_OPT.get()];
                    Optional<Integer> EXTRACTED_15_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_14_OPT = Optional.of(NumberOfStudents > EXTRACTED_15_OPT.get());
                    while (EXTRACTED_14_OPT.get()) {
                        Optional<String> strLine_OPT = Optional.of(Data_OPT.get()[++linenumber]);
                        nData = cratearray(strLine_OPT.get(), nData);
                        NumberOfStudents--;
                    } 
                    Optional<String> EXTRACTED_16_OPT = Optional.of("Caso #");
                    System.out.println(EXTRACTED_16_OPT.get() + pcase);
                    checkConnections(nData);
                    linenumber++;
                    NumberOfScenarios--;
                    pcase++;
                } 
            } else {
                NumberOfScenarios = Integer.parseInt(Data_OPT.get()[linenumber].trim());
            }
        }
    }

    public static int[][] cratearray(String strLine, int[][] nData) {
        String[] temp = null;
        temp = strLine.split(ProblemAConstants.CONSTANT_6);
        Optional<Integer> EXTRACTED_19_OPT = Optional.of(0);
        String EXTRACTED_18 = temp[EXTRACTED_19_OPT.get()];
        int i = Integer.parseInt(EXTRACTED_18.trim());
        for (int j = 2; j < temp.length; j++) {
            Optional<Integer> EXTRACTED_20_OPT = Optional.of(1);
            nData[i][Integer.parseInt(temp[j].trim())] = EXTRACTED_20_OPT.get();
        }
        Optional<int[]> EXTRACTED_21_OPT = Optional.of(nData[i]);
        EXTRACTED_21_OPT.get()[i] = 1;
        return nData;
    }

    public static void checkConnections(int[][] nData) {
        nData = Floyd(nData);
        groupSearching(nData);
    }

    public static void groupSearching(int[][] nData) {
        int i;
        int j;
        Optional<Integer> n_OPT = Optional.of(nData.length);
        int[][] groupsArray = new int[n_OPT.get()][0];
        Optional<Integer> EXTRACTED_22_OPT = Optional.of(1);
        for (i = EXTRACTED_22_OPT.get(); i < n_OPT.get(); i++) {
            for (j = 1; j < n_OPT.get(); j++) {
                Optional<Boolean> EXTRACTED_30_OPT = Optional.of(i == j);
                if (!EXTRACTED_30_OPT.get()) {
                    Optional<int[]> EXTRACTED_23_OPT = Optional.of(nData[i]);
                    Optional<Integer> EXTRACTED_24_OPT = Optional.of(1);
                    int EXTRACTED_31 = EXTRACTED_23_OPT.get()[j];
                    if (EXTRACTED_31 == EXTRACTED_24_OPT.get()) {
                        Optional<int[]> EXTRACTED_27_OPT = Optional.of(nData[i]);
                        int EXTRACTED_26 = EXTRACTED_27_OPT.get()[j];
                        Optional<int[]> EXTRACTED_28_OPT = Optional.of(nData[j]);
                        Optional<Integer> EXTRACTED_33_OPT = Optional.of(EXTRACTED_28_OPT.get()[i]);
                        Optional<Boolean> EXTRACTED_25_OPT = Optional.of(EXTRACTED_26 == EXTRACTED_33_OPT.get());
                        if (!EXTRACTED_25_OPT.get()) {
                            groupsArray = groupsArray(groupsArray, i, j, ProblemAConstants.CONSTANT_8);
                        } else {
                            groupsArray = groupsArray(groupsArray, i, j, ProblemAConstants.CONSTANT_7);
                            int[] EXTRACTED_29 = nData[j];
                            Optional<Integer> EXTRACTED_32_OPT = Optional.of(0);
                            EXTRACTED_29[i] = EXTRACTED_32_OPT.get();
                        }
                    }
                } else {
                    continue;
                }
            }
        }
        printresult(groupsArray);
    }

    public static int[][] groupsArray(int[][] array, int i, int j, String a) {
        int empty = array[0].length;
        int m;
        int n;
        Optional<Integer> ii_OPT;
        int ij;
        int temp;
        Optional<Integer> temp1_OPT;
        int indexi;
        Optional<Integer> indexj_OPT;
        Optional<Integer> itemp_OPT;
        int[] B = new int[]{ 0 };
        Optional<String> EXTRACTED_35_OPT = Optional.of("the_same");
        boolean EXTRACTED_34 = a == EXTRACTED_35_OPT.get();
        if (!EXTRACTED_34) {
            int EXTRACTED_147 = 0;
            if (empty != EXTRACTED_147) {
                Optional<Integer> EXTRACTED_68_OPT = Optional.of(0);
                for (m = EXTRACTED_68_OPT.get(); m < array.length; m++) {
                    Optional<int[]> EXTRACTED_69_OPT = Optional.of(array[m]);
                    Arrays.sort(EXTRACTED_69_OPT.get());
                    int[] EXTRACTED_70 = array[m];
                    indexi = arraySearch(EXTRACTED_70, i);
                    Optional<int[]> EXTRACTED_171_OPT = Optional.of(array[m]);
                    indexj_OPT = Optional.of(arraySearch(EXTRACTED_171_OPT.get(), j));
                    Optional<Integer> EXTRACTED_71_OPT = Optional.of(0);
                    Optional<Integer> EXTRACTED_151_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_150_OPT = Optional.of(indexi >= EXTRACTED_151_OPT.get());
                    boolean EXTRACTED_152 = indexj_OPT.get() >= EXTRACTED_71_OPT.get();
                    boolean EXTRACTED_149 = EXTRACTED_150_OPT.get() && EXTRACTED_152;
                    if (EXTRACTED_149)
                        break;

                    Optional<Integer> EXTRACTED_154_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_73_OPT = Optional.of(indexj_OPT.get() < EXTRACTED_154_OPT.get());
                    int EXTRACTED_153 = 0;
                    Optional<Boolean> EXTRACTED_172_OPT = Optional.of(indexi < EXTRACTED_153);
                    Optional<Boolean> EXTRACTED_72_OPT = Optional.of(EXTRACTED_172_OPT.get() && EXTRACTED_73_OPT.get());
                    if (EXTRACTED_72_OPT.get()) {
                        Optional<Integer> EXTRACTED_76_OPT = Optional.of(0);
                        Optional<int[]> EXTRACTED_173_OPT = Optional.of(array[m]);
                        boolean EXTRACTED_75 = EXTRACTED_173_OPT.get().length == EXTRACTED_76_OPT.get();
                        int EXTRACTED_78 = 1;
                        Optional<Integer> EXTRACTED_77_OPT = Optional.of(m + EXTRACTED_78);
                        Optional<int[]> EXTRACTED_155_OPT = Optional.of(array[EXTRACTED_77_OPT.get()]);
                        Optional<Integer> EXTRACTED_156_OPT = Optional.of(0);
                        Optional<Boolean> EXTRACTED_174_OPT = Optional.of(EXTRACTED_155_OPT.get().length == EXTRACTED_156_OPT.get());
                        boolean EXTRACTED_74 = EXTRACTED_75 && EXTRACTED_174_OPT.get();
                        if (!EXTRACTED_74) {
                            continue;
                        } else {
                            Optional<int[]> EXTRACTED_157_OPT = Optional.of(array[m]);
                            int EXTRACTED_189 = 1;
                            Optional<Integer> EXTRACTED_175_OPT = Optional.of(indexi + EXTRACTED_189);
                            Optional<Integer> EXTRACTED_188_OPT = Optional.of(-EXTRACTED_175_OPT.get());
                            array[m] = insertElement(EXTRACTED_157_OPT.get(), i, EXTRACTED_188_OPT.get());
                            Optional<Integer> EXTRACTED_79_OPT = Optional.of(1);
                            int EXTRACTED_81 = m + 1;
                            Optional<int[]> EXTRACTED_80_OPT = Optional.of(array[EXTRACTED_81]);
                            int EXTRACTED_159 = 1;
                            Optional<Integer> EXTRACTED_158_OPT = Optional.of(indexj_OPT.get() + EXTRACTED_159);
                            Optional<Integer> EXTRACTED_192_OPT = Optional.of(m + EXTRACTED_79_OPT.get());
                            Optional<Integer> EXTRACTED_193_OPT = Optional.of(-EXTRACTED_158_OPT.get());
                            array[EXTRACTED_192_OPT.get()] = insertElement(EXTRACTED_80_OPT.get(), j, EXTRACTED_193_OPT.get());
                            break;
                        }
                    }
                    Optional<Integer> EXTRACTED_84_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_83_OPT = Optional.of(indexi >= EXTRACTED_84_OPT.get());
                    int EXTRACTED_177 = 0;
                    boolean EXTRACTED_176 = indexj_OPT.get() < EXTRACTED_177;
                    Optional<Boolean> EXTRACTED_82_OPT = Optional.of(EXTRACTED_83_OPT.get() && EXTRACTED_176);
                    if (EXTRACTED_82_OPT.get()) {
                        Optional<Integer> EXTRACTED_178_OPT = Optional.of(0);
                        ij = EXTRACTED_178_OPT.get();
                        temp1_OPT = Optional.of(ProblemAConstants.CONSTANT_9);
                        Optional<Integer> EXTRACTED_160_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_85_OPT = Optional.of(m + EXTRACTED_160_OPT.get());
                        for (n = EXTRACTED_85_OPT.get(); n < array.length; n++) {
                            Optional<Integer> EXTRACTED_86_OPT = Optional.of(0);
                            Optional<int[]> EXTRACTED_162_OPT = Optional.of(array[n]);
                            Optional<Boolean> EXTRACTED_161_OPT = Optional.of(EXTRACTED_162_OPT.get().length == EXTRACTED_86_OPT.get());
                            int EXTRACTED_181 = 1;
                            int EXTRACTED_194 = -EXTRACTED_181;
                            boolean EXTRACTED_180 = temp1_OPT.get() == EXTRACTED_194;
                            Optional<Boolean> EXTRACTED_179_OPT = Optional.of(EXTRACTED_161_OPT.get() && EXTRACTED_180);
                            if (EXTRACTED_179_OPT.get()) {
                                temp1_OPT = Optional.of(n);
                            }
                            Optional<int[]> EXTRACTED_182_OPT = Optional.of(array[n]);
                            Arrays.sort(EXTRACTED_182_OPT.get());
                            Optional<int[]> EXTRACTED_163_OPT = Optional.of(array[n]);
                            itemp_OPT = Optional.of(arraySearch(EXTRACTED_163_OPT.get(), j));
                            Optional<Integer> EXTRACTED_195_OPT = Optional.of(0);
                            if (itemp_OPT.get() >= EXTRACTED_195_OPT.get()) {
                                Optional<Integer> EXTRACTED_87_OPT = Optional.of(1);
                                ij = EXTRACTED_87_OPT.get();
                            }
                        }
                        int EXTRACTED_183 = 1;
                        boolean EXTRACTED_164 = ij == EXTRACTED_183;
                        if (!EXTRACTED_164) {
                            int[] EXTRACTED_88 = array[temp1_OPT.get()];
                            Arrays.sort(EXTRACTED_88);
                            int[] EXTRACTED_89 = array[temp1_OPT.get()];
                            Optional<Integer> EXTRACTED_196_OPT = Optional.of(0);
                            array[temp1_OPT.get()] = insertElement(EXTRACTED_89, j, EXTRACTED_196_OPT.get());
                            break;
                        } else
                            break;

                    }
                    int EXTRACTED_165 = 0;
                    int EXTRACTED_184 = 0;
                    boolean EXTRACTED_190 = (indexi < EXTRACTED_184) && (indexj_OPT.get() >= EXTRACTED_165);
                    if (EXTRACTED_190) {
                        Optional<Integer> EXTRACTED_185_OPT = Optional.of(0);
                        ij = EXTRACTED_185_OPT.get();
                        Optional<Integer> EXTRACTED_166_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_90_OPT = Optional.of(-EXTRACTED_166_OPT.get());
                        temp1_OPT = Optional.of(EXTRACTED_90_OPT.get());
                        Optional<Integer> EXTRACTED_92_OPT = Optional.of(1);
                        int EXTRACTED_91 = m + EXTRACTED_92_OPT.get();
                        for (n = EXTRACTED_91; n < array.length; n++) {
                            Optional<Integer> EXTRACTED_167_OPT = Optional.of(0);
                            Optional<int[]> EXTRACTED_197_OPT = Optional.of(array[n]);
                            Optional<Boolean> EXTRACTED_94_OPT = Optional.of(EXTRACTED_197_OPT.get().length == EXTRACTED_167_OPT.get());
                            Optional<Integer> EXTRACTED_168_OPT = Optional.of(1);
                            int EXTRACTED_95 = -EXTRACTED_168_OPT.get();
                            Optional<Boolean> EXTRACTED_186_OPT = Optional.of(temp1_OPT.get() == EXTRACTED_95);
                            Optional<Boolean> EXTRACTED_93_OPT = Optional.of(EXTRACTED_94_OPT.get() && EXTRACTED_186_OPT.get());
                            if (EXTRACTED_93_OPT.get()) {
                                temp1_OPT = Optional.of(n);
                            }
                            Optional<int[]> EXTRACTED_198_OPT = Optional.of(array[n]);
                            Arrays.sort(EXTRACTED_198_OPT.get());
                            Optional<int[]> EXTRACTED_191_OPT = Optional.of(array[n]);
                            itemp_OPT = Optional.of(arraySearch(EXTRACTED_191_OPT.get(), i));
                            Optional<Boolean> EXTRACTED_96_OPT = Optional.of(itemp_OPT.get() >= 0);
                            if (EXTRACTED_96_OPT.get()) {
                                Optional<Integer> EXTRACTED_187_OPT = Optional.of(1);
                                ij = EXTRACTED_187_OPT.get();
                            }
                        }
                        Optional<Integer> EXTRACTED_98_OPT = Optional.of(1);
                        boolean EXTRACTED_97 = ij == EXTRACTED_98_OPT.get();
                        if (!EXTRACTED_97) {
                            int[] EXTRACTED_169 = array[temp1_OPT.get()];
                            Arrays.sort(EXTRACTED_169);
                            int[] EXTRACTED_99 = array[temp1_OPT.get()];
                            Optional<Integer> EXTRACTED_100_OPT = Optional.of(0);
                            array[temp1_OPT.get()] = insertElement(EXTRACTED_99, i, EXTRACTED_100_OPT.get());
                            break;
                        } else
                            break;

                    }
                }
            } else {
                Optional<Integer> EXTRACTED_148_OPT = Optional.of(0);
                Optional<int[]> EXTRACTED_64_OPT = Optional.of(array[EXTRACTED_148_OPT.get()]);
                Optional<Integer> EXTRACTED_65_OPT = Optional.of(0);
                array[0] = insertElement(EXTRACTED_64_OPT.get(), i, EXTRACTED_65_OPT.get());
                Optional<Integer> EXTRACTED_66_OPT = Optional.of(1);
                Optional<Integer> EXTRACTED_67_OPT = Optional.of(1);
                Optional<int[]> EXTRACTED_170_OPT = Optional.of(array[EXTRACTED_67_OPT.get()]);
                array[EXTRACTED_66_OPT.get()] = insertElement(EXTRACTED_170_OPT.get(), j, 0);
            }
        } else {
            Optional<Integer> EXTRACTED_101_OPT = Optional.of(0);
            if (empty != EXTRACTED_101_OPT.get()) {
                for (m = 0; m < array.length; m++) {
                    Optional<int[]> EXTRACTED_39_OPT = Optional.of(array[m]);
                    Arrays.sort(EXTRACTED_39_OPT.get());
                    Optional<int[]> EXTRACTED_40_OPT = Optional.of(array[m]);
                    indexi = arraySearch(EXTRACTED_40_OPT.get(), i);
                    int[] EXTRACTED_41 = array[m];
                    indexj_OPT = Optional.of(arraySearch(EXTRACTED_41, j));
                    Optional<Integer> EXTRACTED_105_OPT = Optional.of(0);
                    Optional<Integer> EXTRACTED_125_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_124_OPT = Optional.of(indexi >= EXTRACTED_125_OPT.get());
                    Optional<Boolean> EXTRACTED_126_OPT = Optional.of(indexj_OPT.get() >= EXTRACTED_105_OPT.get());
                    Optional<Boolean> EXTRACTED_104_OPT = Optional.of(EXTRACTED_124_OPT.get() && EXTRACTED_126_OPT.get());
                    if (EXTRACTED_104_OPT.get())
                        break;

                    int EXTRACTED_43 = 0;
                    Optional<Boolean> EXTRACTED_127_OPT = Optional.of(indexi < EXTRACTED_43);
                    Optional<Integer> EXTRACTED_140_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_128_OPT = Optional.of(indexj_OPT.get() < EXTRACTED_140_OPT.get());
                    boolean EXTRACTED_42 = EXTRACTED_127_OPT.get() && EXTRACTED_128_OPT.get();
                    if (EXTRACTED_42) {
                        Optional<Integer> EXTRACTED_44_OPT = Optional.of(0);
                        int[] EXTRACTED_106 = array[m];
                        Optional<Boolean> EXTRACTED_129_OPT = Optional.of(EXTRACTED_106.length == EXTRACTED_44_OPT.get());
                        if (!EXTRACTED_129_OPT.get()) {
                            continue;
                        } else {
                            int[] EXTRACTED_45 = array[m];
                            int EXTRACTED_47 = 1;
                            Optional<Integer> EXTRACTED_107_OPT = Optional.of(indexi + EXTRACTED_47);
                            Optional<Integer> EXTRACTED_46_OPT = Optional.of(-EXTRACTED_107_OPT.get());
                            array[m] = insertElement(EXTRACTED_45, i, EXTRACTED_46_OPT.get());
                            Optional<Integer> EXTRACTED_49_OPT = Optional.of(1);
                            Optional<Integer> EXTRACTED_130_OPT = Optional.of(indexj_OPT.get() + EXTRACTED_49_OPT.get());
                            Optional<Integer> EXTRACTED_48_OPT = Optional.of(-EXTRACTED_130_OPT.get());
                            array[m] = insertElement(array[m], j, EXTRACTED_48_OPT.get());
                            break;
                        }
                    }
                    Optional<Integer> EXTRACTED_110_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_50_OPT = Optional.of(indexj_OPT.get() < EXTRACTED_110_OPT.get());
                    Optional<Integer> EXTRACTED_109_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_131_OPT = Optional.of(indexi >= EXTRACTED_109_OPT.get());
                    Optional<Boolean> EXTRACTED_108_OPT = Optional.of(EXTRACTED_131_OPT.get() && EXTRACTED_50_OPT.get());
                    if (EXTRACTED_108_OPT.get()) {
                        temp = m;
                        ij = indexj_OPT.get();
                        Optional<Integer> EXTRACTED_51_OPT = Optional.of(0);
                        temp1_OPT = Optional.of(EXTRACTED_51_OPT.get());
                        Optional<Integer> EXTRACTED_132_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_52_OPT = Optional.of(m + EXTRACTED_132_OPT.get());
                        for (n = EXTRACTED_52_OPT.get(); n < array.length; n++) {
                            Optional<int[]> EXTRACTED_111_OPT = Optional.of(array[n]);
                            Arrays.sort(EXTRACTED_111_OPT.get());
                            int[] EXTRACTED_53 = array[n];
                            itemp_OPT = Optional.of(arraySearch(EXTRACTED_53, j));
                            Optional<Integer> EXTRACTED_54_OPT = Optional.of(0);
                            boolean EXTRACTED_133 = itemp_OPT.get() >= EXTRACTED_54_OPT.get();
                            if (EXTRACTED_133) {
                                Optional<int[]> EXTRACTED_112_OPT = Optional.of(array[temp]);
                                Optional<int[]> EXTRACTED_134_OPT = Optional.of(array[n]);
                                array[temp] = merge(EXTRACTED_112_OPT.get(), EXTRACTED_134_OPT.get());
                                array[n] = B;
                                int EXTRACTED_113 = 1;
                                temp1_OPT = Optional.of(EXTRACTED_113);
                                break;
                            }
                        }
                        int EXTRACTED_114 = 1;
                        Optional<Boolean> EXTRACTED_144_OPT = Optional.of(temp1_OPT.get() == EXTRACTED_114);
                        if (!EXTRACTED_144_OPT.get()) {
                            Optional<int[]> EXTRACTED_115_OPT = Optional.of(array[temp]);
                            Arrays.sort(EXTRACTED_115_OPT.get());
                            Optional<Integer> EXTRACTED_56_OPT = Optional.of(1);
                            Optional<Integer> EXTRACTED_55_OPT = Optional.of(ij + EXTRACTED_56_OPT.get());
                            Optional<Integer> EXTRACTED_116_OPT = Optional.of(-EXTRACTED_55_OPT.get());
                            int[] EXTRACTED_135 = array[temp];
                            array[temp] = insertElement(EXTRACTED_135, j, EXTRACTED_116_OPT.get());
                            break;
                        } else
                            break;

                    }
                    Optional<Integer> EXTRACTED_141_OPT = Optional.of(0);
                    boolean EXTRACTED_58 = indexi < EXTRACTED_141_OPT.get();
                    Optional<Integer> EXTRACTED_59_OPT = Optional.of(0);
                    Optional<Boolean> EXTRACTED_136_OPT = Optional.of(indexj_OPT.get() >= EXTRACTED_59_OPT.get());
                    Optional<Boolean> EXTRACTED_57_OPT = Optional.of(EXTRACTED_58 && EXTRACTED_136_OPT.get());
                    if (EXTRACTED_57_OPT.get()) {
                        temp = m;
                        ii_OPT = Optional.of(indexi);
                        int EXTRACTED_60 = 0;
                        temp1_OPT = Optional.of(EXTRACTED_60);
                        Optional<Integer> EXTRACTED_145_OPT = Optional.of(1);
                        Optional<Integer> EXTRACTED_137_OPT = Optional.of(m + EXTRACTED_145_OPT.get());
                        for (n = EXTRACTED_137_OPT.get(); n < array.length; n++) {
                            int[] EXTRACTED_117 = array[n];
                            Arrays.sort(EXTRACTED_117);
                            Optional<int[]> EXTRACTED_118_OPT = Optional.of(array[n]);
                            indexi = arraySearch(EXTRACTED_118_OPT.get(), i);
                            Optional<Integer> EXTRACTED_142_OPT = Optional.of(0);
                            Optional<Boolean> EXTRACTED_119_OPT = Optional.of(indexi >= EXTRACTED_142_OPT.get());
                            if (EXTRACTED_119_OPT.get()) {
                                Optional<int[]> EXTRACTED_120_OPT = Optional.of(array[n]);
                                Optional<int[]> EXTRACTED_138_OPT = Optional.of(array[temp]);
                                array[temp] = merge(EXTRACTED_138_OPT.get(), EXTRACTED_120_OPT.get());
                                array[n] = B;
                                Optional<Integer> EXTRACTED_146_OPT = Optional.of(1);
                                temp1_OPT = Optional.of(EXTRACTED_146_OPT.get());
                                break;
                            }
                        }
                        int EXTRACTED_143 = 1;
                        boolean EXTRACTED_61 = temp1_OPT.get() == EXTRACTED_143;
                        if (!EXTRACTED_61) {
                            int EXTRACTED_63 = 1;
                            Optional<Integer> EXTRACTED_62_OPT = Optional.of(ii_OPT.get() + EXTRACTED_63);
                            Optional<Integer> EXTRACTED_121_OPT = Optional.of(-EXTRACTED_62_OPT.get());
                            Optional<int[]> EXTRACTED_139_OPT = Optional.of(array[temp]);
                            array[temp] = insertElement(EXTRACTED_139_OPT.get(), i, EXTRACTED_121_OPT.get());
                            break;
                        } else
                            break;

                    }
                }
            } else {
                Optional<Integer> EXTRACTED_36_OPT = Optional.of(0);
                Optional<Integer> EXTRACTED_102_OPT = Optional.of(0);
                int EXTRACTED_122 = 0;
                array[EXTRACTED_102_OPT.get()] = insertElement(array[EXTRACTED_36_OPT.get()], i, EXTRACTED_122);
                int EXTRACTED_37 = 0;
                Optional<Integer> EXTRACTED_123_OPT = Optional.of(0);
                int[] EXTRACTED_38 = array[EXTRACTED_123_OPT.get()];
                Optional<Integer> EXTRACTED_103_OPT = Optional.of(0);
                array[EXTRACTED_37] = insertElement(EXTRACTED_38, j, EXTRACTED_103_OPT.get());
            }
        }
        return array;
    }

    private static int[] insertElement(int[] original, int element, int index) {
        Optional<Integer> length_OPT = Optional.of(length_OPT.get());
        Optional<int[]> destination_OPT = Optional.of(new int[length_OPT.get() + 1]);
        Optional<Integer> EXTRACTED_199_OPT = Optional.of(0);
        System.arraycopy(original, 0, destination_OPT.get(), EXTRACTED_199_OPT.get(), index);
        destination_OPT.get()[index] = element;
        Optional<Integer> EXTRACTED_200_OPT = Optional.of(index + 1);
        System.arraycopy(original, index, destination_OPT.get(), EXTRACTED_200_OPT.get(), length_OPT.get() - index);
        return destination_OPT.get();
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] C = new int[array1.length + array2.length];
        Optional<Integer> EXTRACTED_201_OPT = Optional.of(0);
        int EXTRACTED_202 = 0;
        System.arraycopy(array1, EXTRACTED_201_OPT.get(), C, EXTRACTED_202, array1.length);
        Optional<Integer> EXTRACTED_203_OPT = Optional.of(0);
        System.arraycopy(array2, EXTRACTED_203_OPT.get(), C, array1.length, array2.length);
        return C;
    }

    public static int arraySearch(int[] array, int val) {
        int index = Arrays.binarySearch(array, val);
        return index;
    }

    public static int[][] Floyd(int[][] nData) {
        int i;
        int j;
        int k;
        int n = nData.length;
        for (k = 0; k < n; k++)
            for (i = 0; i < n; i++) {
                Optional<Integer> EXTRACTED_211_OPT = Optional.of(0);
                for (j = EXTRACTED_211_OPT.get(); j < n; j++) {
                    int[] EXTRACTED_205 = nData[i];
                    int EXTRACTED_210 = 1;
                    Optional<Integer> EXTRACTED_213_OPT = Optional.of(nData[k][j]);
                    Optional<Boolean> EXTRACTED_206_OPT = Optional.of(EXTRACTED_213_OPT.get() == EXTRACTED_210);
                    int EXTRACTED_209 = 1;
                    int EXTRACTED_212 = EXTRACTED_205[k];
                    Optional<Boolean> EXTRACTED_204_OPT = Optional.of((EXTRACTED_212 == EXTRACTED_209) && EXTRACTED_206_OPT.get());
                    if (EXTRACTED_204_OPT.get()) {
                        int[] EXTRACTED_207 = nData[i];
                        int EXTRACTED_208 = 1;
                        EXTRACTED_207[j] = EXTRACTED_208;
                    }
                }
            }

        return nData;
    }

    public static void printresult(int[][] nData) {
        int i;
        int j;
        int t1;
        Optional<Integer> t2_OPT;
        int group = 0;
        Optional<Integer> out_OPT = Optional.of(0);
        for (i = 0; i < nData.length; i++) {
            Optional<Integer> EXTRACTED_214_OPT = Optional.of(0);
            t1 = EXTRACTED_214_OPT.get();
            Optional<Integer> EXTRACTED_215_OPT = Optional.of(0);
            t2_OPT = Optional.of(EXTRACTED_215_OPT.get());
            Optional<Integer> EXTRACTED_216_OPT = Optional.of(4);
            if (!(nData[i].length >= EXTRACTED_216_OPT.get())) {
                Optional<Integer> EXTRACTED_218_OPT = Optional.of(1);
                Optional<Boolean> EXTRACTED_217_OPT = Optional.of(nData[i].length == EXTRACTED_218_OPT.get());
                Optional<int[]> EXTRACTED_219_OPT = Optional.of(nData[i]);
                Optional<Integer> EXTRACTED_220_OPT = Optional.of(0);
                Optional<Boolean> EXTRACTED_229_OPT = Optional.of(EXTRACTED_219_OPT.get().length == EXTRACTED_220_OPT.get());
                if (!(EXTRACTED_217_OPT.get() || EXTRACTED_229_OPT.get())) {
                    int[] EXTRACTED_225 = nData[i];
                    t2_OPT = Optional.of(EXTRACTED_225.length);
                } else {
                    int EXTRACTED_221 = 0;
                    Optional<int[]> EXTRACTED_222_OPT = Optional.of(nData[i]);
                    for (j = EXTRACTED_221; j < EXTRACTED_222_OPT.get().length; j++) {
                        int EXTRACTED_224 = nData[i][j];
                        Optional<Integer> EXTRACTED_231_OPT = Optional.of(0);
                        Optional<Boolean> EXTRACTED_223_OPT = Optional.of(EXTRACTED_224 != EXTRACTED_231_OPT.get());
                        if (EXTRACTED_223_OPT.get())
                            t1++;

                    }
                }
            } else {
                group++;
            }
            Optional<Integer> EXTRACTED_230_OPT = Optional.of(out_OPT.get() + t1);
            Optional<Integer> EXTRACTED_226_OPT = Optional.of(EXTRACTED_230_OPT.get() + t2_OPT.get());
            out_OPT = Optional.of(EXTRACTED_226_OPT.get());
        }
        String EXTRACTED_228 = group + " ";
        Optional<String> EXTRACTED_227_OPT = Optional.of(EXTRACTED_228 + out_OPT.get());
        out_OPT.get().println(EXTRACTED_227_OPT.get());
    }

    /**
     */
    public ProblemA(boolean boolean0) {
        throw new RuntimeException("You'd better not have called me!");
    }
}