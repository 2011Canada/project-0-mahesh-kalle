package com.revature.abstraction;



public class AbstractionLauncher {

	
	
	public static void main(String[] args) {
		
		EntertainmentMedia lotr = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] {15, 55});
		EntertainmentMedia hp3 = new Book(17.99, "Harry Potter and the Prisoner of Azkaban", "Penguin", "2003", 8, new int [] {10, 25}, 320, "J.K.Rowling");
		
		Menu main = new Menu(new Displayable[] {lotr, hp3});
		
		System.out.println(main.display());
				
				
	}
}
