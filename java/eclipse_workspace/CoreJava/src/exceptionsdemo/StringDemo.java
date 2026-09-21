/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :12:38:10 pm
 * Email : saisushankindroji1476@gmail.com
 */

package exceptionsdemo;

public class StringDemo {

	public static void main(String[] args) {

		String s1 = "Hello World";
		String s2 = null;

		try {

			System.out.println("Length of s1 : " + s1.length());
			System.out.println("Length of s2 : " + s2.length());

		} catch (NullPointerException e) {

			System.out.println("Null Pointer Exception Occurred");
			System.out.println("Message : " + e.getMessage());
			System.out.println("Exception : " + e);

		} finally {

			System.out.println("Program execution completed.");
		}
	}
}