package com.kruthik.java8.entities;

public class Product {

	String name;
	double price;
	// Day-28 fields
	String category;
	double rating;

	public Product(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product(String name, String category, double price, double rating) {
		super();
		this.name = name;
		this.price = price;
		this.category = category;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", category=" + category + ", rating=" + rating + "]";
	}

//	@Override
//	public String toString() {
//		return "Product [name=" + name + ", price=" + price + "]";
//	}

}
