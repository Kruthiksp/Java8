package com.kruthik.java8.bonus;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * 	sort the resulting of Day_18 map by average price in descending order 
 * 	and 
 * 	collect it into a LinkedHashMap to preserve that order?
 */
public class Day_18 {

	public static void main(String[] args) {

		Map<String, Double> groupedMap = com.kruthik.java8.Day_18.groupingProductsToMap();

		Map<String, Double> sorted = groupedMap.entrySet().stream()
				.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

		System.out.println(sorted);
	}
}
