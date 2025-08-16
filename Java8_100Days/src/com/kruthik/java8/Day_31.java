package com.kruthik.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.kruthik.java8.entities.Movie;

/*
 * Given a List of Movie Objects.
 * 	Group movies by genre.
 * 	For each genre, calculate the average rating.
 * 	Find the highest-rated movie in each genre.
 * 	Sort genres by their average rating (descending) and display results in the format:
 * 		Genre -> Average Rating | Top Movie Title
 */
public class Day_31 {

	public static void main(String[] args) {

		List<Movie> movies = initializer();

		Map<String, Double> avgRatingByGenre = movies.stream()
				.collect(Collectors.groupingBy(Movie::getGenre, Collectors.averagingDouble(Movie::getRating)));

		Map<String, Movie> highestRatedByGenre = movies.stream().collect(Collectors.groupingBy(Movie::getGenre,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Movie::getRating)), Optional::get)));

		avgRatingByGenre.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed())
				.forEach(entity -> {
					String key = entity.getKey();
					Double value = entity.getValue();
					Movie movie = highestRatedByGenre.get(key);
					
					String roundedRating = String.format("%.1f", value);

					System.out.println(key + " -> " + roundedRating + " | " + movie.getTitle());
				});
	}

	public static List<Movie> initializer() {
		return Arrays.asList(new Movie("Inception", "Sci-Fi", 8.8, 2010),
				new Movie("Interstellar", "Sci-Fi", 8.6, 2014), new Movie("The Matrix", "Sci-Fi", 8.7, 1999),
				new Movie("The Dark Knight", "Action", 9.0, 2008), new Movie("Gladiator", "Action", 8.5, 2000),
				new Movie("Mad Max: Fury Road", "Action", 8.1, 2015),
				new Movie("The Shawshank Redemption", "Drama", 9.3, 1994),
				new Movie("Forrest Gump", "Drama", 8.8, 1994), new Movie("Fight Club", "Drama", 8.8, 1999),
				new Movie("The Conjuring", "Horror", 7.5, 2013), new Movie("A Quiet Place", "Horror", 7.6, 2018),
				new Movie("Get Out", "Horror", 7.7, 2017));
	}
}
