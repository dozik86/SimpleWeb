package com.mastery.java.mapper;

import com.mastery.java.dto.Employee;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getInt("employee_id"));
        employee.setFirst_name(resultSet.getString("first_name"));
        employee.setLast_name(resultSet.getString("last_name"));
        employee.setDepartment_id(resultSet.getInt("department_id"));
        employee.setJob_title(resultSet.getString("job_title"));
        employee.setGender(resultSet.getString("gender"));
        employee.setDate_of_bith(resultSet.getString("date_of_birth"));
        return employee;
    }

}
