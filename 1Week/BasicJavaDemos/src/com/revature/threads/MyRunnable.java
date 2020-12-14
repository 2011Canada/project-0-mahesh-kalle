package com.revature.threads;

public class MyRunnable implements Runnable{
	
	public void run() {
		while(true) {
			System.out.println("I am the Runnable Thread");
		}
		
	};

}
