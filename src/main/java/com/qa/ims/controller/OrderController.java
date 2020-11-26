package com.qa.ims.controller;

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
	
	// Attributes
	private OrderDAO orderDAO;
	// Requires an OrderLineDAO to control the orderline table at the same time
	private OrderLineDAO orderLineDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
		this.orderLineDAO = new OrderLineDAO();
	}

	// Read all orders by using the toString method
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
 
	// Create an empty order for a customer
	@Override
	public Order create() {
		LOGGER.info("Please enter a customer ID");
		Long customer_id = utils.getLong();
		
		// Creates an sql DATE for the current date
		java.sql.Date order_date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		// Uses OrderDAO to create an empty order with customer ID and the date
		Order order = orderDAO.create(new Order(customer_id, order_date));
		
		// Calls the 'addToOrder' method with the recently created ID to add items to empty order
		addToOrder(orderDAO.readOrder(order.getOrder_id()).getOrder_id());
		LOGGER.info("Item created");
		return order;
	} 
 
	// Updates an order by asking for items to add or delete
	@Override
	public Order update() {
		
		LOGGER.info("Do you want to ADD an item or DELETE?");
		LOGGER.info("\t or RETURN");
		// Ask the user if they want to add or delete items from order
		String choice = utils.getString().toLowerCase();
		
		Order returnedOrder = null;

			switch(choice) {
			case "add":
				// If 'add' they enter the ID of the order to edit
				LOGGER.info("Please enter the id of the order you would like to update");
				Long id = utils.getLong();
				// Call addToOrder function with an ID as used in create
				returnedOrder = addToOrder(id);
				break;
			case "delete":
				// If 'delete' the deleteFromOrder function is called.
				returnedOrder = deleteFromOrder();
				LOGGER.info("Order deleted");
				break;
			case "return":
				break;
			default:
				LOGGER.info("Not an input. Try again");
				break;
			}
		return returnedOrder;
	}
	public Order addToOrder(Long id) {

		Long item_id;
		double price = 0;
		double total_cost = 0;
		int quantity = 0;
		// Uses itemDAO to get the item objects to put in the orderline
			ItemDAO itemDAO = new ItemDAO();
		// get the current order details
			Order order = orderDAO.readOrder(id);
			total_cost = order.getTotal_cost();
			
		// Do-while loop to allow user to enter multiple items. 
		// If 0 is entered the loop breaks.
		do {
			LOGGER.info("Please enter an item id, 0 to exit");
			item_id = utils.getLong();
			if(item_id ==0) {
				break;
			}
			LOGGER.info("Please enter a quantity");
			quantity = utils.getInt();
			
			// If there is an item with the above ID, get it's price
			if(itemDAO.readItem(item_id) != null) {
				
				
				Item itemUpdateQty = itemDAO.readItem(item_id);
				int currentQty = itemUpdateQty.getQuantity();
				
				if(quantity <= currentQty) {
					price = itemDAO.readItem(item_id).getPrice();
					// Get the total cost
					
					total_cost += price * quantity;
					
					itemUpdateQty.setQuantity(currentQty - quantity);
					itemDAO.update(itemUpdateQty);
				}
				else {
					LOGGER.info("Not enough in stock");
					break;
				}
			}
			// Create an order with the ID and total cost
			order = new Order(id, total_cost);
			// Create an orderline record with the item
			 orderLineDAO.create(new OrderLine(order.getOrder_id(), item_id, quantity));
		}
		// Repeat until 0 is entered
		while(item_id!=0);

		// Update the order
		orderDAO.update(order);
		
		LOGGER.info("Order created");
		return order;
	}
	
	public Order deleteFromOrder() {
		LOGGER.info("Please enter the id of the order you would like to edit: ");
		Long id = utils.getLong();

		Long item_id;
		Item item = null;
		double total_cost = 0;
		// Uses itemDAO to get the item objects to remove from orderline
			ItemDAO itemDAO = new ItemDAO();
		// get the current order details such as total cost.
			Order order = orderDAO.readOrder(id);
			total_cost = order.getTotal_cost();
			
			OrderLine orderLine = null;
			
		// Do-while loop to allow user to enter multiple items. 
		// If 0 is entered the loop breaks.
		do {
			LOGGER.info("Please enter an item id, 0 to exit");
			item_id = utils.getLong();
			if(item_id ==0) {
				break;
			}

			 
			// If there is an item with the above ID, get it's price
			if(itemDAO.readItem(item_id) != null) {
				// Get the total cost
				
				total_cost -= order.getTotal_cost();
				
				item = itemDAO.readItem(item_id);

				orderLine = orderLineDAO.readOrderLineByOrder(item.getItem_id(), id);
				orderLineDAO.delete(orderLine.getOrderline_id());
			}
			else {
				LOGGER.info("Item doesn't exist");
			}
			// Create an order with the ID and total cost
			order = new Order(id, total_cost);
			// Create an orderline record with the item
		}
		// Repeat until 0 is entered
		while(item_id!=0);
		
		// Update the order
		orderDAO.update(order);
		
		LOGGER.info("Order updated");
		return order;
	}
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		return orderDAO.delete(id);
	}

}
