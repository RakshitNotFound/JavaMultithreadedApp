package com.bank.main;

import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;


class  ApplicationThread implements Runnable {
	
	public void run() {
		
		JFrame f=new JFrame("Button Example");
	    final JTextField tf=new JTextField();
	    tf.setBounds(50,50, 150,20);
	    JButton b=new JButton("Click Here"); 
	    b.setBounds(50,100,95,30);
	    
	    b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
	            tf.setText("Welcome to Javatpoint.");
	        }
	    });
	    
	    f.add(b);f.add(tf);
	    f.setSize(400,400);
	    f.setLayout(null);
	    f.setVisible(true);
	}  
	
}

class ThreadingLogic {
	
	public static void createThread() {
		
		ApplicationThread app = new ApplicationThread();
		
		Thread t1 = new Thread(app);
		t1.start();
	}
}

public class MainThreaded {
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("1 - new client, 2 - exit");
			Scanner sc = new Scanner(System.in);
			Integer choice = sc.nextInt();
			if(choice == 1) {
				ThreadingLogic.createThread();
			}
			else {
				sc.close();
				return;
			}
		}
		
	}
}
