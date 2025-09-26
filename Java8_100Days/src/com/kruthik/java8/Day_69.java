package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Project;
/*
 * Given a List of Projects Object
  	Generate a DomainReport for each domain containing:
		-> Total budget allocated to that domain
		-> Average budget per project
		-> Project with the maximum budget
		-> Unique team members working in that domain
 */
public class Day_69 {

	public static void main(String[] args) {

		List<Project> projects = getProjects();

		Map<String, DomainReport> result = projects.stream().collect(
				Collectors.groupingBy(
						Project::getDomain,
						Collectors.collectingAndThen(
								Collectors.toList(),
								domainProjects -> {
								double totalBudget = domainProjects.stream()
										.mapToDouble(Project::getBudget)
										.sum();
								
								double avgBudget = domainProjects.stream()
										.mapToDouble(Project::getBudget)
										.average()
										.orElse(0);
								
								Project maxBudgetProject = domainProjects.stream()
										.max(Comparator.comparingDouble(Project::getBudget))
										.orElse(null);
								
								Set<String> teamMembers = domainProjects.stream().flatMap(p -> p.getTeamMembers().stream()).collect(Collectors.toSet());
								
								return new DomainReport(totalBudget, avgBudget, maxBudgetProject, teamMembers);
						})
					)
				);
		
		result.entrySet().stream().forEach( entry -> {
			String key = entry.getKey();
			DomainReport value = entry.getValue();
			System.out.println(key + " \t " + value);
		});

	}

	public static List<Project> getProjects() {
		return Arrays.asList(new Project("AI_Chatbot", "AI", 150000, Arrays.asList("Alice", "Bob")),
				new Project("AI_Recommendation", "AI", 100000, Arrays.asList("Eve", "Alice")),
				new Project("TradingSystem", "Finance", 120000, Arrays.asList("Charlie", "David")),
				new Project("FraudDetection", "Finance", 60000, Arrays.asList("David")),
				new Project("PatientPortal", "Healthcare", 120000, Arrays.asList("Frank", "Alice")),
				new Project("ECom_Platform", "E-Commerce", 200000, Arrays.asList("George", "Hannah")),
				new Project("ECom_Analytics", "E-Commerce", 180000, Arrays.asList("Hannah", "Bob")));
	}

}

class DomainReport {

	private double totalBudget;
	private double avgBudget;
	private Project maxBudgetProject;
	private Set<String> teamMembers;

	public DomainReport(double totalBudget, double avgBudget, Project maxBudgetProject, Set<String> teamMembers) {
		this.totalBudget = totalBudget;
		this.avgBudget = avgBudget;
		this.maxBudgetProject = maxBudgetProject;
		this.teamMembers = teamMembers;
	}

	@Override
	public String toString() {
		return "DomainReport [totalBudget=" + totalBudget + ", avgBudget=" + avgBudget + ", maxBudgetProject="
				+ (maxBudgetProject != null ? maxBudgetProject.getProjectName() : "None") + ", teamMembers="
				+ teamMembers + "]";
	}
}
