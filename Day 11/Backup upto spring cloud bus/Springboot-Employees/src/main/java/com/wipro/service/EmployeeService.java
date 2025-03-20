package com.wipro.service;

import com.wipro.dto.EmployeeDepartmentDto;
import com.wipro.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto empdto);

	public EmployeeDepartmentDto getEmployeeById(Long id);

}
