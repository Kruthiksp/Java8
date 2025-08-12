package com.kruthik.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day27;

/**
 * Given a list of Employee objects.
 * 		Group employees by city and then by department.
 * 		For each department in each city, find the average salary.
 * 		Sort the departments in descending order of their overall average salary.
 */
public class Day_27 {

	public static void main(String[] args) {

		List<Employee_Day27> employees = initializer();

		Map<String, Map<String, Double>> groupedAvg = employees.stream().collect(
				Collectors.groupingBy(Employee_Day27::getCity, Collectors.groupingBy(Employee_Day27::getDepartment,
						Collectors.averagingDouble(Employee_Day27::getSalary))));

		LinkedHashMap<String, Object> sortedDepartments = groupedAvg.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entity -> entity.getValue().entrySet().stream()
						.sorted(Map.Entry.<String, Double>comparingByValue().reversed()).collect(Collectors
								.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new)),
						(v1, v2) -> v1, LinkedHashMap::new));

		System.out.println(sortedDepartments);
	}

	public static List<Employee_Day27> initializer() {
		return Arrays.asList(new Employee_Day27("John", "IT", "Delhi", 80000, 2019),
				new Employee_Day27("Alice", "HR", "Delhi", 50000, 2020),
				new Employee_Day27("Bob", "Finance", "Delhi", 90000, 2018),
				new Employee_Day27("David", "IT", "Mumbai", 75000, 2021),
				new Employee_Day27("Eve", "Finance", "Mumbai", 88000, 2019),
				new Employee_Day27("Frank", "HR", "Mumbai", 60000, 2020),
				new Employee_Day27("Grace", "Finance", "Bangalore", 95000, 2017),
				new Employee_Day27("Hank", "IT", "Bangalore", 70000, 2018));
	}

}
