package com.wipro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wipro.entity.Employee;
import com.wipro.repository.EmployeeRepository;

@Service
public class EmployeeService {

	//get all employees with pagination
	@Autowired
	private EmployeeRepository employeeRepository;
	public Page<Employee> getEmployeeWithPagination(int page, int size) {
		  Pageable pageable = PageRequest.of(page, size);
	        return employeeRepository.findAll(pageable);
		
	}
	public Page<Employee> getEmployeesWithSorting(int page, int size, String sortField) {
		
		Pageable pageable = PageRequest.of(page, size,Sort.by(sortField).ascending() );
        return employeeRepository.findAll(pageable);
	}

}
