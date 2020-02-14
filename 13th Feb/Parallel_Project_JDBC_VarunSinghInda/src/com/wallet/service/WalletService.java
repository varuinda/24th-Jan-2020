package com.wallet.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.wallet.bean.Account;
import com.wallet.database.Data1;
import com.wallet.database.Data2;

public class WalletService implements WalletServiceInterface{
	int c = 0;
	Date d= new Date();
	public int deposit(Account a,int m)throws SQLException{
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		d1.addMoney(a,m);
		d2.creditTransaction(a,m);
		return 1;
	}
	public int withdraw(Account a,int m)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		d1.withdrawMoney(a,m);
		d2.debitTransaction(a, m);
		return 1;
	}
	public int balanceCheck(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		return d1.balance(a);
	}
	public ArrayList<String> allTransactions(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
			return d2.transactions(a);
	}
	public void createAccount(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		d1.createAcc(a);
	}
	public int fundTransfer(Account a,int m,int idp)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		//a.setId(idp);
		Account b = new Account();
		b.setDate(d.toString());
		b.setId(idp);
		if(d1.checkid(b)) {	
			d1.transfer(a,m,idp);
			//d1.withdrawMoney(id,m);
			d2.debitTransaction(a,m);
			d2.creditTransaction(b, m);
			return 1;
		}
		return 0;
	}
	public ArrayList<String> allUsers()throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		return d1.showAll();
	}
	public boolean login(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		return d1.log(a);
	}
	public boolean checkID(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		return d1.checkid(a);
	}
	public void close()throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		d1.closeDB();
	}
	public int deleteID(Account a)throws SQLException {
		Data1 d1 = new Data1();
		Data2 d2 = new Data2();
		if(d1.checkid(a)) {
			d1.delete(a);
			return 1;
		}
		else {
			return 0;
		}
	}
}
