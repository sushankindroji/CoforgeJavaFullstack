/**
 * Author :sushank2
 * Date :16-Jul-2026
 * Time :9:42:42 am
 * Email : saisushankindroji1476@gmail.com
 */

package assignments.java8;

@FunctionalInterface
interface StringOperation {
	Object operate(String str);
}

public class StringOperationDemo {

	public static void main(String[] args) {

		String text = "Java";

		StringOperation upper = s -> s.toUpperCase();

		StringOperation lower = s -> s.toLowerCase();

		StringOperation reverse =
				s -> new StringBuilder(s).reverse().toString();

				StringOperation length = s -> s.length();

				System.out.println("Uppercase : " + upper.operate(text));
				System.out.println("Lowercase : " + lower.operate(text));
				System.out.println("Reverse : " + reverse.operate(text));
				System.out.println("Length : " + length.operate(text));
	}
}
