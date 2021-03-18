package task_15;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class WorkingWithArrayLists {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_task_15.txt";
    private static final String OUTPUT_FILE = "target/logs/output_task_15";

    public static void main(String[] args) throws IOException {
        ArrayList<String> arrayList = InputOutputUtils.readArrayListFromFileToString(INPUT_FILE);
        LinkedList<String> linkedList = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE);
        InputOutputUtils.writeToFile(arrayList, OUTPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(printElementFromSpecificPosition(arrayList, 2), OUTPUT_FILE, "Print element from the specific position (index = 2): ");
        InputOutputUtils.writeToFileAndAppend(insertElementAtSpecificPosition(linkedList, 10, "X"), OUTPUT_FILE, "Insert 'X' in the 10th position: ");
        InputOutputUtils.writeToFileAndAppend(emptyAnArrayList(arrayList), OUTPUT_FILE, "Empty the list: ");
    }

    private static String printElementFromSpecificPosition(ArrayList<String> list, int position) {
        for (int i = 0; i < list.size(); i++) {
            if (i == position) {
                return list.get(i);
            }
        }
        return null;
    }

    private static LinkedList<String> insertElementAtSpecificPosition(LinkedList<String> list, int position, String element) {
        for (int i = list.size(); i <= position; i++) {
            if (i == position) {
                list.add(i, element);
            } else {
                list.add(i, "temp");
            }
        }
        return list;
    }

    private static ArrayList<String> emptyAnArrayList(ArrayList<String> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        return list;
    }

    private static ArrayList<String> reverseElementsInArrayList(ArrayList<String> list) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = list.size(); i-- > 0; ) {
            stringArrayList.add(list.get(i));
        }
        return stringArrayList;
    }

    private static ArrayList<String> removeDuplicatedElementsFromArrayList(ArrayList<String> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }

}
