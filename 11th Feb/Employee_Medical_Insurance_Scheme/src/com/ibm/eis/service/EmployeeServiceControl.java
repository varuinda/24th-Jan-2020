package com.ibm.eis.service;

import java.util.ArrayList;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.save.Data;

public class EmployeeServiceControl implements EmployeeService{
	Employee e = new Employee();
	public String schemeDecider(String d, int s) {
		if(d.equals("system associate") && (s>5000 && s<20000)) {
			return "Scheme C";
		}
		else if(d.equals("programmer") && (s>=20000 && s<40000)) {
			return "Scheme B";
		}
		else if(d.equals("manager") && (s>=40000)) {
			return "Scheme A";
		}
		else if(d.equals("clerk") && (s<5000)) {
			return "No Scheme";
		}
		else {
			return "Designation and salary does not match the parameters";
		}
	}
	
	Data d = new Data();
	public String findEmployee(String s) {
		return d.find(s);
	}
	public void addDetails(Employee e) {
		d.addData(e);
	}
	public ArrayList<Employee> getDetails() {
		return d.getData();
	}
	public boolean idCheck(String id) {
		return d.checkIDD(id);
	}
	public boolean salCheck(String s) {
		char[] c= s.toCharArray();
		for(int i=0;i<s.length();i++) {
			if(((int)c[i])<49 && ((int)c[i])>57) {
				return false;
			}
		}
		return true;
	}
}
