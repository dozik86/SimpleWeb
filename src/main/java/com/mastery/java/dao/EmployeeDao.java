package com.mastery.java.dao;
import com.mastery.java.dto.Employee;
import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee getId(int id);

    void add(Employee employee);

    void update (Employee employee);

    void delete(int id);

}
