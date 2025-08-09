package com.kruthik.java8.entities;

public class Employee_Day24 {

	private String department;
	private String gender;
	private double salary;

	public Employee_Day24(String department, String gender, double salary) {
		super();
		this.department = department;
		this.gender = gender;
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public String getGender() {
		return gender;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee_Day24 [department=" + department + ", gender=" + gender + ", salary=" + salary + "]";
	}

}
