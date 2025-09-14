package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day60;

/*
 * Given a group of Employee Objects.
	Group employees by department and within each department:
		-> Find the highest paid employee.
		-> Find the average salary.
		-> Find the most experienced employee.
	Collect the result in a Map<String, Map<String, Object>>, where:
		-> Key = Department name
		-> Value = Map with keys "highestPaid", "averageSalary", "mostExperienced"
 */
public class Day_60 {
	public static void main(String[] args) {
		List<Employee_Day60> employees = initializer();
		Map<String, Map<String, Object>> result = employees.stream().collect(Collectors
				.groupingBy(Employee_Day60::getDepartment,
						Collectors.collectingAndThen(
								Collectors.teeing(
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparingDouble(Employee_Day60::getSalary)), Optional::get),
										Collectors.teeing(
												Collectors.averagingDouble(Employee_Day60::getSalary), 
												Collectors.collectingAndThen(
														Collectors.maxBy(Comparator.comparingInt(Employee_Day60::getExperience)), Optional::get),
												(avg, maxExp) -> Map.of("avgSal", avg, "maxExp", maxExp)),
										(maxSal, map) -> {
											HashMap<String, Object> finalMap = new HashMap<>(map);
											finalMap.put("maxSal", maxSal);
											return finalMap;
										}),
								Function.identity()))
				);
		
		result.entrySet().stream().forEach(entity -> {
			String key = entity.getKey();
			Map<String,Object> value = entity.getValue();
			
			System.out.println(key);
			value.entrySet().stream().forEach(entity2 -> {
				Object value2 = entity2.getValue();
				if(value2 instanceof Employee_Day60) {
					value2 = ((Employee_Day60) value2).getName();
				}
				System.out.println(entity2.getKey() + ": " + value2);
			});
			System.out.println();
		});
	}

	public static List<Employee_Day60> initializer() {
		return Arrays.asList(new Employee_Day60("Alice", "IT", 70000, 5), new Employee_Day60("Bob", "HR", 50000, 3),
				new Employee_Day60("Charlie", "IT", 80000, 7), new Employee_Day60("David", "IT", 60000, 2),
				new Employee_Day60("Eve", "HR", 55000, 4), new Employee_Day60("Frank", "Finance", 90000, 8),
				new Employee_Day60("Grace", "Finance", 85000, 6));
	}
}
