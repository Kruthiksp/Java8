package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

	/*
	 * 	Given a list of integers, use Java 8 Stream API to filter out the even numbers and collect them into a new list.
	*/
public class Day_01 {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

		System.out.println("Even Numbers: " + evenNumbers);
	}
}
