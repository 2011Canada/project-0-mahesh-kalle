package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.EntertainmentMediaMenu;
import com.revature.repositories.EntertainmentMediaDAO;
import com.revature.repositories.EntertainmentMediaMemoryDao;
import com.revature.services.EntertainmentMediaService;
import com.revature.services.EntertainmentMediaServiceImplementation;

public class Entertainment720Launcher {

	public static Logger e720Logger = LogManager.getLogger("com.revature.e720");
	
	public static void main(String[] args) {
		EntertainmentMediaDAO emd = new EntertainmentMediaMemoryDao();
		EntertainmentMediaService ems = new EntertainmentMediaServiceImplementation(emd);
		EntertainmentMediaMenu emm = new EntertainmentMediaMenu(ems);
		
		e720Logger.info("Server has Started");
		
		while(true) {
			//the server is running
			
			//System.out.println("hello");
			
			System.out.println(emm.display());
			emm.manageUserInput();
		}
		
		
	}
	
	
	
}
