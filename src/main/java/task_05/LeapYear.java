package task_05;

import utils.InputOutputUtils;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class LeapYear {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_fifthtask";
    private static final String OUTPUT_FILE_ONE = "target/logs/output_fifthtask_one";
    private static final String OUTPUT_FILE_TWO = "target/logs/output_fifthtask_two";

    public static void main(String[] args) throws IOException {
        int number = InputOutputUtils.readOnlyOneIntFromFile(INPUT_FILE);
        InputOutputUtils.writeToFile(calcLeapYearUsingWhile(number), OUTPUT_FILE_ONE);
        InputOutputUtils.writeToFile(calcLeapYearUsingForLoop(number), OUTPUT_FILE_TWO);

    }

    public static List<Integer> calcLeapYearUsingWhile(int n) {
        List<Integer> years = new ArrayList<>();
        int year = Year.now().getValue();
        int count = 0;
        while (count < n) {
            ++year;
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                count++;
                years.add(year);
            }
        }
        return years;
    }

    public static List<Integer> calcLeapYearUsingForLoop(int n) {
        List<Integer> years = new ArrayList<>();
        int year = Year.now().getValue();
        for (int i = 0; i < n; ) {
            ++year;
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                i++;
                years.add(year);
            }
        }
        return years;
    }
}
