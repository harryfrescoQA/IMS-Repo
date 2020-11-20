package com.qa.ims.persistence.domain;

import java.sql.Date;
import java.util.List;

//import java.util.List;

public class Order {
	// -------------------
	// Attributes
	// -------------------
		private Long order_id;
		private Long customer_id;
		private Date order_date;
		private double total_cost = 0.00;
		// Has a list of orderLines which contain the items in the order
		private List<OrderLine> orderLineList;
		
		// Constructor with all values
		public Order(Long order_id, Long customer_id, Date order_date, double total_cost,
				List<OrderLine> orderLineList) {
			super();
			this.order_id = order_id;
			this.customer_id = customer_id;
			this.order_date = order_date;
			this.total_cost = total_cost;
			this.orderLineList = orderLineList;
		}

		// Constructor with no order_id
//		public Order(Long customer_id, Date order_date, double total_cost, List<OrderLine> orderLineList) {
//			super();
//			this.customer_id = customer_id;
//			this.order_date = order_date;
//			this.total_cost = total_cost;
//			this.orderLineList = orderLineList;
//
//		}

		public Order(Long customer_id, Date order_date) {
			super();
			this.customer_id = customer_id;
			this.order_date = order_date;
		}

//		public Order(Long order_id, Long customer_id, Date order_date, double total_cost) {
//			super();
//			this.order_id = order_id;
//			this.customer_id = customer_id;
//			this.order_date = order_date;
//			this.total_cost = total_cost;
//
//		}

		public Order(Long order_id, double total_cost) {
			super();
			this.order_id = order_id;
			this.total_cost = total_cost;
		}

		
		// Getters and Setters
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


		public List<OrderLine> getOrderLineList() {
			return orderLineList;
		}

		public void setOrderLineList(List<OrderLine> orderLineList) {
			this.orderLineList = orderLineList;
		}

		//Long order_id, Long customer_id, Date order_date, double total_cost
		@Override
		public String toString() {
			String out =  "Order ID:" + order_id + " Customer ID: " + customer_id + " Date: " + order_date + " Total Cost: "+ total_cost;
			out += "\n\t Items: " + "\n";
			out += "\t---------------\n";
			for(OrderLine i : orderLineList) {
				out += "\t" + i.toString() + "\n";
				
			}
			return out;
		}
		
	
	
}
