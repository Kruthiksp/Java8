package com.kruthik.java8;

import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given a String,
	Return a Map<Character, Long> that counts occurrences of each character (ignore case and spaces).
 */
public class Day_94 {

	public static void main(String[] args) {
		String sentance = "Java Stream API Rocks";

		Map<Character, Long> res = sentance
				.chars()	// Create an IntStream from the string's characters
				.mapToObj(c -> (char) c)	// Convert int values to Character
				.map(Character::toLowerCase)
				.filter(c -> c != ' ')
				.collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		
		res.forEach((ch, freq) -> {
			System.out.println(ch + " => " + freq);
		});
		
	}

}
