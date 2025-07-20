package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of lowercase strings, use Java 8 Stream and map() to convert
 * each string to uppercase and collect the result into a new list.
 */

public class Day_04 {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("java", "spring", "lambda", "stream");

		List<String> res = words.stream().map(word -> word.toUpperCase()).collect(Collectors.toList());

		System.out.println(res);
	}
}
