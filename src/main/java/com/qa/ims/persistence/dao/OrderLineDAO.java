package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.DBUtils;

public class OrderLineDAO implements Dao<OrderLine>{
	public static final Logger LOGGER = LogManager.getLogger();
	
	// Returns all orderlines in the db
	// Not used
	@Override
	public List<OrderLine> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				//SELECT *  FROM orders JOIN orderline ON orders.order_id = orderline.order_id;
				ResultSet resultSet = statement.executeQuery("SELECT *  FROM orderline");) {
			List<OrderLine> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(modelFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	// Returns the latest orderline in db
	public OrderLine readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline ORDER BY orderline_id DESC LIMIT 1");) {
			while(resultSet.next()) {
			return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Creates an order line
	@Override
	public OrderLine create(OrderLine t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			//INSERT INTO `ims`.`items` (`item_title`, `quantity`, `price`) VALUES ('Fender Stratocaster - White', '100', '699.99');
			statement.executeUpdate("INSERT INTO orderline(order_id, item_id, quantity_ordered) values('" + t.getOrder_id()
					+ "','" + t.getItem_id() + "','" +t.getQuantity()+ "')");
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Returns ONE orderline by its id
//	public OrderLine readOrderLine(Long id) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();
//				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where orderline_id = " + id);) {
//			resultSet.next();
//			return modelFromResultSet(resultSet);
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
//		return null;
//	}
	
	// Returns ONE orderline by it's item_id AND order_id
	// Used for when orderline_id cannot be known
	public OrderLine readOrderLineByOrder(Long item_id, Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderline where order_id = " + order_id + 
						" AND item_id = "+ item_id);) {
			while(resultSet.next()) {
			return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	// Updates OrderLine
	// Not used
	@Override
	public OrderLine update(OrderLine t) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				Statement statement = connection.createStatement();) {
//			statement.executeUpdate("update orderline set order_id ='" + t.getOrder_id()+"', item_id = '" + t.getItem_id() + "', quantity_ordered = '" +
//				 t.getQuantity() + "' where orderline_id = " + t.getOrderline_id());
//			return null;
//			//return readOrderLine(t.getOrderline_id());
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//		}
		return null;
	}

	// Deletes orderLine
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
			return statement.executeUpdate("delete from orderline where orderline_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public OrderLine modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("orderline_id");
		Long order_id = resultSet.getLong("order_id");
		Long item_id = resultSet.getLong("item_id");
		int quantity = resultSet.getInt("quantity_ordered");

		OrderLine test = new OrderLine(id, order_id, item_id, quantity);
		//System.out.println("Found " + test.getOrder_id());
		return test;
	}
	
	// Returns List of orderlines in one order
	public List<OrderLine> readAllID(Long id) {

		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				
				//SELECT *  FROM orders JOIN orderline ON orders.order_id = orderline.order_id;
				ResultSet resultSet = statement.executeQuery("select * from orderline where order_id = " + id);) {
			List<OrderLine> orderlines = new ArrayList<>();
			while (resultSet.next()) {
				orderlines.add(modelFromResultSet(resultSet));
			}
			return orderlines;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

}
