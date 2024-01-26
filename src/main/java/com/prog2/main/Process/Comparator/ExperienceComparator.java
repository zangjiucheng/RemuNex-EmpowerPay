package com.prog2.main.Process.Comparator;

import java.util.Comparator;

import com.prog2.main.Process.Teacher;

/**
 * This is the comparator class for the experience of the teacher.
 * 
 * @version 1.1
 * @since 2023/5/4
 * @author Jiucheng Zang
 */

public class ExperienceComparator implements Comparator<Teacher> {

    /**
     * @param o1
     * @param o2
     * @return int
     */
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getYearsOfExperience() - o2.getYearsOfExperience();
    }
}
