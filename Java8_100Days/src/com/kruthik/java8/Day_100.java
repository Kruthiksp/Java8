package com.kruthik.java8;

import java.util.Comparator;
import java.util.List;

import com.kruthik.java8.entities.Employee;

/*
 * Given a list of Employee objects, find the N-th highest salary using stream API (no loops, no sorting twice).
 */
public class Day_100 {

	public static void main(String[] args) {
		
		List<Employee> employees = Day_91.getEmployees();

		int n = 3;

		Employee nthHighestSal = employees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.skip(n - 1).findFirst().orElse(null);

		System.out.println(nthHighestSal);
	}

}
