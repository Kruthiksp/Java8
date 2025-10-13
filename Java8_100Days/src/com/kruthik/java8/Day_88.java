package com.kruthik.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a list of Product objects, Group products by category and produce a Map<String, Map<String, Object>> 
	where:
	"minPrice" → minimum price in the category
	"maxPrice" → maximum price in the category
	"averageRating" → average rating of all products in the category
 */
public class Day_88 {

	public static void main(String[] args) {

		List<Product> products = Day_28.initializer();

		Map<String, HashMap<String, Object>> res = products.stream().collect(
				Collectors.groupingBy(
						Product::getCategory,
						Collectors.collectingAndThen(
								Collectors.toList(),
								lst -> {
									HashMap<String, Object> map = new HashMap<>();
									map.put("minPrice", Double.MAX_VALUE);
									map.put("maxPrice", Double.MIN_VALUE);
									map.put("totalRating", 0.0);
									lst.forEach((p) -> {
										if (p.getPrice() < (double)map.get("minPrice")) {
											map.put("minPrice", p.getPrice());
										}
										if (p.getPrice() > (double)map.get("maxPrice")) {
											map.put("maxPrice", p.getPrice());
										}
										map.put("totalRating", (double)map.get("totalRating") + p.getRating());
									});
									double totalRating = (double) map.remove("totalRating");
									map.put("averageRating", totalRating / lst.size());
									return map;
								})
						)
				);
		
		res.forEach((key, val) -> {
			System.out.println(key + " => " + val);
		});
	}

}
