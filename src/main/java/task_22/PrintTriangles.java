package task_22;

public class PrintTriangles {
    private static final String SPACE = " ";

    public static void main(String[] args) {
        int rows = 10;

//        print2DIntArray(printPascalTriangle2(rows));
        printPowerOf2Triangle(rows);

    }

    private static void printPowerOf2Triangle(int rows) {
        int row = 0;
        int num = 1;
        int space = rows - 1;
        while (row < rows) {
            // Space
            for (int i = 0; i < space; i++) {
                System.out.print("    ");
            }
            //Print nums
            for (int i = 0; i < num; i++) {
                System.out.printf("%4d", (int) Math.pow(2, i));
            }
            for (int i = num - 2; i >= 0; i--) {
                System.out.printf("%4d", (int) Math.pow(2, i));
            }
            System.out.println();
            row++;
            space--;
            num++;
        }
    }

    private static String[][] printPascalTriangle1(int n) {
        int colSize = n * 2 - 1;
        String[][] arr = new String[n][colSize];
        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j < colSize; j++) {
                arr[i][j] = SPACE;
                for (int k = 0; k <= i; k++) {
                    if (k == 0 || i == 0) {
                        arr[i][k] = String.valueOf(1);
                    } else {
                        num = num * (i - k + 1) / k;
                    }
                    arr[i][k] = String.valueOf(num);
                }
            }
        }
        return arr;
    }

    private static int[][] printPascalTriangle2(int rows) {
        int cols = 2 * rows + 1;
        int[][] arr = new int[rows][cols];
        arr[0][rows] = 1;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j + 1];
            }
        }
        return arr;
    }

    private static void print2DIntArray(int[][] arr) {
        int size = arr.length;
        int colSize = arr[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < colSize; j++) {
                if (arr[i][j] != 0) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }

    private static void printArray(String[][] arr) {
        int rowSize = arr.length;
        int colSize = arr[0].length;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
//                System.out.print(arr[i][j] + " ");
                System.out.printf("%4s", arr[i][j]);
            }
            System.out.println();
        }
    }
}

