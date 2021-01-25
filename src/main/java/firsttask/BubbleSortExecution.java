package firsttask;

import utils.InputOutputUtils;
import java.io.*;

public class BubbleSortExecution {
    private static final String INPUTFILE = "src/main/resources/input_files/input.txt";
    private static final String OUTPUTFILE = "target/logs/output.txt";

    public static void main(String[] args) throws IOException {
        int[] data = InputOutputUtils.readFile(INPUTFILE);
        BubbleSort.usingBubbleSort(data);
        InputOutputUtils.writeToFile(data, OUTPUTFILE);
    }
}
