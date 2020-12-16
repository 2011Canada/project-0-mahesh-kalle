package com.revature.models;

/**
 * @author Alec
 *
 */
public class Book extends EntertainmentMedia {
	
	private int numPages;
	
	String author;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(double price,  String name, String copyrightOwner, String releaseDate, int rating,
			int[] recommendedAgeRange) {
		super(price, "Book", name, copyrightOwner, releaseDate, rating, recommendedAgeRange);
		// TODO Auto-generated constructor stub
	}

	public Book(double price, String name, String copyrightOwner, String releaseDate, int rating,
			int[] recommendedAgeRange, int numPages, String author) {
		this(price,  name, copyrightOwner, releaseDate, rating, recommendedAgeRange);
		this.numPages = numPages;
		this.author = author;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "[ " + super.toString() +  "\n Book [numPages=" + numPages + ", author=" + author + "]" + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + numPages;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (numPages != other.numPages)
			return false;
		return true;
	}
	
	
	

}
