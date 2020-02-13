package com.wallet.bean;

public class Transaction {
	int  id;
	int withdraw;
	int credit;
	String date_tran;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDate_tran() {
		return date_tran;
	}
	public void setDate_tran(String date_tran) {
		this.date_tran = date_tran;
	}
	
}
