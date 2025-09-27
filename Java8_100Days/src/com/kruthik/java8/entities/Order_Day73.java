package com.kruthik.java8.entities;

import java.util.List;

public class Order_Day73 {
	private int orderId;
	private String customerName;
	private List<String> items;
	private double amount;

	public Order_Day73(int orderId, String customerName, List<String> items, double amount) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.items = items;
		this.amount = amount;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<String> getItems() {
		return items;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", items=" + items + ", amount="
				+ amount + "]";
	}

}
