/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:39:12 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

interface PerformOperation {
	boolean check(int n);
}

public class LambdaDemo {

	static PerformOperation isOdd() {
		return n -> n % 2 != 0;
	}

	static PerformOperation isPrime() {
		return n -> {
			if (n < 2)
				return false;

			for (int i = 2; i <= Math.sqrt(n); i++) {
				if (n % i == 0)
					return false;
			}
			return true;
		};
	}

	static PerformOperation isPalindrome() {
		return n -> {
			int temp = n;
			int rev = 0;

			while (temp > 0) {
				rev = rev * 10 + temp % 10;
				temp /= 10;
			}

			return rev == n;
		};
	}

	public static void main(String[] args) {

		System.out.println("15 is Odd : " + isOdd().check(15));
		System.out.println("17 is Prime : " + isPrime().check(17));
		System.out.println("121 is Palindrome : " + isPalindrome().check(121));
	}
}
