package utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InputOutputUtils {

    public static <T> void writeToFile(T data, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write("The result is: " + data + "\n");
        fileWriter.close();
    }

    public static <T> void writeToFileAndAppend(T data, String path, String message) throws IOException {
        FileWriter fileWriter = new FileWriter(path, true);
        fileWriter.write(message + data + "\n");
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

    public static List<int[]> readTwoArraysFromFile(String path) throws IOException {
        List<String> result = Files.readAllLines(Paths.get(path));
        List<int[]> intList = new ArrayList<>();
        for (String s : result) {
            String[] strings = s.trim().split("\\s+");
            int[] nums = new int[strings.length];
            for (int j = 0; j < strings.length; j++) {
                nums[j] = Integer.parseInt(strings[j]);
            }
            intList.add(nums);
        }
        return intList;
    }

    public static LinkedList<String> readLinkedListFromFileToString(String path) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(path));
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : list) {
            String[] strings = s.trim().split("\\s+");
            linkedList.addAll(Arrays.asList(strings));
        }
        return linkedList;
    }

    public static ArrayList<String> readArrayListFromFileToString(String path) throws IOException {
        List<String> list = Files.readAllLines(Paths.get(path));
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : list) {
            String[] strings = s.trim().split("\\s+");
            arrayList.addAll(Arrays.asList(strings));
        }
        return arrayList;
    }

    public static int readOnlyOneIntFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        return scanner.nextInt();
    }

    public static void writeTwoDimensionalArrayToFile(int[][] array, String path, String message) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                builder.append(array[i][j]);
                if (j < array[i].length - 1)
                    builder.append(" ");
            }
            builder.append("\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(message + builder.toString());
        writer.close();
    }

    public static void writeListToFile(List<int[]> list, String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        bw.write("Result: \n");
        for (int[] arr : list) {
            bw.write(Arrays.toString(arr));
            bw.newLine();
        }
        bw.close();
    }

    public static int[][] readTwoDimensionalJaggedArrayFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        int countLines = 0;
        List<String[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            countLines++;
            list.add(currentLine);
        }
        scanner.close();
        int[][] arr = new int[countLines][];
        for (int i = 0; i < list.size(); i++) {
            int size = list.get(i).length;
            arr[i] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(list.get(i)[j]);
            }
        }
        return arr;
    }

    public static int[][] readTwoDimensionalArrayFromFile(String path) throws FileNotFoundException {
        int[][] array;
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        int size = scanner.nextLine().trim().split("\\s+").length;
        scanner.close();
        array = new int[size][size];
        scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            String[] currentLine = scanner.nextLine().trim().split("\\s+");
            for (int i = 0; i < currentLine.length; i++) {
                array[lineCount][i] = Integer.parseInt(currentLine[i]);
            }
            lineCount++;
        }
        scanner.close();
        return array;
    }

    public static List<int[][]> readTwoMatricesFromFile(String path) throws FileNotFoundException {
        List<int[][]> matrices = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        int size = scanner.nextLine().trim().split("\\s+").length;
        scanner.close();
        int[][] firstArr = new int[size][size];
        int[][] secondArr = new int[size][size];
        scanner = new Scanner(new File(path));
        int linesFirstArr = 0;
        int linesSecondArr = 0;
        boolean initialArr = true;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("===")) {
                initialArr = false;
                continue;
            }
            if (initialArr) {
                String[] firstArrLine = line.trim().split("\\s+");
                for (int i = 0; i < firstArrLine.length; i++) {
                    firstArr[linesFirstArr][i] = Integer.parseInt(firstArrLine[i]);
                }
                linesFirstArr++;
            } else {
                String[] secondArrLine = line.trim().split("\\s+");
                for (int i = 0; i < secondArrLine.length; i++) {
                    secondArr[linesSecondArr][i] = Integer.parseInt(secondArrLine[i]);
                }
                linesSecondArr++;
            }
        }
        matrices.add(firstArr);
        matrices.add(secondArr);
        scanner.close();
        return matrices;
    }
}
