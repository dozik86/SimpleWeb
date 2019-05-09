package com.mastery.java.dao;

import com.mastery.java.dto.Employee;
import com.mastery.java.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    @Override
    public Employee getId(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id=?";
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }


    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender,date_of_birth) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql, employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(), employee.getJob_title(),
                employee.getGender(),employee.getDate_of_bith());
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?,date_of_birth=? WHERE employee_id=?";
        jdbcTemplate.update(sql, employee.getId(), employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(),
                employee.getJob_title(), employee.getGender(),employee.getDate_of_bith());

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM employee WHERE employee_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
