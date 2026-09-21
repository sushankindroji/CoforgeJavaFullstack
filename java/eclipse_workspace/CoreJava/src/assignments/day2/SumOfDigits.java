/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:12:27 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number: ");
		int num = sc.nextInt();

		int sum = 0;

		while (num != 0) {

			sum += num % 10;
			num /= 10;
		}

		System.out.println("Sum of Digits = " + sum);

		sc.close();
	}
}