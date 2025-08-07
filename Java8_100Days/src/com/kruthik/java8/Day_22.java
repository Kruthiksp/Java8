package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Student_Day22;

/*
 * Given a list of Student objects, each having:
 * Group the students by gradeLevel,
 * within each grade, group them by subject,
 * and calculate the average marks for each subject.
 */
public class Day_22 {

	public static void main(String[] args) {

		List<Student_Day22> students = initializer();

		Map<Integer, Map<String, Double>> result = students.stream()
				.collect(Collectors.groupingBy(Student_Day22::getGradeLevel,
						Collectors.groupingBy(Student_Day22::getSubject,
							Collectors.averagingInt(Student_Day22::getMarks)
						)
					));

		System.out.println(result);
	}

	public static List<Student_Day22> initializer() {
		return Arrays.asList(
				new Student_Day22("Alice", 10, "Math", 85),
				new Student_Day22("Bob", 10, "Math", 78),
				new Student_Day22("Charlie", 10, "Science", 90),
				new Student_Day22("David", 11, "Math", 88),
				new Student_Day22("Eve", 11, "Science", 76),
				new Student_Day22("Frank", 11, "Math", 94)
			);
	}

}
