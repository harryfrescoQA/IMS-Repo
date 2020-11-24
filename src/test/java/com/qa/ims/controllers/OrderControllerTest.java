package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock
	private Utils utils;

	@Mock
	private OrderDAO dao;


	@InjectMocks
	private OrderController controller;
	
	// Orderid, customer id, order date, total cost, orderlinelist
	@Test
	public void testReadAll() {
		List<Order> orders = new ArrayList<>();
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		orderlines.add(new OrderLine(1l, 1l, 1l, 1));
		Order order = new Order(1L, 1l, date, 700.00, orderlines);
		orders.add(order);

		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	

//	@Test
//	public void testCreate() {
//		final long customer_id = 1l;
//		java.sql.Date order_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//
//		
//		List<OrderLine> orderlines = new ArrayList<>();
//		orderlines.add(new OrderLine(1l, 1l, 1l, 1));
//		final Order created = new Order( customer_id, order_date);
//		
//		Mockito.when(utils.getLong()).thenReturn(customer_id);
//		Mockito.when(dao.create(created)).thenReturn(created);
//		//Mockito.when(dao.readOrder(1l)).thenReturn(created);
//		//Mockito.when(controller.addToOrder(1l)).thenReturn(created);
//		
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
}
