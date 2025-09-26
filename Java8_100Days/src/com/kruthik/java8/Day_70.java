package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Invoice;

/*
 * Given a List of Invoice Objects.
  	generate a report grouped by category that includes:
		-> Total Revenue for each category
		-> Average Invoice Amount per category
		-> Top Customer (customer who spent the most in that category)
		-> Monthly Breakdown (Map of Month → Total Amount)
 */
public class Day_70 {

	public static void main(String[] args) {
		
		List<Invoice> invoices = getInvoices();

		Map<String, Map<String, Object>> result = invoices.stream().collect(
				Collectors.groupingBy(
						Invoice::getCategory,
						Collectors.collectingAndThen(
								Collectors.toList(),
								categoryInvoice -> {
									double totalRevenue = categoryInvoice.stream().mapToDouble(Invoice::getAmount).sum();
									
									double avgRevenue = categoryInvoice.stream().mapToDouble(Invoice::getAmount).average().orElse(0);
									
									Invoice maxInvoice = categoryInvoice.stream().max(Comparator.comparing(i -> i.getAmount())).orElse(null);
									
									Map<String, Double> monthlyBreakdown = categoryInvoice.stream()
										.collect(
												Collectors.groupingBy(
														Invoice::getMonth,
														Collectors.summingDouble(Invoice::getAmount)));
									
									return Map.of("totalRevenue", totalRevenue,
											"avgRevenue", avgRevenue,
											"maxInvoice", maxInvoice,
											"monthlyBreakdown", monthlyBreakdown);
								})
						)
				);
		
		result.entrySet().forEach(entry -> {
			System.out.println(entry.getKey() + " \t -> " + entry.getValue());
		});
	}
	
	public static List<Invoice> getInvoices() {
        return Arrays.asList(
                new Invoice("Alice", "Electronics", 1200, "Jan"),
                new Invoice("Bob", "Grocery", 800, "Jan"),
                new Invoice("Alice", "Electronics", 1500, "Feb"),
                new Invoice("Charlie", "Grocery", 600, "Feb"),
                new Invoice("Bob", "Clothing", 2000, "Jan"),
                new Invoice("David", "Electronics", 1000, "Mar"),
                new Invoice("Eve", "Clothing", 1500, "Feb"),
                new Invoice("Frank", "Grocery", 1200, "Mar"),
                new Invoice("Alice", "Clothing", 2500, "Mar"),
                new Invoice("Charlie", "Electronics", 1800, "Apr"),
                new Invoice("David", "Grocery", 700, "Apr"),
                new Invoice("Bob", "Electronics", 900, "Feb")
        );
    }
}
