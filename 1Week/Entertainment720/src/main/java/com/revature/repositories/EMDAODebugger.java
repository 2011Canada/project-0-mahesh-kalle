package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;

public class EMDAODebugger {

	public static void main(String[] args) {
		EntertainmentMediaDAO emd = new EntertainmentMediaMemoryDao();
		
		List<EntertainmentMedia> catalgoue = emd.findAll();

		for(EntertainmentMedia em : catalgoue) {
			System.out.println(em);
		}
		
		//does get by name work?
		try {
			EntertainmentMedia hp3 = emd.findEntertainmentMediaByName("arry Potter and the Prisoner of Azkaban");
			System.out.println(hp3);
		} catch (MediaNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
