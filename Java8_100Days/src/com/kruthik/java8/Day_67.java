package com.kruthik.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Employee_Day60;

/*
 * Given a List of Employee Objects.
 * 	Generate a report grouped by department
  	Average salary
	Most experienced employee
	Highest paid employee
	Number of employees per city
	And collect the result as Map<String, DepartmentReport>
 */
public class Day_67 {

	public static void main(String[] args) {
		
		List<Employee_Day60> employees = initializer();
		
		Map<String, DepartmentReport> result = employees.stream().collect(
					Collectors.groupingBy(
							Employee_Day60::getDepartment,
							Collectors.collectingAndThen(
								Collectors.toList(),
								deptEmps -> {
									Double avgSal = deptEmps.stream().collect(Collectors.averagingDouble(Employee_Day60::getSalary));
									Employee_Day60 mostExp = deptEmps.stream().max(Comparator.comparingInt(Employee_Day60::getExperience)).orElse(null);
									Employee_Day60 maxSal = deptEmps.stream().max(Comparator.comparingDouble(Employee_Day60::getSalary)).orElse(null);
									long noOfEmps = deptEmps.stream().count();
									
									return new DepartmentReport(avgSal, mostExp, maxSal, Map.of(mostExp.getCity(), noOfEmps));
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

class DepartmentReport {

	private double avgSalary;
	private Employee_Day60 mostExperienced;
	private Employee_Day60 highestPaid;
	private Map<String, Long> employeesPerCity;

	public DepartmentReport(double avgSalary, Employee_Day60 mostExperienced, Employee_Day60 highestPaid,
			Map<String, Long> employeesPerCity) {
		super();
		this.avgSalary = avgSalary;
		this.mostExperienced = mostExperienced;
		this.highestPaid = highestPaid;
		this.employeesPerCity = employeesPerCity;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public Employee_Day60 getMostExperienced() {
		return mostExperienced;
	}

	public Employee_Day60 getHighestPaid() {
		return highestPaid;
	}

	public Map<String, Long> getEmployeesPerCity() {
		return employeesPerCity;
	}

	@Override
	public String toString() {
		return "DepartmentReport [avgSalary=" + avgSalary + ", mostExperienced=" + mostExperienced + ", highestPaid="
				+ highestPaid + ", employeesPerCity=" + employeesPerCity + "]";
	}

}
