package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Filter only the odd numbers, Square each of those odd numbers and 
 * Collect the result into a new list
 */

public class Day_03 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> res = numbers.stream().filter(i -> i % 2 == 1).map(i -> i * i).collect(Collectors.toList());
		
		System.out.println(res);
	}
}
