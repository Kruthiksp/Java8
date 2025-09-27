package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Transaction_Day63;

/*
 * Given a List of Transaction Objects
  	Calculate the total credit amount.
	Calculate the total debit amount.
	Find the transaction with the maximum amount.
	Partition the transactions into credit and debit groups using Collectors.partitioningBy.
 */
public class Day_72 {

	public static void main(String[] args) {
		
		List<Transaction_Day63> txns = getTransactions();
		
		Map<String, Object> result = txns.stream().collect(
				Collectors.teeing(
						Collectors.filtering(
								txn -> txn.getType().equals("CREDIT"), 
								Collectors.summingDouble(Transaction_Day63::getAmount)),
						Collectors.teeing(
								Collectors.filtering(
										txn -> txn.getType().equals("DEBIT"), 
										Collectors.summingDouble(Transaction_Day63::getAmount)),
								Collectors.teeing(
										Collectors.collectingAndThen(
												Collectors.maxBy(Comparator.comparingDouble(Transaction_Day63::getAmount)),
												opt -> opt.orElse(null)),
										Collectors.partitioningBy(txn -> txn.getType().equals("CREDIT")),
										(maxTxn, partition) -> {
											Map<String, Object> inner1 = new HashMap<>();
											inner1.put("maxTxn", maxTxn);
											inner1.put("partition", partition);
											return inner1;
										}),
								(debitTotal, inner1) -> {
									Map<String, Object> inner2 = new HashMap<>(inner1);
									inner2.put("debitTotal", debitTotal);
									return inner2;
								}),
						(creditTotal, inner2) -> {
							Map<String, Object> finalMap = new HashMap<>(inner2);
							finalMap.put("creditTotal", creditTotal);
							return finalMap;
						})
			);
		
		result.entrySet().forEach(System.out::println);
	}
	
	public static List<Transaction_Day63> getTransactions() {
		return Arrays.asList(
				new Transaction_Day63("TXN001", "CREDIT", 2300.0, "Bangalore"),
				new Transaction_Day63("TXN002", "CREDIT", 7000.0, "Mumbai"),
				new Transaction_Day63("TXN003", "DEBIT", 4500.0, "Mumbai"),
				new Transaction_Day63("TXN004", "CREDIT", 4300.0, "Bangalore"),
				new Transaction_Day63("TXN005", "CREDIT", 8000.0, "Bangalore"),
				new Transaction_Day63("TXN006", "DEBIT", 5200.0, "Delhi"),
				new Transaction_Day63("TXN007", "CREDIT", 3100.0, "Delhi"),
				new Transaction_Day63("TXN008", "DEBIT", 2900.0, "Bangalore")
			);

	}

}
