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

public class OrderLineDAOTest {
	private final OrderLineDAO DAO = new OrderLineDAO();
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
		List<OrderLine> orderlines = new ArrayList<>();
		orderlines.add(new OrderLine(1l, 1l, 1l, 1));

		assertEquals(orderlines, DAO.readAll());
	}
	 
	@Test
	public void readLatestTest() {
		assertEquals(new OrderLine(1l, 1l, 1l, 1), DAO.readLatest());
	}
	
	@Test
	public void createTest() {

		OrderLine expected = new OrderLine(2l, 1l, 1l, 1);
	
		assertEquals(expected, DAO.create(expected));
	}
	
	@Test
	public void readOrderLineTest() {
		OrderLine expected = new OrderLine(1l, 1l, 1l, 1);
		assertEquals(expected, DAO.readOrderLineByOrder(1l, 1l));
	}
	
	@Test
	public void deleteTest() {
		assertEquals(1, DAO.delete(1l));
	}
	
}
