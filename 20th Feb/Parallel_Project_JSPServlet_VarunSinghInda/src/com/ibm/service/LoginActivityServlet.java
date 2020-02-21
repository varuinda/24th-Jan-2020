package com.ibm.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.bean.Account;

/**
 * Servlet implementation class LoginActivityServlet
 */
@WebServlet("/LoginActivityServlet")
public class LoginActivityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("sid")==null || request.getSession()==null){
			response.sendRedirect("index.jsp");
		}
		else {
		String credit = request.getParameter("creditbalance");
		String debit = request.getParameter("debitbalance");
		String viewbalance = request.getParameter("viewbalance");
		String fundtransfer = request.getParameter("fundtransfer");
		String viewtransactions = request.getParameter("viewtransactions");
		String logout = request.getParameter("logout");
		Account a = new Account();
		a.setId(Integer.parseInt(request.getSession().getAttribute("sid").toString()));
		a.setPassword(request.getSession().getAttribute("spass").toString());
		MainService ms = new MainService();
		try {
		if(credit!=null) {
			response.sendRedirect("creditbalance.jsp");
		}
		else if(debit!=null) {
			response.sendRedirect("debitbalance.jsp");
		}
		else if(viewbalance!=null) {
			//service to view balance
			int m = ms.balanceCheck(a);
			StringBuilder sb = new StringBuilder("Your balance is ");
			sb.append(m);
			request.setAttribute("message1",sb.toString() );
			request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
		}
		else if(fundtransfer!=null) {
			response.sendRedirect("fundtransfer.jsp");
		}
		else if(viewtransactions!=null) {
			//service to view all transactions
			ArrayList<String> al = ms.allTransactions(a);
			StringBuilder sb = new StringBuilder("");
			for(String str:al) {
				sb.append(str);
				sb.append("<br>");
			}
			request.setAttribute("message1",sb.toString());
			request.getRequestDispatcher("loginactivity.jsp").forward(request, response);
		}
		else if(logout!=null) {

			request.getSession().invalidate();
			request.getSession().removeAttribute("sid");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		}catch(SQLException e) {
			System.out.println("Error in loginAcitivity: "+e.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in loginActivity Driver: "+e.getMessage());
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
