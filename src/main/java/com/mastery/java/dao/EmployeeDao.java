package com.mastery.java.dao;

import com.mastery.java.dto.Employee;
import com.mastery.java.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {
    private final EmployeeMapper employeeMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao (EmployeeMapper employeeMapper, NamedParameterJdbcTemplate jdbcTemplate) {
        this.employeeMapper = employeeMapper;
        this.jdbcTemplate = jdbcTemplate;
    }


    public Employee getEmployeeById(int id) {

        String sql ="Select * from employee where employee_id =:id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        return jdbcTemplate.queryForObject(sql, params, employeeMapper);
    }

    public void delEmployeeById(int id) {
        KeyHolder holder = new GeneratedKeyHolder();
        String sql ="DELETE from employee where employee_id = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);

        jdbcTemplate.update(sql, params, holder, new String[]{"employee_id"});
    }


    public List<Employee> findAll(){
        return  jdbcTemplate.query("Select * from employee", employeeMapper);
    }



    public Employee createEmployee(Employee employee) {
        KeyHolder holder = new GeneratedKeyHolder();
        String sql ="INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) VALUES (:first_name,:last_name,:department_id,:job_title,:gender,:date_of_birth)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("first_name", employee.getFirst_name());
        params.addValue("last_name", employee.getLast_name());
        params.addValue("department_id", employee.getDepartment_id());
        params.addValue("job_title", employee.getJob_title());
        params.addValue("gender", employee.getGender());
        params.addValue("date_of_birth", employee.getDate_of_birth());

        jdbcTemplate.update(sql,params,holder, new String[] { "employee_id" });
        employee.setEmployee_id(holder.getKey().intValue());
        return employee;
    }

    public Employee updateEmployee(int employee_id, Employee employee){
        KeyHolder holder = new GeneratedKeyHolder();
        String sql ="UPDATE  employee SET first_name=:first_name, last_name=:last_name, department_id=:department_id, job_title=:job_title, gender=:gender, date_of_birth=:date_of_birth WHERE employee_id=:employee_id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("employee_id", employee_id);
        params.addValue("first_name", employee.getFirst_name());
        params.addValue("last_name", employee.getLast_name());
        params.addValue("department_id", employee.getDepartment_id());
        params.addValue("job_title", employee.getJob_title());
        params.addValue("gender", employee.getGender());
        params.addValue("date_of_birth", employee.getDate_of_birth());

        jdbcTemplate.update(sql,params,holder, new String[] { "employee_id" });
        return employee;
    }


}