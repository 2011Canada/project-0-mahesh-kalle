package com.revature.exceptions;

import java.util.HashSet;
import java.util.Set;

import com.revature.abstraction.Book;
import com.revature.abstraction.EntertainmentMedia;
import com.revature.abstraction.Movie;

public class ExceptionLauncher {

	static CatalogueService cs = new CatalogueService();
	

	public static void main(String[] args) {
		
		//our server is running
		while(true) {
			//get some user input
			String movieSearch = "random";
			//the server would pause while waiting for user input
			
			try {
				EntertainmentMedia foundMedia = cs.findMedia(movieSearch);
				System.out.println("Found your Media");
				System.out.println(foundMedia);
				break;//this is just for the demo
				//the server should never shutdown unless seomthing terrible happens
			} catch ( MediaNotFoundException e) {
				System.out.println(e.getMessage());
				System.out.println("Please Enter another Media Choice");
				break;//this is just for the demo
				//the server should never shutdown unless seomthing terrible happens
			}
		}
	
	
	
	}
}
