package com.kruthik.java8;

import java.util.List;
import java.util.stream.IntStream;

/*
 * Given a list of Integers.
 * 	Calculate the sum using a sequential stream and measure execution time.
 * 	Calculate the sum using a parallel stream and measure execution time.
 * 	Compare performance and explain when parallel streams are beneficial.
 */
public class Day_47 {

	public static void main(String[] args) {

		List<Integer> numbers = IntStream.rangeClosed(1, 10_00_00_000).boxed().toList();

		long start1 = System.currentTimeMillis();
		int strm = numbers.stream().mapToInt(Integer::intValue).sum();
		long end1 = System.currentTimeMillis();
		System.out.println("Sequential sum = " + strm + ", Time taken = " + (end1 - start1) + " ms");
		
		long start2 = System.currentTimeMillis();
		int parallelStrm = numbers.parallelStream().mapToInt(Integer::intValue).sum();
		long end2 = System.currentTimeMillis();
		System.out.println("Parallel sum = " + parallelStrm + ", Time taken = " + (end2 - start2) + " ms");

	}
}
