package com.bway.springproject;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.BeforeClass;

import com.testing.calculation;

public class CalculationTest {

	static calculation c ;
	
	@BeforeClass
	public static void init(){
		
		c = new calculation();
		System.out.println("===============init method loaded=============");
	}
	
	
	@Test
	public void squareTest(){
		
		
		int res= c.square(5);
		assertEquals(res, 25);
	}

	@Test
	public void testSIvalue(){
		
		int res = c.SI(5000, 5, 5);
		assertEquals(res, 1250);
		
		
	}
	
	
}
