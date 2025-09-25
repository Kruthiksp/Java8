package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Customer_Day65;
import com.kruthik.java8.entities.Order_Day59;

/*
 * Given a List of Customer Objects.
	totalRevenue → Sum of all amount for "DELIVERED" orders.
	topCustomer → Customer who spent the most (only "DELIVERED" orders count).
	orderStatuses → A Set<String> containing all distinct order statuses found in that city.
 */

public class Day_65 {

	public static void main(String[] args) {

		List<Customer_Day65> customers = initializer();

		Map<String, Map<String, Object>> result = customers.stream()
				.collect(Collectors.groupingBy(Customer_Day65::getCity, Collectors.teeing(

						Collectors.flatMapping(cust -> cust.getOrders().stream(),
								Collectors.filtering(order -> order.getStatus().equals("DELIVERED"),
										Collectors.toList())),

						Collectors.teeing(
								Collectors.flatMapping(cust -> cust.getOrders().stream(),
										Collectors.summingDouble(Order_Day59::getAmount)),
								Collectors.flatMapping(cust -> cust.getOrders().stream(),
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparingDouble(Order_Day59::getAmount)),
												opt -> opt.orElse(null))),
								(totalRevenue, maxOrder) -> Map.of("totalRevenue", totalRevenue, "maxOrder", maxOrder)),

						(completedOrders, statsMap) -> {
							Map<String, Object> finalMap = new HashMap<>(statsMap);
							finalMap.put("DELIVERED_Orders", completedOrders);
							return finalMap;
						})));
		
		result.entrySet().forEach(System.out::println);

	}

	public static List<Customer_Day65> initializer() {
		Order_Day59 o1 = new Order_Day59("O1", "Alice", 1200, "NEW", Arrays.asList("Laptop", "Mouse"));
		Order_Day59 o2 = new Order_Day59("O2", "Alice", 1500, "COMPLETED", Arrays.asList("Monitor", "Keyboard"));

		Order_Day59 o3 = new Order_Day59("O3", "Bob", 800, "COMPLETED", Arrays.asList("Keyboard", "Mouse"));
		Order_Day59 o4 = new Order_Day59("O4", "Bob", 2000, "NEW", Arrays.asList("Chair", "Desk"));

		Order_Day59 o5 = new Order_Day59("O5", "Charlie", 500, "CANCELLED", Arrays.asList("Mouse"));
		Order_Day59 o6 = new Order_Day59("O6", "Charlie", 1800, "COMPLETED", Arrays.asList("Monitor"));

		Order_Day59 o7 = new Order_Day59("O7", "David", 700, "NEW", Arrays.asList("Keyboard"));
		Order_Day59 o8 = new Order_Day59("O8", "David", 2500, "DELIVERED", Arrays.asList("Laptop", "Headphones"));

		Order_Day59 o9 = new Order_Day59("O9", "Eve", 1000, "COMPLETED", Arrays.asList("Dress", "Shoes"));
		Order_Day59 o10 = new Order_Day59("O10", "Eve", 600, "CANCELLED", Arrays.asList("Bag"));

		return Arrays.asList(new Customer_Day65(1, "Alice", "Bangalore", Arrays.asList(o1, o2)),
				new Customer_Day65(2, "Bob", "Mumbai", Arrays.asList(o3, o4)),
				new Customer_Day65(3, "Charlie", "Bangalore", Arrays.asList(o5, o6)),
				new Customer_Day65(4, "David", "Delhi", Arrays.asList(o7, o8)),
				new Customer_Day65(5, "Eve", "Mumbai", Arrays.asList(o9, o10)));
	}

}
