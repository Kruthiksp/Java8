package com.kruthik.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day59;
/*
 * Given a List of Order Objects.
	Group orders by their status.
	For each status, calculate:
		-> Total Revenue (sum of amount)
		-> List of unique customer names
		-> List of all purchased items (flattened, no duplicates)
	Return the result as a Map<Status, Map<String, Object>>
 */
public class Day_59 {

	public static void main(String[] args) {
		List<Order_Day59> orders = initializer();

		Map<String, Map<String, Object>> result = orders.stream()
		        .collect(Collectors.groupingBy(
		                Order_Day59::getStatus,
		                Collectors.collectingAndThen(
		                        Collectors.teeing(
		                                Collectors.summingDouble(Order_Day59::getAmount), // 1st collector -> total revenue
		                                Collectors.teeing(
		                                        Collectors.mapping(Order_Day59::getCustomerName, Collectors.toSet()), // 2nd collector -> customers
		                                        Collectors.flatMapping(o -> o.getItems().stream(), Collectors.toSet()), // 3rd collector -> items
		                                        (customers, items) -> Map.of("customers", customers, "items", items)
		                                ),
		                                (total, map) -> {
		                                    Map<String, Object> finalMap = new HashMap<>(map);
		                                    finalMap.put("totalRevenue", total);
		                                    return finalMap;
		                                }
		                        ),
		                        Function.identity()
		                )
		        ));

		result.entrySet().stream().forEach(System.out::println);
	}

	public static List<Order_Day59> initializer() {
		return Arrays.asList(new Order_Day59("O1", "Alice", 1200, "NEW", Arrays.asList("Laptop", "Mouse")),
				new Order_Day59("O2", "Bob", 800, "COMPLETED", Arrays.asList("Keyboard", "Mouse")),
				new Order_Day59("O3", "Alice", 1500, "COMPLETED", Arrays.asList("Monitor", "Keyboard")),
				new Order_Day59("O4", "Charlie", 500, "CANCELLED", Arrays.asList("Mouse")));
	}
}
