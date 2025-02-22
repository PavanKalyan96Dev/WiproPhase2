package com.wipro.model;

public class Student {

	private Integer stid;
	private String stname;
	private String staddress;
	public Integer getStid() {
		return stid;
	}
	public void setStid(Integer stid) {
		this.stid = stid;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public String getStaddress() {
		return staddress;
	}
	public void setStaddress(String staddress) {
		this.staddress = staddress;
	}
	
	public Student(Integer stid, String stname, String staddress) {
		super();
		this.stid = stid;
		this.stname = stname;
		this.staddress = staddress;
	}
	@Override
	public String toString()
	{
		return stid + " " +stname +" "+ staddress; 
	}
	public Student()
	{
		
	}
	
}
