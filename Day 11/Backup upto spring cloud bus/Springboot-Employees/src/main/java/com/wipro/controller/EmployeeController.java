package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.dto.EmployeeDepartmentDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    @Autowired
    EmployeeService service;
    
    @PostMapping
    public EmployeeDto saveEmployee(@RequestBody EmployeeDto empdto) {
        return service.saveEmployee(empdto);
    }
    
    @GetMapping("/{id}")
    public EmployeeDepartmentDto getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }
}
