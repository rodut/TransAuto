package task_10;

import task_09.SegregationOf0sAnd1s;
import utils.InputOutputUtils;

import java.io.*;

public class Segregate0From1InA2DArray {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_tenthtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_tenthtask.txt";

    public static void main(String... args) throws IOException {
        int[][] arr = InputOutputUtils.readTwoDimensionalJaggedArrayFromFile(INPUT_FILE);
        int[][] result = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            result[i] = new int[arr[i].length];
            result[i] = SegregationOf0sAnd1s.segregate0sFrom1s(arr[i]);
        }
        InputOutputUtils.writeTwoDimensionalArrayToFile(result, OUTPUT_FILE, "Result: \n");
    }
}
