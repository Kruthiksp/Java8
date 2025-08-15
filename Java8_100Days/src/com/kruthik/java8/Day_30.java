package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Book;

	/*
	 * Given a List of Book Objects
	 * 	-> Group the books by genre.
	 * 	-> For each genre:
	 * 		->Find the average price of books.
	 * 		->Find the most recently published book.
	 * 	-> Sort the genres by average price in descending order
	 */

public class Day_30 {

	public static void main(String[] args) {

		List<Book> books = initializer();

		Map<String, Double> avgByGenre = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.averagingDouble(Book::getPrice)));

		Map<String, Book> latestBookByGenre = books.stream().collect(Collectors.groupingBy(Book::getGenre,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Book::getYear)), Optional::get)));

		avgByGenre.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.forEach(entity -> {
					String genre = entity.getKey();
					double avgPrice = entity.getValue();
					Book book = latestBookByGenre.get(genre);
					System.out.println(genre + " -> " + avgPrice + " | " + book.getTitle());
				});
	}

	public static List<Book> initializer() {
		return Arrays.asList(new Book("The Silent Patient", "Alex Michaelides", "Thriller", 450.0, 2019),
				new Book("The Guest List", "Lucy Foley", "Thriller", 380.0, 2020),
				new Book("Educated", "Tara Westover", "Memoir", 500.0, 2018),
				new Book("Becoming", "Michelle Obama", "Memoir", 650.0, 2019),
				new Book("Atomic Habits", "James Clear", "Self-help", 550.0, 2018),
				new Book("The 5 AM Club", "Robin Sharma", "Self-help", 420.0, 2020),
				new Book("Dune", "Frank Herbert", "Science Fiction", 700.0, 1965),
				new Book("Project Hail Mary", "Andy Weir", "Science Fiction", 850.0, 2021));
	}
}
