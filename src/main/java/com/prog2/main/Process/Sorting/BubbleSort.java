package com.prog2.main.Process.Sorting;

import java.util.Comparator;

/**
 * BubbleSort
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023/5/8
 * 
 */

class BubbleSort {

    /**
     * @param arr[]
     * @param c
     */
    public static void bubbleSort(Object arr[], Comparator c) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void bubbleSort(Object arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0) {
                    // swap arr[j+1] and arr[j]
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

}