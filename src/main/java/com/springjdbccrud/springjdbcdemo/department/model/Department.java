package com.springjdbccrud.springjdbcdemo.department.model;

import java.util.List;

public class Department {
    private int id;
    private String department;

    public Department(){

    }

    public Department(int id,String department){
        this.id=id;
        this.department = department;
    }

    public Department(String department) {
        this.department = department;
    }


    public int getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String email) {
        this.department = department;
    }
    public void setId(int id) {
        this.id = id;
    }


}
