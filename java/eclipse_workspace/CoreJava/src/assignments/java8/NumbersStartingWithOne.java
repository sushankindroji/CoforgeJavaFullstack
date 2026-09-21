/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:36:38 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.List;

public class NumbersStartingWithOne {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 15, 110, 220, 135, 41, 1000);

		list.stream()
		.map(String::valueOf)
		.filter(s -> s.startsWith("1"))
		.forEach(System.out::println);
	}
}
