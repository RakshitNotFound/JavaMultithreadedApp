package com.bank;

import java.util.HashMap;

public class Bank {
	
	private HashMap<Integer, Customer> db = new HashMap<Integer, Customer>();
	private int accountNoCounter = 1000;
	
	public int register(String name, String password) {
		Customer c = new Customer(name, password, accountNoCounter);
		this.db.put(accountNoCounter, c);
		return accountNoCounter++;
	}
	
	public Customer login(Integer accountNo, String password) {
		Customer c = db.get(accountNo);
		if(c == null) {
			System.out.println("Customer does not exist");
		}
		else {
			if(c.checkPassword(password)) {
				c.setLoggedIn(true);
				return c;
			} else {
				System.out.println("Wrong password");
			}
		}
		return new Customer(null, null, 0);
	}
	
	public void logout(Integer accountNo) {
		Customer c = db.get(accountNo);
		c.setLoggedIn(false);
	}
	
}
