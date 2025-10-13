package com.kruthik.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/*
 * Write a custom collector that collects a stream of strings into a Map<Integer, List<String>>,
	where:
	key -> length of the string
	value -> list of all strings of that length, sorted in alphabetical order.
 */
public class Day_87 {

	public static void main(String[] args) {

		Stream<String> words = Stream.of("apple", "bat", "ball", "ant", "cat", "banana", "car", "dog", "zebra", "axe");

		Map<Integer, List<String>> res = words.collect(new CustomCollector_12());

		res.forEach((key, val) -> {
			System.out.println(key + " => " + val);
		});
	}
}

class CustomCollector_12 implements Collector<String, Map<Integer, TreeSet<String>>, Map<Integer, List<String>>> {

	@Override
	public Supplier<Map<Integer, TreeSet<String>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<Integer, TreeSet<String>>, String> accumulator() {
		return (map, word) -> {
			map.computeIfAbsent(word.length(), v -> new TreeSet<String>()).add(word);
		};
	}

	@Override
	public BinaryOperator<Map<Integer, TreeSet<String>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((len, lst) -> {
				TreeSet<String> set = map1.computeIfAbsent(len, v -> new TreeSet<String>());
				set.addAll(lst);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<Integer, TreeSet<String>>, Map<Integer, List<String>>> finisher() {
		return (map) -> {
			HashMap<Integer, List<String>> res = new HashMap<Integer, List<String>>();
			map.forEach((len, lst) -> {
				res.put(len, List.copyOf(lst));
			});
			return res;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
