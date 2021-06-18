package task_09;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.Arrays;

public class SegregationOf0sAnd1s {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_ninthtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_ninthtask.txt";

    public static void main(String[] args) throws IOException {
        int[] arr = InputOutputUtils.readFile(INPUT_FILE);
        InputOutputUtils.writeToFile(Arrays.toString(segregate(arr)), OUTPUT_FILE);
    }

    public static int[] segregate0sFrom1s(int[] arr) {
        int count = 0;
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (i < count) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        return array;
    }

    private static int[] segregate(int[] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                count++;
            }
        }
        int[] firstArr = new int[count];
        int[] secondArr = new int[arr.length - count];
        int indexArr1 = 0;
        int indexArr2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                firstArr[indexArr1] = 0;
                indexArr1++;
            }else{
                secondArr[indexArr2] = 1;
                indexArr2++;
            }
        }
        return concatenateArrays(firstArr, secondArr);
    }

    private static int[] concatenateArrays(int[] first, int[] second){
        int[] arr = new int[first.length + second.length];
        System.arraycopy(first, 0, arr, 0, first.length);
        System.arraycopy(second, 0, arr, first.length, second.length);
        return arr;
    }
}
