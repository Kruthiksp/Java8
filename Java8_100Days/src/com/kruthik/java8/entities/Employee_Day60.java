package com.kruthik.java8.entities;

public class Employee_Day60 {
	private String name;
	private String department;
	private double salary;
	private int experience;

	public Employee_Day60(String name, String department, double salary, int experience) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.experience = experience;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public double getSalary() {
		return salary;
	}

	public int getExperience() {
		return experience;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", salary=" + salary + ", experience="
				+ experience + "]";
	}

}
