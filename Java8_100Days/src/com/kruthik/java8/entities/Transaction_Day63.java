package com.kruthik.java8.entities;

public class Transaction_Day63 {
	private String id;
	private String type; // e.g., "GROCERY", "ELECTRONICS", "CLOTHING"
	private double amount;
	private String city;

	public Transaction_Day63(String id, String type, double amount, String city) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", amount=" + amount + ", city=" + city + "]";
	}

}
