package com.wipro.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.dto.DepartmentDto;

@FeignClient(name="employee-service", url="http://localhost:8080")
public interface APIClient {
    @GetMapping("/departments/{code}")
    DepartmentDto getDepartmentByCode(@PathVariable String code);
}
