package com.kruthik.java8.entities;

public class Employee {

	private int id;
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

	/**
	 * For Day-50
	 * 
	 * @param id
	 * @param department
	 * @param name
	 * @param salary
	 */
	public Employee(int id, String department, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public String getDepartment() {
		return department;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", department=" + department + ", name=" + name + ", salary=" + salary + "]";
	}

//	@Override
//	public String toString() {
//		return "Employee [department=" + department + ", name=" + name + ", salary=" + salary + "]";
//	}

//	@Override
//	public String toString() {
//		return "Employee [department=" + department + ", name=" + name + "]";
//	}

//	@Override
//	public String toString() {
//		return "Employee [name=" + name + ", salary=" + salary + "]";
//	}

}
