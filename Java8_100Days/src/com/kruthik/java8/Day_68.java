package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Order_Day59;

/*
 * Given a List of Order Objects
   	For each city, generate a report containing:
	Total revenue from COMPLETED orders.
	Top 2 customers by total spending in that city.
	Distinct set of products purchased in that city.
	Order status breakdown → count of orders per status.
 */
public class Day_68 {

	public static void main(String[] args) {

		List<Order_Day59> orders = initializer();

		Map<String, CityOrderReport> result = orders.stream().collect(
				Collectors.groupingBy(
						Order_Day59::getCity,
						Collectors.collectingAndThen(
								Collectors.toList(),
								cityOrders -> {
									double totalRevenue = cityOrders.stream()
											.filter(o -> o.getStatus().equals("COMPLETED"))
											.mapToDouble(Order_Day59::getAmount)
											.sum();
									
									List<String> top2Customers = cityOrders.stream().filter(o -> o.getStatus().equals("COMPLETED")).collect(
											Collectors.collectingAndThen(
													Collectors.groupingBy(
															Order_Day59::getCustomerName,
															Collectors.summingDouble(Order_Day59::getAmount)
														),
													customerTotals -> 
														customerTotals.entrySet().stream()
														.sorted(Map.Entry.<String, Double>comparingByValue().reversed())
														.limit(2)
														.map(Map.Entry::getKey)
														.collect(Collectors.toList())
													)
											);
									
									Set<String> distinctProducts = cityOrders.stream().flatMap(o -> o.getItems().stream()).collect(Collectors.toSet());
									
									Map<String, Long> statusBreakdown = cityOrders.stream().collect(Collectors.groupingBy(Order_Day59::getStatus, Collectors.counting()));
									
									return new CityOrderReport(totalRevenue, top2Customers, distinctProducts, statusBreakdown);
								})
						)
				);
		
		result.entrySet().stream().forEach(System.out::println);
	}

	public static List<Order_Day59> initializer() {
		return Arrays.asList(new Order_Day59("O1", "Alice", "Bangalore", 1200, "NEW", Arrays.asList("Laptop", "Mouse")),
				new Order_Day59("O2", "Bob", "Delhi", 800, "COMPLETED", Arrays.asList("Keyboard", "Mouse")),
				new Order_Day59("O3", "Alice", "Bangalore", 1500, "COMPLETED", Arrays.asList("Monitor", "Keyboard")),
				new Order_Day59("O4", "David", "Mumbai", 1800, "CANCELLED", Arrays.asList("Monitor", "Keyboard")),
				new Order_Day59("O5", "Eve", "Mumbai", 2500, "NEW", Arrays.asList("Monitor", "Keyboard")),
				new Order_Day59("O6", "Bob", "Delhi", 750, "COMPLETED", Arrays.asList("Monitor", "Keyboard")),
				new Order_Day59("O7", "Charlie", "Bangalore", 500, "CANCELLED", Arrays.asList("Mouse")));
	}

}

class CityOrderReport {
	double totalRevenue;
	List<String> topCustomers; // only names of top 2 customers
	Set<String> distinctProducts;
	Map<String, Long> statusBreakdown;

	public CityOrderReport(double totalRevenue, List<String> topCustomers, Set<String> distinctProducts,
			Map<String, Long> statusBreakdown) {
		super();
		this.totalRevenue = totalRevenue;
		this.topCustomers = topCustomers;
		this.distinctProducts = distinctProducts;
		this.statusBreakdown = statusBreakdown;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public List<String> getTopCustomers() {
		return topCustomers;
	}

	public Set<String> getDistinctProducts() {
		return distinctProducts;
	}

	public Map<String, Long> getStatusBreakdown() {
		return statusBreakdown;
	}

	@Override
	public String toString() {
		return "CityOrderReport [totalRevenue=" + totalRevenue + ", topCustomers=" + topCustomers
				+ ", distinctProducts=" + distinctProducts + ", statusBreakdown=" + statusBreakdown + "]";
	}

}
