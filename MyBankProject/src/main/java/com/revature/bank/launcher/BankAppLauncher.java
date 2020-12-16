package com.revature.bank.launcher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bank.menus.DisplayMenu;


public class BankAppLauncher {

	public static Logger logger = LogManager.getLogger("com.revature.bank");
		
	public static void main(String args[]) {
		
		logger.info("Server has Started..");

		DisplayMenu dispMenu = new DisplayMenu();
	
		dispMenu.displayMenu();
	}
}
