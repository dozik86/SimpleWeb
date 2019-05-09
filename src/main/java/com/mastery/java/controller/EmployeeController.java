package com.mastery.java.controller;


import com.mastery.java.dto.Employee;
import com.mastery.java.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/employees")
    public String getAllEmployee(Model model){
        model.addAttribute("employee",employeeService.fidnAll());
        return "employeesList";
    }

    @GetMapping("/employee2/{id}")
    public @ResponseBody
    Employee findId(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", employeeService.getId(id));
        return employeeService.getId(id);
    }

    @GetMapping("/addEmployee")
    public String createEmployeesPage() {
        return "createEmployee";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute("employee")Employee employee) {
        employeeService.add(employee);
        return "redirect:/employees";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute("employee")Employee employee) {
        employeeService.update(employee);
        return "redirect:/employee/" + employee.getId();
    }

    @GetMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, Model model) {
        model.addAttribute("employee", employeeService.getId(id));
        return "editEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
