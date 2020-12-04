package com.revature.abstraction;

import java.util.Arrays;


public class Movie extends EntertainmentMedia {
	
	double runtime;
	
	String[] credits;
	
	//we can use a specialized child to configure its generalized parent
	public Movie (double price, String name, String copyrightOwner, String releaseDate, int rating, int [] recommendedAgeRange ) {
		super(price, "Movie", name, copyrightOwner, releaseDate, rating, recommendedAgeRange);
	}
	
	
	
	@Override//polymorphism
	public String display() {
		//building a bad movie screen for the display
		String border = "";
		for(int i = 0; i < 100; i++) {
			border += "#";
		}
		//modify this some day
		//TODO
		
		String original = super.display();
		
		
		return border + "\n" + original + border + "\n";
	}



	@Override
	public String toString() {
		return "[ " + super.toString() + "\n Movie [runtime=" + runtime + ", credits=" + Arrays.toString(credits) + "]" + "]";
	}
	
	
	
}
