package com.kruthik.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Given a List of Integer.
 * 	Find all prime numbers from the list.
 * 	Use both sequential stream and parallel stream to process, and compare their performance.
 * 	Print the time taken for each.
 */
public class Day_48 {

	public static void main(String[] args) {

		List<Integer> nums = IntStream.rangeClosed(1, 10_00_000).boxed().toList();

		long start1 = System.currentTimeMillis();
		List<Integer> prime_1 = nums.stream().filter(num -> Day_48.primeCheck(num)).collect(Collectors.toList());
		long end1 = System.currentTimeMillis();
		System.out
				.println("Sequential Stream found: " + prime_1.size() + " prime numbers in " + (end1 - start1) + "ms");

		long start2 = System.currentTimeMillis();
		List<Integer> prime_2 = nums.parallelStream().filter(num -> Day_48.primeCheck(num))
				.collect(Collectors.toList());
		long end2 = System.currentTimeMillis();
		System.out.println("Parallel Stream found: " + prime_2.size() + " prime numbers in " + (end2 - start2) + "ms");

	}

	public static boolean primeCheck(int num) {
		if (num <= 1)
			return false;

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
