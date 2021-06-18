package task_02;

import utils.*;
import java.io.IOException;

public class NumberPi {

    private static final String INPUTFILE = "src/main/resources/input_files/input_secondtask.txt";
    private static final String OUTPUT = "target/logs/output_secondtask.txt";

    public static void main(String[] args) throws IOException {
        int n = InputOutputUtils.readOnlyOneIntFromFile(INPUTFILE);
        double temp, pi = 0;
        for (int i = 1; i <= Math.pow(10, n); i++) {
            if (i % 2 == 0) {
                temp = -4.0 / (2 * i - 1);
            } else {
                temp = 4.0 / (2 * i - 1);
            }
            pi += temp;
        }
        InputOutputUtils.writeToFile(DecimalUtils.roundDecimalNumber(pi, n), OUTPUT);
    }
}
