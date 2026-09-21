/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:37:16 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.List;

public class CountElements {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

		long count = list.stream().count();

		System.out.println("Total Elements = " + count);
	}
}
