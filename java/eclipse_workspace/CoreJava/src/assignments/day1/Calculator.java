/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:03:24 am
 * Email : saisushankindroji1476@gmail.com
 */
package assignments.day1;

public class Calculator {

	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("Usage: java Calculator <num1> <num2>");
			return;
		}

		double num1 = Double.parseDouble(args[0]);
		double num2 = Double.parseDouble(args[1]);

		System.out.println("Addition = " + (num1 + num2));
		System.out.println("Subtraction = " + (num1 - num2));
		System.out.println("Multiplication = " + (num1 * num2));

		if (num2 != 0)
			System.out.println("Division = " + (num1 / num2));
		else
			System.out.println("Division by zero is not possible.");
	}
}
