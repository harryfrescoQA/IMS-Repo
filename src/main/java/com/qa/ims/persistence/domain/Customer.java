package com.qa.ims.persistence.domain;

public class Customer {
	
	// -------------------
	// Attributes
	// -------------------
		private Long id;
		private String firstName;
		private String surname;

	// ------------------------
	// Constructor with no id
	// ------------------------
		public Customer(String firstName, String surname) {
			this.firstName = firstName;
			this.surname = surname;
		}

	// ------------------------
	// Constructor with ID
	// ------------------------
		public Customer(Long id, String firstName, String surname) {
			this.id = id;
			this.firstName = firstName;
			this.surname = surname;
		}
		
	// -----------------------
	// Getters and Setters
	// -----------------------
		public Long getId() {
			return id;
		}
		
		public void setId(Long id) {
			this.id = id;
		}
		
		public String getFirstName() {
			return firstName;
		}
		
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		
		public String getSurname() {
			return surname;
		}
		
		public void setSurname(String surname) {
			this.surname = surname;
		}

	@Override
	public String toString() {

		String output = "\n\n "+ id + "\t " + firstName + "\t \t " + surname;
		return output;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

}
