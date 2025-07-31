package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Book;

/*
 * 	Given a list of Book objects,
 *  group the books by author and then collect the book titles (as a list) for each author.
 *  
 */
public class Day_15 {
	
	public static void main(String[] args) {
	
		List<Book> books = Arrays.asList(
			    new Book("Effective Java", "Joshua Bloch"),
			    new Book("Java Concurrency in Practice", "Brian Goetz"),
			    new Book("Clean Code", "Robert C. Martin"),
			    new Book("Java Puzzlers", "Joshua Bloch"),
			    new Book("Clean Architecture", "Robert C. Martin")
			);
		
			Map<String,List<String>> result = books.stream().collect(
					Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getTitle, Collectors.toList())));
			
		System.out.println(result);
	}
}
