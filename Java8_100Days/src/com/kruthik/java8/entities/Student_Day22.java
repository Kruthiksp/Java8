package com.kruthik.java8.entities;

public class Student_Day22 {

	private String name;
	private int gradeLevel;
	private String subject;
	private int marks;

	public Student_Day22(String name, int gradeLevel, String subject, int marks) {
		super();
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.subject = subject;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public String getSubject() {
		return subject;
	}

	public int getMarks() {
		return marks;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", gradeLevel=" + gradeLevel + ", subject=" + subject + ", marks="
				+ marks + "]";
	}

}
