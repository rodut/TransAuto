package task_06;

import utils.*;

import java.io.*;
import java.util.*;

public class ThreeArrays {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_sixthtask.txt";
    private static final String OUTPUT_FILE = "target/logs/output_sixthtask.txt";

    public static void main(String[] args) throws IOException {
        List<int[]> intList = new ArrayList<>();
        Scanner scanner = new Scanner(new File(INPUT_FILE));
        List<String> stringList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            stringList.add(scanner.nextLine());
        }
        scanner.close();
        for (String s : stringList) {
            String[] strings = s.trim().split("\\s+");
            int[] nums = new int[strings.length];
            for (int j = 0; j < strings.length; j++) {
                nums[j] = Integer.parseInt(strings[j]);
            }
            intList.add(nums);
        }
        int[] initialResult = mergeTwoSortedArrays(intList.get(0), intList.get(1));
        int[] finalResult = mergeTwoSortedArrays(initialResult, intList.get(2));
        InputOutputUtils.writeToFile(Arrays.toString(finalResult), OUTPUT_FILE);
    }

    public static int[] mergeTwoSortedArrays(int[] firstArray, int[] secondArray) {
        int i = 0, j = 0, k = 0;
        int firstLength = firstArray.length;
        int secondLength = secondArray.length;
        int[] thirdArray = new int[firstLength + secondLength];
        while (i < firstLength && j < secondLength) {
            if (firstArray[i] < secondArray[j]) {
                thirdArray[k] = firstArray[i];
                k++;
                i++;
            } else {
                thirdArray[k] = secondArray[j];
                k++;
                j++;
            }
        }
        while (i < firstLength) {
            thirdArray[k] = firstArray[i];
            k++;
            i++;
        }
        while (j < secondLength) {
            thirdArray[k] = secondArray[j];
            k++;
            j++;
        }
        return thirdArray;
    }
}
