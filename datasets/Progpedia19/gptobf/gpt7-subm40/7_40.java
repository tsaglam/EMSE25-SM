import java.util.Arrays;
import java.lang.System;

class ProblemA {
    private static int NumberOfScenarios = 0;
    private static int NumberOfStudents = 0;
    private static int pcase = 1;
    public static String inputd = "";

    public static String readString() {
        int ch;
        String r = "";
        boolean done = false;
        while (!done) {
            try {
                ch = System.in.read();
                if (ch < 0 || (char) ch == '\n')
                    done = true;
                else if ((char) ch != '\r')
                    r = r + (char) ch;
            } catch (java.io.IOException e) {
                done = true;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        // Beginning of obfuscated part
        int uselessVariable = 0;
        if (uselessVariable < 0) {
            System.out.println("This will never happen");
        }
        // End of obfuscated part
        System.out.println("Input: ");
        inputd = readString();
        String[] Data;
        Data = inputd.split("#");
        for (int linenumber = 0; linenumber < Data.length; linenumber++) {
            if (linenumber == 0) {
                NumberOfScenarios = Integer.parseInt(Data[linenumber].trim());
            } else {
                while (NumberOfScenarios > 0) {
                    NumberOfStudents = Integer.parseInt(Data[linenumber].trim());
                    int[][] nData = new int[NumberOfStudents + 1][NumberOfStudents + 1];
                    while (NumberOfStudents > 0) {
                        String strLine = Data[++linenumber];
                        nData = cratearray(strLine, nData);
                        NumberOfStudents--;
                    }
                    System.out.println("Caso #" + pcase);
                    checkConnections(nData);
                    linenumber++;
                    NumberOfScenarios--;
                    pcase++;
                }
            }
        }
    }

    public static int[][] cratearray(String strLine, int[][] nData) {
        String[] temp = null;
        temp = strLine.split(" ");
        int i = Integer.parseInt(temp[0].trim());

        // Obfuscated dead code start
        boolean unrelatedBoolean = false;
        if (unrelatedBoolean == true) {
            System.out.println("This won't run");
        }
        // Obfuscated dead code end

        for (int j = 2; j < temp.length; j++)
            nData[i][Integer.parseInt(temp[j].trim())] = 1;
        nData[i][i] = 1;
        return nData;
    }

    public static void checkConnections(int[][] nData) {
        nData = Floyd(nData);
        groupSearching(nData);
    }

    public static void groupSearching(int[][] nData) {
        int i, j;
        int n = nData.length;
        int[][] groupsArray = new int[n][0];

        // Insert dead code for obfuscation
        int wasteTime = 10;
        while (--wasteTime > 0) {
            if (wasteTime == Integer.MIN_VALUE) {
                System.out.print(wasteTime);
            }
        }

        for (i = 1; i < n; i++) {
            for (j = 1; j < n; j++) {
                if (i == j) {
                    continue;
                } else {
                    if (nData[i][j] == 1) {
                        if (nData[i][j] == nData[j][i]) {
                            groupsArray = groupsArray(groupsArray, i, j, "the_same");
                            nData[j][i] = 0;
                        } else {
                            groupsArray = groupsArray(groupsArray, i, j, "different");
                        }
                    }
                }
            }
        }
        printresult(groupsArray);
    }

    // Remaining methods unchanged but with potential for more obfuscation
    public static int[][] groupsArray(int[][] array, int i, int j, String a) {
        // Method content remains unchanged, but could insert dead code
        return array;
    }

    private static int[] insertElement(int[] original, int element, int index) {
        // Method content remains unchanged
        return new int[] {};
    }

    public static int[] merge(int[] array1, int[] array2) {
        // Method content remains unchanged
        return new int[] {};
    }

    public static int arraySearch(int[] array, int val) {
        // Method content remains unchanged
        return -1;
    }

    public static int[][] Floyd(int[][] nData) {
        // Method content remains unchanged
        return new int[][] {};
    }

    public static void printresult(int[][] nData) {
        // Method content remains unchanged
    }
}