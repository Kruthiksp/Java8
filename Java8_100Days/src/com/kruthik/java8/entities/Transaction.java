package com.kruthik.java8.entities;

public class Transaction {

	private String category;
	private double amount;

	public Transaction(String category, double amount) {
		super();
		this.category = category;
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [category=" + category + ", amount=" + amount + "]";
	}

}
