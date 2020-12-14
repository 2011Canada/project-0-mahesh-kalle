package com.revature.primitives;

public class PrimitivesLauncher {
	
	
	public static void main(String [] args) {
		
		byte b = 127;
		
		System.out.println("Byte: " + b);

		//overflow
		//overflow is bad, be careful when assign values to primitives, especially the small ones
		b = (byte)10000;
		
		System.out.println("Byte: " + b);
		
		
		short s = -32767;
		
		System.out.println("Short: " + s);
		
		//based on the original unicode 
		char c = 84;
		
		System.out.println("Char: " + c);
		
		int i = Integer.MAX_VALUE;
		
		System.out.println("Int: " + i);
		
		
		//converting between primitives, easy to assign a small to a big, not vice versa
		
		//in java number literals are assumed to be integers or doubles depending on if there is a decimal
		//if a put a number literal thats bigger than an int you get an error
		// put a capital letter L at the end of the number to tell the compiler to treat it as a long
		long l = 3000000000L;
		
		float f = 1.1F;
		
		double d = 2.5;
		
		boolean bool = true;
		bool = false;
		
		
	}
	

}
