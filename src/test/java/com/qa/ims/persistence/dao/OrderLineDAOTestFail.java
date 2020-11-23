package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderLine;
import com.qa.ims.utils.DBUtils;

public class OrderLineDAOTestFail {
	private final OrderLineDAO DAO = new OrderLineDAO();
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "fail");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data-test.sql");
	}
	
	//order_id, customer_id, Date order_date, total_cost, 
	// List<OrderLine> orderLineList
	@Test
	public void readAllTest() {
		List<OrderLine> orderlines = new ArrayList<>();
		assertEquals(orderlines, DAO.readAll());
	}
	 
	@Test
	public void readLatestTest() {
		assertEquals(null, DAO.readLatest());
	}
	
	@Test
	public void createTest() {

		OrderLine expected = new OrderLine(2l, 1l, 1l, 1);
	
		assertEquals(null, DAO.create(expected));
	}
	
	@Test
	public void readOrderLineTest() {
		assertEquals(null, DAO.readOrderLineByOrder(1l, 1l));
	}
	
	@Test
	public void deleteTest() {
		assertEquals(0, DAO.delete(2l));
	}
	
	@Test
	public void readAllIDTest() {
		List<OrderLine> orderlines = new ArrayList<>();
		assertEquals(orderlines, DAO.readAllID(1l));
	}
}
