package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InputOutputUtils {

    public static <T> void writeToFile(T data, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("The result is: " + data);
        fileWriter.close();
    }

    public static int[] readFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner firstScanner = new Scanner(file);
        int arrLength = 0;
        while (firstScanner.hasNextInt()) {
            arrLength++;
            firstScanner.nextInt();
        }
        int[] array = new int[arrLength];
        Scanner secondScanner = new Scanner(file);
        for (int i = 0; i < array.length; i++) {
            array[i] = secondScanner.nextInt();
        }
        firstScanner.close();
        secondScanner.close();
        return array;
    }

    public static int readOnlyOneIntFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        return scanner.nextInt();
    }
}
