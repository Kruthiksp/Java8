package com.kruthik.java8.bonus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee;

public class Day_06 {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
			    new Employee("HR", "Alice"),
			    new Employee("Engineering", "Bob"),
			    new Employee("HR", "Charlie"),
			    new Employee("Engineering", "David"),
			    new Employee("Sales", "Eve")
			);
		
		Map<String, List<Employee>> mappedEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		
		System.out.println(mappedEmployees);
	}
}