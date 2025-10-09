package com.kruthik.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.kruthik.java8.entities.Product;

/*
 * Create a custom collector that takes a stream of Product objects and collects them into a
	Map<String, Map<String, Object>>, where:
	Outer Map key -> Category of the product
	Inner Map should contain:
		"totalPrice" -> sum of prices of products in that category
		"averagePrice" -> average price in that category
		"productNames" -> comma-separated string of product names in that category (in insertion order)
 */
public class Day_85 {

	public static void main(String[] args) {

		List<Product> products = Day_28.initializer();
		Map<String, Map<String, Object>> res = products.stream().collect(new CustomCollector_10());
		res.forEach((key, val) -> {
			System.out.println(key + " -> " + val);
		});
	}

}

class CustomCollector_10
		implements Collector<Product, Map<String, Map<String, Object>>, Map<String, Map<String, Object>>> {

	@Override
	public Supplier<Map<String, Map<String, Object>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<String, Map<String, Object>>, Product> accumulator() {
		return (map, product) -> {
			Map<String, Object> newCategory = map.computeIfAbsent(product.getCategory(),
					v -> new HashMap<String, Object>());
			double totalPrice = (double) newCategory.getOrDefault("totalPrice", 0.0);
			int count = (int) newCategory.getOrDefault("count", 0);
			StringJoiner productNames = (StringJoiner) newCategory.getOrDefault("productNames", new StringJoiner(", "));

			newCategory.put("totalPrice", totalPrice + product.getPrice());
			newCategory.put("count", count + 1);
			newCategory.put("productNames", productNames.add(product.getName()));
		};
	}

	@Override
	public BinaryOperator<Map<String, Map<String, Object>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((category2, stats2) -> {

				Map<String, Object> stats1 = map1.computeIfAbsent(category2, v -> new HashMap<String, Object>());

				double totalPrice1 = (double) stats1.getOrDefault("totalPrice", 0.0);
				double totalPrice2 = (double) stats2.getOrDefault("totalPrice", 0.0);
				stats1.put("totalPrice", totalPrice1 + totalPrice2);

				int count1 = (int) stats1.getOrDefault("count", 0);
				int count2 = (int) stats2.getOrDefault("count", 0);
				stats1.put("count", count1 + count2);

				StringJoiner sj1 = (StringJoiner) stats1.getOrDefault("productNames", new StringJoiner(", "));
				StringJoiner sj2 = (StringJoiner) stats2.getOrDefault("productNames", new StringJoiner(", "));
				stats1.put("productNames", sj1.toString() + sj2.toString());

			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Map<String, Object>>, Map<String, Map<String, Object>>> finisher() {
		return map -> {
			map.forEach((category, stats) -> {
				double price = (double) stats.get("totalPrice");
				int count = (int) stats.remove("count");
				Object products = (StringJoiner) stats.remove("productNames");

				stats.put("averagePrice", (price / count));
				stats.put("productNames", products.toString());
			});
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
