package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;


import org.junit.Test;

public class OrderLineTestFail {
	@Test
	public void equalsOrderline_idTestFail() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(2l, 2l, 3l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	@Test
	public void equalsOrderline_idTestFailNull() {
		OrderLine orderline = new OrderLine(null, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	
	@Test
	public void equalsOrder_idTestFail() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 1l, 3l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	@Test
	public void equalsOrder_idTestFailNull() {
		OrderLine orderline = new OrderLine(1l, null, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	
	@Test
	public void equalsItem_idTestFail() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 4l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	@Test
	public void equalsItem_idTestFailNull() {
		OrderLine orderline = new OrderLine(1l, 2l, null, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l, 1);
		
		assertFalse(orderline.equals(orderline2));
	}
	
	@Test
	public void equalsQuantityTestFail() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 1);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l,2);
		
		assertFalse(orderline.equals(orderline2));
	}
	@Test
	public void equalsQuantityTestFailNull() {
		OrderLine orderline = new OrderLine(1l, 2l, 3l, 0);
		OrderLine orderline2 = new OrderLine(1l, 2l, 3l,1);
		
		assertFalse(orderline.equals(orderline2));
	}
}
