/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :12:05:12 pm
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo4;

import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		// program to perform division of 2 nos without exception handling


		int a, b, result;
		Scanner input = new Scanner(System.in);

		System.out.println("Input two integers");
		a = input.nextInt();
		b = input.nextInt();  // enter 0

		result = a / b;  // JRE Throws Arithmetic exception

		System.out.println("Result = " + result);  
		input.close();


	}

}
