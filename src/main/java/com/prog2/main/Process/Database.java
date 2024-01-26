package com.prog2.main.Process;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 * This class is used to create a database object
 * 
 * @author Jiucheng Zang
 * @version 1.0
 * @since 2023-03-26
 * 
 */

public class Database implements Serializable {

    public Database(String fileDir) {
        this.fileDir = fileDir;
        this.departmentList = new ArrayList<Department>();
    }

    public Database(String fileDir, ArrayList<Department> departmentList) {
        this.fileDir = fileDir;
        this.departmentList = departmentList;
    }

    /**
     * @param department
     */
    public void addDepartment(Department department) {
        this.departmentList.add(department);
    }

    /**
     * @return String
     */
    public String getFileDir() {
        return this.fileDir;
    }

    /**
     * @param fileDir
     */
    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    /**
     * @return ArrayList<Department>
     */
    public ArrayList<Department> getDepartmentList() {
        return this.departmentList;
    }

    /**
     * @param departmentList
     */
    public void setDepartmentList(ArrayList<Department> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Database)) {
            return false;
        }
        Database database = (Database) o;
        return Objects.equals(fileDir, database.fileDir) && Objects.equals(departmentList, database.departmentList);
    }

    @Override
    public String toString() {
        return "{" +
                " fileDir='" + getFileDir() + "'" +
                ", departmentList='" + getDepartmentList() + "'" +
                "}";
    }

    private String fileDir;
    public ArrayList<Department> departmentList;

}
