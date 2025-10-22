package com.kruthik.java8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a list of Product with category and rating,
	Return a Map<String, Double> containing average rating per category using Collectors.reducing (no averaging collector).
 */
public class Day_98 {

	public static void main(String[] args) {
		
		List<Product> products = Day_92.getProducts();
		
		Map<String, double[]> res = products.stream().collect(
				Collectors.groupingBy(
						Product::getCategory, 
						Collectors.reducing(
								new double[] {0.0, 0.0},
								p -> new double[] {p.getRating(), 1.0},
								(a, b) -> new double[] {a[0] + b[0] , a[1] + b[1]}
						)
					)
				);
		
		res.forEach((category, sumCount) -> {
			double avg = sumCount[0] / sumCount[1];
			System.out.println(category + " -> " + avg);
		});
		
	}

}
