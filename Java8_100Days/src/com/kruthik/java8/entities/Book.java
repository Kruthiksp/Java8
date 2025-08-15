package com.kruthik.java8.entities;

public class Book {

	private String title;
	private String author;
	// day-30
	String genre;
	double price;
	int year;

	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public Book(String title, String author, String genre, double price, int year) {
		super();
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.price = price;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public double getPrice() {
		return price;
	}

	public int getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", genre=" + genre + ", price=" + price + ", year="
				+ year + "]";
	}

//	@Override
//	public String toString() {
//		return "Book [title=" + title + ", author=" + author + "]";
//	}

}
