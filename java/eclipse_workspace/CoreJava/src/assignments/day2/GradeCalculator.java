/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:08:08 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Score (0-100): ");
		int score = sc.nextInt();

		if (score >= 90 && score <= 100)
			System.out.println("Your grade is A.");
		else if (score >= 80)
			System.out.println("Your grade is B.");
		else if (score >= 70)
			System.out.println("Your grade is C.");
		else if (score >= 60)
			System.out.println("Your grade is D.");
		else if (score >= 0)
			System.out.println("Your grade is F.");
		else
			System.out.println("Invalid Score.");

		sc.close();
	}
}
