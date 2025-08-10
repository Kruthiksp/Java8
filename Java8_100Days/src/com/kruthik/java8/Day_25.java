package com.kruthik.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day25;

	/*
	 * Given a List of Order Objects
	 * 		From a given List<Order>, group the orders by city,
	 * 		Inside each city, further group by category,
	 * 		For each category, calculate the total sales amount,
	 * 		Sort the categories in descending order of sales within each city.
	 */
public class Day_25 {

	public static void main(String[] args) {

		LinkedHashMap<String, LinkedHashMap<String, Double>> result = new LinkedHashMap<>();

		List<Order_Day25> orders = initializer();

		Map<String, Map<String, Double>> cityCategoryTotal = orders.stream().collect(Collectors.groupingBy(
				Order_Day25::getCity,
				Collectors.groupingBy(Order_Day25::getCategory, Collectors.summingDouble(Order_Day25::getAmount))));

		cityCategoryTotal.entrySet().stream().forEach(entry -> {
			String city = entry.getKey();
			Map<String, Double> categoryMap = entry.getValue();

			LinkedHashMap<String, Double> sortedMap = categoryMap.entrySet().stream()
					.sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toMap(
							Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> (v1 + v2) / 2, LinkedHashMap::new));

			result.put(city, sortedMap);
		});

		result.entrySet().stream().forEach(System.out::println);

	}

	public static List<Order_Day25> initializer() {
		return Arrays.asList(new Order_Day25("John", "Electronics", 2500.0, "Delhi"),
				new Order_Day25("Alice", "Grocery", 1200.0, "Delhi"),
				new Order_Day25("Bob", "Electronics", 2000.0, "Delhi"),
				new Order_Day25("David", "Grocery", 1000.0, "Bangalore"),
				new Order_Day25("Eve", "Clothing", 3500.0, "Bangalore"),
				new Order_Day25("Frank", "Grocery", 4000.0, "Bangalore"),
				new Order_Day25("Grace", "Clothing", 2000.0, "Mumbai"),
				new Order_Day25("Hank", "Electronics", 3000.0, "Mumbai"));
	}
}
