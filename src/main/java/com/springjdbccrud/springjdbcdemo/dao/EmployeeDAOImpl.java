package com.springjdbccrud.springjdbcdemo.dao;

import com.springjdbccrud.springjdbcdemo.model.Employee;
import com.springjdbccrud.springjdbcdemo.model.EmployeeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
 JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees (username, email, department,age,phonenumber) VALUES (?, ?, ?, ?, ?)", new Object[] {employee.getUsername(), employee.getEmail(), employee.getDepartment(), employee.getAge(),employee.getPhonenumber()});
    }

    @Override
    public int update(Employee employee, int id) {
        return jdbcTemplate.update("UPDATE employees SET username=?, email=?, department=?, age=?, phonenumber=? WHERE id=?", new Object[]{employee.getUsername(), employee.getEmail(), employee.getDepartment(), employee.getAge(),employee.getPhonenumber(),id});
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?",id);
    }

    @Override
    public List<Employee> getAll() {
       return jdbcTemplate.query("SELECT * FROM employees",new EmployeeRowMapper());
    }

    @Override
    public Employee getById(int id) {
try{
    return jdbcTemplate.queryForObject("SELECT * FROM employees WHERE id=?", new EmployeeRowMapper(), id);

}catch(EmptyResultDataAccessException e){
            return null;
        }

    }
}
