package task_21;

public class HillPatterns {
    private static final String SPACE = " ";
    private static final String HASH = "#";

    public static void main(String[] args) {
        int value = 10;
        print2DArray(hillPatternAUsing2DArray(value));
        System.out.println();
        print2DArray(hillPatternBUsing2DArray(value));
        System.out.println();
        print2DArray(hillPatternCUsing2DArray(value));
        System.out.println();
        print2DArray(hillPatternDUsing2DArray(value));
    }

    private static String[][] hillPatternAUsing2DArray(int rows) {
        int cols = rows * 2 - 1;
        String[][] arr = new String[rows][cols];
        int temp = rows - 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col >= temp - row && col <= temp + row) {
                    arr[row][col] = HASH;
                } else {
                    arr[row][col] = SPACE;
                }
            }
        }
        return arr;
    }

    private static String[][] hillPatternBUsing2DArray(int rows) {
        int cols = rows * 2 - 1;
        String[][] arr = new String[rows][cols];
        int temp = rows - 1;
        for (int row = 0; row < rows; row++) {
            int count = temp - row;
            for (int col = 0; col < cols; col++) {
                if (col >= temp - count && col <= temp + count) {
                    arr[row][col] = HASH;
                } else {
                    arr[row][col] = SPACE;
                }
            }
        }
        return arr;
    }

    private static String[][] hillPatternCUsing2DArray(int val) {
        int size = val * 2 - 1;
        String[][] arr = new String[size][size];
        String[][] firstHillPattern = hillPatternAUsing2DArray(val);
        String[][] secondHillPattern = hillPatternBUsing2DArray(val);
        int temp = 1;
        for (int i = 0; i < size; i++) {
            if (i < val) {
                for (int k = 0; k < size; k++) {
                    arr[i][k] = firstHillPattern[i][k];
                }
            } else {
                for (int j = 0; j < size; j++) {
                    arr[i][j] = secondHillPattern[temp][j];
                }
                temp++;
            }
        }
        return arr;
    }

    private static String[][] hillPatternDUsing2DArray(int val) {
        String[][] arr = hillPatternCUsing2DArray(val);
        int size = val * 2 - 1;
        String[][] tempArr = new String[size][size];
        for (int i = 0; i < size; i++) {
            if (i < val - 1) {
                for (int j = 0; j < size; j++) {
                    if (arr[i][j].equals(HASH)) {
                        tempArr[i + 1][j] = (SPACE);
                    } else if (arr[i][j].equals(SPACE)) {
                        tempArr[i + 1][j] = HASH;
                    }
                    tempArr[0][j] = HASH;
                }
            } else if (i >= val) {
                for (int j = 0; j < size; j++) {
                    if (arr[i][j].equals(HASH)) {
                        tempArr[i - 1][j] = SPACE;
                    } else if (arr[i][j].equals(SPACE)) {
                        tempArr[i - 1][j] = HASH;
                    }
                    tempArr[size - 1][j] = HASH;
                }
            }
        }
        return tempArr;
    }

    private static void print2DArray(String[][] arr) {
        int size = arr.length;
        int colSize = arr[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < colSize; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
