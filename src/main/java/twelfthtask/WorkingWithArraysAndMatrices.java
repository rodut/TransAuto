package twelfthtask;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingWithArraysAndMatrices {
    private static final String INPUT_FILE1 = "src/main/resources/input_files/input_twelfthtask_arrays";
    private static final String OUTPUT_FILE = "target/logs/output_twelfthtask";
    private static final String INPUT_FILE2 = "src/main/resources/input_files/input_twelfthtask_matrices";

    public static void main(String[] args) throws IOException {
        List<int[]> list = new ArrayList<>(InputOutputUtils.readTwoArraysFromFile(INPUT_FILE1));
        InputOutputUtils.writeToFile(findCommonElementsInTwoArrays(list.get(0), list.get(1)), OUTPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(findSecondLargestElemInArray(list.get(0)), OUTPUT_FILE, "\nSecond largest element: ");
        List<int[][]> matrices = new ArrayList<>(InputOutputUtils.readTwoMatricesFromFile(INPUT_FILE2));
        InputOutputUtils.writeToFileAndAppend(Arrays.deepToString(addTwoMatrices(matrices.get(0), matrices.get(1))), OUTPUT_FILE, "The sum of matrices: ");
    }

    private static List<Integer> findCommonElementsInTwoArrays(int[] first, int[] second) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[i] == second[j]) {
                    list.add(first[i]);
                }
            }
        }
        return list;
    }

    private static int findSecondLargestElemInArray(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length - i - 1; j++) {
                if (max < arr[i]) {
                    max = arr[j];
                }
            }
        }
        return max;
    }

    private static int[][] addTwoMatrices(int[][] first, int[][] second) {
        int[][] result = new int[first.length][second.length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }
}
