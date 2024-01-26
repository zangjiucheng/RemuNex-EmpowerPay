package com.prog2.main.Process;

import java.io.Serializable;
import java.util.Objects;

/**
 * This class is used to create a dean object
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public class Dean implements Serializable {

    private Teacher teacher;

    public Dean(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @return Teacher
     */
    public Teacher getTeacher() {
        return this.teacher;
    }

    /**
     * @param teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dean)) {
            return false;
        }
        Dean dean = (Dean) o;
        return Objects.equals(teacher, dean.teacher);
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                "'" + getTeacher() + "'" +
                "}";
    }

}