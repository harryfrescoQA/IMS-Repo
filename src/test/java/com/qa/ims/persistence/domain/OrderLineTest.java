package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OrderLineTest {

	@Test
	public void constructorTest1() {
		OrderLine orderline = new OrderLine(1l, 1l, 1);
		assertTrue(orderline instanceof OrderLine);
	}
	
	@Test
	public void constructorTest2() {
		OrderLine orderline = new OrderLine(1l, 1l, 1l, 1);
		assertTrue(orderline instanceof OrderLine);
	}
	
	@Test
	public void getOrderLine_idTest() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		assertEquals(Long.valueOf(1l), orderline.getOrderline_id());
		
	}
	
	@Test
	public void setOrderLine_idTest() {
		OrderLine orderline = new OrderLine(2l, 2l, 1);
		orderline.setOrderline_id(1l);
		assertEquals(Long.valueOf(1l), orderline.getOrderline_id());
	}
	
	@Test
	public void getOrder_idTest() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		assertEquals(Long.valueOf(2l), orderline.getOrder_id());
	}
	
	@Test
	public void setOrder_idTest() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		orderline.setOrder_id(4l);
		assertEquals(Long.valueOf(4l), orderline.getOrder_id());
	}
	
	@Test
	public void getItem_idTest() {
		OrderLine orderline = new OrderLine(2l, 3l, 1);
		assertEquals(Long.valueOf(3l), orderline.getItem_id());
	}
	@Test
	public void setItem_idTest() {
		OrderLine orderline = new OrderLine(2l, 3l, 1);
		orderline.setItem_id(4l);
		assertEquals(Long.valueOf(4l), orderline.getItem_id());
	}
	
	@Test
	public void getQuantityTest() {
		OrderLine orderline = new OrderLine(2l, 3l, 1);
		assertEquals(1, orderline.getQuantity());
	}
	@Test
	public void setQuantityTest() {
		OrderLine orderline = new OrderLine(2l, 3l, 1);
		orderline.setQuantity(2);
		assertEquals(2, orderline.getQuantity());
	}
	
	@Test
	public void toStringTest() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		String out = "Item ID: " + 3l + "  Qty: " +1;
		assertEquals(out, orderline.toString());
	}
	
	@Test
	public void equalsTest() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l, 1);
		
		assertTrue(orderline.equals(orderline2));
	}
}
