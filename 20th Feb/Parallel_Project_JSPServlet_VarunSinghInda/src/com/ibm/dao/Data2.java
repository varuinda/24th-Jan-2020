package com.ibm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ibm.bean.Account;

public class Data2 {
	Connection dbCon;
	PreparedStatement pstmt;
	public Data2()throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmtraining?serverTimezone=IST", "root", "");
	}
	public void creditTransaction(Account a)throws SQLException {
		String insertQry = "insert into transactions values(?,?,?)";
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setString(1, a.getDate());
			pstmt.setInt(2, a.getId());
			pstmt.setInt(3, a.getBalance());
			pstmt.executeUpdate();
	}
	public void debitTransaction(Account a)throws SQLException {
		int mnew = -1*a.getBalance();
		String insertQry = "insert into transactions values(?,?,?)";
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setString(1, a.getDate());
			pstmt.setInt(2, a.getId());
			pstmt.setInt(3, mnew);
			pstmt.executeUpdate();
	}
	public ArrayList<String> transactions(Account a)throws SQLException {
		String showQry = "select * from transactions";
		ArrayList<String> al1 =  new ArrayList<String>();
		//ArrayList al2 = new ArrayList();
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(showQry);
			//ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId()) {
					StringBuilder sb = new StringBuilder("");
					sb.append("Transaction of: ");
					sb.append(rs.getInt("changed"));
					sb.append(" Done on: ");
					sb.append(rs.getString("date_transaction"));
					al1.add(sb.toString());
					//System.out.println("Transaction of: "+rs.getInt("changed")+" Done on: " + rs.getString("date_transaction"));
				}
			}
			return al1;
	}
}
