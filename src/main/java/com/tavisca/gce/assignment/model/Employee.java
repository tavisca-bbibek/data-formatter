package com.tavisca.gce.assignment.model;

import java.util.Arrays;

public class Employee {
    private int empId;
    private String name;
    private String[] hobbies;
    private Department department;

    public Employee() {
        this.empId = 0;
        this.name = "Undefined";
        this.hobbies = new String[]{"Undefined"};
        this.department = new Department();
    }

    public Employee(int empId, String name, String[] hobbies, Department department) {
        this.empId = empId;
        this.name = name;
        this.hobbies = hobbies;
        this.department = department;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", hobbies=" + Arrays.toString(hobbies) +
                ", department='" + department + '\'' +
                '}';
    }
}