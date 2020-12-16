package com.revature.threads;

public class ThreadStateLauncher {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread sleepy = new Thread(new SleepyThread());
		Thread waiting = new Thread(new WaitingThread(sleepy));
		
		
		sleepy.setName("Sleepy Thread");
		waiting.setName("Waiting Thread");
		
		System.out.println(sleepy.getName() + ": State: " + sleepy.getState());//1????
		
		sleepy.start();
		
		System.out.println(sleepy.getName() + ": State: " + sleepy.getState());//2????
		
		//this is a JVM hack
		//by having all but one thread sleeping we can trick the JVM into choosing the thread we want
		Thread.sleep(1000);
		
		System.out.println(sleepy.getName() + ": State: " + sleepy.getState());//3????
		
		waiting.start();
		
		
		Thread.sleep(1000);
		
		System.out.println(waiting.getName() + ": State: " + waiting.getState());//4????
		
		
		Thread.sleep(5000);
		
		System.out.println(sleepy.getName() + ": State: " + sleepy.getState());//5????
		System.out.println(waiting.getName() + ": State: " + waiting.getState());//6????
		
		
	}
	
	

}
