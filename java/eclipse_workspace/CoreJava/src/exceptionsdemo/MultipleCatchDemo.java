package exceptionsdemo;

/**
 * Author :sushank2
 * Date :09-Jul-2026
 * Time :12:48:32 pm
 * Email : saisushankindroji1476@gmail.com
 */


import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MultipleCatchDemo {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, c;

		try {
			System.out.println("Enter Any 2 Numbers");

			a = Integer.parseInt(br.readLine());
			b = Integer.parseInt(br.readLine());

			System.out.println("Enter your Name : ");
			String name = br.readLine();

			c = a / b;

			System.out.println("C VALUE = " + c);
			System.out.println("Thank You " + name);
		}
		catch (NumberFormatException nfe) {
			System.err.println("Please pass only integer values. " + nfe);
		}
		catch (ArithmeticException ae) {
			System.err.println("Please don't pass the second value as 0. " + ae);
		}
		catch (IOException ioe) {
			System.err.println("Input/Output Error: " + ioe);
		}
		finally {
			try {
				br.close();
			}
			catch (IOException e) {
				System.err.println("Error while closing BufferedReader.");
			}

			System.out.println("Inside Finally Block");
		}

		System.out.println("End of Main Method");
	}
}