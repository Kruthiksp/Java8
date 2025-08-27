package com.kruthik.java8;

import java.util.Optional;
import java.util.Scanner;

/*
 * Given a method:
 * 	-> Wrap the result of getEmailByUsername() in an Optional.
 * 	-> Print the email if present, otherwise print "Email not found".
 * 	-> Use orElseGet() to return a default email ("default@example.com").
 * 	-> Use map() to transform the email to uppercase if it exists.
 */
public class Day_42 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.next();

//		1. Wrap the result of getEmailByUsername() in an Optional.
		Optional<String> email = Optional.ofNullable(getEmailByUsername(name));

//		2. Print the email if present, otherwise print "Email not found".
		System.out.println(name + " -> " + email.orElse("Email not found"));

//		3. Use orElseGet() to return a default email ("default@example.com").
		System.out.println("Default email for: " + name + " -> " + email.orElseGet(() -> "default@example.com"));

//		4. Use map() to transform the email to uppercase if it exists.
		System.out.println("Uppercase Email: " + email.map(String::toUpperCase).orElse("Email not found"));

	}

	public static String getEmailByUsername(String username) {

		if ("alice".equalsIgnoreCase(username)) {
			return "alice@example.com";
		} else if ("bob".equalsIgnoreCase(username)) {
			return "bob@example.com";
		}
		return null;
	}

}
