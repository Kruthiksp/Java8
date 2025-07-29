package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Department;
import com.kruthik.java8.entities.Employee;

public class Day_13 {

	public static void main(String[] args) {

		List<Department> departments = initializer();

		Map<String, List<Employee>> filteredMap = departments.stream()
				.collect(Collectors.toMap(Department::getName, dept -> dept.getEmployees().stream()
						.filter(emp -> emp.getSalary() > 60000).collect(Collectors.toList())));

		Map<String, List<String>> result = filteredMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
				entry -> entry.getValue().stream().map(Employee::getName).sorted().collect(Collectors.toList())));

		System.out.println(result);
	}

	public static List<Department> initializer() {
		Employee e1 = new Employee("Alice", 63000);
		Employee e2 = new Employee("Charlie", 82000);
		Employee e3 = new Employee("Bob", 55000);
		Employee e4 = new Employee("David", 95000);

		Department d1 = new Department("IT", Arrays.asList(e1, e2));
		Department d2 = new Department("HR", Arrays.asList(e3, e4));

		return Arrays.asList(d1, d2);
	}

}
