package com.qa.ims.persistence.domain;

public class Item {
	
	// -------------------
	// Attributes
	// -------------------
		private Long item_id;
		private String item_title;
		private int quantity;
		private double price;
	
	// ------------------------
	// Constructor with no id
	// ------------------------
		public Item(String item_title, int quantity, double price) {
			super();
			this.item_title = item_title;
			this.quantity = quantity;
			this.price = price;
		}
	
	// ------------------------
	// Constructor with ID
	// ------------------------
		public Item(Long item_id, String item_title, int quantity, double price) {
			super();
			this.item_id = item_id;
			this.item_title = item_title;
			this.quantity = quantity;
			this.price = price;
		}
		
	// -----------------------
	// Getters and Setters
	// -----------------------
		public Long getItem_id() {
			return item_id;
		}
		public void setItem_id(Long item_id) {
			this.item_id = item_id;
		}
		public String getItem_title() {
			return item_title;
		}
		public void setItem_title(String item_title) {
			this.item_title = item_title;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
	
	//Long item_id, String item_title, int quantity, double price
	@Override
	public String toString() {
		return "id:" + item_id + " item_title: " + item_title + " quantity: " + quantity + " price: "+ price;
	}
}
