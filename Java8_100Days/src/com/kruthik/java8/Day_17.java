package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction;

/*
	You are given a list of Transaction objects.
	Each transaction has: category, paymentMethod, amount.
		Group the transactions by category.
		Then group each category’s transactions by paymentMethod.
		Sum the total amount spent per payment method per category.
*/
public class Day_17 {

	public static void main(String[] args) {

		List<Transaction> transactions = initializer();

		Map<String, Map<String, Double>> result = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCategory, Collectors
						.groupingBy(Transaction::getPaymentMethod, Collectors.summingDouble(Transaction::getAmount))));

		System.out.println(result);

	}

	public static List<Transaction> initializer() {
		return Arrays.asList(new Transaction("Travel", "Credit Card", 3000.0),
				new Transaction("Travel", "Cash", 2000.0), new Transaction("Food", "Debit Card", 300.0),
				new Transaction("Travel", "Credit Card", 1500.0), new Transaction("Shopping", "UPI", 1000.0),
				new Transaction("Shopping", "UPI", 500.0), new Transaction("Food", "Cash", 200.0),
				new Transaction("Food", "Debit Card", 100.0));
	}
}
