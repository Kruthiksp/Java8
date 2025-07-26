package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction;

/**
 *	Given a list of Transaction objects
 *		-> Group the transactions by category
 *		-> Find the total amount spent in each category
 *		-> Store the result in a Map<String, Double>
 *		-> Print the final grouped totals
 */


public class Day_10 {

	public static void main(String[] args) {

		List<Transaction> transactions = Arrays.asList(
			    new Transaction("Food", 150),
			    new Transaction("Travel", 300),
			    new Transaction("Food", 100),
			    new Transaction("Shopping", 250),
			    new Transaction("Travel", 200)
			);
		
			Map<String, Double> res = transactions.stream()
														.collect(Collectors.groupingBy(Transaction::getCategory,
																						Collectors.summingDouble(Transaction::getAmount)
																					)
																			);
		System.out.println(res);
	}
}
