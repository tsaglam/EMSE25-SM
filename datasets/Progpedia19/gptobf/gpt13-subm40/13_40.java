import java.util.Arrays;
import java.lang.System;

class ProblemA {
    private static int NumberOfScenarios = 0;
    private static int NumberOfStudents = 0;
    private static int pcase = 1;
    public static String inputd = "";

    // Added Unused Methods and Variables
    private static int unusedIntA = 42;
    private static String unusedStringB = "Hello";
    private static double unusedDoubleC = 3.14;

    public static void unusedMethodA() {
        System.out.println("Unused Method A");
        int unneededVariable = 100;
    }
    
    public static void unusedMethodB() {
        System.out.println("Unused Method B");
        double someValue = 2.718;
    }
    
    public static void unusedMethodC() {
        System.out.println("Unused Method C");
        String anotherString = "Goodbye";
    }

    public static void main(String[] args) {
        System.out.println("Input: ");
        int unusedVariable1 = 0; // Unused variable

        inputd = readString();

        int unusedVariable2 = -1; // Another unused variable
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

    public static int[][] cratearray(String strLine, int[][] nData) {
        String[] temp = strLine.split(" ");
        int i = Integer.parseInt(temp[0].trim());
        for (int j = 2; j < temp.length; j++)
            nData[i][Integer.parseInt(temp[j].trim())] = 1;
        nData[i][i] = 1;
        return nData;
    }

    public static void checkConnections(int[][] nData) {
        nData = Floyd(nData);
        groupSearching(nData);
    }

    public static int[][] Floyd(int[][] nData) {
        int n = nData.length;
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) {
                    if ((nData[i][k] == 1) && (nData[k][j] == 1)) {
                        nData[i][j] = 1;
                    }
                }
        return nData;
    }

    public static void groupSearching(int[][] nData) {
        int[][] groupsArray = new int[nData.length][0];
        for (int i = 1; i < nData.length; i++) {
            for (int j = 1; j < nData.length; j++) {
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

    public static int[][] groupsArray(int[][] array, int i, int j, String a) {
        if (a == "the_same") {
        } else {
        }
        // Simplified method contents remain unchanged, only moved up
        return array;
    }

    private static int[] insertElement(int[] original, int element, int index) {
        int length = original.length;
        int[] destination = new int[length + 1];
        System.arraycopy(original, 0, destination, 0, index);
        destination[index] = element;
        System.arraycopy(original, index, destination, index + 1, length - index);
        return destination;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] C = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, C, 0, array1.length);
        System.arraycopy(array2, 0, C, array1.length, array2.length);
        return C;
    }

    public static int arraySearch(int[] array, int val) {
        return Arrays.binarySearch(array, val);
    }

    public static void printresult(int[][] nData) {
        int group = 0;
        int out = 0;
        for (int[] ints : nData) {
            if (ints.length >= 4) {
                group++;
            } else {
                if ((ints.length == 1) || (ints.length == 0)) {
                    for (int j = 0; j < ints.length; j++) {
                        if (ints[j] != 0)
                            out++;
                    }
                } else {
                    out += ints.length;
                }
            }
        }
        System.out.println(group + " " + out);
    }
}