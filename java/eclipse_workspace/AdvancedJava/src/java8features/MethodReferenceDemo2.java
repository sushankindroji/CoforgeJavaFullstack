/**
 * Author :sushank2
 * Date :14-Jul-2026
 * Time :12:15:23 pm
 * Email : saisushankindroji1476@gmail.com
 */

package java8features;

import java.util.function.BiConsumer;

// Program to demonstrate Method Reference

@FunctionalInterface
interface IDemo {
	void sum(int x, int y);
}

class Calculation {

	void addition(Integer a, Integer b) {
		System.out.println("The Addition is : " + (a + b));
	}
}

public class MethodReferenceDemo2 {

	public static void main(String[] args) {

		Calculation c1 = new Calculation();

		// Lambda Expression
		IDemo d1 = (a, b) ->
		System.out.println("The Addition is : " + (a + b));

		d1.sum(10, 45);

		// Method Reference
		IDemo d2 = c1::addition;

		d2.sum(200, 150);
		d2.sum(700, 350);

		// Built-in Functional Interface
		BiConsumer<Integer, Integer> d3 = c1::addition;

		d3.accept(500, 250);
		d3.accept(800, 450);
	}
}