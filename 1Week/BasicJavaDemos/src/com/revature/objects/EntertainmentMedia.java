package com.revature.objects;

import java.util.Arrays;

public class EntertainmentMedia {

	double price;
	//what kind of media
	String type;
	//what this thing is called
	String name;
	
	String copyrightOwner;
	
	//this is because I don't want to deal with date
	String releaseDate;
	
	int rating;
	
	int[] recommendedAgeRange = new int[2];
	
	//constructor takes the name of the class
	public EntertainmentMedia(double price, //constructors can have any parameters we want
								String type, 
								String name, 
								String copyrightOwner, 
								String releaseDate, 
								int rating,
								int[] recommendedAgeRange) {
		this.price = price;//the this keyword refers to the object that is being created
		this.type = type;
		this.name = name;
		this.copyrightOwner = copyrightOwner;
		this.recommendedAgeRange = recommendedAgeRange;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}
	
	
	//partial constructor
	public EntertainmentMedia(String name, int rating) {
		//instead of the super keyword and calling a parent constructor
		//we can the the this keyword to call on of our other constructor
		this(0.0,"Unknown" ,name, "Unknown", "Unknown", rating, null);
	}
	
	//default constructor
	//same method/constructor with different signatures you are overloading it
	public EntertainmentMedia() {
		super();
	}
	
	//method is a way for use to write a procedure that we can repeat over and over
	//we can customize the methods to fit each object
	public String display() {//return a string that represent the displaying of an Entertainment media object
		return "Name: " + this.name + "\n" +//this keyword refers to the object the method was called on
		"Owner: " + this.copyrightOwner + "\n" +
		"Type: " + this.type + "\n" +
		"Price: " + this.price + "\n" +
		"Rating: " + this.rating + "\n";
		
	}
	
}
