package com.example.SpringCrud.controller;

import com.example.SpringCrud.service.EmployeeService;
import com.example.SpringCrud.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/getEmployee")
    @ResponseBody
    public List<Employee> getCustomer(@RequestBody Employee employee) {
        return employeeService.getEmployee(employee);
    }

    @PostMapping("/addEmployee")
    public void addCustomer(@RequestBody Employee employee){
        employeeService.addEmployee(employee);

    }

    @PutMapping("/updateEmployee/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @Transactional
    public void deleteCustomer(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
    }
}
