package com.kruthik.java8.entities;

public class Order_Day25 {

	private String customerName;
	private String category; // e.g., Electronics, Grocery, Clothing
	private double amount;
	private String city;

	// For day-33
	private String id;
	private String status;

	public Order_Day25(String customerName, String category, double amount, String city) {
		super();
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.city = city;
	}

	public Order_Day25(String customerName, String category, double amount, String city, String id, String status) {
		super();
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.city = city;
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCategory() {
		return category;
	}

	public double getAmount() {
		return amount;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Order_Day25 [customerName=" + customerName + ", category=" + category + ", amount=" + amount + ", city="
				+ city + ", id=" + id + ", status=" + status + "]";
	}

//	@Override
//	public String toString() {
//		return "Order_Day25 [customerName=" + customerName + ", category=" + category + ", amount=" + amount + ", city="
//				+ city + "]";
//	}

}
