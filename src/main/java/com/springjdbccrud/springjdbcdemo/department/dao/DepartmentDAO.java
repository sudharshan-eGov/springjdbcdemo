package com.springjdbccrud.springjdbcdemo.department.dao;

import com.springjdbccrud.springjdbcdemo.department.model.Department;
import com.springjdbccrud.springjdbcdemo.employees.model.Employee;

import java.util.List;

public interface DepartmentDAO {

    int save(Department department);

    int update(Department department);

    int update(Department department, int id);

    int delete(int id);

    List<Department> getAll();

    Department getById(int id);
}
