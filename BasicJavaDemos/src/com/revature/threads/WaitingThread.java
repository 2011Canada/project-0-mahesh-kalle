package com.revature.threads;

public class WaitingThread implements Runnable {
	
	Thread toWaitOn;
	
	public WaitingThread(Thread t) {
		this.toWaitOn = t;
	}
	
	@Override
	public void run() {
		
		System.out.println("I am the waiting Thread I am Waiting on " + this.toWaitOn.getName());
		try {
			this.toWaitOn.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//waits for the specified thread to die, before continuing execution
		System.out.println("The thread I was waiting on died, so now I die as well");
	}
	

}
