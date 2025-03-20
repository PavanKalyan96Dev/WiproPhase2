package com.wipro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.dto.DepartmentDto;
import com.wipro.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	
	@PostMapping
	public DepartmentDto saveDepartment(@RequestBody DepartmentDto deptdto) {
		return service.saveDepartment(deptdto);
	}
	
	@GetMapping("/{code}")
	public DepartmentDto getDepartmentByCode(@PathVariable String code) {
		return service.getDepartmentByCode(code);
	}
	
	

}

