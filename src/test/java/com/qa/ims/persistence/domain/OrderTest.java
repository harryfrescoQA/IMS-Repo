package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {

	@Test
	public void constructorTest1() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 1l, date, 5.00,orderLineList);
	
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void constructorTest2() {
		Date date = Date.valueOf("2020-11-18");
		Order order = new Order(1l, date);
	
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void constructorTest3() {
		Order order = new Order( 1l, 5.00);
	
		assertTrue(order instanceof Order);
	}
	
	@Test
	public void getOrderIDTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 1l, date, 5.00,orderLineList);
	
		assertEquals(Long.valueOf(1l), order.getOrder_id());
	}
	
	@Test
	public void setOrderIDTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 1l, date, 5.00,orderLineList);
	
		order.setOrder_id(2l);
		assertEquals(Long.valueOf(2l), order.getOrder_id());
	}
	@Test
	public void getCustomerIDTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
	
		assertEquals(Long.valueOf(2l), order.getCustomer_id());
	}
	
	@Test
	public void setCustomerIDTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
	
		order.setCustomer_id(3l);
		assertEquals(Long.valueOf(3l), order.getCustomer_id());
	}
	
	@Test
	public void getOrderDateTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
	
		assertEquals(date, order.getOrder_date());
	}
	
	@Test
	public void setOrderDateTest() {
		Date date = Date.valueOf("2020-11-18");
		Order order = new Order(1l, 5.00);
	
		order.setOrder_date(date);
		assertEquals(date, order.getOrder_date());
	}
	
	@Test
	public void getTotal_costTest() {
		Order order = new Order(1l, 5.00);
		assertEquals(Double.valueOf(5.00), Double.valueOf(order.getTotal_cost()));
	}
	
	@Test
	public void setTotal_costTest() {
		Order order = new Order(1l, 5.00);
		order.setTotal_cost(6.00);
		assertEquals(Double.valueOf(6.00), Double.valueOf(order.getTotal_cost()));
	}
	
	@Test
	public void getOrderLineList() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = null;
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
	
		assertEquals(orderLineList, order.getOrderLineList());
	}
	
	@Test
	public void setOrderLineList() {
		Order order = new Order(1l, 5.00);
		List<OrderLine> orderLineList = null;
		order.setOrderLineList(orderLineList);
		
		assertEquals(orderLineList, order.getOrderLineList());
	}
	
	@Test
	public void toStringTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
	
		String output = order.toString();
		String expected = "Order ID:" + 1l + " Customer ID: " + 2l + " Date: " + date + " Total Cost: "+ 5.00;
		expected += "\n\t Items: " + "\n";
		expected += "\t---------------\n";

			expected += "\t" + orderLineList.get(0).toString()+ "\n";
			
		assertEquals(expected, output);
		}
	
	@Test
	public void equalsTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderLineList = new ArrayList<>();
		orderLineList.add(new OrderLine(1l, 1l, 1));
		Order order = new Order(1l, 2l, date, 5.00,orderLineList);
		Order order2 = new Order(1l, 2l, date, 5.00,orderLineList);

		assertTrue(order.equals(order2));
	}
}
