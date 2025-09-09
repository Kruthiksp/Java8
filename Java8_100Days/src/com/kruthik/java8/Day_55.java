package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day36;
/*
 * Given a List of Transaction Objects.
 * Find the sum of amounts and max Transaction using teeing.
 */
public class Day_55 {
	public static void main(String[] args) {
		List<Transaction_Day36> txns = initializer();

		Map<String, Object> res = txns.stream()
				.collect(Collectors.teeing(Collectors.summingDouble(Transaction_Day36::getAmount),
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparingDouble(Transaction_Day36::getAmount)),
								Optional::get),
						(total, max) -> Map.of("total", total, "max", max)));

		res.entrySet().stream().forEach(System.out::println);
	}

	private static List<Transaction_Day36> initializer() {
		return Arrays.asList(new Transaction_Day36("Alice", "T1", 1200.0, "ONLINE"),
				new Transaction_Day36("Alice", "T2", 800.0, "OFFLINE"),
				new Transaction_Day36("Bob", "T3", 500.0, "ONLINE"),
				new Transaction_Day36("Bob", "T4", 2200.0, "OFFLINE"),
				new Transaction_Day36("Charlie", "T5", 1500.0, "ONLINE"),
				new Transaction_Day36("Charlie", "T6", 700.0, "OFFLINE"));
	}
}
