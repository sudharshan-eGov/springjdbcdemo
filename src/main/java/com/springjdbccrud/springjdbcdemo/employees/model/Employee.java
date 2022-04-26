package com.springjdbccrud.springjdbcdemo.employees.model;
import com.springjdbccrud.springjdbcdemo.department.model.Department;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


public class Employee {
    private int id ;
    private String username;
    @Email(message="Email not valid")
    private String email;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone Number not Valid")
    private String phonenumber;
    private int age;
    private int department_id;

    private Department department;
    public Employee(){

    }

    public Employee(int id,String username, String email, String phonenumber, int age,int department_id) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
        this.age = age;
        this.department_id=department_id;
    }

    public Employee(String username, String email, String phonenumber,int age,int department_id) {
        this.username=username;
        this.email=email;
        this.phonenumber = phonenumber;
        this.age=age;
        this.department_id=department_id;
    }


    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                ", department_id=" + department_id +
                '}';
    }

}
