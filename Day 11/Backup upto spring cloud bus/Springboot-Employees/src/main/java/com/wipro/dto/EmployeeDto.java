package com.wipro.dto;

public class EmployeeDto {
	private Long empId;
	private String empName;
	private String email;
	private String deptCode;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public EmployeeDto() {
		super();
	}
	public EmployeeDto(Long empId, String empName, String email, String deptCode) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.deptCode = deptCode;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDeptCode() {
		return deptCode;
	}
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	

}
