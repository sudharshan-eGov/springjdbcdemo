package com.springjdbccrud.springjdbcdemo.employees.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException{
        return  new Employee    (
                rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("phonenumber"),
                rs.getInt("age"),
                rs.getInt("department_id")
        );
    }

}
