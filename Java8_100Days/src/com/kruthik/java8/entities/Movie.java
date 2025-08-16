package com.kruthik.java8.entities;

public class Movie {

	private String title;
	private String genre;
	private double rating;
	private int releaseYear;

	public Movie(String title, String genre, double rating, int releaseYear) {
		super();
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public double getRating() {
		return rating;
	}

	public String getTitle() {
		return title;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", genre=" + genre + ", rating=" + rating + ", releaseYear=" + releaseYear
				+ "]";
	}

}
