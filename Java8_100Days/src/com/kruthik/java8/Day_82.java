package com.kruthik.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
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
 * Create a custom collector that takes a stream of Product objects and returns a Map<String, List<Product>>,
 * where:
	key -> category of the product.
	value -> list of only those products whose rating ≥ 4.5, 
	And Sorted the values by price descending.
 */
public class Day_82 {

	public static void main(String[] args) {
		List<Product> products = Day_28.initializer();
		Map<String, List<Product>> res = products.stream().collect(new CustomCollector_07());
		res.forEach((key, val) -> {
			System.out.println(key);
			System.out.println(val);
		});
	}

}

class CustomCollector_07 implements Collector<Product, Map<String, List<Product>>, Map<String, List<Product>>> {

	@Override
	public Supplier<Map<String, List<Product>>> supplier() {
		return LinkedHashMap::new;
	}

	@Override
	public BiConsumer<Map<String, List<Product>>, Product> accumulator() {
		return (map, product) -> {
			List<Product> lst = map.computeIfAbsent(product.getCategory(), v -> new ArrayList<>());
			if (product.getRating() >= 4.5) {
				lst.add(product);
			}
		};
	}

	@Override
	public BinaryOperator<Map<String, List<Product>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((category, products) -> {
				List<Product> lst1 = map1.computeIfAbsent(category, v -> new ArrayList<>());
				lst1.addAll(products);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, List<Product>>, Map<String, List<Product>>> finisher() {
		return map -> {
			map.forEach((category, products) -> {
				Collections.sort(products, Comparator.comparing(Product::getPrice).reversed());
			});
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}