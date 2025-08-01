package com.kruthik.java8.entities;

public class Employee {

	private String department;
	private String name;
	private double salary;

	public Employee(String department, String name) {
		super();
		this.department = department;
		this.name = name;
	}

	/**
	 * For Day-12
	 * 
	 * @param name
	 * @param salary
	 */

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public Employee(String department, String name, double salary) {
		super();
		this.department = department;
		this.name = name;
		this.salary = salary;
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

//	@Override
//	public String toString() {
//		return "Employee [department=" + department + ", name=" + name + "]";
//	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

}
