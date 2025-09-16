package com.kruthik.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day60;

/*
 * Given a List of Employee Object.
 * 	Write a Java 8 program that groups employees by their city and, for each city, calculates:
		-> Average salary
		-> List of distinct departments
		-> The name of the most experienced employee in that city
	Return the result as a Map<String, CityReport> where CityReport is a custom class (or record) that holds:
		-> double avgSalary
		-> List<String> departments
		-> String mostExperiencedEmp
 */
public class Day_62 {

	public static void main(String[] args) {
		List<Employee_Day60> employees = initializer();

		Map<String, CityReport> result = employees.stream().collect(Collectors
				.groupingBy(Employee_Day60::getCity,
						Collectors.teeing(
								Collectors.averagingDouble(Employee_Day60::getSalary),
								Collectors.teeing(
										Collectors.mapping(Employee_Day60::getDepartment, Collectors.toSet()),
										Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee_Day60::getExperience)),
												opt -> opt.orElse(null)),
										(depts, maxExp) -> Map.entry(depts, maxExp)),
								(avgSal, entry) -> {
									return new CityReport(avgSal, entry.getKey(), entry.getValue());
								})
						)
			);
		
		result.entrySet().stream().forEach(System.out::println);
	}

	public static List<Employee_Day60> initializer() {
		return List.of(new Employee_Day60("Alice", "IT", 70000, 5, "New York"),
				new Employee_Day60("Bob", "Finance", 85000, 7, "New York"),
				new Employee_Day60("Charlie", "IT", 60000, 4, "Chicago"),
				new Employee_Day60("David", "HR", 50000, 6, "Chicago"),
				new Employee_Day60("Eve", "Finance", 90000, 8, "New York"),
				new Employee_Day60("Frank", "HR", 45000, 3, "Chicago"));
	}

}

class CityReport {
	double avgSalary;
	Set<String> departments;
	Employee_Day60 mostExperiencedEmp;

	public CityReport(double avgSalary, Set<String> departments, Employee_Day60 mostExperiencedEmp) {
		super();
		this.avgSalary = avgSalary;
		this.departments = departments;
		this.mostExperiencedEmp = mostExperiencedEmp;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}

	public Set<String> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<String> departments) {
		this.departments = departments;
	}

	public Employee_Day60 getMostExperiencedEmp() {
		return mostExperiencedEmp;
	}

	public void setMostExperiencedEmp(Employee_Day60 mostExperiencedEmp) {
		this.mostExperiencedEmp = mostExperiencedEmp;
	}

	@Override
	public String toString() {
		return "CityReport [avgSalary=" + avgSalary + ", departments=" + departments + ", mostExperiencedEmp="
				+ mostExperiencedEmp + "]";
	}

}
