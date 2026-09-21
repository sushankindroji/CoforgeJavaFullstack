/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:09:25 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class TriangleType {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Side1: ");
		int a = sc.nextInt();

		System.out.print("Enter Side2: ");
		int b = sc.nextInt();

		System.out.print("Enter Side3: ");
		int c = sc.nextInt();

		if (a == b && b == c)
			System.out.println("The triangle is Equilateral.");
		else if (a == b || b == c || a == c)
			System.out.println("The triangle is Isosceles.");
		else
			System.out.println("The triangle is Scalene.");

		sc.close();
	}
}
