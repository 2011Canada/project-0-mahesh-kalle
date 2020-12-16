package com.revature.bank.menus;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.bank.launcher.BankAppLauncher;
import com.revature.bank.models.User;
import com.revature.bank.repositories.UserDaoImpl;
import com.revature.bank.service.UserService;


public class DisplayMenu implements UserService{
	
	private static Scanner sc = new Scanner(System.in);
	private static User u = null;
	final static UserDaoImpl dao = UserDaoImpl.getInstance();
	static AccountMenu actMenu = new AccountMenu();

	public void displayMenu()  {
		
		 loop: while (true) {
				 	System.out.println("--------------------------");
					System.out.println("WELCOME TO REVATURE BANK");
					System.out.println("--------------------------");
					System.out.println("Please select below options to proceed:");
					System.out.println("1 to Log in");
					System.out.println("2 to Register Customer Account");
					System.out.println("3 to Register Admin account");
					System.out.println("0 to Exit");
					System.out.println("Enter option: ");
					while (!sc.hasNextInt()) {
					      System.out.println("Input is not a number. Please enter a valid number");
					      sc.nextLine();
					      continue;
					}
					int option = sc.nextInt();
					if(option < 0) {
						System.out.println("Please enter the above numbers only.");
					}
					sc.nextLine();
					BankAppLauncher.logger.info("You Selected: " + option);

					switch (option) {
					case 1:
						try {
							LoginMenu.login();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						LoginMenu.createCustomer();
						break;
					case 3:
						LoginMenu.createAdmin();
						break;
					case 0:
						break loop;
					}

					if (u != null) {
						LoginMenu.loggedIn(u);
					}
				}

				sc.close();
			}

}

