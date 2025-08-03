package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
	You are given a list of Product objects, each with a name and a price. Some products may have the same name but different prices.
		Group the products into a Map<String, Double> where 
			key -> product name
			value -> average price for that product name.
*/
public class Day_18 {

	public static void main(String[] args) {

		Map<String, Double> grouped = groupingProductsToMap();

		System.out.println(grouped);

	}

	public static Map<String, Double> groupingProductsToMap() {

		List<Product> products = initializer();

		return products.stream()
				.collect(Collectors.groupingBy(Product::getName, Collectors.averagingDouble(Product::getPrice)));
	}

	public static List<Product> initializer() {
		return Arrays.asList(new Product("Laptop", 50000), new Product("Mouse", 700), new Product("Laptop", 55000),
				new Product("Mouse", 500), new Product("Keyboard", 1500));
	}

}
