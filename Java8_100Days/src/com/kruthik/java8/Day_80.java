package com.kruthik.java8;

import java.util.ArrayList;
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
import java.util.stream.Stream;

/*
 * Create a custom collector that takes a Stream<String> and collects it into a Map<Integer, List<String>>
 * 	The key is the length of the string.
 * 	The value is a list of all strings with that length.
 */
public class Day_80 {

	public static void main(String[] args) {
		Stream<String> words = Stream.of("Java", "Spring", "Go", "Python", "JS", "Rust", "HTML", "CSS");
		Map<Integer, List<String>> res = words.collect(new CustomCollector_05());
		res.forEach((i, lst) -> System.out.println(i + ": " + lst));
	}

}

class CustomCollector_05 implements Collector<String, Map<Integer, List<String>>, Map<Integer, List<String>>> {

	@Override
	public Supplier<Map<Integer, List<String>>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<Integer, List<String>>, String> accumulator() {
		return (map, word) -> {
			int key = word.length();
			map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
		};
	}

	@Override
	public BinaryOperator<Map<Integer, List<String>>> combiner() {
		return (map1, map2) -> {
			map2.forEach((i, lst) -> {
				map1.merge(i, lst, (oldLst, newLst) -> {
					oldLst.addAll(newLst);
					return oldLst;
				});
			});
			return map1;
		};
	}

	@Override
	public Function<Map<Integer, List<String>>, Map<Integer, List<String>>> finisher() {
		return map -> map;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
