package com.ibm.eis.bean;

public class Employee {
	String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	String name;
	String designation;
	int salary;
	String insuraceScheme;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getInsuraceScheme() {
		return insuraceScheme;
	}
	public void setInsuraceScheme(String insuraceScheme) {
		this.insuraceScheme = insuraceScheme;
	}
	public String toString() {
		return "ID: "+this.getId()+" Name: " + this.getName() + " Designation: " + this.getDesignation() + " Salary: "+ this.getSalary() + " Insurace Scheme: " + this.getInsuraceScheme();
	}
}
