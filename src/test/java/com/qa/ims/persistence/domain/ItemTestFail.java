package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTestFail {

	@Test
	public void equalsTitleTestFail() {
		Item item = new Item(1l, "Title", 1, 5.00);
		Item item2 = new Item(1l, "Title 2", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}
	
	@Test
	public void equalsTitleTestFailNull() {
		Item item = new Item(1l, null, 1, 5.00);
		Item item2 = new Item(1l, "Title", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}
	
	
	@Test
	public void equalsIDTestFail() {
		Item item = new Item(1l, "Title", 1, 5.00);
		Item item2 = new Item(2l, "Title", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}
	
	@Test
	public void equalsIDTestFailNull() {
		Item item = new Item(null, "Title", 1, 5.00);
		Item item2 = new Item(1l, "Title", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}
	
	
	@Test
	public void equalsQtyTestFail() {
		Item item = new Item(1l, "Title", 1, 5.00);
		Item item2 = new Item(1l, "Title", 2, 5.00);
		
		assertEquals(false, item.equals(item2));
	}
	@Test
	public void equalsQtyTestFailNull() {
		Item item = new Item(1l, "Title", 0, 5.00);
		Item item2 = new Item(1l, "Title", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}

	@Test
	public void equalsPriceTestFail() {
		Item item = new Item(1l, "Title", 1, 5.00);
		Item item2 = new Item(1l, "Title", 1, 6.00);
		
		assertEquals(false, item.equals(item2));
	}

	@Test
	public void equalsPriceTestFailNull() {
		Item item = new Item(1l, "Title", 1, 0);
		Item item2 = new Item(1l, "Title", 1, 5.00);
		
		assertEquals(false, item.equals(item2));
	}

	
	
	
	
	
}
