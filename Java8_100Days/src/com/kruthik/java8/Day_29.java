package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day27;

/*
 * Given a list of Employee objects
 * 		-> Find the average salary of employees for each department.
 *		-> For each department, find the highest-paid employee.
 *		-> Sort the departments by average salary in descending order and collect the result in a LinkedHashMap where
 *		-> key = department
 *		-> value = a Map.Entry<Double, Employee> (average salary, top employee).
 */
	
public class Day_29 {

	public static void main(String[] args) {

		List<Employee_Day27> initializer = initializer();

		Map<String, Double> avgSalByDept = initializer.stream().collect(Collectors
				.groupingBy(Employee_Day27::getDepartment, Collectors.averagingDouble(Employee_Day27::getSalary)));

		Map<String, Employee_Day27> maxSalByDept = initializer.stream()
				.collect(Collectors.groupingBy(Employee_Day27::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee_Day27::getSalary)), Optional::get)));

		LinkedHashMap<String, Employee_Day27> finalResult = avgSalByDept.entrySet().stream()
				.sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors.toMap(
						Map.Entry::getKey, e -> maxSalByDept.get(e.getKey()), (v1, v2) -> v1, LinkedHashMap::new));

		finalResult.entrySet().stream().forEach(System.out::println);

	}

	public static List<Employee_Day27> initializer() {
		return Arrays.asList(new Employee_Day27("John", "IT", "Bangalore", 75000, 2020),
				new Employee_Day27("Alice", "HR", "Bangalore", 50000, 2019),
				new Employee_Day27("Bob", "IT", "Bangalore", 82000, 2018),
				new Employee_Day27("David", "Finance", "Mumbai", 65000, 2021),
				new Employee_Day27("Eve", "Finance", "Mumbai", 72000, 2017),
				new Employee_Day27("Frank", "HR", "Delhi", 58000, 2020));
	}
}
