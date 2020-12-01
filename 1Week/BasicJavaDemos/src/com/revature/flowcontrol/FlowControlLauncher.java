package com.revature.flowcontrol;

public class FlowControlLauncher {
	
	public static void main(String[] args) {
		int x = 1;
		//the most basic of flow control is the if statement
		if( x > 0) {//if takes () inside we write an expression that turns into a boolean
			System.out.println("x = 2");
		}
		
		//an if statement has optional else block at the end of it
		//the else block executes if no if statements above execute
		//an if statement also has an infinite number of optional else if statements
		//see below
		if(x == 1) {
			System.out.println("only if x == 1");
		} else if (x == 2) {
			System.out.println("only if x != 1 and x == 2");
		} else if (x == 3) {
			System.out.println("only if x != 1 and x != 2 and x ==3");
		} else {
			System.out.println("only if x != 1 and x != 2 and x !=3");
		}
		
		
		//pretty common if else if else
		if( x > 0) {
		
		} else if (x < 0) {
		
		} else {
			
		}
		
		//in the switch put the variable
		//we can use numbers
		//characters or strings
		x = 2;
		switch (x) {
			case 1: {
				System.out.println("x = 1");
				break; // allows us to break out of a flow control block
				//loop, or switch or an if/else
			}
			case 2:{
				System.out.println("x = 2");
				break;
			}
			case 3: {
				System.out.println("x = 3");
				break;
			}
			case 4:{
				System.out.println("x = 4");
				break;
			}
			default: {
				System.out.println("x = ?");
				break;
			}	
		}
		
		//the powerful for loop
		//has three pieces
		//an optional phase for declaring/initializing vars
		//an optional phase boolean expression for when the loop should stop
		//an optional phase for what to after each execution of the loop
		for(int i = 0; i < 10; ++i) {
			System.out.println("i is now: " + i);
		}
		
		//when evaluating an expression the location of you ++ matters
		int y = 0;
		y++;
		System.out.println("y++ = " + y );
		y= 0;
		System.out.println("++y = " + ++y);
	
		
		
		
		//enhanced for loop
		//we use this with arrays and collections
		//less powerful but easier to use
		
		//executes until its condition is false
		//if the condition starts false it doesn't execute
		while(y < 10) {
			System.out.println("While ");
			y++;
		}
		
		//will always execute once, then it check the while condition to see if it continues
		do {
			
		}while(false);
		
		while(true) {
			System.out.println("ifinite loop");
			break;//frees us from the loop
		}
		
		for(int i = 0; i < 10; i++) {
			if(i%2 == 0) {//if i is even number
				continue;//stop executing the loop and go back to the top
				//do the next iteration of the loop
			}
			//goto is reserved but does nothing in the language
			System.out.println("I is now: " + i);
		}
		
		//the ternary is special short hand for if else statement 
		//boolean expression ? what to do if true : what to do if false
		String s = (y > 0) ?  "True" : "False";//you will rarely see me use a ternary in java
		System.out.println(s);
		
	}

}
