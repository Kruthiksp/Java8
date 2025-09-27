package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee;

/*
 * Given a List of Employee Objects
 * Group employees by department.
	For each department, find the highest-paid employee.
	Collect the results into a Map<String, Employee> where:
		key = department
		value = highest-paid employee.
 */
public class Day_71 {

	public static void main(String[] args) {

		List<Employee> employees = getEmployees();

		Map<String, Employee> result = employees.stream().collect(
				Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
								opt -> opt.orElse(null))
					));
		
		result.entrySet().forEach(System.out::println);
	}

	public static List<Employee> getEmployees() {
		return Arrays.asList(new Employee(1, "IT", "Alice", 70000), new Employee(2, "HR", "Bob", 50000),
				new Employee(3, "IT", "Charlie", 80000), new Employee(4, "Finance", "David", 90000),
				new Employee(5, "HR", "Eve", 60000));
	}

}
