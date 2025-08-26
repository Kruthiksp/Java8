package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Person;

/*
 * Given a list of numbers:
 * 	-> Use a static method reference to check if a number is even.
 * 	-> Use an instance method reference to print each number.
 * 	-> Use a constructor reference to convert the list of strings into a list of Employee objects.
 */
public class Day_41 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(5, 12, 8, 21, 30, 7);

//		Static method reference
		List<Integer> even = numbers.stream().filter(UtilClass::extractEven).collect(Collectors.toList());
		System.out.println(even);

//		Instance method reference
		System.out.println("Printing numbers: ");
		numbers.stream().forEach(n -> new UtilClass().printNumbers(n));

//		Constructor reference
		BiFunction<String, Integer, Person> createPerson = Person::new;

		Person p1 = createPerson.apply("Bob", 41);
		Person p2 = createPerson.apply("Alice", 25);

		System.out.println(p1);
		System.out.println(p2);
	}

}

class UtilClass {

	public static boolean extractEven(int number) {
		if (number % 2 == 0)
			return true;
		return false;
	}

	public void printNumbers(int number) {
		System.out.println(number);
	}

}
