package com.kruthik.java8.entities;

public class Transaction_Day23 {

	String city;
	String type; // e.g. "Grocery", "Electronics", "Stationery"
	double amount;

	public Transaction_Day23(String city, String type, double amount) {
		super();
		this.city = city;
		this.type = type;
		this.amount = amount;
	}

	public String getCity() {
		return city;
	}

	public String getType() {
		return type;
	}

	public double getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction_Day23 [city=" + city + ", type=" + type + ", amount=" + amount + "]";
	}

}
