package com.prog2.main;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.prog2.main.Process.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 *
 * @author jiucheng
 */
public class SalaryCalculateTest {

    @Test
    void PartTimeTeacherSalaryCalculateTest1() {
        PartTimeTeacher teacher = new PartTimeTeacher(new Teacher("", "", "", 'X', "", 0, 'B',
                ""), 5);
        double actual = teacher.getSalary();
        double expected = 319.2;
        assertEquals(expected, actual);
    }

    @Test
    void PartTimeTeacherSalaryCalculateTest2() {
        PartTimeTeacher teacher = new PartTimeTeacher(new Teacher("", "", "", 'X', "", 0, 'B',
                ""), 15);
        double actual = teacher.getSalary();
        double expected = 957.6;
        assertEquals(expected, actual);
    }

    @Test
    void PartTimeTeacherSalaryCalculateTest3() {
        PartTimeTeacher teacher = new PartTimeTeacher(new Teacher("", "", "", 'X', "", 0, 'M',
                ""), 3);
        double actual = teacher.getSalary();
        double expected = 373.92;
        assertEquals(expected, actual);
    }

    @Test
    void PartTimeTeacherSalaryCalculateTest4() {
        PartTimeTeacher teacher = new PartTimeTeacher(new Teacher("", "", "", 'X', "", 0, 'M',
                ""), 10);
        double actual = teacher.getSalary();
        double expected = 1246.4;
        assertEquals(expected, actual);
    }

    @Test
    void PartTimeTeacherSalaryCalculateTest5() {
        PartTimeTeacher teacher = new PartTimeTeacher(new Teacher("", "", "", 'X', "", 0, 'D',
                ""), 8);
        double actual = teacher.getSalary();
        double expected = 1361.92;
        assertEquals(expected, actual);
    }

    @Test
    void FullTimeTeacherSalaryCalculateTest1() {
        Teacher teacher = new Teacher("", "", "", 'X', "", 0, 'D',
                "");
        double actual = teacher.getSalary();
        double expected = 6092.8;
        assertEquals(expected, actual);
    }

    @Test
    void FullTimeTeacherSalaryCalculateTest2() {
        Teacher teacher = new Teacher("", "", "", 'X', "", 0, 'M',
                "");
        double actual = teacher.getSalary();
        double expected = 4460.8;
        assertEquals(expected, actual);
    }

    @Test
    void FullTimeTeacherSalaryCalculateTest3() {
        Teacher teacher = new Teacher("", "", "", 'X', "", 0, 'B',
                "");
        double actual = teacher.getSalary();
        double expected = 2284.8;
        assertEquals(expected, actual);
    }

    @Test
    void StaffSalaryCalculateTest1() {
        Staff staff = new Staff("", "", "", 'X', 5, "", "");
        double actual = staff.getSalary();
        double expected = 240;
        assertEquals(expected, actual);
    }

    @Test
    void StaffSalaryCalculateTest2() {
        Staff staff = new Staff("", "", "", 'X', 7, "", "");
        double actual = staff.getSalary();
        double expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    void StaffSalaryCalculateTest3() {
        Staff staff = new Staff("", "", "", 'X', 3, "", "");
        double actual = staff.getSalary();
        double expected = 144;
        assertEquals(expected, actual);
    }

    @Test
    void StaffSalaryCalculateTest4() {
        Staff staff = new Staff("", "", "", 'X', 20, "", "");
        double actual = staff.getSalary();
        double expected = 960;
        assertEquals(expected, actual);
    }

    @Test
    void StaffSalaryCalculateTest5() {
        Staff staff = new Staff("", "", "", 'X', 15, "", "");
        double actual = staff.getSalary();
        double expected = 720;
        assertEquals(expected, actual);
    }

}
