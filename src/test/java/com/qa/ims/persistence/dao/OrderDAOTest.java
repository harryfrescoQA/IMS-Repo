package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.utils.DBUtils;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderLine;
public class OrderDAOTest {
	private final OrderDAO DAO = new OrderDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
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
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		orderlines.add(new OrderLine(1l, 1l, 1l, 1));
		expected.add(new Order(1l, 1l, date, 700.00, orderlines));
		System.out.println(expected);
		System.out.println(DAO.readAll());
		assertEquals(expected, DAO.readAll());
	}
	 
	@Test
	public void readLatestTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		assertEquals(new Order(1l, 1l, date, 700.00, orderlines), DAO.readLatest());
	}
	
	@Test
	public void createTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		Order expected = new Order(2l, 1l, date, 700.00, orderlines);
	
		assertEquals(expected, DAO.create(expected));
	}
	
	@Test
	public void readOrderTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		Order expected = new Order(1l, 1l, date, 700.00, orderlines);
	
		assertEquals(expected, DAO.readOrder(1l));
	}
	
	@Test
	public void updateTest() {
		Date date = Date.valueOf("2020-11-18");
		List<OrderLine> orderlines = new ArrayList<>();
		Order expected = new Order(1l, 1l, date, 800.00, orderlines);
	
		assertEquals(expected, DAO.update(expected));
	}
	
	@Test
	public void deleteTest() {
		assertEquals(1, DAO.delete(1l));
	}
}
