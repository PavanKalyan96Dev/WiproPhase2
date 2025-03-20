package com.wipro.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;
import com.wipro.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/pagination")  // This mapping is correct
    public Page<Employee> getEmployeesWithPagination(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {
        
        return employeeService.getEmployeeWithPagination(page, size);
    }
    
    //sort the data by name
    @GetMapping("pagination-sorting")
    public Page<Employee> getEmployeesWithPaginationAndSorting(
    		
    		 @RequestParam(defaultValue = "0") int page, 
    	        @RequestParam(defaultValue = "5") int size,
    @RequestParam(defaultValue = "name") String sortField){
    
    	return employeeService.getEmployeesWithSorting(page,size,sortField);
    		
    		
    }
    
}
