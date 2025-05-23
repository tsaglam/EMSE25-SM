import java.lang.System;
import java.util.Arrays;
class ProblemA {
    private static int NumberOfScenarios = 0;
    public static String inputd = "";
    private static int NumberOfStudents = 0;
    private static int pcase = 1;

    public static void main(String[] args) {
        System.out.println("Input: ");
        inputd = readString();
        processInput(inputd);
    }
    
    public static String readString() {
        StringBuilder r = new StringBuilder();
        int ch;
        try {
            while ((ch = System.in.read()) != -1) {
                if ((char) ch == '\n')
                    break;
                else if ((char) ch != '\r')
                    r.append((char) ch);
            }
        } catch (java.io.IOException e) {
            return r.toString();
        }
        return r.toString();
    }

    private static void processInput(String inputData) {
        String[] Data = inputData.split("#");
        NumberOfScenarios = Integer.parseInt(Data[0].trim());
        int lineCounter = 1;
        while (NumberOfScenarios-- > 0) {
            NumberOfStudents = Integer.parseInt(Data[lineCounter++].trim());
            int[][] nData = new int[NumberOfStudents + 1][NumberOfStudents + 1];
            for (int i = 0; i < NumberOfStudents; i++) {
                nData = cratearray(Data[lineCounter++], nData);
            }
            System.out.println("Case #" + pcase++);
            checkConnections(nData);
        }
    }

    public static int[][] cratearray(String strLine, int[][] nData) {
        String[] temp = strLine.split(" ");
        int i = Integer.parseInt(temp[0].trim());
        for (int j = 2; j < temp.length; j++) {
            nData[i][Integer.parseInt(temp[j].trim())] = 1;
        }
        nData[i][i] = 1;
        return nData;
    }
    
    public static void checkConnections(int[][] nData) {
        nData = Floyd(nData);
        groupSearching(nData);
    }
    
    public static int[][] Floyd(int[][] nData) {
        for (int k = 1; k < nData.length; k++)
            for (int i = 1; i < nData.length; i++)
                for (int j = 1; j < nData.length; j++) {
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
                if (i != j && nData[i][j] == 1) {
                    String relationType = nData[i][j] == nData[j][i] ? "the_same" : "different";
                    groupsArray = groupsArray(groupsArray, i, j, relationType);
                    if (relationType.equals("the_same")) {
                        nData[j][i] = 0;
                    }
                }
            }
        }
        printresult(groupsArray);
    }

    public static int[][] groupsArray(int[][] array, int i, int j, String a) {
        boolean found = false;
        for (int[] group : array) {
            if (Arrays.binarySearch(group, i) >= 0 || Arrays.binarySearch(group, j) >= 0) {
                found = true;
                break;
            }
        }
        if (!found) {
            array = extendArray(array, i, j, a);
        }
        return array;
    }

    public static void printresult(int[][] nData) {
        int groups = 0, outliers = 0;
        for (int[] group : nData) {
            if (group.length > 3) groups++;
            else outliers += group.length;
        }
        System.out.println(groups + " groups and " + outliers + " outliers.");
    }

    private static int[][] extendArray(int[][] array, int i, int j, String relation) {
        if (relation.equals("the_same")) {
            for (int m = 0; m < array.length; m++) {
                if (array[m].length == 0) {
                    array[m] = new int[]{i, j};
                    break;
                }
            }
        } else {
            for (int m = 0; m < array.length; m += 2) {
                if (array[m].length == 0) {
                    array[m] = new int[]{i};
                    if (m + 1 < array.length) {
                        array[m + 1] = new int[]{j};
                    }
                    break;
                }
            }
        }
        return array;
    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, result, 0, array1.length);
        System.arraycopy(array2, 0, result, array1.length, array2.length);
        return result;
    }
    
    private static int[] insertElement(int[] original, int element, int index) {
        int[] result = new int[original.length + 1];
        System.arraycopy(original, 0, result, 0, index);
        result[index] = element;
        System.arraycopy(original, index, result, index + 1, original.length - index);
        return result;
    }

    public static int arraySearch(int[] array, int value) {
        return Arrays.binarySearch(array, value);
    }
}