package com.ibm.training;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.ibm.training.bean.Account;
import com.ibm.training.bean.Transaction;
import com.ibm.training.service.MainService;

@Component("ui")
public class UI {
	@Autowired
	 Account a;
	@Autowired
	 MainService ms;
	int loginID,fundID;
	Scanner n = new Scanner(System.in);
	Date d = new Date();
	public void menu(){
    		System.out.println("1. Create Account");
    		System.out.println("2. Login into an existing account");
    		System.out.println("3. View all users");
    		System.out.println("4. Exit");
    		int n1 = 0;
    		while(true) {
    			System.out.print("Enter your response: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("Value cannot be negative...Try again");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		if(n1==1) {
    			first();
    		}
    		else if(n1==2) {
    			second();
    		}
    		else if(n1==3) {
    			third();
    		}
    		else {
    			fourth();
    		}
	}
    	public void	first() {
    			int id=0;
    			while(true) {
        			System.out.print("Enter your Unique ID: ");
        			String ids = n.nextLine();
        			id = getInt(ids);
        			if(id==-8560928) {
        				System.out.println("Enter an integer value instead of a string");
        			}
        			else {
        				if(id<0) {
        					System.out.println("Value cannot be negative...Try again");
        				}
        				else {
        					a.setId(id);
        					break;
        				}
        			}
        		}
    			String name = "";
    			while(true) {
    				System.out.print("Enter the name: ");
    				name = n.nextLine();
    				if(getStr(name)==0) {
    					System.out.println("String cannot be empty...Try again");
    				}
    				else {
    					a.setName(name);
    					break;
    				}
    			}
    			int bal=0;
    			while(true) {
        			System.out.print("Enter your starting balance: ");
        			String ids = n.nextLine();
        			bal = getInt(ids);
        			if(bal==-8560928) {
        				System.out.println("Enter an integer value instead of a string");
        			}
        			else {
        				if(bal<0) {
        					System.out.println("Value cannot be negative...Try again");
        				}
        				else {
        					a.setBalance(bal);
        					break;
        				}
        			}
        		}
    			String pass = "";
    			while(true) {
    				System.out.print("Enter the password: ");
    				pass = n.nextLine();
    				if(getStr(pass)==0) {
    					System.out.println("String cannot be empty...Try again");
    				}
    				else {
    					a.setPassword(pass);
    					break;
    				}
    			}
    			a.setDate_created(d.toString());
    			if(ms.addAccount(a)==0) {
    				System.out.println("ID already exist in the database...Try again");
    			}
    			else {
    				System.out.println("Account successfully created");
    			}
    			menu();
    		}
    	public void second() {
    		int id=0;
			while(true) {
    			System.out.print("Enter your Unique ID: ");
    			String ids = n.nextLine();
    			id = getInt(ids);
    			if(id==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(id<0) {
    					System.out.println("Value cannot be negative...Try again");
    				}
    				else {
    					a.setId(id);
    					break;
    				}
    			}
    		}
			String pass = "";
			while(true) {
				System.out.print("Enter the password: ");
				pass = n.nextLine();
				if(getStr(pass)==0) {
					System.out.println("String cannot be empty...Try again");
				}
				else {
					a.setPassword(pass);
					break;
				}
			}
			int mi = ms.login(a);
			if(mi==0) {
				System.out.println("Wrong credentials");
				menu();
			}
			else {
				loginID = a.getId();
				firstMenu();
			}
    		
    	}
    	public void firstMenu() {
    		System.out.println("1. Credit");
    		System.out.println("2. Debit");
    		System.out.println("3. View Balance");
    		System.out.println("4. Fund Transfer");
    		System.out.println("5. View all transactions");
    		System.out.println("6. Exit");
    		int n1 = 0;
    		while(true) {
    			System.out.print("Enter your response: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("Value cannot be negative...Try again");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		if(n1==1) {
    			credit();
    		}
    		else if(n1==2) {
    			debit();
    		}
    		else if(n1==3) {
    			viewBalance();
    		}
    		else if(n1==4){
    			fundTransfer();
    		}
    		else if(n1==5) {
    			viewTransactions();
    		}
    		else {
    			menu();
    		}
    	}
    	public void credit() {
    		int n1 = 0;
    		while(true) {
    			System.out.print("Enter the amount to credit: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("Amount cannot be negative...Try again");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		a.setId(loginID);
    		a.setBalance(n1);
    		a.setDate_created(d.toString());
    		ms.credit(a);
    		System.out.println("Credited successfully, Your new balance: "+ms.getBalance(a));
    		firstMenu();
    	}
    	public void debit() {
    		int n1 = 0;
    		while(true) {
    			System.out.print("Enter the amount to debit: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("Amount cannot be negative...Try again");
    				}
    				else {
    					break;
    				}
    			}
    		}
    		a.setId(fundID);
    		if(ms.checkID(a)==0) {
    			System.out.println("ID is not present in the database");
    		}
    		else {
    			a.setId(loginID);
    			a.setDate_created(d.toString());
    			a.setBalance(n1);
    			if(ms.debit(a)==0) {
    				System.out.println("Amount entered is more than the balance present");
    			}
    			else {
    				System.out.println("Debited successfully, Your new balance: "+ms.getBalance(a));
    			}
    		}
    		firstMenu();
    	}
    	public void viewBalance() {
    		a.setId(loginID);
    		System.out.println("Your balance: "+ms.getBalance(a));
    		firstMenu();
    	}
    	public void fundTransfer() {
    		int id=0;
			while(true) {
    			System.out.print("Enter the unique ID of the person to transfer: ");
    			String ids = n.nextLine();
    			id = getInt(ids);
    			if(id==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(id<0) {
    					System.out.println("Value cannot be negative...Try again");
    				}
    				else {
    					fundID = id;
    					break;
    				}
    			}
    		}
			int n1 = 0;
			while(true) {
    			System.out.print("Enter the amount to debit: ");
    			String ns1 = n.nextLine();
    			n1 = getInt(ns1);
    			if(n1==-8560928) {
    				System.out.println("Enter an integer value instead of a string");
    			}
    			else {
    				if(n1<0) {
    					System.out.println("Amount cannot be negative...Try again");
    				}
    				else {
    					break;
    				}
    			}
    		}
			a.setId(loginID);
			a.setBalance(n1);
			a.setDate_created(d.toString());
			if(ms.debit(a)==0) {
				System.out.println("Amount entered is more than the balance present");
			}
			else {
				a.setId(fundID);
				a.setBalance(n1);
				a.setDate_created(d.toString());
				ms.credit(a);
				a.setId(loginID);
				System.out.println("Transferred successfully...Your new balance: "+ms.getBalance(a));
			}
    		firstMenu();
    	}
    	public void viewTransactions() {
    		a.setId(loginID);
    		List<Transaction> al = ms.viewAllTransactions(a);
    		for(Transaction acc:al) {
    			System.out.print(acc.getId()+ " ");
    			System.out.print(acc.getChanged()+ " ");
    			System.out.print(acc.getDate_transaction());
    			System.out.println();
    		}
    		firstMenu();
    	}
    	public void third() {
    		List<Account> al = ms.viewUsers();
    		for(Account acc:al) {
    			System.out.print(acc.getId() + " ");
    			System.out.print(acc.getName()+ " ");
    			System.out.print(acc.getBalance()+" ");
    			System.out.print(acc.getDate_created());
    			System.out.println();
    		}
    		menu();
    	}
    	public void fourth() {
    		System.out.println("Thank you for using the application");
    	}
    public static int getInt(String s) {
    	int m = 0;
    	try {
    		m = Integer.parseInt(s);
    	}catch(Exception e) {
    		return -8560928;
    	}
    	return m;
    }
    public static int getStr(String s) {
    	if(s.trim().length()==0) {
    		return 0;
    	}
    	return 1;
    }

}
