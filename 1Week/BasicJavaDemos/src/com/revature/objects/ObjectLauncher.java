package com.revature.objects;

public class ObjectLauncher extends Object {
	
	public static void main(String  args[]) {
		//use the new keyword with a constructor to instantiate a class
		EntertainmentMedia lotr = new EntertainmentMedia(34.99,  "Movie", "Lord of the Rings: Fellowship of the Ring", "JRR Estates","2001-12-20", 10, new int[] {10,55});//every class has at least one constructor
		EntertainmentMedia hotFuzz = new EntertainmentMedia();
		
		
		//this is bad
		//lotr.numberOfMedia = 10;
		//if you want to change a static or use it in any way
		// do so using the class
		
		//EntertainmentMedia.numberOfMedia = 10;
		//above was forbidden by the private keyword
		EntertainmentMedia.getNumberOfMedia();
		
		System.out.println(lotr);
		System.out.println(hotFuzz.display());
		
		
		
		System.out.println(EntertainmentMedia.getNumberOfMedia());
	}

}
