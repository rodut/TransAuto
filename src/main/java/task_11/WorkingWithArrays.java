package task_11;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingWithArrays {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_eleventhtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_eleventhtask.txt";

    public static void main(String[] args) throws IOException {
        int[] arr = InputOutputUtils.readFile(INPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(calcAverageValOfElements(arr), OUTPUT_FILE, "Average: ");
        InputOutputUtils.writeToFileAndAppend(Arrays.toString(removeElementFromArray(arr, 7)), OUTPUT_FILE, "Removed element: ");
        InputOutputUtils.writeToFileAndAppend(Arrays.toString(copyArrayByIteration(arr)), OUTPUT_FILE, "Copied array: ");
        InputOutputUtils.writeToFileAndAppend(Arrays.toString(reverseIntArray(arr)), OUTPUT_FILE, "Reversed array: ");
    }

    private static double calcAverageValOfElements(int[] arr) {
        int sum = 0;
        double averageValue;
        for (int i : arr) {
            sum += i;
        }
        averageValue = (double) sum / arr.length;
        return averageValue;
    }

    private static int[] removeElementFromArray(int[] arr, int num) {
        int[] tempArr = new int[arr.length - 1];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != num) {
                tempArr[j] = arr[i];
                j++;
            }
        }
        return tempArr;
    }

    private static List<Integer> removeElementFromArrayUsingList(int[] arr, int num) {
        List<Integer> list = new ArrayList<>();
        for (int element : arr) {
            if (element != num) {
                list.add(element);
            }
        }
        return list;
    }

    private static int[] copyArrayByIteration(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tempArr[i] = arr[i];
        }
        return tempArr;
    }

    private static int[] reverseIntArray(int[] arr) {
        int[] tempArr = new int[arr.length];
        for (int i = arr.length - 1, j = 0; i >= 0 && j < arr.length; i--, j++) {
            tempArr[j] = arr[i];
        }
        return tempArr;
    }
}
