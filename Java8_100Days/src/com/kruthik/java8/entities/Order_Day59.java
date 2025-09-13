package com.kruthik.java8.entities;

import java.util.List;

public class Order_Day59 {

	private String orderId;
	private String customerName;
	private double amount;
	private String status;
	private List<String> items;

	public Order_Day59(String orderId, String customerName, double amount, String status, List<String> items) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.amount = amount;
		this.status = status;
		this.items = items;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	public String getStatus() {
		return status;
	}

	public List<String> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Order_Day59 [orderId=" + orderId + ", customerName=" + customerName + ", amount=" + amount + ", status="
				+ status + ", items=" + items + "]";
	}

}
