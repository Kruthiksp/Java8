package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Student_Day35;

/*
 * Given a list of Student objects:
 * 	Group students by their department.
 * 	For each department, find the average GPA.
 * 	Also, find the top student (highest GPA) in each department.
 * 	Finally, sort the departments by average GPA (descending order) and print:
 * 		Department -> Average GPA | Top Student
 */
public class Day_35 {

	public static void main(String[] args) {

		List<Student_Day35> students = initializer();

		Map<String, Double> deptAvg = students.stream().collect(
				Collectors.groupingBy(Student_Day35::getDepartment, Collectors.averagingDouble(Student_Day35::getGpa)));

		Map<String, Student_Day35> topperByDept = students.stream()
				.collect(Collectors.groupingBy(Student_Day35::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparingDouble(Student_Day35::getGpa)), Optional::get)));

		deptAvg.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(entity -> {
			String key = entity.getKey();
			Double value = entity.getValue();

			String avgGpa = String.format("%.1f", value);

			Student_Day35 topper = topperByDept.get(key);

			System.out.println(key + " -> " + avgGpa + " | " + topper);

		});

	}

	public static List<Student_Day35> initializer() {
		return Arrays.asList(new Student_Day35("Alice", "CSE", 2021, 9.1), new Student_Day35("Bob", "EEE", 2020, 8.7),
				new Student_Day35("Charlie", "ME", 2019, 7.9), new Student_Day35("David", "CSE", 2022, 8.4),
				new Student_Day35("Eve", "EEE", 2021, 8.0), new Student_Day35("Frank", "ME", 2020, 7.5),
				new Student_Day35("Grace", "CSE", 2019, 8.7), new Student_Day35("Heidi", "EEE", 2022, 8.3),
				new Student_Day35("Ivan", "ME", 2021, 8.2));
	}

}
