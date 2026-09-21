/**
 * Author :sushank2
 * Date :10-Jul-2026
 * Time :9:09:57 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.day2;

import java.util.Scanner;

public class PasswordStrength {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter Password: ");
		String password = sc.nextLine();

		boolean upper = false;
		boolean lower = false;
		boolean digit = false;
		boolean special = false;

		for (int i = 0; i < password.length(); i++) {

			char ch = password.charAt(i);

			if (Character.isUpperCase(ch))
				upper = true;
			else if (Character.isLowerCase(ch))
				lower = true;
			else if (Character.isDigit(ch))
				digit = true;
			else
				special = true;
		}

		if (password.length() >= 8 && upper && lower && digit && special)
			System.out.println("Password Strength: Strong");
		else if (password.length() >= 6 && upper && lower && digit)
			System.out.println("Password Strength: Medium");
		else
			System.out.println("Password Strength: Weak");

		sc.close();
	}
}
