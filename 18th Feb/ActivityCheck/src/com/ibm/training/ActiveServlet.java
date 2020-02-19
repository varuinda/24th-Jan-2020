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
		//String logout = request.getParameter("logout");
		HttpSession session=request.getSession(false); 
		response.setContentType("text/html");
		if(session!=null) {
			//String email = (String) session.getAttribute("email");
			response.getWriter().println("Welcome " + (String)session.getAttribute("name"));
			response.getWriter().println("Date of Birth: "+(String)session.getAttribute("dob"));
			response.getWriter().print("<br/><a href=\"logout\">Logout</a>");
		}
		else {
			response.sendRedirect("index.html");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*if(session!=null) {
			if(logout!=null) {
				response.setContentType("text/html");
				response.getWriter().println("Successfully logged out");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);
				session.invalidate();
			}
		}
		else {
			response.sendRedirect("loginacc.html");
		}*/
		
	}

}
