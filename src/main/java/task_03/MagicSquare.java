package task_03;

import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MagicSquare {
    private static final String INPUTFILE = "src/main/resources/input_files/input_thirdtask";
    private static final String OUTPUTFILE = "target/logs/output_thirdtask.txt";

    public static void main(String[] args) throws IOException {
        int[][] square = InputOutputUtils.readTwoDimensionalArrayFromFile(INPUTFILE);
        checkIfMagicSquare(square);
    }

    public static void checkIfMagicSquare(int[][] array) throws IOException {
        List<Integer> rowList = new ArrayList<>();
        List<Integer> columnList = new ArrayList<>();
        int size = array.length;
        int sumOfFirstDiagonal = 0;
        int sumOfSecondDiagonal = 0;
        for (int i = 0; i < size; i++) {
            sumOfFirstDiagonal += array[i][i];
            sumOfSecondDiagonal += array[i][size - i - 1];
            int sumEachRow = 0;
            int sumEachCol = 0;
            for (int j = 0; j < size; j++) {
                sumEachRow += array[i][j];
                sumEachCol += array[j][i];
            }
            rowList.add(sumEachRow);
            columnList.add(sumEachCol);
        }
        if ((rowList.equals(columnList)) && (sumOfFirstDiagonal == sumOfSecondDiagonal)) {
            InputOutputUtils.writeTwoDimensionalArrayToFile(array, OUTPUTFILE, "This is a magic square: \n");
        } else {
            InputOutputUtils.writeTwoDimensionalArrayToFile(array, OUTPUTFILE, "This is NOT a magic square: \n");
        }
    }
}
