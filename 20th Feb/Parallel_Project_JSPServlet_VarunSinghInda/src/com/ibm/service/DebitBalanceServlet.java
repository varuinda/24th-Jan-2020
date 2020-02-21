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
 * Servlet implementation class DebitBalanceServlet
 */
@WebServlet("/DebitBalanceServlet")
public class DebitBalanceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String debitbalance = request.getParameter("debitholder");
		String debitbutton  = request.getParameter("debitbutton");
		Account a = new Account();
		Date date = new Date();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		try {
		a.setBalance(Integer.parseInt(debitbalance));
		if(Integer.parseInt(debitbalance)<0) {
			request.setAttribute("message1", "Amount should only have positive integer values");
			request.getRequestDispatcher("debitbalance.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Amount should only have integer values");
			request.getRequestDispatcher("debitbalance.jsp").forward(request, response);
		}
		a.setDate(date.toString());
		MainService ms = new MainService();
		try {
		if(debitbutton!=null) {
			//service to deduct balance
			//service to show balance
			int m = ms.withdraw(a);
			if(m==1) {
				StringBuilder sb = new StringBuilder();
				sb.append("Withdraw Successful...Your updated balance: ");
				sb.append(ms.balanceCheck(a));
				request.setAttribute("message1",sb.toString() );
				request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
			}
			else {
				request.setAttribute("message1","Withdraw amount more than balance");
				request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.println("Error while debit: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while debit driver: "+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
