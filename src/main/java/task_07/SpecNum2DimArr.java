package task_07;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecNum2DimArr {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_seventhtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_seventhtask.txt";

    public static void main(String[] args) throws IOException {
        int[][] arr = InputOutputUtils.readTwoDimensionalArrayFromFile(INPUT_FILE);
        int n = 5;
        InputOutputUtils.writeToFile(findSpecifiedNumber(arr, n), OUTPUT_FILE);
    }

    private static List<String> findSpecifiedNumber(int[][] arr, int num) {
        List<String> locations = new ArrayList<>();
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (arr[row][col] == num) {
                    String location = String.format("[%s, %s]", row, col);
                    locations.add(location);
                }
            }
        }
        return locations;
    }
}
