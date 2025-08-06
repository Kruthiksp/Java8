package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Item;
import com.kruthik.java8.entities.Order;

/*
 * 	You are given a list of Order objects. Each Order contains a list of Items.
 * 	Compute the total quantity sold for each item category across all orders.
 * 
 */
public class Day_21 {

	public static void main(String[] args) {

		List<Order> orders = initializer();

		Map<String, Integer> res = orders.stream().flatMap(order -> order.getItems().stream())
				.collect(Collectors.groupingBy(Item::getCategory, Collectors.summingInt(Item::getQuantity)));

		System.out.println(res);
	}

	public static List<Order> initializer() {

		Item i1 = new Item("Pen", "Stationery", 10);
		Item i2 = new Item("Notebook", "Stationery", 5);
		Item i3 = new Item("Mouse", "Electronics", 7);
		Item i4 = new Item("Keyboard", "Electronics", 15);
		Item i5 = new Item("Apple", "Grocery", 3);
		Item i6 = new Item("Banana", "Grocery", 5);

		Order o1 = new Order(1, Arrays.asList(i1, i3, i5));
		Order o2 = new Order(2, Arrays.asList(i2, i4, i6));

		return Arrays.asList(o1, o2);

	}
}

/*
 * Summarizing Example:
 * ---------------------
 		Map<String, IntSummaryStatistics> summarizing = orders.stream().flatMap(order -> order.getItems().stream())
				.collect(Collectors.groupingBy(Item::getCategory, Collectors.summarizingInt(Item::getQuantity)));

		LinkedHashMap<String, Integer> res2 = summarizing.entrySet().stream().collect(
				Collectors.toMap(Map.Entry::getKey, entity -> (int) entity.getValue().getSum(), (v1, v2) -> v1,LinkedHashMap::new));

		System.out.println(res1);
		System.out.println(summarizing);
 */



