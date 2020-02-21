package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Account;

/**
 * Servlet implementation class AddAccountServlet
 */
@WebServlet("/AddAccountServlet")
public class AddAccountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getSession().getAttribute("sid");
		if(id!=null){
			response.sendRedirect("loginactivity.jsp");
		}
		else {
		Account a = new Account();
		MainService ms = new MainService();
		Date date = new Date();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String uniqueid = request.getParameter("uniqueid");
		String startingbalance = request.getParameter("startingbalance");
		String create = request.getParameter("createaccount");
		if(name.trim().length()==0) {
			request.setAttribute("message1", "Name field can't be empty");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		else if(password.trim().length()==0) {
			request.setAttribute("message1", "Password field can't be empty");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		else {
		a.setName(name);
		try {
		a.setId(Integer.parseInt(uniqueid));
		if(Integer.parseInt(uniqueid)<0) {
			request.setAttribute("message1", "Unique ID should only have positive integer values");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Unique ID should only have integer values");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		a.setPassword(password);
		try {
		a.setBalance(Integer.parseInt(startingbalance));
		if(Integer.parseInt(startingbalance)<0) {
			request.setAttribute("message1", "Balance should only have positive integer values");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Balance should only have integer values");
			request.getRequestDispatcher("addaccount.jsp").forward(request, response);
		}
		a.setDate(date.toString());
		try {
			if(create!=null) {
				//service to create
				int m = ms.addAccount(a);
				String message="";
				if(m==1) {
					message="Successfully created";
				}
				else if(m==0) {
					message= "ID already exists in the database";
				}
				request.setAttribute("message1", message);
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
			}
		}catch(SQLException e) {
			System.out.println("Error while creating account "+e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Error while creating class "+e.getMessage());
		}
		}
		}
	}

}
