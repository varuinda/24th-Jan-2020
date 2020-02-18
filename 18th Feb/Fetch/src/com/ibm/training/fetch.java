package com.ibm.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class fetch
 */
@WebServlet("/fetch")
public class fetch extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String[] games  = request.getParameterValues("sport");
		String degree = request.getParameter("study");
		String date = request.getParameter("date");
		response.getWriter().println("Name: " +name);
		response.getWriter().println("Gender: "+gender);
		response.getWriter().println("Games:");
		for(int i=0;i<games.length;i++) {
			response.getWriter().println(games[i] + " ");
		}
		response.getWriter().println("Degree: "+degree);
		response.getWriter().println("Date: "+date);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
