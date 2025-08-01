package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Department;
import com.kruthik.java8.entities.Employee;


/*
 * 	You are given a list of Department objects. 
 *		Each department has a name and a list of Employee objects.
 *	 	Each employee has a name, department, and salary.
 *	
 *	From all employees in all departments:
 *		Group employees by department name.
 *		For each department, find the highest-paid employee.
 *		Return a Map<String, Employee> where key is department name, and value is the highest-paid employee of that department.	
 *
 */

public class Day_16 {

	public static void main(String[] args) {

		List<Department> departments = initializer();

		Map<String, Employee> collect = departments.stream().flatMap(dept -> dept.getEmployees().stream())
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.collectingAndThen(
						Collectors.maxBy(Comparator.comparing(Employee::getSalary)), Optional::get)));

		System.out.println(collect);
	}

	public static List<Department> initializer() {
		Employee e1 = new Employee("IT", "Alice", 60000);
		Employee e2 = new Employee("IT", "Bob", 45000);
		Employee e3 = new Employee("HR", "Charlie", 52000);
		Employee e4 = new Employee("HR", "Alice", 60000);

		Department d1 = new Department("IT", Arrays.asList(e1, e2));
		Department d2 = new Department("HR", Arrays.asList(e3, e4));

		return Arrays.asList(d1, d2);
	}
}
