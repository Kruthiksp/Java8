package com.kruthik.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/*
 * Given a List of Integers.
 * 	Collect them as a ';' separated String.
 * 	using Custom collector.
 */
public class Day_76 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		String res = numbers.stream().collect(new CustomCollector_01());
		System.out.println(res);
	}

}

// ----------------------------------------------------------------------------------------
// SemicolonJoiningCollector
class CustomCollector_01 implements Collector<Integer, StringJoiner, String> {

	@Override
	public Supplier<StringJoiner> supplier() {
		return () -> new StringJoiner(";", "[", "]");
	}

	@Override
	public BiConsumer<StringJoiner, Integer> accumulator() {
		return (sj, num) -> sj.add(String.valueOf(num));
	}

	// Required in Parallel Stream
	@Override
	public BinaryOperator<StringJoiner> combiner() {
		return null;
	}

	@Override
	public Function<StringJoiner, String> finisher() {
		return StringJoiner::toString;
	}

	@Override
	public Set<Characteristics> characteristics() {
		return Collections.emptySet();
	}

}