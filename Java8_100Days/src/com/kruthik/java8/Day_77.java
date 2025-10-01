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
 * Create a custom collector that,
 * 	Given a stream of integers, 
 * 	Produces a result containing both the sum and the average in a single pass.
 * 
 * NOTE: Don't use IntSummaryStatistics.
 */
public class Day_77 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		Map<String, Double> res = numbers.stream().collect(new CustomCollector_02());

		System.out.println(res);
	}
}

// SumAndAverageCollector
class CustomCollector_02 implements Collector<Integer, double[], Map<String, Double>> {

	@Override
	public Supplier<double[]> supplier() {
		return () -> new double[2];
	}

	@Override
	public BiConsumer<double[], Integer> accumulator() {
		return (arr, num) -> {
			arr[0] += num;
			arr[1] += 1;
		};
	}

	@Override
	public BinaryOperator<double[]> combiner() {
		return (arr1, arr2) -> {
			arr1[0] += arr2[0];
			arr1[1] += arr2[1];
			return arr1;
		};
	}

	@Override
	public Function<double[], Map<String, Double>> finisher() {
		return arr -> {
			HashMap<String, Double> res = new HashMap<>();
			res.put("sum", arr[0]);
			res.put("avg", arr[1] == 0 ? 0.0 : arr[0] / arr[1]);
			return res;
		};
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}
