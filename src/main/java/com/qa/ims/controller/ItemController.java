package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item>  {

	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all items to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter an item title");
		String item_title = utils.getString();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter a price");
		double price = utils.getDouble();
		// Creates item object and use DAO to create
		Item item = itemDAO.create(new Item(item_title, quantity, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Updates an existing item by taking in user input
	 */
	
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter an item title");
		String item_title = utils.getString();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter a price");
		double price = utils.getDouble();
		// Create item object and use DAO to update
		Item item = itemDAO.update(new Item(id, item_title, quantity, price));
		LOGGER.info("Item created");
		return item;
	}

	/**
	 * Deletes an existing item by the item_id
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		// Uses dao to delete item from system
		return itemDAO.delete(id);
	}

}
