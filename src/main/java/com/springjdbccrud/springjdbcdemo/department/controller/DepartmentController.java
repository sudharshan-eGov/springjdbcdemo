package com.springjdbccrud.springjdbcdemo.department.controller;

import com.springjdbccrud.springjdbcdemo.department.dao.DepartmentDAO;
import com.springjdbccrud.springjdbcdemo.department.model.Department;
import com.springjdbccrud.springjdbcdemo.employees.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentDAO dDAO;

    @CrossOrigin(origins = "*")
    @GetMapping("/department")
    public List<Department> getDepartment(){
        return dDAO.getAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable int id){
        return dDAO.getById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/create_department")
    public String saveDepartment(@RequestBody Department department){
        System.out.println(department+"department");
        return dDAO.save(department)+" No. of rows saved to the database";
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update_department/{id}")
    public String updateDepartment(@RequestBody Department department, @PathVariable int id){
        return  dDAO.update(department,id)+" No. of rows updates to the database";
    }

    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/delete_department/{id}")
    public String deleteDepartmentById(@PathVariable int id){
        return  dDAO.delete(id)+" No. of rows deleted from the database";
    }

}
