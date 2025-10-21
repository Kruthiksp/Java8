package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given a list of words, Return a Map<Integer, List<String>> 
 * where:
 * 	key = length, 
 * 	value = sorted list of words with that length.
 */
public class Day_96 {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("cat", "dog", "banana", "apple", "kiwi", "cherry", "mango", "pear", "grape");

		Map<Integer, List<String>> res = wordList.stream().collect(
				Collectors.groupingBy(
						String::length,
						Collectors.collectingAndThen(
							Collectors.toList(),
							lst -> {
								return lst.stream().sorted().collect(Collectors.toList());
							})
					)
			);
		res.forEach((len, words) -> {
			System.out.println(len + " -> " + words);
		});
	}

}
