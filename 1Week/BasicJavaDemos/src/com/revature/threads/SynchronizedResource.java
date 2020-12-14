package com.revature.threads;

public class SynchronizedResource {

	//many threads needs access to this
	//maybe its a database connection
	//maybe its an array
	//who cares
	private Object resource = new Object();
	
	//should make this a semaphore
	private boolean objectInUse = false;
	
	
	
	
	
	synchronized public Object getResource() {
		//synchronized allows for the use of 2 very useful methods
		//.wait
		//can be called on any object
		//the thread accessing the object either waits on the object
		while(objectInUse) {
			System.out.println(Thread.currentThread().getName() + " is stuck waiting on the resource");
			try {
				this.wait();//the current will wait on the object until different calls notify oin the object
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		objectInUse = true;
		return resource;
		
	}
	
	synchronized public void releaseResource() {
		//.notify
		//or notifies other threads trying to access it
		objectInUse = false;
		this.notify();//tell the other threads they can use the object now
	}
	
	
	
}
