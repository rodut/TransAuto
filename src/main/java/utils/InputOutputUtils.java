package utils;

import java.io.*;
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

    public static int[][] readTwoDimensionalArrayFromFile(String path) throws FileNotFoundException {
        int[][] array;
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        int arraySize = scanner.nextLine().trim().split("\\s+").length;
        scanner.close();
        array = new int[arraySize][arraySize];
        scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            for (int i = 0; i < currentLine.length; i++) {
                array[lineCount][i] = Integer.parseInt(currentLine[i]);
            }
            lineCount++;
        }
        return array;
    }

    public static void writeTwoDimensionalArrayToFile(int[][] array, String path, String message) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                builder.append(array[i][j]);
                if (j < array.length - 1)
                    builder.append(" ");
            }
            builder.append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(message + builder.toString());
        writer.close();
    }
}
