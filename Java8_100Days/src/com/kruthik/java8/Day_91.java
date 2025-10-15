package com.kruthik.java8;

import com.kruthik.java8.entities.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * Given a List of Employee Objects.
	-> Group employees by department and extract top 3 highest paid employees in each department
	-> sorted in descending order of salary.
 */
public class Day_91 {

	public static void main(String[] args) {
		
		List<Employee> employees = getEmployees();
		
		Map<String, List<Employee>> res = employees.stream().collect(
				Collectors.groupingBy(
						Employee::getDepartment,
						Collectors.collectingAndThen(
								Collectors.toList(),
								lst -> {
									List<Employee> topSal = lst.stream()
											.sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
											.limit(3)
											.collect(Collectors.toList());
									
									return topSal;
							})
					)
				);
		
		res.forEach((dept, val) -> {
			System.out.println(dept + ": ");
			val.forEach(System.out::println);
			System.out.println();
		});
	}

	public static List<Employee> getEmployees() {
		return Arrays.asList(new Employee("IT", "Alice", 95000), new Employee("IT", "Bob", 87000),
				new Employee("IT", "Charlie", 105000), new Employee("IT", "David", 99000),
				new Employee("HR", "Eve", 60000), new Employee("HR", "Frank", 75000),
				new Employee("HR", "Grace", 70000), new Employee("Finance", "Heidi", 120000),
				new Employee("Finance", "Ivan", 110000), new Employee("Finance", "Judy", 95000));

	}

}
