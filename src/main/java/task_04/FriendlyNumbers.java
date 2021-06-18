package task_04;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.*;

public class FriendlyNumbers {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_fourthtask";
    private static final String OUTPUT_FILE = "target/logs/fourthtask_output.txt";

    public static void main(String[] args) throws IOException {
        int number = InputOutputUtils.readOnlyOneIntFromFile(INPUT_FILE);
        InputOutputUtils.writeToFile(getAllFriendlyPairs(number), OUTPUT_FILE);
    }

    public static double calcAbundancyIndex(int number) {
        double sum = 0;
        double index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                sum += i;
            }
            index = sum / number;
        }
        return index;
    }

    public static HashMap<Integer, Double> sortByValue(HashMap<Integer, Double> map) {
        List<Map.Entry<Integer, Double>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());
        HashMap<Integer, Double> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Double> elem : list) {
            temp.put(elem.getKey(), elem.getValue());
        }
        return temp;
    }

    public static HashMap<Integer, Double> findEqualValues(HashMap<Integer, Double> map) {
        HashMap<Integer, Double> mapFriendlyPairs = new HashMap<>();
        Integer[] keys = map.keySet().toArray(new Integer[0]);
        for (Integer key : keys) {
            Double value = map.get(key);
            map.remove(key);
            if (map.containsValue(value)) {
                mapFriendlyPairs.put(key, value);
            }
            if (mapFriendlyPairs.containsValue(value)) {
                mapFriendlyPairs.put(key, value);
            }
        }
        return sortByValue(mapFriendlyPairs);
    }

    public static HashMap<Integer, Double> getAllFriendlyPairs(int number) {
        HashMap<Integer, Double> map = new HashMap<>();
        double index;
        for (int i = 6; i <= number; i++) {
            index = calcAbundancyIndex(i);
            map.put(i, index);
        }
        return findEqualValues(map);
    }
}
