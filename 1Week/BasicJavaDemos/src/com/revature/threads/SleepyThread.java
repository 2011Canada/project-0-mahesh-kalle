package com.revature.threads;

public class SleepyThread implements Runnable{

	
	@Override
	public void run() {
		
		System.out.println("Boy I am so sleeeeepy");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//
		System.out.println("Now that I am Awake, it is time to die!");
		
		
	}
}
