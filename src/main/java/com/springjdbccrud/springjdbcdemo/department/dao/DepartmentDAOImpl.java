package com.springjdbccrud.springjdbcdemo.department.dao;


import com.springjdbccrud.springjdbcdemo.department.model.Department;

import com.springjdbccrud.springjdbcdemo.department.model.DepartmentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  class DepartmentDAOImpl implements DepartmentDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int save(Department department) {
        return jdbcTemplate.update("INSERT INTO department (department) VALUES (?)", department.getDepartment());
    }

    @Override
    public int update(Department department) {
        return 0;
    }

    @Override
    public int update(Department department, int id){
        return jdbcTemplate.update("UPDATE department SET department=? WHERE id=?", department.getDepartment(),id);
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM department WHERE id=?",id);
    }

    @Override
    public List<Department> getAll() {
        return jdbcTemplate.query("SELECT * FROM department",new DepartmentRowMapper());
    }

    @Override
    public Department getById(int id) {
        try{
            return jdbcTemplate.queryForObject("SELECT * FROM department WHERE id=?", new DepartmentRowMapper(), id);

        }catch(EmptyResultDataAccessException e){
            return null;
        }

    }


}
