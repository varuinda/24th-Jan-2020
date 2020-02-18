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
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		String logout = request.getParameter("logout");
		if((boolean) session.getAttribute("isUserLoggedIn")) {
			if(logout!=null) {
				response.setContentType("text/html");
				response.getWriter().println("Successfully logged out");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);
				session.invalidate();
			}
		}
		else {
			response.setContentType("text/html");
			response.getWriter().println("Cannot come to this page directly... Please login");
			RequestDispatcher dispatcher = request.getRequestDispatcher("loginacc.html");
			dispatcher.include(request, response);
		}
		
	}

}
