package com.kruthik.java8.entities;

import java.util.List;

public class Customer_Day65 {
	private int id;
	private String name;
	private String city;
	private List<Order_Day59> orders;

	public Customer_Day65(int id, String name, String city, List<Order_Day59> orders) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public List<Order_Day59> getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Customer_Day65 [id=" + id + ", name=" + name + ", city=" + city + ", orders=" + orders + "]";
	}

}
