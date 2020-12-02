package com.revature.abstraction;

public class Menu implements Displayable{
	
	Displayable [] lines;
	
	public Menu(Displayable [] lines ) {
		this.lines = lines;
	}

	@Override
	public String display() {
		String display = "TOP MENU\n";
		for(int i = 0; i < lines.length; i++) {
			display += lines[i].display();
		}
		display += "BOTTOM MENU\n";
		return display;
	}
	
	
}
