/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :3:11:31 pm
 * Email : saisushankindroji1476@gmail.com
 */

package streamsdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	public static void main(String[] args) {

		List<Integer> grades = new ArrayList<Integer>();

		grades.add(10);
		grades.add(6);
		grades.add(5);
		grades.add(7);
		grades.add(8);
		grades.add(9);

		// Build stream from Collections
		Stream<Integer> stm1 = grades.stream();

		System.out.println("***** ArrayList Contents *****");
		stm1.forEach(System.out::println);

		// Intermediate operation - map()
		// Terminal operation - collect()
		List<Integer> squares = grades.stream()
				.map(n -> n * n)
				.collect(Collectors.toList());

		System.out.println("***** Squares of Grades *****");
		System.out.println(squares);
	}
}
