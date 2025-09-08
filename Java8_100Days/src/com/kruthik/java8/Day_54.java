package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day25;

/*
 * Find the first order with status = "NEW".
	Find any order with status = "COMPLETED" (to demonstrate findAny()).
	Calculate the total revenue from all COMPLETED orders.
	Partition orders into completed vs not completed using partitioningBy.
 */
public class Day_54 {

	public static void main(String[] args) {

		List<Order_Day25> orders = initializer();

		Order_Day25 first = orders.stream().filter(o -> o.getStatus().equals("NEW")).findFirst().get();
		System.out.println(first);

		Order_Day25 any = orders.stream().filter(o -> o.getStatus().equals("COMPLETED")).findAny().get();
		System.out.println(any);

		double revenue = orders.stream().filter(o -> o.getStatus().equals("COMPLETED"))
				.collect(Collectors.summingDouble(Order_Day25::getAmount));
		System.out.println(revenue);

		Map<Boolean, List<Order_Day25>> partation = orders.stream()
				.collect(Collectors.partitioningBy(o -> o.getStatus().equals("COMPLETED")));
		partation.entrySet().stream().forEach(System.out::println);
	}

	public static List<Order_Day25> initializer() {
		return Arrays.asList(new Order_Day25("John", "Electronics", 4500.0, "Delhi", "O101", "NEW"),
				new Order_Day25("Alice", "Grocery", 1200.0, "Delhi", "O102", "PROCESSING"),
				new Order_Day25("Bob", "Clothing", 2000.0, "Mumbai", "O103", "COMPLETED"),
				new Order_Day25("Charlie", "Electronics", 3000.0, "Mumbai", "O104", "COMPLETED"),
				new Order_Day25("David", "Grocery", 5000.0, "Bangalore", "O105", "CANCELLED"),
				new Order_Day25("Eva", "Clothing", 3500.0, "Bangalore", "O106", "CANCELLED"),
				new Order_Day25("Frank", "Electronics", 2500.0, "Delhi", "O107", "NEW"),
				new Order_Day25("Grace", "Clothing", 1800.0, "Mumbai", "O108", "PROCESSING"),
				new Order_Day25("Helen", "Grocery", 2200.0, "Bangalore", "O109", "NEW"));
	}
}
