package com.kruthik.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day_44 {
	public static void main(String[] args) {

		List<User> users = initializer();

//		1. Get city of User
		System.out.println("--- Get City of Users ---");
		for (User user : users) {
			String city = user.getAddress().map(Address::getCity).orElse("City not available");
			System.out.println(user.getName() + " -> " + city);
		}

//		2. Extract all available cities
		System.out.println("\n--- Extract all available cities ---");
		List<String> cities = users.stream().flatMap(user -> user.getAddress().stream()).map(Address::getCity)
				.filter(Objects::nonNull).collect(Collectors.toList());

		System.out.println("Cities: " + cities);

//		3. Find first city starting with "B"
		System.out.println("\n--- Find first city starting with \"B\" ---");
		String startsWith_B = users.stream().flatMap(user -> user.getAddress().stream()).map(Address::getCity)
				.filter(city -> city.startsWith("B")).findFirst().orElse("No city found");
		System.out.println("First City Starts with B: " + startsWith_B);
	}

	public static List<User> initializer() {
		return Arrays.asList(new User("Alice", Optional.of(new Address("Bangalore"))),
				new User("Bob", Optional.empty()), new User("Charlie", Optional.of(new Address("Chennai"))),
				new User("David", Optional.of(new Address("Mumbai"))), new User("Eva", Optional.empty()));
	}
}

class Address {

	private String city;

	public Address(String city) {
		super();
		this.city = city;
	}

	public String getCity() {
		return city;
	}
}

class User {
	private String name;
	private Optional<Address> address; // user may or may not have an address

	public User(String name, Optional<Address> address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Optional<Address> getAddress() {
		return address;
	}
}