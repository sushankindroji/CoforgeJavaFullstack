/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:13:13 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

public class StarPattern {

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print("* ");
			}

			System.out.println();
		}

		for (int i = 4; i >= 1; i--) {

			for (int j = 1; j <= (2 * i - 1); j++) {
				System.out.print("* ");
			}

			System.out.println();
		}
	}
}
