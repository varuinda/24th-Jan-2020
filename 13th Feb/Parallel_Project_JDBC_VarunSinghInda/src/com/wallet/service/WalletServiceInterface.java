package com.wallet.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.wallet.bean.Account;

public interface WalletServiceInterface {
	public boolean login(Account a)throws SQLException;
	public int deposit(Account a,int m) throws SQLException;
	public int withdraw(Account a,int m)throws SQLException;
	public int balanceCheck(Account a)throws SQLException;
	public ArrayList<String> allTransactions(Account a)throws SQLException;
	public void createAccount(Account a)throws SQLException;
	public int fundTransfer(Account a,int balance,int idp)throws SQLException;
	public ArrayList<String> allUsers()throws SQLException;
	public boolean checkID(Account a)throws SQLException;
	public int deleteID(Account a)throws SQLException;
}
