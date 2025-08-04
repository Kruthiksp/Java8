package com.kruthik.java8.entities;

public class Item {

	private String name;
	private double price;
	private int quantity;

	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Item(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

//	@Override
//	public String toString() {
//		return "Item [name=" + name + ", price=" + price + "]";
//	}

}
