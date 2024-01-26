package com.prog2.main.GUI;

import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.prog2.main.Process.*;
import com.prog2.main.Process.Comparator.SalaryComparator;
import com.prog2.main.Process.Comparator.SpecialtyComparator;
import com.prog2.main.Process.Comparator.WorkLoadComparator;
import com.prog2.main.Process.Sorting.Sort;
import com.prog2.main.Process.Comparator.DutyComparator;
import com.prog2.main.Process.Comparator.ExperienceComparator;
import com.prog2.main.Process.Comparator.IDComparator;
import com.prog2.main.Process.Comparator.NameComparator;

/**
 * Refresh Data
 * 
 * @author Jiucheng Zang
 * @version 1.1
 * @since 2023-03-27
 * @see com.prog2.main.GUI.mainGUI
 * 
 */

public class RefreshData {

    /**
     * @param department
     * @param status
     * @return String[][]
     */
    public static String[][] refreshTeacher(Department department, boolean status, int order) {
        String[][] dataT = new String[department.getTeacherList().size()][10];
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        for (Teacher t : department.getTeacherList()) {
            teacherList.add(t);
        }
        // ArrayList<Teacher> teacherList = department.getTeacherList();
        switch (order) {
            case -1:
                break;
            case 0:
                Sort.sort(teacherList, new NameComparator<Teacher>(Teacher.class));
                // Collections.sort(teacherList, new NameComparator<Teacher>(Teacher.class));
                break;
            case 1:
                Sort.sort(teacherList, new IDComparator<Teacher>(Teacher.class));
                break;
            case 2:
                Sort.sort(teacherList, new SalaryComparator<Teacher>(Teacher.class));
                break;
            case 3:
                Sort.sort(teacherList, new SpecialtyComparator());
                break;
            case 4:
                Sort.sort(teacherList, new ExperienceComparator());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Order");
                break;
        }

        for (int i = 0; i < teacherList.size(); i++) {
            try {
                String[] liData;
                Teacher teacher = teacherList.get(i);
                String name = teacher.getName();
                String email = teacher.getEmail();
                String id = teacher.prngId();
                String phone = teacher.getPhone();
                String gender = Character.toString(teacher.getGender());
                String specialty = teacher.getSpecialty();
                String experience = String.valueOf(teacher.getYearsOfExperience());
                String degree = Character.toString(teacher.getDegree());
                String salary = String.valueOf(teacher.getSalary());
                String hoursWorked = "Not Applicable";
                if (id.charAt(0) == 'F') {
                } else if (id.charAt(0) == 'P') {
                    PartTimeTeacher pTeacher = (PartTimeTeacher) teacher;
                    hoursWorked = String.valueOf(pTeacher.getHoursWorked());
                    mainGUI.partTimeList.add(i);
                } else {
                    throw new IllegalArgumentException("Invalid ID");
                }
                if (status) {
                    String[] tempData = { String.valueOf(i), name, id, phone, email, gender, specialty, experience,
                            degree, salary,
                            hoursWorked };
                    liData = tempData;
                } else {
                    String[] tempData = { name, id, phone, email, gender, specialty, experience, degree, salary,
                            hoursWorked };
                    liData = tempData;
                }
                dataT[i] = liData;
            } catch (NullPointerException e) {
                if (i == 0)
                    throw new NullPointerException("No Teacher");
                else
                    throw new NullPointerException("TeacherData is not complete");
            }
        }
        return dataT;
    }

    /**
     * @param department
     * @param status
     * @return String[][]
     */
    public static String[][] refreshStaff(Department department, boolean status, int order) {
        String[][] dataS = new String[department.getStaffList().size()][8];
        ArrayList<Staff> staffList = new ArrayList<Staff>();
        for (Staff s : department.getStaffList()) {
            staffList.add(s);
        }
        // ArrayList<Staff> staffList = department.getStaffList();
        switch (order) {
            case -1:
                break;
            case 0:
                Sort.sort(staffList, new NameComparator<Staff>(Staff.class));
                break;
            case 1:
                Sort.sort(staffList, new IDComparator<Staff>(Staff.class));
                break;
            case 2:
                Sort.sort(staffList, new SalaryComparator<Staff>(Staff.class));
                break;
            case 3:
                Sort.sort(staffList, new DutyComparator());
                break;
            case 4:
                Sort.sort(staffList, new WorkLoadComparator());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid Order");
                break;
        }
        for (int i = 0; i < staffList.size(); i++) {
            try {
                String[] liData;
                Staff staff = staffList.get(i);
                String name = staff.getName();
                String email = staff.getEmail();
                String id = staff.prngId();
                String phone = staff.getPhone();
                String gender = Character.toString(staff.getGender());
                String workload = String.valueOf(staff.getWorkLoad());
                String duty = staff.getDuty();
                String salary = String.valueOf(staff.getSalary());
                if (status) {
                    String[] tempData = { String.valueOf(i), name, id, phone, email, gender, workload, duty, salary };
                    liData = tempData;
                } else {
                    String[] tempData = { name, id, phone, email, gender, workload, duty, salary };
                    liData = tempData;
                }
                dataS[i] = liData;
            } catch (NullPointerException e) {
                if (i == 0)
                    throw new NullPointerException("No Staff");
                else
                    throw new NullPointerException("StaffData is not complete");
            }
        }
        return dataS;
    }

    /**
     * @param department
     * @param dataD
     * @return String[]
     */
    public static String[] refreshDean(Department department, String[] dataD) {
        String newDataD[] = new String[9];
        try {
            Teacher dean = department.getDean().getTeacher();
            newDataD[0] = dataD[0].substring(0, dataD[0].length() - 8) + dean.getName() + "</html>";
            newDataD[1] = dataD[1].substring(0, dataD[1].length() - 8) + dean.prngId() + "</html>";
            newDataD[2] = dataD[2].substring(0, dataD[2].length() - 8) + dean.getPhone() + "</html>";
            newDataD[3] = dataD[3].substring(0, dataD[3].length() - 8) + dean.getEmail() + "</html>";
            newDataD[4] = dataD[4].substring(0, dataD[4].length() - 8) + dean.getGender() + "</html>";
            newDataD[5] = dataD[5].substring(0, dataD[5].length() - 8) + dean.getSpecialty() + "</html>";
            newDataD[6] = dataD[6].substring(0, dataD[6].length() - 8) + dean.getYearsOfExperience() + "</html>";
            newDataD[7] = dataD[7].substring(0, dataD[7].length() - 8) + dean.getDegree() + "</html>";
            newDataD[8] = dataD[8].substring(0, dataD[8].length() - 8) + dean.getSalary() + "</html>";
        } catch (NullPointerException e) {
            // JOptionPane.showMessageDialog(null, "No Dean Been Set");
            // System.out.println("No Dean");
            // throw new NullPointerException("No Dean");
        }
        return newDataD;
    }

    /**
     * @param dataBase
     * @return ArrayList<JMenuItem>
     */
    public static ArrayList<JMenuItem> refreshDepartment(Database dataBase) {
        ArrayList<JMenuItem> departmentList = new ArrayList<JMenuItem>();
        for (int i = 0; i < dataBase.getDepartmentList().size(); i++) {
            Department department = dataBase.getDepartmentList().get(i);
            JMenuItem departmentItem = new JMenuItem(department.getName());
            departmentList.add(departmentItem);
        }
        return departmentList;
    }

}
