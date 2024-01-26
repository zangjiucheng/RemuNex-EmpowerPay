package com.prog2.main.Process.Comparator;

import java.util.Comparator;

import com.prog2.main.Process.Staff;

/**
 * This is the comparator class for the workload of the staff.
 * 
 * @version 1.1
 * @since 2023/5/4
 * @author Jiucheng Zang
 */

public class WorkLoadComparator implements Comparator<Staff> {

    /**
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Staff o1, Staff o2) {
        return o1.getWorkLoad() - o2.getWorkLoad();
    }
}
