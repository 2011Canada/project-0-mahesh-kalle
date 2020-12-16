package com.revature.menus;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Displayable;
import com.revature.repositories.EntertainmentMediaDAO;
import com.revature.repositories.EntertainmentMediaPostgresDao;
import com.revature.repositories.UserDao;
import com.revature.repositories.UserPostgresDao;
import com.revature.services.EntertainmentMediaService;
import com.revature.services.EntertainmentMediaServiceImplementation;
import com.revature.services.UserService;
import com.revature.services.UserServiceImplementation;

public class MenuSelector implements Displayable{

	private MenuNode currentMenu;
	
	public MenuSelector() {
		EntertainmentMediaDAO emd = new EntertainmentMediaPostgresDao();
		EntertainmentMediaService ems = new EntertainmentMediaServiceImplementation(emd);
		EntertainmentMediaMenu emm = new EntertainmentMediaMenu(ems);
		
		UserDao ud = new UserPostgresDao();
		UserService us = new UserServiceImplementation(ud);
		LoginMenu lm = new LoginMenu(us);
		
		MenuNode login = new MenuNode(lm);
		MenuNode entertainmentMediaMenu = new MenuNode(emm);
		entertainmentMediaMenu.parentMenu = login;
		login.childrenMenus.add(entertainmentMediaMenu);
		this.currentMenu = login;
	}
	
	
		static class MenuNode {
		
		private Menu menu;
		
		private MenuNode parentMenu;
		
		private List<MenuNode> childrenMenus = new ArrayList<>();
		
		public MenuNode returnToParent() {
			return parentMenu;
		}
		
		public MenuNode goToChild(int index) {
			return childrenMenus.get(index);
		}
		
		public MenuNode( Menu menu)  {
			this.menu = menu;
		}
		
		
	}


	@Override
	public String display() {
		// TODO Auto-generated method stub
		return currentMenu.menu.display();
	}
	
	
	public void handleInput() {
		currentMenu.menu.manageUserInput();
	}
	
	public void moveToSubMenu(int index) {
		this.currentMenu = currentMenu.goToChild(index);
	}
	
	public void returnToPrevious() {
		this.currentMenu = currentMenu.returnToParent();
	}
	
}
