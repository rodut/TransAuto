package task_13;

import utils.InputOutputUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithArrays {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_task_13.txt";
    private static final String INPUT_FILE2 = "src/main/resources/input_files/input_task_13_value.txt";
    private static final String INPUT_FILE3 = "src/main/resources/input_files/input_eleventhtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_task_13.txt";
    private static final String OUTPUT_FILE2 = "target/logs/output_task_13_two_pairs.txt";

    public static void main(String[] args) throws IOException {
        int[] arr = InputOutputUtils.readFile(INPUT_FILE);
        int[] arr1 = InputOutputUtils.readFile(INPUT_FILE3);
        InputOutputUtils.writeToFile(findSmallestAndSecondSmallestElements(arr1), OUTPUT_FILE);
        int n = InputOutputUtils.readOnlyOneIntFromFile(INPUT_FILE2);
        InputOutputUtils.writeToFileAndAppend(findSumOfTwoElementsEqualsGivenInt(arr, n), OUTPUT_FILE2, "Result: ");
        InputOutputUtils.writeToFileAndAppend(findSumOfAllElementsEqualsGivenInt(arr, n), OUTPUT_FILE2, "Result: ");
    }

    private static List<String> findSumOfAllElementsEqualsGivenInt(int[] arr, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            String temp = String.valueOf(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    list.add(arr[i] + " + " + arr[j]);
                }
                if (sum + arr[j] <= n) {
                    sum += arr[j];
                    temp += " + " + arr[j];
                    if (sum == n) {
                        list.add(temp);
                    }
                }
            }
        }
        return list;
    }

    private static List<String> findSumOfTwoElementsEqualsGivenInt(int[] arr, int n) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == n) {
                    list.add(arr[i] + " + " + arr[j]);
                }
            }
        }
        return list;
    }

    private static List<Integer> findSmallestAndSecondSmallestElements(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int size = arr.length;
        int smallest = arr[0];
        int secondSmallest = arr[0];
        for (int i = 0; i < size; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            } else if (secondSmallest > arr[i] && secondSmallest != smallest) {
                secondSmallest = arr[i];
            }
        }
        list.add(smallest);
        list.add(secondSmallest);
        return list;
    }

}
