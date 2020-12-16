package com.revature.services;

import java.util.List;

import com.revature.models.EntertainmentMedia;

public interface EntertainmentMediaService {

	public List<EntertainmentMedia> seeAllMedia();
	
	public void rateMedia(EntertainmentMedia em, int rating);
	
	public EntertainmentMedia purchaseMedia(EntertainmentMedia em);
	
}
