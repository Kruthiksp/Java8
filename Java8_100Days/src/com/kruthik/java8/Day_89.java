package com.kruthik.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a list of Product objects, group them by category and then for each category,
	Find the product with the highest rating,
	Collect all the product names in that category into a comma-separated string,
	Calculate the total number of products in that category.
 */
public class Day_89 {

	public static void main(String[] args) {

		List<Product> products = Day_28.initializer();

		Map<String, HashMap<String, Object>> res = products.stream().collect(
				Collectors.groupingBy(
						Product::getCategory,
						Collectors.collectingAndThen(
								Collectors.toList(),
								lst -> {
									LinkedHashMap<String, Object> map = new LinkedHashMap<>();
									
									Product topRated = lst.stream().max(Comparator.comparingDouble(Product::getRating)).get();
									map.put("topRated", topRated);
									
									String productNames = lst.stream().collect(Collectors.mapping(Product::getName, Collectors.joining(",")));
									map.put("productNames", productNames);
									
									long count = lst.stream().count();
									map.put("count", count);
									
									return map;
								})
					)
				);

		res.forEach((key1, val1) -> {
			System.out.println(key1 + ": ");
			val1.forEach((key2, val2) -> {
				System.out.println(key2 + " => " + val2);
			});
			System.out.println();
		});
	}

}
