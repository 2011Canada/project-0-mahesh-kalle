package com.revature.threads;

public class BasicThreadLauncher {
	
	
	public static void main(String[] args) {
		
		Thread t = new MyThread();
		Thread t2 = new Thread(new MyRunnable());//do this one
		
		t.start();
		t2.start();
		
		while(true) {
			System.out.println("I am the Main Thread");
		}
		
	}
	

}
