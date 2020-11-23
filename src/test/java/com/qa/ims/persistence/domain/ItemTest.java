package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ItemTest {

	@Test
	public void constructorTest1() {
		Item item = new Item("Title", 1, 5.00);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void constructorTest2() {
		Item item = new Item(1l, "Title", 1, 5.00);
		assertTrue(item instanceof Item);
	}
	
	@Test
	public void getItemIdTest() {
		Item item = new Item(1l, "Title", 1, 5.00);
		assertEquals(Long.valueOf(1l), item.getItem_id());
	}
	
	@Test
	public void setIDTest() {
		Item item = new Item("Title", 1, 5.00);
		item.setItem_id(1l);
		assertEquals(Long.valueOf(1l), item.getItem_id());
	}
	
	@Test
	public void getItemTitleTest() {
		Item item = new Item(1l, "Title", 1, 5.00);
		assertEquals("Title", item.getItem_title());
	}
	
	@Test
	public void setItemTitleTest() {
		Item item = new Item("Title", 1, 5.00);
		item.setItem_title("Test Title");
		assertEquals("Test Title", item.getItem_title());
	}
	
	
}
