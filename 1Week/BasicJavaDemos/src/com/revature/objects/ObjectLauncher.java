package com.revature.objects;

public class ObjectLauncher {
	
	public static void main(String  args[]) {
		//use the new keyword with a constructor to instantiate a class
		EntertainmentMedia lotr = new EntertainmentMedia(34.99,  "Movie", "Lord of the Rings: Fellowship of the Ring", "JRR Estates","2001-12-20", 10, new int[] {10,55});//every class has at least one constructor
		EntertainmentMedia hotFuzz = new EntertainmentMedia();
		
		System.out.println(lotr.display());
		System.out.println(hotFuzz.display());
	}

}
