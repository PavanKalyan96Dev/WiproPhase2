package com.wipro.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "EmployeeDTO", description = "Data Transfer Object for Employee")

public class EmployeeDTO
{
    @Schema(description = "Unique identifier of the employee", example = "101")

	private Long id;
    @Schema(description = "Name of the employee", example = "Pavan")

	private String name;
    @Schema(description = "Department of the employee", example = "IT")

	private String department;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public EmployeeDTO(Long id, String name, String department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	public EmployeeDTO()
	{
		
	}
	
	

}
