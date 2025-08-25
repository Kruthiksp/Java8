package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * Use Predicate to filter employees whose names:
 * 		-> Start with "A" or "D".
 * 		-> And have length greater than 3.
 * Use Function chaining to:
 * 		-> Convert each name to uppercase.
 * 		-> Then append " - Employee".
 * Use Consumer chaining to print each processed name in two ways:
 * 		-> First just print the name.
 * 		-> Then print "Processed: <name>".
 */

public class Day_40 {

	public static void main(String[] args) {

		List<String> employees = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank");

		Predicate<String> p1 = name -> name.startsWith("A");
		Predicate<String> p2 = name -> name.startsWith("D");

		Function<String, String> f1 = name -> name.toUpperCase();
		Function<String, String> f2 = name -> name.concat(" - Employee");

		Consumer<String> c1 = name -> System.out.println(name);
		Consumer<String> c2 = name -> System.out.println("Processed Name: " + name);

		List<String> filteredEmployees = employees.stream().filter(p1.or(p2)).collect(Collectors.toList());
		List<String> uppercaseNames = employees.stream().filter(p1.or(p2)).map(f1.andThen(f2))
				.collect(Collectors.toList());

		System.out.println("Filtered Names:\n------------------");
		filteredEmployees.stream().forEach(c1.andThen(c2));
		System.out.println("\nUppercase Names:\n------------------");
		uppercaseNames.stream().forEach(c1.andThen(c2));
	}
}
