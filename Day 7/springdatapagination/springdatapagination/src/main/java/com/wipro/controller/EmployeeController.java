package com.wipro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.wipro.entity.Employee;
import com.wipro.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Pagination API
    @GetMapping("/pagination/{page}/{size}")
    public Page<Employee> getEmployeesWithPagination(@PathVariable int page, @PathVariable int size) {
        return service.getEmployeesWithPagination(page, size);
    }

    // Sorting API (ASC / DESC)
    @GetMapping("/sort/{field}/{order}")
    public List<Employee> getEmployeesWithSorting(@PathVariable String field, @PathVariable String order) {
        return service.getEmployeesWithSorting(field, order);
    }

    // Pagination + Sorting Combined
    @GetMapping("/pagination/{page}/{size}/sort/{field}/{order}")
    public Page<Employee> getEmployeesWithPaginationAndSorting(@PathVariable int page, 
                                                               @PathVariable int size, 
                                                               @PathVariable String field,
                                                               @PathVariable String order) {
        return service.getEmployeesWithPaginationAndSorting(page, size, field, order);
    }
}
