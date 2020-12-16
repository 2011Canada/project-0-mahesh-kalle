package com.revature.menus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.models.Displayable;
import com.revature.models.EntertainmentMedia;
import com.revature.services.EntertainmentMediaService;


//this menu lists all of the media options
//users can choose an option to purchase
public class EntertainmentMediaMenu implements Menu{
	
	EntertainmentMediaService ems;
	
	List<Displayable> lines;
	
	Scanner userIn;
	
	public EntertainmentMediaMenu(EntertainmentMediaService ems ) {
		this.ems = ems;
		lines = new ArrayList<Displayable>(this.ems.seeAllMedia());
		userIn = new Scanner(System.in);
	}

	
	public String display() {
		String display = "";
		for(int i =0; i<lines.size(); i++) {
			display += (i+1) + ": " + lines.get(i).display() + "\n"; 
		}
		display += "Choose a number to purchase";
		return display;
	}
	
	public void manageUserInput() {
		String input = this.userIn.nextLine();//read in the entire line of text
		//this should be a number, but not necessarily
		try {
			int choice = Integer.parseInt(input) - 1;//for readability
			if(choice < 0 || choice>= lines.size()) {
				System.out.println("Make a valid choice please");
				return;
			}
			ems.purchaseMedia((EntertainmentMedia)lines.get(choice));
		} catch(NumberFormatException e) {
			System.out.println("Make A valid choice please");
		}
		

	}
	

}
