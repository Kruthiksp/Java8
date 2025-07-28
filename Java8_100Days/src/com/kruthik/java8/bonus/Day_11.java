package com.kruthik.java8.bonus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Student;

	/**
	 *	Given a List<Student>,
	 *	extract all unique course names (i.e., no duplicates).
	 *	Sort them alphabetically.
	 *	Collect the result into a List<String>.
	 */

public class Day_11 {

	public static void main(String[] args) {

		Student s1 = new Student("Alice", Arrays.asList("Math", "Science", "English"));
		Student s2 = new Student("Bob", Arrays.asList("History", "Math", "Geography"));
		Student s3 = new Student("Charlie", Arrays.asList("Math", "Science"));

		List<Student> students = Arrays.asList(s1, s2, s3);

		List<String> courses = students.stream()
								.flatMap(student -> student.getCourses().stream())
								.distinct()
								.sorted()
								.collect(Collectors.toList()
							);

		System.out.println(courses);
	}
}
