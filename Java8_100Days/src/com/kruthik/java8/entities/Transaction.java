package com.kruthik.java8.entities;

public class Transaction {

	private String category;
	private String paymentMethod;
	private double amount;

	/*
	 * 2 Args Constructors
	 */
	public Transaction(String category, double amount) {
		super();
		this.category = category;
		this.amount = amount;
	}

	/*
	 * 3 Args Constructors
	 */
	public Transaction(String category, String paymentMethod, double amount) {
		super();
		this.category = category;
		this.paymentMethod = paymentMethod;
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

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Transaction [category=" + category + ", paymentMethod=" + paymentMethod + ", amount=" + amount + "]";
	}

//	@Override
//	public String toString() {
//		return "Transaction [category=" + category + ", amount=" + amount + "]";
//	}

}
