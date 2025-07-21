package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of strings, sort them in ascending order of their lengths using
 * Java 8 features.
 */

public class Day_05 {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("java", "springboot", "api", "lambda", "stream");

		List<String> sorted = words.stream()
//									.sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
									.sorted(Comparator.comparing(String::length))
									.collect(Collectors.toList());

		System.out.println(sorted);
		
	}
}
