package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day27;
	/*
	 * Given a list of Employee objects
	 * 	Group employees by department and find the total salary per department.
	 * 	From each department, find the employee with the lowest salary.
	 * 	Print departments sorted by total salary (descending) along with the employee having the lowest salary in that department.
	 */
public class Day_37 {

	public static void main(String[] args) {
		List<Employee_Day27> employees = initializer();

		Map<String, Double> deptTotal = employees.stream().collect(Collectors.groupingBy(Employee_Day27::getDepartment,
				Collectors.summingDouble(Employee_Day27::getSalary)));

		Map<String, Employee_Day27> minSalaryEmp = employees.stream()
				.collect(Collectors.groupingBy(Employee_Day27::getDepartment, Collectors.collectingAndThen(
						Collectors.minBy(Comparator.comparingDouble(Employee_Day27::getSalary)), Optional::get)));

		deptTotal.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEach(entity -> {
			String key = entity.getKey();
			Double value = entity.getValue();
			
			Employee_Day27 employee_Day27 = minSalaryEmp.get(key);
			
			System.out.println(key + " - " + value +" | "+ employee_Day27);
			
		});
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
