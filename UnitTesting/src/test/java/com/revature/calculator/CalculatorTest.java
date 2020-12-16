package com.revature.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	
	private Calculator calc;
	
	@BeforeEach//run before each test
	public void setupCalc() {
		this.calc = new Calculator();//we setup a new calc before each test
	}
	
	
	@Test
	public void testAddWithPositives() {
		assertEquals(4, calc.add(2, 2));//test the calc
		assertEquals(10, calc.add(6,4));
		assertEquals(100, calc.add(20, 80));
	}
	
	@Test
	public void testAddWithPositiveAndNegative() {
		assertEquals(0, calc.add(5, -5));
	}
	
	@Test
	public void testAddWithNegativeAndNegative() {
		assertEquals(-10, calc.add(-2, -8));
	}
	
	
	@Test
	public void testDivWithDivideByZero() {
		assertThrows(ArithmeticException.class, ()->{
			calc.div(1,0);
		});
	}

}
