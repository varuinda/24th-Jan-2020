package com.ibm.eis.service;

import java.util.ArrayList;

import com.ibm.eis.bean.Employee;

public interface EmployeeService {
	public ArrayList<Employee> getDetails();
	public String schemeDecider(String designation,int salary);
	public void addDetails(Employee e);
	public String findEmployee(String s);
	public boolean idCheck(String id);
	public boolean salCheck(String s);
}
