/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:38:35 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class StatisticsDemo {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);

		IntSummaryStatistics stats =
				list.stream()
				.mapToInt(Integer::intValue)
				.summaryStatistics();

		System.out.println("Maximum = " + stats.getMax());
		System.out.println("Minimum = " + stats.getMin());
		System.out.println("Sum = " + stats.getSum());
		System.out.println("Average = " + stats.getAverage());
	}
}
