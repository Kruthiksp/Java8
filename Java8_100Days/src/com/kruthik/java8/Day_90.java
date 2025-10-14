package com.kruthik.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Item;
import com.kruthik.java8.entities.Order;

/*
 * Given a list of Order objects, each Order has List<Item>
 * Group them by customer name
 * 	Compute "totalSpent" -> total price of all items purchased by the customer.
			"uniqueItems" -> comma-separated string of all unique item names (no duplicates).
			"orderCount" -> total number of orders placed by the customer.
 */
public class Day_90 {

	public static void main(String[] args) {
		
		List<Order> orders = getOrders();
		
		Map<String, LinkedHashMap<String, Object>> res = orders.stream().collect(
				Collectors.groupingBy(
						Order::getCustomerName,
						Collectors.collectingAndThen(
								Collectors.toList(),
								lst -> {
									LinkedHashMap<String, Object> map = new LinkedHashMap<>();
									
									double totalSpent = lst.stream().flatMap(o-> o.getItems().stream()).collect(Collectors.summingDouble(Item::getPrice));
									String uniqueItems = lst.stream().flatMap(o-> o.getItems().stream()).collect(Collectors.mapping(Item::getName, Collectors.joining(", ")));
									long orderCount = lst.stream().count();
									map.put("totalSpent", totalSpent);
									map.put("uniqueItems", uniqueItems);
									map.put("orderCount", orderCount);
									return map;
								}
							)
						)
				);
		
		res.forEach((customer, stats) -> {
			System.out.println(customer);
			stats.forEach((key, val) -> {
				System.out.println(key + " => " + val);
			});
			System.out.println();
		});
	}

	public static List<Order> getOrders() {
		return Arrays.asList(
				new Order(1, "Alice", Arrays.asList(new Item("Laptop", 75000), new Item("Mouse", 1500))),
				new Order(2, "Bob", Arrays.asList(new Item("Keyboard", 2000), new Item("Mouse", 1500))),
				new Order(3, "Alice", Arrays.asList(new Item("Laptop", 75000), new Item("Headphones", 3000))));

	}

}
