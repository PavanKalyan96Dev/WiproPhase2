package com.wipro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.EmployeeDTO;
import com.wipro.entity.Employee;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@Tag(name = "Employee Controller", description = "Operations related to employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // Create Employee
    @PostMapping
    @Operation(summary = "Create Employee", description = "Adds a new employee to the system")
    @ApiResponse(responseCode = "201", description = "Employee created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO dto) {
        return new ResponseEntity<>(service.addEmployee(dto), HttpStatus.CREATED);
    }

    // Get All Employees
    @GetMapping
    @Operation(summary = "Get All Employees", description = "Retrieves a list of all employees")
    @ApiResponse(responseCode = "200", description = "List of employees retrieved successfully")
    public List<Employee> getAllEmployees() {
        return service.getEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    @Operation(summary = "Get Employee by ID", description = "Retrieves an employee by their ID")
    @ApiResponse(responseCode = "200", description = "Employee found")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    public Employee getEmployeeById(
            @Parameter(description = "Employee ID", example = "101") @PathVariable Long id) throws ResourceNotFoundException {
        return service.getEmployeeById(id);
    }

    // Update Employee
    @PutMapping("/{id}")
    @Operation(summary = "Update Employee", description = "Updates an existing employee's details")
    @ApiResponse(responseCode = "200", description = "Employee updated successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    public Employee updateEmployee(
            @Parameter(description = "Employee ID", example = "101") @PathVariable Long id,
            @RequestBody Employee updatedEmployee) {
        return service.updateEmployee(id, updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Employee", description = "Deletes an employee by their ID")
    @ApiResponse(responseCode = "200", description = "Employee deleted successfully")
    @ApiResponse(responseCode = "404", description = "Employee not found")
    public String deleteEmployee(
            @Parameter(description = "Employee ID", example = "101") @PathVariable Long id) {
        return service.deleteEmployeeById(id);
    }

    // Get Employees by Name
    @GetMapping("/name/{name}")
    @Operation(summary = "Get Employees by Name", description = "Retrieves employees by their name")
    @ApiResponse(responseCode = "200", description = "Employees retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No employees found with the given name")
    public List<Employee> getEmployeesByName(
            @Parameter(description = "Employee Name", example = "John Doe") @PathVariable String name) {
        return service.getEmployeesByName(name);
    }

    // Get Employees by Department
    @GetMapping("/department/{department}")
    @Operation(summary = "Get Employees by Department", description = "Retrieves employees by department")
    @ApiResponse(responseCode = "200", description = "Employees retrieved successfully")
    @ApiResponse(responseCode = "404", description = "No employees found in the given department")
    public List<Employee> getEmployeesByDepartment(
            @Parameter(description = "Department Name", example = "HR") @PathVariable String department) {
        return service.getEmployeesByDepartment(department);
    }
}
