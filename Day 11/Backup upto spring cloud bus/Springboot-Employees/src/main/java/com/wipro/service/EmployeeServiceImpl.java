package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.DepartmentDto;
import com.wipro.dto.EmployeeDepartmentDto;
import com.wipro.dto.EmployeeDto;
import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    EmployeeRepo repo;
    
    @Autowired
    ModelMapper mapper;
    
	/*
	 * @Autowired WebClient client;
	 */
    
    @Autowired
    APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto empdto) {
        Employee emp = mapper.map(empdto, Employee.class);
        Employee newEmp = repo.save(emp);
        return mapper.map(newEmp, EmployeeDto.class);
    }

    @Override
    public EmployeeDepartmentDto getEmployeeById(Long id) {
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDeptCode());
        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);
        
        return new EmployeeDepartmentDto(employeeDto, departmentDto);
    }
}
