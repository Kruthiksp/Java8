package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day36;

/*
 * Given a list of Transaction objects, 
 * 	Group them by customerName and find:
 * 	Total transaction amount per customer.
 * 	Highest transaction per customer.
 * 	Print customers sorted by their total transaction amount (descending), along with their highest transaction.
 */
public class Day_36 {

	public static void main(String[] args) {

		List<Transaction_Day36> txns = initializer();

		Map<String, Double> totalByCustomer = txns.stream().collect(Collectors.groupingBy(
				Transaction_Day36::getCustomerName, Collectors.summingDouble(Transaction_Day36::getAmount)));

		Map<String, Transaction_Day36> maxPaymentByCustomer = txns.stream()
				.collect(Collectors.groupingBy(Transaction_Day36::getCustomerName, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Transaction_Day36::getAmount)), Optional::get)));

		totalByCustomer.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.forEach(entity -> {
					String key = entity.getKey();
					Double value = entity.getValue();
					Transaction_Day36 transaction = maxPaymentByCustomer.get(key);

					System.out.println(key + " -> " + value + " | " + transaction);

				});

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
