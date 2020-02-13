package com.wallet.bean;

public class Account {
	String name;
	int id;
	String password;
	int balance;
	String date;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String toString() {
		return "Name: "+this.getName() + " ID: " + this.getId()+ " Balance: "+this.getBalance() + " Account created on: "+this.getDate();
	}
}
