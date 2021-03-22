package task_17;

import utils.InputOutputUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class WorkingWithLinkedLists {
    private static final String INPUT_FILE = "src/main/resources/input_files/input_task_17.txt";
    private static final String OUTPUT_FILE = "target/logs/output_task_17";

    public static void main(String[] args) throws IOException {
        LinkedList<String> linkedList = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(linkedList, OUTPUT_FILE, "Initial LL: ");
        InputOutputUtils.writeToFileAndAppend(shuffleLinkedListUsingCollections(linkedList), OUTPUT_FILE, "LL shuffled using Collection: ");
        InputOutputUtils.writeToFileAndAppend(shuffleLinkedListUsingRandom(linkedList), OUTPUT_FILE, "LL shuffled using algorithm: ");
        LinkedList<String> linkedList1 = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(linkedList1, OUTPUT_FILE, "Initial LL: ");
        InputOutputUtils.writeToFileAndAppend(swapTwoElementsInLinkedListByIndex(linkedList1, 1, 3), OUTPUT_FILE, "Swap by index 1 & 3: ");
        LinkedList<String> linkedList2 = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE);
        InputOutputUtils.writeToFileAndAppend(linkedList2, OUTPUT_FILE, "Initial LL: ");
        LinkedList<Integer> integers = new LinkedList<>();
        for (String s : linkedList2) {
            integers.add(Integer.parseInt(s));
        }
        InputOutputUtils.writeToFileAndAppend(swapTwoValuesInLinkedList(integers, 1, 4), OUTPUT_FILE, "Swap by algorithm 1 & 4: ");
    }

    private static <T> LinkedList<T> swapTwoValuesInLinkedList(LinkedList<T> linkedList, T value1, T value2) {
        LinkedList<T> list = new LinkedList<>(linkedList);
        int size = linkedList.size();
        for (int i = 0; i < size; i++) {
            T temp = linkedList.get(i);
            for (int j = i + 1; j < size - i; j++) {
                if (linkedList.get(i) == value1 && linkedList.get(j) == value2) {
                    list.set(i, linkedList.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    private static <T> LinkedList<T> swapTwoElementsInLinkedListByIndex(LinkedList<T> linkedList, int i, int j) {
        T temp = linkedList.get(i);
        linkedList.set(i, linkedList.get(j));
        linkedList.set(j, temp);
        return linkedList;
    }

    private static <T> LinkedList<T> shuffleLinkedListUsingRandom(LinkedList<T> linkedList) {
        LinkedList<T> list = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < linkedList.size(); i++) {
            int index = random.nextInt(i + 1);
            list.add(index, linkedList.get(i));
        }
        return list;
    }

    private static <T> LinkedList<T> shuffleLinkedListUsingCollections(LinkedList<T> linkedList) {
        Collections.shuffle(linkedList);
        return linkedList;
    }
}
