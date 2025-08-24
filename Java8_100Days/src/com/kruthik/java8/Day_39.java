package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * Given a list of integers
 * 	Use a Predicate to filter and print only even numbers.
 * 	Use a Function to square each number and collect results into a new list.
 * 	Use a Consumer to print each element of the squared list.
 * 	Use a Supplier to generate a random number between 1–100.
 */
public class Day_39 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(10, 25, 30, 45, 50, 65, 70);

		Predicate<Integer> p = n -> n % 2 == 0;
		Function<Integer, Integer> f = n -> n * n;
		Consumer<Integer> c = n -> System.out.println(n);
		Supplier<Integer> s = () -> {

			return (int) Math.floor(Math.random() * 100);
		};

		numbers.stream().filter(p).map(f).forEach(c);
		
		System.out.println("Random Number: " + s.get());
	}
}
