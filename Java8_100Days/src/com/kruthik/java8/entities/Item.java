package com.kruthik.java8.entities;

public class Item {

	private String name;
	private String category;
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

	public Item(String name, String category, int quantity) {
		super();
		this.name = name;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", category=" + category + ", quantity=" + quantity + "]";
	}

//	@Override
//	public String toString() {
//		return "Item [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
//	}

//	@Override
//	public String toString() {
//		return "Item [name=" + name + ", price=" + price + "]";
//	}

}
