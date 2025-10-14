package com.kruthik.java8.entities;

import java.util.List;

public class Order {

	private int orderId;
	private String customerName;
	private List<Item> items;

	public Order(int orderId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.items = items;
	}

	public Order(int orderId, String customerName, List<Item> items) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.items = items;
	}

	public int getOrderId() {
		return orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", items=" + items + "]";
	}

}
