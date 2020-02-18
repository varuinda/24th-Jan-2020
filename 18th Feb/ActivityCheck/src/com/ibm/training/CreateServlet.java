package com.ibm.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String date = request.getParameter("date");
		String create = request.getParameter("create");
		if(create!=null) {
			if(check(username)) {
				response.setContentType("text/html");
				response.getWriter().println("Username already exists in the database... Try again");
				RequestDispatcher dispatcher = request.getRequestDispatcher("createacc.html");
				dispatcher.include(request, response);
			}
			else {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmtraining?serverTimezone=IST","root","");
					String insertQry = "insert into website values(?,?,?,?)";
					PreparedStatement pstmt;
					pstmt = dbCon.prepareStatement(insertQry);
					pstmt.setString(1, name);
					pstmt.setString(2,username);
					pstmt.setString(3, password);
					pstmt.setString(4, date);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					System.out.println("Can't connect" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("Driver could not be loaded");
				}
				response.setContentType("text/html");
				response.getWriter().println("Successfully created");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);
			}
		}
	}
	public boolean check(String username) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmtraining?serverTimezone=IST","root","");
			String idQry = "select username from website";
			Statement stmt;
			stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(idQry);
			//ResultSet rs = pstmt.executeQuery(idQry);
				while(rs.next()) {
					if(rs.getString("username").equals(username)) {
						return true;
					}
				}
		} catch (SQLException e) {
			System.out.println("Can't connect" + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Driver could not be loaded");
		}
		return false;
	}

}
