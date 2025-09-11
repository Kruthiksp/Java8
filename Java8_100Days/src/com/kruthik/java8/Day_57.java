package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
	Given a list of products
		Group products by category.
		For each category:
			-> Collect all product names into a comma-separated String (e.g., "TV, Laptop, Phone").
			-> Find the average price.
		Return a Map<String, Map<String, Object>>
*/
public class Day_57 {

	public static void main(String[] args) {
		List<Product> products = initializer();

		Map<String, Map<String, Object>> res = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory,
						Collectors.teeing(Collectors.mapping(Product::getName, Collectors.joining(", ")),
								Collectors.averagingDouble(Product::getPrice),
								(join, avg) -> Map.of("Products", join, "average", avg))));

		res.entrySet().stream().forEach(entity -> {
			String key = entity.getKey();
			Map<String, Object> value = entity.getValue();

			System.out.println(key + " -> " + value);
		});

	}

	public static List<Product> initializer() {
		return Arrays.asList(new Product("Laptop", "Electronics", 75000.0, 4.8),
				new Product("Smartphone", "Electronics", 50000.0, 4.5),
				new Product("Headphones", "Electronics", 2000.0, 4.2), new Product("Apples", "Grocery", 150.0, 4.9),
				new Product("Rice", "Grocery", 80.0, 4.3), new Product("Milk", "Grocery", 50.0, 4.1),
				new Product("Shirt", "Clothing", 1200.0, 4.6), new Product("Jeans", "Clothing", 2500.0, 4.7),
				new Product("Jacket", "Clothing", 3500.0, 4.4));
	}
}
