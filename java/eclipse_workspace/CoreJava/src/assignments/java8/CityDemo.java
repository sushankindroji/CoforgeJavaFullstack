/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:41:21 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.List;

public class CityDemo {

	public static void main(String[] args) {

		List<String> cities =
				Arrays.asList("Hyderabad", "Delhi", "Mumbai", "Chennai");

		System.out.println("Lambda");

		cities.forEach(city -> System.out.println(city));

		System.out.println("\nMethod Reference");

		cities.forEach(System.out::println);

		System.out.println("\nSorted");

		cities.stream()
		.sorted()
		.forEach(System.out::println);

		System.out.println("\nUppercase");

		cities.stream()
		.map(String::toUpperCase)
		.forEach(System.out::println);
	}
}
