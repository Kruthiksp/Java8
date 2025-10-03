package com.kruthik.java8;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

/*
 * Write a custom collector that takes a Stream<Integer> and returns a Map<String, Double> with the following keys:
	"positiveSum" → Sum of all positive numbers
	"negativeSum" → Sum of all negative numbers
	"average" → Average of all numbers (positive + negative)
 */
public class Day_79 {
	public static void main(String[] args) {
		Stream<Integer> numbers = Stream.of(10, -5, 20, -15, 30, -25, 50);
		Map<String, Double> res = numbers.collect(new CustomCollector_04());
		System.out.println(res);
	}
}

class CustomCollector_04 implements Collector<Integer, Map<String, Double>, Map<String, Double>> {

	@Override
	public Supplier<Map<String, Double>> supplier() {
		return LinkedHashMap::new;
	}

	@Override
	public BiConsumer<Map<String, Double>, Integer> accumulator() {
		return (map, num) -> {
			if (num > 0) {
				map.put("positiveSum", map.getOrDefault("positiveSum", 0.0) + num);
			} else {
				map.put("negativeSum", map.getOrDefault("negativeSum", 0.0) + num);
			}
			map.put("count", map.getOrDefault("count", 0.0) + 1);
		};
	}

	@Override
	public BinaryOperator<Map<String, Double>> combiner() {
		return (map1, map2) -> {
			map2.forEach((key, val) -> {
				map1.merge(key, val, Double::sum);
			});
			return map1;
		};
	}

	@Override
	public Function<Map<String, Double>, Map<String, Double>> finisher() {
		return map -> {
			Double count = map.remove("count");
			Double nSum = map.get("negativeSum");
			Double pSum = map.get("positiveSum");
			map.put("average", (nSum + pSum) / count);
			return map;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}