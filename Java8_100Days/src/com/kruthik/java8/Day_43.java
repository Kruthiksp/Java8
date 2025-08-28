package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day_43 {

	public static void main(String[] args) {

		List<Employee> employees = initializer();

//		1. Safe emails with fallback if null
		List<String> emails = employees.stream()
				.map(emp -> Optional.ofNullable(emp.getEmail()).orElse("Email Not Found")).collect(Collectors.toList());

		System.out.println("Safe emails = " + emails);

//		2. Find first employee whose email starts with 'c'
		Optional<Employee> firstC = employees.stream().filter(emp -> Optional.ofNullable(emp.getEmail())
				.map(mail -> mail.toLowerCase().startsWith("c")).orElse(false)).findFirst();

		String firstCEmail = firstC.map(Employee::getEmail).map(String::toUpperCase).orElse("No employee found");
		
		System.out.println("\nFirst employee with email starting with 'c' → " + firstCEmail);
		

//		3. Count employees with email present
		long countWithEmail = employees.stream().filter(e -> Optional.ofNullable(e.getEmail()).isPresent()).count();
		System.out.println("\nTotal employees with email = " + countWithEmail);
	}

	public static List<Employee> initializer() {
		return Arrays.asList(new Employee("Alice", "alice@example.com"), new Employee("Bob", null),
				new Employee("Charlie", "charlie@example.com"), new Employee("David", null));
	}
}

class Employee {

	private String name;
	private String email;

	public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + "]";
	}

}
