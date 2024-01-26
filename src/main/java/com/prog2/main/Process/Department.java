package com.prog2.main.Process;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * This class is used to create a department object
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public class Department implements Serializable {

    public Department(String name) {
        this.name = name;
        this.staffList = new ArrayList<Staff>();
        this.teacherList = new ArrayList<Teacher>();
        this.dean = null;
        id++;
    }

    public Department(String name, ArrayList<Staff> staffList, ArrayList<Teacher> teacherList) {
        this.name = name;
        this.staffList = staffList;
        this.teacherList = teacherList;
    }

    /**
     * @param teacher
     */
    public void addTeacher(Teacher teacher) {
        this.teacherList.add(teacher);
    }

    /**
     * @param staff
     */
    public void addStaff(Staff staff) {
        this.staffList.add(staff);
    }

    /**
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param name
     * @return Department
     */
    public Department name(String name) {
        setName(name);
        return this;
    }

    /**
     * @return ArrayList<Staff>
     */
    public ArrayList<Staff> getStaffList() {
        return this.staffList;
    }

    public void setStaffList(ArrayList<Staff> staffList) {
        this.staffList = staffList;
    }

    public ArrayList<Teacher> getTeacherList() {
        return this.teacherList;
    }

    public void setTeacherList(ArrayList<Teacher> teacherList) {
        boolean status = false;
        for (Teacher teacher : teacherList) {
            if (teacher.equals(dean.getTeacher())) {
                status = true;
                break;
            }
        }
        if (status) {
            this.teacherList = teacherList;
        } else {
            throw new IllegalArgumentException("The dean is not been include in the teacher list");
        }
    }

    public Dean getDean() {
        return this.dean;
    }

    public void setDean(Dean dean) {
        Teacher deanTeacher = dean.getTeacher();
        boolean status = false;
        if (deanTeacher.getDepartment().equals(this.name)) {
            for (Teacher teacher : this.teacherList) {
                if (teacher.equals(deanTeacher)) {
                    status = true;
                    break;
                }
            }
            if (status) {
                this.dean = dean;
            } else {
                throw new IllegalArgumentException(
                        "The dean must be from the same department as the teacher (Teacher is not in the teacher list)");
            }
        } else {
            throw new IllegalArgumentException(
                    "The dean must be from the same department as the teacher (Teacher department string is not equal to department name)");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Department)) {
            return false;
        }
        Department department = (Department) o;
        return Objects.equals(staffList, department.staffList) && Objects.equals(teacherList, department.teacherList)
                && Objects.equals(dean, department.dean);
    }

    public int getId() {
        return this.id;
    }

    public String prngId() {
        random.setSeed(getId());
        return "D" + random.nextInt(10000);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + prngId() + "'" +
                " name='" + getName() + "'" +
                ", staffList='" + getStaffList() + "'" +
                ", teacherList='" + getTeacherList() + "'" +
                ", dean='" + getDean() + "'" +
                "}";
    }

    private String name;
    private ArrayList<Staff> staffList = new ArrayList<Staff>();
    private ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
    private Dean dean;
    transient private static int n = 0;
    private int id = n++;
    protected Random random = new Random();

}
