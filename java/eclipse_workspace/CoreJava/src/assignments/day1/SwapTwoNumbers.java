/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :8:56:59 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day1;

public class SwapTwoNumbers {

	public static void main(String[] args) {

		int a = 10;
		int b = 20;

		System.out.println("Before Swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		a = a + b;
		b = a - b;
		a = a - b;

		System.out.println("\nAfter Swapping");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
}
