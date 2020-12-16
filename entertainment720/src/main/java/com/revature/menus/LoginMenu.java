package com.revature.menus;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.launcher.Entertainment720Launcher;
import com.revature.models.Displayable;
import com.revature.services.UserService;

public class LoginMenu implements Menu{
	
	private UserService us;
	
	List<Displayable> lines;
	
	Scanner userIn;
	
	public LoginMenu(UserService us) {
		this.us = us;
		this.lines = new ArrayList<Displayable>();
		lines.add(()->"Welcome to Entertainment720");
		lines.add(()->"Where we go around the world twice for our customers");
		this.userIn = new Scanner(System.in);
	}

	@Override
	public String display() {
		String display = "";
		for(int i =0; i<lines.size(); i++) {
			display += lines.get(i).display() + "\n"; 
		}
		display += "Press Enter to Login";
		return display;
	}
	
	public void manageUserInput() {
		String dummy = this.userIn.nextLine();
		System.out.println("Please Enter your Username");
		String username = this.userIn.nextLine();
		System.out.println("Please Enter your Password");
		String password = this.userIn.nextLine();
		System.out.println(this.us.login(username, password).display());
		if(Entertainment720Launcher.getCurrentUser() != null) {
			Entertainment720Launcher.ms.moveToSubMenu(0);
		}
		
	}

}
