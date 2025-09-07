package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day36;

/*
 * Given a list of Transaction objects with fields:
	Calculate the total credited amount and total debited amount separately.
	Find the highest transaction amount.
	Find the user with the maximum total transaction amount (sum of all their transactions).
	Create a comma-separated string of all unique transaction types.
*/
public class Day_53 {

	public static void main(String[] args) {

		List<Transaction_Day36> txns = initializer();

		Map<String, Double> typeTotal = txns.stream().collect(Collectors.groupingBy(Transaction_Day36::getType,
				Collectors.summingDouble(Transaction_Day36::getAmount)));

		Transaction_Day36 maxTxn = txns.stream().max(Comparator.comparing(Transaction_Day36::getAmount)).get();

		Entry<String, Double> maxTxnCustomer = txns.stream()
				.collect(Collectors.collectingAndThen(
						Collectors.groupingBy(Transaction_Day36::getCustomerName,
								Collectors.summingDouble(Transaction_Day36::getAmount)),
						map -> map.entrySet().stream().max(Map.Entry.comparingByValue())))
				.get();

		String paymentTypes = txns.stream().map(txn -> txn.getType())
				.collect(Collectors.collectingAndThen(Collectors.toSet(), set -> String.join(", ", set)));

		System.out.println(typeTotal);
		System.out.println(maxTxn);
		System.out.println(maxTxnCustomer);
		System.out.println(paymentTypes);
	}

	public static List<Transaction_Day36> initializer() {
		return Arrays.asList(new Transaction_Day36("Alice", "T1", 1200.0, "CREDIT"),
				new Transaction_Day36("Alice", "T2", 800.0, "DEBIT"),
				new Transaction_Day36("Bob", "T3", 500.0, "DEBIT"), new Transaction_Day36("Bob", "T4", 2200.0, "DEBIT"),
				new Transaction_Day36("Charlie", "T5", 1500.0, "CREDIT"),
				new Transaction_Day36("Charlie", "T6", 700.0, "CREDIT"));
	}

}
