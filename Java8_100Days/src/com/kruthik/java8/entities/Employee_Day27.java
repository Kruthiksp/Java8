package com.kruthik.java8.entities;

public class Employee_Day27 {

	private String name;
	private String department;
	private String city;
	private double salary;
	private int yearOfJoining;

	public Employee_Day27(String name, String department, String city, double salary, int yearOfJoining) {
		super();
		this.name = name;
		this.department = department;
		this.city = city;
		this.salary = salary;
		this.yearOfJoining = yearOfJoining;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getCity() {
		return city;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearOfJoining() {
		return yearOfJoining;
	}

	@Override
	public String toString() {
		return "Employee_Day27 [name=" + name + ", department=" + department + ", city=" + city + ", salary=" + salary
				+ ", yearOfJoining=" + yearOfJoining + "]";
	}

}
