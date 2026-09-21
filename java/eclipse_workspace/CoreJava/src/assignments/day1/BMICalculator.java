/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:05:19 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day1;

import java.util.Scanner;

public class BMICalculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Weight (kg): ");
		double weight = sc.nextDouble();

		System.out.print("Enter Height (m): ");
		double height = sc.nextDouble();

		double bmi = weight / (height * height);

		System.out.printf("Your BMI is %.2f", bmi);

		sc.close();
	}
}