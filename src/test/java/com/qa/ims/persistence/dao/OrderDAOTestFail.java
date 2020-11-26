package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTestFail {
	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "fail");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	//order_id, customer_id, Date order_date, total_cost, 
	// List<OrderLine> orderLineList
	@Test
	public void readAllTest() {
		List<Order> expected = new ArrayList<>();

		assertEquals(expected, DAO.readAll());
	}
	 
	@Test
	public void readLatestTest() {
		assertEquals(null, DAO.readLatest());
	}
	
	@Test
	public void createTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		Order expected = new Order(2l, 1l, date, 700.00, orderlines);
	
		assertEquals(null, DAO.create(expected));
	}
	
	@Test
	public void readOrderTest() {
		assertEquals(null, DAO.readOrder(1l));
	}
	
	@Test
	public void updateTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		Order expected = new Order(1l, 1l, date, 800.00, orderlines);
	
		assertEquals(null, DAO.update(expected));
	}
	
	@Test
	public void deleteTest() {
		assertEquals(0, DAO.delete(2l));
	}
}
