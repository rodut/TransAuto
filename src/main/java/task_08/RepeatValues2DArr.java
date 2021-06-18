package task_08;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepeatValues2DArr {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_eighthtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_eighthtask.txt";

    public static void main(String[] args) throws IOException {
        int[][] arr = InputOutputUtils.readTwoDimensionalArrayFromFile(INPUT_FILE);
        InputOutputUtils.writeToFile(findRepeatingValuesIn2DArray(arr), OUTPUT_FILE);
    }

    private static List<Integer> findRepeatingValuesIn2DArray(int[][] arr) {
        List<Integer> result = new ArrayList<>();
        int length = arr.length;
        for (int indexCol = 0; indexCol < length; indexCol++) {
            for (int indexRow = 0; indexRow < length - 1; indexRow++) {
                for (int k = indexCol + 1; k < length; k++) {
                    for (int l = 0; l < length - 1; l++) {
                        if (arr[indexRow][indexCol] == arr[l][k]) {
                            result.add(arr[l][k]);
                        }
                    }
                }
            }
        }
        return result.stream().distinct().sorted().collect(Collectors.toList());
    }
}
