package com.kruthik.java8.entities;

public class Invoice {
	
	private String customerName;
	private String category;
	private double amount;
	private String month;

	public Invoice(String customerName, String category, double amount, String month) {
		this.customerName = customerName;
		this.category = category;
		this.amount = amount;
		this.month = month;
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

	public String getMonth() {
		return month;
	}

	@Override
	public String toString() {
		return customerName + " - " + category + " - " + amount + " - " + month;
	}

}
