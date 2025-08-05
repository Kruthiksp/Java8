package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Department;
import com.kruthik.java8.entities.Employee;

/*
 * You are given a list of Department objects.
 * 		Each department has a name and a list of Employee objects. Each employee has a name and salary.	
 * 		Find the department name that has the highest average salary.
 */
public class Day_20 {

	public static void main(String[] args) {
		
		List<Department> departments = initializer();
		
		Map<String,Double> collect = departments.stream()
				.collect(Collectors
						.toMap(Department::getName, 
								dept -> dept.getEmployees().stream()
								.collect(Collectors.averagingDouble(Employee::getSalary))
								));
		
		String res = collect.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("No Department");
		
		System.out.println(res);
	}

	public static List<Department> initializer() {
		Employee e1 = new Employee("Alice", 95000);
		Employee e2 = new Employee("Charlie", 65000);
		Employee e3 = new Employee("Bob", 72000);
		Employee e4 = new Employee("David", 63000);

		Department d1 = new Department("IT", Arrays.asList(e1, e2));
		Department d2 = new Department("HR", Arrays.asList(e3, e4));

		return Arrays.asList(d1, d2);
	}
}
