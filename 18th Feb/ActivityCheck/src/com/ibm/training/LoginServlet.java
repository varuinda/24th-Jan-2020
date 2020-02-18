package com.ibm.training;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		if(login!=null) {
			if(check(username,password)) {
				HttpSession session = request.getSession();
				 session.setAttribute("isUserLoggedIn",true);
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmtraining?serverTimezone=IST","root","");
					String idQry = "select * from website";
					Statement stmt;
					stmt = dbCon.createStatement();
					ResultSet rs = stmt.executeQuery(idQry);
					//ResultSet rs = pstmt.executeQuery(idQry);
						while(rs.next()) {
							if(rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
								response.setContentType("text/html");
								response.getWriter().println("Name: "+rs.getString("name") + " Date of birth: "+rs.getString("date"));
								RequestDispatcher dispatcher = request.getRequestDispatcher("active.html");
								RequestDispatcher dispatcher1 = request.getRequestDispatcher("ActiveServlet");
								dispatcher.include(request, response);
								dispatcher1.include(request, response);
							}
						}
				} catch (SQLException e) {
					System.out.println("Can't connect" + e.getMessage());
				} catch (ClassNotFoundException e) {
					System.out.println("Driver could not be loaded");
				}
			}
			else {
				response.setContentType("text/html");
				response.getWriter().println("Login failed... Try again");
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginacc.html");
				dispatcher.include(request, response);
			}
		}
	}
	public boolean check(String username,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmtraining?serverTimezone=IST","root","");
			String idQry = "select username,password from website";
			Statement stmt;
			stmt = dbCon.createStatement();
			ResultSet rs = stmt.executeQuery(idQry);
			//ResultSet rs = pstmt.executeQuery(idQry);
				while(rs.next()) {
					if(rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
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
