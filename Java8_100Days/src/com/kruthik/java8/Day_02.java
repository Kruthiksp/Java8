package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a list of integers, use Java 8 Stream API and map() to square each number and collect the results into a new list.	
*/
public class Day_02 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> squares = numbers.stream().map(i -> i * i).collect(Collectors.toList());

		System.out.println(squares);

	}
}
