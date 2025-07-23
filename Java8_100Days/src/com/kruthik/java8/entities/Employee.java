package com.kruthik.java8.entities;

public class Employee {
	
	private String department;
	private String name;

	public Employee(String department, String name) {
		super();
		this.department = department;
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [department=" + department + ", name=" + name + "]";
	}

}
