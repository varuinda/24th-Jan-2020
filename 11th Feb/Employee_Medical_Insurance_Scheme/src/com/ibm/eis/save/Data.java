package com.ibm.eis.save;

import java.util.ArrayList;

import com.ibm.eis.bean.Employee;

public class Data {
	ArrayList<Employee> al  = new ArrayList<>();
	public void addData(Employee e) {
		al.add(e);
	}
	public ArrayList<Employee> getData(){
		return al;
	}
	public String find(String id) {
		int flag = 0;
		for(Employee e:al) {
			if((id.toLowerCase()).equals((e.getId()).toLowerCase())) {
				return e.toString();
			}
		}
		return "Employee data does not exist";
	}
	public boolean checkIDD(String d) {
		for(Employee e:al) {
			if((d.toLowerCase()).equals((e.getId()).toLowerCase())) {
				return false;
			}
		}
		return true;
	}
}
