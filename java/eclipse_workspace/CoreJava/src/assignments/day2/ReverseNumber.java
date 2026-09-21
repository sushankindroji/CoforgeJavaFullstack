/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:11:18 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number: ");
		int num = sc.nextInt();

		int reverse = 0;

		while (num != 0) {

			int digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;
		}

		System.out.println("Reversed Number = " + reverse);

		sc.close();
	}
}
