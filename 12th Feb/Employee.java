package com.ibm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {
	Connection dbCon;
	PreparedStatement pstmt;
	
	public Employee() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
		} catch (SQLException e) {
			System.out.println("Error while connecting the database: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		Employee obj = new Employee();
		while(true) {
			System.out.println("1. Add an employee data");
			System.out.println("2. Update an employee data");
			System.out.println("3. Delete an employee data");
			System.out.println("4. View all employee data");
			System.out.println("5. To exit");
			int n1 = n.nextInt();
			if(n1==1) {
				obj.addDetails();
			}
			else if(n1==2) {
				obj.updateDetails();
			}
			else if(n1==3) {
				obj.deleteDetails();
			}
			else if(n1==4) {
				obj.showDetails();
			}
			else {
				break;
			}
		}
		System.out.println("Thank you for using the application");
		try {
			obj.dbCon.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void addDetails() {
		Scanner n = new Scanner(System.in);
		int id = 0;
		int age = 0;
		while(true){
			System.out.print("Enter the id: ");
			String id1 = n.nextLine();
			try {
				id = Integer.parseInt(id1);
				break;
			}catch(Exception e) {
				System.out.println("ID error... Enter the ID in numeric values");
			}
		}
		
		System.out.print("Enter the name: ");
		String name = n.nextLine();
		while(true) {
			System.out.print("Enter the age: ");
			String age1 = n.nextLine();
			try {
				age = Integer.parseInt(age1);
				break;
			}catch(Exception e) {
				System.out.println("Age error.. Enter the age in numeric values");
			}
		}
		System.out.print("Enter the designation: ");
		String designation = n.nextLine();
		String insertQry = "insert into employee_details values (?,?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4,designation);
			if(pstmt.executeUpdate()>0){
				System.out.println("Employee added successfully");
			}
			else {
				System.out.println("Error while executing add");
			}
		} catch (SQLException e) {
			System.out.println("Error while adding employee: "+e.getMessage());
		}
	}
	
	void showDetails() {
		String showQry = "select * from employee_details";
		try {
			ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				System.out.println("Name: "+rs.getString("name")+" ID: "+rs.getInt("id")+" Age: "+rs.getInt("age")+" Designation: "+rs.getString("designation"));
			}
		} catch (Exception e) {
			System.out.println("Error while showing data: "+e.getMessage());
		}
		
	}
	
	void updateDetails() {
		int id = 0;
		Scanner n = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the ID which you want to update: ");
			String id1 = n.nextLine();
			try {
				id = Integer.parseInt(id1);
				break;
			}catch(Exception e) {
				System.out.println("Error... Please enter the numeric value for ID");
			}
		}
		System.out.println("1. Update name");
		System.out.println("2. Update age");
		System.out.println("3. Update designation");
		int n2 = n.nextInt();
		n.nextLine();
		if(n2==1) {
			String updateQry = "update employee_details set name = ? where id = ?";
			System.out.print("Enter the new name: ");
			String newname = n.nextLine();
			try {
				pstmt = dbCon.prepareStatement(updateQry);
				pstmt.setString(1,newname);
				pstmt.setInt(2,id);
				if(pstmt.executeUpdate()>0) {
					System.out.println("Name successfully updated");
				}
				else {
					System.out.println("Employee ID did not match with the database IDs");
				}
			} catch (SQLException e) {
				System.out.println("Error while updating data: "+e.getMessage());
			}
		}
		else if(n2==2) {
			String updateQry = "update employee_details set age = ? where id = ?";
			int newage = 0;
			while(true) {
				System.out.print("Enter the new age: ");
				String newage1 = n.nextLine();
				try {
					newage = Integer.parseInt(newage1);
					break;
				}catch(Exception e) {
					System.out.println("Error....Please enter the numeric value for the age");
				}
			}
			try {
				pstmt = dbCon.prepareStatement(updateQry);
				pstmt.setInt(1,newage);
				pstmt.setInt(2,id);
				if(pstmt.executeUpdate()>0) {
					System.out.println("Age successfully updated");
				}
				else {
					System.out.println("Employee ID did not match with the database IDs");
				}
			} catch (SQLException e) {
				System.out.println("Error while updating data: "+e.getMessage());
			}
		}
		else if(n2==3) {
			String updateQry = "update employee_details set designation = ? where id = ?";
			System.out.print("Enter the new designation: ");
			String newdesig = n.nextLine();
			try {
				pstmt = dbCon.prepareStatement(updateQry);
				pstmt.setString(1,newdesig);
				pstmt.setInt(2,id);
				if(pstmt.executeUpdate()>0) {
					System.out.println("Designation successfully updated");
				}
				else {
					System.out.println("Employee ID did not match with the database IDs");
				}
			} catch (SQLException e) {
				System.out.println("Error while updating data: "+e.getMessage());
			}
		}
		else {
			System.out.println("Some other option was selected.... System restarted");
		}
	}
	
	void deleteDetails() {
		Scanner n = new Scanner(System.in);
		int id = 0;
		while(true) {
			System.out.print("Enter the ID which you want to delete: ");
			String id1 = n.nextLine();
			try {
				id = Integer.parseInt(id1);
				break;
			}catch(Exception e){
				System.out.println("Error.... Please enter the numeric value for ID");
			}
		}
		String deleteQry = "delete from employee_details where id = ?";
		try {
			pstmt = dbCon.prepareStatement(deleteQry);
			pstmt.setInt(1, id);
			if(pstmt.executeUpdate()>0) {
				System.out.println("Deleted successfully");
			}
			else {
				System.out.println("ID did not match with the IDs present in the database");
			}
		} catch (SQLException e) {
			System.out.println("Error while Deleting the data: "+e.getMessage());
		}
		
	}
}
