package com.kruthik.java8.entities;

public class Transaction_Day36 {
	
	private String customerName;
	private String transactionId;
	private double amount;
	private String type;

	public Transaction_Day36(String customerName, String transactionId, double amount, String type) {
		this.customerName = customerName;
		this.transactionId = transactionId;
		this.amount = amount;
		this.type = type;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getAmount() {
		return amount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Txn[" + transactionId + ", " + type + ", " + amount + "]";
	}
}
