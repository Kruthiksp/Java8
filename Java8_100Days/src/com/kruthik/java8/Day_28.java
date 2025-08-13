package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a List of Product Objects
 * 		-> Group the products by category.
 * 		-> For each category, find the product with the highest rating.
 * 		-> Sort the categories by average price (descending).
 */
public class Day_28 {

	public static void main(String[] args) {

		List<Product> products = initializer();

		Map<String, Double> avgPriceByCategory = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

		Map<String, Product> highestRatedProductByCategory = products.stream()
				.collect(Collectors.groupingBy(Product::getCategory, Collectors
						.collectingAndThen(Collectors.maxBy(Comparator.comparing(Product::getRating)), Optional::get)));

		LinkedHashMap<String, Entry<Double, Product>> sortedMap = avgPriceByCategory.entrySet().stream()
				.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey,
						e -> Map.entry(e.getValue(), highestRatedProductByCategory.get(e.getKey())), (v1, v2) -> v1,
						LinkedHashMap::new));

		sortedMap.forEach((category, info) -> {
			Double avgPrice = info.getKey();
			Product topProduct = info.getValue();
			System.out.println(category + " → Avg Price: " + avgPrice + ", Top Rated: " + topProduct.getName()
					+ " (Rating: " + topProduct.getRating() + ")");
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
