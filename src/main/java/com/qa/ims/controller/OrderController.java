package com.qa.ims.controller;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long customer_id = utils.getLong();

		Date order_date = (Date) new java.util.Date();

		Order order = orderDAO.create(new Order(customer_id, order_date));
		
		LOGGER.info("Item created");
		return order;
	}

	@Override
	public Order update() {
		
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = utils.getLong();
		
		

		
		Long item_id;
		double price = 0;
		double total_cost = 0;
		do {
			LOGGER.info("Please enter an item id");
			item_id = utils.getLong();
			
			LOGGER.info("Please enter a quantity");
			int quantity = utils.getInt();
			
			LOGGER.info("Please enter a price for the item");
			price = utils.getDouble();
			total_cost += price * quantity;
		}
		while(item_id!=0);
		//Long order_id, Long customer_id, Date order_date, double total_cost
		Order order = orderDAO.update(new Order(id, total_cost));
		LOGGER.info("Order created");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
