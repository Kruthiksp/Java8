package com.kruthik.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day24;

	/*
	 *	Given a list of employees, find the average salary for each gender per department.
	 */
public class Day_24 {

	public static void main(String[] args) {
		
		List<Employee_Day24> employees = initializer();

		Map<String, Map<String, Double>> collect = employees.stream()
				.collect(Collectors.groupingBy(Employee_Day24::getDepartment, LinkedHashMap::new, Collectors
						.groupingBy(Employee_Day24::getGender, Collectors.averagingDouble(Employee_Day24::getSalary))));

		System.out.println(collect);
	}

	public static List<Employee_Day24> initializer() {
		return Arrays.asList(new Employee_Day24("IT", "Male", 5000), new Employee_Day24("IT", "Female", 6000),
				new Employee_Day24("HR", "Female", 4500), new Employee_Day24("HR", "Male", 5500),
				new Employee_Day24("Finance", "Female", 7000), new Employee_Day24("Finance", "Male", 6500));
	}
}
