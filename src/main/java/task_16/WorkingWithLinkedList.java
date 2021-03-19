package task_16;

import com.sun.media.jfxmediaimpl.HostUtils;
import utils.InputOutputUtils;

import java.io.IOException;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class WorkingWithLinkedList {
    private static final String INPUT_FILE1 = "src/main/resources/input_files/input_task_16.txt";
    private static final String INPUT_FILE2 = "src/main/resources/input_files/input_task_16_2.txt";
    private static final String OUTPUT_FILE = "target/logs/output_task_16.txt";

    public static void main(String[] args) throws IOException {
        LinkedList<String> linkedList1 = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE1);
        LinkedList<String> linkedList2 = InputOutputUtils.readLinkedListFromFileToString(INPUT_FILE2);
        InputOutputUtils.writeToFileAndAppend(joinTwoLinkedLists(linkedList1, linkedList2), OUTPUT_FILE, "Joined Linked Lists: ");
        InputOutputUtils.writeToFileAndAppend(joinTwoLinkedListUsingCollections(linkedList1, linkedList2), OUTPUT_FILE, "Joined LL using Collections: ");
        InputOutputUtils.writeToFileAndAppend(swapTwoElementsInLinkedListByIndex(linkedList1, 0, 4), OUTPUT_FILE, "Swapping two elements: ");
    }

    private static <T> LinkedList<T> swapTwoElementsInLinkedListByIndex(LinkedList<T> list, int index1, int index2) {
        T first = list.get(index1);
        T second = list.get(index2);
        list.set(index2, first);
        list.set(index1, second);
        return list;
    }

    private static <T> LinkedList<T> joinTwoLinkedLists(LinkedList<T> list1, LinkedList<T> list2) {
        LinkedList<T> linkedList = new LinkedList<>();
        int size = list1.size() + list2.size();
        for (int i = 0, j = 0; i < size; i++) {
            if (i < list1.size()) {
                linkedList.add(list1.get(i));
            } else {
                linkedList.add(list2.get(j));
                j++;
            }
        }
        return linkedList;
    }

    private static <T> LinkedList<T> joinTwoLinkedListUsingCollections(LinkedList<T> list1, LinkedList<T> list2) {
        return new LinkedList<T>() {{
            addAll(list1);
            addAll(list2);
        }};
    }
}
