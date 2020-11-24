package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertFalse;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTestFail {

	@Test
	public void equalsOrder_idTestFail() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(2l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	@Test
	public void equalsOrder_idTestFailNull() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(null, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equalsCustomer_idTestFail() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 3l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	@Test
	public void equalsCustomer_idTestFailNull() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, null, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equalsOrder_dateTestFail() {
		Date date = Date.valueOf("2020-11-18");
		Date date2 = Date.valueOf("2020-11-19");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date2, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	@Test
	public void equalsOrder_dateTestFailNull() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, null, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equalsTotal_costTestFail() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 6.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	@Test
	public void equalsTotal_costTestFailNull() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 0,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
	
	@Test
	public void equalsOrderLineListTestFail() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		
		List<OrderLine> orderLineList2 = new ArrayList<>();
		orderLineList2.add(new OrderLine(2l, 2l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList2);

		assertFalse(order.equals(order2));
	}
	@Test
	public void equalsOrderLineListTestFailNull() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));

		Order order = new Order(1l, 2l, date, 5.00,null);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertFalse(order.equals(order2));
	}
}
