package com.kruthik.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day73;

/*
 * Given a List of Order Objects.
   	Find all unique items bought across all orders (flatten items).
	Count how many times each item was bought (frequency).
	Find the customer who spent the maximum total amount (group by customer and sum).
	Return a Map<String, Object> containing:
	"uniqueItems" → Set of items
	"itemFrequency" → Map<String, Long>
	"topCustomer" → customerName
 */
public class Day_73 {

	public static void main(String[] args) {
		
		List<Order_Day73> orders = getOrders();
		
		Set<String> items = orders.stream().flatMap(o -> o.getItems().stream()).collect(Collectors.toSet());
		Map<String, Long> frequency = orders.stream().flatMap(o -> o.getItems().stream()).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
		Map<String, Double> customerTotal = orders.stream().collect(Collectors.groupingBy(Order_Day73::getCustomerName, Collectors.summingDouble(Order_Day73::getAmount)));
		String topCustomer = customerTotal.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("items", items);
		result.put("frequency", frequency);
		result.put("topCustomer", topCustomer);
		
		result.entrySet().forEach(System.out::println);
	}
	
	public static List<Order_Day73> getOrders() {
		return Arrays.asList(
			    new Order_Day73(1, "Alice", Arrays.asList("Laptop", "Mouse"), 60000),
			    new Order_Day73(2, "Bob", Arrays.asList("Keyboard", "Mouse"), 15000),
			    new Order_Day73(3, "Alice", Arrays.asList("Monitor"), 20000),
			    new Order_Day73(4, "Charlie", Arrays.asList("Laptop", "Keyboard", "Mouse"), 80000)
			);
	}

}
