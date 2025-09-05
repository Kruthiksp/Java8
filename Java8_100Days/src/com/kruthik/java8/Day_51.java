package com.kruthik.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Person;

/*
 * Given a List of Person Objects.
 * 	Partition people into 2 groups
 * 		-> Minors 
 * 		-> Adults
 *  Get IntSummaryStatistics for ages.
 *  Collect all unique ages into a Set.
 */
public class Day_51 {

	public static void main(String[] args) {
		List<Person> people = Initializer();

		Map<Boolean, List<Person>> partationByAge = people.stream()
				.collect(Collectors.partitioningBy(person -> person.getAge() >= 18));

		System.out.println("List of Adults:\n---------------");
		partationByAge.entrySet().stream().filter(entity -> entity.getKey()).forEach(entity -> {
			List<Person> value = entity.getValue();
			for (Person p : value) {
				System.out.println(p.getName() + "\t - " + p.getAge());
			}
		});

		System.out.println();

		System.out.println("List of Minors:\n---------------");
		partationByAge.entrySet().stream().filter(entity -> !entity.getKey()).forEach(entity -> {
			List<Person> value = entity.getValue();
			for (Person p : value) {
				System.out.println(p.getName() + "\t - " + p.getAge());
			}
		});

		IntSummaryStatistics intSummery = people.stream().collect(Collectors.summarizingInt(Person::getAge));
		System.out.println();
		System.out.println("Integer Summery: ");
		System.out.println(intSummery + "\n");

		Set<Integer> distinctAge = people.stream().map(Person::getAge).collect(Collectors.toSet());
		System.out.println();
		System.out.println("Distinct Ages: ");
		System.out.println(distinctAge);
	}

	public static List<Person> Initializer() {
		return Arrays.asList(new Person("Alice", 25), new Person("Bob", 17), new Person("Charlie", 30),
				new Person("David", 15), new Person("Eve", 22));

	}

}
