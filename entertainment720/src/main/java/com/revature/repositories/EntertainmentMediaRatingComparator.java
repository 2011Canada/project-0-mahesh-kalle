package com.revature.repositories;

import java.util.Comparator;

import com.revature.models.EntertainmentMedia;

public class EntertainmentMediaRatingComparator implements Comparator<EntertainmentMedia> {

	@Override
	public int compare(EntertainmentMedia o1, EntertainmentMedia o2) {

		if(o1.getRating() > o2.getRating()) {
			return 1;
		} else if (o1.getRating() < o2.getRating()) {
			return -1;
		}else {
			return 0;
		}
	}
	
	
}
