package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Person;

/**
 * Given a list of Person Object,
 * 	Sort the list of Person objects by age in ascending order
 * 	Then by name in alphabetical order if ages are equal
 */

public class Day_06 {

	public static void main(String[] args) {

		List<Person> people = Arrays.asList(
			    new Person("Alice", 30),
			    new Person("Bob", 25),
			    new Person("Charlie", 25),
			    new Person("David", 35)
			);

		List<Person> sortedPeople = people.stream()
											.sorted(Comparator.comparing(Person::getAge)
											.thenComparing(Person::getName))
											.collect(Collectors.toList());
		
		System.out.println(sortedPeople);
		
	}
}
