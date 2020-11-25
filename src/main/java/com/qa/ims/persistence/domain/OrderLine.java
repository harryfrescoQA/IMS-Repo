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
				String out = "Item ID: " + item_id.toString() + "  Qty: " +quantity;
				return out;
			}
			
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				OrderLine other = (OrderLine) obj;
				if (orderline_id == null) {
					if (other.orderline_id != null)
						return false;
				} else if (!orderline_id.equals(other.orderline_id))
					return false;
				if (order_id == null) {
					if (other.order_id != null)
						return false;
				} else if (!order_id.equals(other.order_id))
					return false;
				if (item_id == null) {
					if (other.item_id != null)
						return false;
				} else if (!(item_id == other.item_id))
					return false;
				if (quantity == 0) {
					if (other.quantity != 0)
						return false;
				} else if (!(quantity == other.quantity))
					return false;
				return true;
			}

}
