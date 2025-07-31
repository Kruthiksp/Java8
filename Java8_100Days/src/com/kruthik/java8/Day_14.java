package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Item;
import com.kruthik.java8.entities.Order;

/*
 * You are given a list of Order objects. Each Order has:
 *		An id
 *		A List<Item> called items
 *	Each Item has:
 *		String name
 *		double price
 *
 *	Flatten all items from all orders
 *	Group the items by their name
 *	Calculate the total price for each item name
 *	Store the result in a Map<String, Double> where key = item name, value = total price
 */

public class Day_14 {

	public static void main(String[] args) {

		List<Order> orders = initializer();

		Map<String, Double> result = orders.stream().flatMap(order -> order.getItems().stream())
				.collect(Collectors.groupingBy(Item::getName, Collectors.summingDouble(Item::getPrice)));

		System.out.println(result);

	}

	public static List<Order> initializer() {
		Item item1 = new Item("Pen", 10);
		Item item2 = new Item("Notebook", 40);
		Item item3 = new Item("Pencil", 5);
		Item item4 = new Item("Eraser", 3);

		List<Item> list1 = Arrays.asList(item1, item2);
		List<Item> list2 = Arrays.asList(item3, item4);

		Order order1 = new Order(1, list1);
		Order order2 = new Order(2, list2);

		return Arrays.asList(order1, order2);
	}
}
