package com.revature.models;

import java.util.Arrays;

public abstract class EntertainmentMedia extends Object implements Displayable, Comparable<EntertainmentMedia>{

	private static int numberOfMedia = 0;
	
	
	private int mediaId;
	
	private double price;
	//what kind of media
	private String type;
	//what this thing is called
	private String name;
	
	private String copyrightOwner;
	
	//this is because I don't want to deal with date
	private String releaseDate;
	
	private int rating = 0;
	
	private int[] recommendedAgeRange = new int[2];
	
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
		
		numberOfMedia++;
	}
	
	
	
	//default constructor
	//same method/constructor with different signatures you are overloading it
	public EntertainmentMedia() {
		super();
		numberOfMedia++;
	}
	
	//method is a way for use to write a procedure that we can repeat over and over
	//we can customize the methods to fit each object
	public String display() {//return a string that represent the displaying of an Entertainment media object
		return "Name: " + this.name + "\n" + //this keyword refers to the object the method was called on
		 "	   " + "Type: " + this.type + " " +
		"Price: " + this.price; 

		
	}
	
	
	@Override
	public int compareTo(EntertainmentMedia o) {
		//how should it be sorted?
		//if this name is smaller, we get -1
		//if this name is bigger, we get 1
		//if they are the same we get 0
		return this.getName().compareTo(o.getName());
	}
	
	
	
	
	
	
	
	
	public static void doSomething() {
		numberOfMedia = 0;
	}



	@Override
	public String toString() {
		return "EntertainmentMedia [mediaId=" + mediaId + ", price=" + price + ", type=" + type + ", name=" + name
				+ ", copyrightOwner=" + copyrightOwner + ", releaseDate=" + releaseDate + ", rating=" + rating
				+ ", recommendedAgeRange=" + Arrays.toString(recommendedAgeRange) + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((copyrightOwner == null) ? 0 : copyrightOwner.hashCode());
		result = prime * result + mediaId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rating;
		result = prime * result + Arrays.hashCode(recommendedAgeRange);
		result = prime * result + ((releaseDate == null) ? 0 : releaseDate.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntertainmentMedia other = (EntertainmentMedia) obj;
		if (copyrightOwner == null) {
			if (other.copyrightOwner != null)
				return false;
		} else if (!copyrightOwner.equals(other.copyrightOwner))
			return false;
		if (mediaId != other.mediaId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (rating != other.rating)
			return false;
		if (!Arrays.equals(recommendedAgeRange, other.recommendedAgeRange))
			return false;
		if (releaseDate == null) {
			if (other.releaseDate != null)
				return false;
		} else if (!releaseDate.equals(other.releaseDate))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}



	public static int getNumberOfMedia() {
		return numberOfMedia;
	}



	public static void setNumberOfMedia(int numberOfMedia) {
		EntertainmentMedia.numberOfMedia = numberOfMedia;
	}



	public int getMediaId() {
		return mediaId;
	}



	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCopyrightOwner() {
		return copyrightOwner;
	}



	public void setCopyrightOwner(String copyrightOwner) {
		this.copyrightOwner = copyrightOwner;
	}



	public String getReleaseDate() {
		return releaseDate;
	}



	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}



	public int getRating() {
		return rating;
	}



	public void setRating(int rating) {
		this.rating = rating;
	}



	public int[] getRecommendedAgeRange() {
		return recommendedAgeRange;
	}



	public void setRecommendedAgeRange(int[] recommendedAgeRange) {
		this.recommendedAgeRange = recommendedAgeRange;
	}


	
	
}
