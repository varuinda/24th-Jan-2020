package com.wallet.service;

import com.wallet.bean.Account;
import com.wallet.database.Data1;
import com.wallet.database.Data2;

public class WalletService implements WalletServiceInterface{
	Account a = new Account();
	Data1 d1 = new Data1();
	Data2 d2 = new Data2();
	int c = 0;
	public void deposit(int id,int m,String d) {
		d1.addMoney(id,m);
		d2.creditTransaction(id,m,d);
	}
	public void withdraw(int id,int m,String d) {
		d1.withdrawMoney(id,m);
	}
	public int balanceCheck(int id) {
		return d1.balance(id);
	}
	public void allTransactions(int id) {
			d2.transactions(id);
	}
	public void createAccount(Account a) {
		d1.createAcc(a);
		c++;
	}
	public void fundTransfer(int id,int m,int idp,String d) {
		if(checkID(idp)) {	
			d1.transfer(id,m,idp);
			d1.withdrawMoney(id,m);
			d2.debitTransaction(id,m,d);
			d2.creditTransaction(idp, m, d);
		}
		else {
			System.out.println("ID is not present in the database");
		}
	}
	public void allUsers() {
		d1.showAll();
	}
	public boolean login(int id,String p) {
		return d1.log(id,p);
	}
	public boolean checkID(int id) {
		return d1.checkid(id);
	}
	public void close() {
		d1.closeDB();
	}
}
