package com.kruthik.java8;

import com.kruthik.java8.entities.User;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * Given a list of User Objects.
 * 	Extract all unique email addresses from the list of users using Streams + flatMap().
 * 	Print them in sorted order.
 */
public class Day_52 {

	public static void main(String[] args) {
		List<User> users = initializer();

		Set<String> res = users.stream().flatMap(user -> user.getEmails().stream()).collect(Collectors.toSet());
		
		System.out.println("List of Uniques Emails:\n------------------------");
		res.stream().sorted().forEach(System.out::println);
	}

	public static List<User> initializer() {
		return Arrays.asList(new User(1, "Alice", Arrays.asList("alice@gmail.com", "alice@yahoo.com")),
				new User(2, "Bob", Arrays.asList("bob@gmail.com", "alice@yahoo.com")),
				new User(3, "Charlie", Arrays.asList("charlie@gmail.com")));

	}
}
