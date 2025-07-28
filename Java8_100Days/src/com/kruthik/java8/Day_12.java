package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Department;
import com.kruthik.java8.entities.Employee;

/**
 * You have a list of Department objects Each department has a name and a list of employees.
 * From the list of departments 
 * 		Extract names of employees who have a salary greater than ₹50,000 
 * 		Avoid duplicates (assume multiple departments can have employees with the same name).
 * 		Sort the names alphabetically.
 * 		Collect into a List<String>.
 */

public class Day_12 {

	public static void main(String[] args) {

		List<Department> departments = initializer();

		List<String> collect = departments.stream()
								.flatMap(dept -> dept.getEmployees().stream())
								.filter(emp -> emp.getSalary() > 50000)
								.map(Employee::getName).distinct()
								.sorted(Comparator.reverseOrder())
								.collect(Collectors.toList()
							);

		System.out.println(collect);

	}

	public static List<Department> initializer() {
		Employee e1 = new Employee("Alice", 60000);
		Employee e2 = new Employee("Bob", 45000);
		Employee e3 = new Employee("Charlie", 52000);
		Employee e4 = new Employee("Alice", 60000);

		Department d1 = new Department("IT", Arrays.asList(e1, e2));
		Department d2 = new Department("HR", Arrays.asList(e3, e4));

		return Arrays.asList(d1, d2);
	}
}
