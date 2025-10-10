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
 * Create a custom collector that takes a stream of Product objects and returns a
	Map<String, Product>, where:
	key -> product’s category
	value -> product with the highest rating in that category
 */

public class Day_86 {

	public static void main(String[] args) {
		List<Product> products = Day_28.initializer();
		Map<String, Product> res1 = products.parallelStream().collect(new CustomCollector_11());
		res1.forEach((key, val) -> {
			System.out.println(key + " -> " + val);
		});
	}

}

class CustomCollector_11 implements Collector<Product, Map<String, Product>, Map<String, Product>> {

	@Override
	public Supplier<Map<String, Product>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<String, Product>, Product> accumulator() {
		return (map, product) -> {
			Product currentMaxProduct = map.computeIfAbsent(product.getCategory(), v -> product);

			if (product.getRating() > currentMaxProduct.getRating())
				map.put(product.getCategory(), product);
		};
	}

	@Override
	public BinaryOperator<Map<String, Product>> combiner() {
		return (map1, map2) -> {
			map2.forEach((category, maxProduct2) -> {
				Product maxProduct1 = map1.computeIfAbsent(category, v -> maxProduct2);
				if (maxProduct2.getRating() > maxProduct1.getRating()) {
					map1.put(category, maxProduct2);
				}
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Product>, Map<String, Product>> finisher() {
		return map -> map;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}