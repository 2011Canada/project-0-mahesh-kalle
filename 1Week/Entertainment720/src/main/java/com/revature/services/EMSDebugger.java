package com.revature.services;

import java.util.List;

import com.revature.models.EntertainmentMedia;
import com.revature.repositories.EntertainmentMediaMemoryDao;

public class EMSDebugger {
	
	public static void main(String[] args) {
		EntertainmentMediaService ems = new EntertainmentMediaServiceImplementation(new EntertainmentMediaMemoryDao());
		
		List<EntertainmentMedia> catalogue = ems.seeAllMedia();
		
		for(EntertainmentMedia em : catalogue) {
			System.out.println(em);
		}
		
		
		
	}

}
