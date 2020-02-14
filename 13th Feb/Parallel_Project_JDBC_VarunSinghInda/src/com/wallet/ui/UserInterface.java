package com.wallet.ui;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.wallet.bean.Account;
import com.wallet.service.WalletService;

public class UserInterface {
	public static void main(String[] args) throws SQLException {
		Scanner n = new Scanner(System.in);
		WalletService ws = new WalletService();
		Date d = new Date();
		while(true) {
			int n1 = 0;
			while(true) {
				System.out.println("1. Create an account");
				System.out.println("2. Log in to an existing account");
				System.out.println("3. View all users");
				System.out.println("4. Delete Account");
				System.out.println("5. Any other number to exit");
				String n12 = n.nextLine();
				try {
					n1 = Integer.parseInt(n12);
					break;
				}catch(Exception e) {
					System.out.println("Enter a number for further process");
				}
			}
			if(n1==1) {
				try {
				String name = "";
				while(true) {
					System.out.print("Enter your name: ");
					name = n.nextLine();
					name = name.trim();
					if(name.length()>0) {
						break;
					}
					else {
						System.out.println("The name field can't be empty..Try again");
					}
				}
				String password = "";
				while(true) {
					System.out.print("Enter your password: ");
					password = n.nextLine();
					password = password.trim();
					if(password.length()>0) {
						break;
					}
					else {
						System.out.println("The password field can't be empty...Try again");
					}
				}
				int id = 0;
				Account a = new Account();
				while(true) {
					while(true) {
						System.out.print("Enter your unique ID: ");
						String id1 = n.nextLine();
						try {
							id = Integer.parseInt(id1);
							if(id<0) {
								System.out.println("ID cannot be negative");
								
							}
							else {
								a.setId(id);
								break;
							}
						}catch(Exception e) {
							System.out.println("Error... Unique ID should only be an integer value, try again");
						}
					}
					if(ws.checkID(a)) {
						System.out.println("ID already exist in the database...Try again");
					}
					else {
						break;
					}
				}
				int bal = 0;
				while(true) {
					System.out.print("Enter your starting balance: ");
					String bal1 = n.nextLine();
					try {
						bal = Integer.parseInt(bal1);
						if(bal<0) {
							System.out.println("Balance cannot be negative");
						}
						else {
							break;
						}
					}catch(Exception e) {
						System.out.println("Error... Balance should only be an integer value, try again");
					}
				}
				//Account a = new Account();
				//a.setId(id);
				a.setName(name);
				a.setPassword(password);
				a.setBalance(bal);
				a.setDate(d.toString());
				ws.createAccount(a);
				System.out.println("Account created successfully");
				}catch(Exception e) {
					System.out.println("Error while creating account");
				}
			}
			else if(n1==2) {
				try {
				int id = 0;
				Account a = new Account();
				while(true) {
					System.out.print("Enter your unique ID: ");
					String id1 = n.nextLine();
					try {
						id = Integer.parseInt(id1.trim());
						break;
					}catch(Exception e) {
						System.out.println("Error... Unique ID should only be an integer value, try again");
					}
				}
				a.setId(id);
				String pass = "";
				while(true) {
					System.out.print("Enter your password: ");
					pass = n.nextLine();
					pass = pass.trim();
					if(pass.length()>0) {
						break;
					}
					else {
						System.out.println("Password field is required....Try again");
					}
				}
				a.setPassword(pass);
				if(ws.login(a)) {
					while(true) {
						int n2 = 0;
						while(true) {
							System.out.println("1. Credit balance");
							System.out.println("2. Debit balance");
							System.out.println("3. View balance");
							System.out.println("4. Fund transfer");
							System.out.println("5. View all transactions");
							System.out.println("6. Any other number to Log out");
							String n21 = n.nextLine();
							try {
								n2 = Integer.parseInt(n21);
								break;
							}catch(Exception e) {
								System.out.println("Enter a number for further process");
							}
						}
						if(n2==1) {
							int money = 0;
							while(true) {
								System.out.print("Enter the amount that you want to credit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									if(money<0) {
										System.out.println("Amount can't be negative");
									}
									else {
										break;
									}
								}catch(Exception e) {
									System.out.println("Error... Amount should only be an integer value, try again");
								}
							}
							a.setDate(d.toString());
							int m = ws.deposit(a, money);
							if(m==1){
								System.out.println("Credited successfully");
								System.out.println("Your updated balance: "+ws.balanceCheck(a));
							}
						}
						else if(n2==2) {
							int money = 0;
							while(true) {
								System.out.print("Enter the amount that you want to debit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									if(money<0) {
										System.out.println("Amount can't be negative");
									}
									else {
										if(money<=ws.balanceCheck(a)) {
											a.setDate(d.toString());
											int m = ws.withdraw(a, money);
											if(m==1) {
												System.out.println("Deposited Successfully");
												System.out.println("Your updated balance: " +ws.balanceCheck(a));
											}
										}
										else {
											System.out.println("Withdrawn amount is more than the present balance");
										}
										break;
									}
								}catch(Exception e) {
									System.out.println("Error... Amount should only be an integer value, try again");
								}
							}
						}
						else if(n2==3) {
							System.out.println("Your balanace: "+ws.balanceCheck(a));
						}
						else if(n2==4) {
							int idp = 0;
							while(true) {
								System.out.print("Enter the unique ID of the person: ");
								String idp1 = n.nextLine();
								try {
									idp = Integer.parseInt(idp1);
									break;
								}catch(Exception e) {
									System.out.println("Error... Unique ID should only be an integer value, try again");
								}
							}
							int money = 0;
							while(true) {
								System.out.print("Enter the amount that you want to debit: ");
								String money1 = n.nextLine();
								try {
									money = Integer.parseInt(money1);
									if(money<0) {
										System.out.println("Amount cannot be negative");
									}
									else {
										if(money<=ws.balanceCheck(a)) {
											a.setDate(d.toString());
											int m3 =ws.fundTransfer(a, money, idp);
											if(m3==1) {
												System.out.println("Transferred Successfully");
												System.out.println("Your updated balance: "+ws.balanceCheck(a));
												break;
											}
										}
										else {
											System.out.println("Withdrawn amount is more than the present balance");
										}
										
									}
								}catch(Exception e) {
									System.out.println("Error... Amount should only be an integer value, try again"+e.getMessage());
								}
							}
						}
						else if(n2==5) {
							ArrayList<String> al = ws.allTransactions(a);
							for(String str:al) {
								System.out.println(str);
							}
						}
						else {
							break;
						}
					}
					}
				else {
					System.out.println("Wrong unique ID or password");
				}
				}catch(Exception e) {
					System.out.println("Error while logging in");
				}
			}
			else if(n1==3) {
				try {
				ArrayList<String> al = ws.allUsers();
				for(String a:al) {
					System.out.println(a);
				}
				}catch(Exception e) {
					System.out.println("Exception while displaying users");
				}
			}
			else if(n1==4) {
				try {
				int id = 0;
				while(true) {
					System.out.print("Enter your unique ID: ");
					String id1 = n.nextLine();
					try {
						id = Integer.parseInt(id1.trim());
						break;
					}catch(Exception e) {
						System.out.println("Error... Unique ID should only be an integer value, try again");
					}
				}
				String pass = "";
				while(true) {
					System.out.print("Enter your password: ");
					pass = n.nextLine();
					pass = pass.trim();
					if(pass.length()>0) {
						break;
					}
					else {
						System.out.println("Password field is required....Try again");
					}
				}
				Account a = new Account();
				a.setId(id);
				a.setPassword(pass);
				int m = ws.deleteID(a);
				if(m==1) {
					System.out.println("Deleted successfully");
				}
				else {
					System.out.println("ID is not present in the database");
				}
				}catch(Exception e) {
					System.out.println("Exception while deleting user");
				}
			}
			else {
				break;
			}
		}
		System.out.println("Thank you for using ewallet");
		try {
		ws.close();
		}catch(Exception e) {
			System.out.println("Exception while closing database");
		}
	}
}
