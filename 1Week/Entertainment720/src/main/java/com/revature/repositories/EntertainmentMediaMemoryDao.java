package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.Book;
import com.revature.models.EntertainmentMedia;
import com.revature.models.Movie;

public class EntertainmentMediaMemoryDao  implements EntertainmentMediaDAO{
	
	static List<EntertainmentMedia> catalogue = new ArrayList<>();

	// static code block is a block of code that will execute when the program
	// before the main method
	static {
		EntertainmentMedia hotFuzz = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] { 15, 55 });
		EntertainmentMedia hp3 = new Book(17.99, "Harry Potter and the Prisoner of Azkaban", "Penguin", "2003", 8,
				new int[] { 10, 25 }, 320, "J.K.Rowling");
		EntertainmentMedia jumpStreet = new Movie(10.00, "21 Jump Street", "Channing Tatum and Jonah Hill",
				"2010-01-01", 9, new int[] { 15, 55 });
		EntertainmentMedia hp4 = new Book(17.99, "Harry Potter and the Goblet of Fire", "Penguin", "2005", 10,
				new int[] { 10, 25 }, 450, "J.K.Rowling");
		catalogue.add(jumpStreet);
		catalogue.add(hotFuzz);
		catalogue.add(hp3);
		catalogue.add(hp4);
	}

	@Override
	public EntertainmentMedia saveOne(EntertainmentMedia em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntertainmentMedia updateEntertainmentMedia(EntertainmentMedia em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntertainmentMedia> findAll() {
		return catalogue;
	}

	@Override
	public EntertainmentMedia findEntertainmentMediaByName(String name) throws MediaNotFoundException {
		for(EntertainmentMedia em : catalogue) {
			if(em.getName().equals(name)) {
				return em;
			}
		}
		throw new MediaNotFoundException();
	}

}
