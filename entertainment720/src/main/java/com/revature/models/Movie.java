package com.revature.models;

import java.util.Arrays;


public class Movie extends EntertainmentMedia {
	
	double runtime;
	
	//the one to infinity people that worked on the movie
	String[] credits;
	
	//we can use a specialized child to configure its generalized parent
	public Movie (double price, String name, String copyrightOwner, String releaseDate, int rating, int [] recommendedAgeRange ) {
		super(price, "Movie", name, copyrightOwner, releaseDate, rating, recommendedAgeRange);
	}
	
	public Movie() {
		super();
		this.setType("Movie");
	}
	
	
	
	
	
//	@Override//polymorphism
//	public String display() {
//		//building a bad movie screen for the display
//		String border = "";
//		for(int i = 0; i < 100; i++) {
//			border += "#";
//		}
//		//modify this some day
//		//TODO
//		
//		String original = super.display();
//		
//		
//		return border + "\n" + original + border + "\n";
//	}



	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}

	public String[] getCredits() {
		return credits;
	}

	public void setCredits(String[] credits) {
		this.credits = credits;
	}

	@Override
	public String toString() {
		return "[ " + super.toString() + "\n Movie [runtime=" + runtime + ", credits=" + Arrays.toString(credits) + "]" + "]";
	}
	
	
	
}
