package com.revature.strings;

public class StringLauncher {

	
	
	public static void main(String[] args) {
		
		String s = "hello";
		
		String s2 = "hello";
		
		System.out.println( "Comapring s and s2" );
		compareStrings(s,s2);//true for both?
		
		String s3 = "he" + "llo";
		
		System.out.println("Comapring s and s3");
		compareStrings(s, s3);//true for both?
		
		String s4 = "he";
		
		String s5 = "llo";
		
		String s6 = s4 + s5;
		
	
		
		System.out.println("Comparing s and s6");
		compareStrings(s, s6);
		
		
		String s7 = new String("hello");
		
		System.out.println("Comparing s and s7");
		compareStrings(s, s7);
		
		
		String repeat = "abcdbacdcabdbcad";
		String [] split = repeat.split("d");
		for(int i = 0; i< split.length; i++) {
			System.out.println(split[i]);
		}
		String joined = String.join(":", split);
		System.out.println(joined);
		
		StringBuilder sb = new StringBuilder("Hello World");
		
		sb.reverse().insert(4, "this").append(" SB rulez");
		
		System.out.println(sb);
		
	}
	
	
	public static void compareStrings(String s, String s2) {
		System.out.println("String 1 == String 2: " + (s==s2));
		System.out.println("String 1 .equals String 2: " + s.equals(s2));
	}
	
	
	
}
