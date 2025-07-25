package com.kruthik.java8;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 *	Given a Map<String, Integer> representing products and their stock quantities
 *		-> Filter products where the stock is less than 100.
 *		-> Sort the result by stock quantity (ascending).
 *		-> Collect into a new LinkedHashMap (to maintain sort order).
 *		-> Print the result.
 */

public class Day_09 {

	public static void main(String[] args) {
		
		Map<String, Integer> productStock = Map.of(
				"Laptop", 50,
				"Mouse", 150,
				"Keyboard", 85,
				"Monitor", 25,
				"USB Cable", 200
			);
		
		Map<String, Integer> collect = productStock.entrySet().stream()
													.filter(p -> p.getValue() < 100)
													.sorted(Comparator.comparing(Entry::getValue))
													.collect(Collectors.toMap(
															Entry::getKey, 
															Entry::getValue,
															(v1, v2) -> v1 + v2,
															LinkedHashMap::new)
														);
		
		System.out.println(collect);

	}
}

/**
 *	map.entrySet().stream()
 *	map.keySet().stream()
 *	map.values().stream()
 */