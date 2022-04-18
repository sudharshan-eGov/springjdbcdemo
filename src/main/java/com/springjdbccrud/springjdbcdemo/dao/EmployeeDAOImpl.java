package com.springjdbccrud.springjdbcdemo.dao;

import com.springjdbccrud.springjdbcdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
 JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees (username, email, department) VALUES (?, ?, ?)", new Object[] {employee.getUsername(), employee.getEmail(), employee.getDepartment(), employee.getPhonenumber(), employee.getAge(), employee.getGender()});
    }

    @Override
    public int update(Employee employee, int id) {
        return jdbcTemplate.update("UPDATE employees SET username=?, email=?, department=? WHERE id=?", new Object[]{employee.getUsername(), employee.getEmail(), employee.getDepartment(),employee.getPhonenumber(), employee.getAge(), employee.getGender(),id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?");
    }

    @Override
    public List<Employee> getAll() {
       return jdbcTemplate.query("SELECT * FROM employees", new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id=?", new BeanPropertyRowMapper<Employee>(Employee.class), id);
    }
}
