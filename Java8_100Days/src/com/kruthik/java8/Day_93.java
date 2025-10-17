package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Given a List<String> words,
	Return a Set<String> containing only duplicate elements (case-sensitive) using streams.
 */
public class Day_93 {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("apple", "banana", "orange", "apple", "kiwi", "banana", "grape", "kiwi");

		Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
		
		Set<String> res = freq.entrySet().stream()
				.filter(entry -> entry.getValue() > 1)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());

		System.out.println(res);
	}

}
