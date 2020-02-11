package com.ibm.eis.ui;

import java.util.Scanner;

import com.ibm.eis.bean.Employee;
import com.ibm.eis.service.EmployeeServiceControl;

public class UserInterface {
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.println("Welcome to Employee Insurance Scheme Database");
		EmployeeServiceControl esc = new EmployeeServiceControl();
		
		while(true) {
			System.out.println("1. Add an employee");
			System.out.println("2. Find the details of the employee");
			System.out.println("3. Data of all the employees");
			System.out.println("4. To exit");
			int n1 = n.nextInt();
			n.nextLine();
			if(n1==1) {
				System.out.print("Enter the ID: ");
				String identity = n.next();
				n.nextLine();
				if(esc.idCheck(identity)) {
					System.out.print("Enter the employee name: ");
					String name = n.nextLine();
					//n.nextLine();
					System.out.print("Enter the designation: ");
					String desig = n.nextLine();
					//n.nextLine();
					System.out.print("Enter the employee salary: ");
					String sal = n.next();
					//n.nextLine();
					try {
						int salary = Integer.parseInt(sal);
						String insurance = esc.schemeDecider(desig.toLowerCase(),salary);
						if(insurance.equals("Designation and salary does not match the parameters")) {
							System.out.println("Sorry the salary and designation did not match");
						}
						else {
							Employee e = new Employee();
							e.setId(identity);
							e.setName(name);
							e.setSalary(salary);
							e.setDesignation(desig);
							e.setInsuraceScheme(insurance);
							esc.addDetails(e);
						}
					}
					catch(Exception e) {
						System.out.println("This is not a valid input");
					}
				}
				else {
					System.out.println("ID already exists in the database");
				}
			}
			else if(n1==2) {
				System.out.print("Enter the id of the Employee : ");
				String id = n.next();
				System.out.println(esc.findEmployee(id));
			}
			else if(n1==3) {
				System.out.println(esc.getDetails());
			}
			else {
				break;
			}
		}
		System.out.println("Thanks for using the application");
	}
}
