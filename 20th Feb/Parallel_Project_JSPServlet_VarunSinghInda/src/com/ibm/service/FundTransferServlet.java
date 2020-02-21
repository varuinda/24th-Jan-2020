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
 * Servlet implementation class FundTransferServlet
 */
@WebServlet("/FundTransferServlet")
public class FundTransferServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String)request.getSession().getAttribute("sid");
		if(id==null){
			response.sendRedirect("index.jsp");
		}
		else {
		String reid = request.getParameter("receiverid");
		String bal = request.getParameter("balancetransfer");
		String transfer = request.getParameter("transferbutton");
		Date date = new Date();
		Account a = new Account();
		Account b = new Account();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		try {
		a.setBalance(Integer.parseInt(bal));
		if(Integer.parseInt(bal)<0) {
			request.setAttribute("message1", "Amount should only have positive integer values");
			request.getRequestDispatcher("fundtransfer.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Amount should only have integer values");
			request.getRequestDispatcher("fundtransfer.jsp").forward(request, response);
		}
		a.setDate(date.toString());
		try {
		b.setId(Integer.parseInt(reid));
		if(Integer.parseInt(reid)<0) {
			request.setAttribute("message1", "Unique ID should only have positive integer values");
			request.getRequestDispatcher("fundtransfer.jsp").forward(request, response);
		}
		}catch(Exception e) {
			request.setAttribute("message1", "Unique ID should only have integer values");
			request.getRequestDispatcher("fundtransfer.jsp").forward(request, response);
		}
		b.setBalance(Integer.parseInt(bal));
		b.setDate(date.toString());
		MainService ms = new MainService();
		try {
		if(transfer!=null) {
			//service to deduct user balance
			//service to add receiver balance
			//service to show balance;
			if(ms.checkID(b)){
				int m = ms.withdraw(a);
				if(m==1) {
					StringBuilder sb = new StringBuilder();
					int me= ms.deposit(b);
					if(me==1) {
						sb.append("Fund transfer successful...Your updated balance: ");
						sb.append(ms.balanceCheck(a));
						request.setAttribute("message1",sb.toString() );
						request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
					}
				}
				else {
					request.setAttribute("message1","Withdraw amount more than balance");
					request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("message1","Entered ID does not exists in the database" );
				request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
			}
		}
		}catch(SQLException e) {
			System.out.println("Error while fund transfer: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while fund transfer driver: "+e.getMessage());
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
