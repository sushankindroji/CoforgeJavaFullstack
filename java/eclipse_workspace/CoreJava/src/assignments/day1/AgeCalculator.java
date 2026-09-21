/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:04:23 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day1;

import java.util.Scanner;

public class AgeCalculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Birth Year: ");
		int birthYear = sc.nextInt();

		int age = 2026 - birthYear;

		System.out.println("You are " + age + " years old.");

		sc.close();
	}
}