package com.kruthik.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.kruthik.java8.entities.Product;

/*
 * Custom Collector (Intermediate – Grouping + Statistics)
	Create a custom collector that takes a stream of Product objects and returns a Map<String, Map<String, Object>>, where:
	The outer map’s key is the product’s category.
	The inner map contains:
		"totalProducts" → total number of products in that category
		"totalPrice" → sum of all product prices in that category
		"averagePrice" → average price of products in that category
		"maxPriceProduct" → product with the highest price in that category
*/
public class Day_81 {

	public static void main(String[] args) {
		List<Product> products = Day_28.initializer();
		Map<String, Map<String, Object>> res = products.stream().collect(new CustomCollector_06());
		res.forEach((category, stats) -> {
			System.out.println(category + " -> " + stats);
		});
	}

}

class CustomCollector_06
		implements Collector<Product, Map<String, Map<String, Object>>, Map<String, Map<String, Object>>> {

	@Override
	public Supplier<Map<String, Map<String, Object>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<String, Map<String, Object>>, Product> accumulator() {

		return (map, product) -> {
			Map<String, Object> stats = map.computeIfAbsent(product.getCategory(), v -> new HashMap<String, Object>());

			stats.put("count", (int) stats.getOrDefault("count", 0) + 1);
			stats.put("sum", (Double) stats.getOrDefault("sum", 0.0) + product.getPrice());

			Product currentMax = (Product) stats.get("maxPriceProduct");
			if (currentMax == null || product.getPrice() > currentMax.getPrice()) {
				stats.put("maxPriceProduct", product);
			}
		};
	}

	@Override
	public BinaryOperator<Map<String, Map<String, Object>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((category, stats2) -> {
				Map<String, Object> stats1 = map1.computeIfAbsent(category, v -> new HashMap<>());

				// count
				int count1 = (int) stats1.getOrDefault("count", 0);
				int count2 = (int) stats2.getOrDefault("count", 0);
				stats1.put("count", count1 + count2);

				// sum
				double sum1 = (double) stats1.getOrDefault("sum", 0.0);
				double sum2 = (double) stats2.getOrDefault("sum", 0.0);
				stats1.put("sum", sum1 + sum2);

				Product max1 = (Product) stats1.get("maxPriceProduct");
				Product max2 = (Product) stats2.get("maxPriceProduct");
				if (max1 == null || (max2 != null && max2.getPrice() > max1.getPrice())) {
					stats1.put("maxPriceProduct", max2);
				}
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Map<String, Object>>, Map<String, Map<String, Object>>> finisher() {
		return (map) -> {
			map.forEach((category, innerMap) -> {
				double sum = (double) innerMap.get("sum");
				int count = (int) innerMap.get("count");

				innerMap.put("average", sum / count);
			});
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
