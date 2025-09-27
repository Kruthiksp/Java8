package com.kruthik.java8.entities;

import java.util.List;

public class Project {
	private String projectName;
	private String domain;
	private double budget;
	private List<String> teamMembers;

	public Project(String projectName, String domain, double budget, List<String> teamMembers) {
		this.projectName = projectName;
		this.domain = domain;
		this.budget = budget;
		this.teamMembers = teamMembers;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getDomain() {
		return domain;
	}

	public double getBudget() {
		return budget;
	}

	public List<String> getTeamMembers() {
		return teamMembers;
	}

	@Override
	public String toString() {
		return "Project{" + "projectName='" + projectName + '\'' + ", domain='" + domain + '\'' + ", budget=" + budget
				+ ", teamMembers=" + teamMembers + '}';
	}
}
