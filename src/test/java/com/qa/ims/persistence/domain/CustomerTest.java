package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void constructorTest1() {
		Customer cust = new Customer("Test", "Testy");
		assertTrue(cust instanceof Customer);
	}
	
	@Test
	public void constructorTest2() {
		Customer cust = new Customer(1l,"Test", "Testy");
		assertTrue(cust instanceof Customer);
	}
		
	@Test
	public void getIDTest() {
		Customer cust = new Customer(1l, "Test", "Testy");
		assertEquals(Long.valueOf(1l), cust.getId());
	}
	
	@Test
	public void setIDTest() {
		Customer cust = new Customer("Test", "Testy");
		cust.setId(1l);
		assertEquals(Long.valueOf(1l), cust.getId());
	}
	
	@Test
	public void getFirstNameTest() {
		Customer cust = new Customer("Test", "Testy");
		assertEquals("Test", cust.getFirstName());
	}
	
	@Test
	public void setFirstNameTest() {
		Customer cust = new Customer("Test", "Testy");
		cust.setFirstName("Testo");
		assertEquals("Testo", cust.getFirstName());
	}
	
	@Test
	public void getSurnameTest() {
		Customer cust = new Customer("Test", "Testy");
		assertEquals("Testy", cust.getSurname());
	}
	
	@Test
	public void setSurnameTest() {
		Customer cust = new Customer("Test", "Testy");
		cust.setSurname("Testo");
		assertEquals("Testo", cust.getSurname());
	}
	
	@Test
	public void toStringTest() {
		Customer cust = new Customer(1l, "Test", "Testy");
		String output = cust.toString();
		String expected = "\n\n " + 1 + "\t " + "Test" + "\t \t " + "Testy";
		assertEquals(expected, output);
		}
	
	@Test
	public void equalsTest() {
		Customer cust = new Customer(1l, "Test", "Testy");
		Customer cust2 = new Customer(1l, "Test", "Testy");
		
		assertEquals(true, cust.equals(cust2));
		
	}

	
}
