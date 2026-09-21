/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :12:09:56 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

// Method Reference - Shorthand of Lambda Expression

@FunctionalInterface
interface MyInterface {
	void myMethod(int a);
}

class Test {

	void display(int x) {
		System.out.println("I am an Instance Method : " + x);
	}
}

public class MethodReferencesDemo1 {

	public static void main(String[] args) {

		// Traditional approach
		Test t1 = new Test();
		t1.display(100);

		// Method Reference
		MyInterface m1ref = t1::display;

		// Calling Functional Interface method
		m1ref.myMethod(200);
	}
}