package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee;

/*
	Given a List of Employee Object
		Group employees by department.
		Find the average salary of each department.
		Partition employees into high earners (salary > 50,000) and others.
*/
public class Day_45 {

	public static void main(String[] args) {

		List<Employee> employees = initializer();
		
//		1. Group employees by department.
//		2. Find the average salary of each department.
		Map<String, Double> grouped = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("Average salary of each department: ");
		grouped.entrySet().stream().forEach(System.out::println);
		
//		3. Partition employees into high earners (salary > 50,000) and others.
		Map<Boolean, List<Employee>> separatedBySal = employees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getSalary() > 50000));

		System.out.println("\nSalary Above 50,000: ");
		separatedBySal.entrySet().stream().filter(entity -> entity.getKey()).forEach(entity -> {
			entity.getValue().stream().forEach(System.out::println);
		});

		System.out.println("\nSalary Less Than 50,000: ");
		separatedBySal.entrySet().stream().filter(entity -> !entity.getKey()).forEach(entity -> {
			entity.getValue().stream().forEach(System.out::println);
		});
	}

	public static List<Employee> initializer() {
		return Arrays.asList(new Employee("IT", "Alice", 60000), new Employee("IT", "Bob", 45000),
				new Employee("HR", "Charlie", 52000), new Employee("HR", "Alice", 60000));
	}
}
