package com.springjdbccrud.springjdbcdemo.controller;

import com.springjdbccrud.springjdbcdemo.dao.EmployeeDAO;
import com.springjdbccrud.springjdbcdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeDAO eDAO;
    @CrossOrigin(origins = "*")
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
       return eDAO.getAll();
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return eDAO.getById(id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/employees")
    public String saveEmployee(@RequestBody Employee employee){
        return eDAO.save(employee)+" No. of rows saved to the database";
    }
    @CrossOrigin(origins = "*")
    @PutMapping("/employee/{id}")
    public String updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        return  eDAO.update(employee,id)+" No. of rows updates to the database";
    }
    @CrossOrigin(origins = "*",allowedHeaders = "*")
    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable int id){
        return  eDAO.delete(id)+" No. of rows deleted from the database";
    }
}
