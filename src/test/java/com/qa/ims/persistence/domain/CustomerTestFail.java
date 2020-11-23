package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTestFail {
	@Test
	public void equalsTestFailFirstName() {
		Customer cust = new Customer(1l, "Test", "Testy");
		Customer cust2 = new Customer(1l, "Testo", "Testy");
		
		assertEquals(false, cust.equals(cust2));
	}
	@Test
	public void equalsTestFailFirstNameNull() {
		Customer cust = new Customer(1l, null, "Testy");
		Customer cust2 = new Customer(1l, "Testo", "Testy");
		
		assertEquals(false, cust.equals(cust2));
	}
	@Test
	public void equalsTestFailID() {
		Customer cust = new Customer(1l, "Test", "Testy");
		Customer cust2 = new Customer(2l, "Test", "Testy");
		
		assertEquals(false, cust.equals(cust2));
	}
	@Test
	public void equalsTestFailIDNull() {
		Customer cust = new Customer(null, "Test", "Testy");
		Customer cust2 = new Customer(2l, "Test", "Testy");
		
		assertEquals(false, cust.equals(cust2));
	}
	@Test
	public void equalsTestFailSurname() {
		Customer cust = new Customer(1l, "Test", "Testy");
		Customer cust2 = new Customer(1l, "Test", "Testay");
		
		assertEquals(false, cust.equals(cust2));
	}
	@Test
	public void equalsTestFailSurnameNull() {
		Customer cust = new Customer(1l, "Test", null);
		Customer cust2 = new Customer(1l, "Test", "Testay");
		
		assertEquals(false, cust.equals(cust2));
	}
}
