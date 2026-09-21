/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:37:59 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.List;

public class SortList {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(50, 20, 10, 80, 40, 30);

		list.stream()
		.sorted()
		.forEach(System.out::println);
	}
}
