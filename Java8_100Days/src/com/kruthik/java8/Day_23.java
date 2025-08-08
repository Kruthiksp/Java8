package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day23;

/*
	You have a list of Transaction objects:
	create a map where:
		Key → City name
		Value → List of transaction types in that city where the total amount is greater than 1000
*/
public class Day_23 {

	public static void main(String[] args) {
		List<Transaction_Day23> transactions = initializer();

		Map<String, Map<String, List<Transaction_Day23>>> collect = transactions.stream()
				.filter(transaction -> transaction.getAmount() > 1000)
				.collect(Collectors.groupingBy(Transaction_Day23::getCity,
						Collectors.groupingBy(Transaction_Day23::getType, Collectors.toList())));

		System.out.println(collect);
	}

	public static List<Transaction_Day23> initializer() {
		return Arrays.asList(new Transaction_Day23("Bangalore", "Grocery", 500),
				new Transaction_Day23("Bangalore", "Electronics", 1700),
				new Transaction_Day23("Bangalore", "Stationery", 200), new Transaction_Day23("Delhi", "Grocery", 1500),
				new Transaction_Day23("Delhi", "Electronics", 300), new Transaction_Day23("Delhi", "Stationery", 900));
	}
}
