package com.mastery.java.service;

import com.mastery.java.dto.Employee;

import java.util.List;

public interface EmployeeService {

    void add(Employee employee);

    Employee getId(int id);

    List<Employee> fidnAll();

    void update(Employee employee);

    void delete(int id);
}
