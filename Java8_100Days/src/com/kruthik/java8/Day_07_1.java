package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.kruthik.java8.entities.Product;

/**
 * 	Use Java 8 Streams to find the product with the highest price and print it.
 */
public class Day_07_1 {

	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
			    new Product("Laptop", 50000),
			    new Product("Mouse", 500),
			    new Product("Keyboard", 1200),
			    new Product("Monitor", 8000),
			    new Product("Pen Drive", 750)
			);
		
		Optional<Product> costly = products.stream().max(Comparator.comparing(Product::getPrice));
		
		costly.ifPresent(System.out::println);
		
	}
}
