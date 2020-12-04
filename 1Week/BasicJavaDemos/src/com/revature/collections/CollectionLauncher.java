package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.revature.abstraction.Book;
import com.revature.abstraction.EntertainmentMedia;
import com.revature.abstraction.Movie;

public class CollectionLauncher {
	
	public static void main(String[] args) {
		EntertainmentMedia hotFuzz = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] {15, 55});
		EntertainmentMedia hp3 = new Book(17.99, "Harry Potter and the Prisoner of Azkaban", "Penguin", "2003", 8, new int [] {10, 25}, 320, "J.K.Rowling");
		EntertainmentMedia jumpStreet = new Movie(10.00, "21 Jump Street", "Channing Tatum and Jonah Hill", "2010-01-01", 9, new int[] {15, 55});
		EntertainmentMedia hp4 = new Book(17.99, "Harry Potter and the Goblet of Fire", "Penguin", "2005", 10, new int [] {10, 25}, 450, "J.K.Rowling");
	
		//generics
		List<EntertainmentMedia> catalogue = new LinkedList<>();
		catalogue.add(hotFuzz);
		catalogue.add(hp3);
		catalogue.add(jumpStreet);
		catalogue.add(hp4);
		
		
		for(int i = 0; i < catalogue.size(); i++) {
			System.out.println(catalogue.get(i));
		}
		catalogue.remove(1);
		System.out.println("-----------------------");
		//with anything that implements the iterable interface or basic arrays
		//we can use the enhanced for loop it looks like this
		//for (<type> id : <something iterable/array> )
		for (EntertainmentMedia em : catalogue) {
			System.out.println(em);
		}//never goes out of bounds
		//easier to read
		//much harder to manipulate the collection
		
		//how do I turn a list into a set?
		
		//one constructor option supported by all collections is to build a collection from a different
		Set<EntertainmentMedia> setCatalogue = new HashSet<>(catalogue);
		
		System.out.println("-----------------------");
		//works the same for list and set and all collections
		for(EntertainmentMedia em : setCatalogue) {
			//setCatalogue.remove(em);
		}
		setCatalogue.add(hotFuzz);
		
		System.out.println("==========================");
		
		//how an iterator works
		Iterator<EntertainmentMedia> setIterator = setCatalogue.iterator();
		while(setIterator.hasNext()) {
			EntertainmentMedia em = setIterator.next();
			if(em.getName() == "This") {
				setIterator.remove();//removes from whatever underling collection 
			}
			System.out.println(em);
		}
		
		Map<Integer, EntertainmentMedia> catalogueWithId = new HashMap<>();
		catalogueWithId.put(1, hotFuzz);
		catalogueWithId.put(2, hp3);
		catalogueWithId.put(3, hp4);
		catalogueWithId.put(4, jumpStreet);
		
		System.out.println("--------------------------");
		for(Integer i : catalogueWithId.keySet()) {

			System.out.println("Found with key:" + i + " " +catalogueWithId.get(i));
		}
		for(EntertainmentMedia em : catalogueWithId.values()) {
			System.out.println(em);
		}
		
		
		MyArrayList<EntertainmentMedia> badArray = new MyArrayList<>();
		badArray.setData(new EntertainmentMedia[] {hp3,hp4});
		EntertainmentMedia[] arr =  badArray.getdata();
		
		
		List<Book> bList = new ArrayList<>();
		bList.add((Book)hp3);
		bList.add((Book)hp4);
		
		catalogue.addAll(bList);
	}

}
