package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day60;

/*
 * Given a List of Employee Objects.
 * 	Partition employees into two groups:
		-> Experienced (experience >= 5 years)
		-> Less Experienced (experience < 5 years)
	For each partition, calculate two things at once (use teeing):
		-> Total Salary
		-> Highest Paid Employee
	Return a Map<Boolean, Map<String, Object>>, where:
		-> true - Experienced employees
		-> false - Less experienced employees.
 */
public class Day_61 {

	public static void main(String[] args) {

		List<Employee_Day60> employees = initializer();

		Map<Boolean, Map<String, Object>> result = employees.stream().collect(
				Collectors.partitioningBy(
						emp -> emp.getExperience()>=5,
						Collectors.teeing(
								Collectors.summingDouble(Employee_Day60::getSalary),
								Collectors.collectingAndThen(
										Collectors.maxBy(Comparator.comparing(Employee_Day60::getSalary)),
										opt -> opt.orElse(null)),
								(totalSalary, highestPaid) -> Map.<String, Object>of("totalSalary", totalSalary, "highestPaid", highestPaid))
					)
			);
		
		result.entrySet().stream().forEach(System.out::println);
	}

	public static List<Employee_Day60> initializer() {
		return Arrays.asList(new Employee_Day60("Alice", "IT", 70000, 5), new Employee_Day60("Bob", "HR", 50000, 3),
				new Employee_Day60("Charlie", "IT", 80000, 7), new Employee_Day60("David", "IT", 60000, 2),
				new Employee_Day60("Eve", "HR", 55000, 4), new Employee_Day60("Frank", "Finance", 90000, 8),
				new Employee_Day60("Grace", "Finance", 85000, 6));
	}

}
