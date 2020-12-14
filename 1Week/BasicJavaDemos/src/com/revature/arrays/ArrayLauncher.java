package com.revature.arrays;

import com.revature.inheritance.Movie;

public class ArrayLauncher {

	
	public static void main(String[] args) {
		int [] intArr = new int[10];
		
		for(int i = 0; i < intArr.length; i++) {
			System.out.println("i = " + i + " arr[i] =  " + intArr[i]);
		}
		System.out.println();
		for(int i = intArr.length -1; i >= 0 ; i--) {
			System.out.println("i = " + i + " arr[i] =  " + intArr[i]);
		}
		
		Object [] objArr = new Object[10];
		objArr[0] = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] {15, 55});
		for(int i = 0; i < objArr.length; i++) {
			System.out.println("i = " + i + " obj[i] =  " + objArr[i]);
		}
		
		int [][][][][][][] d2 = new int[10][5][2][1][][][];//as many dimensions as you want
		
		
	}
}
