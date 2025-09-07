package com.kruthik.java8.entities;

import java.util.List;

public class User {
	
	private int id;
	private String name;
	List<String> emails;

	public User(int id, String name, List<String> emails) {
		super();
		this.id = id;
		this.name = name;
		this.emails = emails;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<String> getEmails() {
		return emails;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", emails=" + emails + "]";
	}

}
