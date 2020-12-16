package com.revature.services;

import java.util.List;

import com.revature.launcher.Entertainment720Launcher;
import com.revature.models.EntertainmentMedia;
import com.revature.repositories.EntertainmentMediaDAO;

public class EntertainmentMediaServiceImplementation implements EntertainmentMediaService{

	private EntertainmentMediaDAO emd;
	
	public EntertainmentMediaServiceImplementation(EntertainmentMediaDAO emd ) {
		this.emd = emd;
	}
	
	
	
	public List<EntertainmentMedia> seeAllMedia() {
		
		return emd.findAll();
	}

	
	public void rateMedia(EntertainmentMedia em, int rating) {
		//verify the em exists
		//get its current rating
		//recalculate a new rating
		//update the em with a new rating
		emd.updateEntertainmentMedia(em);

	}


	public EntertainmentMedia purchaseMedia(EntertainmentMedia em) {
		//verify this is a real Em
		//emd.findEntertainmentMediaByName(em.getName());
		//I would send a new a purchase object to my purchaseDao
		//make sure we save their purchasing data
		//return the full data of thing they bought
		Entertainment720Launcher.e720Logger.debug("Someone Purchased " + em.getName());
		System.out.println("Hooray you bought " + em.getName());
		return null;
	}

}
