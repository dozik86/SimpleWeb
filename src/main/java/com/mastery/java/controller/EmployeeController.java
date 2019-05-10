package com.mastery.java.controller;

import com.mastery.java.dto.Employee;
import com.mastery.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("employ")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getAll();

    }

    @GetMapping("{id}")
    public Employee getOne(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @DeleteMapping("{id}")

    public Employee delete(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.delEmployee(id);
        return employee;
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        employeeService.createEmployee(employee);
        return employee;
    }


    @PutMapping("{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return employee;
    }


}