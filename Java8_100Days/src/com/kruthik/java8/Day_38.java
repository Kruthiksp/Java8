package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day36;

/*
 * Given a list of Transaction objects
 * 	Find the total amount of all CREDIT transactions.
 * 	Get the list of transactions greater than 1000.
 * 	Find the transaction with the maximum amount.
 */
public class Day_38 {

	public static void main(String[] args) {

		List<Transaction_Day36> txns = initializer();

		double totalCredit = txns.stream().filter(t -> t.getType().equals("CREDIT"))
				.mapToDouble(Transaction_Day36::getAmount).sum();
		System.out.println("Total CREDIT amount = " + totalCredit);

		List<Transaction_Day36> highValueTxns = txns.stream().filter(t -> t.getAmount() > 1000)
				.collect(Collectors.toList());
		System.out.println("\nTransactions greater than 1000");
		highValueTxns.forEach(System.out::println);

		Transaction_Day36 maxTxn = txns.stream().max(Comparator.comparing(Transaction_Day36::getAmount)).get();
		System.out.println("\nTransaction with max amount");
		System.out.println(maxTxn);
	}

	private static List<Transaction_Day36> initializer() {
		return Arrays.asList(new Transaction_Day36("Alice", "T1", 1200.0, "CREDIT"),
				new Transaction_Day36("Alice", "T2", 800.0, "DEBIT"),
				new Transaction_Day36("Bob", "T3", 500.0, "CREDIT"),
				new Transaction_Day36("Bob", "T4", 2200.0, "DEBIT"),
				new Transaction_Day36("Charlie", "T5", 1500.0, "CREDIT"),
				new Transaction_Day36("Charlie", "T6", 700.0, "DEBIT"));
	}
}
