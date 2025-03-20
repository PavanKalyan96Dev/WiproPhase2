package com.wipro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.EmployeeDTO;
import com.wipro.entity.Employee;
import com.wipro.exception.ResourceNotFoundException;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // Add Employee
    public EmployeeDTO addEmployee(EmployeeDTO dto) {
    	//convert dto to entity
    	Employee employee=new Employee(dto.getName(),dto.getDepartment());
       Employee savedEmployee=repository.save(employee);//entity class 
       
       //convert entity to  dto object again
       
       EmployeeDTO employeeDTO=new EmployeeDTO(savedEmployee.getId(),savedEmployee.getName(),savedEmployee.getDepartment());
       return employeeDTO;
       
    }

    // Get All Employees
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    // Get Employee by ID
    public Employee getEmployeeById(Long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with given id " + id + " is not present"));
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setDepartment(updatedEmployee.getDepartment());
            return repository.save(employee);
        }).orElse(null);
    }

    // Delete Employee
    public String deleteEmployeeById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return "Employee with ID " + id + " deleted successfully.";
        } else {
            return "Employee not found.";
        }
    }

    // Get Employees by Name
    public List<Employee> getEmployeesByName(String name) {
        return repository.findByName(name);
    }

    // Get Employees by Department
    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findByDepartment(department);
    }
}
