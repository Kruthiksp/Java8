package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Student_Day35;

/*
 * Given a List of Student Objects.
	Find the average marks of each department.
	Find the student with the highest marks overall.
	Create a Map<String, List<String>> → where key = department, value = list of student names sorted by marks (descending).
 */
public class Day_74 {

	public static void main(String[] args) {

		List<Student_Day35> students = getStudents();

		Map<String, Double> avgByDept = students.stream().collect(
				Collectors.groupingBy(Student_Day35::getDepartment, Collectors.averagingDouble(Student_Day35::getGpa)));
		Student_Day35 topStudent = students.stream().max(Comparator.comparingDouble(Student_Day35::getGpa))
				.orElse(null);
		Map<String, List<String>> sortedName = students.stream()
				.sorted(Comparator.comparing(Student_Day35::getGpa).reversed()).collect(Collectors.groupingBy(
						Student_Day35::getDepartment, Collectors.mapping(Student_Day35::getName, Collectors.toList())));

		System.out.println(avgByDept);
		System.out.println(topStudent);
		System.out.println(sortedName);
		
	}

	public static List<Student_Day35> getStudents() {
		return Arrays.asList(new Student_Day35("Alice", "CSE", 2021, 9.1), new Student_Day35("Bob", "EEE", 2020, 8.7),
				new Student_Day35("Charlie", "ME", 2019, 7.9), new Student_Day35("David", "CSE", 2022, 8.4),
				new Student_Day35("Eve", "EEE", 2021, 8.0), new Student_Day35("Frank", "ME", 2020, 7.5),
				new Student_Day35("Grace", "CSE", 2019, 8.7), new Student_Day35("Heidi", "EEE", 2022, 8.3),
				new Student_Day35("Ivan", "ME", 2021, 8.2));
	}

}
