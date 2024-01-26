package com.prog2.main.Process.Sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * This is the sorting class for the staff and teacher.
 * 
 * @version 1.1
 * @since 2023/5/4
 * @author Jiucheng Zang
 * 
 */

public class Sort {

    /**
     * @param sortList
     * @param c
     */
    public static <T> void sort(ArrayList<T> sortList, Comparator<T> c) {
        int sortIndex = 0;
        Object[] a = sortList.toArray();
        Object[] aux = a.clone();
        switch (sortIndex) {
            case 0:
                MergeSort.mergeSort(aux, a, 0, a.length, 0, c);
                break;
            case 1:
                BubbleSort.bubbleSort(a, c);
                break;
            case 2:
                throw new UnsupportedOperationException("Not supported Sort Algorithm yet.");
        }

        ListIterator<T> i = sortList.listIterator();
        try {
            for (Object e : a) {
                i.next();
                i.set((T) e);
            }
        } catch (Exception ex) {
            throw new IllegalArgumentException("Sort Error: " + ex.getMessage());
        }
    }
}
