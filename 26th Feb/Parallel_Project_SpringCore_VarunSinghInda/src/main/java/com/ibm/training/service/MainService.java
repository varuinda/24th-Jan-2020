package com.ibm.training.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.bean.Account;
import com.ibm.training.bean.Transaction;
import com.ibm.training.dao.AccountDatabase;
import com.ibm.training.dao.TransactionDatabase;


@Service
public class MainService {
	@Autowired
	AccountDatabase ad;
	@Autowired
	TransactionDatabase td;
	public int addAccount(Account a){
		if(!ad.check(a)) {
			ad.addNewAccount(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public int login(Account a) {
		if(ad.log(a)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public int getBalance(Account a){
		return ad.balance(a);
	}
	public int debit(Account a){
		if(a.getBalance()<=getBalance(a)) {
			ad.withdrawMoney(a);
			td.debitTransaction(a);
			return 1;
		}
		else {
			return 0;
		}
	}
	public int credit(Account a){
		ad.addMoney(a);
		td.creditTransaction(a);
		return 1;
	}
	public int checkID(Account a) {
		if(ad.checkid(a)) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public List<Transaction> viewAllTransactions(Account a) {
		return td.viewAll(a);
		
	}
	public List<Account> viewUsers() {
		return ad.viewAll();
		
	}
}
