package com.kruthik.java8.entities;

import java.util.List;

public class Student {

	private String name;
	private List<String> courses;

	public Student(String name, List<String> courses) {
		super();
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", courses=" + courses + "]";
	}

}
