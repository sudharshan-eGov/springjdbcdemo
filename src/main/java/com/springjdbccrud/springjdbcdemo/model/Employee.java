package com.springjdbccrud.springjdbcdemo.model;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id ;
    private String username;
    private String email;
    private String department;
    private String phonenumber;
    private int age;


}
