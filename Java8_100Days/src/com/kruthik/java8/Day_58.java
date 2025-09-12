package com.kruthik.java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collector;

import com.kruthik.java8.entities.Employee;

/*
 * Collects employees into a Map<String, Double> where:
		Key = Department
		Value = Total salary in that department
	Achieve this without using Collectors.groupingBy() (write your own logic). 
 */
public class Day_58 {

	public static void main(String[] args) {

		List<Employee> employees = initializer();

		Map<String, Double> res = employees.stream().collect(Collector.of(
//				Supplier
				(Supplier<Map<String, Double>>) HashMap::new, // Explicit Type Casting
//				Accumulator
				(map, emp) -> {
					map.merge(emp.getDepartment(), emp.getSalary(), Double::sum);
				},
//				Combiner	-> Combiner is useful only when using parallel Stream
				(map1, map2) -> {
					map2.forEach((k, v) -> map1.merge(k, v, Double::sum));
					return map1;
				} /* , */

//				Optional
		/* Collector.Characteristics.UNORDERED */
		));

		System.out.println(res);
	}

	public static List<Employee> initializer() {
		return Arrays.asList(new Employee(1, "IT", "Alice", 60000), new Employee(2, "IT", "Bob", 45000),
				new Employee(3, "HR", "Charlie", 52000), new Employee(4, "HR", "Alice", 60000));
	}
}
