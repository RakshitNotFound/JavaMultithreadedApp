package com.bank;

public class Customer {
	
	private String name;
	private Integer accountNo;
	private String password;
	private Double balance;
	Boolean loggedIn;
	
	Customer(String name, String password, Integer accountNo) {
		this.balance = 0.0;
		this.name = new String(name);
		this.password = new String(password);
		this.accountNo = accountNo;
		this.setLoggedIn(false);
	}
	
	public Boolean checkPassword(String password) {
//		return this.password == password ? true: false;
		if(this.password.equals(password)) return true;
		else return false;
	}
	
	public Double deposit(Double amount) {
		if(loggedIn) {
			this.balance += amount;
			return this.balance;
		} else {
			System.out.println("Log in first");
			return (double) -1;
		}
	}
	
	public Double withdraw(Double amount) {
		if(loggedIn) {
			if(this.balance >= amount) {
				this.balance -= amount;
				return this.balance;
			} else {
				System.out.println("Balance low for withdrawal");
				return (double) -1;
			}
		} else {
			System.out.println("Log in first");
			return (double) -1;
		}
	}
	
	public void showCustomerInfo() {
		if(loggedIn) {
			System.out.println(
				"Name: " + this.name + "\n" +
				"Account number: " + this.accountNo + "\n" +
				"Balance: " + this.balance + "\n"
			);
		} else {
			System.out.println("Log in first");
		}
	}
	
	protected void setLoggedIn(Boolean value) {
		this.loggedIn = value;
	}
	
	public Boolean getLoggedIn() {
		return this.loggedIn;
	}

}
