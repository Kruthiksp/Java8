package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day36;

/*
 * Given a list of transactions:
 * 	Find the total amount of all transactions using Collectors.reducing.
 * 	Find the transaction with the maximum amount.
 * 	Use Collectors.summarizingDouble to get count, sum, min, average, and max of transaction amounts.
 */
public class Day_46 {

	public static void main(String[] args) {

		List<Transaction_Day36> txns = initializer();

		Double totalAmt = txns.stream().map(Transaction_Day36::getAmount).reduce(Double::sum).get();
		System.out.println("Total amount of all transactions: " + totalAmt);

		Transaction_Day36 maxTxn = txns.stream().max(Comparator.comparing(Transaction_Day36::getAmount)).get();
		System.out.println("Transaction with the maximum amount: " + maxTxn);

		DoubleSummaryStatistics summary = txns.stream()
				.collect(Collectors.summarizingDouble(Transaction_Day36::getAmount));
		System.out.println("Summary of all Transactions: " + summary);

	}

	private static List<Transaction_Day36> initializer() {
		return Arrays.asList(new Transaction_Day36("Alice", "T1", 1200.0, "ONLINE"),
				new Transaction_Day36("Alice", "T2", 800.0, "OFFLINE"),
				new Transaction_Day36("Bob", "T3", 500.0, "ONLINE"),
				new Transaction_Day36("Bob", "T4", 2200.0, "OFFLINE"),
				new Transaction_Day36("Charlie", "T5", 1500.0, "ONLINE"),
				new Transaction_Day36("Charlie", "T6", 700.0, "OFFLINE"));
	}
}
