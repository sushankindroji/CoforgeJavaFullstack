/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :10:56:07 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class LambdaDemo3 {

	public static void main(String[] args) {

		// Lambda expression to check even number
		NumericTest isEven = (n) -> n % 2 == 0;

		// Lambda expression to check negative number
		NumericTest isNegative = (n) -> n < 0;

		System.out.println("7 is Even Number : " + isEven.computeTest(7));
		System.out.println("-55 is Negative Number : " + isNegative.computeTest(-55));

		// Error:
		// boolean a = (n) -> (n % 2 == 0);
		// Lambda expressions can only be assigned to a Functional Interface.

		// Lambda expression to check prime number
		NumericTest isPrime = (n) -> {
			if (n <= 1) {
				return false;
			}

			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					return false;
				}
			}

			return true;
		};

		System.out.println("7 is Prime Number : " + isPrime.computeTest(7));
		System.out.println("10 is Prime Number : " + isPrime.computeTest(10));
		System.out.println("13 is Prime Number : " + isPrime.computeTest(13));
	}
}
