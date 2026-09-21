package controlflow;

/**
 * Author :sushank2
 * Date :06-Jul-2026
 * Time :9:36:00 am
 * Email : saisushankindroji1476@gmail.com
 */

import java.util.Scanner;

public class SwitchDemo1 {
	public static void main(String[] args) {
		int day;
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter Day Number (1-7):");
		day = scan.nextInt();

		switch (day) {
		case 1:
			System.out.println("Monday");
			break;
		case 2:
			System.out.println("Tuesday");
			break;
		case 3:
			System.out.println("Wednesday");
			break;
		case 4:
			System.out.println("Thursday");
			break;
		case 5:
			System.out.println("Friday");
			break;
		case 6:
			System.out.println("Saturday");
			break;
		case 7:
			System.out.println("Sunday");
			break;
		default:
			System.out.println("Invalid Day Number. Please enter a number between 1 and 7.");
		}
		scan.close();

	}
}
