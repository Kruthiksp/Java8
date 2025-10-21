package com.kruthik.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Product;

/*
 * Given a list of Product objects,
	Return a Map<String, Product> where key is category and value is the product with max price in that category.
 */
public class Day_97 {

	public static void main(String[] args) {
		List<Product> products = Day_92.getProducts();
		Map<String, Product> res = products.stream().collect(
				Collectors.groupingBy(
						Product::getCategory,
						Collectors.collectingAndThen(
								Collectors.toList(),
								lst -> {
									return lst.stream().max(Comparator.comparingDouble(Product::getPrice)).get();
								})
					)
			);
		
		res.forEach((category, expensiveProduct) -> {
			System.out.println(category + " -> " + expensiveProduct);
		});
	}

}
