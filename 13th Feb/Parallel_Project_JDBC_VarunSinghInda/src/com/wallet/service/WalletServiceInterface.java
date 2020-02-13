package com.wallet.service;

import com.wallet.bean.Account;

public interface WalletServiceInterface {
	public boolean login(int id,String p);
	public void deposit(int id,int m,String d);
	public void withdraw(int id,int m,String d);
	public int balanceCheck(int id);
	public void allTransactions(int id);
	public void createAccount(Account a);
	public void fundTransfer(int id,int balance,int idp,String d);
	public void allUsers();
	public boolean checkID(int id);
}
