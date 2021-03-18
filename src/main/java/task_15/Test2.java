package task_15;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2, 3}, {40, 50, 60}, {70, 80, 90}};
        int[][] arr2 = {{1, 40, 70}, {110, 120, 130}, {140, 150, 160}};
        int[][] arr3 = {{40, 50, 60}, {170, 180, 190}, {200, 210, 220}};
        System.out.println(findCommonElements(arr1, arr2));
        System.out.println(findCommonElements2(arr1, arr2, arr3));
    }

    private static List<Integer> findCommonElements(int[][] arr1, int[][] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    for (int l = 0; l < arr2.length; l++) {
                        if (arr1[i][j] == arr2[k][l]) {
                            if (!list.contains(arr2[k][l])) {
                                list.add(arr2[k][l]);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    private static List<Integer> findCommonElements2(int[][] arr1, int[][] arr2, int[][] arr3) {
        List<Integer> list = new ArrayList<>();
        int sum1 = 0;
        int sum2 = 0;
        int totalSum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    for (int l = 0; l < arr2.length; l++) {
                        if (arr1[i][j] == arr2[k][l]) {
                            if (!list.contains(arr2[k][l])) {
                                list.add(arr2[k][l]);
                                sum1 += arr2[k][l];
                            }
                        }
                        if (arr1[i][j] == arr3[k][l]) {
                            if (!list.contains(arr3[k][l])) {
                                list.add(arr3[k][l]);
                                sum2 += arr3[k][l];
                            }
                        }
                        totalSum = sum1 + sum2;
                    }
                }
            }
        }
        list.add(totalSum);
        return list;
    }
}
