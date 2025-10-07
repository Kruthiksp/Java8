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
 * Create a custom collector that takes a stream of Product objects and groups them by category, while also computing three statistics per category:
	Total number of products, Total price, Average rating
	Finally, return a Map<String, Map<String, Object>> with category as the key and the inner map containing these 3 statistics.
 */
public class Day_83 {

	public static void main(String[] args) {
		List<Product> products = Day_28.initializer();
		Map<String, Map<String, Object>> res = products.stream().collect(new CustomCollector_08());
		res.forEach((key, val) -> {
			System.out.println(key);
			System.out.println(val);
		});
	}

}

class CustomCollector_08
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
			stats.put("totalPrice", (double) stats.getOrDefault("totalPrice", 0.0) + product.getPrice());
			stats.put("totalRating", (double) stats.getOrDefault("totalRating", 0.0) + product.getRating());
		};
	}

	@Override
	public BinaryOperator<Map<String, Map<String, Object>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((category, stats2) -> {
				Map<String, Object> stats1 = map1.computeIfAbsent(category, v -> new HashMap<>());

				int count1 = (int) stats1.getOrDefault("count", 0);
				int count2 = (int) stats2.getOrDefault("count", 0);
				stats1.put("count", count1 + count2);

				double totalPrice1 = (double) stats1.getOrDefault("totalPrice", 0.0);
				double totalPrice2 = (double) stats2.getOrDefault("totalPrice", 0.0);
				stats1.put("totalPrice", totalPrice1 + totalPrice2);

				double totalRating1 = (double) stats1.getOrDefault("totalRating", 0.0);
				double totalRating2 = (double) stats2.getOrDefault("totalRating", 0.0);
				stats1.put("totalRating", totalRating1 + totalRating2);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Map<String, Object>>, Map<String, Map<String, Object>>> finisher() {
		return map -> {
			map.forEach((category, stats) -> {
				int count = (int) stats.get("count");
				double rating = (double) stats.remove("totalRating");

				stats.put("avgRating", rating / count);
			});
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
