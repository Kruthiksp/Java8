package com.kruthik.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Item;
import com.kruthik.java8.entities.Order;

/*
 * Given a List of Order Objects where each Order has orderId, customerName, and List<Item> (with price, quantity):
	Produce a Map<String, Object> containing:
	"totalOrders" = total number of orders
	"totalRevenue" = sum of price×quantity of all items
	"uniqueCustomers" = count of distinct customers
 */
public class Day_95 {

	public static void main(String[] args) {
		
		List<Order> orders = getOrders();
		
		HashMap<String, Object> res = orders.stream().collect(
				Collectors.collectingAndThen(
						Collectors.toList(), 
						lst -> {
							HashMap<String, Object> map = new HashMap<>();

							long totalOrders = lst.stream().count();
							double totalRevenue = lst.stream().flatMap(o -> o.getItems().stream())
									.mapToDouble(i -> i.getQuantity() * i.getPrice()).sum();
							Set<String> uniqueCustomers = lst.stream().map(Order::getCustomerName)
									.collect(Collectors.toSet());

							map.put("totalOrders", totalOrders);
							map.put("totalRevenue", totalRevenue);
							map.put("uniqueCustomers", uniqueCustomers);

							return map;
						}
					)
			);
			res.forEach((key, val) -> {
				System.out.println(key + " => " + val);
			});
	}

	public static List<Order> getOrders() {
		return Arrays.asList(
			    new Order(101, "Alice", Arrays.asList(
			        new Item("Laptop", 75000, 1),
			        new Item("Headphones", 2000, 2)
			    )),
			    new Order(102, "Bob", Arrays.asList(
			        new Item("Shirt", 1200, 3),
			        new Item("Jeans", 2500, 1)
			    )),
			    new Order(103, "Alice", Arrays.asList(
			        new Item("Rice", 80, 10),
			        new Item("Milk", 50, 5)
			    )),
			    new Order(104, "David", Arrays.asList(
			        new Item("Smartphone", 50000, 1)
			    ))
			);

	}

}
