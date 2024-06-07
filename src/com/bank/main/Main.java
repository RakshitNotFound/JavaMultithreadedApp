package com.bank.main;

import java.util.Scanner;

import com.bank.Bank;
import com.bank.Customer;

public class Main {
	
	public static void main(String[] args) {
		
		Bank b = new Bank();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1 - register, 2 - login, 3 - exit");
			int op = sc.nextInt();
			if(op == 1) {
				String name = sc.next();
				String password = sc.next();
				Integer accNo = b.register(name, password);
				System.out.println(accNo);
				continue;
			}
			else if(op == 2) {
				Integer accNo = sc.nextInt();
				String password = sc.next();
				Customer c = b.login(accNo, password);
				if(c.getLoggedIn()) {
					while(true) {
						System.out.println("1 - withdraw, 2 - deposit, 3 - show info, 4 - log out");
						int op2 = sc.nextInt();
						if(op2 == 1) {
							Double amount = sc.nextDouble();
							c.withdraw(amount);
						}
						else if(op2 == 2) {
							Double amount = sc.nextDouble();
							c.deposit(amount);
						}
						else if(op2 == 3) {
							c.showCustomerInfo();
						}
						else if(op2 == 4) {
							b.logout(accNo);
							break;
						}
						continue;
					}
				}
				else {
					continue;
				}
			}
			else if(op == 3) {
				sc.close();
				return;
			}
		}
		
	}
	
}
