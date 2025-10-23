package com.kruthik.java8;

import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order;

/*
 * Given List<Order> each with List<Item>,
	Flatten all items across orders and compute the total price (price × quantity) of all items.
 */
public class Day_99 {

	public static void main(String[] args) {

		List<Order> orders = Day_95.getOrders();

		List<Double> res = orders.stream()
				.flatMap(o -> o.getItems().stream())
				.map(i -> i.getPrice() * i.getQuantity())
				.collect(Collectors.toList());
		System.out.println(res);

	}

}
