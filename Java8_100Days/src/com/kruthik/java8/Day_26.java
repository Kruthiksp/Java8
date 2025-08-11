package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day26;

	/**
	 * Given a List of Transaction Objects.
	 * 		Filter transactions that happened in 2023 only.
	 * 		Group these transactions by city.
	 * 		For each city, find the transaction with the maximum amount.
	 * 		sort the result by the highest transaction amount (descending order)
	 */
public class Day_26 {

	public static void main(String[] args) {

		List<Transaction_Day26> transactions = initializer();

		Map<String, List<Transaction_Day26>> filteredByYearAndCity = 
				transactions.stream().filter(t -> t.getYear() == 2023).collect(Collectors.groupingBy(Transaction_Day26::getCity));

		Map<String, Transaction_Day26> maxByCity = filteredByYearAndCity.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream()
						.max(Comparator.comparingDouble(Transaction_Day26::getAmount)).orElse(null)));

		Map<String, Transaction_Day26> sortedResult = maxByCity.entrySet().stream()
				.sorted(Comparator
						.comparingDouble((Map.Entry<String, Transaction_Day26> entry) -> entry.getValue().getAmount())
						.reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

		System.out.println(sortedResult);
	}

	public static List<Transaction_Day26> initializer() {
		return Arrays.asList(new Transaction_Day26("John", "Bangalore", 5000.0, 2023),
				new Transaction_Day26("Alice", "Mumbai", 6500.0, 2023),
				new Transaction_Day26("Bob", "Delhi", 3000.0, 2023),
				new Transaction_Day26("David", "Bangalore", 4500.0, 2023),
				new Transaction_Day26("Eve", "Mumbai", 7000.0, 2025),
				new Transaction_Day26("Frank", "Delhi", 8000.0, 2024),
				new Transaction_Day26("Maxx", "Bangalore", 6000.0, 2022),
				new Transaction_Day26("Dev", "Delhi", 7500.0, 2023));
	}
}
