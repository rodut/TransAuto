package task_07;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    private static final String INPUT_FILE = "src/main/resources/input_files/test";
    private static final String OUTPUT_FILE = "target/logs/text.txt";

    public static void main(String[] args) throws IOException {
        int[][] arr = InputOutputUtils.readTwoDimensionalArrayFromFile(INPUT_FILE);
        InputOutputUtils.writeToFile(calcMaxValCol(arr), OUTPUT_FILE);
    }

    private static List<Integer> calcMaxValCol(int[][] arr) {
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int a = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > a) {
                    a = arr[i][j];
                }
            }
            results.add(a);
        }
        return results;
    }
}
