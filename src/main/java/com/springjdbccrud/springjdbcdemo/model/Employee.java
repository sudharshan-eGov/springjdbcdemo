package com.springjdbccrud.springjdbcdemo.model;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


public class Employee {
    private int id ;
    private String username;
    @Email(message="Email not valid")
    private String email;
    private String department;
    @Pattern(regexp="(^$|[0-9]{10})",message = "Phone Number not Valid")
    private String phonenumber;
    private int age;

    public Employee(){

    }

    public Employee(int id,String username, String email, String department, String phonenumber, int age) {
        this.id=id;
        this.username = username;
        this.email = email;
        this.department = department;
        this.phonenumber = phonenumber;
        this.age = age;
    }

    public Employee(String username, String email, String department, String phonenumber,int age) {
        this.username=username;
        this.email=email;
        this.department = department;
        this.phonenumber = phonenumber;
        this.age=age;

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
    public String getDepartment() {
        return department;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", age=" + age +
                '}';
    }

}
