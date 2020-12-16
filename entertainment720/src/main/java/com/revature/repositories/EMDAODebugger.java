package com.revature.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.revature.exceptions.MediaNotFoundException;
import com.revature.models.EntertainmentMedia;
import com.revature.models.Movie;

public class EMDAODebugger {

	public static void main(String[] args) {
		EntertainmentMediaDAO emd = new EntertainmentMediaPostgresDao();
		EntertainmentMedia em = new Movie( 2.00, "Hot Rod", "Lonely Island", "2007-01-01 00:00:00", 6, new int[] {13, 30});
		((Movie)em).setRuntime(110.30);
		emd.saveOne(em);
		
	}

}
