package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

	/**
	 * Given a list of Product Object,
	 * 	-> Filter the products that cost more than ₹1000
	 * 	-> sort them in Descending order of price
	 * 	-> Collect the result into a new List<Product>
	 * 	-> Print the filtered list
	 */

public class Day_07 {
	
	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
				    new Product("Laptop", 50000),
				    new Product("Mouse", 500),
				    new Product("Keyboard", 1200),
				    new Product("Monitor", 8000),
				    new Product("Pen Drive", 750)
				);
		
		List<Product> filteredProducts = products.stream()
													.filter(p -> p.getPrice() > 1000)
													.sorted(Comparator.comparing(Product::getPrice).reversed())
													.collect(Collectors.toList());
		
		filteredProducts.forEach(System.out::println);

	}
}
