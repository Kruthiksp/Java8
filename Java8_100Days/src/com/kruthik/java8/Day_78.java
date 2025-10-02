package com.kruthik.java8;

import java.util.Arrays;
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

/*
 * Create a custom collector that takes a stream of strings and
 * groups them by their first character,
 * while also counting how many words fall into each group.
 */
public class Day_78 {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("apple", "apricot", "banana", "blueberry", "cherry", "cranberry", "avocado");

		Map<Character, Integer> res = words.stream().collect(new CustomCollector_03());

		System.out.println(res);
	}
}

// 
class CustomCollector_03 implements Collector<String, Map<Character, Integer>, Map<Character, Integer>> {

	@Override
	public Supplier<Map<Character, Integer>> supplier() {
//		return () -> new HashMap<Character, Integer>();
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<Character, Integer>, String> accumulator() {

		return (map, word) -> {
			if (map.containsKey(word.charAt(0))) {
				map.put(word.charAt(0), map.get(word.charAt(0)) + 1);
			} else {
				map.put(word.charAt(0), 1);
			}
		};
	}

	@Override
	public BinaryOperator<Map<Character, Integer>> combiner() {
		return (map1, map2) -> {
			map2.forEach((ch, count) -> {
				map1.merge(ch, count, Integer::sum);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<Character, Integer>, Map<Character, Integer>> finisher() {
		return map -> map;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}
}
