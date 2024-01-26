package com.prog2.main.Process;

import java.util.Objects;

/**
 * This class is used to create a teacher object extends Person and implements
 * ComputePayRoll
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public class Teacher extends Person implements ComputePayRoll {

    /**
     * Generate a random ID for the teacher with seed of the teacher's Index
     * 
     * @return String
     */

    public String prngId() {
        random.setSeed(getId());
        return "F" + random.nextInt(10000);
    }

    /**
     * This method is used to calculate the salary of the teacher
     * 
     * @return double
     * @see ComputePayRoll
     */

    @Override
    public double calculateSalary() {
        double degreeRate;
        switch (this.degree) {
            case 'B':
                degreeRate = 42;
                break;
            case 'M':
                degreeRate = 82;
                break;
            case 'D':
                degreeRate = 112;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.degree);
        }
        this.salary = (32 * degreeRate * 2) * 0.85;
        this.salary = Math.ceil(this.salary * 100) / 100;
        return this.salary;
    }

    /**
     * This method is used to create a teacher object
     * 
     * @param name
     * @param phone
     * @param email
     * @param gender
     * @param specialty
     * @param yearsOfExperience
     * @param degree
     * @param department
     */

    public Teacher(String name, String phone, String email, char gender, String specialty, int yearsOfExperience,
            char degree, String department) {
        super(name, phone, email, gender);
        this.specialty = specialty;
        this.yearsOfExperience = yearsOfExperience;
        this.degree = degree;
        this.salary = calculateSalary();
        this.department = department;
    }

    /**
     * @return String
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     * @param specialty
     */
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    /**
     * @return double
     */
    public double getSalary() {
        return this.salary;
    }

    /**
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * @return int
     */
    public int getYearsOfExperience() {
        return this.yearsOfExperience;
    }

    /**
     * @param yearsOfExperience
     */
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public char getDegree() {
        return this.degree;
    }

    /**
     * This method is used to set the degree of the teacher (M: Master, B: Bachelor,
     * D: Doctor)
     * 
     * @param degree
     * 
     */

    public void setDegree(char degree) {
        this.degree = degree;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Teacher specialty(String specialty) {
        setSpecialty(specialty);
        return this;
    }

    public Teacher salary(double salary) {
        setSalary(salary);
        return this;
    }

    public Teacher yearsOfExperience(int yearsOfExperience) {
        setYearsOfExperience(yearsOfExperience);
        return this;
    }

    public Teacher degree(char degree) {
        setDegree(degree);
        return this;
    }

    public Teacher department(String department) {
        setDepartment(department);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Teacher)) {
            return false;
        }
        Teacher teacher = (Teacher) o;
        return Objects.equals(specialty, teacher.specialty) && salary == teacher.salary
                && yearsOfExperience == teacher.yearsOfExperience && degree == teacher.degree
                && Objects.equals(department, teacher.department);
    }

    @Override
    public String toString() {
        return "{" +
                " person='" + super.toString() + "'" +
                " specialty='" + getSpecialty() + "'" +
                ", salary='" + getSalary() + "'" +
                ", yearsOfExperience='" + getYearsOfExperience() + "'" +
                ", degree='" + getDegree() + "'" +
                ", department='" + getDepartment() + "'" +
                "}";
    }

    protected String specialty;
    protected double salary;
    protected int yearsOfExperience;
    protected char degree;
    protected String department;

}
