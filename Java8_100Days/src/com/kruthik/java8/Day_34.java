package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day25;

/*
 * Given list of Order Objects
 * 		Consider only the orders with status = "DELIVERED".
 * 		For each city, find the category that has the highest total sales amount.
 * 		Print results like
 * 		city -> category (Total amount)
 */

public class Day_34 {

	public static void main(String[] args) {

		List<Order_Day25> orders = initializer();

		Map<String, Map<String, Double>> collect = orders.stream()
				.filter(order -> order.getStatus().equals("DELIVERED"))
				.collect(Collectors.groupingBy(Order_Day25::getCity, Collectors.groupingBy(Order_Day25::getCategory,
						Collectors.summingDouble(Order_Day25::getAmount))));

		collect.entrySet().stream().forEach(entity -> {
			String key = entity.getKey();
			Map<String, Double> value = entity.getValue();

			Entry<String, Double> maxCategory = value.entrySet().stream()
					.max(Map.Entry.<String, Double>comparingByValue()).get();

			System.out.println(key + " -> " + maxCategory.getKey() + " (" + maxCategory.getValue() + ")");

		});

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
