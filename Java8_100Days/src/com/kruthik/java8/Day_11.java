package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Item;
import com.kruthik.java8.entities.Order;

/**
 *	You have a list of Order objects.
 *	Each order contains a list of Items.
 *	create a List<String> containing the names of all items from all orders.
 */

public class Day_11 {

	public static void main(String[] args) {

		Item item1 = new Item("Pen", 10);
		Item item2 = new Item("Notebook", 40);
		Item item3 = new Item("Pencil", 5);
		Item item4 = new Item("Eraser", 3);

		List<Item> list1 = Arrays.asList(item1, item2);
		List<Item> list2 = Arrays.asList(item3, item4);

		Order order1 = new Order(1, list1);
		Order order2 = new Order(2, list2);

		List<Order> orders = Arrays.asList(order1, order2);

		List<String> collect = orders.stream()
								.flatMap(order -> order.getItems().stream())
								.map(Item::getName)
								.collect(Collectors.toList());

		System.out.println(collect);

	}
}
