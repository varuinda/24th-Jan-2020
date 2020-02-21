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
 * Servlet implementation class CreditBalanceServlet
 */
@WebServlet("/CreditBalanceServlet")
public class CreditBalanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idsp = (String)request.getSession().getAttribute("sid");
		if(idsp==null){
			response.sendRedirect("index.jsp");
		}
		else {
		String id = (String)request.getSession().getAttribute("sid");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
		else {
		String creditbalance = request.getParameter("creditholder");
		String creditbutton  = request.getParameter("creditbutton");
		Account a  = new Account();
		Date date = new Date();
		MainService ms = new MainService();
		try {
		a.setBalance(Integer.parseInt(creditbalance));
		if(Integer.parseInt(creditbalance)<0) {
			request.setAttribute("message1", "Amount should have positive integer values");
			request.getRequestDispatcher("creditbalance.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Amount should have integer values");
			request.getRequestDispatcher("creditbalance.jsp").forward(request, response);
		}
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setDate(date.toString());
		try {
		if(creditbutton!=null) {
			//service to add balance
			//service to show balance
			int m = ms.deposit(a);
			if(m==1) {
				StringBuilder sb = new StringBuilder();
				sb.append("Deposit Successful...Your updated balance: ");
				sb.append(ms.balanceCheck(a));
				request.setAttribute("message1",sb.toString() );
				request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.println("Error while credit: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while credit driver: "+e.getMessage());
		}
		}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
