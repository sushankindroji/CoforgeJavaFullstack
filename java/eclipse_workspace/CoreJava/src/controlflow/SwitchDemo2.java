package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :9:47:49 am
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

public class SwitchDemo2 {
	public static void main(String[] args) {
		float num1, num2, result;
		String operator;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter First Number :");
		num1 = scan.nextInt();

		System.out.println("Enter Second Number :");
		num2 = scan.nextInt();

		System.out.println("Enter Operator (+, -, *, /) :");
		operator = scan.next();

		switch(operator) {
		case "+":
			result = num1 + num2;
			System.out.println("Result : " + result);
			break;

		case "-":
			result = num1 - num2;
			System.out.println("Result : " + result);
			break;

		case "*":
			result = num1 * num2;
			System.out.println("Result : " + result);
			break;
		case "/":
			if (num2 != 0) {
				result = num1 / num2;
				System.out.println("Result : " + result);
			} else {
				System.out.println("Error: Division by zero is not allowed.");
			}
			break;

		default:
			System.out.println("invalid operator, please enter one of +,-,*,/");


		}
	}
}
