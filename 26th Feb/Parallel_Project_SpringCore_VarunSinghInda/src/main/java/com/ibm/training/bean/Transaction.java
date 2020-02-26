package com.ibm.training.bean;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	String date_transaction;
	int id;
	int changed;
	public String getDate_transaction() {
		return date_transaction;
	}
	public void setDate_transaction(String date_transaction) {
		this.date_transaction = date_transaction;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChanged() {
		return changed;
	}
	public void setChanged(int changed) {
		this.changed = changed;
	}
}
