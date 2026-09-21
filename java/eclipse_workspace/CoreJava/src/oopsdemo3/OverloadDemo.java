/**
 * Author :sushank2
 * Date :08-Jul-2026
 * Time :10:44:21 am
 * Email : saisushankindroji1476@gmail.com
 */

package oopsdemo3;

public class OverloadDemo {

	public static void main(String[] args) {


		Addition a1 = new Addition();

		//invoking add() overload method
		a1.add();
		a1.add(20,30);
		a1.add(34.75f,542.67f);
		a1.add(300,500,100);
		a1.add("Hello" , "World");
		//a1.add(10);
	}

}
