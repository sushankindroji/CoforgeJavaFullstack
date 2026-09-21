/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:34:42 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.List;

public class EvenNumbers {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 15, 20, 25, 30, 35, 40);

		list.stream()
		.filter(n -> n % 2 == 0)
		.forEach(System.out::println);
	}
}