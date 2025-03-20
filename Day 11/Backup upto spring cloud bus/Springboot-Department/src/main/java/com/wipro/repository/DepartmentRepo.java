package com.wipro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.dto.DepartmentDto;
import com.wipro.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    
    Department findByDeptcode(String deptcode); // Return Department entity, not DTO
}

