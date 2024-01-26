package com.prog2.main.Process;

import java.util.Objects;

/**
 * This class is used to create a staff object extends Person and implements
 * ComputePayRoll
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public class Staff extends Person implements ComputePayRoll {

    /**
     * This field is used to store the workload of the staff
     */

    @Override
    public double calculateSalary() {
        this.salary = (this.workLoad * 32 * 2) * 0.75;
        return this.salary;
    }

    public Staff(String name, String phone, String email, char gender, int workLoad, String duty, String department) {
        super(name, phone, email, gender);
        if (workLoad < 0 || workLoad > 40)
            throw new IllegalArgumentException("Workload must be between 0 and 40");
        this.workLoad = workLoad;
        calculateSalary();
        this.duty = duty;
        this.department = department;
    }

    /**
     * @return int
     */
    public int getWorkLoad() {
        return this.workLoad;
    }

    /**
     * @param workLoad
     */
    public void setWorkLoad(int workLoad) {
        this.workLoad = workLoad;
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
     * @return String
     */
    public String getDuty() {
        return this.duty;
    }

    /**
     * @param duty
     */
    public void setDuty(String duty) {
        this.duty = duty;
    }

    public Staff workLoad(int workLoad) {
        setWorkLoad(workLoad);
        return this;
    }

    public Staff salary(double salary) {
        setSalary(salary);
        return this;
    }

    public Staff duty(String duty) {
        setDuty(duty);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Staff)) {
            return false;
        }
        Staff staff = (Staff) o;
        return workLoad == staff.workLoad && salary == staff.salary && Objects.equals(duty, staff.duty);
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Staff department(String department) {
        setDepartment(department);
        return this;
    }

    public String prngId() {
        random.setSeed(getId());
        return "S" + random.nextInt(10000);
    }

    @Override
    public String toString() {
        return "{" +
                " person='" + super.toString() + "'" +
                " workLoad='" + getWorkLoad() + "'" +
                ", salary='" + getSalary() + "'" +
                ", duty='" + getDuty() + "'" +
                ", department='" + getDepartment() + "'" +
                "}";
    }

    private int workLoad;
    private double salary;
    private String duty;
    private String department;
}