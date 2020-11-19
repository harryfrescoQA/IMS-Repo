package com.qa.ims.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderLineDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private OrderLineDAO orderLineDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		this.orderLineDAO = new OrderLineDAO();
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
		
		java.sql.Date order_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());



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
		int quantity = 0;
		ItemDAO itemDAO = new ItemDAO();
		Order order = null;
		OrderLine orderLine = null;
		do {
			LOGGER.info("Please enter an item id, 0 to exit");
			item_id = utils.getLong();
			if(item_id ==0) {
				break;
			}
			LOGGER.info("Please enter a quantity");
			quantity = utils.getInt();
			
			if(itemDAO.readItemID(item_id) != null) {
				price = itemDAO.readItemID(item_id).getPrice();
				total_cost += price * quantity;
			}
			order = new Order(id, total_cost);
			 orderLine = orderLineDAO.create(new OrderLine(order.getOrder_id(), item_id, quantity));
		}
		while(item_id!=0);
		//Long order_id, Long customer_id, Date order_date, double total_cost
		//OrderLineDAO orderLineDAO = new OrderLineDAO();

		orderLine.toString();
		orderDAO.update(order);
		
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
