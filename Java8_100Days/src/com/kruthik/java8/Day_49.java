package com.kruthik.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * Generate all prime numbers up to N
 * 	Collect the primes into a List.
 * 	Print the total count of primes.
 * 	Print the first 20 primes as a sample.
 * 	Compare execution time with your Day 48 prime-check approach.
 */
public class Day_49 {

	public static void main(String[] args) {

		List<Integer> numbers = IntStream.rangeClosed(0, 100000).boxed().toList();

		long start = System.currentTimeMillis();

		List<Integer> primes = numbers.stream().filter(num -> generatePrime(num)).collect(Collectors.toList());

		long totalPrimes = primes.stream().count();
		System.out.println("Total prime numbers upto 100000 is: " + totalPrimes);

		System.out.println("First 20 primes: ");
		primes.stream().limit(20).forEach(System.out::println);

		long end = System.currentTimeMillis();

		System.out.println("Sieve execution time: " + (end - start) + " ms");
	}

	public static boolean generatePrime(int n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
