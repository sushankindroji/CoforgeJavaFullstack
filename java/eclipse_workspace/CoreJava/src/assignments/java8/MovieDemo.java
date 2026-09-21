/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:39:52 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.*;
import java.util.stream.Collectors;

class Movie {

	String name;
	String genre;
	double rating;

	Movie(String name, String genre, double rating) {
		this.name = name;
		this.genre = genre;
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public double getRating() {
		return rating;
	}

	@Override
	public String toString() {
		return name + " - " + genre + " - " + rating;
	}
}

public class MovieDemo {

	public static void main(String[] args) {

		List<Movie> movies = Arrays.asList(
				new Movie("RRR", "Action", 4.8),
				new Movie("Avatar", "Sci-Fi", 4.5),
				new Movie("KGF", "Action", 4.2),
				new Movie("Frozen", "Animation", 3.8)
				);

		System.out.println("Movies Above Rating 4");

		movies.stream()
		.filter(m -> m.getRating() > 4)
		.forEach(System.out::println);

		System.out.println("\nSorted By Rating");

		movies.stream()
		.sorted(Comparator.comparing(Movie::getRating))
		.forEach(System.out::println);

		System.out.println("\nGrouped By Genre");

		Map<String, List<Movie>> map =
				movies.stream()
				.collect(Collectors.groupingBy(Movie::getGenre));

		System.out.println(map);

		Movie highest =
				movies.stream()
				.max(Comparator.comparing(Movie::getRating))
				.get();

		System.out.println("\nHighest Rated Movie");
		System.out.println(highest);
	}
}