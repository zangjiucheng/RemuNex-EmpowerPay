package com.prog2.main.Process.Comparator;

import java.util.Comparator;

import com.prog2.main.Process.Staff;
import com.prog2.main.Process.Teacher;

/**
 * This is the comparator class for the salary of the staff and teacher.
 * 
 * @version 1.1
 * @since 2023/5/4
 * @author Jiucheng Zang
 */

public class IDComparator<T> implements Comparator<T> {
    private Class<T> type;

    public IDComparator(Class<T> cls) {
        type = cls;
    }

    /**
     * @return Class<T>
     */
    Class<T> getType() {
        return type;
    }

    /**
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(T o1, T o2) {
        if (getType().equals(Teacher.class)) {
            Teacher t1 = (Teacher) o1;
            Teacher t2 = (Teacher) o2;
            return t1.prngId().compareTo(t2.prngId());
        } else if (getType().equals(Staff.class)) {
            Staff t1 = (Staff) o1;
            Staff t2 = (Staff) o2;
            return t1.prngId().compareTo(t2.prngId());
        } else {
            return 0;
        }
    }
}
