package com.revature;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelloWorld {
	
	public static void main(String as[]) {
		System.out.println("Hello World!!");
		String s = "hello";
		String s2 = "hello";
		
		compareStrings(s,s2);
		
		String s3= "he"+"llo";
		
		compareStrings(s,s3);
		
		String s4 = "he";
		String s5="llo";
		String s6=s4+s5;
		
		//compareStrings(s,s6);
		
		String name="test1234+";
		String regex = "^[a-zA-Z0-9]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(name);
		System.out.println("Regex test: "+matcher.matches());
		
		
		
	}

	public static void compareStrings(String s, String s2) {
		/*
		 * System.out.println(" == "+(s==s2));
		 * System.out.println(" equals() "+s.equals(s2));
		 */
		
		int a = 4;
		System.out.println(a++);
		
		System.out.println(" ---------------- ");
	}
}

