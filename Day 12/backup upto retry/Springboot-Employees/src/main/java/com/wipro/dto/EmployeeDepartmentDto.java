package com.wipro.dto;

public class EmployeeDepartmentDto {
	
	private EmployeeDto empDto;
	private DepartmentDto depDto;
	public EmployeeDto getEmpDto() {
		return empDto;
	}
	public void setEmpDto(EmployeeDto empDto) {
		this.empDto = empDto;
	}
	public DepartmentDto getDepDto() {
		return depDto;
	}
	public void setDepDto(DepartmentDto depDto) {
		this.depDto = depDto;
	}
	public EmployeeDepartmentDto(EmployeeDto employeeDto, DepartmentDto depDto) {
		super();
		this.empDto = employeeDto;
		this.depDto = depDto;
	}
	public EmployeeDepartmentDto() {
		super();
	}
	

}
