package com.qa.ims.persistence.domain;

import java.sql.Date;

//import java.util.List;

public class Order {
	// -------------------
	// Attributes
	// -------------------
		private Long order_id;
		private Long customer_id;
		private Date order_date;
		private double total_cost = 0;
		//private List<Item> itemList;
		
		public Order(Long customer_id, Date order_date, double total_cost) {
			super();
			this.customer_id = customer_id;
			this.order_date = order_date;
			this.total_cost = total_cost;

		}

		public Order(Long customer_id, Date order_date) {
			super();
			this.customer_id = customer_id;
			this.order_date = order_date;
		}

		public Order(Long order_id, Long customer_id, Date order_date, double total_cost) {
			super();
			this.order_id = order_id;
			this.customer_id = customer_id;
			this.order_date = order_date;
			this.total_cost = total_cost;

		}

		public Order(Long order_id, double total_cost) {
			super();
			this.order_id = order_id;
			this.total_cost = total_cost;
		}

		public Long getOrder_id() {
			return order_id;
		}

		public void setOrder_id(Long order_id) {
			this.order_id = order_id;
		}



		public Long getCustomer_id() {
			return customer_id;
		}

		public void setCustomer_id(Long customer_id) {
			this.customer_id = customer_id;
		}

		public Date getOrder_date() {
			return order_date;
		}

		public void setOrder_date(Date order_date) {
			this.order_date = order_date;
		}

		public double getTotal_cost() {
			return total_cost;
		}

		public void setTotal_cost(double total_cost) {
			this.total_cost = total_cost;
		}

//		public List<Item> getItemList() {
//			return itemList;
//		}
//
//		public void setItemList(List<Item> itemList) {
//			this.itemList = itemList;
//		}
		//Long order_id, Long customer_id, Date order_date, double total_cost
		@Override
		public String toString() {
			return "id:" + order_id + " customer_id: " + customer_id + " Date: " + order_date + " total_cost: "+ total_cost;
		}
		
	
	
}
