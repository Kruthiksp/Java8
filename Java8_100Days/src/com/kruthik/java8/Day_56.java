package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee;

/*
 * Given a List of Employee Objects.
	Group employees by department.
	For each department, compute:
		-> The total salary.
		-> The employee with the highest salary.
	Return the result as a Map<String, Map<String, Object>> like
 */
public class Day_56 {

	public static void main(String[] args) {

		List<Employee> employees = initializer();

		Map<String, Map<String, Object>> res = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.teeing(Collectors.summingDouble(Employee::getSalary),
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get),
								(sum, max) -> Map.of("total", sum, "max", max))));

		res.entrySet().stream().forEach(System.out::println);
	}

	public static List<Employee> initializer() {
		return Arrays.asList(new Employee(1, "IT", "Alice", 60000), new Employee(2, "IT", "Bob", 45000),
				new Employee(3, "HR", "Charlie", 52000), new Employee(4, "HR", "Alice", 60000));
	}
}
