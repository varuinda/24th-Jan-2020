package com.ibm.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ibm.bean.Account;
import com.ibm.dao.Data1;
import com.ibm.dao.Data2;

public class MainService {
	
	//Data2 d2 = new Data2();
	public int addAccount(Account a)throws SQLException, ClassNotFoundException {
		Data1 d1 = new Data1();
		if(!d1.check(a)) {
			d1.addNewAccount(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public int login(Account a)throws SQLException, ClassNotFoundException {
		Data1 d1 = new Data1();
		if(d1.log(a)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int balanceCheck(Account a)throws SQLException, ClassNotFoundException {
		Data1 d1 = new Data1();
		return d1.balance(a);
	}
	public int deposit(Account a)throws SQLException, ClassNotFoundException{
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		d1.addMoney(a);
		d2.creditTransaction(a);
		return 1;
	}
	public int withdraw(Account a)throws SQLException, ClassNotFoundException {
		if(a.getBalance()<balanceCheck(a)) {
			Data1 d1 = new Data1();
			Data2 d2 = new Data2();
			d1.withdrawMoney(a);
			d2.debitTransaction(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public boolean checkID(Account a)throws SQLException, ClassNotFoundException {
		Data1 d1 = new Data1();
		return d1.checkid(a);
	}
	public ArrayList<String> allUsers()throws SQLException, ClassNotFoundException {
		Data1 d1 = new Data1();
		return d1.showAll();
	}
	public ArrayList<String> allTransactions(Account a)throws SQLException, ClassNotFoundException {
		Data2 d2 = new Data2();
			return d2.transactions(a);
	}
}
