package com.kruthik.java8;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/*
 * Create a custom collector that takes a stream of String values and collects them into a Map<Character, String>
	where:
	key -> first character of the string.
	value -> comma-separated string containing all words that start with that character.
 */
public class Day_84 {

	public static void main(String[] args) {

		Stream<String> words = Stream.of("apple", "banana", "apricot", "blueberry", "cherry", "avocado");
		Map<Character, String> res = words.collect(new CustomCollector_09());
		res.forEach((key, val) -> {
			System.out.println(key + " -> " + val);
		});
	}

}

class CustomCollector_09 implements Collector<String, Map<Character, StringJoiner>, Map<Character, String>> {

	@Override
	public Supplier<Map<Character, StringJoiner>> supplier() {
		return HashMap::new;
	}

	@Override
	public BiConsumer<Map<Character, StringJoiner>, String> accumulator() {
		return (map, word) -> {
			map.computeIfAbsent(word.charAt(0), v -> new StringJoiner(", ")).add(word);
		};
	}

	@Override
	public BinaryOperator<Map<Character, StringJoiner>> combiner() {
		return (map1, map2) -> {
			map2.forEach((ch, words) -> {
				map1.computeIfAbsent(ch, v -> words);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<Character, StringJoiner>, Map<Character, String>> finisher() {
		return map -> {
			HashMap<Character, String> res = new HashMap<Character, String>();

			map.forEach((ch, sj) -> {
				res.put(ch, sj.toString());
			});
			return res;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
