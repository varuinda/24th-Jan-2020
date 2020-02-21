package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getSession().getAttribute("sid");
		if(id!=null){
			response.sendRedirect("loginactivity.jsp");
		}
		else {
		String addAccount = request.getParameter("addAccount");
		String loginAccount = request.getParameter("loginAccount");
		String  viewUsers = request.getParameter("viewUsers");
		String exit = request.getParameter("exit");
		MainService ms = new MainService();
		try {
		if(addAccount!=null) {
			response.sendRedirect("addaccount.jsp");
		}
		else if(loginAccount!=null) {
			response.sendRedirect("loginaccount.jsp");
		}
		else if(viewUsers!=null) {
			//service to view
			ArrayList<String> al = ms.allUsers();
			StringBuilder sb = new StringBuilder("");
			for(String str:al) {
				sb.append(str);
				sb.append("<br>");
			}
			request.setAttribute("message1",sb.toString());
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(exit!=null) {
			response.sendRedirect("exit.jsp");
		}
		}catch(SQLException e) {
			System.out.println("Error on index page: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
