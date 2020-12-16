package com.revature.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.menus.EntertainmentMediaMenu;
import com.revature.menus.LoginMenu;
import com.revature.menus.MenuSelector;
import com.revature.models.User;
import com.revature.repositories.EntertainmentMediaDAO;
import com.revature.repositories.EntertainmentMediaMemoryDao;
import com.revature.repositories.EntertainmentMediaPostgresDao;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgresDao;
import com.revature.services.EntertainmentMediaService;
import com.revature.services.EntertainmentMediaServiceImplementation;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;


public class Entertainment720Launcher {

	public static Logger e720Logger = LogManager.getLogger("com.revature.e720");
	
	private static User currentUser;
	
	public static MenuSelector ms = new MenuSelector();
	
	public static User getCurrentUser() {
		return currentUser;
	}


	public static void setCurrentUser(User currentUser) {
		Entertainment720Launcher.currentUser = currentUser;
	}


	public static void main(String[] args) {
		
		e720Logger.info("Server has Started");
		
		
		while(true) {
		
			System.out.println(ms.display());
			ms.handleInput();
		}
		
		
	}
	
	
	
}
