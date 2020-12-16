package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;

//data access object
public interface EntertainmentMediaDAO {

	//what behaviour should our data layer have
	public EntertainmentMedia saveOne(EntertainmentMedia em);
	
	
	public EntertainmentMedia updateEntertainmentMedia(EntertainmentMedia em);
	
	//read all
	public List<EntertainmentMedia> findAll();
	
	//read one
	public EntertainmentMedia findEntertainmentMediaByName(String name) throws MediaNotFoundException;
	
}
