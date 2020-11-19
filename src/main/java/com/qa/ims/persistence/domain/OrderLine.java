package com.qa.ims.persistence.domain;


public class OrderLine {
	// -------------------
		// Attributes
		// -------------------
			private Long orderline_id;
			private Long order_id;
			private Long item_id;
			private int quantity;
			public OrderLine(Long order_id, Long item_id, int quantity) {
				super();
				this.order_id = order_id;
				this.item_id = item_id;
				this.quantity = quantity;
			}
			
			
			public OrderLine(Long orderline_id, Long order_id, Long item_id, int quantity) {
				super();
				this.orderline_id = orderline_id;
				this.order_id = order_id;
				this.item_id = item_id;
				this.quantity = quantity;
			}


			public Long getOrderline_id() {
				return orderline_id;
			}


			public void setOrderline_id(Long orderline_id) {
				this.orderline_id = orderline_id;
			}


			public Long getOrder_id() {
				return order_id;
			}
			public void setOrder_id(Long order_id) {
				this.order_id = order_id;
			}
			public Long getItem_id() {
				return item_id;
			}
			public void setItem_id(Long item_id) {
				this.item_id = item_id;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}


			@Override
			public String toString() {
				String out = "Item ID " + item_id.toString() + "  Qty: " +quantity;
				return out;
			}
			
			

}
