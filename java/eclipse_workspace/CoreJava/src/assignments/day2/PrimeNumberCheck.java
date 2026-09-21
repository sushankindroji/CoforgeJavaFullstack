/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:11:53 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Number: ");
		int num = sc.nextInt();

		boolean prime = true;

		if (num <= 1)
			prime = false;
		else {

			for (int i = 2; i <= num / 2; i++) {

				if (num % i == 0) {
					prime = false;
					break;
				}
			}
		}

		if (prime)
			System.out.println(num + " is a Prime Number.");
		else
			System.out.println(num + " is Not a Prime Number.");

		sc.close();
	}
}
