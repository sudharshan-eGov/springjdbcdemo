package com.springjdbccrud.springjdbcdemo.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;
    private String username;
    private String email;
    private String department;
    private String phonenumber;
    private String age;
    private String gender;

}
