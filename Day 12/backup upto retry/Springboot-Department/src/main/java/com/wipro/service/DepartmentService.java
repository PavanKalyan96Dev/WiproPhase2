package com.wipro.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dto.DepartmentDto;
import com.wipro.entity.Department;
import com.wipro.repository.DepartmentRepo;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepo repo;

    @Autowired
    private ModelMapper mapper;

    public DepartmentDto saveDepartment(DepartmentDto deptdto) {
        Department dept = mapper.map(deptdto, Department.class);
        Department newdept = repo.save(dept);
        return mapper.map(newdept, DepartmentDto.class);
    }

    public DepartmentDto getDepartmentByCode(String code) {
        Department department = repo.findByDeptcode(code); // Fetch entity
        return department != null ? mapper.map(department, DepartmentDto.class) : null;
    }
}

