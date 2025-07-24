package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/**
 *	You have a list of Product objects with unique names.
 *	Convert this list into a Map<String, Double> where:
 *		-> Key = Product name
 *		-> Value = Product price
 *	If product names are duplicated --- Use merge function
 */

public class Day_08 {
	
	public static void main(String[] args) {
		
		List<Product> products = Arrays.asList(
			    new Product("Laptop", 50000),
			    new Product("Laptop", 60000),
			    new Product("Mouse", 500),
			    new Product("Keyboard", 1200),
			    new Product("Monitor", 8000),
			    new Product("Pen Drive", 750)
			);
		
			Map<String, Double> collectedMap = products.stream()
														.collect(
																Collectors.toMap(
																		Product::getName,	//Key Mapper
																		Product::getPrice,	// Value mapper
																		(price1, price2) -> (price1 + price2) / 2));	// Merge Function
																														// Executes only in case of common Keys
			
			System.out.println(collectedMap);
	}
}
/*
	If product names could be duplicated, you'd need a merge function:
---------------------------------------------------------------------------
	.collect(Collectors.toMap(
		    Product::getName,
		    Product::getPrice,
		    (price1, price2) -> price1 // or price2 or average
		));
*/
