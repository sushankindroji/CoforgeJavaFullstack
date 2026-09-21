/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:06:28 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day1;

import java.util.Scanner;

public class ITCity {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter City Name: ");
		String city = sc.nextLine();

		city = city.toLowerCase();

		if (city.equals("delhi") ||
				city.equals("mumbai") ||
				city.equals("kolkatta") ||
				city.equals("bangalore") ||
				city.equals("chennai") ||
				city.equals("hyderabad")) {

			System.out.println(city + " is an IT City.");
		} else {
			System.out.println(city + " is Not an IT City.");
		}

		sc.close();
	}
}