package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Account;
import com.ibm.dao.Data1;

/**
 * Servlet implementation class LoginAccountServlet
 */
@WebServlet("/LoginAccountServlet")
public class LoginAccountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idsp = (String)request.getSession().getAttribute("sid");
		if(idsp!=null){
			response.sendRedirect("loginactivity.jsp");
		}
		else {
		String id = request.getParameter("uniqueid");
		String password  = request.getParameter("password");
		String login = request.getParameter("loginaccount");
		Account a = new Account();
		if(password.trim().length()==0) {
			request.setAttribute("message1", "Password field can't be empty");
			request.getRequestDispatcher("loginaccount.jsp").forward(request, response);
		}
		else {
		try {
		a.setId(Integer.parseInt(id));
		if(Integer.parseInt(id)<0) {
			request.setAttribute("message1", "Unique ID should only have positive integer values");
			request.getRequestDispatcher("loginaccount.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Unique ID should only have integer values");
			request.getRequestDispatcher("loginaccount.jsp").forward(request, response);
		}
		a.setPassword(password);
		MainService ms = new MainService();
		try {
		if(login!=null) {
			//service to check..it will redirect to loginactivity
			int m = ms.login(a);
			if(m==0) {
				request.setAttribute("message1", "Credentials do not match");
				request.getRequestDispatcher("loginaccount.jsp").forward(request, response);
			}
			else {
				request.getSession().setAttribute("sid", id);
				request.getSession().setAttribute("spass", password);
				response.sendRedirect("loginactivity.jsp");
			}
			
		}
		}catch(SQLException e) {
			System.out.println("Error while logging in: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while logging driver: "+e.getMessage());
		}
		}
		}
	}

}
