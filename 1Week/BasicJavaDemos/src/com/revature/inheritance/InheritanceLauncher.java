package com.revature.inheritance;

public class InheritanceLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie hotFuzz = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] {15, 55});
		
		System.out.println(hotFuzz.display());

	}

}
