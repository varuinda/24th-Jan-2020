package com.wallet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wallet.bean.Account;
import com.wallet.bean.Transaction;

public class Data1 {
	Connection dbCon;
	PreparedStatement pstmt;
	Data2 d = new Data2();
	public Data1()throws SQLException {
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmtraining?serverTimezone=IST", "root", "");
	}
	//Data1 d = new Data1();
	Account a = new Account();
	Transaction t = new Transaction();
	public void addMoney(Account a,int m)throws SQLException {
		int mnew = m+balance(a);
		String updateQry = "update wallet set balance = ? where id = ?";
			/*Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(updateQry);*/
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, mnew);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
		
	}
	public void withdrawMoney(Account a,int m)throws SQLException {
		int mnew = balance(a)-m;
		String updateQry = "update wallet set balance = ? where id = ?";
			/*Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(updateQry);*/
			pstmt = dbCon.prepareStatement(updateQry);
			pstmt.setInt(1, mnew);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
	}
	public int balance(Account a)throws SQLException {
		String balQry = "select id,balance from wallet";
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(balQry);
			//ResultSet rs = pstmt.executeQuery(balQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId()) {
					return rs.getInt("balance");
				}
			}
		return 0;
	}
	public void createAcc(Account a)throws SQLException {
		String insertQry = "insert into wallet values(?,?,?,?,?)";
			pstmt = dbCon.prepareStatement(insertQry);
			pstmt.setInt(1, a.getId());
			pstmt.setString(2, a.getName());
			pstmt.setInt(3, a.getBalance());
			pstmt.setString(4,a.getPassword());
			pstmt.setString(5, a.getDate());
			pstmt.executeUpdate();
	}
	public void transfer(Account a,int m,int idp)throws SQLException {
		int m1 = balance(a)-m;
		String updateQry1 = "update wallet set balance = ? where id = ?";
			pstmt = dbCon.prepareStatement(updateQry1);
			pstmt.setInt(1, m1);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
			a.setId(idp);
		int m2 = balance(a)+m;
		String updateQry2 = "update wallet set balance = ? where id = ?";
			pstmt = dbCon.prepareStatement(updateQry2);
			pstmt.setInt(1, m2);
			pstmt.setInt(2, a.getId());
			pstmt.executeUpdate();
	}
	public ArrayList<String> showAll()throws SQLException {
		ArrayList<String> al = new ArrayList<>();
		Account a  = new Account();
		String showQry = "select name,balance,date_created from wallet";
		int c = 0;
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(showQry);
			//ResultSet rs = pstmt.executeQuery(showQry);
			while(rs.next()) {
				StringBuilder sb = new StringBuilder("");
				sb.append("Name: ");
				sb.append(rs.getString("name"));
				sb.append(" Balance: ");
				sb.append(rs.getInt("balance"));
				sb.append(" Created on: ");
				sb.append(rs.getString("date_created"));
				al.add(sb.toString());
				//System.out.println("Name: " +rs.getString("name") +" Balance: "+rs.getString("balance")+" Created on: " + rs.getString("date_created"));
			}
			return al;
	}
	public boolean log(Account a)throws SQLException {
		String logQry = "select id,password from wallet";
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(logQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId() && (rs.getString("password")).equals(a.getPassword())) {
					return true;
				}
			}
		return false;
	}
	public boolean checkid(Account a)throws SQLException {
		String idQry = "select id from wallet";
			Statement stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(idQry);
		//ResultSet rs = pstmt.executeQuery(idQry);
			while(rs.next()) {
				if(rs.getInt("id")==a.getId()) {
					return true;
				}
			}
		return false;
	}
	public void closeDB()throws SQLException {
			dbCon.close();
	}
	public void delete(Account a)throws SQLException {
		if(log(a)) {
			String delQry = "delete from wallet where id = ?";
				pstmt = dbCon.prepareStatement(delQry);
				pstmt.setInt(1, a.getId());
				pstmt.executeUpdate();
				d.delete(a);
		}
		else {
			System.out.println("Wrong ID or password");
		}
	}
}
