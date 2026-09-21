/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :10:35:52 am
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

public class LambdaDemo2 {

	public static void main(String[] args) {

		// Reverse String
		Mystring reverseStr = (str) -> {
			String result = "";
			for (int i = str.length() - 1; i >= 0; i--) {
				result += str.charAt(i);
			}
			return result;
		};

		System.out.println(reverseStr.mystringfunction("lalalh agagsbnasgtu"));
		System.out.println(reverseStr.mystringfunction("my string continue"));
		System.out.println(reverseStr.mystringfunction("madam"));

		// Greeting
		Mystring myName = (name) -> "Helloooo " + name;
		System.out.println(myName.mystringfunction("Sunny"));

		// Length of String
		Mystring lenString = (str) ->
		"The length of \"" + str + "\" is: " + str.length();

		System.out.println(lenString.mystringfunction("madam"));
		System.out.println(lenString.mystringfunction("James Gosling"));
		System.out.println(lenString.mystringfunction("Raj"));
	}
}