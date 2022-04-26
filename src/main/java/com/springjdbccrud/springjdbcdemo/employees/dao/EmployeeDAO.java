package com.springjdbccrud.springjdbcdemo.employees.dao;

import com.springjdbccrud.springjdbcdemo.employees.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeeDAO {

    int save(Employee employee);
    int update(Employee employee, int id);
    int delete(int id);
    List<Employee> getAll();
    Employee getById(int id);

}
