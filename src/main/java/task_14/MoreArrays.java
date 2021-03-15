package task_14;

import utils.InputOutputUtils;

import java.io.IOException;

public class MoreArrays {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_task_14_1.txt";
    private static final String OUTPUT_FILE = "target/logs/output_task_14.txt";

    public static void main(String[] args) throws IOException {
        int[] arr = InputOutputUtils.readFile(INPUT_FILE);
        InputOutputUtils.writeToFile(checkForTwoElements(arr, 65, 7), OUTPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(findConsecutiveSequence(arr), OUTPUT_FILE, "\nSecond result: ");
    }

    private static int findConsecutiveSequence(int[] arr) {
        int count = 0;
        int smallest = arr[0];
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }
        count++;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (smallest + 1 == arr[j]) {
                    count++;
                    smallest++;
                }
            }
        }
        return count;
    }

    private static boolean checkForTwoElements(int[] arr, int a, int b) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == a && arr[j] == b) {
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    private static boolean checkWithTwoVars(int[] arr, int a, int b) {
        boolean result = false;
        boolean first = false;
        boolean second = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == a){
                first = true;
            }
            if(arr[i] == b){
                second = true;
            }
        }
        if(first && second){
            result = true;
        }
        return result;
    }
}
