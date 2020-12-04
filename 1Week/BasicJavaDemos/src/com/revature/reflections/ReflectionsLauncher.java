package com.revature.reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.revature.abstraction.EntertainmentMedia;

public class ReflectionsLauncher {

	public static void main(String[] args) {
		Class em = EntertainmentMedia.class;
		
		for(Constructor c : em.getConstructors()) {
			System.out.println(c);
			try {
				Object o = c.newInstance();
				System.out.println(o);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
			
		
	}
	
	
	
	
}
