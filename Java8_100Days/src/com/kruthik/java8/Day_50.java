package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee;

/*
 * Given a List of Employee Objects.
 * 	Group employees by department using Collectors.groupingBy.
 * 	Find the average salary per department.
 * 	Find the highest-paid employee per department.
 * 	Collect all employee names into a comma-separated string.
 */
public class Day_50 {

	public static void main(String[] args) {

		List<Employee> employees = initializer();

//		1. Group employees by department using Collectors.groupingBy.
		Map<String, List<String>> groupByDept = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("Employees grouped by department: ");
		System.out.println(groupByDept + "\n");

//		2. Find the average salary per department.
		Map<String, Double> avgSalOfDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary per department: ");
		System.out.println(avgSalOfDept + "\n");

//		3. Find the highest-paid employee per department.
		Map<String, String> maxSalEmpOfDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
								emp -> emp.map(Employee::getName).orElse(null))));
		System.out.println("Highest paid employee per department: ");
		System.out.println(maxSalEmpOfDept + "\n");

//		4. Collect all employee names into a comma-separated string.
		String allEmployees = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
		System.out.println("All employees (comma-separated): ");
		System.out.println(allEmployees + "\n");

	}

	public static List<Employee> initializer() {
		return Arrays.asList(new Employee(1, "IT", "Alice", 70000), new Employee(2, "HR", "Bob", 50000),
				new Employee(3, "IT", "Charlie", 80000), new Employee(4, "Finance", "David", 90000),
				new Employee(5, "HR", "Eve", 60000));
	}

}
