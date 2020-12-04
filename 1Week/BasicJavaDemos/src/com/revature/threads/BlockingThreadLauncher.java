package com.revature.threads;

public class BlockingThreadLauncher {

	public static void main(String[] args) throws InterruptedException {
		
		
		SynchronizedResource sr = new SynchronizedResource();
		
		Thread t1 = new Thread ( new ConsumerThread(sr));
		Thread t2 = new Thread ( new ConsumerThread(sr));
		Thread t3 = new Thread ( new ConsumerThread(sr));
		
		t1.setName("Thread 1");
		t2.setName("Thread 2");
		t3.setName("Thread 3");
		
		
		t1.start();
		t2.start();
		t3.start();
		
		Thread.sleep(1000);
		
		
		System.out.println(t1.getName() + " State: " + t1.getState());
		System.out.println(t2.getName() + " State: " + t2.getState());
		System.out.println(t3.getName() + " State: " + t3.getState());
		
		Thread.sleep(3000);
		
		System.out.println(t1.getName() + " State: " + t1.getState());
		System.out.println(t2.getName() + " State: " + t2.getState());
		System.out.println(t3.getName() + " State: " + t3.getState());
		
	}
	
	
}
