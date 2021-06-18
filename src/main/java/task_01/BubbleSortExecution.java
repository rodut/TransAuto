package task_01;

import utils.InputOutputUtils;
import java.io.*;
import java.util.Arrays;

public class BubbleSortExecution {
    private static final String INPUTFILE = "src/main/resources/input_files/input_firsttask.txt";
    private static final String OUTPUTFILE = "target/logs/output.txt";

    public static void main(String[] args) throws IOException {
        int[] data = InputOutputUtils.readFile(INPUTFILE);
        BubbleSort.usingBubbleSort(data);
        InputOutputUtils.writeToFile(Arrays.toString(data), OUTPUTFILE);
    }
}
