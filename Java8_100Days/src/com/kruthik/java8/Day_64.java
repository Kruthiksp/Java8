package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day25;

/*
 * Given a List of Order Objects.
	group the orders by city, and for each city:
	Find the total order amount.
	Find the average order amount per category (nested grouping by category).
	Find the highest order (max by amount).
 */
public class Day_64 {

	public static void main(String[] args) {
		List<Order_Day25> orders = initializer();

		Map<String, Map<String, Object>> result = orders.stream().collect(Collectors
				.groupingBy(Order_Day25::getCity,
							Collectors.teeing(
									Collectors.summingDouble(Order_Day25::getAmount),
									Collectors.teeing(
											Collectors.groupingBy(Order_Day25::getCategory, Collectors.averagingDouble(Order_Day25::getAmount)),
											Collectors.collectingAndThen(
													Collectors.maxBy(Comparator.comparing(Order_Day25::getAmount)),
													opt -> opt.orElse(null)),
											(avgByCat, maxOrder) -> Map.of("avgByCat", avgByCat ,"maxOrder", maxOrder)),
									(total, map) -> {
										Map<String, Object> finalMap = new HashMap<>(map);
										finalMap.put("total", total);
										return finalMap;
									})
							)
			);
		
		result.entrySet().stream().forEach(System.out::println);
	}

	public static List<Order_Day25> initializer() {
		return Arrays.asList(new Order_Day25("John", "Electronics", 4500.0, "Delhi", "O101", "DELIVERED"),
				new Order_Day25("Alice", "Grocery", 1200.0, "Delhi", "O102", "PENDING"),
				new Order_Day25("Bob", "Clothing", 2000.0, "Mumbai", "O103", "DELIVERED"),
				new Order_Day25("Charlie", "Electronics", 3000.0, "Mumbai", "O104", "CANCELLED"),
				new Order_Day25("David", "Grocery", 5000.0, "Bangalore", "O105", "DELIVERED"),
				new Order_Day25("Eva", "Clothing", 3500.0, "Bangalore", "O106", "DELIVERED"),
				new Order_Day25("Frank", "Electronics", 2500.0, "Delhi", "O107", "DELIVERED"),
				new Order_Day25("Grace", "Clothing", 1800.0, "Mumbai", "O108", "DELIVERED"),
				new Order_Day25("Helen", "Grocery", 2200.0, "Bangalore", "O109", "PENDING"));
	}
}
