package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a List of Product Objects.
 * 	Group products by category.
	Within each category, find the average price.
	Within each category, find the highest-rated product.
 */
public class Day_75 {

	public static void main(String[] args) {
		
		List<Product> products = getProducts();
		
		Map<String, Map<String, Object>> result = products.stream().collect(
				Collectors.groupingBy(
						Product::getCategory,
						Collectors.teeing(
								Collectors.averagingDouble(Product::getPrice), 
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparingDouble(Product::getRating)),
										opt -> opt.orElse(null)),
								(avg, top) -> Map.of("avgPrice", avg, "topItem", top))
						)
				);
		
		result.entrySet().forEach(System.out::println);
	}

	public static List<Product> getProducts() {
		return Arrays.asList(new Product("Laptop", "Electronics", 75000.0, 4.8),
				new Product("Smartphone", "Electronics", 50000.0, 4.5),
				new Product("Headphones", "Electronics", 2000.0, 4.2), new Product("Apples", "Grocery", 150.0, 4.9),
				new Product("Rice", "Grocery", 80.0, 4.3), new Product("Milk", "Grocery", 50.0, 4.1),
				new Product("Shirt", "Clothing", 1200.0, 4.6), new Product("Jeans", "Clothing", 2500.0, 4.7),
				new Product("Jacket", "Clothing", 3500.0, 4.4));
	}

}
