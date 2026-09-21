/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :12:46:45 pm
 * Email : saisushankindroji1476@gmail.com
 */

package collectionsdemo;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListDemo3 {

	public static void main(String[] args) {

		LinkedList<Double> stockPrices = new LinkedList<>();

		stockPrices.add(45.00);
		stockPrices.add(51.00);
		stockPrices.add(62.50);
		stockPrices.add(42.75);
		stockPrices.add(36.80);
		stockPrices.add(68.40);

		System.out.println("Original List: " + stockPrices);

		// Sort ascending
		Collections.sort(stockPrices);
		System.out.println("Sorted List: " + stockPrices);

		// Reverse
		Collections.reverse(stockPrices);
		System.out.println("Reversed List: " + stockPrices);

		// Maximum
		System.out.println("Maximum Stock Price: " + Collections.max(stockPrices));

		// Minimum
		System.out.println("Minimum Stock Price: " + Collections.min(stockPrices));
	}
}