package com.wallet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wallet.bean.Account;

public class Data2 {
	Account a = new Account();
	Connection dbCon;
	PreparedStatement pstmt;
	
	public Data2() {
		try {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
		} catch (SQLException e) {
			System.out.println("Error while connecting the database: "+e.getMessage());
		}
	}
	public void creditTransaction(int id,int m,String d) {
		String insertQry = "insert into transactions values(?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setString(1, d);
			pstmt.setInt(2, id);
			pstmt.setInt(3, m);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while adding employee: "+e.getMessage());
		}
	}
	public void debitTransaction(int id,int m,String d) {
		m = -1*m;
		String insertQry = "insert into transactions values(?,?,?)";
		try {
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setString(1, d);
			pstmt.setInt(2, id);
			pstmt.setInt(3, m);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error while adding employee: "+e.getMessage());
		}
	}
	public void transactions(int id) {
		String showQry = "select * from transactions";
		try {
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(showQry);
			//ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				if(rs.getInt("id")==id) {
					System.out.println("Transaction of: "+rs.getInt("changed")+" Done on: " + rs.getString("date_transaction"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
