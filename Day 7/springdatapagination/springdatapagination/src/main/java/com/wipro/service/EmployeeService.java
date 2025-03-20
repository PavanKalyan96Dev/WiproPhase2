package com.wipro.service;

import java.util.List;
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

    @Autowired
    private EmployeeRepository repository;

    // Pagination
    public Page<Employee> getEmployeesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    // Sorting (ASC or DESC)
    public List<Employee> getEmployeesWithSorting(String field, String order) {
        Sort sort = order.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();
        return repository.findAll(sort);
    }

    // Pagination + Sorting Combined
    public Page<Employee> getEmployeesWithPaginationAndSorting(int page, int size, String field, String order) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, field));
        return repository.findAll(pageable);
    }
}
