package com.aditya.ShoppingBackend3;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

   Calculator calculator;
	/*@Test
	public void test() {
		fail("Not yet implemented");
		
	}*/

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
		calculator = new Calculator(); 
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
		calculator=null;
	}
	
	public void testaddPass()
	{
	Assert.assertEquals(calculator.add(10,2),30);
	}

}
