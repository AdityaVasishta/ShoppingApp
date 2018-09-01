package com.aditya.ShoppingBackend3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.TestCase;

public class CalculatorTest2 extends TestCase {

	private Calculator calculator;
	//private static Calculator calculator;
	
	@Test
	@Ignore
  public void test() {
		fail("Not yet implemented");
	}

	@Before
	protected void setUp()  {
		// TODO Auto-generated method stub
		 calculator =new Calculator();
		//super.setUp();
	}

	/*	@Before
	protected void setUp1()  {
		// TODO Auto-generated method stub
		//super.setUp();
	}
*/
	@Test(expected=ArithmeticException.class,timeout=1000)
	public void testDivideFailre() {
		
		assertNotEquals("testDivideFailure():", 20, calculator.divide(20,0));
	}
	
	

}
