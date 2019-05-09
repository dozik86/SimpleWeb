package com.mastery.java.service;

import com.mastery.java.dao.EmployeeDao;
import com.mastery.java.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    public Employee getId(int id) {
        return employeeDao.getId(id);
    }

    @Override
    public List<Employee> fidnAll() {
        return employeeDao.findAll();
    }

    @Override
    public void update(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeDao.delete(id);
    }
}
