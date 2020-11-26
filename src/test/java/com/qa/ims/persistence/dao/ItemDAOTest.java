package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	private final ItemDAO DAO = new ItemDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		// ID Title Quantity Price
		expected.add(new Item(1l, "Fender Stratocaster - White", 100, 700.00d));

		assertEquals(expected, DAO.readAll());
	}
	

	@Test
	public void testReadLatest() {
		assertEquals(new Item(1l, "Fender Stratocaster - White", 100, 700.00d), DAO.readLatest());
	}
	
	@Test
	public void testCreate() {
		Item expected = new Item(2l, "Test Item", 100, 700.00d);
		assertEquals(expected, DAO.create(expected));
	}
	
	@Test
	public void testReadItem() {
		Item expected = new Item(1l, "Fender Stratocaster - White", 100, 700.00d);
		assertEquals(expected, DAO.readItem(1l));
	}
	
	@Test
	public void testUpdate() {
		Item expected = new Item(1l, "Fender Stratocaster - Black", 100, 700.00d);
		assertEquals(expected, DAO.update(expected));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1l));
	}
}
