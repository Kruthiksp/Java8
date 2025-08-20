package com.kruthik.java8.entities;

public class Student_Day35 {

	private String name;
	private String department;
	private int year;
	private double gpa;

	public Student_Day35(String name, String department, int year, double gpa) {
		super();
		this.name = name;
		this.department = department;
		this.year = year;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public int getYear() {
		return year;
	}

	public double getGpa() {
		return gpa;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", department=" + department + ", year=" + year + ", gpa=" + gpa + "]";
	}

}
