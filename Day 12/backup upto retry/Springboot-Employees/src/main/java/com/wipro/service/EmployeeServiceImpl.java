package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.wipro.dto.DepartmentDto;
import com.wipro.dto.EmployeeDepartmentDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepo repo;
    
    @Autowired
    ModelMapper mapper;
    
	
	  @Autowired 
	  WebClient webClient;
	 
    
    @Autowired
    APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto empdto) {
        Employee emp = mapper.map(empdto, Employee.class);
        Employee newEmp = repo.save(emp);
        return mapper.map(newEmp, EmployeeDto.class);
    }

    @Override
    @CircuitBreaker(name = "${spring.application.name}" , fallbackMethod = "getDefaultDepartment")
    @Retry(name="${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public EmployeeDepartmentDto getEmployeeById(Long id) {
    	System.out.println("iam in getEmployeeById");
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        DepartmentDto departmentDto = webClient.get()
                .uri("/departments/{deptCode}", employee.getDeptCode())  // Update the endpoint accordingly
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block();
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        
        return new EmployeeDepartmentDto(employeeDto, departmentDto);
    }
    
    public EmployeeDepartmentDto getDefaultDepartment(Long id ,Throwable throwable) {
    	 DepartmentDto defaultDepartment = new DepartmentDto();
    	    defaultDepartment.setDepartment("DEFAULT");
    	    defaultDepartment.setDeptcode("Default Department");
    	    defaultDepartment.setDescription("This is a fallback department");

    	    // Fetch the employee details (without department data)
    	    Employee employee = repo.findById(id)
    	            .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

    	    EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

    	    // Return the EmployeeDepartmentDto with default department
    	    return new EmployeeDepartmentDto(employeeDto, defaultDepartment);
    }
}
