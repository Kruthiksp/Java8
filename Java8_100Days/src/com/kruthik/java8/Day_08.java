package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
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
			    new Product("Mouse", 500),
			    new Product("Keyboard", 1200),
			    new Product("Pen Drive", 850),
			    new Product("Monitor", 8000),
			    new Product("Laptop", 80000),
			    new Product("Pen Drive", 750)
			);
		
			Map<String, Double> collectedMap = products.stream()
														.sorted(Comparator.comparing(Product::getPrice).reversed())
														.collect(Collectors.toMap(
																		Product::getName,
																		Product::getPrice,
																		(price1, price2) -> (price1 + price2) / 2
																	)
																);
			
			System.out.println(collectedMap);
	}
}
/**
 * 	If product names could be duplicated, you'd need a merge function
 * 	And To maintain the Insertion Order we have to use LinkedHashMap
 * 
 * 	These are only 4 parameters that can be used inside toMap().
 * 
 *---------------------------------------------------------------------------
 *	.collect(Collectors.toMap(
 *		    Product::getName,	// Key Mapping.
 *		    Product::getPrice,	// Value Mapping.
 *		    (price1, price2) -> (price1 + price2)/2,	// Merge Function, Executes when Keys are duplicated(Instead of throwing IllegalStateException).
 *			LinkedHashMap::new	// To specify which Implementation Class of Map do we need based on our requirement.
 *		));
 *
 *
 *	LinkedHashMap::new 		and 	() -> new LinkedHashMap()	are equal
 */
