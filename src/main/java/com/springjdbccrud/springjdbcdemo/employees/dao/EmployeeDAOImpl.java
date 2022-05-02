package com.springjdbccrud.springjdbcdemo.employees.dao;

import com.springjdbccrud.springjdbcdemo.department.model.DepartmentRowMapper;
import com.springjdbccrud.springjdbcdemo.employees.model.Employee;
import com.springjdbccrud.springjdbcdemo.employees.model.EmployeeRowMapper;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    @Repository
public  class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
 JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employees (username, email, age,phonenumber,department_id) VALUES (?, ?, ?, ?, ?)", employee.getUsername(), employee.getEmail(), employee.getAge(),employee.getPhonenumber(),employee.getDepartment_id());
    }

    @Override
    public int update(Employee employee, int id) {
        return jdbcTemplate.update("UPDATE employees SET username=?, email=?, age=?, phonenumber=? ,department_id=? WHERE id=?", employee.getUsername(), employee.getEmail(), employee.getAge(),employee.getPhonenumber(),employee.getDepartment_id(),id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employees WHERE id=?",id);
    }

    @Override
    public List<Employee> getAll() {
       return jdbcTemplate.query("SELECT * from employees,department where employees.department_id=department.id",new ResultSetExtractor<List<Employee>>() {
           @Override
           public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
               List<Employee> employees=new ArrayList<Employee>();
               int employeeId = 0;
               Employee currentEmployee=null;
               int employeeIdx=0;
               int departmentIdx=0;
               while (rs.next()){
                   if(currentEmployee == null || !(employeeId == rs.getInt("id"))){
                       employeeId=rs.getInt("id");
                       currentEmployee = new EmployeeRowMapper().mapRow(rs,employeeIdx++);
                       departmentIdx=0;
                       employees.add(currentEmployee);
                   }
                   assert currentEmployee != null;
                   currentEmployee.setDepartment(new DepartmentRowMapper().mapRow(rs,departmentIdx++));
               }
               return employees;
           }
       }) ;
    }

    @Override
    public Employee getById(int id) {
//        "SELECT * FROM employees,department WHERE employees.department_id=department.id and employees.id =?";
        return jdbcTemplate.query("SELECT * FROM employees,department WHERE employees.department_id=department.id and employees.id =?",new ResultSetExtractor<Employee>(){

            @Override
            public Employee extractData(ResultSet rs) throws SQLException, DataAccessException {
                Employee employee=null;
                int row=0;
                while (rs.next()){
                    if(employee==null) {
                        employee = new EmployeeRowMapper().mapRow(rs, row);
                    }
                    assert employee != null;
                    employee.setDepartment(new DepartmentRowMapper().mapRow(rs,row));
                    row++;
                }
                return employee;
            }
        },id);
    }
}
