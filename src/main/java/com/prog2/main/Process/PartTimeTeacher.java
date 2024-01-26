package com.prog2.main.Process;

/**
 * This class is used to create a part time teacher object extends from teacher
 * class
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-25
 * 
 */

public class PartTimeTeacher extends Teacher {

    /**
     * @return String
     */
    @Override
    public String prngId() {
        random.setSeed(getId());
        return "P" + random.nextInt(10000);
    }

    /**
     * This method is used to calculate the salary of the part time teacher
     * (Override)
     * 
     * @return double
     * @see ComputePayRoll
     * @see Teacher
     */

    @Override
    public double calculateSalary() {
        double degreeRate;
        switch (super.degree) {
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
                throw new IllegalStateException("Unexpected value: " + super.degree);
        }
        super.salary = (hoursWorked * degreeRate * 2) * 0.76;
        return super.salary;
    }

    public PartTimeTeacher(Teacher teacher, int hoursWorked) {
        super(teacher.getName(), teacher.getPhone(), teacher.getEmail(), teacher.getGender(), teacher.getSpecialty(),
                teacher.getYearsOfExperience(), teacher.getDegree(), teacher.getDepartment());
        n--;
        id--;
        this.hoursWorked = hoursWorked;
        calculateSalary();
    }

    /**
     * @return double
     */
    public double getHoursWorked() {
        return this.hoursWorked;
    }

    /**
     * @param hoursWorked
     */
    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PartTimeTeacher)) {
            return false;
        }
        PartTimeTeacher partTimeTeacher = (PartTimeTeacher) o;
        return hoursWorked == partTimeTeacher.hoursWorked;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
                "'" + super.toString() + "'" +
                ", hoursWorked='" + getHoursWorked() + "'" +
                "}";
    }

    private int hoursWorked;
}
