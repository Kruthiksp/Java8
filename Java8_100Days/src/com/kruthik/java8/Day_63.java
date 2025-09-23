package com.kruthik.java8;
/*
 * Given a List of Transaction Objects:
 * 	Group transactions by city, and for each city:
	-> Calculate the total amount spent
	-> Find the highest transaction (by amount)
	-> Collect the distinct types of transactions
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day63;

public class Day_63 {

	public static void main(String[] args) {
		List<Transaction_Day63> txns = initializer();

		Map<String, HashMap<String, Object>> res = txns.stream().collect(Collectors
				.groupingBy(Transaction_Day63::getCity,
						Collectors.teeing(
								Collectors.summingDouble(Transaction_Day63::getAmount),
								Collectors.teeing(
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparing(Transaction_Day63::getAmount)),
												opt -> opt.orElse(null)),
										Collectors.mapping(Transaction_Day63::getType, Collectors.toSet()),
										(max, types) -> Map.entry(max, types)),
								(total, entry) -> {
									HashMap<String, Object> finalMap = new HashMap<>();
									finalMap.put("total", total);
									finalMap.put("maxTxn", entry.getKey());
									finalMap.put("types", entry.getValue());
									return finalMap;
								})
						)
				);

		res.entrySet().stream().forEach(System.out::println);
		
	}

	public static List<Transaction_Day63> initializer() {
		return Arrays.asList(
				new Transaction_Day63("TXN001", "GROCERY", 2300.0, "Bangalore"),
				new Transaction_Day63("TXN002", "CLOTHING", 7000.0, "Mumbai"),
				new Transaction_Day63("TXN003", "ELECTRONICS", 4500.0, "Mumbai"),
				new Transaction_Day63("TXN004", "GROCERY", 4300.0, "Bangalore"),
				new Transaction_Day63("TXN005", "ELECTRONICS", 8000.0, "Bangalore"),
				new Transaction_Day63("TXN006", "CLOTHING", 5200.0, "Delhi"),
				new Transaction_Day63("TXN007", "GROCERY", 3100.0, "Delhi"),
				new Transaction_Day63("TXN008", "ELECTRONICS", 2900.0, "Bangalore")
			);

	}

}
