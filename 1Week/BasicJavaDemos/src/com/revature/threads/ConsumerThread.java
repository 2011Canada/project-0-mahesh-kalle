package com.revature.threads;

public class ConsumerThread implements Runnable{

	SynchronizedResource sr;
	
	public ConsumerThread(SynchronizedResource sr) {
		this.sr = sr;
	}
	
	
	@Override
	public void run() {
		
		
		Object o = sr.getResource();
		System.out.println("WHOOPEE" + Thread.currentThread().getName() + "GOT THE " + o);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//doing something
		sr.releaseResource();
	}
	
	
	
}
