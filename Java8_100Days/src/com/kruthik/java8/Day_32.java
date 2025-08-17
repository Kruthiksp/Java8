package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day27;

/*
 * Given a List of Employee Objects.
 * 	Partition employees into two groups:
 * 		-> Those who joined before 2018
 * 		-> Those who joined in or after 2018
 * 	For each partition, collect the names of employees as a comma-separated string.
 * 
 */
public class Day_32 {

	public static void main(String[] args) {

		List<Employee_Day27> employees = initializer();

		Map<Boolean, String> result = employees.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getYearOfJoining() < 2018,
						Collectors.mapping(Employee_Day27::getName, Collectors.joining(","))));

		System.out.println("Employees joined before 2018:\t"+result.get(true));
		System.out.println("Employees joined from 2018:\t"+result.get(false));
	
	}

	public static List<Employee_Day27> initializer() {
		return Arrays.asList(new Employee_Day27("Alice", "IT", "Bangalore", 75000.0, 2016),
				new Employee_Day27("Bob", "IT", "Delhi", 82000.0, 2019),
				new Employee_Day27("Charlie", "Finance", "Mumbai", 68000.0, 2017),
				new Employee_Day27("David", "Finance", "Delhi", 72000.0, 2021),
				new Employee_Day27("Eve", "HR", "Mumbai", 54000.0, 2015),
				new Employee_Day27("Frank", "HR", "Bangalore", 58000.0, 2020),
				new Employee_Day27("Grace", "Marketing", "Delhi", 60000.0, 2014),
				new Employee_Day27("Hank", "Marketing", "Bangalore", 64000.0, 2018));
	}
}
