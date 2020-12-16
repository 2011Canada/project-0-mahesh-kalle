package com.revature.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.models.Book;
import com.revature.models.EntertainmentMedia;
import com.revature.models.Movie;
import com.revature.repositories.EntertainmentMediaDAO;



public class EnterinmentMediaServiceImplementationTest {

	private EntertainmentMediaServiceImplementation ems;
	
	private EntertainmentMediaDAO emd;
	
	
	@BeforeEach
	public void setupEMS() {
		this.emd = mock(EntertainmentMediaDAO.class);
		ems = new EntertainmentMediaServiceImplementation(this.emd);
	}
	
	@Test
	public void testSeeAllMedia() {
		List<EntertainmentMedia> testVals = new ArrayList<EntertainmentMedia>();
		EntertainmentMedia hotFuzz = new Movie(10.00, "HotFuzz", "Simon Pegg", "2007-01-01", 9, new int[] { 15, 55 });
		EntertainmentMedia hp3 = new Book(17.99, "Harry Potter and the Prisoner of Azkaban", "Penguin", "2003", 8,new int[] { 10, 25 }, 320, "J.K.Rowling");
		testVals.add(hotFuzz);
		testVals.add(hp3);
		when(emd.findAll()).thenReturn(testVals);
		//if someone calls emd.findAll() they will get the above array
		
		List<EntertainmentMedia> expectedValue = new ArrayList<>(testVals);
		
		assertEquals(expectedValue, ems.seeAllMedia());
		verify(emd).findAll();//make sure ems called the method
	}
	
}
