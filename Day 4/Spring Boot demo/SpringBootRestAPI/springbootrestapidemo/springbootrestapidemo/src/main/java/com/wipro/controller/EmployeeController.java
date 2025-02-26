package com.wipro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.entity.Employee;

@RestController
@RequestMapping("/employees")	//this url is applicable to all the methods inside the class
 
public class EmployeeController
{
	
	private List<Employee> employees = new ArrayList<>();
	//prepopulate the data
    public EmployeeController() {
        employees.add(new Employee(100, "ram", "software"));
        employees.add(new Employee(101, "Kumar", "HR"));
    }
    
    //fetch the data
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }
    //if we want to add a new employee
    @PostMapping
    public String addEmployee(@RequestBody Employee employee) // as we sending employee object as http req  
    														//into java object so we mentioned requbody
    														//json to java object internally converted with RB
    {
        employees.add(employee);		//once the employee obj is added then it adds into the list
        return "Employee added successfully!";	//we gets this msg after adding
    }
    //if we pass loclhost:9090/employees....which method wil be exec 1.get or post....?
    //to avoid those confusion we need to specify the req type like post or post type
 // GET API - Fetch employee by ID
    
    
    @GetMapping("/{id}")	//it is  useed to fetch the particlar empl by using the id
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employees.stream()
            .filter(emp -> emp.getId() == id)
            .findFirst()
            .orElse(null);
    }

    


}
